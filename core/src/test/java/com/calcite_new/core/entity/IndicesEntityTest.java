package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class IndicesEntityTest {
    @Test
    void testBuilderAndFields() {
        IndicesEntity entity = IndicesEntity.builder()
                .sourceProduct("prod")
                .database("db")
                .schema("sch")
                .indexName("idx")
                .userName("user")
                .columnList(List.of("col1","col2"))
                .indexIdentifier("id")
                .indexType("btree")
                .ddlStatement("ddl")
                .isUnique(true)
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("idx", entity.getIndexName());
        assertEquals(List.of("col1","col2"), entity.getColumnList());
        assertTrue(entity.getIsUnique());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        IndicesEntity entity = new IndicesEntity();
        entity.setDatabase("db");
        entity.setSchema("sch");
        entity.setIndexName("idx");
        entity.setColumnList(List.of("col"));
        entity.setIsUnique(false);
        entity.setCreateAt(123L);
        entity.setUpdateAt(456L);
        entity.setInstance("inst");
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("idx", entity.getIndexName());
        assertEquals(List.of("col"), entity.getColumnList());
        assertFalse(entity.getIsUnique());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCode() {
        IndicesEntity entity1 = IndicesEntity.builder().indexName("idx").build();
        IndicesEntity entity2 = IndicesEntity.builder().indexName("idx").build();
        IndicesEntity entity3 = IndicesEntity.builder().indexName("other").build();
        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
    }

    @Test
    void testToString() {
        IndicesEntity entity = IndicesEntity.builder().indexName("idx").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("idx"));
    }

    @Test
    void testAllArgsConstructor() {
        IndicesEntity entity = new IndicesEntity(
            "prod", "db", "sch", "idx", "user", List.of("col"), "id", "btree", "ddl", true, 123L, 456L, "inst"
        );
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("idx", entity.getIndexName());
        assertEquals(List.of("col"), entity.getColumnList());
        assertTrue(entity.getIsUnique());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEmptyAndNullCollections() {
        IndicesEntity entity = new IndicesEntity();
        entity.setColumnList(null);
        assertNull(entity.getColumnList());
        entity.setColumnList(java.util.Collections.emptyList());
        assertTrue(entity.getColumnList().isEmpty());
    }
}
