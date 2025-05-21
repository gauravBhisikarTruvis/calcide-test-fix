package com.calcite_new.sql.parser.bigquery

import com.calcite_new.sql.parser.BigQuerySqlParserFixture
import com.calcite_new.sql.parser.SqlParserFixture
import com.calcite_new.sql.parser.SqlParserSpec

/**
 * Test cases for BigQuery SQL parser.
 */
class BigQuerySqlParserSpec extends SqlParserSpec {

  protected SqlParserFixture parse(String sql) {
    new BigQuerySqlParserFixture().withSql(sql)
  }

}
