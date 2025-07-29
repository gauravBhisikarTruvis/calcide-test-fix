package com.calcite_new.core.model;

import com.calcite_new.core.dialect.sql.BigQuerySqlDialect;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EntityQualifierTest {
    private static final BigQuerySqlDialect DIALECT = new BigQuerySqlDialect();

    @Test
    void testQualifiers() {
        EntityQualifier eq = new EntityQualifier(List.of("db", "sch", "tbl"), List.of("default"), DIALECT);
        assertNotNull(eq.getQualifiers());
        assertTrue(eq.toString().contains("EntityQualifier"));
    }
}
