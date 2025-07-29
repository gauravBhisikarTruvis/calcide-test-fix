package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ViewEntityTest {
    @Test
    void testBuilderAndFields() {
        ViewEntity entity = ViewEntity.builder()
                .sourceProduct("prod")
                .database("db")
                .schema("sch")
                .viewName("view")
                .executedSqlQuery("sql")
                .viewType("type")
                .userName("user")
                .createAt(1L)
                .updateAt(2L)
                .instance("inst")
                .build();
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("view", entity.getViewName());
        assertEquals("sql", entity.getExecutedSqlQuery());
        assertEquals("type", entity.getViewType());
        assertEquals("user", entity.getUserName());
        assertEquals(1L, entity.getCreateAt());
        assertEquals(2L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        ViewEntity entity = new ViewEntity();
        entity.setSourceProduct("prod");
        entity.setDatabase("db");
        entity.setSchema("sch");
        entity.setViewName("view");
        entity.setExecutedSqlQuery("sql");
        entity.setViewType("type");
        entity.setUserName("user");
        entity.setCreateAt(10L);
        entity.setUpdateAt(20L);
        entity.setInstance("inst");
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("view", entity.getViewName());
        assertEquals("sql", entity.getExecutedSqlQuery());
        assertEquals("type", entity.getViewType());
        assertEquals("user", entity.getUserName());
        assertEquals(10L, entity.getCreateAt());
        assertEquals(20L, entity.getUpdateAt());
        assertEquals("inst", entity.getInstance());
    }

    @Test
    void testEqualsAndHashCode() {
        ViewEntity v1 = ViewEntity.builder().viewName("v1").database("db").build();
        ViewEntity v2 = ViewEntity.builder().viewName("v1").database("db").build();
        ViewEntity v3 = ViewEntity.builder().viewName("v2").database("db").build();
        assertEquals(v1, v2);
        assertEquals(v1.hashCode(), v2.hashCode());
        assertNotEquals(v1, v3);
    }

    @Test
    void testToString() {
        ViewEntity entity = ViewEntity.builder().viewName("v1").database("db").build();
        assertTrue(entity.toString().contains("v1"));
        assertTrue(entity.toString().contains("db"));
    }
}
