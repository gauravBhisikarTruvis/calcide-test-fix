package com.calcite_new.sql.parser.snowflake;

import com.calcite_new.sql.parser.antlr.SnowflakeSqlBaseVisitor;
import com.calcite_new.sql.parser.antlr.SnowflakeSqlParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.type.SqlTypeName;

import java.util.*;
import java.util.stream.Collectors;

public class SnowflakeSqlToCalciteVisitor extends SnowflakeSqlBaseVisitor<SqlNode> {

  /**
   * Maps Snowflake data type names to Calcite SqlTypeName enum values
   */
  private static final Map<String, SqlTypeName> TYPE_MAPPING = createTypeMapping();

  /**
   * Maps Snowflake data type prefixes to Calcite SqlTypeName for types that can include parameters
   */
  private static final Map<String, SqlTypeName> TYPE_PREFIX_MAPPING = createTypePrefixMapping();

  /**
   * Initializes the mapping from Snowflake type names to Calcite SqlTypeName enum values
   */
  private static Map<String, SqlTypeName> createTypeMapping() {

    return Map.ofEntries(
        // Exact numeric types
        Map.entry("INT", SqlTypeName.INTEGER),
        Map.entry("INTEGER", SqlTypeName.INTEGER),
        Map.entry("BIGINT", SqlTypeName.BIGINT),
        Map.entry("SMALLINT", SqlTypeName.SMALLINT),

        // Approximate numeric types
        Map.entry("FLOAT", SqlTypeName.FLOAT),
        Map.entry("FLOAT4", SqlTypeName.FLOAT),
        Map.entry("FLOAT8", SqlTypeName.FLOAT),
        Map.entry("DOUBLE", SqlTypeName.DOUBLE),
        Map.entry("DOUBLE PRECISION", SqlTypeName.DOUBLE),
        Map.entry("REAL", SqlTypeName.DOUBLE),

        // Text types
        Map.entry("TEXT", SqlTypeName.VARCHAR),

        // Boolean type
        Map.entry("BOOLEAN", SqlTypeName.BOOLEAN),

        // Date/time types
        Map.entry("DATE", SqlTypeName.DATE),

        // Snowflake-specific types
        Map.entry("VARIANT", SqlTypeName.ANY),
        Map.entry("OBJECT", SqlTypeName.MAP),
        Map.entry("ARRAY", SqlTypeName.ARRAY),
        Map.entry("GEOGRAPHY", SqlTypeName.VARCHAR),
        Map.entry("GEOMETRY", SqlTypeName.VARCHAR));
  }

  /**
   * Initializes the mapping from Snowflake type prefixes to Calcite SqlTypeName
   * for types that can include parameters (precision, scale, length, etc.)
   */
  private static Map<String, SqlTypeName> createTypePrefixMapping() {
    Map<String, SqlTypeName> map = new HashMap<>();

    // Numeric types with precision/scale
    map.put("NUMBER", SqlTypeName.DECIMAL);
    map.put("DECIMAL", SqlTypeName.DECIMAL);
    map.put("NUMERIC", SqlTypeName.DECIMAL);

    // String types with length
    map.put("VARCHAR", SqlTypeName.VARCHAR);
    map.put("CHAR", SqlTypeName.CHAR);
    map.put("CHARACTER", SqlTypeName.CHAR);
    map.put("STRING", SqlTypeName.VARCHAR);
    map.put("BINARY", SqlTypeName.BINARY);
    map.put("VARBINARY", SqlTypeName.VARBINARY);

    // Time/timestamp types with precision
    map.put("TIME", SqlTypeName.TIME);
    map.put("TIMESTAMP", SqlTypeName.TIMESTAMP);
    map.put("TIMESTAMP_LTZ", SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE);
    map.put("TIMESTAMP_NTZ", SqlTypeName.TIMESTAMP);
    map.put("TIMESTAMP_TZ", SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE);

    return Collections.unmodifiableMap(map);
  }

  // Helper method to create parser position
  private SqlParserPos pos() {
    return SqlParserPos.ZERO;
  }

