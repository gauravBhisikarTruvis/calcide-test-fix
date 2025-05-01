package com.calcite_new.sql.core.converter;

import com.calcite_new.core.dialect.sql.SqlDialect;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.prepare.Prepare;
import org.apache.calcite.rel.RelCollation;
import org.apache.calcite.rel.RelCollations;
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.rel.core.CorrelationId;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.logical.*;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.rex.*;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.type.SqlTypeUtil;
import org.apache.calcite.sql.util.SqlBasicVisitor;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
import org.apache.calcite.util.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Converts a validated {@link SqlNode} tree into a {@link RelNode} tree
 * without using {@link org.apache.calcite.sql.validate.SqlValidator} or
 * {@link org.apache.calcite.tools.RelBuilder}.
 *
 * <p>This converter assumes the input {@code SqlNode} is already validated.
 * It relies on {@link Prepare.CatalogReader} to resolve schema objects and obtain
 * type information. Type inference for expressions is performed locally or
 * using {@link RexBuilder}. Relational nodes (like {@link LogicalFilter},
 * {@link LogicalProject}) are constructed directly.
 * </p>
 *
 * <p><b>Note:</b> Avoiding {@code SqlValidator} and {@code RelBuilder}
 * significantly increases complexity, especially regarding type inference,
 * scope resolution, RexInputRef index management, and handling complex SQL features.
 * This implementation makes simplifying assumptions and requires careful manual
 * construction of RelNode properties (like row types and expression references).
 * </p>
 */
public class SqlToRelConverter {

  protected final RelOptCluster cluster;
  protected final EntityCatalogReader catalogReader;
  private final List<String> defaultQualifiers;
  private final SqlDialect dialect;

  protected final RexBuilder rexBuilder;
  protected final RelDataTypeFactory typeFactory;
  protected final RelTraitSet defaultTraits;

  // Context for CTEs (Common Table Expressions)
  // Needs careful handling for nested WITH clauses. A stack might be better.
  private final Map<String, RelNode> cteMap = new HashMap<>();

  /**
   * Creates a SqlToRelConverter.
   *
   * @param cluster       Relational expression cluster
   * @param catalogReader Schema provider
   */
  public SqlToRelConverter(
      RelOptCluster cluster,
      EntityCatalogReader catalogReader,
      List<String> defaultQualifiers,
      SqlDialect dialect) {
    this.cluster = Objects.requireNonNull(cluster, "cluster");
    this.catalogReader = Objects.requireNonNull(catalogReader, "catalogReader");
    this.rexBuilder = cluster.getRexBuilder();
    this.typeFactory = cluster.getTypeFactory();
    this.defaultQualifiers = defaultQualifiers != null
        ? defaultQualifiers
        : ImmutableList.of(); // Default qualifiers for table names
    this.dialect = dialect;
    // Default traits for logical nodes (can be customized)
    this.defaultTraits = cluster.traitSet().replace(Convention.NONE);
  }

  /**
   * Converts the main query {@link SqlNode} to a {@link RelNode}.
   *
   * @param sqlNode The root node of the validated SQL query.
   * @return The equivalent {@link RelNode} tree.
   */
  public RelNode convert(SqlNode sqlNode) {
    try {
      // Initial scope is empty
      Scope initialScope = Scope.createRoot();
      RelNode result = convertQueryRecursive(sqlNode, true, initialScope);
      return result;
    } finally {
      // Clean up CTE context if needed (though typically done per-query)
      cteMap.clear();
    }
  }

  /**
   * Recursively converts a {@link SqlNode} query node (SELECT, UNION, etc.)
   *
   * @param sqlNode    The query node.
   * @param isTopLevel True if this is the outermost query being converted.
   * @param scope      The scope available for resolving identifiers in this query.
   * @return The equivalent {@link RelNode}.
   */
  protected RelNode convertQueryRecursive(SqlNode sqlNode, boolean isTopLevel, Scope scope) {
    SqlKind kind = sqlNode.getKind();
    switch (kind) {
      case SELECT:
        return convertSelect((SqlSelect) sqlNode, scope);
      case ORDER_BY:
        return convertOrderBy((SqlOrderBy) sqlNode, scope);
      case UNION:
      case INTERSECT:
      case EXCEPT:
        return convertSetOp((SqlCall) sqlNode, scope);
      case VALUES:
        // Values clause doesn't depend on outer scope typically
        return convertValues((SqlCall) sqlNode);
      case WITH:
        return convertWith((SqlWith) sqlNode, scope);
      // Add cases for other query types like INSERT source, EXPLAIN, etc. if needed
      default:
        throw new UnsupportedOperationException("Unsupported query node type: " + kind);
    }
  }

  /**
   * Converts a WITH clause by registering CTEs and converting the body.
   */
  protected RelNode convertWith(SqlWith sqlWith, Scope parentScope) {
    // Handle CTEs. This implementation assumes non-recursive CTEs for simplicity.
    // Recursive CTEs require LogicalRecursion which is complex to set up manually.

    // Create a new scope for CTE definitions, inheriting from the parent
    Scope withScope = Scope.createWithScope(parentScope);

    // Convert and register each CTE definition
    for (SqlNode cteNode : sqlWith.withList) {
      SqlWithItem cte = (SqlWithItem) cteNode;
      String alias = cte.name.getSimple();
      if (withScope.isCteDefined(alias)) {
        throw new IllegalArgumentException("Duplicate CTE name: " + alias);
      }
      // Convert CTE body recursively. It can reference CTEs defined earlier *in this WITH*.
      // Pass the current 'withScope' so it can find previously defined CTEs.
      RelNode cteRel = convertQueryRecursive(cte.query, false, withScope);
      withScope.addCte(alias, cteRel); // Register in the current scope
    }

    // Convert the main query body using the scope that now includes all CTE definitions.
    return convertQueryRecursive(sqlWith.body, true, withScope); // Body is top-level relative to WITH
  }


  /**
   * Converts a SELECT statement.
   */
  protected RelNode convertSelect(SqlSelect select, Scope parentScope) {
    // 1. FROM clause - Establishes the initial input scope for this SELECT
    RelNode fromRel = convertFrom(select.getFrom(), parentScope);
    Scope currentScope = Scope.createSelectScope(parentScope, fromRel);

    RelNode currentRel = fromRel;

    // 2. WHERE clause - Filter
    if (select.getWhere() != null) {
      RexNode whereCondition = convertExpression(select.getWhere(), currentScope);
      currentRel = LogicalFilter.create(currentRel, whereCondition);
      // Update scope if needed, though Filter doesn't change row type structure
      currentScope = Scope.createSelectScope(parentScope, currentRel);
    }

    // 3. GROUP BY / Aggregation / HAVING
    boolean isAggregate = AggregateChecker.isAggregate(select); // Checks for GROUP BY or aggregate functions
    RelNode aggregateInput = currentRel; // Input to potential aggregation
    Scope aggregateInputScope = currentScope;

    if (isAggregate) {
      Pair<RelNode, Scope> aggResult = convertAggregate(select, aggregateInput, aggregateInputScope);
      currentRel = aggResult.left;
      currentScope = aggResult.right; // Scope now reflects Aggregate output
    } else if (select.getHaving() != null) {
      throw new IllegalArgumentException("HAVING clause found without GROUP BY or aggregate functions");
    }

    // 4. SELECT list - Projection
    // This needs to happen *after* aggregation but *before* ORDER BY
    Pair<RelNode, Scope> projectResult = convertProject(select.getSelectList(), currentRel, currentScope);
    currentRel = projectResult.left;
    currentScope = projectResult.right; // Scope reflects final projection

    // Window functions (OVER clauses) would typically be handled here,
    // operating on the result of projection/aggregation. Requires LogicalWindow.
    // Manual creation of LogicalWindow is very complex.

    // Note: ORDER BY, LIMIT/OFFSET are handled by convertOrderBy if present

    return currentRel;
  }

