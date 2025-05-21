package com.calcite_new.sql.parser.bigquery;

import com.calcite_new.sql.parser.antlr.BigQuerySqlBaseVisitor;
import com.calcite_new.sql.parser.antlr.BigQuerySqlParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.calcite.avatica.util.TimeUnitRange;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.fun.SqlCase;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
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

/**
 * Visitor to convert BigQuery SQL AST to Calcite {@link SqlNode}.
 */
public class BigQueryToSqlNodeVisitor extends BigQuerySqlBaseVisitor<SqlNode> {

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
  public SqlNode visitDeleteStatement(BigQuerySqlParser.DeleteStatementContext ctx) {
    // Get table identifier
    SqlNode sqlNode = visit(ctx.tableFactor());
    SqlIdentifier tableIdentifier;
    // Handle optional alias
    SqlIdentifier tableAlias = null;
    if (sqlNode.getKind() == SqlKind.AS) {
//      sqlNode = ((SqlBasicCall) sqlNode).getOperands()[0];
      tableIdentifier = ((SqlBasicCall) sqlNode).operand(0);
      tableAlias = ((SqlBasicCall) sqlNode).operand(1);
    } else {
      tableIdentifier = (SqlIdentifier) sqlNode;
    }

    // Create FROM node with optional alias
    SqlNode fromNode;
    if (tableAlias != null) {
      fromNode = new SqlBasicCall(
          SqlStdOperatorTable.AS,
          List.of(tableIdentifier, tableAlias),
          parserPos(ctx)
      );
    } else {
      fromNode = tableIdentifier;
    }

    // Get WHERE condition
    SqlNode whereCondition = visit(ctx.whereCondition);

    // Create DELETE statement
    return new SqlDelete(
        parserPos(ctx),
        fromNode,           // target table
        whereCondition,     // condition
        null,               // source (not used in DELETE)
        null                // alias (handled separately in fromNode)
    );
  }