  @Override
  public SqlNode visitSelectStatement(SnowflakeSqlParser.SelectStatementContext ctx) {
    SqlNode body = visit(ctx.selectCore());

    // Process WITH clause
    if (ctx.withClause() != null) {
      SqlNodeList withList = SqlNodeList.EMPTY;
      for (SnowflakeSqlParser.CommonTableExpressionContext cte : ctx.withClause().commonTableExpression()) {
        withList.add(visit(cte));
      }
      boolean recursive = ctx.withClause().RECURSIVE() != null;
      body = new SqlWith(pos(), withList, body);
    }

    // Process ORDER BY clause
    if (ctx.orderByClause() != null) {
      List<SqlNode> orderList = new ArrayList<>();
      for (SnowflakeSqlParser.OrderByItemContext item : ctx.orderByClause().orderByItem()) {
        orderList.add(visit(item));
      }
      body = new SqlOrderBy(pos(), body, SqlNodeList.of(pos(), orderList), null, null);
    }

    // Process LIMIT clause
    if (ctx.limitClause() != null) {
      List<SqlNode> expressions = ctx.limitClause().expression().stream()
          .map(this::visit)
          .collect(Collectors.toList());

      SqlNode offset = null;
      SqlNode fetch = visit(ctx.limitClause().expression(0));

      if (ctx.limitClause().OFFSET() != null) {
        offset = expressions.size() > 1 ? expressions.get(1) : null;
      }

      body = new SqlOrderBy(pos(), body, new SqlNodeList(Collections.emptyList(), pos()), offset, fetch);
    }

    return body;
  }

  @Override
  public SqlNode visitCommonTableExpression(SnowflakeSqlParser.CommonTableExpressionContext ctx) {
    SqlIdentifier name = new SqlIdentifier(ctx.identifier().getText(), pos());

    List<SqlNode> columnNames = new ArrayList<>();
    if (ctx.columnName() != null && !ctx.columnName().isEmpty()) {
      for (SnowflakeSqlParser.ColumnNameContext col : ctx.columnName()) {
        columnNames.add(new SqlIdentifier(col.getText(), pos()));
      }
    }

    SqlNode query = visit(ctx.selectStatement());
    return new SqlWithItem(pos(), name, new SqlNodeList(columnNames, pos()), query);
  }

  @Override
  public SqlNode visitSelectCore(SnowflakeSqlParser.SelectCoreContext ctx) {
    // Process SELECT list
    boolean distinct = false;
    if (ctx.setQuantifier() != null) {
      distinct = ctx.setQuantifier().DISTINCT() != null;
    }

    List<SqlNode> selectItems = new ArrayList<>();
    for (SnowflakeSqlParser.SelectItemContext item : ctx.selectList().selectItem()) {
      selectItems.add(visit(item));
    }
    SqlNodeList selectList = new SqlNodeList(selectItems, pos());

    // Process FROM clause
    SqlNode from = null;
    if (ctx.fromClause() != null) {
      from = visit(ctx.fromClause());
    }

    // Process WHERE clause
    SqlNode where = null;
    if (ctx.whereClause() != null) {
      where = visit(ctx.whereClause().expression());
    }

    // Process GROUP BY clause
    SqlNodeList groupBy = null;
    if (ctx.groupByClause() != null) {
      List<SqlNode> groupByItems = new ArrayList<>();
      for (SnowflakeSqlParser.GroupByItemContext item : ctx.groupByClause().groupByItem()) {
        groupByItems.add(visit(item));
      }
      groupBy = new SqlNodeList(groupByItems, pos());
    }

    // Process HAVING clause
    SqlNode having = null;
    if (ctx.havingClause() != null) {
      having = visit(ctx.havingClause().expression());
    }

    // Process WINDOW clause
    SqlNodeList windowDecls = null;
    if (ctx.windowClause() != null) {
      List<SqlNode> windowItems = new ArrayList<>();
      for (SnowflakeSqlParser.NamedWindowContext namedWindow : ctx.windowClause().namedWindow()) {
        windowItems.add(visit(namedWindow));
      }
      windowDecls = new SqlNodeList(windowItems, pos());
    }

    // Process QUALIFY clause
    SqlNode qualify = null;
    if (ctx.qualifyClause() != null) {
      qualify = visit(ctx.qualifyClause().expression());
    }

    return new SqlSelect(
        pos(),
        SqlNodeList.EMPTY,                     // HINTS
        selectList,
        from,
        where,
        groupBy,
        having,
        windowDecls,
        qualify,                   // QUALIFY
        null,                    // ORDER BY (handled at selectStatement level)
        null,                    // OFFSET
        null,                    // FETCH
        null                    // HINTS
    );
  }

