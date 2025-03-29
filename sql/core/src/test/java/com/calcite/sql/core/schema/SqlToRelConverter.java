package com.calcite.sql.core.schema;

import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.logical.*;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.rex.RexCorrelVariable;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.tools.Frameworks;

import java.util.*;

public class SqlToRelConverter {
  private final RelOptCluster cluster;
  private final SchemaPlus rootSchema;
  private final RexBuilder rexBuilder;
  private final RelDataTypeFactory typeFactory;
  private final Map<String, RelNode> cteMap;
  private final Map<String, RexCorrelVariable> correlationMap;

  public SqlToRelConverter(RelOptCluster cluster, SchemaPlus rootSchema) {
    this.cluster = cluster;
    this.rootSchema = rootSchema;
    this.rexBuilder = cluster.getRexBuilder();
    this.typeFactory = cluster.getTypeFactory();
    this.cteMap = new HashMap<>();
    this.correlationMap = new HashMap<>();
  }

  public RelNode convertSqlNodeToRelNode(SqlNode sqlNode) {
    // Reset correlation and CTE maps for each conversion
    correlationMap.clear();
    cteMap.clear();

    return convertSqlNodeRecursive(sqlNode, null);
  }

  private RelNode convertSqlNodeRecursive(SqlNode sqlNode, RelNode parentRel) {
    if (sqlNode instanceof SqlSelect) {
      return convertSqlSelect((SqlSelect) sqlNode, parentRel);
    }
    if (sqlNode instanceof SqlWith) {
      return convertSqlWith((SqlWith) sqlNode);
    }
    if (sqlNode instanceof SqlOrderBy) {
      return convertSqlOrderBy((SqlOrderBy) sqlNode, parentRel);
    }
    throw new UnsupportedOperationException("Unsupported SQL node type: " + sqlNode.getClass());
  }

  private RelNode convertSqlWith(SqlWith sqlWith) {
    // Process CTE definitions first
    for (SqlNode withItem : sqlWith.withList) {
      if (withItem instanceof SqlWithItem) {
        SqlWithItem cteItem = (SqlWithItem) withItem;
        String cteName = cteItem.name.getSimple();
        RelNode cteRel = convertSqlNodeRecursive(cteItem.query, null);
        cteMap.put(cteName, cteRel);
      }
    }

    // Convert main query
    return convertSqlNodeRecursive(sqlWith.body, null);
  }

  private RelNode convertSqlSelect(SqlSelect sqlSelect, RelNode parentRel) {
    // Handle FROM clause (table scan or join)
    RelNode fromRel = convertFromClause(sqlSelect.getFrom(), parentRel);

    // Handle WHERE clause (filter)
    RelNode filterRel = convertWhereClause(sqlSelect.getWhere(), fromRel);

    // Handle GROUP BY clause
    RelNode groupByRel = convertGroupByClause(sqlSelect.getGroup(), filterRel);

    // Handle HAVING clause
    RelNode havingRel = convertHavingClause(sqlSelect.getHaving(), groupByRel);

    // Handle SELECT clause (project)
    RelNode projectRel = convertSelectClause(sqlSelect.getSelectList(), havingRel);

    return projectRel;
  }

  private RelNode convertFromClause(SqlNode fromNode, RelNode parentRel) {
    if (fromNode.getKind() == SqlKind.IDENTIFIER) {
      // Simple table reference
      String tableName = ((SqlIdentifier) fromNode).names.get(0);
      return convertTableScan(tableName);
    }
    // Handle JOIN
    if (fromNode.getKind() == SqlKind.JOIN) {
      return convertJoinClause((SqlJoin) fromNode, parentRel);
    }
    if (fromNode instanceof SqlBasicCall) {
      SqlBasicCall fromCall = (SqlBasicCall) fromNode;


      // Handle subquery
      if (fromCall.getOperator() == SqlStdOperatorTable.AS) {
        return convertSubqueryAlias(fromCall, parentRel);
      }
    }
    if (fromNode instanceof SqlSelect) {
      // Subquery in FROM clause
      return convertSqlNodeRecursive(fromNode, parentRel);
    }
    throw new UnsupportedOperationException("Unsupported FROM clause type: " + fromNode.getClass());
  }

