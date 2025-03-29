package com.calcite.sql.parser;

import com.calcite.sql.parser.antlr.AnsiSqlLexer;
import org.antlr.v4.runtime.*;
import org.apache.calcite.sql.SqlNode;

public class AnsiSqlParser implements SqlParser {

  @Override
  public SqlNode parse(String sql) {
    CharStream input = CharStreams.fromString(sql);
    AnsiSqlLexer lexer = new AnsiSqlLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    com.calcite.sql.parser.antlr.AnsiSqlParser parser = new com.calcite.sql.parser.antlr.AnsiSqlParser(tokens);

    // Create visitor
    AnsiSqlVisitor visitor = new AnsiSqlVisitor();
    return visitor.visit(parser.statement());
  }

}


