package com.calcite_new.core.model.dialect.sql;

import com.calcite_new.core.model.dialect.Dialect;
import com.calcite_new.core.model.dialect.Product;

public abstract class SqlDialect extends Dialect {

  protected SqlDialect(Product product) {
    super(product);
  }

  protected abstract String identifierQuote();

}
