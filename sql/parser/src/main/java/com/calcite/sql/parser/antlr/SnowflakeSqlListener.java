// Generated from SnowflakeSql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SnowflakeSqlParser}.
 */
public interface SnowflakeSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SnowflakeSqlParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SnowflakeSqlParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#withClause}.
	 * @param ctx the parse tree
	 */
	void enterWithClause(SnowflakeSqlParser.WithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#withClause}.
	 * @param ctx the parse tree
	 */
	void exitWithClause(SnowflakeSqlParser.WithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCommonTableExpression(SnowflakeSqlParser.CommonTableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCommonTableExpression(SnowflakeSqlParser.CommonTableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#selectCore}.
	 * @param ctx the parse tree
	 */
	void enterSelectCore(SnowflakeSqlParser.SelectCoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#selectCore}.
	 * @param ctx the parse tree
	 */
	void exitSelectCore(SnowflakeSqlParser.SelectCoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(SnowflakeSqlParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(SnowflakeSqlParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(SnowflakeSqlParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(SnowflakeSqlParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectItem(SnowflakeSqlParser.SelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectItem(SnowflakeSqlParser.SelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SnowflakeSqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SnowflakeSqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void enterTableExpression(SnowflakeSqlParser.TableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#tableExpression}.
	 * @param ctx the parse tree
	 */
	void exitTableExpression(SnowflakeSqlParser.TableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#tablePrimary}.
	 * @param ctx the parse tree
	 */
	void enterTablePrimary(SnowflakeSqlParser.TablePrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#tablePrimary}.
	 * @param ctx the parse tree
	 */
	void exitTablePrimary(SnowflakeSqlParser.TablePrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#tableFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterTableFunctionCall(SnowflakeSqlParser.TableFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#tableFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitTableFunctionCall(SnowflakeSqlParser.TableFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(SnowflakeSqlParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(SnowflakeSqlParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(SnowflakeSqlParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(SnowflakeSqlParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SnowflakeSqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SnowflakeSqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SnowflakeSqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SnowflakeSqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(SnowflakeSqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(SnowflakeSqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void enterGroupByItem(SnowflakeSqlParser.GroupByItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void exitGroupByItem(SnowflakeSqlParser.GroupByItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#groupingSetItem}.
	 * @param ctx the parse tree
	 */
	void enterGroupingSetItem(SnowflakeSqlParser.GroupingSetItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#groupingSetItem}.
	 * @param ctx the parse tree
	 */
	void exitGroupingSetItem(SnowflakeSqlParser.GroupingSetItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(SnowflakeSqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(SnowflakeSqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 */
	void enterQualifyClause(SnowflakeSqlParser.QualifyClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 */
	void exitQualifyClause(SnowflakeSqlParser.QualifyClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(SnowflakeSqlParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(SnowflakeSqlParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void enterNamedWindow(SnowflakeSqlParser.NamedWindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void exitNamedWindow(SnowflakeSqlParser.NamedWindowContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecification(SnowflakeSqlParser.WindowSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecification(SnowflakeSqlParser.WindowSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#partitionByClause}.
	 * @param ctx the parse tree
	 */
	void enterPartitionByClause(SnowflakeSqlParser.PartitionByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#partitionByClause}.
	 * @param ctx the parse tree
	 */
	void exitPartitionByClause(SnowflakeSqlParser.PartitionByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(SnowflakeSqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(SnowflakeSqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#orderByItem}.
	 * @param ctx the parse tree
	 */
	void enterOrderByItem(SnowflakeSqlParser.OrderByItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#orderByItem}.
	 * @param ctx the parse tree
	 */
	void exitOrderByItem(SnowflakeSqlParser.OrderByItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void enterFrameClause(SnowflakeSqlParser.FrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#frameClause}.
	 * @param ctx the parse tree
	 */
	void exitFrameClause(SnowflakeSqlParser.FrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#frameStart}.
	 * @param ctx the parse tree
	 */
	void enterFrameStart(SnowflakeSqlParser.FrameStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#frameStart}.
	 * @param ctx the parse tree
	 */
	void exitFrameStart(SnowflakeSqlParser.FrameStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#frameEnd}.
	 * @param ctx the parse tree
	 */
	void enterFrameEnd(SnowflakeSqlParser.FrameEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#frameEnd}.
	 * @param ctx the parse tree
	 */
	void exitFrameEnd(SnowflakeSqlParser.FrameEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(SnowflakeSqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(SnowflakeSqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SnowflakeSqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SnowflakeSqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(SnowflakeSqlParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(SnowflakeSqlParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCaseExpression(SnowflakeSqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCaseExpression(SnowflakeSqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCaseExpression(SnowflakeSqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCaseExpression(SnowflakeSqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SnowflakeSqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SnowflakeSqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(SnowflakeSqlParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(SnowflakeSqlParser.AggregateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#withinGroup}.
	 * @param ctx the parse tree
	 */
	void enterWithinGroup(SnowflakeSqlParser.WithinGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#withinGroup}.
	 * @param ctx the parse tree
	 */
	void exitWithinGroup(SnowflakeSqlParser.WithinGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void enterRegularFunction(SnowflakeSqlParser.RegularFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void exitRegularFunction(SnowflakeSqlParser.RegularFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#specialFunction}.
	 * @param ctx the parse tree
	 */
	void enterSpecialFunction(SnowflakeSqlParser.SpecialFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#specialFunction}.
	 * @param ctx the parse tree
	 */
	void exitSpecialFunction(SnowflakeSqlParser.SpecialFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(SnowflakeSqlParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(SnowflakeSqlParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SnowflakeSqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SnowflakeSqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(SnowflakeSqlParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(SnowflakeSqlParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#databaseName}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseName(SnowflakeSqlParser.DatabaseNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#databaseName}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseName(SnowflakeSqlParser.DatabaseNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SnowflakeSqlParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SnowflakeSqlParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void enterColumnAlias(SnowflakeSqlParser.ColumnAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void exitColumnAlias(SnowflakeSqlParser.ColumnAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(SnowflakeSqlParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(SnowflakeSqlParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(SnowflakeSqlParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(SnowflakeSqlParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#collationName}.
	 * @param ctx the parse tree
	 */
	void enterCollationName(SnowflakeSqlParser.CollationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#collationName}.
	 * @param ctx the parse tree
	 */
	void exitCollationName(SnowflakeSqlParser.CollationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SnowflakeSqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SnowflakeSqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(SnowflakeSqlParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(SnowflakeSqlParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(SnowflakeSqlParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(SnowflakeSqlParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#objectField}.
	 * @param ctx the parse tree
	 */
	void enterObjectField(SnowflakeSqlParser.ObjectFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#objectField}.
	 * @param ctx the parse tree
	 */
	void exitObjectField(SnowflakeSqlParser.ObjectFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SnowflakeSqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SnowflakeSqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(SnowflakeSqlParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(SnowflakeSqlParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(SnowflakeSqlParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(SnowflakeSqlParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SnowflakeSqlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SnowflakeSqlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnowflakeSqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void enterNonReservedKeyword(SnowflakeSqlParser.NonReservedKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnowflakeSqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void exitNonReservedKeyword(SnowflakeSqlParser.NonReservedKeywordContext ctx);
}