package com.calcite_new.core.dialect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testProductEnum() {
        for (Product p : Product.values()) {
            assertNotNull(p.name());
            assertNotNull(p.toString());
        }
        assertNotNull(Product.valueOf(Product.values()[0].name()));
    }
}
