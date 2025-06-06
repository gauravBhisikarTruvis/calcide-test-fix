package com.calcite_new.sqlanalyzer.analyzer.visitor;

import com.calcite_new.sqlanalyzer.relationextractor.RelationshipExtractor;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlNode;

public abstract class BaseStatementVisitor implements StatementVisitor {

    protected final String userName;
    protected final String defaultDatabase;
    protected final String defaultSchema;

    public BaseStatementVisitor(String userName, String defaultDatabase, String defaultSchema) {
        this.userName = userName;
        this.defaultDatabase = defaultDatabase;
        this.defaultSchema = defaultSchema;
    }

    protected void addAccess(SqlNode node, SqlNodeVisitor.Result result) {
        if (node instanceof SqlIdentifier id) {
            RelationshipExtractor.createAccess(id, userName, defaultDatabase, defaultSchema, result.getEntityRelationships());
            result.getSourceTables().add(id);
        }
    }

    protected void addDependsOn(SqlNode targetTable, SqlNodeVisitor.Result fromResult, SqlNodeVisitor.Result mainResult) {
        if (!(targetTable instanceof SqlIdentifier targetId)) {
            return;
        }
        for (SqlIdentifier sourceId : fromResult.getSourceTables()) {
            RelationshipExtractor.createDependsOn(targetId, sourceId, defaultDatabase, defaultSchema, mainResult.getEntityRelationships());
        }
    }
}