  @Override
  public SqlNode visitUpdateStatement(BigQuerySqlParser.UpdateStatementContext ctx) {
    // Get table identifier
    SqlIdentifier tableIdentifier = (SqlIdentifier) visit(ctx.tableIdentifier());

    // Handle optional alias
    SqlIdentifier tableAlias = null;
    if (ctx.alias != null) {
      tableAlias = createIdentifier(ctx.alias);
    }

    // Target with optional alias
    SqlNode targetTable;
    if (tableAlias != null) {
      targetTable = new SqlBasicCall(
          SqlStdOperatorTable.AS,
          List.of(tableIdentifier, tableAlias),
          parserPos(ctx)
      );
    } else {
      targetTable = tableIdentifier;
    }

    // Process SET items
    List<SqlNode> updateSetItems = new ArrayList<>();
    for (BigQuerySqlParser.UpdateSetItemContext setItemCtx : ctx.updateSetItem()) {
      updateSetItems.add(visit(setItemCtx));
    }
    SqlNodeList targetColumnList = new SqlNodeList(updateSetItems, parserPos(ctx));

    // Process optional FROM clause
    SqlNode source = null;
    if (ctx.tableExpression() != null && !ctx.tableExpression().isEmpty()) {
      List<SqlNode> sourceList = new ArrayList<>();
      for (BigQuerySqlParser.TableExpressionContext tableExprCtx : ctx.tableExpression()) {
        sourceList.add(visit(tableExprCtx));
      }

      if (sourceList.size() == 1) {
        source = sourceList.get(0);
      } else {
        // Multiple source tables - create a join tree
        source = new SqlJoin(
            parserPos(ctx),
            sourceList.get(0),
            SqlLiteral.createBoolean(false, parserPos(ctx)), // isNatural
            JoinType.COMMA.symbol(parserPos(ctx)),
            null, // No condition needed for COMMA join
            null,
            null
        );

        for (int i = 1; i < sourceList.size(); i++) {
          source = new SqlJoin(
              parserPos(ctx),
              source,
              SqlLiteral.createBoolean(false, parserPos(ctx)), // isNatural
              JoinType.COMMA.symbol(parserPos(ctx)),
              sourceList.get(i),
              null,
              null
          );
        }
      }
    }

    // Process optional WHERE clause
    SqlNode condition = null;
    if (ctx.whereCondition != null) {
      condition = visit(ctx.whereCondition);
    }

    // Create UPDATE statement
//    return new SqlUpdate(
//        parserPos(ctx),
//        targetTable,
//        targetColumnList,
//        source,
//        condition
//    );
    return null;
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
        keywordList = SqlNodeList.of(SqlLiteral.createSymbol(SqlSelectKeyword.DISTINCT, parserPos(distinct)));
      } else {
        keywordList = SqlNodeList.of(SqlLiteral.createSymbol(SqlSelectKeyword.ALL, parserPos(all)));
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
    SqlIdentifier tableId = (SqlIdentifier) visit(ctx.tableIdentifier());
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

      SqlNode tableRef = visit(ctx.tableIdentifier());

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
  public SqlNode visitTableIdentifier(BigQuerySqlParser.TableIdentifierContext ctx) {
    List<String> names = ctx.identifier().stream()
        .map(it -> createIdentifier(it).getSimple())
        .toList();
    return new SqlIdentifier(names, parserPos(ctx));
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
    SqlLiteral isRows = SqlLiteral.createBoolean(false, parserPos(ctx));
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

//  private SqlIdentifier createIdentifier(BigQuerySqlParser.TableIdentifierContext ctx) {
//    return createIdentifier(ctx.identifier());
//  }

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
  public SqlNode visitLogicalOrExpression(BigQuerySqlParser.LogicalOrExpressionContext ctx) {
    // Start with the first logical AND expression
    SqlNode result = visit(ctx.logicalAndExpression(0));

    // Process each additional OR condition, if any
    for (int i = 1; i < ctx.logicalAndExpression().size(); i++) {
      SqlNode right = visit(ctx.logicalAndExpression(i));
      // Create OR operation between the accumulated result and the next operand
      result = SqlStdOperatorTable.OR.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitLogicalAndExpression(BigQuerySqlParser.LogicalAndExpressionContext ctx) {
    // Start with the first equality expression
    SqlNode result = visit(ctx.equalityExpression(0));

    // Process each additional AND condition, if any
    for (int i = 1; i < ctx.equalityExpression().size(); i++) {
      SqlNode right = visit(ctx.equalityExpression(i));
      // Create AND operation between the accumulated result and the next operand
      result = SqlStdOperatorTable.AND.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitEqualityExpression(BigQuerySqlParser.EqualityExpressionContext ctx) {
    // Start with the first comparison expression
    SqlNode result = visit(ctx.comparisonExpression(0));

    // Process each additional equality condition, if any
    for (int i = 0; i < ctx.comparisonExpression().size() - 1; i++) {
      SqlNode right = visit(ctx.comparisonExpression(i + 1));

      // Determine the operator (EQ, NEQ, NE)
      SqlOperator operator;
      if (ctx.EQ() != null) {
        operator = SqlStdOperatorTable.EQUALS;
      } else { // NE (<>)
        operator = SqlStdOperatorTable.NOT_EQUALS;
      }

      // Create operation between the accumulated result and the next operand
      result = operator.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitComparisonExpression(BigQuerySqlParser.ComparisonExpressionContext ctx) {
    // Start with the first range expression
    SqlNode result = visit(ctx.rangeExpression(0));

    // Process each additional comparison condition, if any
    for (int i = 0; i < ctx.rangeExpression().size() - 1; i++) {
      SqlNode right = visit(ctx.rangeExpression(i + 1));

      // Determine the comparison operator (LT, GT, LTE, GTE)
      SqlOperator operator;
      if (ctx.LT(i) != null) {
        operator = SqlStdOperatorTable.LESS_THAN;
      } else if (ctx.GT(i) != null) {
        operator = SqlStdOperatorTable.GREATER_THAN;
      } else if (ctx.LTE(i) != null) {
        operator = SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
      } else { // GTE
        operator = SqlStdOperatorTable.GREATER_THAN_OR_EQUAL;
      }

      // Create operation between the accumulated result and the next operand
      result = operator.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitRangeExpression(BigQuerySqlParser.RangeExpressionContext ctx) {
    // Get the base additive expression
    SqlNode result = visit(ctx.additiveExpression(0));

    // Handle BETWEEN operator if present
    if (ctx.BETWEEN() != null) {
      SqlNode lower = visit(ctx.additiveExpression(1));
      SqlNode upper = visit(ctx.additiveExpression(2));
      result = SqlStdOperatorTable.BETWEEN.createCall(
          parserPos(ctx),
          result,
          lower,
          upper
      );

      // Apply NOT if present
      if (ctx.NOT() != null && ctx.BETWEEN() != null) {
        result = SqlStdOperatorTable.NOT.createCall(
            parserPos(ctx),
            result
        );
      }
    }
    // Handle IN operator if present
    else if (ctx.IN() != null) {
      SqlNode inList = visit(ctx.inExpressionList());

      // Create IN operation
      result = SqlStdOperatorTable.IN.createCall(
          parserPos(ctx),
          result,
          inList
      );

      // Apply NOT if present
      if (ctx.NOT() != null && ctx.IN() != null) {
        result = SqlStdOperatorTable.NOT.createCall(
            parserPos(ctx),
            result
        );
      }
    }
    // Handle LIKE operator if present
    else if (ctx.LIKE() != null) {
      SqlNode pattern = visit(ctx.additiveExpression(1));
      SqlNode escape = null;

      // Handle optional ESCAPE clause
      if (ctx.ESCAPE() != null) {
        escape = visit(ctx.additiveExpression(2));
      }

      // Create LIKE operation with or without ESCAPE
      SqlNode likeCall;
      if (escape != null) {
        likeCall = SqlStdOperatorTable.LIKE.createCall(
            parserPos(ctx),
            result,
            pattern,
            escape
        );
      } else {
        likeCall = SqlStdOperatorTable.LIKE.createCall(
            parserPos(ctx),
            result,
            pattern
        );
      }

      // Apply NOT if present
      if (ctx.NOT() != null && ctx.LIKE() != null) {
        result = SqlStdOperatorTable.NOT.createCall(
            parserPos(ctx),
            likeCall
        );
      } else {
        result = likeCall;
      }
    }

    return result;
  }

  @Override
  public SqlNode visitInExpressionList(BigQuerySqlParser.InExpressionListContext ctx) {
    // Case 1: Regular IN list with explicit values (expression, expression, ...)
    if (ctx.LPAREN() != null && !ctx.expression().isEmpty()) {
      List<SqlNode> valueList = new ArrayList<>();
      for (BigQuerySqlParser.ExpressionContext exprCtx : ctx.expression()) {
        valueList.add(visit(exprCtx));
      }
      return new SqlNodeList(valueList, parserPos(ctx));
    }

    // Case 2: IN with UNNEST - converts array to a set of values
    if (ctx.UNNEST() != null) {
      SqlNode arrayExpression = visit(ctx.expression(0));
      return SqlStdOperatorTable.UNNEST.createCall(
          parserPos(ctx),
          arrayExpression
      );
    }

    // Case 3: IN subquery - values come from a subquery
    if (ctx.queryExpression() != null) {
      return visit(ctx.queryExpression());
    }

    // Case 4: Empty IN list
    if (ctx.LPAREN() != null && ctx.expression().isEmpty()) {
      return new SqlNodeList(new ArrayList<>(), parserPos(ctx));
    }

    throw new UnsupportedOperationException("Unsupported IN expression list type");
  }

  @Override
  public SqlNode visitAdditiveExpression(BigQuerySqlParser.AdditiveExpressionContext ctx) {
    // Start with the first multiplicative expression
    SqlNode result = visit(ctx.multiplicativeExpression(0));

    // Process each additional additive operator, if any
    for (int i = 0; i < ctx.multiplicativeExpression().size() - 1; i++) {
      SqlNode right = visit(ctx.multiplicativeExpression(i + 1));

      // Determine the operator (PLUS, MINUS, CONCAT)
      SqlOperator operator;
      if (ctx.PLUS(i) != null) {
        operator = SqlStdOperatorTable.PLUS;
      } else if (ctx.MINUS(i) != null) {
        operator = SqlStdOperatorTable.MINUS;
      } else { // CONCAT
        operator = SqlStdOperatorTable.CONCAT;
      }

      // Create operation between the accumulated result and the next operand
      result = operator.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitMultiplicativeExpression(BigQuerySqlParser.MultiplicativeExpressionContext ctx) {
    // Start with the first unary expression
    SqlNode result = visit(ctx.unaryExpression(0));

    // Process each additional multiplicative operator, if any
    for (int i = 0; i < ctx.unaryExpression().size() - 1; i++) {
      SqlNode right = visit(ctx.unaryExpression(i + 1));

      // Determine the operator (MULTIPLY, DIVIDE, DIV, MOD)
      SqlOperator operator;
      if (ctx.STAR(i) != null) {
        operator = SqlStdOperatorTable.MULTIPLY;
      } else if (ctx.DIVIDE(i) != null || ctx.DIV(i) != null) {
        operator = SqlStdOperatorTable.DIVIDE;
      } else { // MOD
        operator = SqlStdOperatorTable.MOD;
      }

      // Create operation between the accumulated result and the next operand
      result = operator.createCall(parserPos(ctx), result, right);
    }

    return result;
  }

  @Override
  public SqlNode visitUnaryExpression(BigQuerySqlParser.UnaryExpressionContext ctx) {
    // Handle unary operators if present
    if (ctx.NOT() != null) {
      SqlNode operand = visit(ctx.unaryExpression());
      return SqlStdOperatorTable.NOT.createCall(parserPos(ctx), operand);
    } else if (ctx.PLUS() != null) {
      SqlNode operand = visit(ctx.unaryExpression());
//      return SqlStdOperatorTable.PLUS_PREFIX.createCall(parserPos(ctx), operand);
      throw new UnsupportedOperationException("Unary plus operator not supported");
    } else if (ctx.MINUS() != null) {
      SqlNode operand = visit(ctx.unaryExpression());
//      return SqlStdOperatorTable.MINUS_PREFIX.createCall(parserPos(ctx), operand);
      throw new UnsupportedOperationException("Unary minus operator not supported");
    } else {
      // If no unary operator, visit the IS expression
      return visit(ctx.isExpression());
    }
  }

  @Override
  public SqlNode visitIsExpression(BigQuerySqlParser.IsExpressionContext ctx) {
    // Get the primary expression
    SqlNode result = visit(ctx.primaryExpression());

    // If there's no IS condition, just return the primary expression
    if (ctx.IS() == null) {
      return result;
    }

    // Handle IS conditions
    boolean isNot = ctx.NOT() != null;
    SqlOperator operator;

    if (ctx.NULL() != null) {
      operator = isNot ? SqlStdOperatorTable.IS_NOT_NULL : SqlStdOperatorTable.IS_NULL;
      return operator.createCall(parserPos(ctx), result);
    } else if (ctx.TRUE() != null) {
      operator = isNot ? SqlStdOperatorTable.IS_NOT_TRUE : SqlStdOperatorTable.IS_TRUE;
      return operator.createCall(parserPos(ctx), result);
    } else if (ctx.FALSE() != null) {
      operator = isNot ? SqlStdOperatorTable.IS_NOT_FALSE : SqlStdOperatorTable.IS_FALSE;
      return operator.createCall(parserPos(ctx), result);
    } else if (ctx.NAN() != null) {
//      operator = isNot ? SqlLibraryOperators.IS_NOT_NAN : SqlLibraryOperators.IS_NAN;
//      return operator.createCall(parserPos(ctx), result);
      throw new UnsupportedOperationException("IS NAN operator not supported");
    }

    // Should not reach here if grammar is correctly defined
    throw new UnsupportedOperationException("Unsupported IS expression");
  }

//  @Override
//  public SqlNode visitPrimaryExpression(BigQuerySqlParser.PrimaryExpressionContext ctx) {
//    // Handle literal values
//    if (ctx.literalValue() != null) {
//      return visit(ctx.literalValue());
//    }
//
//    // Handle CASE expressions
//    if (ctx.caseExpression() != null) {
//      return visit(ctx.caseExpression());
//    }
//
//    // Handle CAST expressions
//    if (ctx.castExpression() != null) {
//      return visit(ctx.castExpression());
//    }
//
//    // Handle function calls
//    if (ctx.functionCall() != null) {
//      return visit(ctx.functionCall());
//    }
//
//    // Handle column references
//    if (ctx.columnReference() != null) {
//      return visit(ctx.columnReference());
//    }
//
//    // Handle array expressions
//    if (ctx.arrayExpression() != null) {
//      return visit(ctx.arrayExpression());
//    }
//
//
//    // Handle EXTRACT expressions
//    if (ctx.extractExpression() != null) {
//      return visit(ctx.extractExpression());
//    }
//
//    // Handle IF expressions
//    if (ctx.ifExpression() != null) {
//      return visit(ctx.ifExpression());
//    }
//
//    // Handle array expressions
//    if (ctx.arrayExpression() != null) {
//      return visit(ctx.arrayExpression());
//    }
//
//    // Handle struct expressions
//    if (ctx.structExpression() != null) {
//      return visit(ctx.structExpression());
//    }
//
//    // Handle subqueries
//    if (ctx.queryExpression() != null) {
//      return visit(ctx.queryExpression());
//    }
//
//    // Handle array/struct field access (e.g., expr[idx])
//
//    throw new UnsupportedOperationException("Unsupported primary expression: " + ctx.getText());
//  }


  @Override
  public SqlNode visitParenthesisedPE(BigQuerySqlParser.ParenthesisedPEContext ctx) {
    SqlNode operand = visit(ctx.expression());
    SqlIdentifier funcName = new SqlIdentifier("", parserPos(ctx));
    SqlFunction op = new SqlUserDefinedFunction(funcName, SqlKind.OTHER_FUNCTION, null, null, null, null) {
      @Override
      public void unparse(SqlWriter writer, SqlCall call, int leftPrec, int rightPrec) {
        final SqlWriter.Frame frame = writer.startList("(", ")");
        operand.unparse(writer, 0, 0);
        writer.endList(frame);
      }
    };
    return new SqlBasicCall(op, List.of(operand), parserPos(ctx));
  }

  @Override
  public SqlNode visitExtractExpression(BigQuerySqlParser.ExtractExpressionContext ctx) {
    // Get the source datetime expression
    SqlNode sourceExpression = visit(ctx.expression());

    // Get the extract field
    String fieldName = ctx.extractField().getText().toUpperCase();
    SqlLiteral timeUnit;

    // Map BigQuery extract fields to Calcite timeUnits
    switch (fieldName) {
      case "MICROSECOND":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.MICROSECOND, parserPos(ctx.extractField()));
        break;
      case "MILLISECOND":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.MILLISECOND, parserPos(ctx.extractField()));
        break;
      case "SECOND":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.SECOND, parserPos(ctx.extractField()));
        break;
      case "MINUTE":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.MINUTE, parserPos(ctx.extractField()));
        break;
      case "HOUR":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.HOUR, parserPos(ctx.extractField()));
        break;
      case "DAY":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.DAY, parserPos(ctx.extractField()));
        break;
      case "DAYOFWEEK":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.DOW, parserPos(ctx.extractField()));
        break;
      case "DAYOFYEAR":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.DOY, parserPos(ctx.extractField()));
        break;
      case "WEEK":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.WEEK, parserPos(ctx.extractField()));
        break;
      case "MONTH":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.MONTH, parserPos(ctx.extractField()));
        break;
      case "QUARTER":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.QUARTER, parserPos(ctx.extractField()));
        break;
      case "YEAR":
        timeUnit = SqlLiteral.createSymbol(TimeUnitRange.YEAR, parserPos(ctx.extractField()));
        break;
      case "DATE":
        // Special handling for DATE extraction
        timeUnit = SqlLiteral.createSymbol(SqlTypeName.DATE, parserPos(ctx.extractField()));
        break;
      case "TIME":
        // Special handling for TIME extraction
        timeUnit = SqlLiteral.createSymbol(SqlTypeName.TIME, parserPos(ctx.extractField()));
        break;
      case "DATETIME":
        // Special handling for DATETIME extraction
        timeUnit = SqlLiteral.createSymbol(SqlTypeName.TIMESTAMP, parserPos(ctx.extractField()));
        break;
      default:
        throw new UnsupportedOperationException("Unsupported EXTRACT field: " + fieldName);
    }

    // Create the EXTRACT function call with the appropriate timeUnit and source expression
    return SqlStdOperatorTable.EXTRACT.createCall(
        parserPos(ctx),
        timeUnit,
        sourceExpression
    );
  }

  @Override
  public SqlNode visitArrayElementAccess(BigQuerySqlParser.ArrayElementAccessContext ctx) {
    throw new UnsupportedOperationException("Array element access not supported");
  }

  @Override
  public SqlNode visitArraySlice(BigQuerySqlParser.ArraySliceContext ctx) {
    throw new UnsupportedOperationException("Array slice not supported");
  }

  @Override
  public SqlNode visitArrayOffset(BigQuerySqlParser.ArrayOffsetContext ctx) {
    throw new UnsupportedOperationException("Array offset not supported");
  }

  @Override
  public SqlNode visitArraySafeOffset(BigQuerySqlParser.ArraySafeOffsetContext ctx) {
    throw new UnsupportedOperationException("Array safe offset not supported");
  }

  @Override
  public SqlNode visitArrayOrdinal(BigQuerySqlParser.ArrayOrdinalContext ctx) {
    throw new UnsupportedOperationException("Array ordinal not supported");
  }

  @Override
  public SqlNode visitArraySafeOrdinal(BigQuerySqlParser.ArraySafeOrdinalContext ctx) {
    throw new UnsupportedOperationException("Array safe ordinal not supported");
  }

  @Override
  public SqlNode visitLiteralValue(BigQuerySqlParser.LiteralValueContext ctx) {
    // Handle numeric literals
    if (ctx.NUMERIC_LITERAL() != null) {
      String text = ctx.NUMERIC_LITERAL().getText();
      if (text.contains(".") || text.toLowerCase().contains("e")) {
        // It's a decimal/float value
        return SqlLiteral.createExactNumeric(text, parserPos(ctx));
      } else {
        // It's an integer
        return SqlLiteral.createExactNumeric(text, parserPos(ctx));
      }
    }

    // Handle string literals
    if (ctx.STRING_LITERAL() != null) {
      String text = ctx.STRING_LITERAL().getText();
      // Remove the surrounding quotes
      text = text.substring(1, text.length() - 1).replace("''", "'");
      return SqlLiteral.createCharString(text, parserPos(ctx));
    }

    // Handle bytes literals
    if (ctx.BYTES_LITERAL() != null) {
      String text = ctx.BYTES_LITERAL().getText();
      // Remove the 'b' or 'rb' prefix and the surrounding quotes
      int startIdx = text.startsWith("rb") ? 3 : 2;
      text = text.substring(startIdx, text.length() - 1).replace("''", "'");
      return SqlLiteral.createBinaryString(text.getBytes(), parserPos(ctx));
    }

    // Handle date literals
    if (ctx.DATE_LITERAL() != null) {
      String text = ctx.DATE_LITERAL().getText();
      // Extract the date part from 'DATE yyyy-mm-dd'
      String datePart = text.substring(5, text.length() - 1).replace("'", "");
//      return SqlLiteral.createDate(DateString.parse(datePart), parserPos(ctx));
      throw new UnsupportedOperationException("Date literal not supported");
    }

    // Handle timestamp literals
    if (ctx.TIMESTAMP_LITERAL() != null) {
      String text = ctx.TIMESTAMP_LITERAL().getText();
      // Extract the timestamp part from 'TIMESTAMP yyyy-mm-dd hh:mm:ss'
      String timestampPart = text.substring(10, text.length() - 1).replace("'", "");
//      return SqlLiteral.createTimestamp(TimestampString.parse(timestampPart), 0, parserPos(ctx));
      throw new UnsupportedOperationException("Timestamp literal not supported");
    }

    // Handle boolean literals
    if (ctx.BOOL_LITERAL() != null) {
      String text = ctx.BOOL_LITERAL().getText().toLowerCase();
      boolean value = text.equals("true");
      return SqlLiteral.createBoolean(value, parserPos(ctx));
    }

    // Handle NULL literal
    if (ctx.NULL() != null) {
      return SqlLiteral.createNull(parserPos(ctx));
    }

    throw new UnsupportedOperationException("Unsupported literal type: " + ctx.getText());
  }

  //  @Override
//    public SqlNode visitInPredicateValue(BigQuerySqlParser.InPredicateValueContext ctx) {
//      if (!ctx.expression().isEmpty()) {
//        List<SqlNode> values = ctx.expression().stream()
//            .map(this::visit)
//            .collect(Collectors.toList());
//        return SqlStdOperatorTable.ROW.createCall(parserPos(ctx), values);
//      } else if (ctx.queryExpression() != null) {
//        return visit(ctx.queryExpression());
//      } else if (ctx.UNNEST() != null) {
//        return new SqlUnnestOperator(false).createCall(parserPos(ctx), visit(ctx.expression(0)));
//      }
//      return SqlStdOperatorTable.ROW.createCall(parserPos(ctx));
//    }

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
    SqlNodeList whenList = new SqlNodeList(parserPos(ctx));
    SqlNodeList thenList = new SqlNodeList(parserPos(ctx));
    SqlNode elseExpr = null;

    for (int i = 0; i < ctx.WHEN().size(); i++) {
      whenList.add(visit(ctx.expression(i * 2))); // When expression
      thenList.add(visit(ctx.expression(i * 2 + 1))); // Then expression
    }

    if (ctx.ELSE() != null) {
      elseExpr = visit(ctx.expression().get(ctx.expression().size() - 1)); // Else expression
    }

    return new SqlCase(parserPos(ctx), null, whenList, thenList, elseExpr);
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
      SqlNode call;
      if (ctx.ROW_NUMBER() != null) {
        call = createAggFunction(SqlStdOperatorTable.ROW_NUMBER, false);
      } else if (ctx.RANK() != null) {
        call = createAggFunction(SqlStdOperatorTable.RANK, false);
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

        call = sqlFunction.createCall(parserPos(ctx), operands);
      }

      // Handle OVER clause if present
      if (ctx.windowSpecification() != null) {
        SqlNode window = visit(ctx.windowSpecification());
        return SqlStdOperatorTable.OVER.createCall(parserPos(ctx), call, window);
      }

      return call;
    }
  }

  private SqlNode createAggFunction(SqlAggFunction aggFunction, boolean distinct, SqlNode... operands) {
    assert !distinct;
    return aggFunction.createCall(SqlParserPos.ZERO, operands);
  }

  @Override
  public SqlNode visitColumnReference(BigQuerySqlParser.ColumnReferenceContext ctx) {
//    List<String> names = ctx.tableIdentifier().stream().map(RuleContext::getText).toList();
    List<String> names = ctx.identifier().stream().map(RuleContext::getText).toList();
//    if (ctx.tableIdentifier().size() == 2) {
//      // Three-part identifier: a.b.c
//      String catalog = ctx.tableIdentifier(0).getText();
//      String schema = ctx.tableIdentifier(1).getText();
//      String column = ctx.identifier().getText();
//      return new SqlIdentifier(
//          List.of(catalog, schema, column),
//          parserPos(ctx));
//    } else if (ctx.tableIdentifier().size() == 1) {
//      // Two-part identifier: a.b
//      String table = ctx.tableIdentifier(0).getText();
//      String column = ctx.identifier().getText();
//      return new SqlIdentifier(
//          List.of(table, column),
//          parserPos(ctx));
//    } else {
//      // Simple identifier
//      return new SqlIdentifier(ctx.identifier().getText(), parserPos(ctx));
//    }
    return new SqlIdentifier(names, parserPos(ctx));
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