  @Override
  public SqlNode visitSelectItem(SnowflakeSqlParser.SelectItemContext ctx) {
    if (ctx.getText().equals("*")) {
      return new SqlIdentifier("*", pos());
    } else if (ctx.getText().endsWith(".*")) {
      String tableName = ctx.tableName().getText();
      return new SqlIdentifier(Arrays.asList(tableName, "*"), pos());
    } else {
      SqlNode expr = visit(ctx.expression());

      if (ctx.columnAlias() != null) {
        SqlIdentifier alias = new SqlIdentifier(ctx.columnAlias().getText(), pos());
        return new SqlBasicCall(
            SqlStdOperatorTable.AS,
            new SqlNode[]{expr, alias},
            pos()
        );
      }

      return expr;
    }
  }

  @Override
  public SqlNode visitFromClause(SnowflakeSqlParser.FromClauseContext ctx) {
    if (ctx.tableExpression().size() == 1) {
      return visit(ctx.tableExpression(0));
    } else {
      // Multiple tables means we have implicit cross joins
      List<SqlNode> joins = new ArrayList<>();
      SqlNode left = visit(ctx.tableExpression(0));

      for (int i = 1; i < ctx.tableExpression().size(); i++) {
        SqlNode right = visit(ctx.tableExpression(i));
        left = new SqlJoin(
            pos(),
            left,
            SqlLiteral.createBoolean(false, pos()),
            JoinType.COMMA.symbol(pos()),
            right,
            SqlLiteral.createBoolean(false, pos()),
            null
        );
      }

      return left;
    }
  }

  @Override
  public SqlNode visitTableExpression(SnowflakeSqlParser.TableExpressionContext ctx) {
    SqlNode table = visit(ctx.tablePrimary());

    // Process JOINs
    if (ctx.joinClause() != null && !ctx.joinClause().isEmpty()) {
      for (SnowflakeSqlParser.JoinClauseContext joinCtx : ctx.joinClause()) {
        SqlNode right = visit(joinCtx.tableExpression());
        JoinType joinType = JoinType.INNER;

        if (joinCtx.joinType() != null) {
          if (joinCtx.joinType().CROSS() != null) {
            joinType = JoinType.CROSS;
          } else if (joinCtx.joinType().LEFT() != null) {
            joinType = JoinType.LEFT;
          } else if (joinCtx.joinType().RIGHT() != null) {
            joinType = JoinType.RIGHT;
          } else if (joinCtx.joinType().FULL() != null) {
            joinType = JoinType.FULL;
          }
        } else if (joinCtx.getText().startsWith(",")) {
          joinType = JoinType.COMMA;
        }

        boolean natural = joinCtx.NATURAL() != null;
        SqlNode condition = null;

        if (joinCtx.ON() != null) {
          condition = visit(joinCtx.expression());
        } else if (joinCtx.USING() != null) {
          List<SqlNode> usingColumns = new ArrayList<>();
          for (SnowflakeSqlParser.ColumnNameContext colName : joinCtx.columnName()) {
            usingColumns.add(new SqlIdentifier(colName.getText(), pos()));
          }
          condition = SqlNodeList.of(pos(), usingColumns);
        }

        table = new SqlJoin(
            pos(),
            table,
            SqlLiteral.createBoolean(natural, pos()),
            joinType.symbol(pos()),
            right,
            SqlLiteral.createBoolean(false, pos()),
            condition
        );
      }
    }

    return table;
  }

  @Override
  public SqlNode visitTablePrimary(SnowflakeSqlParser.TablePrimaryContext ctx) {
    SqlNode table;

    if (ctx.tableName() != null) {
      // Simple table reference
      String tableNameText = ctx.tableName().getText();
      List<String> parts = new ArrayList<>();
      if (ctx.tableName().schemaName() != null) {
        if (ctx.tableName().schemaName().databaseName() != null) {
          parts.add(ctx.tableName().schemaName().databaseName().identifier().getText());
        }
        parts.add(ctx.tableName().schemaName().identifier().getText());
      }
      parts.add(ctx.tableName().identifier().getText());

      table = new SqlIdentifier(parts, pos());
    } else if (ctx.selectStatement() != null) {
      // Subquery
      table = visit(ctx.selectStatement());
    } else if (ctx.tableFunctionCall() != null) {
      // Table function
      table = visit(ctx.tableFunctionCall());
    } else if (ctx.tableExpression() != null) {
      // Parenthesized table expression
      table = visit(ctx.tableExpression());
    } else {
      throw new UnsupportedOperationException("Unsupported table primary type");
    }

    // Apply alias if present
    if (ctx.tableAlias() != null) {
      String alias = ctx.tableAlias().getText();

      // Handle column aliases for table if present
      if (!ctx.columnAlias().isEmpty()) {
        List<SqlNode> columnAliases = new ArrayList<>();
        for (SnowflakeSqlParser.ColumnAliasContext colAlias : ctx.columnAlias()) {
          columnAliases.add(new SqlIdentifier(colAlias.getText(), pos()));
        }

        return new SqlBasicCall(
            SqlStdOperatorTable.AS,
            new SqlNode[]{
                table,
                new SqlIdentifier(alias, pos()),
                new SqlNodeList(columnAliases, pos())
            },
            pos()
        );
      } else {
        return new SqlBasicCall(
            SqlStdOperatorTable.AS,
            new SqlNode[]{table, new SqlIdentifier(alias, pos())},
            pos()
        );
      }
    }

    return table;
  }

