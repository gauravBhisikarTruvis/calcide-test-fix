package com.calcite_new.sql.parser.bigquery

/**
 * Test cases for BigQuery DELETE statement parsing.
 */
class BigQueryUpdateParserSpec extends BigQuerySqlParserSpec {

  def "Simple UPDATE should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET employee_id = 5
                  |WHERE employee_id = 5""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee
                      |SET employee_id = 5
                      |WHERE employee_id = 5""".stripMargin())
  }

}
