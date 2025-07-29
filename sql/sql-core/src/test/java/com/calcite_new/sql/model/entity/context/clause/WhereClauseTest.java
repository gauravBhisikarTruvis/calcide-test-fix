package com.calcite_new.sql.model.entity.context.clause;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WhereClauseTest {

    @Test
    void testBuilderAndGetters() {
        WhereClause clause = WhereClause.builder()
                .hasTrueCondition(true)
                .hasCaseInsensitiveComparison(false)
                .hasInWithSubquery(true)
                .hasInWithConstant(false)
                .build();
        assertTrue(clause.getHasTrueCondition());
        assertFalse(clause.getHasCaseInsensitiveComparison());
        assertTrue(clause.getHasInWithSubquery());
        assertFalse(clause.getHasInWithConstant());
    }

    @Test
    void testSetters() {
        WhereClause clause = new WhereClause();
        clause.setHasTrueCondition(null);
        clause.setHasCaseInsensitiveComparison(true);
        clause.setHasInWithSubquery(false);
        clause.setHasInWithConstant(null);
        assertNull(clause.getHasTrueCondition());
        assertTrue(clause.getHasCaseInsensitiveComparison());
        assertFalse(clause.getHasInWithSubquery());
        assertNull(clause.getHasInWithConstant());
    }
}