  /**
   * Converts the FROM clause of a SELECT statement.
   */
  protected RelNode convertFrom(@Nullable SqlNode fromNode, Scope parentScope) {
    if (fromNode == null) {
      // No FROM clause (e.g., SELECT 1) - Use Calcite's convention: LogicalValues with zero rows/cols?
      // Or more commonly, a single row, single dummy column. Let's use the latter.
      // RexLiteral zero = rexBuilder.makeExactLiteral(BigDecimal.ZERO);
      // RelDataType type = typeFactory.createStructType(
      //     ImmutableList.of(typeFactory.createSqlType(SqlTypeName.INTEGER)),
      //     ImmutableList.of("ZERO"));
      // return LogicalValues.createOneRow(cluster); // Calcite helper for SELECT 1

      // Let's create a standard one-row, zero-column Values for compatibility
      return LogicalValues.createOneRow(cluster);
    }

    SqlKind kind = fromNode.getKind();
    switch (kind) {
      case IDENTIFIER: {
        SqlIdentifier id = (SqlIdentifier) fromNode;
        // Check if it's a CTE reference first
        RelNode cteRel = parentScope.findCte(id.names.get(id.names.size() - 1));
        if (cteRel != null) {
          // Found CTE, use its RelNode. Need to handle alias if specified via AS.
          // If no AS, the CTE name itself acts as the alias.
          return cteRel; // Alias handling might need adjustment based on how Scope manages CTEs
        }

        // Assume it's a table
        RelOptTable table = catalogReader.getTable(id.names);
        if (table == null) {
          throw new RuntimeException("Table or CTE not found: " + id.names);
        }
        // Create a scan. Traits can be customized.
        return LogicalTableScan.create(cluster, table, ImmutableList.of()); // Empty hints
      }
      case JOIN:
        return convertJoin((SqlJoin) fromNode, parentScope);

      case AS: {
        SqlCall asCall = (SqlCall) fromNode;
        SqlNode operand = asCall.getOperandList().get(0);
        SqlIdentifier aliasId = (SqlIdentifier) asCall.getOperandList().get(1);
        String alias = aliasId.getSimple();

        // Convert the underlying operand
        RelNode underlyingRel = convertFrom(operand, parentScope);

        // The 'AS' itself doesn't create a new RelNode, but the alias is crucial
        // for scope resolution. We need to associate the alias with the underlyingRel
        // in the scope created *after* convertFrom returns.
        // We can return the underlyingRel directly, and the caller (convertSelect)
        // will use the alias when creating the Scope.
        // Alternatively, wrap in a Project to enforce the alias? No, alias is metadata here.
        return underlyingRel; // Alias handled by caller's scope creation
      }
      case SELECT: // Subquery in FROM
      case UNION:
      case INTERSECT:
      case EXCEPT:
      case WITH:
      case ORDER_BY: { // Subquery with ORDER BY (usually requires alias)
        // Convert the subquery recursively. Subqueries execute in their own scope,
        // potentially inheriting correlation variables from parentScope.
        // Pass parentScope for potential correlation.
        return convertQueryRecursive(fromNode, false, parentScope);
      }
      case VALUES:
        return convertValues((SqlCall) fromNode); // Values don't depend on outer scope

      default:
        throw new UnsupportedOperationException("Unsupported FROM clause node type: " + kind);
    }
  }

  /**
   * Converts a JOIN clause.
   */
  protected RelNode convertJoin(SqlJoin join, Scope parentScope) {
    RelNode left = convertFrom(join.getLeft(), parentScope);
    RelNode right = convertFrom(join.getRight(), parentScope);

    JoinRelType joinType = convertJoinType(join.getJoinType());

    // The scope for the join condition includes both left and right inputs.
    Scope joinScope = Scope.createJoinScope(parentScope, left, right);

    RexNode condition;
    Set<CorrelationId> correlationIds = ImmutableSet.of(); // TODO: Handle correlations if needed

    if (join.getCondition() == null) {
      if (join.isNatural()) {
        condition = convertNaturalJoinCondition(left.getRowType(), right.getRowType());
      } else if (join.getConditionType() == JoinConditionType.USING) {
//                condition = convertUsingJoinCondition(join.getUsingList(), left.getRowType(), right.getRowType());
        throw new UnsupportedOperationException("USING not implemented yet");
      } else {
        // No condition (cross join or error)
        if (joinType == JoinRelType.INNER) { // Standard CROSS JOIN
          condition = rexBuilder.makeLiteral(true);
        } else {
          throw new IllegalArgumentException("Outer join requires ON, USING, or NATURAL");
        }
      }
    } else { // ON condition
      if (join.getConditionType() != JoinConditionType.ON) {
        throw new IllegalArgumentException("Unexpected condition type for ON join: " + join.getConditionType());
      }
      // Convert the ON condition using the combined scope
      condition = convertExpression(join.getCondition(), joinScope);
    }

    // Create the LogicalJoin node
    return LogicalJoin.create(left, right, ImmutableList.of() /* hints */, condition, correlationIds, joinType);
  }

  /**
   * Converts SqlJoinOperator.JoinType to JoinRelType.
   */
  protected JoinRelType convertJoinType(JoinType joinType) {
    switch (joinType) {
      case INNER:
        return JoinRelType.INNER;
      case LEFT:
        return JoinRelType.LEFT;
      case RIGHT:
        return JoinRelType.RIGHT;
      case FULL:
        return JoinRelType.FULL;
      case CROSS:
        return JoinRelType.INNER; // Use INNER with TRUE condition
      case COMMA:
        return JoinRelType.INNER; // Typically equivalent to CROSS or INNER
      default:
        throw new UnsupportedOperationException("Unsupported join type: " + joinType);
    }
  }

