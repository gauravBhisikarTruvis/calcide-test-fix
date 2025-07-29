package com.calcite_new.core.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryLogTest {
    @Test
    void testBuilderAndFields() {
        QueryLog entity = QueryLog.builder()
                .logId("id")
                .sourceProduct("prod")
                .database("db")
                .schema("sch")
                .sqlQuery("sql")
                .sessionId("sess")
                .userName("user")
                .startTime(1L)
                .totalExecutionTimeMs(2L)
                .cpuTimeMs(3L)
                .applicationId("app")
                .ioCount(4L)
                .isStoredProcedureCall(true)
                .procedureId(5L)
                .instance("inst")
                .isCommand(true)
                .commandEntityType("etype")
                .commandCmdKind("cmdkind")
                .commandSource("src")
                .commandDestination("dest")
                .commandSchemaJson("json")
                .commandCreateTime(6L)
                .commandUpdateTime(7L)
                .commandEntityName("ename")
                .commandViewSql("vsql")
                .workloadReservationId("wid")
                .hardwareUtilTimeMs(8L)
                .build();
        assertEquals("id", entity.getLogId());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("sql", entity.getSqlQuery());
        assertEquals("sess", entity.getSessionId());
        assertEquals("user", entity.getUserName());
        assertEquals(1L, entity.getStartTime());
        assertEquals(2L, entity.getTotalExecutionTimeMs());
        assertEquals(3L, entity.getCpuTimeMs());
        assertEquals("app", entity.getApplicationId());
        assertEquals(4L, entity.getIoCount());
        assertTrue(entity.getIsStoredProcedureCall());
        assertEquals(5L, entity.getProcedureId());
        assertEquals("inst", entity.getInstance());
        assertTrue(entity.getIsCommand());
        assertEquals("etype", entity.getCommandEntityType());
        assertEquals("cmdkind", entity.getCommandCmdKind());
        assertEquals("src", entity.getCommandSource());
        assertEquals("dest", entity.getCommandDestination());
        assertEquals("json", entity.getCommandSchemaJson());
        assertEquals(6L, entity.getCommandCreateTime());
        assertEquals(7L, entity.getCommandUpdateTime());
        assertEquals("ename", entity.getCommandEntityName());
        assertEquals("vsql", entity.getCommandViewSql());
        assertEquals("wid", entity.getWorkloadReservationId());
        assertEquals(8L, entity.getHardwareUtilTimeMs());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        QueryLog entity = new QueryLog();
        entity.setLogId("id");
        entity.setSourceProduct("prod");
        entity.setDatabase("db");
        entity.setSchema("sch");
        entity.setSqlQuery("sql");
        entity.setSessionId("sess");
        entity.setUserName("user");
        entity.setStartTime(11L);
        entity.setTotalExecutionTimeMs(12L);
        entity.setCpuTimeMs(13L);
        entity.setApplicationId("app");
        entity.setIoCount(14L);
        entity.setIsStoredProcedureCall(false);
        entity.setProcedureId(15L);
        entity.setInstance("inst");
        entity.setIsCommand(false);
        entity.setCommandEntityType("etype");
        entity.setCommandCmdKind("cmdkind");
        entity.setCommandSource("src");
        entity.setCommandDestination("dest");
        entity.setCommandSchemaJson("json");
        entity.setCommandCreateTime(16L);
        entity.setCommandUpdateTime(17L);
        entity.setCommandEntityName("ename");
        entity.setCommandViewSql("vsql");
        entity.setWorkloadReservationId("wid");
        entity.setHardwareUtilTimeMs(18L);
        assertEquals("id", entity.getLogId());
        assertEquals("prod", entity.getSourceProduct());
        assertEquals("db", entity.getDatabase());
        assertEquals("sch", entity.getSchema());
        assertEquals("sql", entity.getSqlQuery());
        assertEquals("sess", entity.getSessionId());
        assertEquals("user", entity.getUserName());
        assertEquals(11L, entity.getStartTime());
        assertEquals(12L, entity.getTotalExecutionTimeMs());
        assertEquals(13L, entity.getCpuTimeMs());
        assertEquals("app", entity.getApplicationId());
        assertEquals(14L, entity.getIoCount());
        assertFalse(entity.getIsStoredProcedureCall());
        assertEquals(15L, entity.getProcedureId());
        assertEquals("inst", entity.getInstance());
        assertFalse(entity.getIsCommand());
        assertEquals("etype", entity.getCommandEntityType());
        assertEquals("cmdkind", entity.getCommandCmdKind());
        assertEquals("src", entity.getCommandSource());
        assertEquals("dest", entity.getCommandDestination());
        assertEquals("json", entity.getCommandSchemaJson());
        assertEquals(16L, entity.getCommandCreateTime());
        assertEquals(17L, entity.getCommandUpdateTime());
        assertEquals("ename", entity.getCommandEntityName());
        assertEquals("vsql", entity.getCommandViewSql());
        assertEquals("wid", entity.getWorkloadReservationId());
        assertEquals(18L, entity.getHardwareUtilTimeMs());
    }

    @Test
    void testOnCreate() {
        QueryLog entity = new QueryLog();
        entity.setStartTime(null);
        entity.onCreate();
        assertNotNull(entity.getStartTime());
    }

    @Test
    void testEqualsAndHashCode() {
        QueryLog q1 = QueryLog.builder().logId("id1").database("db").build();
        QueryLog q2 = QueryLog.builder().logId("id1").database("db").build();
        QueryLog q3 = QueryLog.builder().logId("id2").database("db").build();
        assertEquals(q1, q2);
        assertEquals(q1.hashCode(), q2.hashCode());
        assertNotEquals(q1, q3);
    }

    @Test
    void testToString() {
        QueryLog entity = QueryLog.builder().logId("id1").database("db").build();
        assertTrue(entity.toString().contains("id1"));
        assertTrue(entity.toString().contains("db"));
    }

    @Test
    void testOnCreateWithNotNullStartTime() {
        QueryLog entity = new QueryLog();
        entity.setStartTime(123L);
        entity.onCreate();
        assertEquals(123L, entity.getStartTime());
    }

    @Test
    void testOnCreateWithNullStartTime() {
        QueryLog entity = new QueryLog();
        entity.setStartTime(null);
        entity.onCreate();
        assertNotNull(entity.getStartTime());
    }
}
