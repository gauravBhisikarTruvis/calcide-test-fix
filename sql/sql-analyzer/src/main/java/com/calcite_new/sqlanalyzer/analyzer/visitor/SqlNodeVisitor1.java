package com.calcite_new.sqlanalyzer.analyzer.visitor;

import com.calcite_new.sql.SqlUpdate;
import com.calcite_new.sqlanalyzer.model.entity.context.clause.SelectClause;
import com.calcite_new.sqlanalyzer.model.entity.EntityRelationship;
import com.calcite_new.sqlanalyzer.relationextractor.RelationshipExtractor;
import com.calcite_new.sqlanalyzer.model.entity.QueryContext;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import com.calcite_new.sqlanalyzer.model.entity.context.clause.WhereClause;
import lombok.Getter;
import lombok.Setter;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.util.SqlBasicVisitor;

import java.util.ArrayList;
import java.util.List;

import static com.calcite_new.sqlanalyzer.utils.SqlConditionUtils.isConditionAlwaysTrue;
import static com.calcite_new.sqlanalyzer.utils.SqlSubqueryUtils.hasInOrNotInClauseWithSubquery;

public class SqlNodeVisitor1 extends SqlBasicVisitor<SqlNodeVisitor1.Result> {

    @Getter
    @Setter
    public static class Result {
        private QueryType queryType;
        private final List<EntityRelationship> entityRelationships = new ArrayList<>();
        private final QueryContext context = new QueryContext();
        private final List<SqlIdentifier> sourceTables = new ArrayList<>();
    }

    private final String userName;
    private final String defaultDatabase;
    private final String defaultSchema;

    public SqlNodeVisitor1(String userName, String defaultDatabase, String defaultSchema) {
        this.userName = userName;
        this.defaultDatabase = defaultDatabase;
        this.defaultSchema = defaultSchema;
    }

    @Override
    public Result visit(SqlCall call) {
        return switch (call) {
            case null -> new Result();
            case SqlSelect sqlSelect -> visitSelect(sqlSelect);
            case SqlInsert sqlInsert -> visitInsert(sqlInsert);
            case SqlUpdate sqlUpdate -> visitUpdate(sqlUpdate);
            case SqlDelete sqlDelete -> visitDelete(sqlDelete);
            default -> visitGenericCall(call);
        };
    }

    @Override
    public Result visit(SqlIdentifier id) {
        // Avoid adding source tables or relationships for column refs
        return new Result();
    }


    private Result visitSelect(SqlSelect select) {
        Result result = new Result();
        result.setQueryType(QueryType.SELECT);

        processSelectClause(select, result);

        if (select.getFrom() != null) {
            Result fromResult = select.getFrom().accept(this);
            mergeResults(result, fromResult);
            addSourceTableIfIdentifier(select.getFrom(), result);
        }

        if (select.getWhere() != null) {
            processWhereClause(select.getWhere(), result);
        }
        return result;
    }

    private Result visitInsert(SqlInsert insert) {
        Result result = new Result();
        result.setQueryType(QueryType.INSERT);

        addSourceTableIfIdentifier(insert.getTargetTable(), result);

        if (insert.getSource() != null) {
            Result sourceResult = insert.getSource().accept(this);
            mergeResults(result, sourceResult);
            createDependsOnForTargets(insert.getTargetTable(), sourceResult, result);
        }
        return result;
    }

    private Result visitUpdate(SqlUpdate update) {
        Result result = new Result();
        result.setQueryType(QueryType.UPDATE);

        addSourceTableIfIdentifier(update.getTargetTable(), result);

        if (update.getCondition() != null) {
            Result conditionResult = update.getCondition().accept(this);
            mergeResults(result, conditionResult);
            createDependsOnForTargets(update.getTargetTable(), conditionResult, result);
        }
        return result;
    }

    private Result visitDelete(SqlDelete delete) {
        Result result = new Result();
        result.setQueryType(QueryType.DELETE);

        addSourceTableIfIdentifier(delete.getTargetTable(), result);

        if (delete.getCondition() != null) {
            Result conditionResult = delete.getCondition().accept(this);
            mergeResults(result, conditionResult);
            createDependsOnForTargets(delete.getTargetTable(), conditionResult, result);
            setWhereClauseWithTrueCondition(delete.getCondition(), result);
        }
        return result;
    }

    private Result visitGenericCall(SqlCall call) {
        Result result = new Result();
        for (SqlNode operand : call.getOperandList()) {
            if (operand != null) {
                Result subResult = operand.accept(this);
                mergeResults(result, subResult);
            }
        }
        return result;
    }

    private void processSelectClause(SqlSelect select, Result result) {
        SelectClause selectClause = new SelectClause();
        boolean selectAll = select.getSelectList().size() == 1 && "*".equals(select.getSelectList().get(0).toString());
        selectClause.setSelectAll(selectAll);
        selectClause.setDistinct(select.isDistinct());
        result.getContext().setSelectClause(selectClause);
    }

    private void processWhereClause(SqlNode whereNode, Result result) {
        WhereClause whereClause = new WhereClause();
        whereClause.setHasSubqueryInsideInClause(hasInOrNotInClauseWithSubquery(whereNode));
        result.getContext().setWhereClause(whereClause);

        Result whereResult = whereNode.accept(this);
        mergeResults(result, whereResult);
    }

    private void setWhereClauseWithTrueCondition(SqlNode condition, Result result) {
        WhereClause whereClause = new WhereClause();
        whereClause.setHasTrueCondition(isConditionAlwaysTrue(condition));
        result.getContext().setWhereClause(whereClause);
    }

    private void addSourceTableIfIdentifier(SqlNode node, Result result) {
        if (node instanceof SqlIdentifier id) {
            RelationshipExtractor.createAccess(id, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
            result.getSourceTables().add(id);
        }
    }

    private void createDependsOnForTargets(SqlNode targetTable, Result sourceResult, Result mainResult) {
        if (!(targetTable instanceof SqlIdentifier targetId)) {
            return;
        }
        for (SqlIdentifier sourceId : sourceResult.getSourceTables()) {
            RelationshipExtractor.createDependsOn(targetId, sourceId, defaultDatabase, defaultSchema, mainResult.getEntityRelationships());
        }
    }

    private void mergeResults(Result main, Result other) {
        if (other == null) return;
        main.getEntityRelationships().addAll(other.getEntityRelationships());
        main.getSourceTables().addAll(other.getSourceTables());
        if (other.getContext() != null) {
            main.getContext().merge(other.getContext());
        }
    }
}
