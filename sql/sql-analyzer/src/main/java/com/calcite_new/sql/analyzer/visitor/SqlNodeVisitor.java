package com.calcite_new.sql.analyzer.visitor;

import com.calcite_new.sql.SqlUpdate;
import com.calcite_new.sql.analyzer.relationextractor.EntityRelationship;
import com.calcite_new.sql.analyzer.relationextractor.RelationshipExtractor;
import com.calcite_new.sql.analyzer.utils.SqlConditionUtils;
import com.calcite_new.sql.analyzer.model.context.clause.InClause;
import com.calcite_new.sql.analyzer.model.QueryContext;
import com.calcite_new.sql.analyzer.model.constants.QueryType;
import com.calcite_new.sql.analyzer.model.context.clause.WhereClause;
import lombok.Getter;
import lombok.Setter;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.util.SqlBasicVisitor;
import org.apache.calcite.sql.util.SqlShuttle;

import java.util.ArrayList;
import java.util.List;

public class SqlNodeVisitor extends SqlBasicVisitor<SqlNodeVisitor.Result> {

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

    public SqlNodeVisitor(String userName, String defaultDatabase, String defaultSchema) {
        this.userName = userName;
        this.defaultDatabase = defaultDatabase;
        this.defaultSchema = defaultSchema;
    }

    @Override
    public Result visit(SqlCall call) {
        Result result = new Result();

        if (call instanceof SqlSelect) {
            result = visitSelect((SqlSelect) call);
            return result;
        }

        if (call instanceof SqlInsert) {
            result = visitInsert((SqlInsert) call);
            return result;
        }

        if (call instanceof SqlUpdate) {
            result = visitUpdate((SqlUpdate) call);
            return result;
        }

        if (call instanceof SqlDelete) {
            result = visitDelete((SqlDelete) call);
            return result;
        }

        for (SqlNode operand : call.getOperandList()) {
            if (operand != null) {
                Result subResult = operand.accept(this);
                mergeResults(result, subResult);
            }
        }
        return result;
    }

    @Override
    public Result visit(SqlIdentifier id) {
        // DO NOT create access or add to sourceTables here
        // Because this could be a column reference
        return new Result();
    }

    private Result visitSelect(SqlSelect select) {
        Result result = new Result();
        result.setQueryType(QueryType.SELECT);

        if (select.getFrom() != null) {
            Result fromResult = select.getFrom().accept(this);
            mergeResults(result, fromResult);

            if (select.getFrom() instanceof SqlIdentifier fromId) {
                RelationshipExtractor.createAccess(fromId, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
                result.getSourceTables().add(fromId);
            }
        }

        if (select.getWhere() != null) {
            WhereClause whereClause = new WhereClause();
            whereClause.setInClauses(findSubqueries(select.getWhere()));
            result.getContext().setWhereClause(whereClause);

            Result whereResult = select.getWhere().accept(this);
            mergeResults(result, whereResult);
        }
        return result;
    }

    private Result visitInsert(SqlInsert insert) {
        Result result = new Result();
        result.setQueryType(QueryType.INSERT);

        SqlNode targetTable = insert.getTargetTable();
        if (targetTable instanceof SqlIdentifier targetId) {
            RelationshipExtractor.createAccess(targetId, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
            result.getSourceTables().add(targetId);
        }

        if (insert.getSource() != null) {
            Result sourceResult = insert.getSource().accept(this);
            mergeResults(result, sourceResult);

            if (targetTable instanceof SqlIdentifier targetId) {
                for (SqlIdentifier sourceId : sourceResult.getSourceTables()) {
                    RelationshipExtractor.createDependsOn(targetId, sourceId, defaultDatabase, defaultSchema, result.getEntityRelationships());
                }
            }
        }
        return result;
    }

    private Result visitUpdate(SqlUpdate update) {
        Result result = new Result();
        result.setQueryType(QueryType.UPDATE);

        SqlNode targetTable = update.getTargetTable();
        if (targetTable instanceof SqlIdentifier targetId) {
            RelationshipExtractor.createAccess(targetId, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
            result.getSourceTables().add(targetId);
        }

        if (update.getCondition() != null) {
            Result conditionResult = update.getCondition().accept(this);
            mergeResults(result, conditionResult);

            if (targetTable instanceof SqlIdentifier targetId) {
                for (SqlIdentifier sourceId : conditionResult.getSourceTables()) {
                    RelationshipExtractor.createDependsOn(targetId, sourceId, defaultDatabase, defaultSchema, result.getEntityRelationships());
                }
            }
        }
        return result;
    }

    private Result visitDelete(SqlDelete delete) {
        Result result = new Result();
        result.setQueryType(QueryType.DELETE);

        SqlNode targetTable = delete.getTargetTable();
        if (targetTable instanceof SqlIdentifier targetId) {
            RelationshipExtractor.createAccess(targetId, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
            result.getSourceTables().add(targetId);
        }

        SqlNode condition = delete.getCondition();
        if (condition != null) {
            Result conditionResult = condition.accept(this);
            mergeResults(result, conditionResult);

            if (targetTable instanceof SqlIdentifier targetId) {
                for (SqlIdentifier sourceId : conditionResult.getSourceTables()) {
                    RelationshipExtractor.createDependsOn(targetId, sourceId, defaultDatabase, defaultSchema, result.getEntityRelationships());
                }
            }

            boolean isTrueCondition = SqlConditionUtils.isConditionAlwaysTrue(condition);
            WhereClause whereClause = new WhereClause();
            whereClause.setTrueCondition(isTrueCondition);
            result.getContext().setWhereClause(whereClause);
        }
        return result;
    }

    private List<InClause> findSubqueries(SqlNode where) {
        List<InClause> result = new ArrayList<>();
        where.accept(new SqlShuttle() {
            @Override
            public SqlNode visit(SqlCall call) {
                if (call.getKind() == SqlKind.IN) {
                    for (SqlNode operand : call.getOperandList()) {
                        if (operand instanceof SqlSelect) {
                            InClause ctx = new InClause();
                            ctx.setSubquery(true);
                            result.add(ctx);
                        }
                    }
                }
                return super.visit(call);
            }
        });
        return result;
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
