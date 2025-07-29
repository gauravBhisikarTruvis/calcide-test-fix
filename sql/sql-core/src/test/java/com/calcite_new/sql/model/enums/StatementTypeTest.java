package com.calcite_new.sql.model.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatementTypeTest {
    @Test
    void testEnumValues() {
        assertEquals(StatementType.INSERT.family, StatementTypeFamily.DML);
        assertEquals(StatementType.SELECT.family, StatementTypeFamily.DRL);
        assertTrue(StatementType.DMLS.contains(StatementType.INSERT));
        assertTrue(StatementType.DDLS.contains(StatementType.CREATE_TABLE));
    }
}
