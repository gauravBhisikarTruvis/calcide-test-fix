package com.calcite_new.sqlanalyzer.analyzer.visitor;

import com.calcite_new.sqlanalyzer.model.entity.context.clause.SelectClause;
import com.calcite_new.sqlanalyzer.model.entity.context.clause.WhereClause;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlSelect;

import static com.calcite_new.sqlanalyzer.utils.SqlSubqueryUtils.hasInOrNotInClauseWithSubquery;

public class SelectVisitor extends BaseStatementVisitor {

    public SelectVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlSelect select = (SqlSelect) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setQueryType(QueryType.SELECT);

        SelectClause selectClause = new SelectClause();
        selectClause.setSelectAll(isSelectAll(select));
        selectClause.setDistinct(select.isDistinct());
        result.getContext().setSelectClause(selectClause);

        if (select.getFrom() != null) {
            SqlNodeVisitor visitor = new SqlNodeVisitor(userName, defaultDatabase, defaultSchema);
            SqlNodeVisitor.Result fromResult = select.getFrom().accept(visitor);
            SqlNodeVisitor.mergeResults(result, fromResult);

            addAccess(select.getFrom(), result);
        }

        if (select.getWhere() != null) {
            WhereClause whereClause = new WhereClause();
            whereClause.setHasSubqueryInsideInClause(hasInOrNotInClauseWithSubquery(select.getWhere()));
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
