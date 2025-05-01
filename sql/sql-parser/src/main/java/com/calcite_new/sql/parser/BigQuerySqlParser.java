package com.calcite_new.sql.parser;

import com.calcite_new.sql.parser.antlr.BigQuerySqlLexer;
import com.calcite_new.sql.parser.bigquery.BigQueryToCalciteVisitor;
import org.antlr.v4.runtime.*;
import org.apache.calcite.sql.SqlNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser for BigQuery SQL dialect.
 */
public class BigQuerySqlParser extends SqlParser {
  private static final Logger logger = LoggerFactory.getLogger(BigQuerySqlParser.class);

  public BigQuerySqlParser() {
    this(Mode.PROD);
  }

  public BigQuerySqlParser(Mode mode) {
    super(new SyntaxErrorListener(), mode);
  }

  @Override
  public SqlNode parse(String sql) {
    boolean devMode = false;
    CharStream input = CharStreams.fromString(sql);
    BigQuerySqlLexer lexer = new BigQuerySqlLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    com.calcite_new.sql.parser.antlr.BigQuerySqlParser parser =
        new com.calcite_new.sql.parser.antlr.BigQuerySqlParser(tokens);
    parser.removeErrorListeners();
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
      if (mode == Mode.DEBUG) {
        syntaxErrorListener.getExceptions()
            .forEach(e -> logger.error(e.getMessage()));
      }
    }
    return visitor.visit(selectStatement);
  }
}
