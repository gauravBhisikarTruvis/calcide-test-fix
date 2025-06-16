package com.calcite_new.sql.core.processor.visitor;

import com.calcite_new.sql.model.enums.StatementType;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlUpdate;

public class UpdateVisitor extends BaseStatementVisitor {

    public UpdateVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlUpdate update = (SqlUpdate) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setStatementType(StatementType.UPDATE);

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


