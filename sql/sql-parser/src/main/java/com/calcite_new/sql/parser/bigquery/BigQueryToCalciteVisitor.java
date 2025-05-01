package com.calcite_new.sql.parser.bigquery;

import com.calcite_new.sql.parser.antlr.BigQuerySqlBaseVisitor;
import com.calcite_new.sql.parser.antlr.BigQuerySqlParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.type.InferTypes;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.validate.SqlUserDefinedAggFunction;
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
import org.apache.calcite.util.DateString;
import org.apache.calcite.util.Optionality;
import org.apache.calcite.util.TimeString;
import org.apache.calcite.util.TimestampString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.calcite.sql.SqlOperator.MDX_PRECEDENCE;

/**
 * Visitor to convert BigQuery SQL AST to Calcite {@link SqlNode}.
 */
public class BigQueryToCalciteVisitor extends BigQuerySqlBaseVisitor<SqlNode> {

  @Override
  public SqlNode visitSelectStatement(BigQuerySqlParser.SelectStatementContext ctx) {
    SqlNode query = visit(ctx.queryExpression());

    if (ctx.orderByClause() != null) {
      SqlNodeList orderList = (SqlNodeList) visit(ctx.orderByClause());
      query = new SqlOrderBy(parserPos(ctx), query, orderList, null,
          ctx.limitClause() != null ? visit(ctx.limitClause()) : null);
    } else if (ctx.limitClause() != null) {
      query = new SqlOrderBy(parserPos(ctx), query, SqlNodeList.EMPTY, null,
          visit(ctx.limitClause()));
    }

    if (ctx.withClause() != null) {
      SqlNodeList withList = (SqlNodeList) visit(ctx.withClause());
      query = new SqlWith(parserPos(ctx), withList, query);
    }

    return query;
  }

  @Override
  public SqlNode visitWithClause(BigQuerySqlParser.WithClauseContext ctx) {
    List<SqlNode> withItems = new ArrayList<>();
    for (BigQuerySqlParser.WithQueryItemContext itemCtx : ctx.withQueryItem()) {
      withItems.add(visit(itemCtx));
    }
    return new SqlNodeList(withItems, parserPos(ctx));
  }

  @Override
  public SqlNode visitWithQueryItem(BigQuerySqlParser.WithQueryItemContext ctx) {
    SqlNode query = visit(ctx.queryExpression());
    SqlIdentifier name = createIdentifier(ctx.identifier());
    return new SqlWithItem(parserPos(ctx), name, null, query);
  }

  @Override
  public SqlNode visitQueryExpression(BigQuerySqlParser.QueryExpressionContext ctx) {
    SqlNode right = visit(ctx.queryTerm());

    if (ctx.UNION() != null || ctx.EXCEPT() != null || ctx.INTERSECT() != null) {
      SqlKind kind;
      if (ctx.UNION() != null) {
        kind = SqlKind.UNION;
      } else if (ctx.EXCEPT() != null) {
        kind = SqlKind.EXCEPT;
      } else {
        kind = SqlKind.INTERSECT;
      }

      boolean isAll = ctx.ALL() != null;
      boolean isDistinct = ctx.DISTINCT() != null;

      SqlOperator operator;
      if (kind == SqlKind.UNION) {
        operator = isAll ? SqlStdOperatorTable.UNION_ALL : SqlStdOperatorTable.UNION;
      } else if (kind == SqlKind.EXCEPT) {
        operator = isAll ? SqlStdOperatorTable.EXCEPT_ALL : SqlStdOperatorTable.EXCEPT;
      } else {
        operator = isAll ? SqlStdOperatorTable.INTERSECT_ALL : SqlStdOperatorTable.INTERSECT;
      }

      SqlNode left = visit(ctx.queryExpression());
      return new SqlBasicCall(operator, List.of(left, right), parserPos(ctx));
    }

    return right;
  }

  @Override
  public SqlNode visitQueryTerm(BigQuerySqlParser.QueryTermContext ctx) {
    return visit(ctx.queryPrimary());
  }

  @Override
  public SqlNode visitQueryPrimary(BigQuerySqlParser.QueryPrimaryContext ctx) {
    if (ctx.simpleQuery() != null) {
      return visit(ctx.simpleQuery());
    } else {
      return visit(ctx.queryExpression());
    }
  }

  @Override
  public SqlNode visitSimpleQuery(BigQuerySqlParser.SimpleQueryContext ctx) {
    SqlNodeList selectList = (SqlNodeList) visit(ctx.selectClause());
    SqlNodeList keywordList = SqlNodeList.EMPTY;
    SqlNode from = null;
    SqlNode where = null;
    SqlNodeList groupBy = null;
    SqlNode having = null;
    SqlNode qualify = null;
    SqlNodeList windowList = null;

    if (ctx.selectClause().setQuantifier() != null) {
      TerminalNode distinct = ctx.selectClause().setQuantifier().DISTINCT();
      TerminalNode all = ctx.selectClause().setQuantifier().ALL();
      if (distinct != null) {
        keywordList = SqlNodeList.of(SqlLiteral.createSymbol(SetQualifier.DISTINCT, parserPos(distinct)));
      } else {
        keywordList = SqlNodeList.of(SqlLiteral.createSymbol(SetQualifier.ALL, parserPos(all)));
      }

    }

    if (ctx.fromClause() != null) {
      from = visit(ctx.fromClause());
    }

    if (ctx.whereClause() != null) {
      where = visit(ctx.whereClause());
    }

    if (ctx.groupByClause() != null) {
      groupBy = (SqlNodeList) visit(ctx.groupByClause());
    }

    if (ctx.havingClause() != null) {
      having = visit(ctx.havingClause());
    }

    if (ctx.qualifyClause() != null) {
      qualify = visit(ctx.qualifyClause());
    }

    if (ctx.windowClause() != null) {
      windowList = (SqlNodeList) visit(ctx.windowClause());
    }

    // Create a SQL select
    SqlNode query = new SqlSelect(
        parserPos(ctx),
        keywordList,                     // KEYWORD LIST
        selectList,
        from,
        where,
        groupBy,
        having,
        windowList,
        qualify,                   // QUALIFY
        null,                    // ORDER BY (handled at selectStatement level)
        null,                    // OFFSET
        null,                    // FETCH
        null                    // HINTS
    );

    if (ctx.orderByClause() != null) {
      SqlNodeList orderList = (SqlNodeList) visit(ctx.orderByClause());
      query = new SqlOrderBy(parserPos(ctx), query, orderList, null,
          ctx.limitClause() != null ? visit(ctx.limitClause()) : null);
    } else if (ctx.limitClause() != null) {
      query = new SqlOrderBy(parserPos(ctx), query, SqlNodeList.EMPTY, null,
          visit(ctx.limitClause()));
    }
    return query;
  }

  @Override
  public SqlNode visitSelectClause(BigQuerySqlParser.SelectClauseContext ctx) {
    List<SqlNode> selectItems = new ArrayList<>();
    for (BigQuerySqlParser.SelectItemContext itemCtx : ctx.selectItem()) {
      selectItems.add(visit(itemCtx));
    }

    return new SqlNodeList(selectItems, parserPos(ctx));
  }

  @Override
  public SqlNode visitSelectItem(BigQuerySqlParser.SelectItemContext ctx) {
    if (ctx.expression() != null) {
      SqlNode expr = visit(ctx.expression());
      if (ctx.identifier() != null) {
        SqlIdentifier alias = createIdentifier(ctx.identifier());
        return new SqlBasicCall(
            SqlStdOperatorTable.AS,
            List.of(expr, alias),
            parserPos(ctx)
        );
      }
      return expr;
    } else if (ctx.tableWildcard() != null) {
      return visit(ctx.tableWildcard());
    } else {
      // '*' wildcard
      return SqlIdentifier.star(parserPos(ctx));
    }
  }

