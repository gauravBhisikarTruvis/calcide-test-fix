package com.calcite_new.sql.model.entity.context.clause;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderByClauseTest {

    @Test
    void testField() {
        OrderByClause clause = new OrderByClause();
        clause.isInsideSubQuery = true;
        assertTrue(clause.isInsideSubQuery);
        clause.isInsideSubQuery = false;
        assertFalse(clause.isInsideSubQuery);
    }
}
