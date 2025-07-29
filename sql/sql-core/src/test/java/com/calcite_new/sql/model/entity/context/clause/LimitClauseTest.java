package com.calcite_new.sql.model.entity.context.clause;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LimitClauseTest {

    @Test
    void testConstructor() {
        LimitClause clause = new LimitClause();
        assertNotNull(clause);
    }
}
