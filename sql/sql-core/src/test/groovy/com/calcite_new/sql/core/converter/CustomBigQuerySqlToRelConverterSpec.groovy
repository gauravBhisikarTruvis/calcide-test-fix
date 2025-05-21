package com.calcite_new.sql.core.converter

import groovy.transform.CompileDynamic
import spock.lang.Specification

/**
 * This class is used to test the SqlNode to RelNode conversion functionality for BigQuery
 */
@CompileDynamic
class CustomBigQuerySqlToRelConverterSpec extends Specification {

  def "Simple SELECT with all columns should be processed"() {
    when:
    String sql = """SELECT *
                   |FROM foodmart.employee""".stripMargin()

    then:
    String expectedPlan = """LogicalTableScan(table=[[big_query, test, foodmart, employee]])
                            |""".stripMargin()
    withSql(sql).check(expectedPlan)
  }

  def "SELECT with column selection should be processed"() {
    when:
    String sql = """SELECT employee_id, full_name, salary
                 |FROM employee""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(employee_id=[\$0], full_name=[\$1], salary=[\$11])
                         |  LogicalTableScan(table=[[big_query, test, foodmart-test, employee]])
                         |""".stripMargin())
  }

  def "SELECT with WHERE clause should be processed"() {
    when:
    String sql = """SELECT product_id, product_name, SKU
                 |FROM `foodmart`.`product`
                 |WHERE low_fat = TRUE""".stripMargin()

    then:
    String expectedPlan = """LogicalProject(product_id=[\$1], product_name=[\$3], SKU=[\$4])
                            |  LogicalFilter(condition=[=(\$9, true)])
                            |    LogicalTableScan(table=[[big_query, test, foodmart, product]])
                            |""".stripMargin()
    withSql(sql).check(expectedPlan)
  }

  def "SELECT with GROUP BY and aggregation should be processed"() {
    when:
    String sql = """SELECT store_id, SUM(store_sales) as total_sales
                 |FROM sales_fact_1997
                 |GROUP BY store_id""".stripMargin()

    then:
    withSql(sql).check("""LogicalAggregate(group=[{4}], total_sales=[SUM(\$5)])
                         |  LogicalTableScan(table=[[big_query, test, foodmart-test, sales_fact_1997]])
                         |""".stripMargin())
  }

  def "SELECT with ORDER BY should be processed"() {
    when:
    String sql = """SELECT customer_id, fname, lname
                 |FROM foodmart.`customer`
                 |ORDER BY lname ASC, fname DESC""".stripMargin()

    then:
    withSql(sql).check("""LogicalSort(sort0=[\$2], sort1=[\$1], dir0=[ASC], dir1=[DESC])
                         |  LogicalProject(customer_id=[\$0], fname=[\$3], lname=[\$2])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, customer]])
                         |""".stripMargin())
  }

  def "SELECT with LIMIT clause should be processed"() {
    when:
    String sql = """SELECT promotion_id, promotion_name, media_type
                 |FROM foodmart.promotion
                 |LIMIT 10""".stripMargin()

    then:
    withSql(sql).check("""LogicalSort(fetch=[10])
                         |  LogicalProject(promotion_id=[\$0], promotion_name=[\$2], media_type=[\$3])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, promotion]])
                         |""".stripMargin())
  }

  def "SELECT with JOIN should be processed"() {
    when:
    String sql = """SELECT s.store_id, s.store_name, e.employee_id, e.full_name
                 |FROM `foodmart`.store s
                 |JOIN `foodmart`.employee e ON s.store_id = e.store_id""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(store_id=[\$0], store_name=[\$3], employee_id=[\$24], full_name=[\$25])
                         |  LogicalJoin(condition=[=(\$0, \$30)], joinType=[inner])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, store]])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, employee]])
                         |""".stripMargin())
  }

  def "SELECT with LEFT JOIN should be processed"() {
    when:
    String sql = """SELECT c.customer_id, c.fullname, sf.store_sales
                 |FROM foodmart.customer c
                 |LEFT JOIN `foodmart`.`sales_fact_1997` sf ON c.customer_id = sf.customer_id""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(customer_id=[\$0], fullname=[\$28], store_sales=[\$34])
                         |  LogicalJoin(condition=[=(\$0, \$31)], joinType=[left])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, customer]])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |""".stripMargin())
  }

  def "SELECT with multiple JOINs should be processed"() {
    when:
    String sql = """SELECT sf.product_id, p.product_name, pc.product_category, sf.store_sales
                 |FROM foodmart.sales_fact_1997 sf
                 |JOIN foodmart.product p ON sf.product_id = p.product_id
                 |JOIN foodmart.product_class pc ON p.product_class_id = pc.product_class_id""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(product_id=[\$0], product_name=[\$11], product_category=[\$25], store_sales=[\$5])
                         |  LogicalJoin(condition=[=(\$8, \$23)], joinType=[inner])
                         |    LogicalJoin(condition=[=(\$0, \$9)], joinType=[inner])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, product]])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, product_class]])
                         |""".stripMargin())
  }

  def "SELECT with HAVING clause should be processed"() {
    when:
    String sql = """SELECT store_id, SUM(store_sales) as total_sales
                 |FROM `foodmart`.`sales_fact_1997`
                 |GROUP BY store_id
                 |HAVING SUM(store_sales) > 10000""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(store_id=[\$0], total_sales=[\$2])
                         |  LogicalFilter(condition=[>(\$2, 10000)])
                         |    LogicalAggregate(group=[{4}], total_sales=[SUM(\$5)], \$f1=[SUM(\$5)])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |""".stripMargin())
  }

  def "SELECT with complex expression in GROUP BY clause should be processed"() {
    when:
    String sql = """SELECT EXTRACT(YEAR FROM time_by_day.the_date) AS year,
                   |       EXTRACT(MONTH FROM time_by_day.the_date) AS month,
                   |       SUM(sales_fact_1997.store_sales) AS total_sales
                   |FROM foodmart.time_by_day
                   |JOIN foodmart.sales_fact_1997 ON time_by_day.time_id = sales_fact_1997.time_id
                   |GROUP BY EXTRACT(YEAR FROM time_by_day.the_date)""".stripMargin()

    then:
    withSql(sql).check("""LogicalFilter(condition=[>(\$1, 10000.0E0)])
                         |  LogicalAggregate(group=[{0}], total_sales=[SUM(\$1)])
                         |    LogicalProject(store_id=[\$4], store_sales=[\$5])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |""".stripMargin())
  }

  def "SELECT with subquery should be processed"() {
    when:
    String sql = """SELECT store_id, store_name
                 |FROM foodmart.store
                 |WHERE store_id IN (
                 |  SELECT DISTINCT store_id
                 |  FROM `foodmart`.`sales_fact_1997`
                 |  WHERE store_sales > 100
                 |)""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(store_id=[\$0], store_name=[\$3])
                         |  LogicalFilter(condition=[IN(\$0, {
                         |LogicalAggregate(group=[{0}])
                         |  LogicalProject(store_id=[\$4])
                         |    LogicalFilter(condition=[>(\$5, 100)])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |})])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, store]])
                         |""".stripMargin())
  }

  def "SELECT with date functions should be processed"() {
    when:
    String sql = """SELECT time_id, EXTRACT(YEAR FROM the_date) as year, EXTRACT(MONTH FROM the_date) as month
                 |FROM foodmart.time_by_day
                 |WHERE EXTRACT(YEAR FROM the_date) = 1997""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(time_id=[\$0], year=[EXTRACT('YEAR', \$1)], month=[EXTRACT('MONTH', \$1)])
                         |  LogicalFilter(condition=[=(EXTRACT('YEAR', \$1), 1997)])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, time_by_day]])
                         |""".stripMargin())
  }

  def "SELECT with CASE expression should be processed"() {
    when:
    String sql = """SELECT customer_id, yearly_income,
                 |CASE
                 |  WHEN yearly_income = 'High' THEN 'Premium'
                 |  WHEN yearly_income = 'Medium' THEN 'Standard'
                 |  ELSE 'Basic'
                 |END AS customer_tier
                 |FROM `foodmart`.customer""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(customer_id=[\$0], yearly_income=[\$18], customer_tier=[CASE(=(\$18, 'High'), 'Premium', =(\$18, 'Medium'), 'Standard', 'Basic')])
                         |  LogicalTableScan(table=[[big_query, test, foodmart, customer]])
                         |""".stripMargin())
  }

  def "SELECT with UNION should be processed"() {
    when:
    String sql = """SELECT product_id, time_id, store_sales
                 |FROM foodmart.sales_fact_1997
                 |UNION ALL
                 |SELECT product_id, time_id, store_sales
                 |FROM `foodmart`.`sales_fact_1998`""".stripMargin()

    then:
    withSql(sql).check("""LogicalUnion(all=[true])
                         |  LogicalProject(product_id=[\$0], time_id=[\$1], store_sales=[\$5])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |  LogicalProject(product_id=[\$0], time_id=[\$1], store_sales=[\$5])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1998]])
                         |""".stripMargin())
  }

  def "SELECT with complex WHERE conditions should be processed"() {
    when:
    String sql = """SELECT store_id, store_name, store_type
                 |FROM store
                 |WHERE (store_type = 'Supermarket' OR store_type = 'Deluxe Supermarket')
                 |AND store_sqft > 20000
                 |AND coffee_bar = TRUE""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(store_id=[\$0], store_name=[\$3], store_type=[\$1])
                         |  LogicalFilter(condition=[AND(OR(=(\$1, 'Supermarket'), =(\$1, 'Deluxe Supermarket')), >(\$15, 20000), =(\$19, true))])
                         |    LogicalTableScan(table=[[big_query, test, foodmart-test, store]])
                         |""".stripMargin())
  }

  def "SELECT with window functions should be processed"() {
    when:
    String sql = """SELECT employee_id, full_name, salary,
                 |RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) as salary_rank
                 |FROM `foodmart`.`employee`""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(employee_id=[\$0], full_name=[\$1], salary=[\$11], salary_rank=[RANK() OVER (PARTITION BY \$7 ORDER BY \$11 DESC)])
                         |  LogicalTableScan(table=[[big_query, test, foodmart, employee]])
                         |""".stripMargin())
  }

  def "SELECT with aggregations and math operations should be processed"() {
    when:
    String sql = """SELECT product_id,
                 |AVG(store_sales) as avg_sales,
                 |SUM(store_sales) / SUM(unit_sales) as avg_price
                 |FROM `sales_fact_1997`
                 |GROUP BY product_id""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(product_id=[\$0], avg_sales=[\$1], avg_price=[/(\$2, \$3)])
                         |  LogicalAggregate(group=[{0}], avg_sales=[AVG(\$5)], \$f1=[SUM(\$5)], \$f2=[SUM(\$7)])
                         |    LogicalTableScan(table=[[big_query, test, foodmart-test, sales_fact_1997]])
                         |""".stripMargin())
  }

  def "SELECT with common table expression (CTE) should be processed"() {
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
    withSql(sql).check("""LogicalProject(product_id=[\$0], product_name=[\$5], total_sales=[\$1])
                         |  LogicalJoin(condition=[=(\$0, \$3)], joinType=[inner])
                         |    LogicalSort(sort0=[\$1], dir0=[DESC], fetch=[10])
                         |      LogicalAggregate(group=[{0}], total_sales=[SUM(\$5)])
                         |        LogicalTableScan(table=[[big_query, test, foodmart, sales_fact_1997]])
                         |    LogicalTableScan(table=[[big_query, test, foodmart-test, product]])
                         |""".stripMargin())
  }

  def "SELECT with DISTINCT should be processed"() {
    when:
    String sql = """SELECT DISTINCT product_category, product_family
                 |FROM `foodmart`.product_class
                 |ORDER BY product_family, product_category""".stripMargin()

    then:
    withSql(sql).check("""LogicalSort(sort0=[\$1], sort1=[\$0], dir0=[ASC], dir1=[ASC])
                         |  LogicalAggregate(group=[{0, 1}])
                         |    LogicalProject(product_category=[\$2], product_family=[\$4])
                         |      LogicalTableScan(table=[[big_query, test, foodmart, product_class]])
                         |""".stripMargin())
  }

  def "SELECT with timestamp operations should be processed"() {
    when:
    String sql = """SELECT store_id, 
                 |TIMESTAMP_DIFF(last_remodel_date, first_opened_date, DAY) as days_until_remodel
                 |FROM foodmart.store
                 |WHERE first_opened_date IS NOT NULL
                 |AND last_remodel_date IS NOT NULL""".stripMargin()

    then:
    withSql(sql).check("""LogicalProject(store_id=[\$0], days_until_remodel=[TIMESTAMP_DIFF(\$14, \$13, 'DAY')])
                         |  LogicalFilter(condition=[AND(IS NOT NULL(\$13), IS NOT NULL(\$14))])
                         |    LogicalTableScan(table=[[big_query, test, foodmart, store]])
                         |""".stripMargin())
  }

  private static SqlToRelConverterFixture withSql(String sql) {
    BigQuerySqlToRelConverterFixture.with(sql)
  }

}
