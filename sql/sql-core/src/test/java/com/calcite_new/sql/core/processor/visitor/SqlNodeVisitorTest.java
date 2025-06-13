package com.calcite_new.sql.core.processor.visitor;

import com.calcite_new.sql.model.enums.StatementType;
import com.calcite_new.sql.relationextractor.RelationshipType;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqlNodeVisitorTest {

    private SqlNodeVisitor visitor;
    private static final String USER = "testUser";
    private static final String DATABASE = "testDb";
    private static final String SCHEMA = "testSchema";

    @BeforeEach
    void setUp() {
        visitor = new SqlNodeVisitor(USER, DATABASE, SCHEMA);
    }

    @Test
    void testSelectStatement() throws Exception {
        String sql = "SELECT a.id, b.name FROM table1 a JOIN table2 b ON a.id = b.id WHERE a.id > 10";
        SqlNode sqlNode = parseSql(sql);

        SqlNodeVisitor.Result result = sqlNode.accept(visitor);

        assertNotNull(result);
        assertEquals(StatementType.SELECT, result.getStatementType());
        result.getEntityRelationships().forEach(relationship -> {
            assertEquals(RelationshipType.ACCESSES, relationship.getRelationshipType(),
                    "All relationships in SELECT should be of type ACCESSES");
            assertEquals(USER, relationship.getSourceEntity().getEntityName());
            assertTrue(relationship.getTargetEntity().getEntityName().matches("^(table1|table2)$"),
                    "Target entity should be either table1 or table2");
        });
    }

    @Test
    void testInsertStatement() throws Exception {
        String sql = "INSERT INTO target_table (col1, col2) SELECT col1, col2 FROM source_table";
        SqlNode sqlNode = parseSql(sql);

        SqlNodeVisitor.Result result = sqlNode.accept(visitor);

        assertNotNull(result);
        assertEquals(StatementType.INSERT, result.getStatementType());
    }

    @Test
    void testDeleteStatement() throws Exception {
        String sql = "DELETE FROM table1 WHERE TRUE";
        SqlNode sqlNode = parseSql(sql);

        SqlNodeVisitor.Result result = sqlNode.accept(visitor);

        assertNotNull(result);
        assertEquals(StatementType.DELETE, result.getStatementType());

    }

    @Test
    void testNullCall() {
        SqlNodeVisitor.Result result = visitor.visit((SqlCall) null);

        assertNotNull(result);
        assertTrue(result.getEntityRelationships().isEmpty());
        assertTrue(result.getSourceTables().isEmpty());
    }

    @Test
    void testIdentifierVisit() {
        SqlIdentifier identifier = new SqlIdentifier("columnName", SqlParserPos.ZERO);
        SqlNodeVisitor.Result result = visitor.visit(identifier);

        assertNotNull(result);
        assertTrue(result.getEntityRelationships().isEmpty());
        assertTrue(result.getSourceTables().isEmpty());
    }

    @Test
    void testMergeResults() {
        SqlNodeVisitor.Result main = new SqlNodeVisitor.Result();
        SqlNodeVisitor.Result other = new SqlNodeVisitor.Result();

        other.getSourceTables().add(new SqlIdentifier("table1", SqlParserPos.ZERO));

        SqlNodeVisitor.mergeResults(main, other);

        assertEquals(1, main.getSourceTables().size());
    }

    private SqlNode parseSql(String sql) throws Exception {
        SqlParser parser = SqlParser.create(sql);
        return parser.parseStmt();
    }
}