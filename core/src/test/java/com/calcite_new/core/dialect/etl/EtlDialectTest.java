package com.calcite_new.core.dialect.etl;

import com.calcite_new.core.dialect.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtlDialectTest {
    static class DummyEtlDialect extends EtlDialect {
        public DummyEtlDialect() { super(Product.BIGQUERY); }
        @Override public String normalize(String s) { return s; }
    }
    @Test
    void testEtlDialectClass() {
        DummyEtlDialect dialect = new DummyEtlDialect();
        assertNotNull(dialect.toString());
        assertEquals("abc", dialect.normalize("abc"));
    }
}
