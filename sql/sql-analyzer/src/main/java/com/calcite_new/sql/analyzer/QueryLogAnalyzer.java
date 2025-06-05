package com.calcite_new.sql.analyzer;

import com.calcite_new.sql.analyzer.model.QueryAnalysisModel;
import com.calcite_new.sql.analyzer.model.constants.QueryStatus;
import com.calcite_new.sql.parser.BigQuerySqlParser;
import com.calcite_new.sql.analyzer.utils.SqlStatementUtils;
import com.calcite_new.sql.analyzer.visitor.SqlNodeVisitor;
import org.apache.calcite.sql.SqlNode;

public class QueryLogAnalyzer {

    private final BigQuerySqlParser sqlParser;

    public QueryLogAnalyzer(String product) {
        this.sqlParser = new BigQuerySqlParser();
    }

    public QueryAnalysisModel process(QueryLog queryLog) {
        QueryAnalysisModel model = initializeModel(queryLog);

        try {
            SqlNode sqlNode = sqlParser.parse(queryLog.getSqlText());

            if (SqlStatementUtils.isIgnored(sqlNode.getKind().name())) {
                model.setQueryStatus(QueryStatus.IGNORED);
                return model;
            }

            SqlNodeVisitor visitor = new SqlNodeVisitor(queryLog.getUserName(), queryLog.getDatabase(), queryLog.getSchema());
            SqlNodeVisitor.Result result = sqlNode.accept(visitor);
            populateModel(model, result);
        } catch (Exception e) {
            model.setQueryStatus(QueryStatus.PARSE_ERROR);
        }

        return model;
    }

    private QueryAnalysisModel initializeModel(QueryLog queryLog) {
        QueryAnalysisModel model = new QueryAnalysisModel();
        model.setQueryId(queryLog.getQueryId());
        model.setQueryExecutionTime(queryLog.getExecutionTime());
        model.setDatabase(queryLog.getDatabase());
        model.setSchema(queryLog.getSchema());
        model.setSessionId(queryLog.getSessionId());
        model.setUserName(queryLog.getUserName());
        return model;
    }

    private void populateModel(QueryAnalysisModel model, SqlNodeVisitor.Result result) {
        model.setQueryStatus(QueryStatus.PARSE_SUCCESS);
        model.setQueryType(result.getQueryType());
        model.setQueryContext(result.getContext());
        model.setEntityRelationships(result.getEntityRelationships());
    }
}