  @Override
  public SqlNode visitTableWildcard(BigQuerySqlParser.TableWildcardContext ctx) {
    SqlIdentifier tableId = createIdentifier(ctx.tableIdentifier());
    return new SqlIdentifier(
        List.of(tableId.getSimple(), "*"),
        parserPos(ctx)
    );
  }

  @Override
  public SqlNode visitFromClause(BigQuerySqlParser.FromClauseContext ctx) {
    List<SqlNode> fromItems = new ArrayList<>();
    for (BigQuerySqlParser.TableExpressionContext tableCtx : ctx.tableExpression()) {
      fromItems.add(visit(tableCtx));
    }

    if (fromItems.size() == 1) {
      return fromItems.get(0);
    } else {
      // Handle multiple table expressions with a comma-separated list
      // In Calcite, this is represented as a join tree
      SqlNode result = fromItems.get(0);
      for (int i = 1; i < fromItems.size(); i++) {
        result = new SqlJoin(
            parserPos(ctx),
            result,
            SqlLiteral.createBoolean(false, parserPos(ctx)),  // isNatural
            SqlLiteral.createSymbol(JoinType.COMMA, parserPos(ctx)),
            fromItems.get(i),
            SqlLiteral.createSymbol(JoinConditionType.NONE, parserPos(ctx)),
            null  // Condition is null for comma join
        );
      }
      return result;
    }
  }

  @Override
  public SqlNode visitTableExpression(BigQuerySqlParser.TableExpressionContext ctx) {
//    if (ctx.tableFactor() != null) {
//      return visit(ctx.tableFactor());
//    } else {
      return visit(ctx.joinedTable());
//    }
  }

  @Override
  public SqlNode visitTableFactor(BigQuerySqlParser.TableFactorContext ctx) {
    SqlNode fromSource;

    if (ctx.queryExpression() != null) {
      // Subquery
      fromSource = new SqlBasicCall(
          SqlStdOperatorTable.AS,
          new SqlNode[]{
              visit(ctx.queryExpression()),
              createIdentifier(ctx.tableAlias().identifier())
          },
          parserPos(ctx)
      );
    } else if (ctx.tableExpression() != null) {
      // Parenthesized table expression
      fromSource = new SqlBasicCall(
          SqlStdOperatorTable.AS,
          new SqlNode[]{
              visit(ctx.tableExpression()),
              createIdentifier(ctx.tableAlias().identifier())
          },
          parserPos(ctx)
      );
    } else if (ctx.UNNEST() != null) {
      // UNNEST operation
      SqlNode unnestExpr = visit(ctx.expression());
      fromSource = new SqlBasicCall(
          new SqlUnresolvedFunction(
              new SqlIdentifier("UNNEST", parserPos(ctx)),
              null,
              null,
              null,
              null,
              SqlFunctionCategory.USER_DEFINED_FUNCTION
          ),
          List.of(unnestExpr),
          parserPos(ctx)
      );

      if (ctx.tableAlias() != null) {
        fromSource = new SqlBasicCall(
            SqlStdOperatorTable.AS,
            new SqlNode[]{
                fromSource,
                createIdentifier(ctx.tableAlias().identifier())
            },
            parserPos(ctx)
        );
      }

      // Handle WITH OFFSET
      if (ctx.WITH() != null) {
        SqlIdentifier offsetAlias;
        if (ctx.identifier() != null) {
          offsetAlias = createIdentifier(ctx.identifier());
        } else {
          offsetAlias = new SqlIdentifier("offset", parserPos(ctx));
        }

        fromSource = new SqlBasicCall(
            new SqlUnresolvedFunction(
                new SqlIdentifier("WITH OFFSET", parserPos(ctx)),
                null,
                null,
                null,
                null,
                SqlFunctionCategory.USER_DEFINED_FUNCTION
            ),
            new SqlNode[]{fromSource, offsetAlias},
            parserPos(ctx)
        );
      }
    } else if (ctx.functionCall() != null) {
      // Function as a table
      fromSource = visit(ctx.functionCall());

      if (ctx.tableAlias() != null) {
        fromSource = new SqlBasicCall(
            SqlStdOperatorTable.AS,
            new SqlNode[]{
                fromSource,
                createIdentifier(ctx.tableAlias().identifier())
            },
            parserPos(ctx)
        );
      }
    } else {
      // Regular table reference
      SqlNode tableRef;

      // Check if we have a multi-part table identifier
      if (ctx.tableIdentifier().size() == 2) {
        // database.table format
        SqlIdentifier dbId = createIdentifier(ctx.tableIdentifier(0));
        SqlIdentifier tableId = createIdentifier(ctx.tableIdentifier(1));
        tableRef = new SqlIdentifier(
            List.of(dbId.getSimple(), tableId.getSimple()),
            parserPos(ctx)
        );
      } else {
        // Simple table name
        tableRef = createIdentifier(ctx.tableIdentifier(0));
      }

      // Handle table alias if present
      if (ctx.tableAlias() != null) {
        SqlIdentifier alias = createIdentifier(ctx.tableAlias().identifier());

        // Check if column aliases are provided
        if (ctx.tableAlias().columnAlias() != null) {
          List<SqlNode> columnAliases = new ArrayList<>();
          for (BigQuerySqlParser.IdentifierContext idCtx :
              ctx.tableAlias().columnAlias().identifier()) {
            columnAliases.add(createIdentifier(idCtx));
          }

          fromSource = new SqlBasicCall(
              SqlStdOperatorTable.AS,
              new SqlNode[]{tableRef, alias, new SqlNodeList(columnAliases, parserPos(ctx))},
              parserPos(ctx)
          );
        } else {
          fromSource = new SqlBasicCall(
              SqlStdOperatorTable.AS,
              new SqlNode[]{tableRef, alias},
              parserPos(ctx)
          );
        }
      } else {
        fromSource = tableRef;
      }
    }

    return fromSource;
  }

  @Override
  public SqlNode visitJoinedTable(BigQuerySqlParser.JoinedTableContext ctx) {
    if (ctx.tableFactor() != null) {
      return visit(ctx.tableFactor());
    }

    SqlNode left = visit(ctx.joinedTable());
    SqlNode right = visit(ctx.tableExpression());

    // Determine join type
    JoinType joinType = JoinType.INNER;
    if (ctx.joinType() != null) {
      if (ctx.joinType().CROSS() != null) {
        joinType = JoinType.CROSS;
      } else if (ctx.joinType().FULL() != null) {
        joinType = JoinType.FULL;
      } else if (ctx.joinType().LEFT() != null) {
        joinType = JoinType.LEFT;
      } else if (ctx.joinType().RIGHT() != null) {
        joinType = JoinType.RIGHT;
      }
    }

    JoinConditionType conditionType = JoinConditionType.NONE;
    SqlNode condition = null;

    if (ctx.joinSpecification() != null) {
      if (ctx.joinSpecification().ON() != null) {
        conditionType = JoinConditionType.ON;
        condition = visit(ctx.joinSpecification().expression());
      } else if (ctx.joinSpecification().USING() != null) {
        conditionType = JoinConditionType.USING;
        List<SqlNode> usingColumns = new ArrayList<>();
        for (BigQuerySqlParser.IdentifierContext idCtx :
            ctx.joinSpecification().identifier()) {
          usingColumns.add(createIdentifier(idCtx));
        }
        condition = new SqlNodeList(usingColumns, parserPos(ctx));
      }
    }

    return new SqlJoin(
        parserPos(ctx),
        left,
        SqlLiteral.createBoolean(false, parserPos(ctx)),  // isNatural
        SqlLiteral.createSymbol(joinType, parserPos(ctx)),
        right,
        SqlLiteral.createSymbol(conditionType, parserPos(ctx)),
        condition
    );
  }

