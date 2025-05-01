package com.calcite_new.sql.parser;

import org.apache.calcite.sql.SqlNode;

/**
 * Abstract class for SQL parsers.
 *
 * <p>Subclasses should provide specific implementations for parsing SQL strings.
 */
public abstract class SqlParser {
  protected final SyntaxErrorListener syntaxErrorListener;
  protected final Mode mode;

  public SqlParser(SyntaxErrorListener errorListener, Mode mode) {
    this.syntaxErrorListener = errorListener;
    this.mode = mode;
  }

  abstract SqlNode parse(String sql);

  public boolean success() {
    return !syntaxErrorListener.hasErrors();
  }

  public enum Mode {
    PROD,
    DEBUG
  }
}