  /**
   * Generates join condition for NATURAL JOIN.
   */
  protected RexNode convertNaturalJoinCondition(RelDataType leftType, RelDataType rightType) {
    List<String> leftNames = leftType.getFieldNames();
    List<String> rightNames = rightType.getFieldNames();
    List<RexNode> conditions = new ArrayList<>();
    int leftFieldCount = leftType.getFieldCount();

    for (RelDataTypeField leftField : leftType.getFieldList()) {
      // Case-insensitive match? Calcite usually handles this via validator config. Assume insensitive.
      RelDataTypeField rightField = rightType.getField(leftField.getName(), false, false);
      if (rightField != null) {
        // Check type compatibility? Assumed validated.
        RexNode leftRef = rexBuilder.makeInputRef(leftField.getType(), leftField.getIndex());
        RexNode rightRef = rexBuilder.makeInputRef(rightField.getType(), leftFieldCount + rightField.getIndex());
        conditions.add(rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, leftRef, rightRef));
      }
    }
    if (conditions.isEmpty()) {
      // Standard SQL behavior for NATURAL JOIN with no common columns is CROSS JOIN.
      return rexBuilder.makeLiteral(true);
    }
    return RexUtil.composeConjunction(rexBuilder, conditions);
  }

  /**
   * Generates join condition for JOIN USING.
   */
  protected RexNode convertUsingJoinCondition(SqlNodeList usingList, RelDataType leftType, RelDataType rightType) {
    List<RexNode> conditions = new ArrayList<>();
    int leftFieldCount = leftType.getFieldCount();

    for (SqlNode node : usingList) {
      SqlIdentifier id = (SqlIdentifier) node;
      String name = id.getSimple(); // USING columns are unqualified

      RelDataTypeField leftField = leftType.getField(name, false, false);
      RelDataTypeField rightField = rightType.getField(name, false, false);

      if (leftField == null || rightField == null) {
        throw new RuntimeException("Column '" + name + "' specified in USING clause not found in both tables or is ambiguous");
      }
      // Check type compatibility? Assumed validated.

      RexNode leftRef = rexBuilder.makeInputRef(leftField.getType(), leftField.getIndex());
      RexNode rightRef = rexBuilder.makeInputRef(rightField.getType(), leftFieldCount + rightField.getIndex());
      conditions.add(rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, leftRef, rightRef));
    }
    return RexUtil.composeConjunction(rexBuilder, conditions);
  }

  /**
   * Converts GROUP BY, aggregate functions, and HAVING.
   */
  protected Pair<RelNode, Scope> convertAggregate(SqlSelect select, RelNode input, Scope inputScope) {

    // 1. Find GROUP BY expressions & Build GroupSet
    ImmutableBitSet groupSet;
    List<RexNode> groupExprs = new ArrayList<>(); // Expressions corresponding to groupSet bits
    Map<Integer, RexNode> groupExprMap = new HashMap<>(); // Map group index -> RexNode

    if (select.getGroup() != null) {
      ImmutableBitSet.Builder groupSetBuilder = ImmutableBitSet.builder();
      for (SqlNode groupNode : select.getGroup().getList()) {
        RexNode groupRex = convertExpression(groupNode, inputScope);
        groupExprs.add(groupRex);
        // Try to find if this expression matches an input field index
        int inputIndex = findRexInputIndex(groupRex, input);
        if (inputIndex != -1) {
          groupSetBuilder.set(inputIndex);
          groupExprMap.put(inputIndex, groupRex);
        } else {
          // Grouping by a complex expression requires Project beforehand or handling in Aggregate.
          // Standard Aggregate requires groupSet to refer to input fields.
          // We might need to project the expression first.
          throw new UnsupportedOperationException("Grouping by complex expression '" + groupNode + "' requires pre-projection (not implemented here).");
        }
      }
      groupSet = groupSetBuilder.build();
    } else {
      // Global aggregation (no GROUP BY clause)
      groupSet = ImmutableBitSet.of();
    }

    // 2. Find Aggregate Calls (in SELECT list and HAVING clause)
    AggregateFinder aggFinder = new AggregateFinder();
    select.accept(aggFinder); // Visit SELECT, HAVING
    List<AggregateCallInfo> aggregateCallInfos = aggFinder.getAggCalls();

    // 3. Create AggregateCall instances for LogicalAggregate
    List<AggregateCall> aggCalls = new ArrayList<>();
    Map<AggregateCallInfo, Integer> aggCallOutputIndexMap = new HashMap<>(); // Map info -> index in aggCalls list

    for (AggregateCallInfo info : aggregateCallInfos) {
      List<Integer> argList = new ArrayList<>();
      List<RexNode> operands = new ArrayList<>();
      for (SqlNode operand : info.sqlOperands) {
        RexNode operandRex = convertExpression(operand, inputScope);
        // AggregateCall arguments must be input refs. Project if necessary.
        int inputIndex = findRexInputIndex(operandRex, input);
        operands.add(operandRex);
        if (inputIndex == -1) {
          // Aggregate argument is a complex expression. Requires pre-projection.
          throw new UnsupportedOperationException("Aggregate function '" + info.sqlAggFunction.getName()
              + "' argument '" + operand + "' requires pre-projection (not implemented here).");
        }
        argList.add(inputIndex);
      }

      SqlAggFunction calciteAgg = mapSqlAggregation(info.sqlAggFunction);
      if (calciteAgg == null) {
        throw new UnsupportedOperationException("Unsupported aggregate function: " + info.sqlAggFunction.getName());
      }

      int filterArg = getFilterArg(input, inputScope, info);
      boolean nullable = operands.stream().anyMatch(o -> o.getType().isNullable());
      RelDataType type = typeFactory//.createSqlType(SqlTypeName.ANY);
          .createTypeWithNullability(
              rexBuilder.deriveReturnType(calciteAgg, operands),
              nullable);
      String name = info.alias != null ? info.alias : generateAggAlias(info.sqlAggFunction, aggCalls.size());

      AggregateCall aggCall = AggregateCall.create(
          calciteAgg,
          info.isDistinct,
          false, // approximate
          false,
          operands,
          argList,
          filterArg,
          null,
          RelCollations.EMPTY,
          type,
          name);

      aggCallOutputIndexMap.put(info, aggCalls.size());
      aggCalls.add(aggCall);
    }

    // 4. Create the LogicalAggregate node
    // The output row type includes group keys first, then aggregate calls.
    RelNode aggregate = LogicalAggregate.create(input, groupSet, null, aggCalls); // null for groupSets (GROUPING SETS not handled)

    // 5. HAVING clause - Filter *after* aggregation
    RelNode resultRel = aggregate;
    if (select.getHaving() != null) {
      // Convert HAVING expression, replacing aggregates/group keys with references
      // to the output of the Aggregate node.
      Scope havingScope = Scope.createAggregateOutputScope(inputScope, aggregate, groupSet, groupExprMap, aggCalls, aggCallOutputIndexMap);
      RexNode havingCondition = convertExpression(select.getHaving(), havingScope);
      resultRel = LogicalFilter.create(aggregate, havingCondition);
    }

    // Final scope reflects the output of Aggregate (or Filter if HAVING exists)
    Scope finalScope = Scope.createAggregateOutputScope(inputScope, resultRel, groupSet, groupExprMap, aggCalls, aggCallOutputIndexMap);
    return Pair.of(resultRel, finalScope);
  }

  private int getFilterArg(RelNode input, Scope inputScope, AggregateCallInfo info) {
    int filterArg = -1; // TODO: Implement FILTER (WHERE ...) support for aggregates

    if (info.filter != null) {
      // Convert the filter expression to a RexNode
      RexNode filterRex = convertExpression(info.filter, inputScope);

      // Filter must be a boolean expression
      if (!SqlTypeUtil.isBoolean(filterRex.getType())) {
        throw new IllegalArgumentException("FILTER expression must be boolean, found: " +
            filterRex.getType().getSqlTypeName());
      }

      // The filter must be an input reference or a simple expression
      int inputIndex = findRexInputIndex(filterRex, input);
      if (inputIndex != -1) {
        // Simple case: filter is a direct column reference
        filterArg = inputIndex;
      } else {
        // Complex filter requires pre-projection
        throw new UnsupportedOperationException("Complex filter expressions in FILTER clause " +
            "require pre-projection (not implemented here).");
      }
    }
    return filterArg;
  }

  /**
   * Converts the SELECT list (projection).
   */
  protected Pair<RelNode, Scope> convertProject(SqlNodeList selectList, RelNode input, Scope inputScope) {
    List<RexNode> projects = new ArrayList<>();
    List<String> aliases = new ArrayList<>();
    RelDataType inputRowType = input.getRowType();
    AtomicInteger aliasCounter = new AtomicInteger(0);

    for (SqlNode node : selectList.getList()) {
      assert node != null;
      if (node.getKind() == SqlKind.IDENTIFIER && ((SqlIdentifier) node).isStar()) {
        // Expand SELECT *
        if (((SqlIdentifier) node).names.size() > 1) {
          // Expand SELECT table.*
          SqlIdentifier id = (SqlIdentifier) node;
          String qualifier = id.names.get(0);
          Scope.InputRelation sourceRelation = inputScope.findRelation(qualifier);
          if (sourceRelation == null) {
            throw new RuntimeException("Unknown table alias in SELECT list: " + qualifier);
          }
          RelDataType sourceRowType = sourceRelation.relNode.getRowType();
          for (int i = 0; i < sourceRowType.getFieldCount(); i++) {
            RelDataTypeField field = sourceRowType.getFieldList().get(i);
            // Create RexInputRef relative to the *combined* input node
            projects.add(rexBuilder.makeInputRef(field.getType(), sourceRelation.offset + i));
            aliases.add(field.getName()); // Use original field name
          }
        } else {
          // Expand SELECT * (all columns from input)
          for (int i = 0; i < inputRowType.getFieldCount(); i++) {
            RelDataTypeField field = inputRowType.getFieldList().get(i);
            projects.add(rexBuilder.makeInputRef(field.getType(), i));
            aliases.add(field.getName());
          }
        }
      } else {
        // Convert regular expression
        RexNode projExpr = convertExpression(node, inputScope);
        projects.add(projExpr);
        // Use explicit alias (AS) or derive one
        aliases.add(SqlValidatorUtil.getAlias(node, aliasCounter.getAndIncrement())); // Using helper, replace if needed
      }
    }

    // Create the projection node
//      create RelDataType using aliases and projects
    RelDataType outputRowType = typeFactory.createStructType(
        projects.stream().map(RexNode::getType).collect(Collectors.toList()),
        aliases);
    RelNode project = LogicalProject.create(input, List.of(), projects, outputRowType, Set.of());

    // Create the scope reflecting the projection output
    Scope projectScope = Scope.createProjectScope(inputScope, project, aliases);
    return Pair.of(project, projectScope);
  }


  /**
   * Converts an ORDER BY clause (including LIMIT/OFFSET).
   */
  protected RelNode convertOrderBy(SqlOrderBy orderBy, Scope parentScope) {
    // Convert the underlying query first. It executes in its own scope.
    RelNode input = convertQueryRecursive(orderBy.query, false, parentScope);
    Scope inputScope = Scope.createFromRelNode(parentScope, input); // Scope reflects the input to ORDER BY

    List<RelFieldCollation> collations = new ArrayList<>();

    for (SqlNode orderNode : orderBy.orderList.getList()) {
      RelFieldCollation.Direction direction = RelFieldCollation.Direction.ASCENDING;
      RelFieldCollation.NullDirection nullDirection = RelFieldCollation.NullDirection.UNSPECIFIED; // Default based on direction

      SqlNode exprNode = orderNode;
      // Handle DESC
      if (orderNode.getKind() == SqlKind.DESCENDING) {
        exprNode = ((SqlCall) orderNode).getOperandList().get(0);
        direction = RelFieldCollation.Direction.DESCENDING;
      }
      // Handle NULLS FIRST/LAST explicitly
      if (exprNode.getKind() == SqlKind.NULLS_FIRST) {
        exprNode = ((SqlCall) exprNode).getOperandList().get(0);
        nullDirection = RelFieldCollation.NullDirection.FIRST;
      } else if (exprNode.getKind() == SqlKind.NULLS_LAST) {
        exprNode = ((SqlCall) exprNode).getOperandList().get(0);
        nullDirection = RelFieldCollation.NullDirection.LAST;
      }

      // Set default null direction if unspecified
      if (nullDirection == RelFieldCollation.NullDirection.UNSPECIFIED) {
        nullDirection = (direction == RelFieldCollation.Direction.DESCENDING)
            ? RelFieldCollation.NullDirection.FIRST // Standard SQL default for DESC
            : RelFieldCollation.NullDirection.LAST;  // Standard SQL default for ASC
      }

      // Convert the expression - it refers to the output of the underlying query (input)
      RexNode orderRex = convertExpression(exprNode, inputScope);

      // Find the index of this expression in the input RelNode's output fields
      int fieldIndex = findRexInputIndex(orderRex, input);
      if (fieldIndex != -1) {
        collations.add(new RelFieldCollation(fieldIndex, direction, nullDirection));
      } else {
        // If the expression is not a simple output field, it should have been projected.
        // Calcite's SqlToRelConverter often adds complex ORDER BY expressions to the
        // underlying projection if they aren't already present. Doing this manually
        // here is complex. Assume ORDER BY refers to output columns/expressions.
        // Try matching by structure/digest if simple index lookup fails?
        throw new UnsupportedOperationException("ORDER BY expression '" + exprNode
            + "' could not be resolved to a simple output column index of the query. Pre-projection might be required.");
      }
    }

    RexNode offset = null;
    RexNode fetch = null;

    if (orderBy.offset != null) {
      // Offset expression is evaluated *before* sorting conceptually, but uses outer scope?
      // Let's assume it's constant for simplicity, converted without input scope.
      offset = convertExpression(orderBy.offset, Scope.createRoot()); // Evaluate in empty scope
      if (!RexUtil.isLiteral(offset, true) || !SqlTypeUtil.isIntType(offset.getType())) {
        throw new IllegalArgumentException("OFFSET requires an integer literal");
      }
    }
    if (orderBy.fetch != null) {
      fetch = convertExpression(orderBy.fetch, Scope.createRoot()); // Evaluate in empty scope
      if (!RexUtil.isLiteral(fetch, true) || !SqlTypeUtil.isNumeric(fetch.getType())) {
        throw new IllegalArgumentException("FETCH/LIMIT requires an integer literal");
      }
    }

    // Create LogicalSort
    if (!collations.isEmpty() || offset != null || fetch != null) {
      RelCollation relCollation = RelCollations.of(collations);
      return LogicalSort.create(input, relCollation, offset, fetch);
    } else {
      // No sorting, limit, or offset - return input directly
      return input;
    }
  }

  /**
   * Converts set operations (UNION, INTERSECT, EXCEPT).
   */
  protected RelNode convertSetOp(SqlCall setOp, Scope parentScope) {
    // Convert inputs recursively. They operate in their own scopes but share the parent scope.
    RelNode left = convertQueryRecursive(setOp.getOperandList().get(0), false, parentScope);
    RelNode right = convertQueryRecursive(setOp.getOperandList().get(1), false, parentScope);

    boolean all = false;//setOp.getModifierNode(SqlSelectKeyword.ALL) != null;
    List<RelNode> inputs = ImmutableList.of(left, right);

    SqlKind kind = setOp.getKind();
    switch (kind) {
      case UNION:
        return LogicalUnion.create(inputs, all);
      case INTERSECT:
        return LogicalIntersect.create(inputs, all);
      case EXCEPT:
        return LogicalMinus.create(inputs, all);
      default:
        throw new AssertionError("Unexpected set operator: " + kind);
    }
  }

  /**
   * Converts a VALUES clause.
   */
  protected RelNode convertValues(SqlCall valuesCall) {
    assert valuesCall.getOperator().equals(SqlStdOperatorTable.VALUES);

    List<ImmutableList<RexLiteral>> tuples = new ArrayList<>();
    RelDataType rowType = null;
    List<String> fieldNames = null;

    if (valuesCall.getOperandList().isEmpty()) {
      // No rows provided, e.g., INSERT INTO T SELECT * FROM (VALUES)
      // We need a schema. This is impossible to determine without context.
      // Calcite's validator usually infers this from the target table/context.
      throw new IllegalArgumentException("Cannot determine row type for empty VALUES clause without external context.");
    }

    for (int i = 0; i < valuesCall.getOperandList().size(); i++) {
      SqlNode rowConstructor = valuesCall.getOperandList().get(i);
      if (!(rowConstructor instanceof SqlCall) || !((SqlCall) rowConstructor).getOperator().equals(SqlStdOperatorTable.ROW)) {
        throw new IllegalArgumentException("VALUES operands must be ROW constructors");
      }
      SqlCall rowCall = (SqlCall) rowConstructor;
      ImmutableList.Builder<RexLiteral> tupleBuilder = ImmutableList.builder();
      List<RelDataType> types = new ArrayList<>();
      List<String> currentFieldNames = new ArrayList<>();

      for (int j = 0; j < rowCall.getOperandList().size(); j++) {
        SqlNode operand = rowCall.getOperandList().get(j);
        // Use a null/empty scope as literals don't depend on input
        RexNode rex = convertExpression(operand, Scope.createRoot());

        if (!(rex instanceof RexLiteral)) {
          // Allow DEFAULT? Requires context. Allow simple expressions?
          throw new UnsupportedOperationException("VALUES clause currently only supports literals. Found: " + rex.getKind());
        }
        tupleBuilder.add((RexLiteral) rex);

        // Infer row type and field names from the first row
        if (i == 0) {
          types.add(rex.getType());
          // Try to get alias, default to COL$j
          String name = SqlValidatorUtil.getAlias(operand, -1); // -1 means don't generate default like EXPR$
          currentFieldNames.add(name != null ? name : "COL$" + j);
        }
      }

      if (i == 0) {
        // Use least restrictive type if multiple rows have different numeric types?
        // Assumed validation handled type coercion and determined the final type.
        // We use the types from the first row directly.
        rowType = typeFactory.createStructType(types, currentFieldNames);
        fieldNames = currentFieldNames; // Store for potential use
      } else {
        // TODO: Verify subsequent rows match the inferred type? Assumed validated.
      }
      tuples.add(tupleBuilder.build());
    }

    if (rowType == null) {
      // Should not happen if operand list was not empty
      throw new IllegalStateException("Could not determine row type for VALUES clause");
    }

    return LogicalValues.create(cluster, rowType, ImmutableList.copyOf(tuples));
  }


  // =====================================================================
  // Expression Conversion (SqlNode -> RexNode)
  // =====================================================================

  /**
   * Converts a {@link SqlNode} expression into a {@link RexNode} within a given scope.
   *
   * @param node  The SqlNode expression to convert.
   * @param scope The scope providing context for identifier resolution.
   * @return The equivalent RexNode.
   */
  protected RexNode convertExpression(SqlNode node, Scope scope) {
    // First, check if the node is an AS call. If so, we convert the underlying expression.
    // The alias itself is *not* part of the RexNode representation of the expression's value;
    // it's metadata used, for example, during projection list construction (see convertProject).
    if (node.getKind() == SqlKind.AS) {
      SqlCall asCall = (SqlCall) node;
      // Standard AS has two operands: expression and alias identifier
      if (asCall.getOperandList().size() != 2 || !(asCall.getOperandList().get(1) instanceof SqlIdentifier)) {
        // This should typically be caught by prior validation if it were used.
        // Since validation is skipped, add a basic check.
        throw new IllegalArgumentException("Invalid AS operator usage. Expected 'expression AS identifier'. Node: " + node);
      }
      SqlNode expressionToConvert = asCall.getOperandList().get(0);
      // Recursively call convertExpression on the *actual* expression node, ignoring the alias part.
      // The scope remains the same.
      return convertExpression(expressionToConvert, scope);
    }

    SqlKind kind = node.getKind();
    switch (kind) {
      case LITERAL:
        return convertLiteral((SqlLiteral) node);
      case IDENTIFIER:
        return convertIdentifier((SqlIdentifier) node, scope);
      case CASE:
        return convertCase((SqlCall) node, scope);
      case ROW:
        return convertRow((SqlCall) node, scope);
      case LITERAL_CHAIN: // e.g., 'abc' 'def'
        throw new UnsupportedOperationException("LITERAL_CHAIN not supported yet");
//                return convertLiteralChain((SqlLiteralChain) node, scope);
      case OVER: // Window function call
        return convertOver((SqlCall) node, scope);

      // Add other expression kinds: CAST, functions, operators...
      case OTHER_FUNCTION:
      case PLUS:
      case MINUS:
      case TIMES:
      case DIVIDE:
      case MOD:
      case EQUALS:
      case NOT_EQUALS:
      case LESS_THAN:
      case GREATER_THAN:
      case LESS_THAN_OR_EQUAL:
      case GREATER_THAN_OR_EQUAL:
      case AND:
      case OR:
      case NOT:
      case IS_NULL:
      case IS_NOT_NULL:
      case IS_TRUE:
      case IS_NOT_TRUE:
      case IS_FALSE:
      case IS_NOT_FALSE:
      case PLUS_PREFIX:
      case MINUS_PREFIX:
      case EXISTS:
      case SCALAR_QUERY:
      case IN:
      case NOT_IN:
      case LIKE:
      case SIMILAR:
      case BETWEEN:
//            case NOT_BETWEEN:
      case CAST:
        // ... other operators
        return convertCall((SqlCall) node, scope);
      default:
        // Check for aggregate functions - should only be converted directly
        // in specific contexts (e.g., post-aggregation).
        if (node instanceof SqlCall && ((SqlCall) node).getOperator() instanceof SqlAggFunction) {
          // This might be called from convertAggregate or convertPostAggregationExpression
          // Need context to know if it's valid here.
          // If called from general convertExpression, it's likely an error.
          if (!scope.isAggregateContext()) {
            throw new IllegalStateException("Aggregate function " + ((SqlCall) node).getOperator().getName()
                + " encountered outside of aggregation context.");
          }
          // If in aggregate context, delegate to a specific handler if needed,
          // otherwise it might be an aggregate call being replaced by an InputRef.
          return convertAggregateCallExpr((SqlCall) node, scope);
        }
        throw new UnsupportedOperationException("Unsupported expression node type: " + kind + " (" + node.getClass().getSimpleName() + ")");
    }
  }

  /**
   * Converts a literal SqlNode to RexLiteral.
   */
  protected RexLiteral convertLiteral(SqlLiteral literal) {
    SqlTypeName typeName = literal.getTypeName();
    Object value = literal.getValue(); // May be null

    if (value == null) {
      // Need type information for NULL literal. Validation usually provides this.
      // We have to guess or require explicit CAST. Let's try to infer if possible.
      // If this literal is inside a CAST(NULL AS type), the convertCall for CAST handles it.
      // Otherwise, it's ambiguous. Defaulting to a specific type like VARCHAR is risky.
      // Use the base NULL type, RexBuilder might refine later if context allows.
      // A better approach might be needed depending on usage.
      RelDataType type = typeFactory.createSqlType(SqlTypeName.NULL);
      return (RexLiteral) rexBuilder.makeNullLiteral(type); // Cast needed as return type is RexNode
    }

    try {
      switch (typeName) {
        case BOOLEAN:
          return rexBuilder.makeLiteral(literal.booleanValue());
        case TINYINT:
        case SMALLINT:
        case INTEGER:
          return rexBuilder.makeExactLiteral(
              literal.getValueAs(BigDecimal.class), // Use BigDecimal for precision
              typeFactory.createSqlType(typeName));
        case BIGINT:
          return rexBuilder.makeExactLiteral(
              literal.getValueAs(BigDecimal.class),
              typeFactory.createSqlType(typeName));
        case DECIMAL:
          RelDataType decType = typeFactory.createSqlType(typeName, 10);
          return rexBuilder.makeExactLiteral(literal.getValueAs(BigDecimal.class), decType);
        case FLOAT: // Approximate
        case REAL:  // Approximate
        case DOUBLE: // Approximate
          return rexBuilder.makeApproxLiteral(
              literal.getValueAs(BigDecimal.class), // RexBuilder often expects BigDecimal
              typeFactory.createSqlType(typeName));
        case CHAR:
        case VARCHAR:
          return rexBuilder.makeCharLiteral(literal.getValueAs(NlsString.class));
        case BINARY:
        case VARBINARY:
          throw new UnsupportedOperationException("VARBINARY not supported yet");
//                    return rexBuilder.makeBinaryLiteral(literal.getValueAs(ByteString.class));
        case DATE:
          return rexBuilder.makeDateLiteral(literal.getValueAs(DateString.class));
        case TIME:
          return rexBuilder.makeTimeLiteral(literal.getValueAs(TimeString.class), 10);
        case TIMESTAMP:
          return rexBuilder.makeTimestampLiteral(literal.getValueAs(TimestampString.class), 10);
        case INTERVAL_YEAR:
        case INTERVAL_YEAR_MONTH:
        case INTERVAL_MONTH:
        case INTERVAL_DAY:
        case INTERVAL_DAY_HOUR:
        case INTERVAL_DAY_MINUTE:
        case INTERVAL_DAY_SECOND:
        case INTERVAL_HOUR:
        case INTERVAL_HOUR_MINUTE:
        case INTERVAL_HOUR_SECOND:
        case INTERVAL_MINUTE:
        case INTERVAL_MINUTE_SECOND:
        case INTERVAL_SECOND:
          SqlIntervalLiteral.IntervalValue intValue = (SqlIntervalLiteral.IntervalValue) value;
          // Ensure qualifier has precision if needed
          SqlIntervalQualifier qualifier = intValue.getIntervalQualifier();
          RelDataType intervalType = typeFactory.createSqlIntervalType(qualifier);
          BigDecimal intervalValueDecimal = new BigDecimal(intValue.getSign() * Long.parseLong(intValue.getIntervalLiteral()));
          return rexBuilder.makeIntervalLiteral(intervalValueDecimal, qualifier);

        case SYMBOL: // Used for flags like DESC, NULLS FIRST/LAST - not expression literals
          throw new IllegalArgumentException("Cannot convert SYMBOL literal to RexNode: " + literal);
          // Add other types (GEOMETRY, MULTISET, etc.)
        default:
          throw new UnsupportedOperationException("Unsupported literal type: " + typeName);
      }
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Literal value does not match expected type for " + typeName + ": " + literal, e);
    }
  }

  /**
   * Converts an identifier SqlNode to RexInputRef or RexFieldAccess.
   */
  protected RexNode convertIdentifier(SqlIdentifier id, Scope scope) {
    Pair<Scope.InputRelation, RelDataTypeField> fieldInfo = scope.findField(id);

    if (fieldInfo == null) {
      // Could be a correlation variable if not found in immediate scope.
      // TODO: Implement correlation variable lookup (requires walking up scope stack).
      throw new RuntimeException("Identifier '" + id + "' not found in current scope: " + scope);
    }

    Scope.InputRelation relation = fieldInfo.left;
    RelDataTypeField field = fieldInfo.right;

    // Calculate the absolute index based on the relation's offset in the combined input
    int index = relation.offset + field.getIndex();

    // Simple case: Reference to a field in the direct input(s)
    return rexBuilder.makeInputRef(field.getType(), index);
  }

  /**
   * Converts a CASE expression.
   */
  protected RexNode convertCase(SqlCall caseCall, Scope scope) {
    assert caseCall.getOperator().equals(SqlStdOperatorTable.CASE);
    List<SqlNode> operands = caseCall.getOperandList();
    List<RexNode> rexOperands = new ArrayList<>();

    // Convert all WHEN, THEN, and ELSE clauses recursively using the current scope
    for (SqlNode operand : operands) {
      rexOperands.add(convertExpression(operand, scope));
    }

    // RexBuilder.makeCall handles type inference for the result (least restrictive of THEN/ELSE)
    return rexBuilder.makeCall(SqlStdOperatorTable.CASE, rexOperands);
  }

  /**
   * Converts a ROW constructor expression.
   */
  protected RexNode convertRow(SqlCall rowCall, Scope scope) {
    assert rowCall.getOperator().equals(SqlStdOperatorTable.ROW);
    List<RexNode> rexOperands = rowCall.getOperandList().stream()
        .map(operand -> convertExpression(operand, scope))
        .collect(Collectors.toList());

    // Determine type - relies on operand types
    RelDataType rowType = rexBuilder.deriveReturnType(SqlStdOperatorTable.ROW, rexOperands);
    return rexBuilder.makeCall(rowType, SqlStdOperatorTable.ROW, rexOperands);
  }

  /** Converts a SqlLiteralChain (e.g. 'abc' 'def') */
