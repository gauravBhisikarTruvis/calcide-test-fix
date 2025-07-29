package com.calcite_new.core.dialect.sql;

import com.calcite_new.core.dialect.Dialect;
import com.calcite_new.core.dialect.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqlDialectTest {
    static class DummySqlDialect extends SqlDialect {
        public DummySqlDialect() { super(Product.BIGQUERY); }
        @Override public String identifierQuote() { return "`"; }
        @Override public int supportedQualificationLevels() { return 0; }
        @Override public String normalize(String s) { return s; }
    }
    @Test
    void testSqlDialectToString() {
        DummySqlDialect dialect = new DummySqlDialect();
        assertNotNull(dialect.toString());
        assertNotNull(dialect.identifierQuote());
        assertEquals(0, dialect.supportedQualificationLevels());
        assertEquals("foo", dialect.normalize("foo"));
    }
}
