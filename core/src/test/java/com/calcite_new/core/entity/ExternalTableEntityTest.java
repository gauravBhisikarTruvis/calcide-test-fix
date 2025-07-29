package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExternalTableEntityTest {
    @Test
    void testBuilderAndFields() {
        ExternalTableEntity entity = ExternalTableEntity.builder()
                .sourceProduct("prod")
                .database("db")
                .schema("sch")
                .externalTableName("ext")
                .externalTableType("type")
                .externalObjectName("obj")
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("ext", entity.getExternalTableName());
        assertEquals("type", entity.getExternalTableType());
        assertEquals("obj", entity.getExternalObjectName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        ExternalTableEntity entity = new ExternalTableEntity();
        entity.setSourceProduct("prod");
        entity.setDatabase("db");
        entity.setSchema("sch");
        entity.setExternalTableName("ext");
        entity.setExternalTableType("type");
        entity.setExternalObjectName("obj");
        entity.setCreateAt(123L);
        entity.setUpdateAt(456L);
        entity.setInstance("inst");
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("ext", entity.getExternalTableName());
        assertEquals("type", entity.getExternalTableType());
        assertEquals("obj", entity.getExternalObjectName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCode() {
        ExternalTableEntity entity1 = ExternalTableEntity.builder().externalTableName("ext").build();
        ExternalTableEntity entity2 = ExternalTableEntity.builder().externalTableName("ext").build();
        ExternalTableEntity entity3 = ExternalTableEntity.builder().externalTableName("other").build();
        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
    }

    @Test
    void testToString() {
        ExternalTableEntity entity = ExternalTableEntity.builder().externalTableName("ext").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("ext"));
    }

    @Test
    void testAllArgsConstructor() {
        ExternalTableEntity entity = new ExternalTableEntity(
            "prod", "db", "sch", "ext", "type", "obj", 123L, 456L, "inst"
        );
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("ext", entity.getExternalTableName());
        assertEquals("type", entity.getExternalTableType());
        assertEquals("obj", entity.getExternalObjectName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }
}
