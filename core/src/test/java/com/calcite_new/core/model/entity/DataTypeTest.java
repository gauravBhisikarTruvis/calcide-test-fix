package com.calcite_new.core.model.entity;

import org.apache.calcite.sql.type.SqlTypeName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataTypeTest {
    @Test
    void testDataTypeWithPrecisionAndScale() {
        // Type that allows precision and scale (e.g., DECIMAL)
        DataType dt = DataType.create(SqlTypeName.DECIMAL, 10, 2, true);
        assertNotNull(dt);
        assertEquals(SqlTypeName.DECIMAL, dt.getName());
        assertEquals(10, dt.getPrecision());
        assertEquals(2, dt.getScale());
        assertTrue(dt.isNullable());
    }

    @Test
    void testDataTypeWithPrecisionOnly() {
        // Type that allows precision but not scale (e.g., VARCHAR)
        DataType dt = DataType.create(SqlTypeName.VARCHAR, 50, true);
        assertNotNull(dt);
        assertEquals(SqlTypeName.VARCHAR, dt.getName());
        assertEquals(50, dt.getPrecision());
        assertEquals(-1, dt.getScale());
        assertTrue(dt.isNullable());
    }

    @Test
    void testDataTypeWithoutPrecisionOrScale() {
        // Type that allows neither precision nor scale (e.g., DATE)
        DataType dt = DataType.create(SqlTypeName.DATE, false);
        assertNotNull(dt);
        assertEquals(SqlTypeName.DATE, dt.getName());
        assertEquals(-1, dt.getPrecision());
        assertEquals(-1, dt.getScale());
        assertFalse(dt.isNullable());
    }

    @Test
    void testDataTypeWithOnlyType() {
        // Use default nullable true
        DataType dt = DataType.create(SqlTypeName.BOOLEAN);
        assertNotNull(dt);
        assertEquals(SqlTypeName.BOOLEAN, dt.getName());
        assertTrue(dt.isNullable());
    }
}
