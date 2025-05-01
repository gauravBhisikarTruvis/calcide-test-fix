package com.calcite_new.sql.parser;

import com.calcite_new.sql.parser.antlr.AnsiSqlBaseVisitor;
import com.calcite_new.sql.parser.antlr.AnsiSqlParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.util.ImmutableNullableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnsiSqlVisitor extends AnsiSqlBaseVisitor<SqlNode> {

  @Override
  public SqlNode visitSelectStatement(AnsiSqlParser.SelectStatementContext ctx) {
    SqlNode select = visit(ctx.selectList());
    if (select.getKind() == SqlKind.IDENTIFIER) {
      select = SqlNodeList.of(select);
    }
    SqlNodeList selectList = (SqlNodeList) select;
    SqlNode from = ctx.fromClause() != null ? visit(ctx.fromClause()) : null;
    SqlNode where = ctx.whereClause() != null ? visit(ctx.whereClause()) : null;
    SqlNodeList groupBy = ctx.groupByClause() != null ?
        (SqlNodeList) visit(ctx.groupByClause()) : null;
    SqlNode having = ctx.havingClause() != null ? visit(ctx.havingClause()) : null;
    SqlNodeList orderBy = ctx.orderByClause() != null ?
        (SqlNodeList) visit(ctx.orderByClause()) : null;
    SqlNode limitClause = ctx.limitClause() != null ? visit(ctx.limitClause()) : null;

    boolean isDistinct = ctx.distinct() != null &&
        ctx.distinct().DISTINCT() != null;

    return new SqlSelect(
        getPos(ctx),
        isDistinct ? SqlNodeList.of(SqlLiteral.createBoolean(true, SqlParserPos.ZERO))
            : SqlNodeList.EMPTY,
        selectList,
        from,
        where,
        groupBy,
        having,
        null, // window
        null, // qualify
        orderBy,
        null, // offset
        limitClause,  // fetch
        null // hints
    );
  }

  @Override
  public SqlNode visitSelectList(AnsiSqlParser.SelectListContext ctx) {
    List<SqlNode> selectElements = ctx.children.stream().map(this::visit).filter(Objects::nonNull).toList();
    return new SqlNodeList(selectElements, getPos(ctx));
  }

  @Override
  public SqlNode visitOrderByClause(AnsiSqlParser.OrderByClauseContext ctx) {
    List<SqlNode> orderByElements = ctx.children.stream().map(this::visit).filter(Objects::nonNull).toList();
    return new SqlNodeList(orderByElements, getPos(ctx));
  }

  @Override
  public SqlNode visitOrderByElement(AnsiSqlParser.OrderByElementContext ctx) {
    SqlNode exprNode = ctx.expr().accept(this);
    assert ctx.getChildCount() <= 2 : "ORDER BY with more than 2 args not supported.";
    if (ctx.getChildCount() == 2) {
      if (ctx.children.get(1).getText().equals(SqlStdOperatorTable.DESC.toString())) {
        return SqlStdOperatorTable.DESC.createCall(getPos(ctx), exprNode);
      }
    }
    return exprNode;
  }

  protected SqlParserPos getPos(ParserRuleContext ctx) {
    return new SqlParserPos(
        ctx.start.getLine(),
        ctx.start.getStartIndex(),
        ctx.stop.getLine(),
        ctx.stop.getStopIndex());
  }

  //  @Override
//  protected SqlNode defaultResult() {
//    return SqlNodeList.EMPTY;
//  }


  @Override
  public SqlNode visitGroupByClause(AnsiSqlParser.GroupByClauseContext ctx) {
    List<SqlNode> groupByElements = ctx.children.stream().map(this::visit).filter(Objects::nonNull).toList();
    return new SqlNodeList(groupByElements, SqlParserPos.ZERO);
  }

  @Override
  public SqlNode visitSelectElement(AnsiSqlParser.SelectElementContext ctx) {
    if (ctx.expr() == null) {
      return SqlIdentifier.star(SqlParserPos.ZERO);
    }
    return super.visitSelectElement(ctx);
  }

  @Override
  public SqlNode visitErrorNode(ErrorNode node) {
    throw new RuntimeException("Parser error: " + node.getText());
  }

  @Override
  public SqlNode visitTableSource(AnsiSqlParser.TableSourceContext ctx) {
    if (ctx.primaryTableSource() != null) {
      SqlNode primary = visit(ctx.primaryTableSource());
      if (ctx.joinPart().isEmpty()) {
        return primary;
      }

      SqlNode result = primary;
      for (AnsiSqlParser.JoinPartContext join : ctx.joinPart()) {
        SqlNode right = visit(join.primaryTableSource());
        SqlNode condition = join.ON() != null ? visit(join.expr()) : null;

        SqlLiteral joinType = SqlLiteral.createSymbol(
            getJoinType(join.joinType()),
            SqlParserPos.ZERO
        );

        result = new SqlJoin(
            SqlParserPos.ZERO,
            result,
            SqlLiteral.createBoolean(false, SqlParserPos.ZERO), // isNatural
            joinType,
            right,
            SqlLiteral.createSymbol(
                JoinConditionType.ON,
                SqlParserPos.ZERO
            ),
            condition
        );
      }
      return result;
    }
    return null;
  }

  @Override
  public SqlNode visitPrimaryTableSource(AnsiSqlParser.PrimaryTableSourceContext ctx) {
    if (ctx.tableName() != null) {
      String tableName = ctx.tableName().ID().getText();
      SqlIdentifier tableId = new SqlIdentifier(
          List.of(tableName),
          SqlParserPos.ZERO
      );

      if (ctx.alias() != null) {
        return new SqlBasicCall(
            SqlStdOperatorTable.AS,
            ImmutableNullableList.copyOf(new SqlNode[]{
                tableId,
                new SqlIdentifier(
                    ctx.alias().ID().getText(),
                    SqlParserPos.ZERO
                )
            }),
            SqlParserPos.ZERO,
            null // function qualifier
        );
      }
      return tableId;
    }
    return null;
  }

  @Override
  public SqlNode visitWhereClause(AnsiSqlParser.WhereClauseContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public SqlNode visitBinaryExpr(AnsiSqlParser.BinaryExprContext ctx) {
    SqlOperator operator = getOperator(ctx.op.getText());
    SqlNode left = visit(ctx.expr(0));
    SqlNode right = visit(ctx.expr(1));

    return new SqlBasicCall(
        operator,
        ImmutableNullableList.copyOf(new SqlNode[]{left, right}),
        SqlParserPos.ZERO
    );
  }

//  @Override
//  public SqlNode visitFunctionExpr(AnsiSqlParser.FunctionExprContext ctx) {
//    ctx.functionCall().functionName()
//    return super.visitFunctionExpr(ctx);
//  }


  @Override
  public SqlNode visitStar(AnsiSqlParser.StarContext ctx) {
    return SqlIdentifier.star(SqlParserPos.ZERO);
  }

  @Override
  public SqlNode visitFunctionCall(AnsiSqlParser.FunctionCallContext ctx) {
    // Get function name
    String functionName = ctx.functionName().ID().getText().toUpperCase();

    // Get function arguments
    List<SqlNode> args;
    if (ctx.star() != null) {
      args = List.of(ctx.star().accept(this));
    } else {
      args = ctx.expr().stream()
          .map(this::visit)
          .toList();
    }
    // Handle special functions
    return switch (functionName) {
      case "COUNT" -> new SqlBasicCall(
          SqlStdOperatorTable.COUNT,
          args,
          SqlParserPos.ZERO
      );
      case "SUM" -> new SqlBasicCall(
          SqlStdOperatorTable.SUM,
          args,
          SqlParserPos.ZERO
      );
      case "AVG" -> new SqlBasicCall(
          SqlStdOperatorTable.AVG,
          args,
          SqlParserPos.ZERO
      );
      case "MIN" -> new SqlBasicCall(
          SqlStdOperatorTable.MIN,
          args,
          SqlParserPos.ZERO
      );
      case "MAX" -> new SqlBasicCall(
          SqlStdOperatorTable.MAX,
          args,
          SqlParserPos.ZERO
      );
      case "UPPER" -> new SqlBasicCall(
          SqlStdOperatorTable.UPPER,
          args,
          SqlParserPos.ZERO
      );
      case "LOWER" -> new SqlBasicCall(
          SqlStdOperatorTable.LOWER,
          args,
          SqlParserPos.ZERO
      );
      case "SUBSTRING", "SUBSTR" -> new SqlBasicCall(
          SqlStdOperatorTable.SUBSTRING,
          args,
          SqlParserPos.ZERO
      );
      case "CONCAT" -> new SqlBasicCall(
          SqlStdOperatorTable.CONCAT,
          args,
          SqlParserPos.ZERO
      );
      default ->
        // For unknown functions, create a custom function operator
          new SqlBasicCall(
              new SqlUnresolvedFunction(
                  new SqlIdentifier(functionName, SqlParserPos.ZERO),
                  null,
                  null,
                  null,
                  null,
                  SqlFunctionCategory.USER_DEFINED_FUNCTION
              ),
              args,
              SqlParserPos.ZERO
          );
    };
  }

  @Override
  public SqlNode visitColumnRef(AnsiSqlParser.ColumnRefContext ctx) {
    List<String> names = new ArrayList<>();
    if (ctx.tableName() != null) {
      names.add(ctx.tableName().ID().getText());
    }
    names.add(ctx.columnName().ID().getText());
    return new SqlIdentifier(names, SqlParserPos.ZERO);
  }

  @Override
  public SqlNode visitLiteral(AnsiSqlParser.LiteralContext ctx) {
    if (ctx.STRING_LITERAL() != null) {
      String text = ctx.STRING_LITERAL().getText();
      // Remove quotes
      text = text.substring(1, text.length() - 1);
      return SqlLiteral.createCharString(text, SqlParserPos.ZERO);
    } else if (ctx.NUMBER() != null) {
      return SqlLiteral.createExactNumeric(
          ctx.NUMBER().getText(),
          SqlParserPos.ZERO
      );
    } else if (ctx.NULL() != null) {
      return SqlLiteral.createNull(SqlParserPos.ZERO);
    }
    return null;
  }

  private SqlOperator getOperator(String op) {
    return switch (op) {
      case "=" -> SqlStdOperatorTable.EQUALS;
      case "<>" -> SqlStdOperatorTable.NOT_EQUALS;
      case ">" -> SqlStdOperatorTable.GREATER_THAN;
      case "<" -> SqlStdOperatorTable.LESS_THAN;
      case ">=" -> SqlStdOperatorTable.GREATER_THAN_OR_EQUAL;
      case "<=" -> SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
      case "+" -> SqlStdOperatorTable.PLUS;
      case "-" -> SqlStdOperatorTable.MINUS;
      case "*" -> SqlStdOperatorTable.MULTIPLY;
      case "/" -> SqlStdOperatorTable.DIVIDE;
      default -> throw new UnsupportedOperationException("Operator not supported: " + op);
    };
  }

  private JoinType getJoinType(AnsiSqlParser.JoinTypeContext ctx) {
    if (ctx.INNER() != null) return JoinType.INNER;
    if (ctx.LEFT() != null) return JoinType.LEFT;
    if (ctx.RIGHT() != null) return JoinType.RIGHT;
    if (ctx.FULL() != null) return JoinType.FULL;
    if (ctx.CROSS() != null) return JoinType.CROSS;
    return JoinType.INNER; // default
  }
}
