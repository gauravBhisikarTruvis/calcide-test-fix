package com.calcite_new.core.model.dialect.sql;

import com.calcite_new.core.model.dialect.Product;

public class BigQuerySqlDialect extends SqlDialect {

  protected BigQuerySqlDialect() {
    super(Product.BIG_QUERY);
  }

  @Override
  public String normalize(String name) {
    if (name == null || name.isEmpty()) {
      return "";
    }

    // Check if the identifier is backticked
    String quote = identifierQuote();
    if (name.startsWith(quote) && name.endsWith(quote) && name.length() >= 2) {
      // Remove the backticks but preserve the case for backticked identifiers
      return name.substring(1, name.length() - 1);
    }

    // For non-backticked identifiers, convert to lowercase (BigQuery treats them as case-insensitive)
    return name.toLowerCase();
  }

  @Override
  protected String identifierQuote() {
    return "`";
  }
}