//    protected RexNode convertLiteralChain(SqlLiteralChain chain, Scope scope) {
//        // Concatenate the literals. Assumes they are all character literals.
//        // Validation should ensure this.
//        StringBuilder sb = new StringBuilder();
//        NlsString sample = null;
//        for (SqlNode node : chain.getOperandList()) {
//            if (!(node instanceof SqlCharStringLiteral)) {
//                throw new IllegalArgumentException("Literal chain must contain only character literals: " + chain);
//            }
//            SqlCharStringLiteral charLiteral = (SqlCharStringLiteral) node;
//            NlsString nls = charLiteral.getNlsString();
//            sb.append(nls.getValue());
//            if (sample == null) sample = nls; // Use first literal for charset/collation
//        }
//        if (sample == null) { // Empty chain?
//            sample = new NlsString("", null, null); // Default charset/collation? Risky.
//        }
//
//        NlsString result = new NlsString(sb.toString(), sample.getCharsetName(), sample.getCollation());
//        // Determine type - should be VARCHAR with combined length?
//        // Use VARCHAR for simplicity. Precision might be needed.
//        RelDataType type = typeFactory.createSqlType(SqlTypeName.VARCHAR, result.getValue().length());
//        type = typeFactory.createTypeWithCharsetAndCollation(type, result.getCharset(), result.getCollation());
//
//        return rexBuilder.makeCharLiteral(result, type);
//    }

  /**
   * Converts a window function call (OVER). Requires LogicalWindow.
   */
  protected RexNode convertOver(SqlCall overCall, Scope scope) {
    // Manual creation of RexOver is complex as it ties into LogicalWindow.
    // LogicalWindow itself requires careful setup of partitions, orderings, and frame.
    // This is one of the most complex parts to do without RelBuilder.
    throw new UnsupportedOperationException("Window functions (OVER clause) require LogicalWindow, which is complex to create manually and not implemented here.");
    // If implemented:
    // 1. Convert the aggregate function call part (e.g., SUM(col)) -> RexCall (agg)
    // 2. Convert partition keys -> List<RexNode>
    // 3. Convert order keys -> List<RexFieldCollation>
    // 4. Convert frame (ROWS/RANGE BETWEEN ...) -> RexWindowBound (lower, upper), isRows
    // 5. Create RexOver(...)
    // 6. Ensure a LogicalWindow node is created later in the plan processing.
  }

  /**
   * Converts a generic SqlCall (operator or function).
   */
  protected RexNode convertCall(SqlCall call, Scope scope) {
    SqlOperator operator = call.getOperator();
    List<SqlNode> operands = call.getOperandList();

    // Handle special operators explicitly if they don't fit the generic model easily
    if (operator.equals(SqlStdOperatorTable.CAST)) {
      return convertCast(call, scope);
    }
    if (operator.equals(SqlStdOperatorTable.IN) || operator.equals(SqlStdOperatorTable.NOT_IN)) {
      return convertIn(call, scope);
    }
    if (operator.equals(SqlStdOperatorTable.EXISTS)) {
      return convertExists(call, scope);
    }
    if (operator.getKind() == SqlKind.SCALAR_QUERY) {
      return convertScalarSubquery(call, scope);
    }
    // TODO: Handle BETWEEN, LIKE, SIMILAR, etc. if they need special treatment

    // Generic handling for most operators/functions
    List<RexNode> rexOperands = operands.stream()
        .map(operand -> convertExpression(operand, scope))
        .collect(Collectors.toList());

    // Type Inference: Crucial and hard without SqlValidator.
    RelDataType returnType = deriveType(operator, rexOperands);

    return rexBuilder.makeCall(returnType, operator, rexOperands);
  }

  /**
   * Derives return type for an operator call.
   */
  protected RelDataType deriveType(SqlOperator operator, List<RexNode> rexOperands) {
    // 1. Try SqlOperator.inferReturnType (might need more context than just types)
    // 2. Fallback to RexBuilder.deriveReturnType
    RelDataType returnType = null;
    try {
      // SqlOperator.inferReturnType often needs a CallBinding, which requires validator context.
      // We try a simplified version using only operand types. This may fail or be inaccurate.
      List<RelDataType> operandTypes = rexOperands.stream().map(RexNode::getType).collect(Collectors.toList());
      returnType = operator.inferReturnType(typeFactory, operandTypes);
    } catch (Exception e) {
      // Ignore inference failure, fallback below
    }

    if (returnType == null) {
      // Fallback to RexBuilder, which has more robust internal logic
      try {
        returnType = rexBuilder.deriveReturnType(operator, rexOperands);
      } catch (Exception e) {
        throw new IllegalStateException("Could not determine return type for operator " + operator.getName()
            + " with operand types: " + rexOperands.stream().map(r -> r.getType().getFullTypeString()).collect(Collectors.joining(", ")), e);
      }
    }

    if (returnType == null) {
      throw new IllegalStateException("Could not determine return type for operator " + operator.getName());
    }

    // Ensure the type is nullable if the operator or operands allow nulls.
    // This logic is complex and usually handled by SqlValidator.
    // We assume the derived type has correct nullability or rely on RexBuilder.
    return returnType;
  }

  /**
   * Converts a CAST expression.
   */
  protected RexNode convertCast(SqlCall castCall, Scope scope) {
    assert castCall.getOperator().equals(SqlStdOperatorTable.CAST);
    if (castCall.getOperandList().size() != 2) {
      throw new IllegalArgumentException("CAST requires 2 operands");
    }
    RexNode operand = convertExpression(castCall.getOperandList().get(0), scope);
    SqlDataTypeSpec typeSpec = (SqlDataTypeSpec) castCall.getOperandList().get(1);

    // Derive the target type from the SqlDataTypeSpec
    // This assumes the type spec itself is validated and doesn't need complex resolution.
    RelDataType targetType = null;//typeSpec.deriveType(typeFactory);
    if (targetType == null) {
      throw new IllegalStateException("Could not derive type from SqlDataTypeSpec: " + typeSpec);
    }

    // Handle CAST(NULL AS Type) - makeNullLiteral needs the target type
    if (operand.isA(SqlKind.LITERAL) && ((RexLiteral) operand).getValue() == null) {
      return rexBuilder.makeNullLiteral(targetType);
    }

    // Create the cast call
    return rexBuilder.makeCast(targetType, operand);
  }

  /**
   * Converts IN / NOT IN expression (subquery or value list).
   */
  protected RexNode convertIn(SqlCall inCall, Scope scope) {
    boolean isNotIn = inCall.getOperator().equals(SqlStdOperatorTable.NOT_IN);
    if (inCall.getOperandList().size() != 2) {
      throw new IllegalArgumentException(inCall.getOperator().getName() + " requires 2 operands");
    }

    RexNode lhs = convertExpression(inCall.getOperandList().get(0), scope);
    SqlNode rhsNode = inCall.getOperandList().get(1);

    RexNode rex;
    if (rhsNode instanceof SqlNodeList) {
      // IN (value list)
      List<RexNode> rhsList = new ArrayList<>();
      for (SqlNode node : ((SqlNodeList) rhsNode).getList()) {
        rhsList.add(convertExpression(node, scope));
      }
      // RexBuilder creates an OR chain (lhs=v1 OR lhs=v2 ...) or uses RexInNode
      rex = rexBuilder.makeIn(lhs, ImmutableList.copyOf(rhsList));
    } else {
      // IN (subquery)
      RelNode subQueryRel = convertQueryRecursive(rhsNode, false, scope); // Subquery uses outer scope
      // Ensure subquery returns one column
      if (subQueryRel.getRowType().getFieldCount() != 1) {
        throw new IllegalArgumentException("Subquery for IN operator must return exactly one column");
      }
      // TODO: Type compatibility check between lhs and subquery column? Assumed validated.

      // Create RexSubQuery
      rex = RexSubQuery.in(subQueryRel, ImmutableList.of(rexBuilder.makeInputRef(lhs.getType(), 0))); // InputRef refers to lhs within subquery context? Check RexSubQuery API.
      // RexSubQuery.makeIn expects the RelNode and a RexInputRef *referencing the field from the subquery's input* that should be correlated.
      // This requires correlation handling, which is complex.
      // Let's assume non-correlated IN for now.
      // A non-correlated IN subquery is often converted differently (e.g., via join).
      // Using RexSubQuery directly implies potential correlation.
      throw new UnsupportedOperationException("IN/NOT IN with subquery requires RexSubQuery / correlation handling (not fully implemented).");
      // Simplified attempt (likely incorrect for correlation):
      // rex = RexSubQuery.in(subQueryRel, ImmutableList.of(lhs)); // Need to check API
    }

    if (isNotIn) {
      rex = rexBuilder.makeCall(SqlStdOperatorTable.NOT, rex);
    }
    return rex;
  }

  /**
   * Converts EXISTS expression.
   */
  protected RexNode convertExists(SqlCall existsCall, Scope scope) {
    assert existsCall.getOperator().equals(SqlStdOperatorTable.EXISTS);
    if (existsCall.getOperandList().size() != 1) {
      throw new IllegalArgumentException("EXISTS requires 1 operand (subquery)");
    }
    SqlNode subQueryNode = existsCall.getOperandList().get(0);
    RelNode subQueryRel = convertQueryRecursive(subQueryNode, false, scope); // Subquery uses outer scope

    // Create RexSubQuery for EXISTS
    RexSubQuery rex = RexSubQuery.exists(subQueryRel);
    // TODO: Handle correlation if subquery references outer scope. RexSubQuery needs correlation info.
    return rex;
  }

  /**
   * Converts SCALAR subquery expression.
   */
  protected RexNode convertScalarSubquery(SqlCall scalarCall, Scope scope) {
    assert scalarCall.getKind() == SqlKind.SCALAR_QUERY;
    if (scalarCall.getOperandList().size() != 1) {
      throw new IllegalArgumentException("SCALAR_QUERY requires 1 operand (subquery)");
    }
    SqlNode subQueryNode = scalarCall.getOperandList().get(0);
    RelNode subQueryRel = convertQueryRecursive(subQueryNode, false, scope); // Subquery uses outer scope

    // Ensure subquery returns one column and at most one row (checked at runtime usually)
    if (subQueryRel.getRowType().getFieldCount() != 1) {
      throw new IllegalArgumentException("Scalar subquery must return exactly one column");
    }
    // TODO: Check cardinality? RelMetadataQuery can estimate, but exact check is runtime.

    // Create RexSubQuery for SCALAR query
    RexSubQuery rex = RexSubQuery.scalar(subQueryRel);
    // TODO: Handle correlation if subquery references outer scope.
    return rex;
  }

  /**
   * Converts an aggregate function call encountered in an expression context.
   */
  protected RexNode convertAggregateCallExpr(SqlCall aggCall, Scope scope) {
    // This should only be called when converting expressions *after* aggregation,
    // like in HAVING or ORDER BY clauses referencing aggregate results.
    if (!scope.isAggregateContext()) {
      throw new IllegalStateException("Unexpected aggregate function call in non-aggregate scope.");
    }

    // Find the corresponding aggregate call result from the scope
    Pair<Integer, AggregateCall> aggInfo = scope.findAggregateCall(aggCall);
    if (aggInfo == null) {
      throw new RuntimeException("Aggregate function '" + aggCall.getOperator().getName()
          + "' used in post-aggregation clause but not found in Aggregate node output.");
    }

    int fieldIndex = aggInfo.left; // Index in the Aggregate node's output row type
    AggregateCall callInstance = aggInfo.right;

    // Create a RexInputRef pointing to the aggregate result field
    return rexBuilder.makeInputRef(callInstance.getType(), fieldIndex);
  }


  // =====================================================================
  // Helper Methods & Classes
  // =====================================================================

  /**
   * Finds the input index corresponding to a RexNode (if it's a simple RexInputRef).
   */
  protected int findRexInputIndex(RexNode rex, RelNode input) {
    if (rex instanceof RexInputRef) {
      return ((RexInputRef) rex).getIndex();
    }
    // More complex matching (e.g., finding 'a+b' in input if rex is 'a+b') is hard.
    // Requires comparing expression structure or digests. Assume simple refs for now.

    // Check if rex matches one of the input fields structurally (e.g. for group exprs)
    // This is still complex. Rely on RexInputRef for now.
    return -1;
  }

  /**
   * Maps a {@link SqlAggFunction} to a Calcite {@link SqlAggFunction}.
   */
  protected SqlAggFunction mapSqlAggregation(SqlAggFunction sqlAggFunction) {
    // This mapping might depend on operand types for overloaded functions.
    // Assuming standard functions for now.
    // Use SqlStdOperatorTable directly if the instances match.
//        if (sqlAggFunction instanceof Aggregation) {
//            return (Aggregation) sqlAggFunction;
//        }
    // Add specific mappings if needed (e.g., for custom UDAFs)
    // Check standard table by name as fallback? Risky due to overloading.
    if (sqlAggFunction.getName().equalsIgnoreCase("COUNT")) return SqlStdOperatorTable.COUNT;
    if (sqlAggFunction.getName().equalsIgnoreCase("SUM")) return SqlStdOperatorTable.SUM;
    if (sqlAggFunction.getName().equalsIgnoreCase("AVG")) return SqlStdOperatorTable.AVG;
    if (sqlAggFunction.getName().equalsIgnoreCase("MIN")) return SqlStdOperatorTable.MIN;
    if (sqlAggFunction.getName().equalsIgnoreCase("MAX")) return SqlStdOperatorTable.MAX;
    // ... other standard aggregates

    throw new UnsupportedOperationException("Cannot map SqlAggFunction to Aggregation: " + sqlAggFunction.getName());
  }

  /**
   * Generates a default alias for an aggregate call.
   */
  private String generateAggAlias(SqlAggFunction function, int index) {
    // Mimic Calcite's default naming like EXPR$1, but maybe more descriptive
    return function.getName() + "$" + index;
  }

  /**
   * Information about a parsed aggregate call.
   */
  protected static class AggregateCallInfo {
    final SqlAggFunction sqlAggFunction;
    final List<SqlNode> sqlOperands;
    final boolean isDistinct;
    final boolean isApproximate;
    final @Nullable SqlNode filter;
    final @Nullable SqlNodeList orderKeys;
    final @Nullable String alias; // Alias from SELECT list, if any
    final SqlCall originalNode; // The original SqlCall node

    AggregateCallInfo(SqlCall call, @Nullable String alias) {
      this.originalNode = call;
      this.sqlAggFunction = (SqlAggFunction) call.getOperator();
      this.isDistinct = false;//call.getFunctionQuantifier().getKind() == SqlSelectKeyword.DISTINCT;
      this.isApproximate = false; // TODO: Detect APPROXIMATE keyword if supported

      // Need to parse operands, FILTER, ORDER BY within aggregate
      // This structure depends on how SqlAggFunction parses its call
      // Assuming simple operands for now. FILTER/ORDER BY require specific handling.
      this.sqlOperands = call.getOperandList();
      this.filter = null; // TODO: Extract FILTER (WHERE ...) clause
      this.orderKeys = null; // TODO: Extract ORDER BY within aggregate

      this.alias = alias;
    }

    // Need equals/hashCode based on the original SqlNode or its digest
    // to allow matching in post-aggregation expression conversion.
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      AggregateCallInfo that = (AggregateCallInfo) o;
      // Equality based on the original SqlNode should be sufficient if nodes are canonical
      // Using toString is brittle; consider a structural comparison or digest.
      return Objects.equals(originalNode.toString(), that.originalNode.toString());
    }

    @Override
    public int hashCode() {
      return Objects.hash(originalNode.toString());
    }
  }

  /**
   * Visitor to find aggregate calls within a SqlNode tree.
   */
  protected static class AggregateFinder extends SqlBasicVisitor<Void> {
    private final List<AggregateCallInfo> aggCalls = new ArrayList<>();
    private final Set<SqlNode> visited = new HashSet<>(); // Avoid re-visiting shared nodes
    private SqlNode currentSelectListItem = null; // Track current item for alias detection

    public List<AggregateCallInfo> getAggCalls() {
      return aggCalls;
    }

    @Override
    public Void visit(SqlCall call) {
      SqlOperator operator = call.getOperator();

      // Handle AS operator to capture alias for the aggregate call
      if (operator.equals(SqlStdOperatorTable.AS)) {
        SqlNode potentialAggCall = call.getOperandList().get(0);
        SqlIdentifier aliasId = (SqlIdentifier) call.getOperandList().get(1);
        String alias = aliasId.getSimple();
        // Visit the operand, passing the alias down
        findAggregatesRecursive(potentialAggCall, alias);
        return null; // Don't visit AS operands directly in superclass
      }

      // Standard recursion
      return findAggregatesRecursive(call, null);
    }

    // Separate recursive helper to handle alias passing
    private Void findAggregatesRecursive(SqlNode node, @Nullable String alias) {
      if (!visited.add(node)) {
        return null; // Already processed this node
      }

      if (node instanceof SqlCall) {
        SqlCall call = (SqlCall) node;
        SqlOperator operator = call.getOperator();

        if (operator instanceof SqlAggFunction) {
          // Found an aggregate call. Use the alias passed down (if any).
          aggCalls.add(new AggregateCallInfo(call, alias));
          // Do not recurse into arguments of the aggregate function itself
          // unless they can contain aggregates (e.g., SUM(MAX(x)) - usually invalid SQL).
          return null;
        }

        // Recurse into operands unless it's a special case
        if (operator.equals(SqlStdOperatorTable.OVER)) {
          // Visit the aggregate function part, but not the window spec operands
          if (!call.getOperandList().isEmpty()) {
            findAggregatesRecursive(call.getOperandList().get(0), alias); // Pass alias
          }
          return null;
        }

        // Default recursion for other calls
        for (SqlNode operand : call.getOperandList()) {
          if (operand != null) {
            findAggregatesRecursive(operand, null); // Alias doesn't propagate into arbitrary operands
          }
        }
        return null; // Handled recursion manually

      } else if (node instanceof SqlNodeList) {
        // Recurse into list elements
        for (SqlNode n : (SqlNodeList) node) {
          if (n != null) {
            findAggregatesRecursive(n, null); // Alias doesn't propagate
          }
        }
        return null; // Handled recursion manually
      }
      // No action for literals, identifiers etc.
      return null;
    }
  }


  /**
   * Manages the scope for identifier resolution during conversion.
   * Tracks input relations (tables, subqueries, joins) and their fields.
   * Handles CTEs and context for aggregate expression conversion.
   */
  protected static class Scope {
    private final @Nullable Scope parent;
    private final ImmutableList<InputRelation> relations; // Inputs available in this scope
    private final @Nullable Map<String, RelNode> cteMap; // CTEs defined *at this level* or above
    private final boolean isAggregateContext; // True if converting HAVING/ORDER BY post-aggregation

    // Fields specific to aggregate output scope
    private final @Nullable RelNode aggregateNode;
    private final @Nullable ImmutableBitSet groupSet; // Indices of group keys in Aggregate *input*
    private final @Nullable Map<Integer, RexNode> groupExprMap; // Map group key index -> original RexNode (from input)
    private final @Nullable List<AggregateCall> aggCalls; // Aggregate calls in the Aggregate node
    private final @Nullable Map<AggregateCallInfo, Integer> aggCallOutputIndexMap; // Map SqlCall info -> index in aggCalls list

    // Private constructor, use factory methods
    private Scope(@Nullable Scope parent,
                  ImmutableList<InputRelation> relations,
                  @Nullable Map<String, RelNode> cteMap,
                  boolean isAggregateContext,
                  @Nullable RelNode aggregateNode,
                  @Nullable ImmutableBitSet groupSet,
                  @Nullable Map<Integer, RexNode> groupExprMap,
                  @Nullable List<AggregateCall> aggCalls,
                  @Nullable Map<AggregateCallInfo, Integer> aggCallOutputIndexMap) {
      this.parent = parent;
      this.relations = relations;
      this.cteMap = cteMap;
      this.isAggregateContext = isAggregateContext;
      this.aggregateNode = aggregateNode;
      this.groupSet = groupSet;
      this.groupExprMap = groupExprMap;
      this.aggCalls = aggCalls;
      this.aggCallOutputIndexMap = aggCallOutputIndexMap;
    }

    // --- Factory Methods ---

    public static Scope createRoot() {
      return new Scope(null, ImmutableList.of(), null, false, null, null, null, null, null);
    }

    public static Scope createWithScope(Scope parent) {
      // Inherit parent's CTEs, but allow defining new ones
      Map<String, RelNode> newCteMap = new HashMap<>();
      if (parent.cteMap != null) {
        newCteMap.putAll(parent.cteMap);
      }
      return new Scope(parent, parent.relations, newCteMap, false, null, null, null, null, null);
    }

    public static Scope createSelectScope(Scope parent, RelNode fromRel) {
      // The 'fromRel' becomes the primary input relation for this scope.
      // Need to determine its alias (might require looking at the SqlNode that generated fromRel).
      // This is complex without passing SqlNode context alongside RelNode.
      // Assume alias is null for now, meaning only unqualified names or correlation names work.
      InputRelation relation = new InputRelation(null, 0, fromRel);
      return new Scope(parent, ImmutableList.of(relation), parent.cteMap, false, null, null, null, null, null);
    }

    public static Scope createJoinScope(Scope parent, RelNode left, RelNode right) {
      // Join scope has two relations. Offsets are crucial.
      // Assume left alias is null, right alias is null for now.
      InputRelation leftRel = new InputRelation(null, 0, left);
      InputRelation rightRel = new InputRelation(null, left.getRowType().getFieldCount(), right);
      return new Scope(parent, ImmutableList.of(leftRel, rightRel), parent.cteMap, false, null, null, null, null, null);
    }

    public static Scope createProjectScope(Scope parent, RelNode projectNode, List<String> aliases) {
      // Projection scope replaces the previous relations with a single one representing the projection output.
      // Use the provided aliases.
      InputRelation relation = new InputRelation(null, 0, projectNode, aliases);
      return new Scope(parent, ImmutableList.of(relation), parent.cteMap, false, null, null, null, null, null);
    }

    public static Scope createFromRelNode(Scope parent, RelNode relNode) {
      // Generic scope from a single RelNode, e.g., for ORDER BY input.
      // Assumes aliases are just the field names from the RelNode's row type.
      InputRelation relation = new InputRelation(null, 0, relNode);
      return new Scope(parent, ImmutableList.of(relation), parent.cteMap, false, null, null, null, null, null);
    }

    public static Scope createAggregateOutputScope(Scope parent, RelNode aggregateNode,
                                                   ImmutableBitSet groupSet, Map<Integer, RexNode> groupExprMap,
                                                   List<AggregateCall> aggCalls, Map<AggregateCallInfo, Integer> aggCallOutputIndexMap) {
      // Scope representing the output of LogicalAggregate, used for HAVING/ORDER BY
      InputRelation relation = new InputRelation(null, 0, aggregateNode); // Output fields are 0..N-1
      return new Scope(parent, ImmutableList.of(relation), parent.cteMap, true,
          aggregateNode, groupSet, groupExprMap, aggCalls, aggCallOutputIndexMap);
    }


    // --- Methods ---

    public void addCte(String name, RelNode rel) {
      if (cteMap == null) {
        throw new IllegalStateException("Cannot add CTE to this scope type");
      }
      cteMap.put(name, rel);
    }

    public boolean isCteDefined(String name) {
      return cteMap != null && cteMap.containsKey(name);
    }

    public @Nullable RelNode findCte(String name) {
      if (cteMap != null) {
        RelNode cte = cteMap.get(name);
        if (cte != null) {
          return cte;
        }
      }
      // Don't search parent scope for CTEs defined *within* a WITH clause.
      // Standard SQL CTE visibility rules are complex (e.g., nested WITH).
      // This implementation assumes simple visibility (defined before use within the same WITH or outer scope).
      // If parent search is needed: return (parent != null) ? parent.findCte(name) : null;
      return null;
    }

    public boolean isAggregateContext() {
      return isAggregateContext;
    }

    /**
     * Find relation by alias (e.g., table alias in FROM).
     */
    public @Nullable InputRelation findRelation(String alias) {
      for (InputRelation rel : relations) {
        if (rel.alias != null && rel.alias.equalsIgnoreCase(alias)) {
          return rel;
        }
      }
      return (parent != null) ? parent.findRelation(alias) : null;
    }


    /**
     * Find a field by identifier, searching current scope then parents.
     */
    public @Nullable Pair<InputRelation, RelDataTypeField> findField(SqlIdentifier id) {
      String simpleName = id.isSimple() ? id.getSimple() : id.names.get(id.names.size() - 1);
      String qualifier = id.names.size() > 1 ? id.names.get(0) : null;

      for (InputRelation relation : relations) {
        boolean qualifierMatch = (qualifier == null) // Unqualified name matches any relation unless ambiguous
            || (relation.alias != null && relation.alias.equalsIgnoreCase(qualifier));

        if (qualifierMatch) {
          RelDataTypeField field = relation.rowType.getField(simpleName, false, false); // Case-insensitive lookup
          if (field != null) {
            // TODO: Check for ambiguity if qualifier was null and multiple relations have the field.
            return Pair.of(relation, field);
          }
        }
      }

      // If not found, check parent scope (for correlation variables)
      return (parent != null) ? parent.findField(id) : null;
    }

    /**
     * Find aggregate call result in post-aggregation scope.
     */
    public @Nullable Pair<Integer, AggregateCall> findAggregateCall(SqlCall sqlCall) {
      if (!isAggregateContext || aggCalls == null || aggCallOutputIndexMap == null || groupSet == null) {
        return null; // Not in the right context or context is incomplete
      }

      // Need to match sqlCall to one of the AggregateCallInfos used to create the Aggregate node.
      // Use the temporary AggregateCallInfo for matching.
      AggregateCallInfo targetInfo = new AggregateCallInfo(sqlCall, null);
      Integer aggCallIndex = aggCallOutputIndexMap.get(targetInfo); // Index within the aggCalls list

      if (aggCallIndex != null) {
        // Found the aggregate call. Its index in the output row type is groupSet.cardinality() + aggCallIndex.
        int outputIndex = groupSet.cardinality() + aggCallIndex;
        return Pair.of(outputIndex, aggCalls.get(aggCallIndex));
      }

      return null; // Not found
    }


    @Override
    public String toString() {
      return "Scope{relations=" + relations.size() + ", parent=" + (parent != null) + ", cte=" + (cteMap != null ? cteMap.keySet() : "N/A") + "}";
    }

    /**
     * Represents one input relation (table, subquery, join result) within a scope.
     */
    public static class InputRelation {
      final @Nullable String alias; // Explicit alias (from AS) or implicit (table name)
      final int offset; // Starting index of this relation's fields in the combined input row type
      final RelNode relNode;
      final RelDataType rowType;
      final List<String> fieldAliases; // Aliases specific to this relation (e.g., from Project)

      InputRelation(String alias, int offset, RelNode relNode) {
        this(alias, offset, relNode, relNode.getRowType().getFieldNames()); // Default aliases from row type
      }

      InputRelation(@Nullable String alias, int offset, RelNode relNode, List<String> fieldAliases) {
        this.alias = alias;
        this.offset = offset;
        this.relNode = relNode;
        this.rowType = relNode.getRowType(); // Use row type from RelNode directly
        // Ensure fieldAliases size matches rowType field count
        if (fieldAliases.size() != this.rowType.getFieldCount()) {
          // Use default field names if aliases don't match (e.g., scope created before projection aliases known)
          this.fieldAliases = this.rowType.getFieldNames();
        } else {
          this.fieldAliases = ImmutableList.copyOf(fieldAliases);
        }
      }
    }
  }
}

