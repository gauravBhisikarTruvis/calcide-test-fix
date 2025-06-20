package com.calcite_new.sql.core.processor;

import com.calcite_new.core.entity.QueryLog;
import com.calcite_new.sql.core.processor.utils.SqlStatementUtils;
import com.calcite_new.sql.core.processor.visitor.SqlNodeVisitor;
import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.model.enums.StatementStatus;
import com.calcite_new.sql.parser.BigQuerySqlParser;
import org.apache.calcite.sql.SqlNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * QueryLogProcessor is responsible for processing QueryLog object
 * and extracting SqlStatementInfo from them.
 */
@Component
public class QueryLogProcessor {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QueryLogProcessor.class);

  private final BigQuerySqlParser sqlParser;

  public QueryLogProcessor() {
    this.sqlParser = new BigQuerySqlParser();
  }

  public List<SqlStatementInfo> process(List<QueryLog> records) {
    List<SqlStatementInfo> results = new ArrayList<>(records.size());

    for (QueryLog queryLog : records) {
      SqlStatementInfo model = initializeModel(queryLog);

      try {
        SqlNode sqlNode = sqlParser.parse(queryLog.getSqlQuery());

        if (SqlStatementUtils.isIgnored(sqlNode.getKind().name())) {
          model.setStatementStatus(StatementStatus.IGNORED);
          model.setErrorDescription((String) null); // Explicitly clear error description for ignored statements
        } else {
          SqlNodeVisitor visitor = new SqlNodeVisitor(
                  queryLog.getUserName(),
                  queryLog.getDatabase(),
                  queryLog.getSchema()
          );

          try {
            SqlNodeVisitor.Result result = sqlNode.accept(visitor);
            populateModel(model, result);
            model.setErrorDescription((String) null); // Explicitly clear error description for successful statements
          } catch (Exception visitorException) {
            handleVisitorError(model, visitorException, queryLog.getLogId());
          }
        }
      } catch (Exception e) {
        handleParseError(model, e, queryLog.getLogId());
      }

      results.add(model);
    }

    return results;
  }

  private void handleParseError(SqlStatementInfo model, Exception e, String logId) {
    model.setStatementStatus(StatementStatus.PARSE_ERROR);
    model.setErrorDescription(e); // Store full stack trace
    log.error("Parsing error for logId: {}", logId, e);
  }

  private void handleVisitorError(SqlStatementInfo model, Exception e, String logId) {
    model.setStatementStatus(StatementStatus.ERROR);
    model.setErrorDescription(e); // Store full stack trace
    log.error("Error during SQL processing for logId: {}", logId, e);
  }

  private SqlStatementInfo initializeModel(QueryLog queryLog) {
    SqlStatementInfo model = new SqlStatementInfo();
    model.setLogId(queryLog.getLogId());
    model.setQueryExecutionTime(queryLog.getTotalExecutionTimeMs());
    model.setDatabase(queryLog.getDatabase());
    model.setSchema(queryLog.getSchema());
    model.setSessionId(queryLog.getSessionId());
    model.setUserName(queryLog.getUserName());
    return model;
  }

  private void populateModel(SqlStatementInfo model, SqlNodeVisitor.Result result) {
    model.setStatementStatus(StatementStatus.SUCCESS);
    model.setStatementType(result.getStatementType());
    model.setStatementContext(result.getContext());
    model.setEntityRelationships(result.getEntityRelationships());
  }

}
