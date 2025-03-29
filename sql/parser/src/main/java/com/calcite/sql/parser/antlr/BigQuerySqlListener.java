// Generated from BigQuerySql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BigQuerySqlParser}.
 */
public interface BigQuerySqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(BigQuerySqlParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(BigQuerySqlParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#withClause}.
	 * @param ctx the parse tree
	 */
	void enterWithClause(BigQuerySqlParser.WithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#withClause}.
	 * @param ctx the parse tree
	 */
	void exitWithClause(BigQuerySqlParser.WithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#withQueryItem}.
	 * @param ctx the parse tree
	 */
	void enterWithQueryItem(BigQuerySqlParser.WithQueryItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#withQueryItem}.
	 * @param ctx the parse tree
	 */
	void exitWithQueryItem(BigQuerySqlParser.WithQueryItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(BigQuerySqlParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(BigQuerySqlParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterQueryTerm(BigQuerySqlParser.QueryTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitQueryTerm(BigQuerySqlParser.QueryTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterQueryPrimary(BigQuerySqlParser.QueryPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitQueryPrimary(BigQuerySqlParser.QueryPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#simpleQuery}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuery(BigQuerySqlParser.SimpleQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#simpleQuery}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuery(BigQuerySqlParser.SimpleQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(BigQuerySqlParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(BigQuerySqlParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectItem(BigQuerySqlParser.SelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectItem(BigQuerySqlParser.SelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#tableWildcard}.
	 * @param ctx the parse tree
	 */
	void enterTableWildcard(BigQuerySqlParser.TableWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#tableWildcard}.
	 * @param ctx the parse tree
	 */
	void exitTableWildcard(BigQuerySqlParser.TableWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(BigQuerySqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(BigQuerySqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void enterTableExpression(BigQuerySqlParser.TableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void exitTableExpression(BigQuerySqlParser.TableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void enterTableFactor(BigQuerySqlParser.TableFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void exitTableFactor(BigQuerySqlParser.TableFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(BigQuerySqlParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(BigQuerySqlParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void enterColumnAlias(BigQuerySqlParser.ColumnAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void exitColumnAlias(BigQuerySqlParser.ColumnAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void enterJoinedTable(BigQuerySqlParser.JoinedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void exitJoinedTable(BigQuerySqlParser.JoinedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(BigQuerySqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(BigQuerySqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#joinSpecification}.
	 * @param ctx the parse tree
	 */
	void enterJoinSpecification(BigQuerySqlParser.JoinSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#joinSpecification}.
	 * @param ctx the parse tree
	 */
	void exitJoinSpecification(BigQuerySqlParser.JoinSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(BigQuerySqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(BigQuerySqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(BigQuerySqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(BigQuerySqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#groupingElement}.
	 * @param ctx the parse tree
	 */
	void enterGroupingElement(BigQuerySqlParser.GroupingElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#groupingElement}.
	 * @param ctx the parse tree
	 */
	void exitGroupingElement(BigQuerySqlParser.GroupingElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void enterGroupingSet(BigQuerySqlParser.GroupingSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void exitGroupingSet(BigQuerySqlParser.GroupingSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(BigQuerySqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(BigQuerySqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 */
	void enterQualifyClause(BigQuerySqlParser.QualifyClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 */
	void exitQualifyClause(BigQuerySqlParser.QualifyClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(BigQuerySqlParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(BigQuerySqlParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void enterNamedWindow(BigQuerySqlParser.NamedWindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void exitNamedWindow(BigQuerySqlParser.NamedWindowContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecification(BigQuerySqlParser.WindowSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecification(BigQuerySqlParser.WindowSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(BigQuerySqlParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(BigQuerySqlParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void enterPartitionClause(BigQuerySqlParser.PartitionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void exitPartitionClause(BigQuerySqlParser.PartitionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(BigQuerySqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(BigQuerySqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#orderingItem}.
	 * @param ctx the parse tree
	 */
	void enterOrderingItem(BigQuerySqlParser.OrderingItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#orderingItem}.
	 * @param ctx the parse tree
	 */
	void exitOrderingItem(BigQuerySqlParser.OrderingItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void enterFrameClause(BigQuerySqlParser.FrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void exitFrameClause(BigQuerySqlParser.FrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#frameUnits}.
	 * @param ctx the parse tree
	 */
	void enterFrameUnits(BigQuerySqlParser.FrameUnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#frameUnits}.
	 * @param ctx the parse tree
	 */
	void exitFrameUnits(BigQuerySqlParser.FrameUnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#frameExtent}.
	 * @param ctx the parse tree
	 */
	void enterFrameExtent(BigQuerySqlParser.FrameExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#frameExtent}.
	 * @param ctx the parse tree
	 */
	void exitFrameExtent(BigQuerySqlParser.FrameExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#frameStart}.
	 * @param ctx the parse tree
	 */
	void enterFrameStart(BigQuerySqlParser.FrameStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#frameStart}.
	 * @param ctx the parse tree
	 */
	void exitFrameStart(BigQuerySqlParser.FrameStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#frameEnd}.
	 * @param ctx the parse tree
	 */
	void enterFrameEnd(BigQuerySqlParser.FrameEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#frameEnd}.
	 * @param ctx the parse tree
	 */
	void exitFrameEnd(BigQuerySqlParser.FrameEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(BigQuerySqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(BigQuerySqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(BigQuerySqlParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(BigQuerySqlParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BigQuerySqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BigQuerySqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#inPredicateValue}.
	 * @param ctx the parse tree
	 */
	void enterInPredicateValue(BigQuerySqlParser.InPredicateValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#inPredicateValue}.
	 * @param ctx the parse tree
	 */
	void exitInPredicateValue(BigQuerySqlParser.InPredicateValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(BigQuerySqlParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(BigQuerySqlParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCaseExpression(BigQuerySqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCaseExpression(BigQuerySqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCaseExpression(BigQuerySqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCaseExpression(BigQuerySqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(BigQuerySqlParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(BigQuerySqlParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(BigQuerySqlParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(BigQuerySqlParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#structExpression}.
	 * @param ctx the parse tree
	 */
	void enterStructExpression(BigQuerySqlParser.StructExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#structExpression}.
	 * @param ctx the parse tree
	 */
	void exitStructExpression(BigQuerySqlParser.StructExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(BigQuerySqlParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(BigQuerySqlParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BigQuerySqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BigQuerySqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(BigQuerySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(BigQuerySqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(BigQuerySqlParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(BigQuerySqlParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(BigQuerySqlParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(BigQuerySqlParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(BigQuerySqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(BigQuerySqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#structTypeElement}.
	 * @param ctx the parse tree
	 */
	void enterStructTypeElement(BigQuerySqlParser.StructTypeElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#structTypeElement}.
	 * @param ctx the parse tree
	 */
	void exitStructTypeElement(BigQuerySqlParser.StructTypeElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#dateUnit}.
	 * @param ctx the parse tree
	 */
	void enterDateUnit(BigQuerySqlParser.DateUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#dateUnit}.
	 * @param ctx the parse tree
	 */
	void exitDateUnit(BigQuerySqlParser.DateUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(BigQuerySqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(BigQuerySqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(BigQuerySqlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(BigQuerySqlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BigQuerySqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void enterNonReservedKeyword(BigQuerySqlParser.NonReservedKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link BigQuerySqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void exitNonReservedKeyword(BigQuerySqlParser.NonReservedKeywordContext ctx);
}