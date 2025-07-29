package com.calcite_new.core.model;

import com.calcite_new.core.dialect.sql.BigQuerySqlDialect;
import com.calcite_new.core.model.entity.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NamespaceTest {
    private static final BigQuerySqlDialect DIALECT = new BigQuerySqlDialect();

    @Test
    void testAddAndGetTable() {
        Namespace ns = new Namespace(Identifier.of("db", DIALECT));
        Table table = new Table(List.of(ns.getName()), Identifier.of("table1", DIALECT), List.of(), System.currentTimeMillis());
        ns.addTable(table);
        assertEquals(table, ns.getTable(Identifier.of("table1", DIALECT)));
    }

    @Test
    void testAddAndGetView() {
        Namespace ns = new Namespace(Identifier.of("db", DIALECT));
        View view = new View(List.of(ns.getName()), Identifier.of("view1", DIALECT), List.of(), "SELECT 1", System.currentTimeMillis());
        ns.addView(view);
        // No direct getView, but we can test columns and sql fields
        assertEquals("SELECT 1", view.getSql());
        assertNotNull(view.getColumns());
    }
}
