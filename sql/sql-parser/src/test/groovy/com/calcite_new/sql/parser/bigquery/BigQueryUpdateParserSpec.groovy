package com.calcite_new.sql.parser.bigquery

/**
 * Test cases for BigQuery UPDATE statement parsing.
 */
class BigQueryUpdateParserSpec extends BigQuerySqlParserSpec {

  def "Simple UPDATE should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET employee_id = 10
                  |WHERE employee_id = 5""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET employee_id = 10
                      |WHERE employee_id = 5""".stripMargin())
  }

  def "Simple UPDATE should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET gender = 'F'
                  |WHERE employee_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET gender = 'F'
                      |WHERE employee_id = 1""".stripMargin())
  }

  def "UPDATE with multiple SET clauses should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET gender = 'M', marital_status = 'Married', management_role = 'Lead'
                  |WHERE employee_id = 2""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET gender = 'M', marital_status = 'Married', management_role = 'Lead'
                      |WHERE employee_id = 2""".stripMargin())
  }

  def "UPDATE with expression in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.salary
                  |SET salary_paid = salary_paid * 1.05, overtime_paid = overtime_paid + 100.0
                  |WHERE employee_id = 3""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.salary SET salary_paid = salary_paid * 1.05, overtime_paid = overtime_paid + 100.0
                      |WHERE employee_id = 3""".stripMargin())
  }

  def "UPDATE setting a column to NULL should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET supervisor_id = NULL
                  |WHERE employee_id = 4""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET supervisor_id = NULL
                      |WHERE employee_id = 4""".stripMargin())
  }

  def "UPDATE with a subquery in WHERE clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET management_role = 'Senior Manager'
                  |WHERE department_id IN (SELECT department_id FROM foodmart.department WHERE department_description = 'Sales')""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET management_role = 'Senior Manager'
                      |WHERE department_id IN (SELECT department_id
                      |FROM foodmart.department
                      |WHERE department_description = 'Sales')""".stripMargin())
  }

  def "UPDATE with FROM clause (JOIN) should parse"() {
    when:
    String sql = """UPDATE foodmart.salary s
                  |SET s.salary_paid = s.salary_paid * 1.1
                  |FROM foodmart.employee e
                  |WHERE s.employee_id = e.employee_id AND e.department_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.salary AS s SET s.salary_paid = s.salary_paid * 1.1
                      |FROM foodmart.employee AS e
                      |WHERE s.employee_id = e.employee_id AND e.department_id = 1""".stripMargin())
  }

  def "UPDATE with CASE expression in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET management_role = CASE
                  |    WHEN position_title = 'Store Manager' THEN 'Store Level Management'
                  |    WHEN position_title = 'CEO' THEN 'Corporate Executive'
                  |    ELSE 'Non-Store Management'
                  |END
                  |WHERE employee_id = 10""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET management_role = CASE WHEN position_title = 'Store Manager' THEN 'Store Level Management' WHEN position_title = 'CEO' THEN 'Corporate Executive' ELSE 'Non-Store Management' END
                      |WHERE employee_id = 10""".stripMargin())
  }

  def "UPDATE hypothetical STRUCT field should parse"() {
    // Assuming customer table has a column: address_info STRUCT<street STRING, city STRING, zip_code STRING>
    when:
    String sql = """UPDATE foodmart.customer
                  |SET address_info.street = '123 New Street', address_info.city = 'New City'
                  |WHERE customer_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.customer SET address_info.street = '123 New Street', address_info.city = 'New City'
                      |WHERE customer_id = 1""".stripMargin())
  }

  def "UPDATE hypothetical ARRAY element should parse"() {
    // Assuming product table has a column: product_tags ARRAY<STRING>
    when:
    String sql = """UPDATE foodmart.product
                  |SET product_tags[OFFSET(0)] = 'Eco-Friendly'
                  |WHERE product_id = 10""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET product_tags[OFFSET(0)] = 'Eco-Friendly'
                      |WHERE product_id = 10""".stripMargin())
  }

  def "UPDATE with complex WHERE clause (AND/OR) should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET salary = salary * 1.1
                  |WHERE (department_id = 5 AND education_level = 'Graduate Degree') OR position_title = 'President'""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET salary = salary * 1.1
                      |WHERE (department_id = 5 AND education_level = 'Graduate Degree') OR position_title = 'President'""".stripMargin())
  }

  def "UPDATE with alias for the target table should parse"() {
    when:
    String sql = """UPDATE foodmart.employee AS e
                  |SET e.hire_date = CURRENT_DATE()
                  |WHERE e.employee_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee AS e SET e.hire_date = CURRENT_DATE()
                      |WHERE e.employee_id = 1""".stripMargin())
  }

  def "UPDATE with scalar subquery in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET department_id = (SELECT d.department_id FROM foodmart.department d WHERE d.department_description = 'Executive')
                  |WHERE employee_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET department_id = (SELECT d.department_id
                      |FROM foodmart.department AS d
                      |WHERE d.department_description = 'Executive')
                      |WHERE employee_id = 1""".stripMargin())
  }

  def "UPDATE with CAST in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.product
                  |SET SKU = CAST(product_id AS STRING)
                  |WHERE product_id = 10""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET SKU = CAST(product_id AS VARCHAR)
                      |WHERE product_id = 10""".stripMargin())
  }

  def "UPDATE with DEFAULT keyword in SET clause should parse"() {
    // Assuming management_role has a DEFAULT value defined in the table schema
    when:
    String sql = """UPDATE foodmart.employee
                  |SET management_role = DEFAULT
                  |WHERE employee_id = 1""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET management_role = DEFAULT
                      |WHERE employee_id = 1""".stripMargin())
  }

  def "UPDATE with FROM clause and multiple JOINs should parse"() {
    when:
    String sql = """UPDATE s
                  |SET s.salary_paid = s.salary_paid * 1.2
                  |FROM foodmart.salary s
                  |JOIN foodmart.employee e ON s.employee_id = e.employee_id
                  |JOIN foodmart.position p ON e.position_id = p.position_id
                  |WHERE p.pay_basis = 'Salary' AND e.store_id = 10""".stripMargin()

    then:
    parse(sql).check("""UPDATE s SET s.salary_paid = s.salary_paid * 1.2
                      |FROM foodmart.salary AS s INNER JOIN foodmart.employee AS e ON s.employee_id = e.employee_id INNER JOIN foodmart.position AS p ON e.position_id = p.position_id
                      |WHERE p.pay_basis = 'Salary' AND e.store_id = 10""".stripMargin())
  }

  def "UPDATE with aggregate function from subquery in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.product p
                  |SET p.SRP = (
                  |    SELECT AVG(p_inner.SRP)
                  |    FROM foodmart.product p_inner
                  |    WHERE p_inner.product_class_id = p.product_class_id
                  |)
                  |WHERE p.product_id = 7""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product AS p SET p.SRP = (SELECT AVG(p_inner.SRP)
                      |FROM foodmart.product AS p_inner
                      |WHERE p_inner.product_class_id = p.product_class_id)
                      |WHERE p.product_id = 7""".stripMargin())
  }

  def "UPDATE with NOT IN subquery in WHERE clause should parse"() {
    when:
    String sql = """UPDATE foodmart.customer
                  |SET member_card = 'Gold Candidate'
                  |WHERE customer_id NOT IN (
                  |    SELECT c.customer_id
                  |    FROM foodmart.sales_fact_1997 sf
                  |    JOIN foodmart.customer c ON sf.customer_id = c.customer_id
                  |    WHERE sf.store_sales > 1000
                  |) AND yearly_income > '50000'""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.customer SET member_card = 'Gold Candidate'
                      |WHERE NOT customer_id IN (SELECT c.customer_id
                      |FROM foodmart.sales_fact_1997 AS sf
                      |INNER JOIN foodmart.customer AS c ON sf.customer_id = c.customer_id
                      |WHERE sf.store_sales > 1000) AND yearly_income > '50000'""".stripMargin())
  }

  def "UPDATE with EXISTS subquery in WHERE clause should parse"() {
    when:
    String sql = """UPDATE foodmart.store
                  |SET store_type = 'High Volume Super Store'
                  |WHERE EXISTS (
                  |    SELECT 1
                  |    FROM foodmart.sales_fact_1997 sf
                  |    WHERE sf.store_id = store.store_id AND sf.store_sales > 100000
                  |)""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.store SET store_type = 'High Volume Super Store'
                      |WHERE EXISTS((SELECT 1
                      |FROM foodmart.sales_fact_1997 AS sf
                      |WHERE sf.store_id = store.store_id AND sf.store_sales > 100000))""".stripMargin())
  }

  def "UPDATE using values from other columns in the same table in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET full_name = CONCAT(first_name, ' ', last_name)
                  |WHERE employee_id = 5""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET full_name = CONCAT(first_name, ' ', last_name)
                      |WHERE employee_id = 5""".stripMargin())
  }

  def "UPDATE with SAFE_CAST in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET birth_date = SAFE_CAST(CONCAT('1980-01-', LPAD(CAST(MOD(employee_id, 28) + 1 AS STRING), 2, '0')) AS DATE)
                  |WHERE employee_id = 3""".stripMargin() // Creates a potentially valid date string

    then:
    parse(sql).check("""UPDATE foodmart.employee SET birth_date = SAFE_CAST(CONCAT('1980-01-', LPAD(CAST(MOD(employee_id, 28) + 1 AS VARCHAR), 2, '0')) AS DATE)
                      |WHERE employee_id = 3""".stripMargin())
  }

  def "UPDATE with parameterized query placeholders should parse"() {
    // This tests the syntax; actual execution would require parameter binding.
    when:
    String sql = """UPDATE foodmart.employee
                  |SET salary = @new_salary, position_id = @new_position_id
                  |WHERE employee_id = @emp_id""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET salary = @new_salary, position_id = @new_position_id
                      |WHERE employee_id = @emp_id""".stripMargin())
  }

  def "UPDATE hypothetical ARRAY of STRUCTs field should parse"() {
    // Assuming product table has: features ARRAY<STRUCT<name STRING, value STRING, rating INT64>>
    when:
    String sql = """UPDATE foodmart.product
                  |SET features[OFFSET(0)].value = 'New Enhanced Value', features[OFFSET(0)].2.rating = 5
                  |WHERE product_id = 100""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET features[OFFSET(0)].value = 'New Enhanced Value', features[OFFSET(0)][2].rating = 5
                      |WHERE product_id = 100""".stripMargin())
  }

  def "UPDATE with FROM clause using a subquery as source should parse"() {
    // Assuming a staging table: promotions_staging (emp_id INT64, target_position_id INT64, promotion_date DATE)
    when:
    String sql = """UPDATE foodmart.employee e
                  |SET e.position_id = promo.new_position_id, e.salary = e.salary * 1.15
                  |FROM (
                  |    SELECT emp_id, target_position_id AS new_position_id
                  |    FROM foodmart.promotions_staging ps
                  |    WHERE ps.promotion_date = CURRENT_DATE()
                  |) AS promo
                  |WHERE e.employee_id = promo.emp_id""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee AS e SET e.position_id = promo.new_position_id, e.salary = e.salary * 1.15
