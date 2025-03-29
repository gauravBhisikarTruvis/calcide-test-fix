package com.calcite.sql.parser

import org.apache.calcite.sql.SqlDialect
import org.apache.calcite.sql.SqlNode
import org.apache.calcite.sql.dialect.CalciteSqlDialect
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertEquals

class SqlParserSpec extends Specification {

  abstract class SqlParseFixture {
    protected static SqlDialect CALCITE_DIALECT = new CalciteSqlDialect(SqlDialect.EMPTY_CONTEXT
        .withDatabaseProduct(SqlDialect.DatabaseProduct.CALCITE))
    protected String sql

    SqlParseFixture(String sql) {
      this.sql = sql
    }

    abstract SqlParser getParser()

    void check(String expectedSql) {
      SqlNode node = parser.parse(sql)
      assertEquals(expectedSql, node.toSqlString(CALCITE_DIALECT).toString())
    }
  }

}
