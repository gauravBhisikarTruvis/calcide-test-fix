package com.calcite_new.sql.recommender.analyzer.utils;

import java.util.Set;

public class SqlStatementUtils {

    public static final Set<String> UNSUPPORTED_STATEMENTS = Set.of(
            "ANALYZE", "EXPLAIN", "SHOW", "DESCRIBE"
    );

    private SqlStatementUtils() {
    }

    public static boolean isUnsupported(String statementKind) {
        return UNSUPPORTED_STATEMENTS.contains(statementKind);
    }
}