  private RelNode convertTableScan(String tableName) {
    // Check if it's a CTE
    if (cteMap.containsKey(tableName)) {
      return cteMap.get(tableName);
    }

    // Regular table scan
    return LogicalTableScan.create(
        cluster,
        Frameworks.resolve(rootSchema, tableName), List.of()
    );
  }

  private RelNode convertJoinClause(SqlJoin joinCall, RelNode parentRel) {
    List<SqlNode> operandList = joinCall.getOperandList();
    SqlNode left = operandList.get(0);
    SqlNode right = operandList.get(1);
    SqlNode condition = operandList.get(2);

    RelNode leftRel = convertFromClause(left, parentRel);
    RelNode rightRel = convertFromClause(right, parentRel);

    // Convert join condition to RexNode
    RexNode joinCondition = convertSqlToRexNode(condition, leftRel, rightRel);

    // Determine join type
    JoinRelType joinType = determineJoinType(joinCall.getOperator());

    return LogicalJoin.create(
        leftRel,
        rightRel,
        List.of(), // empty hint
        joinCondition,
        Set.of(), // empty correlated columns
        joinType
    );
  }

  private RelNode convertSubqueryAlias(SqlBasicCall aliasCall, RelNode parentRel) {
    SqlNode subquery = aliasCall.getOperandList().get(0);
    SqlIdentifier alias = (SqlIdentifier) aliasCall.getOperandList().get(1);

    RelNode subqueryRel = convertSqlNodeRecursive(subquery, parentRel);

    // Add correlation for subquery alias
    RexCorrelVariable correlVar = rexBuilder.makeCorrel(
        subqueryRel.getRowType(),
        alias.getSimple()
    );
    correlationMap.put(alias.getSimple(), correlVar);

    return subqueryRel;
  }

  private RelNode convertWhereClause(SqlNode whereNode, RelNode inputRel) {
    if (whereNode == null) {
      return inputRel;
    }

    RexNode condition = convertSqlToRexNode(whereNode, inputRel);
    return LogicalFilter.create(inputRel, condition);
  }

  private RelNode convertGroupByClause(SqlNodeList groupList, RelNode inputRel) {
    if (groupList == null || groupList.size() == 0) {
      return inputRel;
    }

    List<RexNode> groupExprs = new ArrayList<>();
    for (SqlNode groupItem : groupList.getList()) {
      groupExprs.add(convertSqlToRexNode(groupItem, inputRel));
    }

    return LogicalAggregate.create(
        inputRel,
        groupExprs,
        Collections.emptyList() // No aggregation functions for now
    );
  }

  private RelNode convertHavingClause(SqlNode havingNode, RelNode inputRel) {
    if (havingNode == null) {
      return inputRel;
    }

    RexNode condition = convertSqlToRexNode(havingNode, inputRel);
    return LogicalFilter.create(inputRel, condition);
  }

  private RelNode convertSelectClause(SqlNodeList selectList, RelNode inputRel) {
    List<RexNode> projects = new ArrayList<>();
    List<String> fieldNames = new ArrayList<>();

    for (SqlNode selectItem : selectList.getList()) {
      RexNode rexProject = convertSqlToRexNode(selectItem, inputRel);
      projects.add(rexProject);

      // Derive column names
      String columnName = deriveColumnName(selectItem);
      fieldNames.add(columnName);
    }

    RelDataType rowType = typeFactory.createStructType(
        projects.stream()
            .map(RexNode::getType)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll),
        fieldNames
    );

