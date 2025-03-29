package com.calcite.sql.parser;

import com.calcite.sql.parser.antlr.BigQuerySqlLexer;
import com.calcite.sql.parser.bigquery.BigQueryToCalciteVisitor;
import org.antlr.v4.runtime.*;
import org.apache.calcite.sql.SqlNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigQuerySqlParser implements SqlParser {
  private static final Logger logger = LoggerFactory.getLogger(BigQuerySqlParser.class);

  @Override
  public SqlNode parse(String sql) {
    boolean debugMode = true;
    boolean devMode = false;
    CharStream input = CharStreams.fromString(sql);
    BigQuerySqlLexer lexer = new BigQuerySqlLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    com.calcite.sql.parser.antlr.BigQuerySqlParser parser =
        new com.calcite.sql.parser.antlr.BigQuerySqlParser(tokens);
    parser.removeErrorListeners();
    SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
//    parser.setTrace(true);
    if (devMode) {
      parser.addErrorListener(new DiagnosticErrorListener());
    }
    parser.addErrorListener(syntaxErrorListener);
    // Create visitor
    BigQueryToCalciteVisitor visitor = new BigQueryToCalciteVisitor();
    ParserRuleContext selectStatement = parser.selectStatement();
    if (syntaxErrorListener.hasErrors()) {
      logger.error("Parsing failed.");
      if (debugMode) syntaxErrorListener.getExceptions().forEach(e -> logger.error(e.getMessage()));
    }
    return visitor.visit(selectStatement);
  }
}
