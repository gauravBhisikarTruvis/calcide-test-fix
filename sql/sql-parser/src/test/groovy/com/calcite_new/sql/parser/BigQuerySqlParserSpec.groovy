package com.calcite_new.sql.parser
/**
 * Test cases for BigQuery SQL parser.
 */
class BigQuerySqlParserSpec extends SqlParserSpec {

  def "Simple SELECT should parse"() {
    when:
    String sql = """SELECT *
                   |FROM foodmart.employee""".stripMargin()

    then:
    parse(sql).check("""SELECT *
                       |FROM foodmart.employee""".stripMargin())
  }

  def "Simple SELECT with all columns should parse"() {
    when:
    String sql = """SELECT *
                 |FROM foodmart.employee""".stripMargin()

    then:
    parse(sql).check("""SELECT *
                     |FROM foodmart.employee""".stripMargin())
  }

  def "SELECT with column selection should parse"() {
    when:
    String sql = """SELECT employee_id, full_name, salary
                 |FROM employee""".stripMargin()

    then:
    parse(sql).check("""SELECT employee_id, full_name, salary
                     |FROM employee""".stripMargin())
  }

  def "SELECT with WHERE clause should parse"() {
    when:
    String sql = """SELECT product_id, product_name, SKU
                 |FROM `foodmart`.`product`
                 |WHERE low_fat = TRUE""".stripMargin()

    then:
    parse(sql).check("""SELECT product_id, product_name, SKU
                     |FROM foodmart.product
                     |WHERE low_fat = TRUE""".stripMargin())
  }

  def "SELECT with GROUP BY and aggregation should parse"() {
    when:
    String sql = """SELECT store_id, SUM(store_sales) as total_sales
                 |FROM sales_fact_1997
                 |GROUP BY store_id""".stripMargin()

    then:
    parse(sql).check("""SELECT store_id, SUM(store_sales) AS total_sales
                     |FROM sales_fact_1997
                     |GROUP BY store_id""".stripMargin())
  }

  def "SELECT with ORDER BY should parse"() {
    when:
    String sql = """SELECT customer_id, fname, lname
                 |FROM `customer`
                 |ORDER BY lname ASC, fname DESC""".stripMargin()

    then:
    parse(sql).check("""SELECT customer_id, fname, lname
                     |FROM customer
                     |ORDER BY lname, fname DESC""".stripMargin())
  }

  def "SELECT with LIMIT clause should parse"() {
    when:
    String sql = """SELECT promotion_id, promotion_name, media_type
                 |FROM foodmart.promotion
                 |LIMIT 10""".stripMargin()

    then:
    parse(sql).check("""SELECT promotion_id, promotion_name, media_type
                     |FROM foodmart.promotion
                     |FETCH NEXT 10 ROWS ONLY""".stripMargin())
  }

  def "SELECT with JOIN should parse"() {
    when:
    String sql = """SELECT s.store_id, s.store_name, e.employee_id, e.full_name
                 |FROM `foodmart`.store s
                 |JOIN `foodmart`.employee e ON s.store_id = e.store_id""".stripMargin()

    then:
    parse(sql).check("""SELECT s.store_id, s.store_name, e.employee_id, e.full_name
                     |FROM foodmart.store AS s
                     |INNER JOIN foodmart.employee AS e ON s.store_id = e.store_id""".stripMargin())
  }

  def "SELECT with LEFT JOIN should parse"() {
    when:
    String sql = """SELECT c.customer_id, c.fullname, sf.store_sales
                 |FROM customer c
                 |LEFT JOIN `foodmart`.`sales_fact_1997` sf ON c.customer_id = sf.customer_id""".stripMargin()

    then:
    parse(sql).check("""SELECT c.customer_id, c.fullname, sf.store_sales
                     |FROM customer AS c
                     |LEFT JOIN foodmart.sales_fact_1997 AS sf ON c.customer_id = sf.customer_id""".stripMargin())
  }

