package com.calcite_new.core.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryConfigTest {
    @Test
    void testRepositoryConfigInstantiation() {
        RepositoryConfig config = new RepositoryConfig();
        assertNotNull(config);
    }
}