  @Override
  public SqlNode visitWhereClause(BigQuerySqlParser.WhereClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitGroupByClause(BigQuerySqlParser.GroupByClauseContext ctx) {
    List<SqlNode> groupingElements = new ArrayList<>();
    for (BigQuerySqlParser.GroupingElementContext elemCtx : ctx.groupingElement()) {
      groupingElements.add(visit(elemCtx));
    }

    return new SqlNodeList(groupingElements, parserPos(ctx));
  }

  @Override
  public SqlNode visitGroupingElement(BigQuerySqlParser.GroupingElementContext ctx) {
    if (ctx.expression() != null) {
      return ctx.expression().stream().map(this::visit).toList().get(0);
    } else if (ctx.ROLLUP() != null) {
      List<SqlNode> rollupItems = new ArrayList<>();
      for (BigQuerySqlParser.ExpressionContext exprCtx : ctx.expression()) {
        rollupItems.add(visit(exprCtx));
      }

      return new SqlBasicCall(
          SqlStdOperatorTable.ROLLUP,
          rollupItems.toArray(new SqlNode[0]),
          parserPos(ctx)
      );
    } else if (ctx.CUBE() != null) {
      List<SqlNode> cubeItems = new ArrayList<>();
      for (BigQuerySqlParser.ExpressionContext exprCtx : ctx.expression()) {
        cubeItems.add(visit(exprCtx));
      }

      return new SqlBasicCall(
          SqlStdOperatorTable.CUBE,
          cubeItems.toArray(new SqlNode[0]),
          parserPos(ctx)
      );
    } else if (ctx.GROUPING() != null) {
      // GROUPING SETS
      List<SqlNode> groupingSets = new ArrayList<>();
      for (BigQuerySqlParser.GroupingSetContext setCtx : ctx.groupingSet()) {
        groupingSets.add(visit(setCtx));
      }

      return new SqlBasicCall(
          SqlStdOperatorTable.GROUPING_SETS,
          groupingSets.toArray(new SqlNode[0]),
          parserPos(ctx)
      );
    }

    throw new UnsupportedOperationException("Unsupported grouping element");
  }

  @Override
  public SqlNode visitGroupingSet(BigQuerySqlParser.GroupingSetContext ctx) {
    List<SqlNode> items = new ArrayList<>();
    if (ctx.expression() != null) {
      for (BigQuerySqlParser.ExpressionContext exprCtx : ctx.expression()) {
        items.add(visit(exprCtx));
      }
    }

    return new SqlBasicCall(SqlStdOperatorTable.ROW, items, parserPos(ctx));
  }

  @Override
  public SqlNode visitHavingClause(BigQuerySqlParser.HavingClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitQualifyClause(BigQuerySqlParser.QualifyClauseContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public SqlNode visitWindowClause(BigQuerySqlParser.WindowClauseContext ctx) {
    List<SqlNode> windowList = new ArrayList<>();
    for (BigQuerySqlParser.NamedWindowContext winCtx : ctx.namedWindow()) {
      windowList.add(visit(winCtx));
    }

    return new SqlNodeList(windowList, parserPos(ctx));
  }

  @Override
  public SqlNode visitNamedWindow(BigQuerySqlParser.NamedWindowContext ctx) {
    SqlWindow namedWindow = (SqlWindow) visit(ctx.windowSpecification());
    SqlIdentifier name = createIdentifier(ctx.identifier());
    if (name != null) {
      namedWindow.setDeclName(name);
    }
    return namedWindow;
  }

  @Override
  public SqlNode visitWindowSpecification(BigQuerySqlParser.WindowSpecificationContext ctx) {
//    SqlWindow window = new SqlWindow(parserPos(ctx), null, null, null, null, null, null);
    SqlIdentifier declName = null;
    SqlNodeList orderList = SqlNodeList.EMPTY;
    SqlNodeList partitionList = SqlNodeList.EMPTY;

    if (ctx.windowName() != null) {
      declName = createIdentifier(ctx.windowName().identifier());
    }

    if (ctx.partitionClause() != null) {
      List<SqlNode> partitionItems = new ArrayList<>();
      for (BigQuerySqlParser.ExpressionContext exprCtx : ctx.partitionClause().expression()) {
        partitionItems.add(visit(exprCtx));
      }
      partitionList = new SqlNodeList(partitionItems, parserPos(ctx));
    }

    if (ctx.orderByClause() != null) {
      orderList = (SqlNodeList) visit(ctx.orderByClause());
    }

    if (ctx.frameClause() != null) {
      throw new UnsupportedOperationException("frameClause not supported");
//      SqlLiteral frameType = null;
//      SqlNode start = null;
//      SqlNode end = null;
//
//      // Frame type (ROWS or RANGE)
//      if (ctx.frameClause().frameUnits().ROWS() != null) {
//        frameType = SqlLiteral.createSymbol(FrameUnit.ROWS, parserPos(ctx));
//      } else {
//        frameType = SqlLiteral.createSymbol(FrameUnit.RANGE, parserPos(ctx));
//      }
//
//      // Frame extent
//      BigQuerySqlParser.FrameExtentContext extentCtx = ctx.frameClause().frameExtent();
//
//      // Frame start
//      start = visit(extentCtx.frameStart());
//
//      // Frame end (if present)
//      if (extentCtx.frameEnd() != null) {
//        end = visit(extentCtx.frameEnd());
//      } else {
//        // If no end is specified, use CURRENT ROW as default (same as start for bounds)
//        end = start;
//      }
//
//      window = window.over(frameType, start, end);
    }
    SqlLiteral isRows = SqlLiteral.createSymbol(FrameUnit.FALSE, parserPos(ctx));
    return new SqlWindow(parserPos(ctx), declName, null, partitionList, orderList, isRows, null, null, null);
  }

  @Override
  public SqlNode visitFrameStart(BigQuerySqlParser.FrameStartContext ctx) {
    if (ctx.UNBOUNDED() != null && ctx.PRECEDING() != null) {
      return SqlWindow.createUnboundedPreceding(parserPos(ctx));
    } else if (ctx.CURRENT() != null && ctx.ROW() != null) {
      return SqlWindow.createCurrentRow(parserPos(ctx));
    } else if (ctx.expression() != null && ctx.PRECEDING() != null) {
      SqlNode offset = visit(ctx.expression());
      return SqlWindow.createPreceding(offset, parserPos(ctx));
    } else if (ctx.expression() != null && ctx.FOLLOWING() != null) {
      SqlNode offset = visit(ctx.expression());
      return SqlWindow.createFollowing(offset, parserPos(ctx));
    } else if (ctx.UNBOUNDED() != null && ctx.FOLLOWING() != null) {
      return SqlWindow.createUnboundedFollowing(parserPos(ctx));
    }

    throw new UnsupportedOperationException("Unsupported frame start");
  }

  @Override
  public SqlNode visitFrameEnd(BigQuerySqlParser.FrameEndContext ctx) {
    if (ctx.UNBOUNDED() != null && ctx.PRECEDING() != null) {
      return SqlWindow.createUnboundedPreceding(parserPos(ctx));
    } else if (ctx.CURRENT() != null && ctx.ROW() != null) {
      return SqlWindow.createCurrentRow(parserPos(ctx));
    } else if (ctx.expression() != null && ctx.PRECEDING() != null) {
      SqlNode offset = visit(ctx.expression());
      return SqlWindow.createPreceding(offset, parserPos(ctx));
    } else if (ctx.expression() != null && ctx.FOLLOWING() != null) {
      SqlNode offset = visit(ctx.expression());
      return SqlWindow.createFollowing(offset, parserPos(ctx));
    } else if (ctx.UNBOUNDED() != null && ctx.FOLLOWING() != null) {
      return SqlWindow.createUnboundedFollowing(parserPos(ctx));
    }

    throw new UnsupportedOperationException("Unsupported frame end");
  }

  @Override
  public SqlNode visitOrderByClause(BigQuerySqlParser.OrderByClauseContext ctx) {
    List<SqlNode> orderItems = new ArrayList<>();
    for (BigQuerySqlParser.OrderingItemContext itemCtx : ctx.orderingItem()) {
      orderItems.add(visit(itemCtx));
    }

    return new SqlNodeList(orderItems, parserPos(ctx));
  }

  @Override
  public SqlNode visitOrderingItem(BigQuerySqlParser.OrderingItemContext ctx) {
    SqlNode expr = visit(ctx.expression());
    boolean ascending = ctx.DESC() == null; // Default is ASC if not specified
    expr = ascending ? expr : new SqlBasicCall(SqlStdOperatorTable.DESC, List.of(expr), parserPos(ctx));

    if (ctx.NULLS() == null) {
      return expr;
    }
    
    if (ctx.FIRST() != null) {
      return SqlStdOperatorTable.NULLS_FIRST.createCall(parserPos(ctx), expr);
    } else {
      return SqlStdOperatorTable.NULLS_LAST.createCall(parserPos(ctx), expr);
    }
  }

  @Override
  public SqlNode visitLimitClause(BigQuerySqlParser.LimitClauseContext ctx) {
    return visit(ctx.expression());
  }

  private SqlIdentifier createIdentifier(BigQuerySqlParser.TableIdentifierContext ctx) {
    return createIdentifier(ctx.identifier());
  }

  // Helper methods
  private SqlIdentifier createIdentifier(BigQuerySqlParser.IdentifierContext ctx) {
    if (ctx == null) {
      return null;
    }

    String identifierText;
    if (ctx.IDENTIFIER() != null) {
      identifierText = ctx.IDENTIFIER().getText();
    } else if (ctx.BACKTICK_IDENTIFIER() != null) {
      // Remove backticks
      identifierText = ctx.BACKTICK_IDENTIFIER().getText();
      identifierText = identifierText.substring(1, identifierText.length() - 1);
      // Handle escaped backticks
      identifierText = identifierText.replace("``", "`");
    } else if (ctx.QUOTED_IDENTIFIER() != null) {
      // Remove quotes
      identifierText = ctx.QUOTED_IDENTIFIER().getText();
      identifierText = identifierText.substring(1, identifierText.length() - 1);
      // Handle escaped quotes
      identifierText = identifierText.replace("\"\"", "\"");
    } else if (ctx.nonReservedKeyword() != null) {
      identifierText = ctx.getText();
    } else {
      throw new IllegalArgumentException("Unsupported identifier type");
    }

    return new SqlIdentifier(identifierText, parserPos(ctx));
  }
  
    @Override
    public SqlNode visitExpression(BigQuerySqlParser.ExpressionContext ctx) {
      if (ctx.literal() != null) {
        return visit(ctx.literal());
      } else if (ctx.columnReference() != null) {
        return visit(ctx.columnReference());
      } else if (ctx.functionCall() != null) {
        return visit(ctx.functionCall());
      } else if (ctx.caseExpression() != null) {
        return visit(ctx.caseExpression());
      } else if (ctx.castExpression() != null) {
        return visit(ctx.castExpression());
      } else if (ctx.arrayExpression() != null) {
        return visit(ctx.arrayExpression());
      } else if (ctx.structExpression() != null) {
        return visit(ctx.structExpression());
      } else if (ctx.EXISTS() != null) {
        SqlNode subQuery = visit(ctx.queryExpression());
        return SqlStdOperatorTable.EXISTS.createCall(parserPos(ctx), subQuery);
      } else if (ctx.ALL() != null || ctx.SOME() != null || ctx.ANY() != null) {
        SqlNode subQuery = visit(ctx.queryExpression());
        throw new UnsupportedOperationException("Unsupported quantified comparison");
//        SqlQuantifyOperator.Quantifier quantifier;
//        if (ctx.ALL() != null) {
//          quantifier = SqlQuantifyOperator.Quantifier.ALL;
//        } else if (ctx.SOME() != null) {
//          quantifier = SqlQuantifyOperator.Quantifier.SOME;
//        } else {
//          quantifier = SqlQuantifyOperator.Quantifier.ANY;
//        }
//        return new SqlQuantifyOperator(quantifier, parserPos(ctx)).createCall(parserPos(ctx), subQuery);
      } else if (ctx.comparisonOperator() != null && (ctx.ALL() != null || ctx.SOME() != null || ctx.ANY() != null)) {
        SqlNode left = visit(ctx.expression(0));
        SqlNode right = visit(ctx.queryExpression());
        throw new UnsupportedOperationException("Unsupported quantified comparison");
//        SqlQuantifyOperator.Quantifier quantifier;
//        if (ctx.ALL() != null) {
//          quantifier = SqlQuantifyOperator.Quantifier.ALL;
//        } else if (ctx.SOME() != null) {
//          quantifier = SqlQuantifyOperator.Quantifier.SOME;
//        } else {
//          quantifier = SqlQuantifyOperator.Quantifier.ANY;
//        }
//        SqlOperator operator = getComparisonOperator(ctx.comparisonOperator());
//        return new SqlQuantifiedComparisonOperator(operator, quantifier, parserPos(ctx)).createCall(parserPos(ctx), left, right);
      } else if (ctx.queryExpression() != null/* && ctx.queryExpression().si == 1 */&& ctx.expression().isEmpty()) {
        // Subquery expression
        return visit(ctx.queryExpression());
      } else if (ctx.expression().size() == 1 && ctx.getChildCount() == 3
          && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
        // Parenthesized expression
        return visit(ctx.expression(0));
      } else if (ctx.IS() != null) {
        SqlNode operand = visit(ctx.expression(0));
        if (ctx.NOT() != null) {
          return SqlStdOperatorTable.IS_NOT_NULL.createCall(parserPos(ctx), operand);
        } else {
          return SqlStdOperatorTable.IS_NULL.createCall(parserPos(ctx), operand);
        }
      } else if (ctx.NOT() != null && ctx.expression().size() == 1) {
        return SqlStdOperatorTable.NOT.createCall(parserPos(ctx), visit(ctx.expression(0)));
      } else if (ctx.AND() != null) {
        return SqlStdOperatorTable.AND.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.OR() != null) {
        return SqlStdOperatorTable.OR.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.LIKE() != null) {
        SqlNode operand = visit(ctx.expression(0));
        SqlNode pattern = visit(ctx.expression(1));
        return SqlStdOperatorTable.LIKE.createCall(parserPos(ctx), operand, pattern);
      } else if (ctx.BETWEEN() != null) {
        SqlNode operand = visit(ctx.expression(0));
        SqlNode lower = visit(ctx.expression(1));
        SqlNode upper = visit(ctx.expression(2));
        return SqlStdOperatorTable.BETWEEN.createCall(parserPos(ctx), operand, lower, upper);
      } else if (ctx.IN() != null) {
        SqlNode operand = visit(ctx.expression(0));
        SqlNode inList = visit(ctx.inPredicateValue());
        if (ctx.NOT() != null) {
          return SqlStdOperatorTable.NOT_IN.createCall(parserPos(ctx), operand, inList);
        } else {
          return SqlStdOperatorTable.IN.createCall(parserPos(ctx), operand, inList);
        }
      } else if (ctx.comparisonOperator() != null) {
        SqlNode left = visit(ctx.expression(0));
        SqlNode right = visit(ctx.expression(1));
        SqlOperator operator = getComparisonOperator(ctx.comparisonOperator());
        return operator.createCall(parserPos(ctx), left, right);
      } else if (ctx.COLLATE() != null) {
        SqlNode expr = visit(ctx.expression(0));
        SqlIdentifier collation = new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
        throw new UnsupportedOperationException("Unsupported collation");
//        return SqlStdOperatorTable.COLLATE.createCall(parserPos(ctx), expr, collation);
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("||")) {
        return SqlStdOperatorTable.CONCAT.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("+")) {
        return SqlStdOperatorTable.PLUS.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("-")) {
        return SqlStdOperatorTable.MINUS.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("*")) {
        return SqlStdOperatorTable.MULTIPLY.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("/")) {
        return SqlStdOperatorTable.DIVIDE.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 3 && ctx.getChild(1).getText().equals("%")) {
        return SqlStdOperatorTable.MOD.createCall(parserPos(ctx), visit(ctx.expression(0)), visit(ctx.expression(1)));
      } else if (ctx.getChildCount() >= 2 && ctx.getChild(0).getText().equals("-") && ctx.expression().size() == 1) {
        return SqlStdOperatorTable.UNARY_MINUS.createCall(parserPos(ctx), visit(ctx.expression(0)));
      } else if (ctx.getChildCount() >= 2 && ctx.getChild(0).getText().equals("+") && ctx.expression().size() == 1) {
        return SqlStdOperatorTable.UNARY_PLUS.createCall(parserPos(ctx), visit(ctx.expression(0)));
      } else if (ctx.getChildCount() >= 5 && ctx.getChild(1).getText().equals("?") && ctx.getChild(3).getText().equals(":")) {
        // Ternary operator expression(?:)
        SqlNode condition = visit(ctx.expression(0));
        SqlNode thenExpr = visit(ctx.expression(1));
        SqlNode elseExpr = visit(ctx.expression(2));
        return SqlStdOperatorTable.CASE.createCall(parserPos(ctx), condition, thenExpr, elseExpr);
      }

      throw new UnsupportedOperationException("Unsupported expression: " + ctx.getText());
    }

    @Override
    public SqlNode visitInPredicateValue(BigQuerySqlParser.InPredicateValueContext ctx) {
      if (!ctx.expression().isEmpty()) {
        List<SqlNode> values = ctx.expression().stream()
            .map(this::visit)
            .collect(Collectors.toList());
        return SqlStdOperatorTable.ROW.createCall(parserPos(ctx), values);
      } else if (ctx.queryExpression() != null) {
        return visit(ctx.queryExpression());
      } else if (ctx.UNNEST() != null) {
        return new SqlUnnestOperator(false).createCall(parserPos(ctx), visit(ctx.expression(0)));
      }
      return SqlStdOperatorTable.ROW.createCall(parserPos(ctx));
    }

    @Override
    public SqlNode visitCaseExpression(BigQuerySqlParser.CaseExpressionContext ctx) {
      if (ctx.simpleCaseExpression() != null) {
        return visit(ctx.simpleCaseExpression());
      } else {
        return visit(ctx.searchedCaseExpression());
      }
    }

    @Override
    public SqlNode visitSimpleCaseExpression(BigQuerySqlParser.SimpleCaseExpressionContext ctx) {
      SqlNode value = visit(ctx.expression(0));

      List<SqlNode> operands = new ArrayList<>();
      operands.add(null); // First operand is null for a simple CASE
      operands.add(value);

      for (int i = 0; i < ctx.WHEN().size(); i++) {
        operands.add(visit(ctx.expression(i * 2 + 1))); // When expression
        operands.add(visit(ctx.expression(i * 2 + 2))); // Then expression
      }

      if (ctx.ELSE() != null) {
        operands.add(visit(ctx.expression().get(ctx.expression().size() - 1))); // Else expression
      }

      return SqlStdOperatorTable.CASE.createCall(parserPos(ctx), operands);
    }

    @Override
    public SqlNode visitSearchedCaseExpression(BigQuerySqlParser.SearchedCaseExpressionContext ctx) {
      List<SqlNode> operands = new ArrayList<>();
      operands.add(null); // First operand is null for a searched CASE

      for (int i = 0; i < ctx.WHEN().size(); i++) {
        operands.add(visit(ctx.expression(i * 2))); // When expression
        operands.add(visit(ctx.expression(i * 2 + 1))); // Then expression
      }

      if (ctx.ELSE() != null) {
        operands.add(visit(ctx.expression().get(ctx.expression().size() - 1))); // Else expression
      }

      return new SqlOperator("CASE", SqlKind.CASE, MDX_PRECEDENCE, true, null,
          InferTypes.RETURN_TYPE, null) {
        @Override
        public SqlSyntax getSyntax() {
          return SqlSyntax.SPECIAL;
        }

        @Override
        public void unparse(SqlWriter writer, SqlCall call, int leftPrec, int rightPrec) {
          writer.newlineAndIndent();
          final SqlWriter.Frame frame =
              writer.startList(SqlWriter.FrameTypeEnum.CASE, "CASE", "END");
          for (int i = 1; i + 1 < call.operandCount(); i += 2) {
            writer.newlineAndIndent();
            writer.keyword("WHEN");
            call.operand(i).unparse(writer, leftPrec, rightPrec);
            writer.keyword("THEN");
            call.operand(i + 1).unparse(writer, leftPrec, rightPrec);
          }
          if (call.operandCount() % 2 == 0) {
            writer.newlineAndIndent();
            writer.keyword("ELSE");
            call.operand(call.operandCount() - 1).unparse(writer, leftPrec, rightPrec);
          }
          writer.newlineAndIndent();
          writer.endList(frame);
        }
      }.createCall(parserPos(ctx), operands);
    }

  private SqlBasicCall createUnresolvedCall(SqlParserPos pos, String opName, List<SqlNode> operands) {
    return new SqlBasicCall(
        new SqlUnresolvedFunction(
            new SqlIdentifier(opName, pos),
            null,
            null,
            null,
            null,
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        ),
        operands,
        pos
    );
  }

  @Override
    public SqlNode visitCastExpression(BigQuerySqlParser.CastExpressionContext ctx) {
      SqlNode operand = visit(ctx.expression());
      SqlDataTypeSpec typeSpec = createDataTypeSpec(ctx.dataType());

      if (ctx.SAFE_CAST() != null) {
        // BigQuery specific safe cast
        return SqlLibraryOperators.SAFE_CAST.createCall(parserPos(ctx), operand, typeSpec);
      } else {
        return SqlStdOperatorTable.CAST.createCall(parserPos(ctx), operand, typeSpec);
      }
    }

    @Override
    public SqlNode visitArrayExpression(BigQuerySqlParser.ArrayExpressionContext ctx) {
      if (ctx.expression().size() > 0) {
        // Array literal [expr1, expr2, ...]
        List<SqlNode> elements = ctx.expression().stream()
            .map(this::visit)
            .collect(Collectors.toList());

        if (ctx.dataType() != null) {
          // Array with explicit type ARRAY<type>[...]
          SqlDataTypeSpec typeSpec = createDataTypeSpec(ctx.dataType());
//          new SqlArrayConstructor(typeSpec, parserPos(ctx))
          return SqlStdOperatorTable.ARRAY_VALUE_CONSTRUCTOR.createCall(parserPos(ctx), elements);
        } else {
          // Simple array literal
          return SqlStdOperatorTable.ARRAY_VALUE_CONSTRUCTOR.createCall(parserPos(ctx), elements);
        }
      } else if (ctx.SELECT() != null) {
        // ARRAY subquery
        SqlNode selectItem = visit(ctx.selectItem());
        SqlNode from = visit(ctx.tableExpression());
        SqlNode where = ctx.whereClause() != null ? visit(ctx.whereClause()) : null;

        List<SqlNode> operands = new ArrayList<>();
        operands.add(selectItem);
        operands.add(from);
        if (where != null) {
          operands.add(where);
        }

        return SqlStdOperatorTable.ARRAY_VALUE_CONSTRUCTOR.createCall(parserPos(ctx), operands);
      } else {
        // Empty array
        return SqlStdOperatorTable.ARRAY_VALUE_CONSTRUCTOR.createCall(parserPos(ctx));
      }
    }

    @Override
    public SqlNode visitStructExpression(BigQuerySqlParser.StructExpressionContext ctx) {
      if (!ctx.structField().isEmpty()) {
        // STRUCT with fields
        List<SqlNode> fields = ctx.structField().stream()
            .map(this::visit)
            .collect(Collectors.toList());
        throw new UnsupportedOperationException("StructExpression not supported.");
//        return SqlLibraryOperators.STRUCT.createCall(parserPos(ctx), fields);
      } else if (!ctx.identifier().isEmpty()) {
        // STRUCT with typed fields
        List<SqlNode> fields = new ArrayList<>();
        for (int i = 0; i < ctx.identifier().size(); i++) {
          SqlIdentifier fieldName = new SqlIdentifier(ctx.identifier(i).getText(), parserPos(ctx));
          SqlDataTypeSpec fieldType = createDataTypeSpec(ctx.dataType(i));
//          fields.add(new SqlStructFieldDeclaration(fieldName, fieldType, parserPos(ctx)));
          throw new UnsupportedOperationException("StructExpression not supported.");
        }
        throw new UnsupportedOperationException("StructExpression not supported.");
//        return new SqlStructTypeConstructor(parserPos(ctx)).createCall(parserPos(ctx), fields);
      } else {
        // Empty STRUCT
        throw new UnsupportedOperationException("StructExpression not supported.");
//        return new SqlStructConstructor(parserPos(ctx)).createCall(parserPos(ctx));
      }
    }

  private SqlDataTypeSpec createDataTypeSpec(BigQuerySqlParser.DataTypeContext dataTypeContext) {
    return (SqlDataTypeSpec) visit(dataTypeContext);
  }

  @Override
    public SqlNode visitStructField(BigQuerySqlParser.StructFieldContext ctx) {
      SqlNode value = visit(ctx.expression());
      if (ctx.identifier() != null) {
        SqlIdentifier fieldName = new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
        throw new UnsupportedOperationException("StructField not supported.");
//        return new SqlStructField(fieldName, value, parserPos(ctx));
      } else {
        return value;
      }
    }

    @Override
    public SqlNode visitFunctionCall(BigQuerySqlParser.FunctionCallContext ctx) {
      if (ctx.COUNT() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode operand;
        if (ctx.expression() != null) {
          operand = visit(ctx.expression(0));
        } else {
          // COUNT(*)
          operand = SqlIdentifier.star(parserPos(ctx));
        }
        return createAggFunction(SqlStdOperatorTable.COUNT, distinct, operand);
      } else if (ctx.SUM() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode operand = ctx.expression() != null ? visit(ctx.expression(0)) : SqlIdentifier.star(parserPos(ctx));
        return createAggFunction(SqlStdOperatorTable.SUM, distinct, operand);
      } else if (ctx.AVG() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode operand = ctx.expression() != null ? visit(ctx.expression(0)) : SqlIdentifier.star(parserPos(ctx));
        return createAggFunction(SqlStdOperatorTable.AVG, distinct, operand);
      } else if (ctx.MIN() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode operand = ctx.expression() != null ? visit(ctx.expression(0)) : SqlIdentifier.star(parserPos(ctx));
        return createAggFunction(SqlStdOperatorTable.MIN, distinct, operand);
      } else if (ctx.MAX() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode operand = ctx.expression() != null ? visit(ctx.expression(0)) : SqlIdentifier.star(parserPos(ctx));
        return createAggFunction(SqlStdOperatorTable.MAX, distinct, operand);
      } else if (ctx.EXTRACT() != null) {
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
        SqlNode operand = visit(ctx.expression(0));
        return SqlStdOperatorTable.EXTRACT.createCall(parserPos(ctx), timeUnit, operand);
      } else if (ctx.DATE_ADD() != null) {
        SqlNode date = visit(ctx.expression(0));
        SqlNode interval = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.DATE_ADD.createCall(parserPos(ctx), date, interval, timeUnit);
      } else if (ctx.DATE_SUB() != null) {
        SqlNode date = visit(ctx.expression(0));
        SqlNode interval = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.DATE_SUB.createCall(parserPos(ctx), date, interval, timeUnit);
      } else if (ctx.DATE_DIFF() != null) {
        SqlNode date1 = visit(ctx.expression(0));
        SqlNode date2 = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.DATE_DIFF.createCall(parserPos(ctx), date1, date2, timeUnit);
      } else if (ctx.TIMESTAMP_ADD() != null) {
        SqlNode timestamp = visit(ctx.expression(0));
        SqlNode interval = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.TIMESTAMP_ADD2.createCall(parserPos(ctx), timestamp, interval, timeUnit);
      } else if (ctx.TIMESTAMP_SUB() != null) {
        SqlNode timestamp = visit(ctx.expression(0));
        SqlNode interval = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.TIMESTAMP_SUB.createCall(parserPos(ctx), timestamp, interval, timeUnit);
      } else if (ctx.TIMESTAMP_DIFF() != null) {
        SqlNode timestamp1 = visit(ctx.expression(0));
        SqlNode timestamp2 = visit(ctx.expression(1));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.TIMESTAMP_DIFF3.createCall(parserPos(ctx), timestamp1, timestamp2, timeUnit);
      } else if (ctx.DATE_TRUNC() != null) {
        SqlNode date = visit(ctx.expression(0));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.DATE_TRUNC.createCall(parserPos(ctx), date, timeUnit);
      } else if (ctx.TIMESTAMP_TRUNC() != null) {
        SqlNode timestamp = visit(ctx.expression(0));
        SqlIdentifier timeUnit = new SqlIdentifier(ctx.dateUnit().getText(), parserPos(ctx));
        return SqlLibraryOperators.TIMESTAMP_TRUNC.createCall(parserPos(ctx), timestamp, timeUnit);
      } else if (ctx.JSON_EXTRACT() != null) {
        SqlNode json = visit(ctx.expression(0));
        SqlNode path = visit(ctx.expression(1));
        throw new UnsupportedOperationException("JsonExtract not supported.");
      } else if (ctx.JSON_EXTRACT_SCALAR() != null) {
        SqlNode json = visit(ctx.expression(0));
        SqlNode path = visit(ctx.expression(1));
        throw new UnsupportedOperationException("JsonExtractScalar not supported.");
      } else if (ctx.JSON_QUERY() != null) {
        SqlNode json = visit(ctx.expression(0));
        SqlNode path = visit(ctx.expression(1));
        throw new UnsupportedOperationException("JsonQuery not supported.");
      } else if (ctx.JSON_VALUE() != null) {
        SqlNode json = visit(ctx.expression(0));
        SqlNode path = visit(ctx.expression(1));
        throw new UnsupportedOperationException("JsonValue not supported.");
      } else if (ctx.TO_JSON_STRING() != null) {
        SqlNode value = visit(ctx.expression(0));
        throw new UnsupportedOperationException("ToJsonString not supported.");
      } else if (ctx.PARSE_JSON() != null) {
        SqlNode jsonString = visit(ctx.expression(0));
        throw new UnsupportedOperationException("ParseJson not supported.");
      } else if (ctx.ARRAY_AGG() != null) {
        boolean distinct = ctx.DISTINCT() != null;
        SqlNode value = visit(ctx.expression(0));

        // Handle optional ORDER BY and LIMIT
        List<SqlNode> operands = new ArrayList<>();
        operands.add(value);

        if (!ctx.orderingItem().isEmpty()) {
          List<SqlNode> orderList = ctx.orderingItem().stream()
              .map(this::visit)
              .collect(Collectors.toList());
          operands.add(SqlNodeList.of(parserPos(ctx), orderList));
        }

        if (ctx.LIMIT() != null) {
          operands.add(visit(ctx.expression(ctx.expression().size() - 1)));
        }

        return SqlLibraryOperators.ARRAY_AGG.createCall(parserPos(ctx), operands);
      } else if (ctx.GENERATE_ARRAY() != null) {
        SqlNode start = visit(ctx.expression(0));
        SqlNode end = visit(ctx.expression(1));
        SqlNode step = ctx.expression().size() > 2 ? visit(ctx.expression(2)) : null;

        throw new UnsupportedOperationException("GenerateArray not supported.");
//        if (step != null) {
//          return new SqlGenerateArrayFunction(parserPos(ctx)).createCall(parserPos(ctx), start, end, step);
//        } else {
//          return new SqlGenerateArrayFunction(parserPos(ctx)).createCall(parserPos(ctx), start, end);
//        }
      } else if (ctx.GENERATE_DATE_ARRAY() != null) {
        SqlNode startDate = visit(ctx.expression(0));
        SqlNode endDate = visit(ctx.expression(1));
        SqlNode step = ctx.expression().size() > 2 ? visit(ctx.expression(2)) : null;

        throw new UnsupportedOperationException("GenerateDateArray not supported.");
//        if (step != null) {
//          return new SqlGenerateDateArrayFunction(parserPos(ctx)).createCall(parserPos(ctx), startDate, endDate, step);
//        } else {
//          return new SqlGenerateDateArrayFunction(parserPos(ctx)).createCall(parserPos(ctx), startDate, endDate);
//        }
      } else {
        // Generic function call
        SqlIdentifier funcName = new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
        List<SqlNode> operands = new ArrayList<>();

        boolean distinct = ctx.DISTINCT() != null;

        // Handle arguments
        if (!ctx.expression().isEmpty()) {
          operands.addAll(ctx.expression().stream()
              .map(this::visit)
              .toList());
        } else if (ctx.getChild(2).getText().equals("*")) {
          operands.add(SqlIdentifier.star(parserPos(ctx)));
        }

        // Create the function
        SqlFunction sqlFunction = distinct
            ? new SqlUserDefinedAggFunction(funcName, SqlKind.OTHER_FUNCTION, null, null, null, null, false, false, Optionality.OPTIONAL)
            : new SqlUserDefinedFunction(funcName, SqlKind.OTHER_FUNCTION, null, null, null, null);

        SqlNode call = sqlFunction.createCall(parserPos(ctx), operands);

        // Handle OVER clause if present
        if (ctx.windowSpecification() != null) {
          SqlNode window = visit(ctx.windowSpecification());
          return SqlStdOperatorTable.OVER.createCall(parserPos(ctx), call, window);
        }

        return call;
      }
    }

  private SqlNode createAggFunction(SqlAggFunction aggFunction, boolean distinct, SqlNode operand) {
    assert !distinct;
    return aggFunction.createCall(SqlParserPos.ZERO, operand);
  }

  @Override
    public SqlNode visitColumnReference(BigQuerySqlParser.ColumnReferenceContext ctx) {
      if (ctx.tableIdentifier().size() == 2) {
        // Three-part identifier: a.b.c
        String catalog = ctx.tableIdentifier(0).getText();
        String schema = ctx.tableIdentifier(1).getText();
        String column = ctx.identifier().getText();
        return new SqlIdentifier(
            List.of(catalog, schema, column),
            parserPos(ctx));
      } else if (ctx.tableIdentifier().size() == 1) {
        // Two-part identifier: a.b
        String table = ctx.tableIdentifier(0).getText();
        String column = ctx.identifier().getText();
        return new SqlIdentifier(
            List.of( table, column ),
            parserPos(ctx));
      } else {
        // Simple identifier
        return new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
      }
    }

    @Override
    public SqlNode visitLiteral(BigQuerySqlParser.LiteralContext ctx) {
      if (ctx.STRING_LITERAL() != null) {
        String text = ctx.STRING_LITERAL().getText();
        // Remove surrounding quotes and handle escaped quotes
        text = text.substring(1, text.length() - 1).replace("''", "'");
        return SqlLiteral.createCharString(text, parserPos(ctx));
      } else if (ctx.INTEGER_LITERAL() != null) {
        long value = Long.parseLong(ctx.INTEGER_LITERAL().getText());
        return SqlLiteral.createExactNumeric(String.valueOf(value), parserPos(ctx));
      } else if (ctx.FLOAT_LITERAL() != null) {
        double value = Double.parseDouble(ctx.FLOAT_LITERAL().getText());
        return SqlLiteral.createApproxNumeric(String.valueOf(value), parserPos(ctx));
      } else if (ctx.TRUE() != null) {
        return SqlLiteral.createBoolean(true, parserPos(ctx));
      } else if (ctx.FALSE() != null) {
        return SqlLiteral.createBoolean(false, parserPos(ctx));
      } else if (ctx.NULL() != null) {
        return SqlLiteral.createNull(parserPos(ctx));
      } else if (ctx.DATE() != null) {
        String dateStr = ctx.STRING_LITERAL().getText();
        dateStr = dateStr.substring(1, dateStr.length() - 1).replace("''", "'");
        return SqlLiteral.createDate(new DateString(dateStr), parserPos(ctx));
      } else if (ctx.TIME() != null) {
        String timeStr = ctx.STRING_LITERAL().getText();
        timeStr = timeStr.substring(1, timeStr.length() - 1).replace("''", "'");
        return SqlLiteral.createTime(new TimeString(timeStr), 0, parserPos(ctx));
      } else if (ctx.TIMESTAMP() != null) {
        String timestampStr = ctx.STRING_LITERAL().getText();
        timestampStr = timestampStr.substring(1, timestampStr.length() - 1).replace("''", "'");
        return SqlLiteral.createTimestamp(SqlTypeName.TIMESTAMP, new TimestampString(timestampStr), 0, parserPos(ctx));
      } else if (ctx.DATETIME() != null) {
        String datetimeStr = ctx.STRING_LITERAL().getText();
        datetimeStr = datetimeStr.substring(1, datetimeStr.length() - 1).replace("''", "'");
        return SqlLiteral.createTimestamp(SqlTypeName.TIMESTAMP, new TimestampString(datetimeStr), 0, parserPos(ctx));
      }

      throw new UnsupportedOperationException("Unsupported literal: " + ctx.getText());
    }

    // Helper methods
    private SqlOperator getComparisonOperator(BigQuerySqlParser.ComparisonOperatorContext ctx) {
      String text = ctx.getText();
      switch (text) {
        case "=":
          return SqlStdOperatorTable.EQUALS;
        case "<":
          return SqlStdOperatorTable.LESS_THAN;
        case ">":
          return SqlStdOperatorTable.GREATER_THAN;
        case "<=":
          return SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
        case ">=":
          return SqlStdOperatorTable.GREATER_THAN_OR_EQUAL;
        case "<>":
        case "!=":
          return SqlStdOperatorTable.NOT_EQUALS;
        default:
          throw new UnsupportedOperationException("Unsupported comparison operator: " + text);
      }
    }

  /**
   * Visits a dataType rule and converts it to a SqlDataTypeSpec.
   */
  @Override
  public SqlNode visitDataType(BigQuerySqlParser.DataTypeContext ctx) {
    SqlParserPos pos = getPos(ctx);

    // Handle basic data types
    if (ctx.getChildCount() == 1) {
      String typeName = ctx.getChild(0).getText().toUpperCase();
      return createBasicDataType(typeName, pos);
    }

    // Handle STRING or BYTES with precision
    if ((ctx.STRING() != null || ctx.BYTES() != null) && ctx.INTEGER_LITERAL() != null) {
      String typeName = ctx.getChild(0).getText().toUpperCase();
      int precision = Integer.parseInt(ctx.INTEGER_LITERAL().getText());
      return new SqlDataTypeSpec(
          new SqlBasicTypeNameSpec(
              getTypeNameForString(typeName),
              precision,
              pos),
          pos);
    }

    // Handle ARRAY types
    if (ctx.ARRAY() != null) {
      SqlNode elementType = visit(ctx.dataType());
      if (elementType instanceof SqlDataTypeSpec) {
        return createArrayType((SqlDataTypeSpec) elementType, pos);
      }
    }

    // Handle STRUCT types
    if (ctx.STRUCT() != null && !ctx.structTypeElement().isEmpty()) {
      return createStructType(ctx, pos);
    }

    // Default fallback
    return new SqlDataTypeSpec(
        new SqlBasicTypeNameSpec(
            SqlTypeName.ANY,
            pos),
        pos);
  }

  /**
   * Visits a structTypeElement rule and converts it to a SqlIdentifier and SqlDataTypeSpec pair.
   */
  @Override
  public SqlNode visitStructTypeElement(BigQuerySqlParser.StructTypeElementContext ctx) {
    SqlParserPos pos = getPos(ctx);
    SqlNode identifier = visit(ctx.identifier());
    SqlNode dataType = visit(ctx.dataType());

    if (identifier instanceof SqlIdentifier && dataType instanceof SqlDataTypeSpec) {
      // Create a custom node that holds both the identifier and type
      return new StructFieldNode(
          (SqlIdentifier) identifier,
          (SqlDataTypeSpec) dataType,
          pos);
    }

    return null;
  }

  /**
   * Creates a basic SqlDataTypeSpec without precision or scale.
   */
  private SqlDataTypeSpec createBasicDataType(String typeName, SqlParserPos pos) {
    SqlTypeName sqlTypeName = mapBigQueryTypeToCalciteType(typeName);
    return new SqlDataTypeSpec(
        new SqlBasicTypeNameSpec(
            sqlTypeName,
            pos),
        pos);
  }

  /**
   * Maps BigQuery type names to Calcite SqlTypeName.
   */
  private SqlTypeName mapBigQueryTypeToCalciteType(String typeName) {
    switch (typeName) {
      case "INT64":
        return SqlTypeName.BIGINT;
      case "FLOAT64":
        return SqlTypeName.DOUBLE;
      case "NUMERIC":
      case "BIGNUMERIC":
        return SqlTypeName.DECIMAL;
      case "BOOL":
      case "BOOLEAN":
        return SqlTypeName.BOOLEAN;
      case "STRING":
        return SqlTypeName.VARCHAR;
      case "BYTES":
        return SqlTypeName.VARBINARY;
      case "DATE":
        return SqlTypeName.DATE;
      case "DATETIME":
        return SqlTypeName.TIMESTAMP;
      case "TIME":
        return SqlTypeName.TIME;
      case "TIMESTAMP":
        return SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE;
      case "INTERVAL":
        return SqlTypeName.INTERVAL_DAY;
      case "GEOGRAPHY":
        return SqlTypeName.GEOMETRY;
//      case "JSON":
//        return SqlTypeName.ANY;
      default:
        return SqlTypeName.ANY;
    }
  }

  /**
   * Creates an ARRAY type from an element type.
   */
  private SqlDataTypeSpec createArrayType(SqlDataTypeSpec elementType, SqlParserPos pos) {
    return new SqlDataTypeSpec(
        new SqlCollectionTypeNameSpec(
            elementType.getTypeNameSpec(),
            SqlTypeName.ARRAY,
            pos),
        pos);
  }

  /**
   * Creates a STRUCT type from a list of field specifications.
   */
  private SqlDataTypeSpec createStructType(BigQuerySqlParser.DataTypeContext ctx, SqlParserPos pos) {
    List<SqlNode> fieldNodes = new ArrayList<>();

    for (BigQuerySqlParser.StructTypeElementContext elementCtx : ctx.structTypeElement()) {
      SqlNode fieldNode = visit(elementCtx);
      if (fieldNode != null) {
        fieldNodes.add(fieldNode);
      }
    }

    throw new UnsupportedOperationException("StructType not supported.");

//    // Create a ROW type with the fields
//    return new SqlDataTypeSpec(
//        new SqlRowTypeNameSpec(
//            fieldNodes,
//            pos),
//        pos);
  }

  /**
   * Gets the type name for STRING or BYTES types.
   */
  private SqlTypeName getTypeNameForString(String typeName) {
    if ("STRING".equals(typeName)) {
      return SqlTypeName.VARCHAR;
    } else if ("BYTES".equals(typeName)) {
      return SqlTypeName.VARBINARY;
    } else {
      return SqlTypeName.ANY;
    }
  }

  /**
   * Helper method to get parser position from a parse tree node.
   */
  private SqlParserPos getPos(org.antlr.v4.runtime.ParserRuleContext ctx) {
    return new SqlParserPos(
        ctx.getStart().getLine(),
        ctx.getStart().getCharPositionInLine(),
        ctx.getStop().getLine(),
        ctx.getStop().getCharPositionInLine());
  }


  // Enum for join types (already defined in Calcite but listed here for clarity)
//  private enum JoinType {
//    INNER, LEFT, RIGHT, FULL, CROSS, COMMA
//  }

  // Enum for join condition types
//  private enum JoinConditionType {
//    ON, USING, NONE
//  }

  // Enum for Set qualifiers
  private enum SetQualifier {
    ALL, DISTINCT
  }

  private enum FrameUnit {
    FALSE
  }

  private SqlParserPos parserPos(ParserRuleContext ctx) {
    return new SqlParserPos(
        ctx.getStart().getLine(),
        ctx.getStart().getCharPositionInLine(),
        ctx.getStop().getLine(),
        ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length());
  }

  /**
   * Helper method to get parser position from a terminal node
   */
  private SqlParserPos parserPos(TerminalNode node) {
    return new SqlParserPos(
        node.getSymbol().getLine(),
        node.getSymbol().getCharPositionInLine(),
        node.getSymbol().getLine(),
        node.getSymbol().getCharPositionInLine() + node.getText().length());
  }

}