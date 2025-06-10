package com.calcite_new.sql.core.processor;

import com.calcite_new.sql.core.processor.utils.SqlStatementUtils;
import com.calcite_new.sql.core.processor.visitor.SqlNodeVisitor;
import com.calcite_new.sql.model.QueryRecord;
import com.calcite_new.sql.model.entity.SqlStatementInfo;
import com.calcite_new.sql.model.enums.QueryStatus;
import com.calcite_new.sql.parser.BigQuerySqlParser;
import org.apache.calcite.sql.SqlNode;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * QueryRecordProcessor is responsible for processing QueryRecord object
 * and extracting SqlStatementInfo from them.
 */
@Component
public class QueryRecordProcessor {

  private final BigQuerySqlParser sqlParser;

  public QueryRecordProcessor() {
    this.sqlParser = new BigQuerySqlParser();
  }

  public List<SqlStatementInfo> process(QueryRecord queryRecord) {
    SqlStatementInfo model = initializeModel(queryRecord);

    try {
      SqlNode sqlNode = sqlParser.parse(queryRecord.getSqlText());

      if (SqlStatementUtils.isIgnored(sqlNode.getKind().name())) {
        model.setQueryStatus(QueryStatus.IGNORED);
        return Collections.singletonList(model);
      }

      SqlNodeVisitor visitor = new SqlNodeVisitor(queryRecord.getUserName(), queryRecord.getDatabase(), queryRecord.getSchema());
      SqlNodeVisitor.Result result = sqlNode.accept(visitor);
      populateModel(model, result);
    } /*catch (SqlParserException e) {
            model.setQueryStatus(QueryStatus.PARSE_ERROR);
        }*/ catch (Exception e) {
      model.setQueryStatus(QueryStatus.PARSE_ERROR);
    }
    return Collections.singletonList(model);
  }

  private SqlStatementInfo initializeModel(QueryRecord queryRecord) {
    SqlStatementInfo model = new SqlStatementInfo();
    model.setLogId(queryRecord.getLogId());
    model.setQueryExecutionTime(queryRecord.getExecutionTime());
    model.setDatabase(queryRecord.getDatabase());
    model.setSchema(queryRecord.getSchema());
    model.setSessionId(queryRecord.getSessionId());
    model.setUserName(queryRecord.getUserName());
    return model;
  }

  private void populateModel(SqlStatementInfo model, SqlNodeVisitor.Result result) {
    model.setQueryStatus(QueryStatus.SUCCESS);
    model.setQueryType(result.getQueryType());
    model.setQueryContext(result.getContext());
    model.setEntityRelationships(result.getEntityRelationships());
  }

}
