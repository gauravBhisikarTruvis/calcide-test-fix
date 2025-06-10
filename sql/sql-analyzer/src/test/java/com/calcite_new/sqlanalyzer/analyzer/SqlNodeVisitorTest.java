package com.calcite_new.sqlanalyzer.analyzer;

import com.calcite_new.sql.parser.BigQuerySqlParser;
import com.calcite_new.sqlanalyzer.analyzer.visitor.SqlNodeVisitor;
import com.calcite_new.sqlanalyzer.model.enums.QueryType;
import com.calcite_new.sqlanalyzer.model.entity.context.clause.SelectClause;
import org.apache.calcite.sql.SqlNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SqlNodeVisitorTest {

    private SqlNode parse(String sql) throws Exception {
        return new BigQuerySqlParser().parse(sql);
    }

    private SqlNodeVisitor getVisitor() {
        return new SqlNodeVisitor("stuti", "project1", "foodmart");
    }

    @Test
    public void testSelectAllFromSalesFact() throws Exception {
        String sql =  "SELECT *" +
                "FROM (" +
                "  SELECT *" +
                "  FROM foodmart.sales_fact_1998" +
                "  ORDER BY store_sales DESC" +
                ")" +
                "WHERE store_sales > 100;";
        SqlNode node = parse(sql);

        SqlNodeVisitor.Result result = node.accept(getVisitor());

        assertEquals(QueryType.SELECT, result.getQueryType());
        assertNotNull(result.getContext().getSelectClause());
        assertTrue(result.getContext().getSelectClause().getHasSelectAll());
        assertFalse(result.getContext().getSelectClause().getHasDistinct());
    }

    @Test
    public void testInClauseSubqueryProduct() throws Exception {
        String sql = "SELECT product_id FROM product WHERE product_id IN (SELECT product_id FROM sales_fact_1997)";
        SqlNode node = parse(sql);

        SqlNodeVisitor.Result result = node.accept(getVisitor());

        assertEquals(QueryType.SELECT, result.getQueryType());
        assertNotNull(result.getContext().getWhereClause());
       // assertFalse(result.getContext().getWhereClause().getInClauses().isEmpty());
       // assertTrue(result.getContext().getWhereClause().getInClauses().getFirst().isSubquery());
    }

    @Test
    public void testDeleteCustomerWhereTrue() throws Exception {
        String sql = "DELETE FROM customer WHERE TRUE";
        SqlNode node = parse(sql);

        SqlNodeVisitor.Result result = node.accept(getVisitor());

        assertEquals(QueryType.DELETE, result.getQueryType());
        assertTrue(result.getContext().getWhereClause().getHasTrueCondition());
    }

    @Test
    public void testDeleteStoreById() throws Exception {
        String sql = "DELETE FROM store WHERE store_id = 101";
        SqlNode node = parse(sql);

        SqlNodeVisitor.Result result = node.accept(getVisitor());

        assertEquals(QueryType.DELETE, result.getQueryType());
        assertFalse(result.getContext().getWhereClause().getHasTrueCondition());
    }

    @Test
    public void testInsertIntoWithSelectStar() throws Exception {
        String sql = "INSERT INTO sales_fact_copy SELECT * FROM sales_fact_1997";
        SqlNode node = parse(sql);

        SqlNodeVisitor.Result result = node.accept(getVisitor());

        assertEquals(QueryType.INSERT, result.getQueryType());

        SelectClause selectClause = result.getContext().getSelectClause();
        assertTrue(selectClause.getHasSelectAll());
    }
}
