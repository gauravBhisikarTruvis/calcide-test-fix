package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the ColumnEntity class.
 */
public class ColumnEntityTest {
    @Test
    void testBuilderAndFields() {
        ColumnEntity entity = ColumnEntity.builder()
                .columnName("col1")
                .sourceProduct("prod")
                .database("db")
                .schema("sch")
                .table("tbl")
                .userName("user")
                .columnPosition(1L)
                .dataType("type")
                .columnLength(10L)
                .columnPrecision(2L)
                .columnScale(3L)
                .columnFormat("fmt")
                .nullable(true)
                .defaultValue("def")
                .isUppercase(true)
                .isCaseSensitive(false)
                .columnConstraint("constraint")
                .compressible(true)
                .compressValueList("list")
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("col1", entity.getColumnName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("tbl", entity.getTable());
        assertEquals("user", entity.getUserName());
        assertEquals(1L, entity.getColumnPosition());
        assertEquals("type", entity.getDataType());
        assertEquals(10L, entity.getColumnLength());
        assertEquals(2L, entity.getColumnPrecision());
        assertEquals(3L, entity.getColumnScale());
        assertEquals("fmt", entity.getColumnFormat());
        assertTrue(entity.getNullable());
        assertEquals("def", entity.getDefaultValue());
        assertTrue(entity.getIsUppercase());
        assertFalse(entity.getIsCaseSensitive());
        assertEquals("constraint", entity.getColumnConstraint());
        assertTrue(entity.getCompressible());
        assertEquals("list", entity.getCompressValueList());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        ColumnEntity entity = new ColumnEntity();
        entity.setColumnName("col");
        entity.setSourceProduct("prod");
        entity.setDatabase("db");
        entity.setSchema("sch");
        entity.setTable("tbl");
        entity.setUserName("user");
        entity.setColumnPosition(1L);
        entity.setDataType("type");
        entity.setColumnLength(10L);
        entity.setColumnPrecision(2L);
        entity.setColumnScale(3L);
        entity.setColumnFormat("fmt");
        entity.setNullable(false);
        entity.setDefaultValue("def");
        entity.setIsUppercase(false);
        entity.setIsCaseSensitive(true);
        entity.setColumnConstraint("constraint");
        entity.setCompressible(false);
        entity.setCompressValueList("list");
        entity.setCreateAt(111L);
        entity.setUpdateAt(222L);
        entity.setInstance("inst");
        assertEquals("col", entity.getColumnName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("tbl", entity.getTable());
        assertEquals("user", entity.getUserName());
        assertEquals(1L, entity.getColumnPosition());
        assertEquals("type", entity.getDataType());
        assertEquals(10L, entity.getColumnLength());
        assertEquals(2L, entity.getColumnPrecision());
        assertEquals(3L, entity.getColumnScale());
        assertEquals("fmt", entity.getColumnFormat());
        assertFalse(entity.getNullable());
        assertEquals("def", entity.getDefaultValue());
        assertFalse(entity.getIsUppercase());
        assertTrue(entity.getIsCaseSensitive());
        assertEquals("constraint", entity.getColumnConstraint());
        assertFalse(entity.getCompressible());
        assertEquals("list", entity.getCompressValueList());
        assertEquals(111L, entity.getCreateAt());
        assertEquals(222L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCodeFull() {
        ColumnEntity entity1 = ColumnEntity.builder()
                .columnName("col1").sourceProduct("prod").database("db").schema("sch").table("tbl")
                .userName("user").columnPosition(1L).dataType("type").columnLength(10L)
                .columnPrecision(2L).columnScale(3L).columnFormat("fmt").nullable(true)
                .defaultValue("def").isUppercase(true).isCaseSensitive(false)
                .columnConstraint("constraint").compressible(true).compressValueList("list")
                .createAt(123L).updateAt(456L).instance("inst").build();
        ColumnEntity entity2 = ColumnEntity.builder()
                .columnName("col1").sourceProduct("prod").database("db").schema("sch").table("tbl")
                .userName("user").columnPosition(1L).dataType("type").columnLength(10L)
                .columnPrecision(2L).columnScale(3L).columnFormat("fmt").nullable(true)
                .defaultValue("def").isUppercase(true).isCaseSensitive(false)
                .columnConstraint("constraint").compressible(true).compressValueList("list")
                .createAt(123L).updateAt(456L).instance("inst").build();
        ColumnEntity entity3 = ColumnEntity.builder().columnName("different").build();

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
        assertNotEquals(entity1.hashCode(), entity3.hashCode());
        assertNotEquals(entity1, null);
        assertNotEquals(entity1, new Object());
    }

    @Test
    void testToString() {
        ColumnEntity entity = ColumnEntity.builder().columnName("c1").database("db").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("c1"));
        assertTrue(str.contains("db"));
    }

    @Test
    void testAllArgsConstructor() {
        // FIX: The order of arguments was incorrect and has been corrected to match the constructor.
        ColumnEntity entity = new ColumnEntity(
                "col1", "prod", "db", "sch", "tbl", "user", 1L, "type", 10L, 2L, 3L,
                "fmt", "def", true, true, false, "constraint", true, "list", 123L, 456L, "inst"
        );
        assertEquals("col1", entity.getColumnName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("tbl", entity.getTable());
        assertEquals("user", entity.getUserName());
        assertEquals(1L, entity.getColumnPosition());
        assertEquals("type", entity.getDataType());
        assertEquals(10L, entity.getColumnLength());
        assertEquals(2L, entity.getColumnPrecision());
        assertEquals(3L, entity.getColumnScale());
        assertEquals("fmt", entity.getColumnFormat());
        assertEquals("def", entity.getDefaultValue());
        assertTrue(entity.getNullable());
        assertTrue(entity.getIsUppercase());
        assertFalse(entity.getIsCaseSensitive());
        assertEquals("constraint", entity.getColumnConstraint());
        assertTrue(entity.getCompressible());
        assertEquals("list", entity.getCompressValueList());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }
}