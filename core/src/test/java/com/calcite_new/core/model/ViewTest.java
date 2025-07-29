package com.calcite_new.core.model;

import com.calcite_new.core.dialect.sql.BigQuerySqlDialect;
import com.calcite_new.core.model.entity.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private static final BigQuerySqlDialect DIALECT = new BigQuerySqlDialect();

    @Test
    void testViewFields() {
        List<Identifier> ns = List.of(Identifier.of("db", DIALECT));
        Identifier name = Identifier.of("view", DIALECT);
        List<Column> columns = List.of();
        String sql = "SELECT 1";
        View view = new View(ns, name, columns, sql, System.currentTimeMillis());
        assertEquals("view", view.getName().getName());
        assertEquals(sql, view.getSql());
        assertNotNull(view.getColumns());
    }
}