  def "SELECT with multiple JOINs should parse"() {
    when:
    String sql = """SELECT sf.product_id, p.product_name, pc.product_category, sf.store_sales
                 |FROM foodmart.sales_fact_1997 sf
                 |JOIN product p ON sf.product_id = p.product_id
                 |JOIN product_class pc ON p.product_class_id = pc.product_class_id""".stripMargin()

    then:
    parse(sql).check("""SELECT sf.product_id, p.product_name, pc.product_category, sf.store_sales
                     |FROM foodmart.sales_fact_1997 AS sf
                     |INNER JOIN product AS p ON sf.product_id = p.product_id
                     |INNER JOIN product_class AS pc ON p.product_class_id = pc.product_class_id""".stripMargin())
  }

  def "SELECT with HAVING clause should parse"() {
    when:
    String sql = """SELECT store_id, SUM(store_sales) as total_sales
                 |FROM `foodmart`.`sales_fact_1997`
                 |GROUP BY store_id
                 |HAVING SUM(store_sales) > 10000""".stripMargin()

    then:
    parse(sql).check("""SELECT store_id, SUM(store_sales) AS total_sales
                     |FROM foodmart.sales_fact_1997
                     |GROUP BY store_id
                     |HAVING SUM(store_sales) > 10000""".stripMargin())
  }

  def "SELECT with subquery should parse"() {
    when:
    String sql = """SELECT store_id, store_name
                 |FROM store
                 |WHERE store_id IN (
                 |  SELECT DISTINCT store_id
                 |  FROM `foodmart`.`sales_fact_1997`
                 |  WHERE store_sales > 100
                 |)""".stripMargin()

    then:
    parse(sql).check("""SELECT store_id, store_name
                     |FROM store
                     |WHERE store_id IN (SELECT DISTINCT store_id
                     |FROM foodmart.sales_fact_1997
                     |WHERE store_sales > 100)""".stripMargin())
  }

  def "SELECT with date functions should parse"() {
    when:
    String sql = """SELECT time_id, EXTRACT(YEAR FROM the_date) as year, EXTRACT(MONTH FROM the_date) as month
                 |FROM foodmart.time_by_day
                 |WHERE EXTRACT(YEAR FROM the_date) = 1997""".stripMargin()

    then:
    parse(sql).check("""SELECT time_id, EXTRACT(YEAR FROM the_date) AS year, EXTRACT(MONTH FROM the_date) AS month
                     |FROM foodmart.time_by_day
                     |WHERE EXTRACT(YEAR FROM the_date) = 1997""".stripMargin())
  }

  def "SELECT with CASE expression should parse"() {
    when:
    String sql = """SELECT customer_id, yearly_income,
                 |CASE
                 |  WHEN yearly_income = 'High' THEN 'Premium'
                 |  WHEN yearly_income = 'Medium' THEN 'Standard'
                 |  ELSE 'Basic'
                 |END AS customer_tier
                 |FROM `foodmart`.customer""".stripMargin()

    then:
    parse(sql).check("""SELECT customer_id, yearly_income,
                     |CASE
                     |WHEN yearly_income = 'High' THEN 'Premium'
                     |WHEN yearly_income = 'Medium' THEN 'Standard'
                     |ELSE 'Basic'
                     |END AS customer_tier
                     |FROM foodmart.customer""".stripMargin())
  }

  def "SELECT with UNION should parse"() {
    when:
    String sql = """SELECT product_id, time_id, store_sales
                 |FROM foodmart.sales_fact_1997
                 |UNION ALL
                 |SELECT product_id, time_id, store_sales
                 |FROM `foodmart`.`sales_fact_1998`""".stripMargin()

    then:
    parse(sql).check("""SELECT product_id, time_id, store_sales
                     |FROM foodmart.sales_fact_1997
                     |UNION ALL
                     |SELECT product_id, time_id, store_sales
                     |FROM foodmart.sales_fact_1998""".stripMargin())
  }

