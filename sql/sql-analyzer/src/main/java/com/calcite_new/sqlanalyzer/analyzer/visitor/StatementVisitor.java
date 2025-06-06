package com.calcite_new.sqlanalyzer.analyzer.visitor;

import org.apache.calcite.sql.SqlCall;

public interface StatementVisitor {
    SqlNodeVisitor.Result visit(SqlCall call);
}
