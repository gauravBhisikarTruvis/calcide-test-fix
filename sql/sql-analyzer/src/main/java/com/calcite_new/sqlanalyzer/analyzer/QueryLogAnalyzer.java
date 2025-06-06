package com.calcite_new.sqlanalyzer.analyzer;

import com.calcite_new.sqlanalyzer.analyzer.visitor.SqlNodeVisitor;
import com.calcite_new.sqlanalyzer.dto.QueryLog;
import com.calcite_new.sqlanalyzer.model.entity.QueryAnalysisModel;
import com.calcite_new.sqlanalyzer.model.enums.QueryStatus;
import com.calcite_new.sql.parser.BigQuerySqlParser;
import com.calcite_new.sqlanalyzer.utils.SqlStatementUtils;
import org.apache.calcite.sql.SqlNode;
import org.springframework.stereotype.Component;

@Component
public class QueryLogAnalyzer {

    private final BigQuerySqlParser sqlParser;

    public QueryLogAnalyzer() {
        this.sqlParser = new BigQuerySqlParser();
    }

    public QueryAnalysisModel analyze(QueryLog queryLog) {
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
        } /*catch (SqlParserException e) {
            model.setQueryStatus(QueryStatus.PARSE_ERROR);
        }*/ catch (Exception e) {
            model.setQueryStatus(QueryStatus.PARSE_ERROR);
        }
        return model;
    }

    private QueryAnalysisModel initializeModel(QueryLog queryLog) {
        QueryAnalysisModel model = new QueryAnalysisModel();
        model.setLogId(queryLog.getLogId());
        model.setQueryExecutionTime(queryLog.getExecutionTime());
        model.setDatabase(queryLog.getDatabase());
        model.setSchema(queryLog.getSchema());
        model.setSessionId(queryLog.getSessionId());
        model.setUserName(queryLog.getUserName());
        return model;
    }

    private void populateModel(QueryAnalysisModel model, SqlNodeVisitor.Result result) {
        model.setQueryStatus(QueryStatus.SUCCESS);
        model.setQueryType(result.getQueryType());
        model.setQueryContext(result.getContext());
        model.setEntityRelationships(result.getEntityRelationships());
    }
}


