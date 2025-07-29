package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the MacroEntity class.
 */
public class MacroEntityTest {
    @Test
    void testBuilderAndFields() {
        MacroEntity entity = MacroEntity.builder()
                .macroName("macro")
                .schema("sch")
                .database("db")
                .executedSqlQuery("def")
                .userName("ret")
                .createAt(123L)
                .updateAt(456L)
                .instance("inst")
                .build();
        assertEquals("macro", entity.getMacroName());
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
        MacroEntity entity = new MacroEntity();
        entity.setMacroName("macro");
        entity.setSchema("sch");
        entity.setDatabase("db");
        entity.setExecutedSqlQuery("def");
        entity.setUserName("ret");
        entity.setCreateAt(123L);
        entity.setUpdateAt(456L);
        entity.setInstance("inst");
        assertEquals("macro", entity.getMacroName());
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
        MacroEntity entity1 = MacroEntity.builder().macroName("macro").database("db").build();
        MacroEntity entity2 = MacroEntity.builder().macroName("macro").database("db").build();
        MacroEntity entity3 = MacroEntity.builder().macroName("other").database("db").build();

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
        assertNotEquals(entity1, entity3);
        assertNotEquals(entity1, null);
        assertNotEquals(entity1, new Object());
    }

    @Test
    void testToString() {
        MacroEntity entity = MacroEntity.builder().macroName("macro").build();
        String str = entity.toString();
        assertNotNull(str);
        assertTrue(str.contains("macro"));
    }

    @Test
    void testAllArgsConstructor() {
        // FIX: The order of arguments was incorrect and has been corrected.
        // The correct constructor order is: database, schema, macroName, userName, executedSqlQuery, ...
        MacroEntity entity = new MacroEntity(
                "db", "sch", "macro", "ret", "def", 123L, 456L, "inst"
        );
        assertEquals("macro", entity.getMacroName());
        assertEquals("sch", entity.getSchema());
        assertEquals("db", entity.getDatabase());
        assertEquals("def", entity.getExecutedSqlQuery());
        assertEquals("ret", entity.getUserName());
        assertEquals(123L, entity.getCreateAt());
        assertEquals(456L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }
}