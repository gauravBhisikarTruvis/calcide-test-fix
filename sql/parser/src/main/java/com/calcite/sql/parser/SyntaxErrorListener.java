package com.calcite.sql.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class SyntaxErrorListener extends BaseErrorListener {
  private boolean hasError = false;
  private final List<RuntimeException> exceptions = new ArrayList<>();

  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                          int line, int charPositionInLine, String msg, RecognitionException e) {
    hasError = true;
    String message = "Syntax error at line " + line + ":" + charPositionInLine + " - " + msg;
    exceptions.add(new RuntimeException(message, e));
  }

  public boolean hasErrors() {
    return hasError;
  }

  public List<RuntimeException> getExceptions() {
    return exceptions;
  }
}
