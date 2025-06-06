package com.calcite_new.sqlanalyzer.utils;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.util.SqlBasicVisitor;

public class SqlSubqueryUtils {

    private SqlSubqueryUtils() {
    }

    public static boolean hasInOrNotInClauseWithSubquery(SqlNode where) {
        if (where == null) return false;

        return Boolean.TRUE.equals(where.accept(new InClauseSubqueryDetector()));
    }

    private static class InClauseSubqueryDetector extends SqlBasicVisitor<Boolean> {
        @Override
        public Boolean visit(SqlCall call) {
            SqlKind kind = call.getKind();
            if ((kind == SqlKind.IN || kind == SqlKind.NOT_IN)
                    && call.getOperandList().size() == 2
                    && call.getOperandList().get(1) instanceof SqlSelect) {
                return true;
            }

            for (SqlNode operand : call.getOperandList()) {
                if (operand != null && Boolean.TRUE.equals(operand.accept(this))) {
                    return true;
                }
            }

            return false;
        }
    }
}
