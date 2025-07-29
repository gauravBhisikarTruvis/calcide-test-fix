package com.calcite_new.core.dialect.etl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataStageDialectTest {
    @Test
    void testDataStageDialectClass() {
        DataStageDialect dialect = new DataStageDialect();
        assertNotNull(dialect.toString());
    }
}
