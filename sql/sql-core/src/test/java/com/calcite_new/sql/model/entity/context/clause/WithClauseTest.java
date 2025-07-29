package com.calcite_new.sql.model.entity.context.clause;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WithClauseTest {

    @Test
    void testConstructor() {
        WithClause clause = new WithClause();
        assertNotNull(clause);
    }
}