  def "SELECT with complex WHERE conditions should parse"() {
    when:
    String sql = """SELECT store_id, store_name, store_type
                 |FROM store
                 |WHERE (store_type = 'Supermarket' OR store_type = 'Deluxe Supermarket')
                 |AND store_sqft > 20000
                 |AND coffee_bar = TRUE""".stripMargin()

    then:
    parse(sql).check("""SELECT store_id, store_name, store_type
                     |FROM store
                     |WHERE (store_type = 'Supermarket' OR store_type = 'Deluxe Supermarket') AND store_sqft > 20000 AND coffee_bar = TRUE""".stripMargin())
  }

  def "SELECT with window functions should parse"() {
    when:
    String sql = """SELECT employee_id, full_name, salary,
                 |RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) as salary_rank
                 |FROM `foodmart`.`employee`""".stripMargin()

    then:
    parse(sql).check("""SELECT employee_id, full_name, salary, RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS salary_rank
                     |FROM foodmart.employee""".stripMargin())
  }

  def "SELECT with aggregations and math operations should parse"() {
    when:
    String sql = """SELECT product_id,
                 |AVG(store_sales) as avg_sales,
                 |SUM(store_sales) / SUM(unit_sales) as avg_price
                 |FROM `sales_fact_1997`
                 |GROUP BY product_id""".stripMargin()

    then:
    parse(sql).check("""SELECT product_id, AVG(store_sales) AS avg_sales, SUM(store_sales) / SUM(unit_sales) AS avg_price
                     |FROM sales_fact_1997
                     |GROUP BY product_id""".stripMargin())
  }

  def "SELECT with common table expression (CTE) should parse"() {
    when:
    String sql = """WITH top_products AS (
                 |  SELECT product_id, SUM(store_sales) as total_sales
                 |  FROM foodmart.sales_fact_1997
                 |  GROUP BY product_id
                 |  ORDER BY total_sales DESC
                 |  LIMIT 10
                 |)
                 |SELECT tp.product_id, p.product_name, tp.total_sales
                 |FROM top_products tp
                 |JOIN `product` p ON tp.product_id = p.product_id""".stripMargin()

    then:
    parse(sql).check("""WITH top_products AS (SELECT product_id, SUM(store_sales) AS total_sales
                       |FROM foodmart.sales_fact_1997
                       |GROUP BY product_id
                       |ORDER BY total_sales DESC
                       |FETCH NEXT 10 ROWS ONLY) SELECT tp.product_id, p.product_name, tp.total_sales
                       |FROM top_products AS tp
                       |INNER JOIN product AS p ON tp.product_id = p.product_id""".stripMargin())
  }

  def "SELECT with DISTINCT should parse"() {
    when:
    String sql = """SELECT DISTINCT product_category, product_family
                 |FROM `foodmart`.product_class
                 |ORDER BY product_family, product_category""".stripMargin()

    then:
    parse(sql).check("""SELECT DISTINCT product_category, product_family
                     |FROM foodmart.product_class
                     |ORDER BY product_family, product_category""".stripMargin())
  }

  def "SELECT with timestamp operations should parse"() {
    when:
    String sql = """SELECT store_id, 
                 |TIMESTAMP_DIFF(last_remodel_date, first_opened_date, DAY) as days_until_remodel
                 |FROM foodmart.store
                 |WHERE first_opened_date IS NOT NULL
                 |AND last_remodel_date IS NOT NULL""".stripMargin()

    then:
    parse(sql).check("""SELECT store_id, TIMESTAMP_DIFF(last_remodel_date, first_opened_date, DAY) AS days_until_remodel
                     |FROM foodmart.store
                     |WHERE first_opened_date IS NOT NULL AND last_remodel_date IS NOT NULL""".stripMargin())
  }

  SqlParserFixture parse(String sql) {
    new BigQuerySqlParserFixture().withSql(sql)
  }

}
