package com.calcite_new.sql.parser

class AnsiSqlParserSpec extends SqlParserSpec {

  def "Simple SELECT should parses"() {
    when:
    String sql = "SELECT * FROM users"

    then:
    parse(sql).check("SELECT *\nFROM users")
  }

  def "Simple SELECT should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.employee"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.employee")
  }

  def "SELECT with column list should parse"() {
    when:
    String sql = "SELECT employee_id, full_name, position_title FROM foodmart.employee"

    then:
    parse(sql).check("SELECT employee_id, full_name, position_title\nFROM foodmart.employee")
  }

  def "SELECT with WHERE clause should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.product WHERE product_class_id = 10"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.product\nWHERE product_class_id = 10")
  }

  def "SELECT with JOIN should parse"() {
    when:
    String sql = "SELECT e.employee_id, e.full_name, s.store_name FROM foodmart.employee e JOIN foodmart.store s ON e.store_id = s.store_id"

    then:
    parse(sql).check("SELECT e.employee_id, e.full_name, s.store_name\nFROM foodmart.employee AS e\nJOIN foodmart.store AS s ON e.store_id = s.store_id")
  }

  def "SELECT with GROUP BY should parse"() {
    when:
    String sql = "SELECT store_id, SUM(store_sales) FROM foodmart.sales_fact_1997 GROUP BY store_id"

    then:
    parse(sql).check("SELECT store_id, SUM(store_sales)\nFROM foodmart.sales_fact_1997\nGROUP BY store_id")
  }

  def "SELECT with ORDER BY should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.customer ORDER BY lname, fname"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.customer\nORDER BY lname, fname")
  }

  def "SELECT with HAVING clause should parse"() {
    when:
    String sql = "SELECT product_id, AVG(unit_sales) FROM foodmart.sales_fact_1997 GROUP BY product_id HAVING AVG(unit_sales) > 10"

    then:
    parse(sql).check("SELECT product_id, AVG(unit_sales)\nFROM foodmart.sales_fact_1997\nGROUP BY product_id\nHAVING AVG(unit_sales) > 10")
  }

  def "SELECT with subquery should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.product WHERE product_id IN (SELECT product_id FROM foodmart.sales_fact_1997)"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.product\nWHERE product_id IN (SELECT product_id\nFROM foodmart.sales_fact_1997)")
  }

  def "SELECT with LIMIT clause should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.customer LIMIT 10"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.customer\nLIMIT 10")
  }

  def "SELECT with CASE expression should parse"() {
    when:
    String sql = "SELECT employee_id, CASE WHEN salary > 10000 THEN 'High' ELSE 'Low' END AS salary_level FROM foodmart.employee"

    then:
    parse(sql).check("SELECT employee_id, CASE WHEN salary > 10000 THEN 'High' ELSE 'Low' END AS salary_level\nFROM foodmart.employee")
  }

  def "SELECT with aggregate functions should parse"() {
    when:
    String sql = "SELECT COUNT(*), MAX(salary), MIN(salary), AVG(salary) FROM foodmart.employee"

    then:
    parse(sql).check("SELECT COUNT(*), MAX(salary), MIN(salary), AVG(salary)\nFROM foodmart.employee")
  }

  def "SELECT with multiple joins should parse"() {
    when:
    String sql = "SELECT p.product_name, s.store_name, SUM(f.store_sales) FROM foodmart.sales_fact_1997 f JOIN foodmart.product p ON f.product_id = p.product_id JOIN foodmart.store s ON f.store_id = s.store_id GROUP BY p.product_name, s.store_name"

    then:
    parse(sql).check("SELECT p.product_name, s.store_name, SUM(f.store_sales)\nFROM foodmart.sales_fact_1997 AS f\nJOIN foodmart.product AS p ON f.product_id = p.product_id\nJOIN foodmart.store AS s ON f.store_id = s.store_id\nGROUP BY p.product_name, s.store_name")
  }

  def "SELECT with complex WHERE conditions should parse"() {
    when:
    String sql = "SELECT * FROM foodmart.product WHERE product_class_id = 10 AND (brand_name LIKE 'A%' OR product_name LIKE 'B%')"

    then:
    parse(sql).check("SELECT *\nFROM foodmart.product\nWHERE product_class_id = 10 AND (brand_name LIKE 'A%' OR product_name LIKE 'B%')")
  }

  def "SELECT with UNION should parse"() {
    when:
    String sql = "SELECT employee_id FROM foodmart.employee UNION SELECT employee_id FROM foodmart.reserve_employee"

    then:
    parse(sql).check("SELECT employee_id\nFROM foodmart.employee\nUNION\nSELECT employee_id\nFROM foodmart.reserve_employee")
  }

  def "INSERT statement should parse"() {
    when:
    String sql = "INSERT INTO foodmart.product (product_id, product_class_id, product_name, SKU) VALUES (1000, 10, 'New Product', 12345)"

    then:
    parse(sql).check("INSERT INTO foodmart.product (product_id, product_class_id, product_name, SKU)\nVALUES (1000, 10, 'New Product', 12345)")
  }

  def "UPDATE statement should parse"() {
    when:
    String sql = "UPDATE foodmart.product SET product_name = 'Updated Name' WHERE product_id = 10"

    then:
    parse(sql).check("UPDATE foodmart.product\nSET product_name = 'Updated Name'\nWHERE product_id = 10")
  }

  def "DELETE statement should parse"() {
    when:
    String sql = "DELETE FROM foodmart.product WHERE product_id = 10"

    then:
    parse(sql).check("DELETE FROM foodmart.product\nWHERE product_id = 10")
  }

  def "SELECT with date functions should parse"() {
    when:
    String sql = "SELECT EXTRACT(YEAR FROM the_date) AS year FROM foodmart.time_by_day"

    then:
    parse(sql).check("SELECT EXTRACT(YEAR FROM the_date) AS year\nFROM foodmart.time_by_day")
  }

  def "SELECT with window functions should parse"() {
    when:
    String sql = "SELECT employee_id, full_name, salary, RANK() OVER (ORDER BY salary DESC) AS salary_rank FROM foodmart.employee"

    then:
    parse(sql).check("SELECT employee_id, full_name, salary, RANK() OVER (ORDER BY salary DESC) AS salary_rank\nFROM foodmart.employee")
  }

  def "SELECT with complex join and conditions should parse"() {
    when:
    String sql = "SELECT c.customer_id, c.fullname, SUM(s.store_sales) FROM foodmart.sales_fact_1997 s JOIN foodmart.customer c ON s.customer_id = c.customer_id JOIN foodmart.time_by_day t ON s.time_id = t.time_id WHERE t.the_year = 1997 AND c.country = 'USA' GROUP BY c.customer_id, c.fullname HAVING SUM(s.store_sales) > 100 ORDER BY SUM(s.store_sales) DESC"

    then:
    parse(sql).check("SELECT c.customer_id, c.fullname, SUM(s.store_sales)\nFROM foodmart.sales_fact_1997 AS s\nJOIN foodmart.customer AS c ON s.customer_id = c.customer_id\nJOIN foodmart.time_by_day AS t ON s.time_id = t.time_id\nWHERE t.the_year = 1997 AND c.country = 'USA'\nGROUP BY c.customer_id, c.fullname\nHAVING SUM(s.store_sales) > 100\nORDER BY SUM(s.store_sales) DESC")
  }

  def "SELECT with PROJECTION and FILTER parses"() {
    when:
    String sql = "SELECT id, name FROM users WHERE age > 18"

    then:
    parse(sql).check("""SELECT id, name
                       |FROM users
                       |WHERE age > 18""".stripMargin())
  }

  def "SELECT with JOIN parses"() {
    when:
    String sql = "SELECT u.name, o.order_date " +
        "FROM users u " +
        "INNER JOIN orders o ON u.id = o.user_id"

    then:
    parse(sql).check("""SELECT u.name, o.order_date
                       |FROM users AS u
                       |INNER JOIN orders AS o ON u.id = o.user_id""".stripMargin())
  }

  def "SELECT with GROUP BY parses"() {
    when:
    String sql = "SELECT dept_id, dept_name, COUNT(*) " +
        "FROM employees " +
        "GROUP BY dept_id, dept_name " +
        "HAVING COUNT(*) > 5"

    then:
    parse(sql).check("""SELECT dept_id, dept_name, COUNT(*)
                       |FROM employees
                       |GROUP BY dept_id, dept_name
                       |HAVING COUNT(*) > 5""".stripMargin())
  }

  def "SELECT with ORDER BY and LIMIT"() {
    when:
    String sql = "SELECT * FROM products ORDER BY price DESC LIMIT 10"

    then:
    parse(sql).check("""SELECT *
                       |FROM products
                       |ORDER BY price DESC
                       |FETCH NEXT 10 ROWS ONLY""".stripMargin())
  }

  SqlParserFixture parse(String sql) {
    new AnsiSqlParserFixture().withSql(sql)
  }

}
