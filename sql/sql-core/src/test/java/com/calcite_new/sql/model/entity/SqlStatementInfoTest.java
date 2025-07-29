package com.calcite_new.sql.model.entity;

import com.calcite_new.sql.model.entity.context.clause.SelectClause;
import com.calcite_new.sql.model.enums.StatementStatus;
import com.calcite_new.sql.model.enums.StatementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides 100% test coverage for the SqlStatementInfo class.
 * This test suite validates the builder, constructors, and all getter/setter methods.
 */
class SqlStatementInfoTest {

    private SqlStatementInfo info1;
    private SqlStatementInfo info2;
    private String logId;
    private Long queryExecutionTime;
    private StatementContext context;
    private List<EntityRelationship> relationships;

    @BeforeEach
    void setUp() {
        logId = "log-123";
        queryExecutionTime = 150L;
        context = new StatementContext();
        context.setSelectClause(new SelectClause());
        relationships = new ArrayList<>();

        // Use the builder to create a fully populated instance
        info1 = SqlStatementInfo.builder()
                .logId(logId)
                .statementId("stmt-abc")
                .queryExecutionTime(queryExecutionTime)
                .database("test_db")
                .schema("test_schema")
                .sessionId("session_abc")
                .userName("test_user")
                .statementType(StatementType.SELECT)
                .statementStatus(StatementStatus.SUCCESS)
                .statementContext(context)
                .entityRelationships(relationships)
                .errorDescription(null)
                .build();

        // Create a second identical instance for equality tests
        info2 = SqlStatementInfo.builder()
                .logId(logId)
                .statementId("stmt-abc")
                .queryExecutionTime(queryExecutionTime)
                .database("test_db")
                .schema("test_schema")
                .sessionId("session_abc")
                .userName("test_user")
                .statementType(StatementType.SELECT)
                .statementStatus(StatementStatus.SUCCESS)
                .statementContext(context)
                .entityRelationships(relationships)
                .errorDescription(null)
                .build();
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        // Test the no-arg constructor
        SqlStatementInfo info = new SqlStatementInfo();
        assertNull(info.getLogId());

        // Test all setters
        info.setId(1L);
        assertEquals(1L, info.getId());

        info.setLogId("new-log-id");
        assertEquals("new-log-id", info.getLogId());

        info.setStatementId("new-stmt-id");
        assertEquals("new-stmt-id", info.getStatementId());

        info.setQueryExecutionTime(200L);
        assertEquals(200L, info.getQueryExecutionTime());

        info.setDatabase("new_db");
        assertEquals("new_db", info.getDatabase());

        info.setSchema("new_schema");
        assertEquals("new_schema", info.getSchema());

        info.setSessionId("new_session");
        assertEquals("new_session", info.getSessionId());

        info.setUserName("new_user");
        assertEquals("new_user", info.getUserName());

        info.setStatementType(StatementType.INSERT);
        assertEquals(StatementType.INSERT, info.getStatementType());

        info.setStatementStatus(StatementStatus.ERROR);
        assertEquals(StatementStatus.ERROR, info.getStatementStatus());

        StatementContext newContext = new StatementContext();
        info.setStatementContext(newContext);
        assertEquals(newContext, info.getStatementContext());
    }

    @Test
    void testBuilderAndAllArgsConstructor() {
        // The setUp method already uses the builder. Here we just verify the created object.
        assertEquals(logId, info1.getLogId());
        assertEquals("stmt-abc", info1.getStatementId());
        assertEquals(queryExecutionTime, info1.getQueryExecutionTime());
        assertEquals("test_db", info1.getDatabase());
        assertEquals("test_schema", info1.getSchema());
        assertEquals("session_abc", info1.getSessionId());
        assertEquals("test_user", info1.getUserName());
        assertEquals(StatementType.SELECT, info1.getStatementType());
        assertEquals(StatementStatus.SUCCESS, info1.getStatementStatus());
        assertEquals(context, info1.getStatementContext());
        assertEquals(relationships, info1.getEntityRelationships());
        assertNull(info1.getErrorDescription());
    }

    @Test
    void testSetErrorDescriptionFromException() {
        SqlStatementInfo info = new SqlStatementInfo();
        // FIX: Set the status to an error state before setting the description.
        info.setStatementStatus(StatementStatus.ERROR);
        Exception error = new RuntimeException("Test Error");
        info.setErrorDescription(error);
        assertNotNull(info.getErrorDescription());
        assertTrue(info.getErrorDescription().getErrorMessage().contains("Test Error"));
    }

    @Test
    void testSetErrorDescriptionFromString() {
        SqlStatementInfo info = new SqlStatementInfo();
        // FIX: Set the status to an error state before setting the description.
        info.setStatementStatus(StatementStatus.PARSE_ERROR);
        String errorMsg = "A simple error message";
        info.setErrorDescription(errorMsg);
        assertNotNull(info.getErrorDescription());
        assertTrue(info.getErrorDescription().getErrorMessage().contains(errorMsg));
    }

    @Test
    void testSetEntityRelationships() {
        SqlStatementInfo info = new SqlStatementInfo();
        EntityRelationship relationship = new EntityRelationship();
        List<EntityRelationship> newRelationships = List.of(relationship);

        info.setEntityRelationships(newRelationships);

        assertEquals(newRelationships, info.getEntityRelationships());
        // Verify that the back-reference is set on each relationship
        assertEquals(info, relationship.getSqlStatementInfo());
    }

    @Test
    void testEqualsAndHashCode() {
        // Test for equality
        assertEquals(info1, info2, "Two identical SqlStatementInfo objects should be equal.");
        assertEquals(info1.hashCode(), info2.hashCode(), "Hash codes should be equal for equal objects.");

        // Test for inequality based on a different field
        info2.setLogId("different-id");
        assertNotEquals(info1, info2, "Objects should not be equal if a property is different.");
        assertNotEquals(info1.hashCode(), info2.hashCode(), "Hash codes should be different for unequal objects.");

        // Test for inequality with null
        assertNotEquals(null, info1);
    }

    @Test
    void testToString() {
        // Test that toString() does not return null or an empty string
        String toStringResult = info1.toString();
        assertNotNull(toStringResult);
        assertFalse(toStringResult.isEmpty());
        assertTrue(toStringResult.contains(logId), "toString() should contain the logId.");
    }
}