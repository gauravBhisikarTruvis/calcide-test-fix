package com.calcite_new.sql.parser;

import com.calcite_new.sql.parser.antlr.AnsiSqlLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.calcite.sql.SqlNode;

public class AnsiSqlParser extends SqlParser {

  public AnsiSqlParser() {
    super(new SyntaxErrorListener(), Mode.DEBUG);
  }

  @Override
  public SqlNode parse(String sql) {
    CharStream input = CharStreams.fromString(sql);
    AnsiSqlLexer lexer = new AnsiSqlLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    com.calcite_new.sql.parser.antlr.AnsiSqlParser parser = new com.calcite_new.sql.parser.antlr.AnsiSqlParser(tokens);

    // Create visitor
    AnsiSqlVisitor visitor = new AnsiSqlVisitor();
    return visitor.visit(parser.statement());
  }

}


