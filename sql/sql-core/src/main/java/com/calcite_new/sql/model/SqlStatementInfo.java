package com.calcite_new.sql.model;

import com.calcite_new.core.dialect.sql.SqlDialect;

public class SqlStatementInfo {
  private final String id;
  private final String sql;
  private final SqlDialect dialect;
  private final StatementType sqlType;
  private final long startTime;
  private final long endTime;
  private final double io;
  private final double cpu;

  public SqlStatementInfo(
      String id,
      String sql,
      SqlDialect dialect,
      StatementType sqlType,
      long startTime,
      long endTime,
      double io,
      double cpu) {
    this.id = id;
    this.sql = sql;
    this.dialect = dialect;
    this.sqlType = sqlType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.io = io;
    this.cpu = cpu;
  }

  public String getId() {
    return id;
  }

  public String getSql() {
    return sql;
  }

  public StatementType getSqlType() {
    return sqlType;
  }

  public SqlDialect getDialect() {
    return dialect;
  }
}
