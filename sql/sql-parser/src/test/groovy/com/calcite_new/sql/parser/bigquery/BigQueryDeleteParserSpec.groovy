package com.calcite_new.sql.parser.bigquery

/**
 * Test cases for BigQuery DELETE statement parsing.
 */
class BigQueryDeleteParserSpec extends BigQuerySqlParserSpec {

  def "Simple DELETE should parse"() {
    when:
    String sql = """DELETE FROM foodmart.employee
                 |WHERE employee_id = 5""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.employee
                     |WHERE employee_id = 5""".stripMargin())
  }

  def "DELETE with complex predicate should parse"() {
    when:
    String sql = """DELETE FROM foodmart.customer
                 |WHERE yearly_income = 'High' 
                 |AND num_children_at_home > 2
                 |AND education = 'College'""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.customer
                     |WHERE yearly_income = 'High' AND num_children_at_home > 2 AND education = 'College'""".stripMargin())
  }

  def "DELETE with IN clause should parse"() {
    when:
    String sql = """DELETE FROM product
                 |WHERE product_id IN (
                 |  SELECT product_id
                 |  FROM `foodmart.sales_fact_1997`
                 |  WHERE store_sales > 100
                 |)""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM product
                       |WHERE product_id IN (SELECT product_id
                       |FROM foodmart.sales_fact_1997
                       |WHERE store_sales > 100)""".stripMargin())
  }

  def "DELETE with JOIN condition should parse"() {
    when:
    String sql = """DELETE FROM foodmart.employee e
                 |WHERE EXISTS (
                 |  SELECT 1
                 |  FROM foodmart.store s
                 |  WHERE e.store_id = s.store_id
                 |  AND s.store_type = 'Supermarket'
                 |)""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.employee AS e
                       |WHERE EXISTS((SELECT 1
                       |FROM foodmart.store AS s
                       |WHERE e.store_id = s.store_id AND s.store_type = 'Supermarket'))""".stripMargin())
  }

  def "DELETE with BETWEEN clause should parse"() {
    when:
    String sql = """DELETE FROM foodmart.inventory_fact_1997
                 |WHERE warehouse_sales BETWEEN 500 AND 1000
                 |AND units_shipped > 50""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.inventory_fact_1997
                     |WHERE warehouse_sales BETWEEN ASYMMETRIC 500 AND 1000 AND units_shipped > 50""".stripMargin())
  }

  def "DELETE with multiple conditions using OR should parse"() {
    when:
    String sql = """DELETE FROM foodmart.promotion
                 |WHERE media_type = 'Radio' 
                 |OR media_type = 'TV' 
                 |OR (media_type = 'In Store' AND cost > 500)""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.promotion
                     |WHERE media_type = 'Radio' OR media_type = 'TV' OR (media_type = 'In Store' AND cost > 500)""".stripMargin())
  }

  def "DELETE with NOT EXISTS condition should parse"() {
    when:
    String sql = """DELETE FROM foodmart.store s
                 |WHERE NOT EXISTS (
                 |  SELECT 1
                 |  FROM foodmart.sales_fact_1997 sf
                 |  WHERE sf.store_id = s.store_id
                 |)""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.store AS s
                       |WHERE NOT EXISTS((SELECT 1
                       |FROM foodmart.sales_fact_1997 AS sf
                       |WHERE sf.store_id = s.store_id))""".stripMargin())
  }

  def "DELETE with DATE functions should parse"() {
    when:
    String sql = """DELETE FROM foodmart.time_by_day
                 |WHERE EXTRACT(YEAR FROM the_date) < 1998
                 |AND quarter = 'Q1'""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.time_by_day
                     |WHERE EXTRACT(YEAR FROM the_date) < 1998 AND quarter = 'Q1'""".stripMargin())
  }

  def "DELETE with complex nested subquery should parse"() {
    when:
    String sql = """DELETE FROM foodmart.product p
                 |WHERE p.product_id IN (
                 |  SELECT sf.product_id
                 |  FROM foodmart.sales_fact_1997 sf
                 |  JOIN foodmart.customer c ON sf.customer_id = c.customer_id
                 |  WHERE c.gender = 'F'
                 |  AND sf.store_sales > (
                 |    SELECT AVG(store_sales) 
                 |    FROM foodmart.sales_fact_1997
                 |  )
                 |)""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.product AS p
                       |WHERE p.product_id IN (SELECT sf.product_id
                       |FROM foodmart.sales_fact_1997 AS sf
                       |INNER JOIN foodmart.customer AS c ON sf.customer_id = c.customer_id
                       |WHERE c.gender = 'F' AND sf.store_sales > (SELECT AVG(store_sales)
                       |FROM foodmart.sales_fact_1997))""".stripMargin())
  }

  def "DELETE with complex CASE expression should parse"() {
    when:
    String sql = """DELETE FROM foodmart.employee
                 |WHERE CASE
                 |        WHEN salary < 1000 THEN 'Low'
                 |        WHEN salary BETWEEN 1000 AND 5000 THEN 'Medium'
                 |        ELSE 'High'
                 |      END = 'High'
                 |AND gender = 'F'""".stripMargin()

    then:
    parse(sql).check("""DELETE FROM foodmart.employee
                     |WHERE CASE WHEN salary < 1000 THEN 'Low' WHEN salary BETWEEN ASYMMETRIC 1000 AND 5000 THEN 'Medium' ELSE 'High' END = 'High' AND gender = 'F'""".stripMargin())
  }

}
