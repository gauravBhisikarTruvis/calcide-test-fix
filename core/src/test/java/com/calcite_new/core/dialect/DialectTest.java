package com.calcite_new.core.dialect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.calcite_new.core.dialect.Product;

class DialectTest {
    static class DummyDialect extends Dialect {
        public DummyDialect() { super(Product.BIGQUERY); }
        @Override public int supportedQualificationLevels() { return 0; }
        @Override public String normalize(String s) { return s; }
    }
    @Test
    void testDialectToString() {
        DummyDialect dialect = new DummyDialect();
        assertNotNull(dialect.toString());
        assertEquals(0, dialect.supportedQualificationLevels());
        assertEquals("test", dialect.normalize("test"));
    }
}
