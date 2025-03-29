// Generated from BigQuerySql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BigQuerySqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BigQuerySqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(BigQuerySqlParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(BigQuerySqlParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#withQueryItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithQueryItem(BigQuerySqlParser.WithQueryItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#queryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(BigQuerySqlParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#queryTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryTerm(BigQuerySqlParser.QueryTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryPrimary(BigQuerySqlParser.QueryPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#simpleQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuery(BigQuerySqlParser.SimpleQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#selectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectClause(BigQuerySqlParser.SelectClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(BigQuerySqlParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#tableWildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableWildcard(BigQuerySqlParser.TableWildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(BigQuerySqlParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#tableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableExpression(BigQuerySqlParser.TableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#tableFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFactor(BigQuerySqlParser.TableFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#tableAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableAlias(BigQuerySqlParser.TableAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#columnAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAlias(BigQuerySqlParser.ColumnAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#joinedTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinedTable(BigQuerySqlParser.JoinedTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(BigQuerySqlParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinSpecification(BigQuerySqlParser.JoinSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(BigQuerySqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(BigQuerySqlParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#groupingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingElement(BigQuerySqlParser.GroupingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#groupingSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSet(BigQuerySqlParser.GroupingSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(BigQuerySqlParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifyClause(BigQuerySqlParser.QualifyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#windowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowClause(BigQuerySqlParser.WindowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#namedWindow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedWindow(BigQuerySqlParser.NamedWindowContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowSpecification(BigQuerySqlParser.WindowSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#windowName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowName(BigQuerySqlParser.WindowNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#partitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(BigQuerySqlParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(BigQuerySqlParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#orderingItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderingItem(BigQuerySqlParser.OrderingItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#frameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameClause(BigQuerySqlParser.FrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#frameUnits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameUnits(BigQuerySqlParser.FrameUnitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#frameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameExtent(BigQuerySqlParser.FrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#frameStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameStart(BigQuerySqlParser.FrameStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#frameEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameEnd(BigQuerySqlParser.FrameEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(BigQuerySqlParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(BigQuerySqlParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(BigQuerySqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#inPredicateValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInPredicateValue(BigQuerySqlParser.InPredicateValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(BigQuerySqlParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCaseExpression(BigQuerySqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchedCaseExpression(BigQuerySqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(BigQuerySqlParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(BigQuerySqlParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#structExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExpression(BigQuerySqlParser.StructExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#structField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructField(BigQuerySqlParser.StructFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(BigQuerySqlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(BigQuerySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#columnReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnReference(BigQuerySqlParser.ColumnReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#tableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIdentifier(BigQuerySqlParser.TableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(BigQuerySqlParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#structTypeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructTypeElement(BigQuerySqlParser.StructTypeElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#dateUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateUnit(BigQuerySqlParser.DateUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(BigQuerySqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(BigQuerySqlParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link BigQuerySqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonReservedKeyword(BigQuerySqlParser.NonReservedKeywordContext ctx);
}