// Generated from AnsiSql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnsiSqlParser}.
 */
public interface AnsiSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AnsiSqlParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AnsiSqlParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(AnsiSqlParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(AnsiSqlParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(AnsiSqlParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(AnsiSqlParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(AnsiSqlParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(AnsiSqlParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(AnsiSqlParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(AnsiSqlParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void enterMergeStatement(AnsiSqlParser.MergeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void exitMergeStatement(AnsiSqlParser.MergeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#dropStatement}.
	 * @param ctx the parse tree
	 */
	void enterDropStatement(AnsiSqlParser.DropStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#dropStatement}.
	 * @param ctx the parse tree
	 */
	void exitDropStatement(AnsiSqlParser.DropStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#alterStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlterStatement(AnsiSqlParser.AlterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#alterStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlterStatement(AnsiSqlParser.AlterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void enterAlterAction(AnsiSqlParser.AlterActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void exitAlterAction(AnsiSqlParser.AlterActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStatement(AnsiSqlParser.CreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStatement(AnsiSqlParser.CreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(AnsiSqlParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(AnsiSqlParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#createViewStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateViewStatement(AnsiSqlParser.CreateViewStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#createViewStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateViewStatement(AnsiSqlParser.CreateViewStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#renameStatement}.
	 * @param ctx the parse tree
	 */
	void enterRenameStatement(AnsiSqlParser.RenameStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#renameStatement}.
	 * @param ctx the parse tree
	 */
	void exitRenameStatement(AnsiSqlParser.RenameStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(AnsiSqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(AnsiSqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AnsiSqlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AnsiSqlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#distinct}.
	 * @param ctx the parse tree
	 */
	void enterDistinct(AnsiSqlParser.DistinctContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#distinct}.
	 * @param ctx the parse tree
	 */
	void exitDistinct(AnsiSqlParser.DistinctContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(AnsiSqlParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(AnsiSqlParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectElement(AnsiSqlParser.SelectElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectElement(AnsiSqlParser.SelectElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(AnsiSqlParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(AnsiSqlParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSource(AnsiSqlParser.TableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSource(AnsiSqlParser.TableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#primaryTableSource}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryTableSource(AnsiSqlParser.PrimaryTableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#primaryTableSource}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryTableSource(AnsiSqlParser.PrimaryTableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterJoinPart(AnsiSqlParser.JoinPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitJoinPart(AnsiSqlParser.JoinPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(AnsiSqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(AnsiSqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(AnsiSqlParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(AnsiSqlParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(AnsiSqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(AnsiSqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(AnsiSqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(AnsiSqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(AnsiSqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(AnsiSqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(AnsiSqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(AnsiSqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#orderByElement}.
	 * @param ctx the parse tree
	 */
	void enterOrderByElement(AnsiSqlParser.OrderByElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#orderByElement}.
	 * @param ctx the parse tree
	 */
	void exitOrderByElement(AnsiSqlParser.OrderByElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(AnsiSqlParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(AnsiSqlParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inSubqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInSubqueryExpr(AnsiSqlParser.InSubqueryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inSubqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInSubqueryExpr(AnsiSqlParser.InSubqueryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNullExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsNullExpr(AnsiSqlParser.IsNullExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNullExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsNullExpr(AnsiSqlParser.IsNullExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(AnsiSqlParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(AnsiSqlParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLikeExpr(AnsiSqlParser.LikeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLikeExpr(AnsiSqlParser.LikeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(AnsiSqlParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(AnsiSqlParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnRefExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterColumnRefExpr(AnsiSqlParser.ColumnRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnRefExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitColumnRefExpr(AnsiSqlParser.ColumnRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpr(AnsiSqlParser.SubqueryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpr(AnsiSqlParser.SubqueryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existsExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(AnsiSqlParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existsExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(AnsiSqlParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseExprs}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCaseExprs(AnsiSqlParser.CaseExprsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseExprs}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCaseExprs(AnsiSqlParser.CaseExprsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(AnsiSqlParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(AnsiSqlParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(AnsiSqlParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link AnsiSqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(AnsiSqlParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(AnsiSqlParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(AnsiSqlParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpr(AnsiSqlParser.CaseExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpr(AnsiSqlParser.CaseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(AnsiSqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(AnsiSqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(AnsiSqlParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(AnsiSqlParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(AnsiSqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(AnsiSqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(AnsiSqlParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(AnsiSqlParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(AnsiSqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(AnsiSqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(AnsiSqlParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(AnsiSqlParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(AnsiSqlParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(AnsiSqlParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnsiSqlParser#star}.
	 * @param ctx the parse tree
	 */
	void enterStar(AnsiSqlParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnsiSqlParser#star}.
	 * @param ctx the parse tree
	 */
	void exitStar(AnsiSqlParser.StarContext ctx);
}