    return LogicalProject.create(
        inputRel,
        projects,
        rowType
    );
  }

  private RelNode convertSqlOrderBy(SqlOrderBy orderByNode, RelNode parentRel) {
    RelNode inputRel = convertSqlNodeRecursive(orderByNode.query, parentRel);

    List<RexNode> sortExprs = new ArrayList<>();
    List<RelFieldCollation> collations = new ArrayList<>();

    for (SqlNode orderItem : orderByNode.orderList.getList()) {
      if (orderItem instanceof SqlBasicCall) {
        SqlBasicCall call = (SqlBasicCall) orderItem;
        RexNode sortExpr = convertSqlToRexNode(call.operands[0], inputRel);
        sortExprs.add(sortExpr);

        // Determine sort direction
        RelFieldCollation.Direction direction =
            call.getOperator() == SqlStdOperatorTable.DESC
                ? RelFieldCollation.Direction.DESCENDING
                : RelFieldCollation.Direction.ASCENDING;

        collations.add(
            new RelFieldCollation(
                sortExprs.size() - 1,
                direction
            )
        );
      }
    }

    return LogicalSort.create(
        inputRel,
        collations
    );
  }

  private RexNode convertSqlToRexNode(SqlNode sqlNode, RelNode... inputRels) {
    // Merge multiple input rels if provided
    RelNode inputRel = inputRels.length > 0 ? mergeRelNodes(inputRels) : null;

    if (sqlNode instanceof SqlIdentifier) {
      return convertSqlIdentifier((SqlIdentifier) sqlNode, inputRel);
    }

    if (sqlNode instanceof SqlBasicCall) {
      return convertSqlBasicCall((SqlBasicCall) sqlNode, inputRel);
    }

    if (sqlNode instanceof SqlLiteral) {
      return convertSqlLiteral((SqlLiteral) sqlNode);
    }

    if (sqlNode instanceof SqlSelect) {
      return convertSubqueryToRexNode((SqlSelect) sqlNode, inputRel);
    }

    throw new UnsupportedOperationException("Unsupported SQL node type for Rex conversion: " + sqlNode.getClass());
  }

  private RexNode convertSqlIdentifier(SqlIdentifier identifier, RelNode inputRel) {
    // Check for correlation variable
    if (correlationMap.containsKey(identifier.names.get(0))) {
      return correlationMap.get(identifier.names.get(0));
    }

    // Find column index in input rel
    String columnName = identifier.names.get(0);
    int columnIndex = findColumnIndex(inputRel, columnName);

    return rexBuilder.makeInputRef(inputRel, columnIndex);
  }

  private RexNode convertSqlBasicCall(SqlBasicCall call, RelNode inputRel) {
    List<RexNode> operands = new ArrayList<>();

    for (SqlNode operand : call.getOperandList()) {
      operands.add(convertSqlToRexNode(operand, inputRel));
    }

    return rexBuilder.makeCall(
        typeFactory.createSqlType(call.getOperator().getReturnType()),
        call.getOperator(),
        operands
    );
  }

  private RexNode convertSqlLiteral(SqlLiteral literal) {
    // Convert SQL literal to RexLiteral
    return rexBuilder.makeLiteral(
        literal.getValue(),
        typeFactory.createSqlType(literal.getTypeName()),
        false
    );
  }

  private RexNode convertSubqueryToRexNode(SqlSelect subquery, RelNode correlatedRel) {
    // Handle correlated subquery
    RelNode subqueryRel = convertSqlNodeRecursive(subquery, correlatedRel);

    // Convert subquery to a scalar subquery
    return rexBuilder.makeSubQuery(
        subqueryRel.getRowType(),
        subqueryRel
    );
  }

  private RelNode mergeRelNodes(RelNode... inputRels) {
    if (inputRels.length == 1) {
      return inputRels[0];
    }

    // Create a logical union of input rels
    return LogicalUnion.create(
        Arrays.asList(inputRels),
        true // all inputs must have same row type
    );
  }

  private JoinRelType determineJoinType(SqlOperator operator) {
    if (operator == SqlStdOperatorTable.INNER_JOIN) return JoinRelType.INNER;
    if (operator == SqlStdOperatorTable.LEFT_JOIN) return JoinRelType.LEFT;
    if (operator == SqlStdOperatorTable.RIGHT_JOIN) return JoinRelType.RIGHT;
    if (operator == SqlStdOperatorTable.FULL_JOIN) return JoinRelType.FULL;
    throw new UnsupportedOperationException("Unsupported join type: " + operator);
  }

  private String deriveColumnName(SqlNode selectItem) {
    if (selectItem instanceof SqlIdentifier) {
      return ((SqlIdentifier) selectItem).names.get(0);
    }
    if (selectItem instanceof SqlBasicCall) {
      return selectItem.toString();
    }
    return "expr";
  }

  private int findColumnIndex(RelNode inputRel, String columnName) {
    RelDataType rowType = inputRel.getRowType();
    for (int i = 0; i < rowType.getFieldCount(); i++) {
      if (rowType.getFieldNames().get(i).equalsIgnoreCase(columnName)) {
        return i;
      }
    }
    throw new IllegalArgumentException("Column not found: " + columnName);
  }
}