  @Override
  public SqlNode visitTableFunctionCall(SnowflakeSqlParser.TableFunctionCallContext ctx) {
    String functionName = ctx.identifier().getText();
    List<SqlNode> args = new ArrayList<>();

    if (ctx.functionArgument() != null) {
      for (SnowflakeSqlParser.FunctionArgumentContext arg : ctx.functionArgument()) {
        args.add(visit(arg.expression()));
      }
    }

    return new SqlBasicCall(
        null,
//        new SqlIdentifier(functionName, pos()),
        List.of(new SqlNode[0]),
        pos()
    );
  }

  @Override
  public SqlNode visitWhereClause(SnowflakeSqlParser.WhereClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitGroupByItem(SnowflakeSqlParser.GroupByItemContext ctx) {
    if (ctx.expression() != null && ctx.expression().size() == 1) {
      return visit(ctx.expression(0));
    } else if (ctx.ROLLUP() != null) {
      List<SqlNode> exprs = new ArrayList<>();
      for (SnowflakeSqlParser.ExpressionContext expr : ctx.expression()) {
        exprs.add(visit(expr));
      }
      return new SqlBasicCall(
          SqlStdOperatorTable.ROLLUP,
          exprs.toArray(new SqlNode[0]),
          pos()
      );
    } else if (ctx.CUBE() != null) {
      List<SqlNode> exprs = new ArrayList<>();
      for (SnowflakeSqlParser.ExpressionContext expr : ctx.expression()) {
        exprs.add(visit(expr));
      }
      return new SqlBasicCall(
          SqlStdOperatorTable.CUBE,
          exprs.toArray(new SqlNode[0]),
          pos()
      );
    } else if (ctx.GROUPING() != null) {
      List<SqlNode> sets = new ArrayList<>();
      for (SnowflakeSqlParser.GroupingSetItemContext item : ctx.groupingSetItem()) {
        sets.add(visit(item));
      }
      return new SqlBasicCall(
          SqlStdOperatorTable.GROUPING_SETS,
          sets.toArray(new SqlNode[0]),
          pos()
      );
    }

    return null;
  }

  @Override
  public SqlNode visitGroupingSetItem(SnowflakeSqlParser.GroupingSetItemContext ctx) {
    if (ctx.expression() != null && ctx.expression().size() == 1) {
      return visit(ctx.expression(0));
    } else {
      List<SqlNode> exprs = new ArrayList<>();
      for (SnowflakeSqlParser.ExpressionContext expr : ctx.expression()) {
        exprs.add(visit(expr));
      }
      return SqlNodeList.of(pos(), exprs);
    }
  }

  @Override
  public SqlNode visitHavingClause(SnowflakeSqlParser.HavingClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitQualifyClause(SnowflakeSqlParser.QualifyClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitNamedWindow(SnowflakeSqlParser.NamedWindowContext ctx) {
    SqlIdentifier name = new SqlIdentifier(ctx.identifier().getText(), pos());
    SqlNode window = visit(ctx.windowSpecification());

    return new SqlBasicCall(
        SqlStdOperatorTable.AS,
        new SqlNode[]{name, window},
        pos()
    );
  }

  @Override
  public SqlNode visitWindowSpecification(SnowflakeSqlParser.WindowSpecificationContext ctx) {
    SqlNodeList partitionList = null;
    SqlNodeList orderList = null;
//    SqlWindow.FrameUnit frameUnit = null;
    SqlNode lowerBound = null;
    SqlNode upperBound = null;

    // Process PARTITION BY
    if (ctx.partitionByClause() != null) {
      List<SqlNode> partitions = new ArrayList<>();
      for (SnowflakeSqlParser.ExpressionContext expr : ctx.partitionByClause().expression()) {
        partitions.add(visit(expr));
      }
      partitionList = new SqlNodeList(partitions, pos());
    }

    // Process ORDER BY
    if (ctx.orderByClause() != null) {
      List<SqlNode> orders = new ArrayList<>();
      for (SnowflakeSqlParser.OrderByItemContext item : ctx.orderByClause().orderByItem()) {
        orders.add(visit(item));
      }
      orderList = new SqlNodeList(orders, pos());
    }

    // Process frame clause
    if (ctx.frameClause() != null) {
//      frameUnit = ctx.frameClause().ROWS() != null ? SqlWindow.FrameUnit.ROW : SqlWindow.FrameUnit.RANGE;

      if (ctx.frameClause().BETWEEN() != null) {
        lowerBound = visitFrameBound(ctx.frameClause().frameStart());
        upperBound = visitFrameBound(ctx.frameClause().frameEnd());
      } else {
        lowerBound = visitFrameBound(ctx.frameClause().frameStart());
        upperBound = SqlWindow.createCurrentRow(pos());
      }
    }

    // Create base window
//    SqlWindow window = new SqlWindow(
//        pos(),
//        ctx.identifier() != null ? new SqlIdentifier(ctx.identifier().getText(), pos()) : null,
//        partitionList,
//        orderList,
//        frameUnit,
//        lowerBound,
//        upperBound,
//        null  // allowPartial
//    );
//
//    return window;
    throw new UnsupportedOperationException("Window specification not supported.");
  }

  private SqlNode visitFrameBound(SnowflakeSqlParser.FrameStartContext ctx) {
    if (ctx.CURRENT() != null) {
      return SqlWindow.createCurrentRow(pos());
    } else if (ctx.UNBOUNDED() != null) {
      if (ctx.PRECEDING() != null) {
        return SqlWindow.createUnboundedPreceding(pos());
      } else {
        return SqlWindow.createUnboundedFollowing(pos());
      }
    } else {
      SqlNode offset = visit(ctx.expression());
      if (ctx.PRECEDING() != null) {
        return SqlWindow.createPreceding(offset, pos());
      } else {
        return SqlWindow.createFollowing(offset, pos());
      }
    }
  }

  private SqlNode visitFrameBound(SnowflakeSqlParser.FrameEndContext ctx) {
    if (ctx.CURRENT() != null) {
      return SqlWindow.createCurrentRow(pos());
    } else if (ctx.UNBOUNDED() != null) {
      if (ctx.PRECEDING() != null) {
        return SqlWindow.createUnboundedPreceding(pos());
      } else {
        return SqlWindow.createUnboundedFollowing(pos());
      }
    } else {
      SqlNode offset = visit(ctx.expression());
      if (ctx.PRECEDING() != null) {
        return SqlWindow.createPreceding(offset, pos());
      } else {
        return SqlWindow.createFollowing(offset, pos());
      }
    }
  }

  @Override
  public SqlNode visitOrderByItem(SnowflakeSqlParser.OrderByItemContext ctx) {
    SqlNode expr = visit(ctx.expression());
    SqlNode direction = ctx.DESC() != null ? SqlStdOperatorTable.DESC.createCall(pos(), expr) : null;

    if (ctx.NULLS() != null) {
      boolean nullsFirst = ctx.FIRST() != null;
      SqlNode nullsOrder = nullsFirst ?
          SqlStdOperatorTable.NULLS_FIRST.createCall(pos(), direction) :
          SqlStdOperatorTable.NULLS_LAST.createCall(pos(), direction);
      return nullsOrder;
    }

    return direction;
  }

  @Override
  public SqlNode visitExpression(SnowflakeSqlParser.ExpressionContext ctx) {
    // Handle literal expressions
    if (ctx.literal() != null) {
      return visit(ctx.literal());
    }

    // Handle column references
    if (ctx.columnReference() != null) {
      return visit(ctx.columnReference());
    }

    // Handle function calls
    if (ctx.functionCall() != null) {
      return visit(ctx.functionCall());
    }

    // Handle CASE expressions
    if (ctx.caseExpression() != null) {
      return visit(ctx.caseExpression());
    }

    // Handle parenthesized expressions
    if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
      return visit(ctx.expression(0));
    }

    // Handle binary operations
    if (ctx.binaryOperator() != null) {
      SqlOperator operator = getOperatorForBinaryOp(ctx.binaryOperator().getText());
      SqlNode left = visit(ctx.expression(0));
      SqlNode right = visit(ctx.expression(1));
      return new SqlBasicCall(operator, new SqlNode[]{left, right}, pos());
    }

    // Handle unary operations
    if (ctx.unaryOperator() != null) {
      SqlOperator operator = getOperatorForUnaryOp(ctx.unaryOperator().getText());
      SqlNode operand = visit(ctx.expression(0));
      return new SqlBasicCall(operator, new SqlNode[]{operand}, pos());
    }

    // Handle IS NULL
    if (ctx.IS() != null && ctx.NULL() != null) {
      SqlNode operand = visit(ctx.expression(0));
      SqlOperator op = ctx.NOT() != null ? SqlStdOperatorTable.IS_NOT_NULL : SqlStdOperatorTable.IS_NULL;
      return new SqlBasicCall(op, new SqlNode[]{operand}, pos());
    }

    // Handle BETWEEN
    if (ctx.BETWEEN() != null) {
      SqlNode value = visit(ctx.expression(0));
      SqlNode lower = visit(ctx.expression(1));
      SqlNode upper = visit(ctx.expression(2));
      SqlOperator op = ctx.NOT() != null ? SqlStdOperatorTable.NOT_BETWEEN : SqlStdOperatorTable.BETWEEN;
      return new SqlBasicCall(op, new SqlNode[]{value, lower, upper}, pos());
    }

    // Handle IN
    if (ctx.IN() != null) {
      SqlNode left = visit(ctx.expression(0));
      SqlOperator op = ctx.NOT() != null ? SqlStdOperatorTable.NOT_IN : SqlStdOperatorTable.IN;

      List<SqlNode> rhs = new ArrayList<>();
      if (ctx.selectStatement() != null) {
        // IN (subquery)
        rhs.add(visit(ctx.selectStatement()));
      } else if (ctx.tableName() != null) {
        // IN tableName
        rhs.add(visit(ctx.tableName()));
      } else {
        // IN (val1, val2, ...)
        for (int i = 1; i < ctx.expression().size(); i++) {
          rhs.add(visit(ctx.expression(i)));
        }
      }

      return new SqlBasicCall(op, new SqlNode[]{left, new SqlNodeList(rhs, pos())}, pos());
    }

    // Handle LIKE
    if (ctx.LIKE() != null || ctx.ILIKE() != null || ctx.SIMILAR() != null || ctx.RLIKE() != null) {
      SqlNode value = visit(ctx.expression(0));
      SqlNode pattern = visit(ctx.expression(1));
      SqlOperator op;

      if (ctx.LIKE() != null) {
        op = ctx.NOT() != null ? SqlStdOperatorTable.NOT_LIKE : SqlStdOperatorTable.LIKE;
      } else if (ctx.ILIKE() != null) {
        op = ctx.NOT() != null ?
            new SqlPrefixOperator("NOT ILIKE", SqlKind.OTHER, 0, null, null, null) :
            new SqlPrefixOperator("ILIKE", SqlKind.OTHER, 0, null, null, null);
      } else if (ctx.SIMILAR() != null) {
        op = ctx.NOT() != null ?
            new SqlPrefixOperator("NOT SIMILAR TO", SqlKind.OTHER, 0, null, null, null) :
            new SqlPrefixOperator("SIMILAR TO", SqlKind.OTHER, 0, null, null, null);
      } else {
        op = ctx.NOT() != null ?
            new SqlPrefixOperator("NOT RLIKE", SqlKind.OTHER, 0, null, null, null) :
            new SqlPrefixOperator("RLIKE", SqlKind.OTHER, 0, null, null, null);
      }

      List<SqlNode> operands = new ArrayList<>();
      operands.add(value);
      operands.add(pattern);

      if (ctx.ESCAPE() != null) {
        operands.add(visit(ctx.expression(2)));
      }

      return new SqlBasicCall(op, operands.toArray(new SqlNode[0]), pos());
    }

    // Handle EXISTS
    if (ctx.EXISTS() != null) {
      SqlNode subquery = visit(ctx.selectStatement());
      return new SqlBasicCall(
          SqlStdOperatorTable.EXISTS,
          new SqlNode[]{subquery},
          pos()
      );
    }

    // Handle CAST
    if (ctx.CAST() != null || ctx.TRY_CAST() != null) {
      SqlNode value = visit(ctx.expression(0));
      SqlDataTypeSpec dataType = getDataTypeSpec(ctx.dataType());
      SqlOperator op = ctx.TRY_CAST() != null ?
          new SqlPrefixOperator("TRY_CAST", SqlKind.CAST, 0, null, null, null) :
          SqlStdOperatorTable.CAST;

      return new SqlBasicCall(
          op,
          new SqlNode[]{value, dataType.withNullable(true)},
          pos()
      );
    }

    // Handle COLLATE
    if (ctx.COLLATE() != null) {
      SqlNode value = visit(ctx.expression(0));
      String collationName = ctx.collationName().getText();

//      return new SqlBasicCall(
//          SqlStdOperatorTable.COLLATE,
//          new SqlNode[]{value, new SqlIdentifier(collationName, pos())},
//          pos()
//      );
      throw new UnsupportedOperationException("COLLATE not supported.");
    }

    // Handle type conversion with ::
    if (ctx.getText().contains("::")) {
      SqlNode value = visit(ctx.expression(0));
      SqlDataTypeSpec dataType = getDataTypeSpec(ctx.dataType());

      return new SqlBasicCall(
          SqlStdOperatorTable.CAST,
          new SqlNode[]{value, dataType.withNullable(true)},
          pos()
      );
    }

    // Handle OVER for window functions
    if (ctx.OVER() != null) {
      SqlNode function = visit(ctx.expression(0));
      SqlNode window;

      if (ctx.windowName() != null) {
        window = new SqlIdentifier(ctx.windowName().getText(), pos());
      } else {
        window = visit(ctx.windowSpecification());
      }

      return new SqlBasicCall(
          SqlStdOperatorTable.OVER,
          new SqlNode[]{function, window},
          pos()
      );
    }

    // Unknown expression type
    throw new UnsupportedOperationException("Unsupported expression type: " + ctx.getText());
  }

  private SqlOperator getOperatorForBinaryOp(String op) {
    return switch (op) {
      case "||" -> SqlStdOperatorTable.CONCAT;
      case "*" -> SqlStdOperatorTable.MULTIPLY;
      case "/" -> SqlStdOperatorTable.DIVIDE;
      case "%" -> SqlStdOperatorTable.MOD;
      case "+" -> SqlStdOperatorTable.PLUS;
      case "-" -> SqlStdOperatorTable.MINUS;
      case "&" -> SqlStdOperatorTable.BIT_AND;
      case "|" -> SqlStdOperatorTable.BIT_OR;
      case "^" -> SqlStdOperatorTable.BIT_XOR;
      case "=", "==" -> SqlStdOperatorTable.EQUALS;
      case "!=", "<>" -> SqlStdOperatorTable.NOT_EQUALS;
      case "<" -> SqlStdOperatorTable.LESS_THAN;
      case "<=" -> SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
      case ">" -> SqlStdOperatorTable.GREATER_THAN;
      case ">=" -> SqlStdOperatorTable.GREATER_THAN_OR_EQUAL;
      case "AND" -> SqlStdOperatorTable.AND;
      case "OR" -> SqlStdOperatorTable.OR;
      default -> throw new UnsupportedOperationException("Unsupported binary operator: " + op);
    };
  }

  private SqlOperator getOperatorForUnaryOp(String op) {
    switch (op) {
      case "+":
        return SqlStdOperatorTable.UNARY_PLUS;
      case "-":
        return SqlStdOperatorTable.UNARY_MINUS;
//      case "~":
//        return SqlStdOperatorTable.BIT_NOT;
      case "NOT":
        return SqlStdOperatorTable.NOT;
      default:
        throw new UnsupportedOperationException("Unsupported unary operator: " + op);
    }
  }

  @Override
  public SqlNode visitColumnReference(SnowflakeSqlParser.ColumnReferenceContext ctx) {
    List<String> parts = new ArrayList<>();

    if (ctx.tableName() != null) {
      parts.add(ctx.tableName().getText());
    }

    parts.add(ctx.columnName().getText());

    return new SqlIdentifier(parts, pos());
  }

  @Override
  public SqlNode visitCaseExpression(SnowflakeSqlParser.CaseExpressionContext ctx) {
    if (ctx.simpleCaseExpression() != null) {
      return visit(ctx.simpleCaseExpression());
    } else {
      return visit(ctx.searchedCaseExpression());
    }
  }

  /*************************************************************************************************/

  /**
   * Extracts and converts a dataType context into a SqlDataTypeSpec object.
   * Uses maps for type mapping instead of if/else statements.
   *
   * @param ctx The dataType context from the ANTLR parser
   * @return A SqlDataTypeSpec object representing the data type
   */
  private SqlDataTypeSpec getDataTypeSpec(SnowflakeSqlParser.DataTypeContext ctx) {
    if (ctx == null) {
      return null;
    }

    // Create position for the entire context
    SqlParserPos pos = getParserPosition(ctx);
    List<SqlNode> parameters = new ArrayList<>();

    // Get the entire text to handle exact matches first
    String fullText = ctx.getText().toUpperCase();

    // Try exact match first
    SqlTypeName typeName = TYPE_MAPPING.get(fullText);

    // If no exact match, try prefix matching
    if (typeName == null) {
      for (Map.Entry<String, SqlTypeName> entry : TYPE_PREFIX_MAPPING.entrySet()) {
        if (fullText.startsWith(entry.getKey())) {
          typeName = entry.getValue();

          // Handle parameters based on type
          if (typeName == SqlTypeName.DECIMAL) {
            // Handle precision and scale for numeric types
            addPrecisionScaleParameters(ctx, parameters);
          } else if (typeName == SqlTypeName.VARCHAR || typeName == SqlTypeName.CHAR ||
              typeName == SqlTypeName.BINARY || typeName == SqlTypeName.VARBINARY) {
            // Handle length for string and binary types
            addLengthParameter(ctx, parameters);
          } else if (typeName == SqlTypeName.TIME || typeName == SqlTypeName.TIMESTAMP ||
              typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
            // Handle precision for time/timestamp types
            addLengthParameter(ctx, parameters);
          }

          break;
        }
      }
    }

    // If still no match, default to ANY
    if (typeName == null) {
      System.err.println("Unrecognized data type: " + fullText);
      typeName = SqlTypeName.ANY;
    }

    // Create and return the SqlDataTypeSpec
    return new SqlDataTypeSpec(
        new SqlBasicTypeNameSpec(typeName, pos),
        null,
        pos);
  }

  /**
   * Adds precision and scale parameters for numeric types
   */
  private void addPrecisionScaleParameters(SnowflakeSqlParser.DataTypeContext ctx, List<SqlNode> parameters) {
    if (!ctx.INTEGER_LITERAL().isEmpty()) {
      // Add precision
      String precision = ctx.INTEGER_LITERAL(0).getText();
      parameters.add(SqlLiteral.createExactNumeric(precision, getParserPosition(ctx.INTEGER_LITERAL(0))));

      // Add scale if specified
      if (ctx.INTEGER_LITERAL().size() >= 2) {
        String scale = ctx.INTEGER_LITERAL(1).getText();
        parameters.add(SqlLiteral.createExactNumeric(scale, getParserPosition(ctx.INTEGER_LITERAL(1))));
      }
    }
  }

  /**
   * Adds length parameter for string, binary, and time types
   */
  private void addLengthParameter(SnowflakeSqlParser.DataTypeContext ctx, List<SqlNode> parameters) {
    if (ctx.INTEGER_LITERAL().size() >= 1) {
      String length = ctx.INTEGER_LITERAL(0).getText();
      parameters.add(SqlLiteral.createExactNumeric(length, getParserPosition(ctx.INTEGER_LITERAL(0))));
    }
  }

  /**
   * Helper method to get parser position from a parse tree node
   */
  private SqlParserPos getParserPosition(ParserRuleContext ctx) {
    return new SqlParserPos(
        ctx.getStart().getLine(),
        ctx.getStart().getCharPositionInLine(),
        ctx.getStop().getLine(),
        ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length());
  }

  /**
   * Helper method to get parser position from a terminal node
   */
  private SqlParserPos getParserPosition(TerminalNode node) {
    return new SqlParserPos(
        node.getSymbol().getLine(),
        node.getSymbol().getCharPositionInLine(),
        node.getSymbol().getLine(),
        node.getSymbol().getCharPositionInLine() + node.getText().length());
  }

  /*************************************************************************************************/


}