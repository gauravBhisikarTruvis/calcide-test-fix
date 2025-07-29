package com.calcite_new.core.dialect.sql;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BigQuerySqlDialectTest {
    @Test
    void normalize_unquotedIdentifier_returnsLowercase() {
        BigQuerySqlDialect dialect = new BigQuerySqlDialect();
        assertEquals("abc", dialect.normalize("ABC"));
    }

    @Test
    void normalize_backtickedIdentifier_preservesCase() {
        BigQuerySqlDialect dialect = new BigQuerySqlDialect();
        assertEquals("MiXeD", dialect.normalize("`MiXeD`"));
    }

    @Test
    void normalize_emptyOrNull_returnsEmptyString() {
        BigQuerySqlDialect dialect = new BigQuerySqlDialect();
        assertEquals("", dialect.normalize(""));
        assertEquals("", dialect.normalize(null));
    }

    @Test
    void otherMethods() {
        BigQuerySqlDialect dialect = new BigQuerySqlDialect();
        assertEquals("`", dialect.identifierQuote());
        assertEquals(3, dialect.supportedQualificationLevels());
        // toString from lombok Object ? ensure not null
        assertNotNull(dialect.toString());
    }
}
