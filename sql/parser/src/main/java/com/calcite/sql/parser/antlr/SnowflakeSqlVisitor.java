// Generated from SnowflakeSql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SnowflakeSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SnowflakeSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(SnowflakeSqlParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(SnowflakeSqlParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#commonTableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonTableExpression(SnowflakeSqlParser.CommonTableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#selectCore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectCore(SnowflakeSqlParser.SelectCoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(SnowflakeSqlParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(SnowflakeSqlParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(SnowflakeSqlParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(SnowflakeSqlParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#tableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableExpression(SnowflakeSqlParser.TableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#tablePrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePrimary(SnowflakeSqlParser.TablePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#tableFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFunctionCall(SnowflakeSqlParser.TableFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(SnowflakeSqlParser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinClause(SnowflakeSqlParser.JoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(SnowflakeSqlParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SnowflakeSqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(SnowflakeSqlParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(SnowflakeSqlParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#groupingSetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetItem(SnowflakeSqlParser.GroupingSetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(SnowflakeSqlParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#qualifyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifyClause(SnowflakeSqlParser.QualifyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#windowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowClause(SnowflakeSqlParser.WindowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#namedWindow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedWindow(SnowflakeSqlParser.NamedWindowContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowSpecification(SnowflakeSqlParser.WindowSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(SnowflakeSqlParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(SnowflakeSqlParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(SnowflakeSqlParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#frameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameClause(SnowflakeSqlParser.FrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#frameStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameStart(SnowflakeSqlParser.FrameStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#frameEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameEnd(SnowflakeSqlParser.FrameEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(SnowflakeSqlParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SnowflakeSqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(SnowflakeSqlParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#simpleCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCaseExpression(SnowflakeSqlParser.SimpleCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#searchedCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchedCaseExpression(SnowflakeSqlParser.SearchedCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SnowflakeSqlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(SnowflakeSqlParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#withinGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroup(SnowflakeSqlParser.WithinGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#regularFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularFunction(SnowflakeSqlParser.RegularFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#specialFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialFunction(SnowflakeSqlParser.SpecialFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#columnReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnReference(SnowflakeSqlParser.ColumnReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SnowflakeSqlParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(SnowflakeSqlParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#databaseName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseName(SnowflakeSqlParser.DatabaseNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(SnowflakeSqlParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#columnAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAlias(SnowflakeSqlParser.ColumnAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#tableAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableAlias(SnowflakeSqlParser.TableAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#windowName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowName(SnowflakeSqlParser.WindowNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#collationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollationName(SnowflakeSqlParser.CollationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SnowflakeSqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(SnowflakeSqlParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(SnowflakeSqlParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#objectField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectField(SnowflakeSqlParser.ObjectFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SnowflakeSqlParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(SnowflakeSqlParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(SnowflakeSqlParser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SnowflakeSqlParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnowflakeSqlParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonReservedKeyword(SnowflakeSqlParser.NonReservedKeywordContext ctx);
}