package com.calcite_new.core.model;

import com.calcite_new.core.dialect.sql.BigQuerySqlDialect;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {
    @Test
    void testOfAndEquals() {
        var dialect = new BigQuerySqlDialect();
        Identifier id1 = Identifier.of("foo", dialect);
        Identifier id2 = Identifier.of("foo", dialect);
        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
        assertEquals("foo", id1.getName());
        assertNotNull(id1.toString());
    }
}
