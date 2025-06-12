package com.calcite_new.sql.core.processor;

import com.calcite_new.core.data_ingestor.entity.QueryLog;
import com.calcite_new.sql.core.processor.utils.SqlStatementUtils;
import com.calcite_new.sql.core.processor.visitor.SqlNodeVisitor;
import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.model.enums.StatementStatus;
import com.calcite_new.sql.parser.BigQuerySqlParser;
import org.apache.calcite.sql.SqlNode;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * QueryRecordProcessor is responsible for processing QueryLog object
 * and extracting SqlStatementInfo from them.
 */
@Component
public class QueryRecordProcessor {

  private final BigQuerySqlParser sqlParser;

  public QueryRecordProcessor() {
    this.sqlParser = new BigQuerySqlParser();
  }

  public List<SqlStatementInfo> process(QueryLog queryLog) {
    SqlStatementInfo model = initializeModel(queryLog);

    try {
      SqlNode sqlNode = sqlParser.parse(queryLog.getSqlQuery());

      if (SqlStatementUtils.isIgnored(sqlNode.getKind().name())) {
        model.setStatementStatus(StatementStatus.IGNORED);
        return Collections.singletonList(model);
      }

      SqlNodeVisitor visitor = new SqlNodeVisitor(queryLog.getUserName(), queryLog.getDatabase(), queryLog.getSchema());
      SqlNodeVisitor.Result result = sqlNode.accept(visitor);
      populateModel(model, result);
    } /*catch (SqlParserException e) {
            model.setQueryStatus(QueryStatus.PARSE_ERROR);
        }*/ catch (Exception e) {
      model.setStatementStatus(StatementStatus.PARSE_ERROR);
    }
    return Collections.singletonList(model);
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