|FROM (SELECT emp_id, target_position_id AS new_position_id
|FROM foodmart.promotions_staging AS ps
|WHERE ps.promotion_date = CURRENT_DATE()) AS promo
|WHERE e.employee_id = promo.emp_id""".stripMargin())
  }

  def "UPDATE with Date/Time functions in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.employee
                  |SET hire_date = DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH), end_date = NULL
                  |WHERE position_title LIKE '%Trainee%' AND employee_id = 123""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.employee SET hire_date = DATE_SUB(CURRENT_DATE(), 1, MONTH), end_date = NULL
                      |WHERE position_title LIKE '%Trainee%' AND employee_id = 123""".stripMargin())
  }

  def "UPDATE all rows using WHERE TRUE should parse"() {
    when:
    String sql = """UPDATE foodmart.product
                  |SET recyclable_package = TRUE, low_fat = FALSE
                  |WHERE TRUE""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET recyclable_package = TRUE, low_fat = FALSE
                      |WHERE TRUE""".stripMargin())
  }

  def "UPDATE with arithmetic in WHERE clause should parse"() {
    when:
    String sql = """UPDATE foodmart.inventory_fact_1997
                  |SET units_shipped = units_shipped + 10
                  |WHERE (units_ordered - units_shipped) > 50 AND warehouse_id = 7""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.inventory_fact_1997 SET units_shipped = units_shipped + 10
                      |WHERE (units_ordered - units_shipped) > 50 AND warehouse_id = 7""".stripMargin())
  }

  def "UPDATE setting a field to another field's transformed value should parse"() {
    when:
    String sql = """UPDATE foodmart.product
                  |SET SRP = gross_weight * 10.5
                  |WHERE product_class_id = (SELECT pc.product_class_id FROM foodmart.product_class pc WHERE pc.product_category = 'Electronics')""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET SRP = gross_weight * 10.5
                      |WHERE product_class_id = (SELECT pc.product_class_id
                      |FROM foodmart.product_class AS pc
                      |WHERE pc.product_category = 'Electronics')""".stripMargin())
  }

  def "UPDATE using a window function in FROM subquery for conditional update should parse"() {
    when:
    String sql = """UPDATE s
                  |SET s.salary_paid = s.salary_paid * 1.05
                  |FROM foodmart.salary s
                  |JOIN (
                  |    SELECT
                  |        employee_id,
                  |        department_id,
                  |        ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary_paid DESC) as rn
                  |    FROM foodmart.salary
                  |    WHERE vacation_accrued > 10
                  |) AS eligible_raises
                  |ON s.employee_id = eligible_raises.employee_id AND s.department_id = eligible_raises.department_id
                  |WHERE eligible_raises.rn <= 3""".stripMargin()

    then:
    parse(sql).check("""UPDATE s SET s.salary_paid = s.salary_paid * 1.05
                      |FROM foodmart.salary AS s INNER JOIN (SELECT employee_id, department_id, ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary_paid DESC) AS rn
                      |FROM foodmart.salary
                      |WHERE vacation_accrued > 10) AS eligible_raises ON s.employee_id = eligible_raises.employee_id AND s.department_id = eligible_raises.department_id
                      |WHERE eligible_raises.rn <= 3""".stripMargin())
  }

  def "UPDATE rebuilding an entire ARRAY of STRUCTs conditionally should parse"() {
    // Assuming product table has: features ARRAY<STRUCT<name STRING, value STRING>>
    when:
    String sql = """UPDATE foodmart.product
                  |SET features = ARRAY(
                  |    SELECT AS STRUCT
                  |        f.name,
                  |        IF(f.name = 'Color', 'Obsidian Black', f.value) AS value
                  |    FROM UNNEST(features) AS f
                  |)
                  |WHERE product_id = 123 AND EXISTS (SELECT 1 FROM UNNEST(features) feat WHERE feat.name = 'Color')""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET features = ARRAY((SELECT ROW(f.name, IF(f.name = 'Color', 'Obsidian Black', f.value) AS value)
                  |FROM UNNEST(features) AS f))
                  |WHERE product_id = 123 AND EXISTS((SELECT 1
                  |FROM UNNEST(features) AS feat
                  |WHERE feat.name = 'Color'))""".stripMargin())
  }

  def "UPDATE boolean field using CASE expression should parse"() {
    when:
    String sql = """UPDATE foodmart.product
                  |SET low_fat = (CASE WHEN net_weight < 0.5 AND product_class_id = 10 THEN TRUE ELSE FALSE END),
                  |    recyclable_package = TRUE
                  |WHERE product_id = 15""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET low_fat = (CASE WHEN net_weight < 0.5 AND product_class_id = 10 THEN TRUE ELSE FALSE END), recyclable_package = TRUE
                      |WHERE product_id = 15""".stripMargin())
  }

  def "UPDATE with a subquery in SET clause returning a STRUCT should parse"() {
    // Assuming product table has: product_details STRUCT<SKU STRING, brand_name STRING, product_name STRING>
    when:
    String sql = """UPDATE foodmart.product
                  |SET product_details = (
                  |    SELECT AS STRUCT p_class.product_department AS SKU, p.brand_name, p.product_name
                  |    FROM foodmart.product_class p_class
                  |    WHERE p_class.product_class_id = product.product_class_id
                  |)
                  |WHERE product_id = 25""".stripMargin()

    then:
    parse(sql).check("""UPDATE foodmart.product SET product_details = (SELECT ROW(p_class.product_department AS SKU, p.brand_name, p.product_name)
                      |FROM foodmart.product_class AS p_class
                      |WHERE p_class.product_class_id = product.product_class_id)
                      |WHERE product_id = 25""".stripMargin())
  }

  def "UPDATE with multiple aliased tables in FROM clause should parse"() {
    when:
    String sql = """UPDATE sfact
                  |SET sfact.store_sales = sfact.store_sales * 0.9
                  |FROM foodmart.sales_fact_1997 AS sfact
                  |INNER JOIN foodmart.store AS st ON sfact.store_id = st.store_id
                  |INNER JOIN foodmart.region AS r ON st.region_id = r.region_id
                  |WHERE r.sales_district = 'West' AND sfact.promotion_id IS NULL""".stripMargin()
    then:
    parse(sql).check("""UPDATE sfact SET sfact.store_sales = sfact.store_sales * 0.9
                      |FROM foodmart.sales_fact_1997 AS sfact INNER JOIN foodmart.store AS st ON sfact.store_id = st.store_id INNER JOIN foodmart.region AS r ON st.region_id = r.region_id
                      |WHERE r.sales_district = 'West' AND sfact.promotion_id IS NULL""".stripMargin())
  }

  def "UPDATE using STRING functions in SET clause should parse"() {
    when:
    String sql = """UPDATE foodmart.customer
                  |SET fullname = UPPER(CONCAT(fname, ' ', lname)),
                  |    address1 = TRIM(REPLACE(address1, ' St.', ' Street'))
                  |WHERE customer_id < 100""".stripMargin()
    then:
    parse(sql).check("""UPDATE foodmart.customer SET fullname = UPPER(CONCAT(fname, ' ', lname)), address1 = TRIM(REPLACE(address1, ' St.', ' Street'))
                      |WHERE customer_id < 100""".stripMargin())
  }

  def "UPDATE with WHERE clause referencing columns from joined table in FROM clause should parse"() {
    when:
    String sql = """UPDATE e
                  |SET e.salary = e.salary * 1.03
                  |FROM foodmart.employee AS e
                  |JOIN foodmart.department AS d ON e.department_id = d.department_id
                  |WHERE d.department_description = 'Human Resources' AND e.hire_date < DATE_SUB(CURRENT_DATE(), INTERVAL 5 YEAR)""".stripMargin()
    then:
    parse(sql).check("""UPDATE e SET e.salary = e.salary * 1.03
                      |FROM foodmart.employee AS e INNER JOIN foodmart.department AS d ON e.department_id = d.department_id
                      |WHERE d.department_description = 'Human Resources' AND e.hire_date < DATE_SUB(CURRENT_DATE(), 5, YEAR)""".stripMargin())
  }

  def "UPDATE target table using its own values in a subquery in FROM clause should parse"() {
    when:
    String sql = """UPDATE p
                  |SET p.SRP = p.SRP + averages.avg_diff
                  |FROM foodmart.product AS p
                  |JOIN (
                  |  SELECT
                  |    product_class_id,
                  |    AVG(SRP - net_weight * 10) AS avg_diff
                  |  FROM foodmart.product
                  |  GROUP BY product_class_id
                  |) AS averages ON p.product_class_id = averages.product_class_id
                  |WHERE p.SRP < 50""".stripMargin()
    then:
    parse(sql).check("""UPDATE p SET p.SRP = p.SRP + averages.avg_diff
                      |FROM foodmart.product AS p INNER JOIN (SELECT product_class_id, AVG(SRP - net_weight * 10) AS avg_diff
                      |FROM foodmart.product
                      |GROUP BY product_class_id) AS averages ON p.product_class_id = averages.product_class_id
                      |WHERE p.SRP < 50""".stripMargin())
  }

}
