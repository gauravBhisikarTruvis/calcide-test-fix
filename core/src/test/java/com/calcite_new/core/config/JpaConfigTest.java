package com.calcite_new.core.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JpaConfigTest {
    @Test
    void testJpaConfigInstantiation() {
        JpaConfig config = new JpaConfig();
        assertNotNull(config);
    }
}
