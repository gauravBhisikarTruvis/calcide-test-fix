// Generated from AnsiSql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnsiSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnsiSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AnsiSqlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(AnsiSqlParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(AnsiSqlParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(AnsiSqlParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(AnsiSqlParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#mergeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeStatement(AnsiSqlParser.MergeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#dropStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropStatement(AnsiSqlParser.DropStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#alterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterStatement(AnsiSqlParser.AlterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#alterAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAction(AnsiSqlParser.AlterActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(AnsiSqlParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(AnsiSqlParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(AnsiSqlParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#renameStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameStatement(AnsiSqlParser.RenameStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(AnsiSqlParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AnsiSqlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#distinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinct(AnsiSqlParser.DistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(AnsiSqlParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#selectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElement(AnsiSqlParser.SelectElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(AnsiSqlParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#tableSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSource(AnsiSqlParser.TableSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#primaryTableSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTableSource(AnsiSqlParser.PrimaryTableSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#joinPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinPart(AnsiSqlParser.JoinPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(AnsiSqlParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(AnsiSqlParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(AnsiSqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(AnsiSqlParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(AnsiSqlParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(AnsiSqlParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#orderByElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByElement(AnsiSqlParser.OrderByElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(AnsiSqlParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inSubqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInSubqueryExpr(AnsiSqlParser.InSubqueryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullExpr(AnsiSqlParser.IsNullExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(AnsiSqlParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeExpr(AnsiSqlParser.LikeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(AnsiSqlParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnRefExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRefExpr(AnsiSqlParser.ColumnRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubqueryExpr(AnsiSqlParser.SubqueryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code existsExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(AnsiSqlParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caseExprs}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprs(AnsiSqlParser.CaseExprsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(AnsiSqlParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(AnsiSqlParser.FunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(AnsiSqlParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(AnsiSqlParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(AnsiSqlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#columnRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRef(AnsiSqlParser.ColumnRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AnsiSqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(AnsiSqlParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(AnsiSqlParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(AnsiSqlParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(AnsiSqlParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnsiSqlParser#star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(AnsiSqlParser.StarContext ctx);
}