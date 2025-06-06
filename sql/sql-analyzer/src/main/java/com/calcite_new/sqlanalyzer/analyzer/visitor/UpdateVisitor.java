package com.calcite_new.sqlanalyzer.analyzer.visitor;

import com.calcite_new.sql.SqlUpdate;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import org.apache.calcite.sql.SqlCall;

public class UpdateVisitor extends BaseStatementVisitor {

    public UpdateVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlUpdate update = (SqlUpdate) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setQueryType(QueryType.UPDATE);

        addAccess(update.getTargetTable(), result);

        if (update.getCondition() != null) {
            SqlNodeVisitor visitor = new SqlNodeVisitor(userName, defaultDatabase, defaultSchema);
            SqlNodeVisitor.Result conditionResult = update.getCondition().accept(visitor);
            SqlNodeVisitor.mergeResults(result, conditionResult);
            addDependsOn(update.getTargetTable(), conditionResult, result);
        }

        return result;
    }
}


