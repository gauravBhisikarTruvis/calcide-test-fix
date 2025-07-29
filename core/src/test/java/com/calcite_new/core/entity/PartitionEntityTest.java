package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the PartitionEntity class.
 */
public class PartitionEntityTest {
    @Test
    void testBuilderAndFields() {
        PartitionEntity entity = PartitionEntity.builder()
                .sourceProduct("prod")
                .partitionName("part")
                .tableName("tbl")
                .schema("sch")
                .database("db")
                .partitionColumns(List.of("col1"))
                .partitionText("text")
                .userName("user")
                .partitionSizeBytes(123L)
                .createAt(123L)
                .instance("inst")
                .build();
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("part", entity.getPartitionName());
        assertEquals("tbl", entity.getTableName());
        assertEquals("sch", entity.getSchema());
        assertEquals("db", entity.getDatabase());
        assertEquals(List.of("col1"), entity.getPartitionColumns());
        assertEquals("text", entity.getPartitionText());
        assertEquals("user", entity.getUserName());
        assertEquals(123L, entity.getPartitionSizeBytes());
        assertEquals(123L, entity.getCreateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        PartitionEntity entity = new PartitionEntity();
        entity.setSourceProduct("prod");
        entity.setPartitionName("part");
        entity.setTableName("tbl");
        entity.setSchema("sch");
        entity.setDatabase("db");
        entity.setPartitionColumns(List.of("col"));
        entity.setPartitionText("text");
        entity.setUserName("user");
        entity.setPartitionSizeBytes(200L);
        entity.setCreateAt(123L);
        entity.setInstance("inst");
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("part", entity.getPartitionName());
        assertEquals("tbl", entity.getTableName());
        assertEquals("sch", entity.getSchema());
        assertEquals("db", entity.getDatabase());
        assertEquals(List.of("col"), entity.getPartitionColumns());
        assertEquals("text", entity.getPartitionText());
        assertEquals("user", entity.getUserName());
        assertEquals(200L, entity.getPartitionSizeBytes());
        assertEquals(123L, entity.getCreateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCode() {
        PartitionEntity entity1 = PartitionEntity.builder().partitionName("part").database("db").build();
        PartitionEntity entity2 = PartitionEntity.builder().partitionName("part").database("db").build();
        PartitionEntity entity3 = PartitionEntity.builder().partitionName("other").database("db").build();

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
        assertNotEquals(entity1, null);
        assertNotEquals(entity1, new Object());
    }

    @Test
    void testToString() {
        PartitionEntity entity = PartitionEntity.builder().partitionName("part").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("part"));
    }

    @Test
    void testAllArgsConstructor() {
        // FIX: The order of arguments was incorrect and has been corrected.
        PartitionEntity entity = new PartitionEntity(
                "prod", "db", "sch", "tbl", "part", List.of("col"), "text", "user", 456L, 123L, "inst"
        );
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("tbl", entity.getTableName());
        assertEquals("part", entity.getPartitionName());
        assertEquals(List.of("col"), entity.getPartitionColumns());
        assertEquals("text", entity.getPartitionText());
        assertEquals("user", entity.getUserName());
        assertEquals(456L, entity.getPartitionSizeBytes());
        assertEquals(123L, entity.getCreateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEmptyAndNullPartitionColumns() {
        PartitionEntity entity = new PartitionEntity();
        entity.setPartitionColumns(null);
        assertNull(entity.getPartitionColumns());
        entity.setPartitionColumns(Collections.emptyList());
        assertTrue(entity.getPartitionColumns().isEmpty());
    }
}