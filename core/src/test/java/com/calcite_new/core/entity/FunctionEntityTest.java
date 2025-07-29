package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the FunctionEntity class.
 */
public class FunctionEntityTest {
    @Test
    void testBuilderAndFields() {
        FunctionEntity entity = FunctionEntity.builder()
                .functionName("fn")
                .sourceProduct("prod")
                .schema("sch")
                .database("db")
                .ExecutedSqlQuery("def")
                .userName("ret")
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("fn", entity.getFunctionName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("sch", entity.getSchema());
        assertEquals("db", entity.getDatabase());
        assertEquals("def", entity.getExecutedSqlQuery());
        assertEquals("ret", entity.getUserName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        FunctionEntity entity = new FunctionEntity();
        entity.setFunctionName("fn");
        entity.setSourceProduct("prod");
        entity.setSchema("sch");
        entity.setDatabase("db");
        entity.setExecutedSqlQuery("def");
        entity.setUserName("ret");
        entity.setCreateAt(123L);
        entity.setUpdateAt(456L);
        entity.setInstance("inst");
        assertEquals("fn", entity.getFunctionName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("sch", entity.getSchema());
        assertEquals("db", entity.getDatabase());
        assertEquals("def", entity.getExecutedSqlQuery());
        assertEquals("ret", entity.getUserName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCode() {
        FunctionEntity entity1 = FunctionEntity.builder().functionName("fn").database("db").build();
        FunctionEntity entity2 = FunctionEntity.builder().functionName("fn").database("db").build();
        FunctionEntity entity3 = FunctionEntity.builder().functionName("other").database("db").build();

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
        assertNotEquals(entity1, null);
        assertNotEquals(entity1, new Object());
    }

    @Test
    void testToString() {
        FunctionEntity entity = FunctionEntity.builder().functionName("fn").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("fn"));
    }

    @Test
    void testAllArgsConstructor() {
        FunctionEntity entity = new FunctionEntity(
                "fn", "prod", "db", "sch", "def", "ret", 123L, 456L, "inst"
        );
        // FIX: Corrected the order of assertions to match the constructor parameters.
        assertEquals("fn", entity.getFunctionName());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("def", entity.getExecutedSqlQuery());
        assertEquals("ret", entity.getUserName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }
}
