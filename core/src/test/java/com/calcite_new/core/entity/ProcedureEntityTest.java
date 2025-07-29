package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProcedureEntityTest {
    @Test
    void testBuilderAndFields() {
        ProcedureEntity entity = ProcedureEntity.builder()
                .procedureName("proc")
                .schema("sch")
                .database("db")
                .executedSqlQuery("def")
                .userName("ret")
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("proc", entity.getProcedureName());
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
        ProcedureEntity entity = new ProcedureEntity();
        entity.setProcedureName("proc");
        entity.setSchema("sch");
        entity.setDatabase("db");
        entity.setExecutedSqlQuery("def");
        entity.setUserName("ret");
        entity.setCreateAt(123L);
        entity.setUpdateAt(456L);
        entity.setInstance("inst");
        assertEquals("proc", entity.getProcedureName());
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
        ProcedureEntity entity1 = ProcedureEntity.builder().procedureName("proc").build();
        ProcedureEntity entity2 = ProcedureEntity.builder().procedureName("proc").build();
        ProcedureEntity entity3 = ProcedureEntity.builder().procedureName("other").build();
        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
    }

    @Test
    void testToString() {
        ProcedureEntity entity = ProcedureEntity.builder().procedureName("proc").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("proc"));
    }

    @Test
    void testAllArgsConstructor() {
        ProcedureEntity entity = new ProcedureEntity(
            "prod", "db", "sch", "proc", "user", "def", 123L, 456L, "inst"
        );
        assertEquals("proc", entity.getProcedureName());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("user", entity.getUserName());
        assertEquals("def", entity.getExecutedSqlQuery());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }
}
