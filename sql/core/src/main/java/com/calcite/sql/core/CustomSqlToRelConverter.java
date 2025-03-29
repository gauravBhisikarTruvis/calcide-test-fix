package com.calcite.sql.core;

import org.apache.calcite.adapter.enumerable.EnumerableRel;
import org.apache.calcite.adapter.enumerable.EnumerableRelImplementor;
import org.apache.calcite.linq4j.tree.Expression;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.*;
import org.apache.calcite.rel.logical.*;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.*;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.Table;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.advise.SqlAdvisor;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.util.Pair;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CustomSqlToRelConverter {
  private final RelOptCluster cluster;
  private final SchemaPlus rootSchema;
  private final RexBuilder rexBuilder;
  private final RelDataTypeFactory typeFactory;
  private final Map<String, RelNode> cteMap;
  private final Map<String, RexCorrelVariable> correlationMap;

  public CustomSqlToRelConverter(RelOptCluster cluster, SchemaPlus rootSchema) {
    this.cluster = cluster;
    this.rootSchema = rootSchema;
    this.rexBuilder = cluster.getRexBuilder();
    this.typeFactory = cluster.getTypeFactory();
    this.cteMap = new HashMap<>();
    this.correlationMap = new HashMap<>();
  }

//  public RelNode convertSqlNodeToRelNode(SqlNode sqlNode) {
//    // Reset correlation and CTE maps for each conversion
//    correlationMap.clear();
//    cteMap.clear();
//
//    return convertSqlNodeRecursive(sqlNode, null);
//  }
//
//  private RelNode convertSqlNodeRecursive(SqlNode sqlNode, RelNode parentRel) {
//    if (sqlNode instanceof SqlSelect) {
//      return convertSqlSelect((SqlSelect) sqlNode, parentRel);
//    }
//    if (sqlNode instanceof SqlWith) {
//      return convertSqlWith((SqlWith) sqlNode);
//    }
//    if (sqlNode instanceof SqlOrderBy) {
//      return convertSqlOrderBy((SqlOrderBy) sqlNode, parentRel);
//    }
//    throw new UnsupportedOperationException("Unsupported SQL node type: " + sqlNode.getClass());
//  }
//
//  private RelNode convertSqlWith(SqlWith sqlWith) {
//    // Process CTE definitions first
//    for (SqlNode withItem : sqlWith.withList) {
//      if (withItem instanceof SqlWithItem) {
//        SqlWithItem cteItem = (SqlWithItem) withItem;
//        String cteName = cteItem.name.getSimple();
//        RelNode cteRel = convertSqlNodeRecursive(cteItem.query, null);
//        cteMap.put(cteName, cteRel);
//      }
//    }
//
//    // Convert main query
//    return convertSqlNodeRecursive(sqlWith.body, null);
//  }
//
//  private RelNode convertSqlSelect(SqlSelect sqlSelect, RelNode parentRel) {
//    // Handle DISTINCT
//    boolean isDistinct = sqlSelect.isDistinct();
//
//    // Handle FROM clause (table scan or join)
//    RelNode fromRel = sqlSelect.getFrom() != null
//        ? convertFromClause(sqlSelect.getFrom(), parentRel)
//        : LogicalValues.createOneRow(cluster); // For queries without FROM
//
//    // Set up correlation context for subqueries
//    setupCorrelationForSubqueries(sqlSelect, fromRel);
//
//    // Handle WHERE clause (filter)
//    RelNode filterRel = convertWhereClause(sqlSelect.getWhere(), fromRel);
//
//    // Handle GROUP BY clause
//    RelNode groupByRel = convertGroupByClause(sqlSelect.getGroup(), filterRel);
//
//    // Handle HAVING clause
//    RelNode havingRel = convertHavingClause(sqlSelect.getHaving(), groupByRel);
//
//    // Handle SELECT clause (project)
//    RelNode projectRel = convertSelectClause(sqlSelect.getSelectList(), havingRel);
//
//    // Handle DISTINCT if present
//    if (isDistinct) {
//      projectRel = convertDistinct(projectRel);
//    }
//
//    // Handle WINDOW clause
//    RelNode windowRel = convertWindowClause(sqlSelect.getWindowList(), projectRel);
//
//    // Handle OFFSET and FETCH (LIMIT)
//    RelNode limitRel = convertOffsetFetch(sqlSelect.getOffset(), sqlSelect.getFetch(), windowRel);
//
//    return limitRel;
//  }
//
//  private void setupCorrelationForSubqueries(SqlSelect sqlSelect, RelNode fromRel) {
//    // Set up correlation variables for subqueries in where, having, and select list
//    if (sqlSelect.getWhere() != null) {
//      extractCorrelationVariables(sqlSelect.getWhere(), fromRel);
//    }
//
//    if (sqlSelect.getHaving() != null) {
//      extractCorrelationVariables(sqlSelect.getHaving(), fromRel);
//    }
//
//    if (sqlSelect.getSelectList() != null) {
//      for (SqlNode node : sqlSelect.getSelectList().getList()) {
//        extractCorrelationVariables(node, fromRel);
//      }
//    }
//  }
//
//  private void extractCorrelationVariables(SqlNode node, RelNode fromRel) {
//    if (node instanceof SqlBasicCall) {
//      SqlBasicCall call = (SqlBasicCall) node;
//
//      for (SqlNode operand : call.getOperandList()) {
//        extractCorrelationVariables(operand, fromRel);
//      }
//
//      // Handle CORRELATE operator specially
//      if (call.getOperator().getKind() == SqlKind.CORRELATE) {
//        SqlNode left = call.operands[0];
//        SqlNode alias = call.operands[1];
//
//        if (alias instanceof SqlIdentifier) {
//          String correlName = ((SqlIdentifier) alias).getSimple();
//          RexCorrelVariable correlVar = rexBuilder.makeCorrel(
//              fromRel.getRowType(),
//              correlName
//          );
//          correlationMap.put(correlName, correlVar);
//        }
//      }
//    } else if (node instanceof SqlSelect) {
//      // Handle subqueries recursively
//      SqlSelect subquery = (SqlSelect) node;
//      if (subquery.getWhere() != null) {
//        extractCorrelationVariables(subquery.getWhere(), fromRel);
//      }
//    }
//  }
//
//  private RelNode convertDistinct(RelNode input) {
//    return LogicalAggregate.create(
//        input,
//        input.getRowType().getFieldList().stream()
//            .map(field -> rexBuilder.makeInputRef(input, field.getIndex()))
//            .collect(Collectors.toList()),
//        Collections.emptyList() // No aggregate functions
//    );
//  }
//
//  private RelNode convertWindowClause(SqlNodeList windowList, RelNode input) {
//    if (windowList == null || windowList.isEmpty()) {
//      return input;
//    }
//
//    // Convert window definitions to window specs
//    List<Window.Group> windowGroups = new ArrayList<>();
//
//    for (SqlNode windowNode : windowList.getList()) {
//      if (windowNode instanceof SqlWindow) {
//        SqlWindow window = (SqlWindow) windowNode;
//
//        // Create partition keys
//        List<RexNode> partitionKeys = new ArrayList<>();
//        if (window.getPartitionList() != null) {
//          for (SqlNode partitionItem : window.getPartitionList()) {
//            partitionKeys.add(convertSqlToRexNode(partitionItem, input));
//          }
//        }
//
//        // Create order keys
//        List<RelFieldCollation> orderKeys = new ArrayList<>();
//        if (window.getOrderList() != null) {
//          for (SqlNode orderItem : window.getOrderList()) {
//            SqlBasicCall call = (SqlBasicCall) orderItem;
//            RexNode sortExpr = convertSqlToRexNode(call.operands[0], input);
//            RelFieldCollation.Direction direction =
//                call.getOperator() == SqlStdOperatorTable.DESC
//                    ? RelFieldCollation.Direction.DESCENDING
//                    : RelFieldCollation.Direction.ASCENDING;
//
//            orderKeys.add(new RelFieldCollation(
//                input.getRowType().getFieldNames().indexOf(sortExpr.toString()),
//                direction
//            ));
//          }
//        }
//
//        // Create window spec
//        Window.Group windowGroup = new Window.Group(
//            partitionKeys,
//            orderKeys,
//            SqlWindow.createWindowBound(window.getLowerBound()),
//            SqlWindow.createWindowBound(window.getUpperBound()),
//            null // No RexWindowFunctions yet
//        );
//
//        windowGroups.add(windowGroup);
//      }
//    }
//
//    return LogicalWindow.create(
//        input,
//        windowGroups
//    );
//  }
//
//  private RelNode convertOffsetFetch(SqlNode offsetNode, SqlNode fetchNode, RelNode input) {
//    if (offsetNode == null && fetchNode == null) {
//      return input;
//    }
//
//    // Convert OFFSET
//    RexNode offset = offsetNode != null
//        ? convertSqlToRexNode(offsetNode, input)
//        : rexBuilder.makeExactLiteral(BigDecimal.ZERO);
//
//    // Convert FETCH/LIMIT
//    RexNode fetch = fetchNode != null
//        ? convertSqlToRexNode(fetchNode, input)
//        : rexBuilder.makeExactLiteral(new BigDecimal(-1)); // -1 means no limit
//
//    return LogicalSort.create(
//        input,
//        input.getTraitSet(),
//        Collections.emptyList(), // No ordering
//        offset,
//        fetch
//    );
//  }
//
//  private RelNode convertSelectClause(SqlNodeList selectList, RelNode inputRel) {
//    List<RexNode> projects = new ArrayList<>();
//    List<String> fieldNames = new ArrayList<>();
//
//    // Handle '*' case
//    if (selectList.size() == 1 && selectList.get(0) instanceof SqlIdentifier
//        && ((SqlIdentifier) selectList.get(0)).isStar()) {
//      // For *, include all columns from input
//      for (int i = 0; i < inputRel.getRowType().getFieldCount(); i++) {
//        projects.add(rexBuilder.makeInputRef(inputRel, i));
//        fieldNames.add(inputRel.getRowType().getFieldNames().get(i));
//      }
//    } else {
//      // Process each item in SELECT list
//      for (SqlNode selectItem : selectList.getList()) {
//        if (selectItem instanceof SqlIdentifier && ((SqlIdentifier) selectItem).isStar()) {
//          // Handle table qualified star: table.*
//          String tableAlias = ((SqlIdentifier) selectItem).names.get(0);
//          addColumnsForTableAlias(tableAlias, inputRel, projects, fieldNames);
//        } else {
//          // Regular column or expression
//          RexNode rexProject = convertSqlToRexNode(selectItem, inputRel);
//          projects.add(rexProject);
//
//          // Handle column aliases in AS expressions
//          String columnName = deriveColumnName(selectItem);
//          fieldNames.add(columnName);
//
//          // Handle aggregation functions
//          if (isAggregateCall(selectItem)) {
//            inputRel = addAggregateFunction(selectItem, inputRel, projects.size() - 1);
//          }
//        }
//      }
//    }
//
//    RelDataType rowType = typeFactory.createStructType(
//        projects.stream()
//            .map(RexNode::getType)
//            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll),
//        fieldNames
//    );
//
//    return LogicalProject.create(
//        inputRel,
//        projects,
//        rowType
//    );
//  }
//
//  private void addColumnsForTableAlias(String tableAlias, RelNode inputRel,
//                                       List<RexNode> projects, List<String> fieldNames) {
//    // Find all columns from the specified table
//    RelDataType rowType = inputRel.getRowType();
//    for (int i = 0; i < rowType.getFieldCount(); i++) {
//      String fullName = rowType.getFieldNames().get(i);
//      if (fullName.startsWith(tableAlias + ".") || tableAlias.equals("*")) {
//        projects.add(rexBuilder.makeInputRef(inputRel, i));
//        fieldNames.add(rowType.getFieldNames().get(i));
//      }
//    }
//  }
//
//  private boolean isAggregateCall(SqlNode node) {
//    if (node instanceof SqlBasicCall) {
//      SqlBasicCall call = (SqlBasicCall) node;
//      SqlOperator operator = call.getOperator();
//      return operator.getKind() == SqlKind.SUM ||
//          operator.getKind() == SqlKind.COUNT ||
//          operator.getKind() == SqlKind.MIN ||
//          operator.getKind() == SqlKind.MAX ||
//          operator.getKind() == SqlKind.AVG;
//    }
//    return false;
//  }
//
//  private RelNode addAggregateFunction(SqlNode aggNode, RelNode input, int projIndex) {
//    if (aggNode instanceof SqlBasicCall) {
//      SqlBasicCall call = (SqlBasicCall) node;
//
//      // Create AggregateCall
//      SqlAggFunction aggFunction = (SqlAggFunction) call.getOperator();
//      List<Integer> argList = new ArrayList<>();
//
//      // For COUNT(*), use empty arg list
//      if (aggFunction.getKind() == SqlKind.COUNT &&
//          call.operands.length == 1 &&
//          call.operands[0] instanceof SqlIdentifier &&
//          ((SqlIdentifier) call.operands[0]).isStar()) {
//        // COUNT(*) - empty arg list
//      } else {
//        // Other agg functions - add arguments
//        for (SqlNode operand : call.operands) {
//          if (operand instanceof SqlIdentifier) {
//            argList.add(findColumnIndex(input, ((SqlIdentifier) operand).getSimple()));
//          }
//        }
//      }
//
//      AggregateCall aggregateCall = AggregateCall.create(
//          aggFunction,
//          false, // not distinct
//          false, // not approximate
//          argList,
//          -1, // no filter
//          null, // no distinctKeys
//          call.getOperator().getName()
//      );
//
//      // Create an Aggregate node
//      return LogicalAggregate.create(
//          input,
//          Collections.emptyList(), // No group keys for simple agg
//          Collections.singletonList(aggregateCall)
//      );
//    }
//
//    return input;
//  }
//
//  private RelNode convertFromClause(SqlNode fromNode, RelNode parentRel) {
//    if (fromNode.getKind() == SqlKind.IDENTIFIER) {
//      // Simple table reference
//      String tableName = ((SqlIdentifier) fromNode).names.get(0);
//      return convertTableScan(tableName);
//    }
//    if (fromNode instanceof SqlBasicCall) {
//      SqlBasicCall fromCall = (SqlBasicCall) fromNode;
//
//      // Handle JOIN
//      if (fromCall.getOperator() == SqlStdOperatorTable.JOIN) {
//        return convertJoinClause(fromCall, parentRel);
//      }
//
//      // Handle subquery
//      if (fromCall.getOperator() == SqlStdOperatorTable.AS) {
//        return convertSubqueryAlias(fromCall, parentRel);
//      }
//    }
//    if (fromNode instanceof SqlSelect) {
//      // Subquery in FROM clause
//      return convertSqlNodeRecursive(fromNode, parentRel);
//    }
//    throw new UnsupportedOperationException("Unsupported FROM clause type: " + fromNode.getClass());
//  }
//
//  private RelNode convertTableScan(String tableName) {
//    // Check if it's a CTE
//    if (cteMap.containsKey(tableName)) {
//      return cteMap.get(tableName);
//    }
//
//    // Regular table scan
//    return LogicalTableScan.create(
//        cluster,
//        Frameworks.resolve(rootSchema, tableName)
//    );
//  }
//
//  private RelNode convertJoinClause(SqlBasicCall joinCall, RelNode parentRel) {
//    SqlNode left = joinCall.operands[0];
//    SqlNode right = joinCall.operands[1];
//    SqlNode condition = joinCall.operands[2];
//
//    RelNode leftRel = convertFromClause(left, parentRel);
//    RelNode rightRel = convertFromClause(right, parentRel);
//
//    // Convert join condition to RexNode
//    RexNode joinCondition = convertSqlToRexNode(condition, leftRel, rightRel);
//
//    // Determine join type
//    JoinRelType joinType = determineJoinType(joinCall.getOperator());
//
//    return LogicalJoin.create(
//        leftRel,
//        rightRel,
//        joinCondition,
//        joinType
//    );
//  }
//
//  private RelNode convertSubqueryAlias(SqlBasicCall aliasCall, RelNode parentRel) {
//    SqlNode subquery = aliasCall.operands[0];
//    SqlIdentifier alias = (SqlIdentifier) aliasCall.operands[1];
//
//    RelNode subqueryRel = convertSqlNodeRecursive(subquery, parentRel);
//
//    // Add correlation for subquery alias
//    RexCorrelVariable correlVar = rexBuilder.makeCorrel(
//        subqueryRel.getRowType(),
//        alias.getSimple()
//    );
//    correlationMap.put(alias.getSimple(), correlVar);
//
//    return subqueryRel;
//  }
//
//  private RelNode convertWhereClause(SqlNode whereNode, RelNode inputRel) {
//    if (whereNode == null) {
//      return inputRel;
//    }
//
//    RexNode condition = convertSqlToRexNode(whereNode, inputRel);
//    return LogicalFilter.create(inputRel, condition);
//  }
//
//  private RelNode convertGroupByClause(SqlNodeList groupList, RelNode inputRel) {
//    if (groupList == null || groupList.size() == 0) {
//      return inputRel;
//    }
//
//    List<RexNode> groupExprs = new ArrayList<>();
//    for (SqlNode groupItem : groupList.getList()) {
//      groupExprs.add(convertSqlToRexNode(groupItem, inputRel));
//    }
//
//    return null;/* LogicalAggregate.create(
//        inputRel,
//        groupExprs,
//        Collections.emptyList() // No aggregation functions for now
//    );*/
//  }
//
//  private RelNode convertHavingClause(SqlNode havingNode, RelNode inputRel) {
//    if (havingNode == null) {
//      return inputRel;
//    }
//
//    RexNode condition = convertSqlToRexNode(havingNode, inputRel);
//    return LogicalFilter.create(inputRel, condition);
//  }
//
//  private RelNode convertSelectClause(SqlNodeList selectList, RelNode inputRel) {
//    List<RexNode> projects = new ArrayList<>();
//    List<String> fieldNames = new ArrayList<>();
//
//    for (SqlNode selectItem : selectList.getList()) {
//      RexNode rexProject = convertSqlToRexNode(selectItem, inputRel);
//      projects.add(rexProject);
//
//      // Derive column names
//      String columnName = deriveColumnName(selectItem);
//      fieldNames.add(columnName);
//    }
//
//    RelDataType rowType = typeFactory.createStructType(
//        projects.stream()
//            .map(RexNode::getType)
//            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll),
//        fieldNames
//    );
//
//    return LogicalProject.create(
//        inputRel,
//        projects,
//        rowType
//    );
//  }
//
//  private RelNode convertSqlOrderBy(SqlOrderBy orderByNode, RelNode parentRel) {
//    RelNode inputRel = convertSqlNodeRecursive(orderByNode.query, parentRel);
//
//    List<RexNode> sortExprs = new ArrayList<>();
//    List<RelFieldCollation> collations = new ArrayList<>();
//
//    for (SqlNode orderItem : orderByNode.orderList.getList()) {
//      if (orderItem instanceof SqlBasicCall) {
//        SqlBasicCall call = (SqlBasicCall) orderItem;
//        RexNode sortExpr = convertSqlToRexNode(call.operands[0], inputRel);
//        sortExprs.add(sortExpr);
//
//        // Determine sort direction
//        RelFieldCollation.Direction direction =
//            call.getOperator() == SqlStdOperatorTable.DESC
//                ? RelFieldCollation.Direction.DESCENDING
//                : RelFieldCollation.Direction.ASCENDING;
//
//        collations.add(
//            new RelFieldCollation(
//                sortExprs.size() - 1,
//                direction
//            )
//        );
//      }
//    }
//
//    return LogicalSort.create(
//        inputRel,
//        collations
//    );
//  }
//
//  private RexNode convertSqlToRexNode(SqlNode sqlNode, RelNode... inputRels) {
//    // Merge multiple input rels if provided
//    RelNode inputRel = inputRels.length > 0 ? mergeRelNodes(inputRels) : null;
//
//    if (sqlNode instanceof SqlIdentifier) {
//      return convertSqlIdentifier((SqlIdentifier) sqlNode, inputRel);
//    }
//
//    if (sqlNode instanceof SqlBasicCall) {
//      return convertSqlBasicCall((SqlBasicCall) sqlNode, inputRel);
//    }
//
//    if (sqlNode instanceof SqlLiteral) {
//      return convertSqlLiteral((SqlLiteral) sqlNode);
//    }
//
//    if (sqlNode instanceof SqlSelect) {
//      return convertSubqueryToRexNode((SqlSelect) sqlNode, inputRel);
//    }
//
//    throw new UnsupportedOperationException("Unsupported SQL node type for Rex conversion: " + sqlNode.getClass());
//  }
//
//  private RexNode convertSqlIdentifier(SqlIdentifier identifier, RelNode inputRel) {
//    // Check for correlation variable
//    if (correlationMap.containsKey(identifier.names.get(0))) {
//      return correlationMap.get(identifier.names.get(0));
//    }
//
//    // Find column index in input rel
//    String columnName = identifier.names.get(0);
//    int columnIndex = findColumnIndex(inputRel, columnName);
//
//    return rexBuilder.makeInputRef(inputRel, columnIndex);
//  }
//
//  private RexNode convertSqlBasicCall(SqlBasicCall call, RelNode inputRel) {
//    List<RexNode> operands = new ArrayList<>();
//
//    for (SqlNode operand : call.operands) {
//      operands.add(convertSqlToRexNode(operand, inputRel));
//    }
//
//    return rexBuilder.makeCall(
//        typeFactory.createSqlType(call.getOperator().getReturnType()),
//        call.getOperator(),
//        operands
//    );
//  }
//
//  private RexNode convertSqlLiteral(SqlLiteral literal) {
//    // Convert SQL literal to RexLiteral
//    return rexBuilder.makeLiteral(
//        literal.getValue(),
//        typeFactory.createSqlType(literal.getTypeName()),
//        false
//    );
//  }
//
//  private RexNode convertSubqueryToRexNode(SqlSelect subquery, RelNode correlatedRel) {
//    // Handle correlated subquery
//    RelNode subqueryRel = convertSqlNodeRecursive(subquery, correlatedRel);
//
//    // Convert subquery to a scalar subquery
//    return rexBuilder.makeSubQuery(
//        subqueryRel.getRowType(),
//        subqueryRel
//    );
//  }
//
//  private RelNode mergeRelNodes(RelNode... inputRels) {
//    if (inputRels.length == 1) {
//      return inputRels[0];
//    }
//
//    // Create a logical union of input rels
//    return LogicalUnion.create(
//        Arrays.asList(inputRels),
//        true // all inputs must have same row type
//    );
//  }
//
//  private JoinRelType determineJoinType(SqlOperator operator) {
//    if (operator == SqlStdOperatorTable.INNER_JOIN) return JoinRelType.INNER;
//    if (operator == SqlStdOperatorTable.LEFT_JOIN) return JoinRelType.LEFT;
//    if (operator == SqlStdOperatorTable.RIGHT_JOIN) return JoinRelType.RIGHT;
//    if (operator == SqlStdOperatorTable.FULL_JOIN) return JoinRelType.FULL;
//    throw new UnsupportedOperationException("Unsupported join type: " + operator);
//  }
//
//  private String deriveColumnName(SqlNode selectItem) {
//    if (selectItem instanceof SqlIdentifier) {
//      return ((SqlIdentifier) selectItem).names.get(0);
//    }
//    if (selectItem instanceof SqlBasicCall) {
//      return selectItem.toString();
//    }
//    return "expr";
//  }
//
//  private int findColumnIndex(RelNode inputRel, String columnName) {
//    RelDataType rowType = inputRel.getRowType();
//    for (int i = 0; i < rowType.getFieldCount(); i++) {
//      if (rowType.getFieldNames().get(i).equalsIgnoreCase(columnName)) {
//        return i;
//      }
//    }
//    throw new IllegalArgumentException("Column not found: " + columnName);
//  }
}