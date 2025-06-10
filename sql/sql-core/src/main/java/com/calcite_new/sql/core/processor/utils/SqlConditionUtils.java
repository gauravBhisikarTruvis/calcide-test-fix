package com.calcite_new.sql.core.processor.utils;

import org.apache.calcite.sql.*;

import java.util.List;

public class SqlConditionUtils {

    @SuppressWarnings("unchecked")
    public static boolean isConditionAlwaysTrue(SqlNode condition) {
        if (condition == null) return false;

        if (condition instanceof SqlIdentifier id) {
            return "TRUE".equalsIgnoreCase(id.toString());
        }

        if (condition instanceof SqlBasicCall call) {
            SqlOperator op = call.getOperator();
            List<SqlNode> operands = call.getOperandList();

            if (operands.size() == 2 && operands.get(0) instanceof SqlLiteral leftLit && operands.get(1) instanceof SqlLiteral rightLit) {
                Object leftVal = leftLit.getValue();
                Object rightVal = rightLit.getValue();

                if (leftVal instanceof Comparable && rightVal instanceof Comparable) {
                    Comparable<Object> left = (Comparable<Object>) leftVal;
                    Comparable<Object> right = (Comparable<Object>) rightVal;

                    return switch (op.getName()) {
                        case "=" -> left.compareTo(right) == 0;
                        case ">" -> left.compareTo(right) > 0;
                        case "<" -> left.compareTo(right) < 0;
                        case ">=" -> left.compareTo(right) >= 0;
                        case "<=" -> left.compareTo(right) <= 0;
                        default -> false;
                    };
                }
            }
        }

        return false;
    }
}
