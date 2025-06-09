package com.calcite_new.sqlanalyzer.analyzer.visitor;

import com.calcite_new.sqlanalyzer.model.entity.context.clause.WhereClause;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import com.calcite_new.sqlanalyzer.utils.InClauseAnalyzer;
import org.apache.calcite.sql.*;

import static com.calcite_new.sqlanalyzer.utils.SqlConditionUtils.isConditionAlwaysTrue;

public class DeleteVisitor extends BaseStatementVisitor {

    public DeleteVisitor(String userName, String defaultDatabase, String defaultSchema) {
        super(userName, defaultDatabase, defaultSchema);
    }

    @Override
    public SqlNodeVisitor.Result visit(SqlCall call) {
        SqlDelete delete = (SqlDelete) call;
        SqlNodeVisitor.Result result = new SqlNodeVisitor.Result();
        result.setQueryType(QueryType.DELETE);

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
