package com.calcite_new.sql.core.processor.visitor;

import com.calcite_new.sql.core.processor.utils.InClauseAnalyzer;
import com.calcite_new.sql.model.enums.StatementType;
import com.calcite_new.sql.model.entity.context.clause.SelectClause;
import com.calcite_new.sql.model.entity.context.clause.WhereClause;
import org.apache.calcite.sql.*;

public class SelectVisitor extends BaseStatementVisitor {

    public SelectVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlSelect select = (SqlSelect) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setStatementType(StatementType.SELECT);

        SelectClause selectClause = new SelectClause();
        selectClause.setHasSelectAll(isSelectAll(select));
        selectClause.setHasDistinct(select.isDistinct());
        result.getContext().setSelectClause(selectClause);

        if (select.getFrom() != null) {
            SqlNodeVisitor visitor = new SqlNodeVisitor(userName, defaultDatabase, defaultSchema);
            SqlNodeVisitor.Result fromResult = select.getFrom().accept(visitor);
            SqlNodeVisitor.mergeResults(result, fromResult);
            addAccess(select.getFrom(), result);
        }

        if (select.getWhere() != null) {
            SqlNode whereExpr = select.getWhere();
            WhereClause whereClause = new WhereClause();
            InClauseAnalyzer.InClauseInfo inInfo = InClauseAnalyzer.analyze(whereExpr);
            whereClause.setHasInWithSubquery(inInfo.hasInWithSubquery());
            whereClause.setHasInWithConstant(inInfo.hasInWithConstant());

            result.getContext().setWhereClause(whereClause);

            SqlNodeVisitor visitor = new SqlNodeVisitor(userName, defaultDatabase, defaultSchema);
            SqlNodeVisitor.Result whereResult = select.getWhere().accept(visitor);
            SqlNodeVisitor.mergeResults(result, whereResult);
        }

        return result;
    }


    private static boolean isSelectAll(SqlSelect select) {
        return select.getSelectList().size() == 1 && "*".equals(select.getSelectList().getFirst().toString());
    }
}
