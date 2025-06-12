package com.calcite_new.sql.core.processor.visitor;

import com.calcite_new.sql.core.processor.utils.InClauseAnalyzer;
import com.calcite_new.sql.model.enums.StatementType;
import com.calcite_new.sql.model.entity.context.clause.WhereClause;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlDelete;
import org.apache.calcite.sql.SqlNode;

import static com.calcite_new.sql.core.processor.utils.SqlConditionUtils.isConditionAlwaysTrue;

public class DeleteVisitor extends BaseStatementVisitor {

    public DeleteVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlDelete delete = (SqlDelete) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setStatementType(StatementType.DELETE);

        addAccess(delete.getTargetTable(), result);

        if (delete.getCondition() != null) {
            SqlNode deleteCondition = delete.getCondition();
            SqlNodeVisitor visitor = new SqlNodeVisitor(userName, defaultDatabase, defaultSchema);
            SqlNodeVisitor.Result conditionResult = deleteCondition.accept(visitor);

            SqlNodeVisitor.mergeResults(result, conditionResult);
            addDependsOn(delete.getTargetTable(), conditionResult, result);

            WhereClause whereClause = new WhereClause();
            whereClause.setHasTrueCondition(isConditionAlwaysTrue(deleteCondition));
            InClauseAnalyzer.InClauseInfo inInfo = InClauseAnalyzer.analyze(deleteCondition);
            whereClause.setHasInWithSubquery(inInfo.hasInWithSubquery());
            whereClause.setHasInWithConstant(inInfo.hasInWithConstant());
            result.getContext().setWhereClause(whereClause);
        }

        return result;
    }
}
