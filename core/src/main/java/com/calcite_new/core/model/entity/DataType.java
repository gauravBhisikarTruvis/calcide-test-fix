package com.calcite_new.core.model.entity;

import org.apache.calcite.sql.type.SqlTypeName;

public record DataType(SqlTypeName name, int precision, int scale) {

  public DataType(SqlTypeName name, int precision, int scale) {
    this.name = name;
    this.precision = name.allowsPrec() ? precision : -1;
    this.scale = name.allowsScale() ? scale : -1;
  }

}
