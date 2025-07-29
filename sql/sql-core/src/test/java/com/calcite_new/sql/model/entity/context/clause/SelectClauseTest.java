package com.calcite_new.sql.model.entity.context.clause;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SelectClauseTest {

    @Test
    void testBuilderAndGetters() {
        SelectClause clause = SelectClause.builder()
                .hasSelectAll(true)
                .hasDistinct(false)
                .unusedColumns(List.of("a", "b"))
                .build();
        assertTrue(clause.getHasSelectAll());
        assertFalse(clause.getHasDistinct());
        assertEquals(List.of("a", "b"), clause.getUnusedColumns());
    }

    @Test
    void testSetters() {
        SelectClause clause = new SelectClause();
        clause.setHasSelectAll(false);
        clause.setHasDistinct(true);
        clause.setUnusedColumns(null);
        assertFalse(clause.getHasSelectAll());
        assertTrue(clause.getHasDistinct());
        assertNull(clause.getUnusedColumns());
    }
}
