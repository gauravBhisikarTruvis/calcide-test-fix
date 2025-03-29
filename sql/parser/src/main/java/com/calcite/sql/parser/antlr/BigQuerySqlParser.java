// Generated from BigQuerySql.g4 by ANTLR 4.13.2

package com.calcite.sql.parser.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BigQuerySqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, ARRAY_AGG=20, ALL=21, AND=22, ANY=23, ARRAY=24, AS=25, 
		ASC=26, AVG=27, BETWEEN=28, BY=29, CASE=30, CAST=31, COLLATE=32, COUNT=33, 
		CROSS=34, CUBE=35, CURRENT=36, DATE=37, DATE_ADD=38, DATE_DIFF=39, DATE_SUB=40, 
		DATE_TRUNC=41, DATETIME=42, TIMESTAMP_ADD=43, TIMESTAMP_SUB=44, TIMESTAMP_DIFF=45, 
		TIMESTAMP_TRUNC=46, TO_JSON_STRING=47, TIME=48, TIMESTAMP=49, DESC=50, 
		DISTINCT=51, ELSE=52, END=53, EXCEPT=54, EXISTS=55, EXTRACT=56, FIRST=57, 
		FOLLOWING=58, FROM=59, FULL=60, GENERATE_ARRAY=61, GENERATE_DATE_ARRAY=62, 
		GROUP=63, GROUPING=64, HAVING=65, IN=66, INNER=67, INTERSECT=68, INTERVAL=69, 
		IS=70, JOIN=71, JSON_EXTRACT=72, JSON_EXTRACT_SCALAR=73, JSON_QUERY=74, 
		JSON_VALUE=75, LAST=76, LEFT=77, LIKE=78, LIMIT=79, MAX=80, MIN=81, NOT=82, 
		NULLS=83, OFFSET=84, ON=85, OR=86, ORDER=87, OUTER=88, OVER=89, PARSE_JSON=90, 
		PARTITION=91, PRECEDING=92, QUALIFY=93, RANGE=94, RIGHT=95, ROLLUP=96, 
		ROW=97, ROWS=98, SAFE_CAST=99, SELECT=100, STRING=101, BYTES=102, BOOL=103, 
		BOOLEAN=104, NUMERIC=105, BIGNUMERIC=106, GEOGRAPHY=107, YEAR=108, QUARTER=109, 
		MONTH=110, WEEK=111, DAY=112, HOUR=113, MINUTE=114, SECOND=115, MILLISECOND=116, 
		MICROSECOND=117, NANOSECOND=118, TRUE=119, FALSE=120, NULL=121, WITH=122, 
		UNION=123, UNNEST=124, USING=125, WHERE=126, SETS=127, WINDOW=128, UNBOUNDED=129, 
		WHEN=130, THEN=131, STRUCT=132, SUM=133, SOME=134, INT64=135, FLOAT64=136, 
		JSON=137, LPAREN=138, RPAREN=139, IDENTIFIER=140, BACKTICK_IDENTIFIER=141, 
		QUOTED_IDENTIFIER=142, STRING_LITERAL=143, INTEGER_LITERAL=144, FLOAT_LITERAL=145, 
		WS=146, COMMENT=147, MULTILINE_COMMENT=148;
	public static final int
		RULE_selectStatement = 0, RULE_withClause = 1, RULE_withQueryItem = 2, 
		RULE_queryExpression = 3, RULE_queryTerm = 4, RULE_queryPrimary = 5, RULE_simpleQuery = 6, 
		RULE_selectClause = 7, RULE_selectItem = 8, RULE_tableWildcard = 9, RULE_fromClause = 10, 
		RULE_tableExpression = 11, RULE_tableFactor = 12, RULE_tableAlias = 13, 
		RULE_columnAlias = 14, RULE_joinedTable = 15, RULE_joinType = 16, RULE_joinSpecification = 17, 
		RULE_whereClause = 18, RULE_groupByClause = 19, RULE_groupingElement = 20, 
		RULE_groupingSet = 21, RULE_havingClause = 22, RULE_qualifyClause = 23, 
		RULE_windowClause = 24, RULE_namedWindow = 25, RULE_windowSpecification = 26, 
		RULE_windowName = 27, RULE_partitionClause = 28, RULE_orderByClause = 29, 
		RULE_orderingItem = 30, RULE_frameClause = 31, RULE_frameUnits = 32, RULE_frameExtent = 33, 
		RULE_frameStart = 34, RULE_frameEnd = 35, RULE_limitClause = 36, RULE_setQuantifier = 37, 
		RULE_expression = 38, RULE_inPredicateValue = 39, RULE_caseExpression = 40, 
		RULE_simpleCaseExpression = 41, RULE_searchedCaseExpression = 42, RULE_castExpression = 43, 
		RULE_arrayExpression = 44, RULE_structExpression = 45, RULE_structField = 46, 
		RULE_functionCall = 47, RULE_comparisonOperator = 48, RULE_columnReference = 49, 
		RULE_tableIdentifier = 50, RULE_dataType = 51, RULE_structTypeElement = 52, 
		RULE_dateUnit = 53, RULE_literal = 54, RULE_identifier = 55, RULE_nonReservedKeyword = 56;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "withClause", "withQueryItem", "queryExpression", 
			"queryTerm", "queryPrimary", "simpleQuery", "selectClause", "selectItem", 
			"tableWildcard", "fromClause", "tableExpression", "tableFactor", "tableAlias", 
			"columnAlias", "joinedTable", "joinType", "joinSpecification", "whereClause", 
			"groupByClause", "groupingElement", "groupingSet", "havingClause", "qualifyClause", 
			"windowClause", "namedWindow", "windowSpecification", "windowName", "partitionClause", 
			"orderByClause", "orderingItem", "frameClause", "frameUnits", "frameExtent", 
			"frameStart", "frameEnd", "limitClause", "setQuantifier", "expression", 
			"inPredicateValue", "caseExpression", "simpleCaseExpression", "searchedCaseExpression", 
			"castExpression", "arrayExpression", "structExpression", "structField", 
			"functionCall", "comparisonOperator", "columnReference", "tableIdentifier", 
			"dataType", "structTypeElement", "dateUnit", "literal", "identifier", 
			"nonReservedKeyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'*'", "'.'", "'||'", "'+'", "'-'", "'/'", "'%'", "'?'", 
			"':'", "'['", "']'", "'<'", "'>'", "'='", "'<='", "'>='", "'<>'", "'!='", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "ARRAY_AGG", "ALL", "AND", 
			"ANY", "ARRAY", "AS", "ASC", "AVG", "BETWEEN", "BY", "CASE", "CAST", 
			"COLLATE", "COUNT", "CROSS", "CUBE", "CURRENT", "DATE", "DATE_ADD", "DATE_DIFF", 
			"DATE_SUB", "DATE_TRUNC", "DATETIME", "TIMESTAMP_ADD", "TIMESTAMP_SUB", 
			"TIMESTAMP_DIFF", "TIMESTAMP_TRUNC", "TO_JSON_STRING", "TIME", "TIMESTAMP", 
			"DESC", "DISTINCT", "ELSE", "END", "EXCEPT", "EXISTS", "EXTRACT", "FIRST", 
			"FOLLOWING", "FROM", "FULL", "GENERATE_ARRAY", "GENERATE_DATE_ARRAY", 
			"GROUP", "GROUPING", "HAVING", "IN", "INNER", "INTERSECT", "INTERVAL", 
			"IS", "JOIN", "JSON_EXTRACT", "JSON_EXTRACT_SCALAR", "JSON_QUERY", "JSON_VALUE", 
			"LAST", "LEFT", "LIKE", "LIMIT", "MAX", "MIN", "NOT", "NULLS", "OFFSET", 
			"ON", "OR", "ORDER", "OUTER", "OVER", "PARSE_JSON", "PARTITION", "PRECEDING", 
			"QUALIFY", "RANGE", "RIGHT", "ROLLUP", "ROW", "ROWS", "SAFE_CAST", "SELECT", 
			"STRING", "BYTES", "BOOL", "BOOLEAN", "NUMERIC", "BIGNUMERIC", "GEOGRAPHY", 
			"YEAR", "QUARTER", "MONTH", "WEEK", "DAY", "HOUR", "MINUTE", "SECOND", 
			"MILLISECOND", "MICROSECOND", "NANOSECOND", "TRUE", "FALSE", "NULL", 
			"WITH", "UNION", "UNNEST", "USING", "WHERE", "SETS", "WINDOW", "UNBOUNDED", 
			"WHEN", "THEN", "STRUCT", "SUM", "SOME", "INT64", "FLOAT64", "JSON", 
			"LPAREN", "RPAREN", "IDENTIFIER", "BACKTICK_IDENTIFIER", "QUOTED_IDENTIFIER", 
			"STRING_LITERAL", "INTEGER_LITERAL", "FLOAT_LITERAL", "WS", "COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BigQuerySql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BigQuerySqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public WithClauseContext withClause() {
			return getRuleContext(WithClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSelectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSelectStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(114);
				withClause();
				}
			}

			setState(117);
			queryExpression(0);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(118);
				orderByClause();
				}
			}

			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(121);
				limitClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WithClauseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(BigQuerySqlParser.WITH, 0); }
		public List<WithQueryItemContext> withQueryItem() {
			return getRuleContexts(WithQueryItemContext.class);
		}
		public WithQueryItemContext withQueryItem(int i) {
			return getRuleContext(WithQueryItemContext.class,i);
		}
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWithClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWithClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWithClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithClauseContext withClause() throws RecognitionException {
		WithClauseContext _localctx = new WithClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_withClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(WITH);
			setState(125);
			withQueryItem();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(126);
				match(T__0);
				setState(127);
				withQueryItem();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WithQueryItemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public WithQueryItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withQueryItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWithQueryItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWithQueryItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWithQueryItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithQueryItemContext withQueryItem() throws RecognitionException {
		WithQueryItemContext _localctx = new WithQueryItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_withQueryItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			identifier();
			setState(134);
			match(AS);
			setState(135);
			match(LPAREN);
			setState(136);
			queryExpression(0);
			setState(137);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryExpressionContext extends ParserRuleContext {
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode UNION() { return getToken(BigQuerySqlParser.UNION, 0); }
		public TerminalNode ALL() { return getToken(BigQuerySqlParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(BigQuerySqlParser.DISTINCT, 0); }
		public TerminalNode EXCEPT() { return getToken(BigQuerySqlParser.EXCEPT, 0); }
		public TerminalNode INTERSECT() { return getToken(BigQuerySqlParser.INTERSECT, 0); }
		public QueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitQueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		return queryExpression(0);
	}

	private QueryExpressionContext queryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, _parentState);
		QueryExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_queryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(140);
			queryTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new QueryExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_queryExpression);
						setState(142);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(143);
						match(UNION);
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(144);
							_la = _input.LA(1);
							if ( !(_la==ALL || _la==DISTINCT) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(147);
						queryTerm();
						}
						break;
					case 2:
						{
						_localctx = new QueryExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_queryExpression);
						setState(148);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(149);
						match(EXCEPT);
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(150);
							_la = _input.LA(1);
							if ( !(_la==ALL || _la==DISTINCT) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(153);
						queryTerm();
						}
						break;
					case 3:
						{
						_localctx = new QueryExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_queryExpression);
						setState(154);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(155);
						match(INTERSECT);
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(156);
							_la = _input.LA(1);
							if ( !(_la==ALL || _la==DISTINCT) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(159);
						queryTerm();
						}
						break;
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryTermContext extends ParserRuleContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterQueryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitQueryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitQueryTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		QueryTermContext _localctx = new QueryTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_queryTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			queryPrimary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryPrimaryContext extends ParserRuleContext {
		public SimpleQueryContext simpleQuery() {
			return getRuleContext(SimpleQueryContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterQueryPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitQueryPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitQueryPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_queryPrimary);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				simpleQuery();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(LPAREN);
				setState(169);
				queryExpression(0);
				setState(170);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleQueryContext extends ParserRuleContext {
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public QualifyClauseContext qualifyClause() {
			return getRuleContext(QualifyClauseContext.class,0);
		}
		public WindowClauseContext windowClause() {
			return getRuleContext(WindowClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public SimpleQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSimpleQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSimpleQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSimpleQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleQueryContext simpleQuery() throws RecognitionException {
		SimpleQueryContext _localctx = new SimpleQueryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simpleQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			selectClause();
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(175);
				fromClause();
				}
				break;
			}
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(178);
				whereClause();
				}
				break;
			}
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(181);
				groupByClause();
				}
				break;
			}
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(184);
				havingClause();
				}
				break;
			}
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(187);
				qualifyClause();
				}
				break;
			}
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(190);
				windowClause();
				}
				break;
			}
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(193);
				orderByClause();
				}
				break;
			}
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(196);
				limitClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectClauseContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(BigQuerySqlParser.SELECT, 0); }
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSelectClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSelectClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(SELECT);
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(200);
				setQuantifier();
				}
				break;
			}
			setState(203);
			selectItem();
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					match(T__0);
					setState(205);
					selectItem();
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectItemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public TableWildcardContext tableWildcard() {
			return getRuleContext(TableWildcardContext.class,0);
		}
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSelectItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSelectItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_selectItem);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				expression(0);
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(213);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(212);
						match(AS);
						}
						break;
					}
					setState(215);
					identifier();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				tableWildcard();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableWildcardContext extends ParserRuleContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterTableWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitTableWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitTableWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableWildcardContext tableWildcard() throws RecognitionException {
		TableWildcardContext _localctx = new TableWildcardContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tableWildcard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			tableIdentifier();
			setState(223);
			match(T__2);
			setState(224);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(BigQuerySqlParser.FROM, 0); }
		public List<TableExpressionContext> tableExpression() {
			return getRuleContexts(TableExpressionContext.class);
		}
		public TableExpressionContext tableExpression(int i) {
			return getRuleContext(TableExpressionContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(FROM);
			setState(227);
			tableExpression();
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(228);
					match(T__0);
					setState(229);
					tableExpression();
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableExpressionContext extends ParserRuleContext {
		public JoinedTableContext joinedTable() {
			return getRuleContext(JoinedTableContext.class,0);
		}
		public TableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitTableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitTableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableExpressionContext tableExpression() throws RecognitionException {
		TableExpressionContext _localctx = new TableExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			joinedTable(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableFactorContext extends ParserRuleContext {
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public TerminalNode UNNEST() { return getToken(BigQuerySqlParser.UNNEST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode WITH() { return getToken(BigQuerySqlParser.WITH, 0); }
		public TerminalNode OFFSET() { return getToken(BigQuerySqlParser.OFFSET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TableFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterTableFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitTableFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitTableFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableFactorContext tableFactor() throws RecognitionException {
		TableFactorContext _localctx = new TableFactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tableFactor);
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				tableIdentifier();
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(238);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				tableIdentifier();
				setState(242);
				match(T__2);
				setState(243);
				tableIdentifier();
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(244);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(LPAREN);
				setState(248);
				queryExpression(0);
				setState(249);
				match(RPAREN);
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(250);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				match(LPAREN);
				setState(254);
				tableExpression();
				setState(255);
				match(RPAREN);
				setState(257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(256);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				match(UNNEST);
				setState(260);
				match(LPAREN);
				setState(261);
				expression(0);
				setState(262);
				match(RPAREN);
				setState(264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(263);
					tableAlias();
					}
					break;
				}
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(266);
					match(WITH);
					setState(267);
					match(OFFSET);
					setState(272);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(269);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
						case 1:
							{
							setState(268);
							match(AS);
							}
							break;
						}
						setState(271);
						identifier();
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(276);
				functionCall();
				setState(278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(277);
					tableAlias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableAliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public ColumnAliasContext columnAlias() {
			return getRuleContext(ColumnAliasContext.class,0);
		}
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitTableAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitTableAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tableAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(282);
				match(AS);
				}
				break;
			}
			setState(285);
			identifier();
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(286);
				columnAlias();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnAliasContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public ColumnAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterColumnAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitColumnAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitColumnAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAliasContext columnAlias() throws RecognitionException {
		ColumnAliasContext _localctx = new ColumnAliasContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_columnAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LPAREN);
			setState(290);
			identifier();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(291);
				match(T__0);
				setState(292);
				identifier();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinedTableContext extends ParserRuleContext {
		public TableFactorContext tableFactor() {
			return getRuleContext(TableFactorContext.class,0);
		}
		public JoinedTableContext joinedTable() {
			return getRuleContext(JoinedTableContext.class,0);
		}
		public TerminalNode JOIN() { return getToken(BigQuerySqlParser.JOIN, 0); }
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinSpecificationContext joinSpecification() {
			return getRuleContext(JoinSpecificationContext.class,0);
		}
		public JoinedTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinedTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterJoinedTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitJoinedTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitJoinedTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinedTableContext joinedTable() throws RecognitionException {
		return joinedTable(0);
	}

	private JoinedTableContext joinedTable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		JoinedTableContext _localctx = new JoinedTableContext(_ctx, _parentState);
		JoinedTableContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_joinedTable, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(301);
			tableFactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JoinedTableContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_joinedTable);
					setState(303);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & 2305851813963759617L) != 0)) {
						{
						setState(304);
						joinType();
						}
					}

					setState(307);
					match(JOIN);
					setState(308);
					tableExpression();
					setState(310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(309);
						joinSpecification();
						}
						break;
					}
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(BigQuerySqlParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(BigQuerySqlParser.CROSS, 0); }
		public TerminalNode FULL() { return getToken(BigQuerySqlParser.FULL, 0); }
		public TerminalNode OUTER() { return getToken(BigQuerySqlParser.OUTER, 0); }
		public TerminalNode LEFT() { return getToken(BigQuerySqlParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(BigQuerySqlParser.RIGHT, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_joinType);
		int _la;
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(INNER);
				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				match(CROSS);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(FULL);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(320);
					match(OUTER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				match(LEFT);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(324);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 5);
				{
				setState(327);
				match(RIGHT);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(328);
					match(OUTER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinSpecificationContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(BigQuerySqlParser.ON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(BigQuerySqlParser.USING, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public JoinSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterJoinSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitJoinSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitJoinSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinSpecificationContext joinSpecification() throws RecognitionException {
		JoinSpecificationContext _localctx = new JoinSpecificationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_joinSpecification);
		int _la;
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(ON);
				setState(334);
				expression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(USING);
				setState(336);
				match(LPAREN);
				setState(337);
				identifier();
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(338);
					match(T__0);
					setState(339);
					identifier();
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(345);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(BigQuerySqlParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(WHERE);
			setState(350);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(BigQuerySqlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(BigQuerySqlParser.BY, 0); }
		public List<GroupingElementContext> groupingElement() {
			return getRuleContexts(GroupingElementContext.class);
		}
		public GroupingElementContext groupingElement(int i) {
			return getRuleContext(GroupingElementContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitGroupByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_groupByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(GROUP);
			setState(353);
			match(BY);
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(354);
				setQuantifier();
				}
				break;
			}
			setState(357);
			groupingElement();
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(358);
					match(T__0);
					setState(359);
					groupingElement();
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupingElementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ROLLUP() { return getToken(BigQuerySqlParser.ROLLUP, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TerminalNode CUBE() { return getToken(BigQuerySqlParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(BigQuerySqlParser.GROUPING, 0); }
		public TerminalNode SETS() { return getToken(BigQuerySqlParser.SETS, 0); }
		public List<GroupingSetContext> groupingSet() {
			return getRuleContexts(GroupingSetContext.class);
		}
		public GroupingSetContext groupingSet(int i) {
			return getRuleContext(GroupingSetContext.class,i);
		}
		public GroupingElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterGroupingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitGroupingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitGroupingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingElementContext groupingElement() throws RecognitionException {
		GroupingElementContext _localctx = new GroupingElementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_groupingElement);
		int _la;
		try {
			setState(403);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				match(ROLLUP);
				setState(367);
				match(LPAREN);
				setState(368);
				expression(0);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(369);
					match(T__0);
					setState(370);
					expression(0);
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(376);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				match(CUBE);
				setState(379);
				match(LPAREN);
				setState(380);
				expression(0);
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(381);
					match(T__0);
					setState(382);
					expression(0);
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(388);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(GROUPING);
				setState(391);
				match(SETS);
				setState(392);
				match(LPAREN);
				setState(393);
				groupingSet();
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(394);
					match(T__0);
					setState(395);
					groupingSet();
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupingSetContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterGroupingSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitGroupingSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingSetContext groupingSet() throws RecognitionException {
		GroupingSetContext _localctx = new GroupingSetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_groupingSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(LPAREN);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -18014432870266784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1188862203257684001L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 259191L) != 0)) {
				{
				setState(406);
				expression(0);
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(407);
					match(T__0);
					setState(408);
					expression(0);
					}
					}
					setState(413);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(416);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HavingClauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(BigQuerySqlParser.HAVING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitHavingClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitHavingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(HAVING);
			setState(419);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifyClauseContext extends ParserRuleContext {
		public TerminalNode QUALIFY() { return getToken(BigQuerySqlParser.QUALIFY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifyClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterQualifyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitQualifyClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitQualifyClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifyClauseContext qualifyClause() throws RecognitionException {
		QualifyClauseContext _localctx = new QualifyClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_qualifyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(QUALIFY);
			setState(422);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WindowClauseContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(BigQuerySqlParser.WINDOW, 0); }
		public List<NamedWindowContext> namedWindow() {
			return getRuleContexts(NamedWindowContext.class);
		}
		public NamedWindowContext namedWindow(int i) {
			return getRuleContext(NamedWindowContext.class,i);
		}
		public WindowClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWindowClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWindowClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWindowClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_windowClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(WINDOW);
			setState(425);
			namedWindow();
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(426);
					match(T__0);
					setState(427);
					namedWindow();
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedWindowContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public NamedWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedWindow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterNamedWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitNamedWindow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitNamedWindow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedWindowContext namedWindow() throws RecognitionException {
		NamedWindowContext _localctx = new NamedWindowContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_namedWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			identifier();
			setState(434);
			match(AS);
			setState(435);
			windowSpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WindowSpecificationContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public PartitionClauseContext partitionClause() {
			return getRuleContext(PartitionClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public FrameClauseContext frameClause() {
			return getRuleContext(FrameClauseContext.class,0);
		}
		public WindowSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWindowSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWindowSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWindowSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowSpecificationContext windowSpecification() throws RecognitionException {
		WindowSpecificationContext _localctx = new WindowSpecificationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_windowSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(LPAREN);
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(438);
				windowName();
				}
				break;
			}
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(441);
				partitionClause();
				}
			}

			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(444);
				orderByClause();
				}
			}

			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RANGE || _la==ROWS) {
				{
				setState(447);
				frameClause();
				}
			}

			setState(450);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WindowNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public WindowNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterWindowName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitWindowName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitWindowName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PartitionClauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(BigQuerySqlParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(BigQuerySqlParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PartitionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterPartitionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitPartitionClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitPartitionClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionClauseContext partitionClause() throws RecognitionException {
		PartitionClauseContext _localctx = new PartitionClauseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_partitionClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(PARTITION);
			setState(455);
			match(BY);
			setState(456);
			expression(0);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(457);
				match(T__0);
				setState(458);
				expression(0);
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrderByClauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(BigQuerySqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(BigQuerySqlParser.BY, 0); }
		public List<OrderingItemContext> orderingItem() {
			return getRuleContexts(OrderingItemContext.class);
		}
		public OrderingItemContext orderingItem(int i) {
			return getRuleContext(OrderingItemContext.class,i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_orderByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(ORDER);
			setState(465);
			match(BY);
			setState(466);
			orderingItem();
			setState(471);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(467);
					match(T__0);
					setState(468);
					orderingItem();
					}
					} 
				}
				setState(473);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrderingItemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(BigQuerySqlParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(BigQuerySqlParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(BigQuerySqlParser.DESC, 0); }
		public TerminalNode FIRST() { return getToken(BigQuerySqlParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(BigQuerySqlParser.LAST, 0); }
		public OrderingItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderingItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterOrderingItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitOrderingItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitOrderingItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderingItemContext orderingItem() throws RecognitionException {
		OrderingItemContext _localctx = new OrderingItemContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_orderingItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			expression(0);
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(475);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(478);
				match(NULLS);
				setState(479);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FrameClauseContext extends ParserRuleContext {
		public FrameUnitsContext frameUnits() {
			return getRuleContext(FrameUnitsContext.class,0);
		}
		public FrameExtentContext frameExtent() {
			return getRuleContext(FrameExtentContext.class,0);
		}
		public FrameClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFrameClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFrameClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFrameClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameClauseContext frameClause() throws RecognitionException {
		FrameClauseContext _localctx = new FrameClauseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_frameClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			frameUnits();
			setState(483);
			frameExtent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FrameUnitsContext extends ParserRuleContext {
		public TerminalNode ROWS() { return getToken(BigQuerySqlParser.ROWS, 0); }
		public TerminalNode RANGE() { return getToken(BigQuerySqlParser.RANGE, 0); }
		public FrameUnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameUnits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFrameUnits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFrameUnits(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFrameUnits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameUnitsContext frameUnits() throws RecognitionException {
		FrameUnitsContext _localctx = new FrameUnitsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_frameUnits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_la = _input.LA(1);
			if ( !(_la==RANGE || _la==ROWS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FrameExtentContext extends ParserRuleContext {
		public FrameStartContext frameStart() {
			return getRuleContext(FrameStartContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(BigQuerySqlParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(BigQuerySqlParser.AND, 0); }
		public FrameEndContext frameEnd() {
			return getRuleContext(FrameEndContext.class,0);
		}
		public FrameExtentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameExtent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFrameExtent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFrameExtent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFrameExtent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameExtentContext frameExtent() throws RecognitionException {
		FrameExtentContext _localctx = new FrameExtentContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_frameExtent);
		try {
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				frameStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				match(BETWEEN);
				setState(489);
				frameStart();
				setState(490);
				match(AND);
				setState(491);
				frameEnd();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FrameStartContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(BigQuerySqlParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(BigQuerySqlParser.PRECEDING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(BigQuerySqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(BigQuerySqlParser.ROW, 0); }
		public TerminalNode FOLLOWING() { return getToken(BigQuerySqlParser.FOLLOWING, 0); }
		public FrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFrameStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFrameStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFrameStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameStartContext frameStart() throws RecognitionException {
		FrameStartContext _localctx = new FrameStartContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_frameStart);
		try {
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				match(UNBOUNDED);
				setState(496);
				match(PRECEDING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				expression(0);
				setState(498);
				match(PRECEDING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(500);
				match(CURRENT);
				setState(501);
				match(ROW);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				expression(0);
				setState(503);
				match(FOLLOWING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(505);
				match(UNBOUNDED);
				setState(506);
				match(FOLLOWING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FrameEndContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(BigQuerySqlParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(BigQuerySqlParser.PRECEDING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(BigQuerySqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(BigQuerySqlParser.ROW, 0); }
		public TerminalNode FOLLOWING() { return getToken(BigQuerySqlParser.FOLLOWING, 0); }
		public FrameEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFrameEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFrameEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFrameEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameEndContext frameEnd() throws RecognitionException {
		FrameEndContext _localctx = new FrameEndContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_frameEnd);
		try {
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				match(UNBOUNDED);
				setState(510);
				match(PRECEDING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				expression(0);
				setState(512);
				match(PRECEDING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(514);
				match(CURRENT);
				setState(515);
				match(ROW);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(516);
				expression(0);
				setState(517);
				match(FOLLOWING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(519);
				match(UNBOUNDED);
				setState(520);
				match(FOLLOWING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LimitClauseContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(BigQuerySqlParser.LIMIT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitLimitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitLimitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(LIMIT);
			setState(524);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(BigQuerySqlParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(BigQuerySqlParser.DISTINCT, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ColumnReferenceContext columnReference() {
			return getRuleContext(ColumnReferenceContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CaseExpressionContext caseExpression() {
			return getRuleContext(CaseExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public StructExpressionContext structExpression() {
			return getRuleContext(StructExpressionContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(BigQuerySqlParser.EXISTS, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TerminalNode ALL() { return getToken(BigQuerySqlParser.ALL, 0); }
		public TerminalNode SOME() { return getToken(BigQuerySqlParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(BigQuerySqlParser.ANY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(BigQuerySqlParser.NOT, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public TerminalNode AND() { return getToken(BigQuerySqlParser.AND, 0); }
		public TerminalNode OR() { return getToken(BigQuerySqlParser.OR, 0); }
		public TerminalNode LIKE() { return getToken(BigQuerySqlParser.LIKE, 0); }
		public TerminalNode IS() { return getToken(BigQuerySqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(BigQuerySqlParser.NULL, 0); }
		public TerminalNode BETWEEN() { return getToken(BigQuerySqlParser.BETWEEN, 0); }
		public TerminalNode IN() { return getToken(BigQuerySqlParser.IN, 0); }
		public InPredicateValueContext inPredicateValue() {
			return getRuleContext(InPredicateValueContext.class,0);
		}
		public TerminalNode COLLATE() { return getToken(BigQuerySqlParser.COLLATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(529);
				literal();
				}
				break;
			case 2:
				{
				setState(530);
				columnReference();
				}
				break;
			case 3:
				{
				setState(531);
				castExpression();
				}
				break;
			case 4:
				{
				setState(532);
				functionCall();
				}
				break;
			case 5:
				{
				setState(533);
				caseExpression();
				}
				break;
			case 6:
				{
				setState(534);
				arrayExpression();
				}
				break;
			case 7:
				{
				setState(535);
				structExpression();
				}
				break;
			case 8:
				{
				setState(536);
				match(EXISTS);
				setState(537);
				match(LPAREN);
				setState(538);
				queryExpression(0);
				setState(539);
				match(RPAREN);
				}
				break;
			case 9:
				{
				setState(541);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==ANY || _la==SOME) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(542);
				match(LPAREN);
				setState(543);
				queryExpression(0);
				setState(544);
				match(RPAREN);
				}
				break;
			case 10:
				{
				setState(546);
				match(LPAREN);
				setState(547);
				queryExpression(0);
				setState(548);
				match(RPAREN);
				}
				break;
			case 11:
				{
				setState(550);
				match(LPAREN);
				setState(551);
				expression(0);
				setState(552);
				match(RPAREN);
				}
				break;
			case 12:
				{
				setState(554);
				match(NOT);
				setState(555);
				expression(17);
				}
				break;
			case 13:
				{
				setState(556);
				match(T__5);
				setState(557);
				expression(3);
				}
				break;
			case 14:
				{
				setState(558);
				match(T__4);
				setState(559);
				expression(2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(629);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(627);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(562);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(563);
						comparisonOperator();
						setState(564);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(566);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(567);
						match(AND);
						setState(568);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(569);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(570);
						match(OR);
						setState(571);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(572);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(573);
						match(LIKE);
						setState(574);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(575);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(576);
						match(T__3);
						setState(577);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(578);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(579);
						match(T__4);
						setState(580);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(581);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(582);
						match(T__5);
						setState(583);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(584);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(585);
						match(T__1);
						setState(586);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(587);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(588);
						match(T__6);
						setState(589);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(590);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(591);
						match(T__7);
						setState(592);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(593);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(594);
						match(T__8);
						setState(595);
						expression(0);
						setState(596);
						match(T__9);
						setState(597);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(599);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(600);
						comparisonOperator();
						setState(601);
						_la = _input.LA(1);
						if ( !(_la==ALL || _la==ANY || _la==SOME) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(602);
						match(LPAREN);
						setState(603);
						queryExpression(0);
						setState(604);
						match(RPAREN);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(606);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(607);
						match(IS);
						setState(609);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(608);
							match(NOT);
							}
						}

						setState(611);
						match(NULL);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(612);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						{
						setState(613);
						match(BETWEEN);
						setState(614);
						expression(0);
						setState(615);
						match(AND);
						setState(616);
						expression(0);
						}
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(618);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(620);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(619);
							match(NOT);
							}
						}

						setState(622);
						match(IN);
						setState(623);
						inPredicateValue();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(624);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(625);
						match(COLLATE);
						setState(626);
						identifier();
						}
						break;
					}
					} 
				}
				setState(631);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InPredicateValueContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode UNNEST() { return getToken(BigQuerySqlParser.UNNEST, 0); }
		public InPredicateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inPredicateValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterInPredicateValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitInPredicateValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitInPredicateValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InPredicateValueContext inPredicateValue() throws RecognitionException {
		InPredicateValueContext _localctx = new InPredicateValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_inPredicateValue);
		int _la;
		try {
			setState(653);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(632);
				match(LPAREN);
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -18014432870266784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1188862203257684001L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 259191L) != 0)) {
					{
					setState(633);
					expression(0);
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(634);
						match(T__0);
						setState(635);
						expression(0);
						}
						}
						setState(640);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(643);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				match(LPAREN);
				setState(645);
				queryExpression(0);
				setState(646);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(648);
				match(UNNEST);
				setState(649);
				match(LPAREN);
				setState(650);
				expression(0);
				setState(651);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseExpressionContext extends ParserRuleContext {
		public SimpleCaseExpressionContext simpleCaseExpression() {
			return getRuleContext(SimpleCaseExpressionContext.class,0);
		}
		public SearchedCaseExpressionContext searchedCaseExpression() {
			return getRuleContext(SearchedCaseExpressionContext.class,0);
		}
		public CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_caseExpression);
		try {
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(655);
				simpleCaseExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				searchedCaseExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleCaseExpressionContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(BigQuerySqlParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END() { return getToken(BigQuerySqlParser.END, 0); }
		public List<TerminalNode> WHEN() { return getTokens(BigQuerySqlParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(BigQuerySqlParser.WHEN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(BigQuerySqlParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(BigQuerySqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(BigQuerySqlParser.ELSE, 0); }
		public SimpleCaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSimpleCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSimpleCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSimpleCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCaseExpressionContext simpleCaseExpression() throws RecognitionException {
		SimpleCaseExpressionContext _localctx = new SimpleCaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_simpleCaseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(CASE);
			setState(660);
			expression(0);
			setState(666); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(661);
				match(WHEN);
				setState(662);
				expression(0);
				setState(663);
				match(THEN);
				setState(664);
				expression(0);
				}
				}
				setState(668); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(670);
				match(ELSE);
				setState(671);
				expression(0);
				}
			}

			setState(674);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SearchedCaseExpressionContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(BigQuerySqlParser.CASE, 0); }
		public TerminalNode END() { return getToken(BigQuerySqlParser.END, 0); }
		public List<TerminalNode> WHEN() { return getTokens(BigQuerySqlParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(BigQuerySqlParser.WHEN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(BigQuerySqlParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(BigQuerySqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(BigQuerySqlParser.ELSE, 0); }
		public SearchedCaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchedCaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterSearchedCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitSearchedCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitSearchedCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchedCaseExpressionContext searchedCaseExpression() throws RecognitionException {
		SearchedCaseExpressionContext _localctx = new SearchedCaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_searchedCaseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(CASE);
			setState(682); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(677);
				match(WHEN);
				setState(678);
				expression(0);
				setState(679);
				match(THEN);
				setState(680);
				expression(0);
				}
				}
				setState(684); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(686);
				match(ELSE);
				setState(687);
				expression(0);
				}
			}

			setState(690);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(BigQuerySqlParser.CAST, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TerminalNode SAFE_CAST() { return getToken(BigQuerySqlParser.SAFE_CAST, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_castExpression);
		try {
			setState(706);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(692);
				match(CAST);
				setState(693);
				match(LPAREN);
				setState(694);
				expression(0);
				setState(695);
				match(AS);
				setState(696);
				dataType();
				setState(697);
				match(RPAREN);
				}
				break;
			case SAFE_CAST:
				enterOuterAlt(_localctx, 2);
				{
				setState(699);
				match(SAFE_CAST);
				setState(700);
				match(LPAREN);
				setState(701);
				expression(0);
				setState(702);
				match(AS);
				setState(703);
				dataType();
				setState(704);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ARRAY() { return getToken(BigQuerySqlParser.ARRAY, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(BigQuerySqlParser.SELECT, 0); }
		public SelectItemContext selectItem() {
			return getRuleContext(SelectItemContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BigQuerySqlParser.FROM, 0); }
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_arrayExpression);
		int _la;
		try {
			setState(745);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(708);
				match(T__10);
				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -18014432870266784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1188862203257684001L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 259191L) != 0)) {
					{
					setState(709);
					expression(0);
					setState(714);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(710);
						match(T__0);
						setState(711);
						expression(0);
						}
						}
						setState(716);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(719);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(720);
				match(ARRAY);
				setState(721);
				match(T__12);
				setState(722);
				dataType();
				setState(723);
				match(T__13);
				setState(724);
				match(T__10);
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -18014432870266784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1188862203257684001L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 259191L) != 0)) {
					{
					setState(725);
					expression(0);
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(726);
						match(T__0);
						setState(727);
						expression(0);
						}
						}
						setState(732);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(735);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(737);
				match(ARRAY);
				{
				setState(738);
				match(SELECT);
				setState(739);
				selectItem();
				setState(740);
				match(FROM);
				setState(741);
				tableExpression();
				setState(743);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(742);
					whereClause();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructExpressionContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(BigQuerySqlParser.STRUCT, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public StructExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterStructExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitStructExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitStructExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExpressionContext structExpression() throws RecognitionException {
		StructExpressionContext _localctx = new StructExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_structExpression);
		int _la;
		try {
			setState(776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(747);
				match(STRUCT);
				setState(759);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(748);
					match(LPAREN);
					setState(749);
					structField();
					setState(754);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(750);
						match(T__0);
						setState(751);
						structField();
						}
						}
						setState(756);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(757);
					match(RPAREN);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(761);
				match(STRUCT);
				setState(762);
				match(T__12);
				setState(763);
				identifier();
				setState(764);
				dataType();
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(765);
					match(T__0);
					setState(766);
					identifier();
					setState(767);
					dataType();
					}
					}
					setState(773);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(774);
				match(T__13);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterStructField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitStructField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitStructField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_structField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			expression(0);
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(779);
				match(AS);
				setState(780);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TerminalNode COUNT() { return getToken(BigQuerySqlParser.COUNT, 0); }
		public TerminalNode SUM() { return getToken(BigQuerySqlParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(BigQuerySqlParser.AVG, 0); }
		public TerminalNode MIN() { return getToken(BigQuerySqlParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(BigQuerySqlParser.MAX, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DISTINCT() { return getToken(BigQuerySqlParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(BigQuerySqlParser.ALL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OVER() { return getToken(BigQuerySqlParser.OVER, 0); }
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public TerminalNode EXTRACT() { return getToken(BigQuerySqlParser.EXTRACT, 0); }
		public TerminalNode FROM() { return getToken(BigQuerySqlParser.FROM, 0); }
		public TerminalNode DATE_ADD() { return getToken(BigQuerySqlParser.DATE_ADD, 0); }
		public TerminalNode INTERVAL() { return getToken(BigQuerySqlParser.INTERVAL, 0); }
		public DateUnitContext dateUnit() {
			return getRuleContext(DateUnitContext.class,0);
		}
		public TerminalNode DATE_SUB() { return getToken(BigQuerySqlParser.DATE_SUB, 0); }
		public TerminalNode DATE_DIFF() { return getToken(BigQuerySqlParser.DATE_DIFF, 0); }
		public TerminalNode TIMESTAMP_ADD() { return getToken(BigQuerySqlParser.TIMESTAMP_ADD, 0); }
		public TerminalNode TIMESTAMP_SUB() { return getToken(BigQuerySqlParser.TIMESTAMP_SUB, 0); }
		public TerminalNode TIMESTAMP_DIFF() { return getToken(BigQuerySqlParser.TIMESTAMP_DIFF, 0); }
		public TerminalNode DATE_TRUNC() { return getToken(BigQuerySqlParser.DATE_TRUNC, 0); }
		public TerminalNode TIMESTAMP_TRUNC() { return getToken(BigQuerySqlParser.TIMESTAMP_TRUNC, 0); }
		public TerminalNode JSON_EXTRACT() { return getToken(BigQuerySqlParser.JSON_EXTRACT, 0); }
		public TerminalNode JSON_EXTRACT_SCALAR() { return getToken(BigQuerySqlParser.JSON_EXTRACT_SCALAR, 0); }
		public TerminalNode JSON_QUERY() { return getToken(BigQuerySqlParser.JSON_QUERY, 0); }
		public TerminalNode JSON_VALUE() { return getToken(BigQuerySqlParser.JSON_VALUE, 0); }
		public TerminalNode TO_JSON_STRING() { return getToken(BigQuerySqlParser.TO_JSON_STRING, 0); }
		public TerminalNode PARSE_JSON() { return getToken(BigQuerySqlParser.PARSE_JSON, 0); }
		public TerminalNode ARRAY_AGG() { return getToken(BigQuerySqlParser.ARRAY_AGG, 0); }
		public TerminalNode ORDER() { return getToken(BigQuerySqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(BigQuerySqlParser.BY, 0); }
		public List<OrderingItemContext> orderingItem() {
			return getRuleContexts(OrderingItemContext.class);
		}
		public OrderingItemContext orderingItem(int i) {
			return getRuleContext(OrderingItemContext.class,i);
		}
		public TerminalNode LIMIT() { return getToken(BigQuerySqlParser.LIMIT, 0); }
		public TerminalNode GENERATE_ARRAY() { return getToken(BigQuerySqlParser.GENERATE_ARRAY, 0); }
		public TerminalNode GENERATE_DATE_ARRAY() { return getToken(BigQuerySqlParser.GENERATE_DATE_ARRAY, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_functionCall);
		int _la;
		try {
			setState(977);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(783);
				_la = _input.LA(1);
				if ( !(_la==AVG || _la==COUNT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 9007199254740995L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(784);
				match(LPAREN);
				setState(786);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(785);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(790);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__5:
				case T__10:
				case ARRAY_AGG:
				case ALL:
				case AND:
				case ANY:
				case ARRAY:
				case AS:
				case ASC:
				case AVG:
				case BETWEEN:
				case BY:
				case CASE:
				case CAST:
				case COLLATE:
				case COUNT:
				case CROSS:
				case CURRENT:
				case DATE:
				case DATE_ADD:
				case DATE_DIFF:
				case DATE_SUB:
				case DATE_TRUNC:
				case DATETIME:
				case TIMESTAMP_ADD:
				case TIMESTAMP_SUB:
				case TIMESTAMP_DIFF:
				case TIMESTAMP_TRUNC:
				case TO_JSON_STRING:
				case TIME:
				case TIMESTAMP:
				case DESC:
				case DISTINCT:
				case ELSE:
				case END:
				case EXISTS:
				case EXTRACT:
				case FIRST:
				case FOLLOWING:
				case FROM:
				case FULL:
				case GENERATE_ARRAY:
				case GENERATE_DATE_ARRAY:
				case GROUP:
				case GROUPING:
				case HAVING:
				case IN:
				case INNER:
				case INTERSECT:
				case IS:
				case JOIN:
				case JSON_EXTRACT:
				case JSON_EXTRACT_SCALAR:
				case JSON_QUERY:
				case JSON_VALUE:
				case LAST:
				case LEFT:
				case LIKE:
				case LIMIT:
				case MAX:
				case MIN:
				case NOT:
				case NULLS:
				case ON:
				case OR:
				case ORDER:
				case OUTER:
				case OVER:
				case PARSE_JSON:
				case PARTITION:
				case PRECEDING:
				case QUALIFY:
				case RANGE:
				case RIGHT:
				case ROLLUP:
				case ROW:
				case ROWS:
				case SAFE_CAST:
				case SELECT:
				case YEAR:
				case MONTH:
				case TRUE:
				case FALSE:
				case NULL:
				case WITH:
				case UNION:
				case USING:
				case WHERE:
				case SETS:
				case WINDOW:
				case UNBOUNDED:
				case WHEN:
				case STRUCT:
				case SUM:
				case SOME:
				case LPAREN:
				case IDENTIFIER:
				case BACKTICK_IDENTIFIER:
				case QUOTED_IDENTIFIER:
				case STRING_LITERAL:
				case INTEGER_LITERAL:
				case FLOAT_LITERAL:
					{
					setState(788);
					expression(0);
					}
					break;
				case T__1:
					{
					setState(789);
					match(T__1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(792);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(793);
				identifier();
				setState(794);
				match(LPAREN);
				setState(796);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(795);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(806);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -18014432870266784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1188862203257684001L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 259191L) != 0)) {
					{
					setState(798);
					expression(0);
					setState(803);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(799);
						match(T__0);
						setState(800);
						expression(0);
						}
						}
						setState(805);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(808);
				match(RPAREN);
				setState(811);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(809);
					match(OVER);
					setState(810);
					windowSpecification();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(813);
				identifier();
				setState(814);
				match(LPAREN);
				setState(815);
				match(T__1);
				setState(816);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(818);
				match(EXTRACT);
				setState(819);
				match(LPAREN);
				setState(820);
				identifier();
				setState(821);
				match(FROM);
				setState(822);
				expression(0);
				setState(823);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(825);
				match(DATE_ADD);
				setState(826);
				match(LPAREN);
				setState(827);
				expression(0);
				setState(828);
				match(T__0);
				setState(829);
				match(INTERVAL);
				setState(830);
				expression(0);
				setState(831);
				dateUnit();
				setState(832);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(834);
				match(DATE_SUB);
				setState(835);
				match(LPAREN);
				setState(836);
				expression(0);
				setState(837);
				match(T__0);
				setState(838);
				match(INTERVAL);
				setState(839);
				expression(0);
				setState(840);
				dateUnit();
				setState(841);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(843);
				match(DATE_DIFF);
				setState(844);
				match(LPAREN);
				setState(845);
				expression(0);
				setState(846);
				match(T__0);
				setState(847);
				expression(0);
				setState(848);
				match(T__0);
				setState(849);
				dateUnit();
				setState(850);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(852);
				match(TIMESTAMP_ADD);
				setState(853);
				match(LPAREN);
				setState(854);
				expression(0);
				setState(855);
				match(T__0);
				setState(856);
				match(INTERVAL);
				setState(857);
				expression(0);
				setState(858);
				dateUnit();
				setState(859);
				match(RPAREN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(861);
				match(TIMESTAMP_SUB);
				setState(862);
				match(LPAREN);
				setState(863);
				expression(0);
				setState(864);
				match(T__0);
				setState(865);
				match(INTERVAL);
				setState(866);
				expression(0);
				setState(867);
				dateUnit();
				setState(868);
				match(RPAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(870);
				match(TIMESTAMP_DIFF);
				setState(871);
				match(LPAREN);
				setState(872);
				expression(0);
				setState(873);
				match(T__0);
				setState(874);
				expression(0);
				setState(875);
				match(T__0);
				setState(876);
				dateUnit();
				setState(877);
				match(RPAREN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(879);
				match(DATE_TRUNC);
				setState(880);
				match(LPAREN);
				setState(881);
				expression(0);
				setState(882);
				match(T__0);
				setState(883);
				dateUnit();
				setState(884);
				match(RPAREN);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(886);
				match(TIMESTAMP_TRUNC);
				setState(887);
				match(LPAREN);
				setState(888);
				expression(0);
				setState(889);
				match(T__0);
				setState(890);
				dateUnit();
				setState(891);
				match(RPAREN);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(893);
				match(JSON_EXTRACT);
				setState(894);
				match(LPAREN);
				setState(895);
				expression(0);
				setState(896);
				match(T__0);
				setState(897);
				expression(0);
				setState(898);
				match(RPAREN);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(900);
				match(JSON_EXTRACT_SCALAR);
				setState(901);
				match(LPAREN);
				setState(902);
				expression(0);
				setState(903);
				match(T__0);
				setState(904);
				expression(0);
				setState(905);
				match(RPAREN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(907);
				match(JSON_QUERY);
				setState(908);
				match(LPAREN);
				setState(909);
				expression(0);
				setState(910);
				match(T__0);
				setState(911);
				expression(0);
				setState(912);
				match(RPAREN);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(914);
				match(JSON_VALUE);
				setState(915);
				match(LPAREN);
				setState(916);
				expression(0);
				setState(917);
				match(T__0);
				setState(918);
				expression(0);
				setState(919);
				match(RPAREN);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(921);
				match(TO_JSON_STRING);
				setState(922);
				match(LPAREN);
				setState(923);
				expression(0);
				setState(924);
				match(RPAREN);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(926);
				match(PARSE_JSON);
				setState(927);
				match(LPAREN);
				setState(928);
				expression(0);
				setState(929);
				match(RPAREN);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(931);
				match(ARRAY_AGG);
				setState(932);
				match(LPAREN);
				setState(934);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(933);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(936);
				expression(0);
				setState(947);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(937);
					match(ORDER);
					setState(938);
					match(BY);
					setState(939);
					orderingItem();
					setState(944);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(940);
						match(T__0);
						setState(941);
						orderingItem();
						}
						}
						setState(946);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIMIT) {
					{
					setState(949);
					match(LIMIT);
					setState(950);
					expression(0);
					}
				}

				setState(953);
				match(RPAREN);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(955);
				match(GENERATE_ARRAY);
				setState(956);
				match(LPAREN);
				setState(957);
				expression(0);
				setState(958);
				match(T__0);
				setState(959);
				expression(0);
				setState(962);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(960);
					match(T__0);
					setState(961);
					expression(0);
					}
				}

				setState(964);
				match(RPAREN);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(966);
				match(GENERATE_DATE_ARRAY);
				setState(967);
				match(LPAREN);
				setState(968);
				expression(0);
				setState(969);
				match(T__0);
				setState(970);
				expression(0);
				setState(973);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(971);
					match(T__0);
					setState(972);
					expression(0);
					}
				}

				setState(975);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(979);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1040384L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnReferenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public ColumnReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnReferenceContext columnReference() throws RecognitionException {
		ColumnReferenceContext _localctx = new ColumnReferenceContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_columnReference);
		try {
			setState(992);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(981);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(982);
				tableIdentifier();
				setState(983);
				match(T__2);
				setState(984);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(986);
				tableIdentifier();
				setState(987);
				match(T__2);
				setState(988);
				tableIdentifier();
				setState(989);
				match(T__2);
				setState(990);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIdentifierContext tableIdentifier() throws RecognitionException {
		TableIdentifierContext _localctx = new TableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(994);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT64() { return getToken(BigQuerySqlParser.INT64, 0); }
		public TerminalNode FLOAT64() { return getToken(BigQuerySqlParser.FLOAT64, 0); }
		public TerminalNode NUMERIC() { return getToken(BigQuerySqlParser.NUMERIC, 0); }
		public TerminalNode BIGNUMERIC() { return getToken(BigQuerySqlParser.BIGNUMERIC, 0); }
		public TerminalNode BOOL() { return getToken(BigQuerySqlParser.BOOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(BigQuerySqlParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(BigQuerySqlParser.STRING, 0); }
		public TerminalNode LPAREN() { return getToken(BigQuerySqlParser.LPAREN, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(BigQuerySqlParser.INTEGER_LITERAL, 0); }
		public TerminalNode RPAREN() { return getToken(BigQuerySqlParser.RPAREN, 0); }
		public TerminalNode BYTES() { return getToken(BigQuerySqlParser.BYTES, 0); }
		public TerminalNode DATE() { return getToken(BigQuerySqlParser.DATE, 0); }
		public TerminalNode DATETIME() { return getToken(BigQuerySqlParser.DATETIME, 0); }
		public TerminalNode TIME() { return getToken(BigQuerySqlParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(BigQuerySqlParser.TIMESTAMP, 0); }
		public TerminalNode INTERVAL() { return getToken(BigQuerySqlParser.INTERVAL, 0); }
		public TerminalNode GEOGRAPHY() { return getToken(BigQuerySqlParser.GEOGRAPHY, 0); }
		public TerminalNode JSON() { return getToken(BigQuerySqlParser.JSON, 0); }
		public TerminalNode ARRAY() { return getToken(BigQuerySqlParser.ARRAY, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(BigQuerySqlParser.STRUCT, 0); }
		public List<StructTypeElementContext> structTypeElement() {
			return getRuleContexts(StructTypeElementContext.class);
		}
		public StructTypeElementContext structTypeElement(int i) {
			return getRuleContext(StructTypeElementContext.class,i);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_dataType);
		int _la;
		try {
			setState(1038);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(996);
				match(INT64);
				}
				break;
			case FLOAT64:
				enterOuterAlt(_localctx, 2);
				{
				setState(997);
				match(FLOAT64);
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(998);
				match(NUMERIC);
				}
				break;
			case BIGNUMERIC:
				enterOuterAlt(_localctx, 4);
				{
				setState(999);
				match(BIGNUMERIC);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1000);
				match(BOOL);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 6);
				{
				setState(1001);
				match(BOOLEAN);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 7);
				{
				setState(1002);
				match(STRING);
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(1003);
					match(LPAREN);
					setState(1004);
					match(INTEGER_LITERAL);
					setState(1005);
					match(RPAREN);
					}
				}

				}
				break;
			case BYTES:
				enterOuterAlt(_localctx, 8);
				{
				setState(1008);
				match(BYTES);
				setState(1012);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(1009);
					match(LPAREN);
					setState(1010);
					match(INTEGER_LITERAL);
					setState(1011);
					match(RPAREN);
					}
				}

				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1014);
				match(DATE);
				}
				break;
			case DATETIME:
				enterOuterAlt(_localctx, 10);
				{
				setState(1015);
				match(DATETIME);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 11);
				{
				setState(1016);
				match(TIME);
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 12);
				{
				setState(1017);
				match(TIMESTAMP);
				}
				break;
			case INTERVAL:
				enterOuterAlt(_localctx, 13);
				{
				setState(1018);
				match(INTERVAL);
				}
				break;
			case GEOGRAPHY:
				enterOuterAlt(_localctx, 14);
				{
				setState(1019);
				match(GEOGRAPHY);
				}
				break;
			case JSON:
				enterOuterAlt(_localctx, 15);
				{
				setState(1020);
				match(JSON);
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 16);
				{
				setState(1021);
				match(ARRAY);
				setState(1022);
				match(T__12);
				setState(1023);
				dataType();
				setState(1024);
				match(T__13);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 17);
				{
				setState(1026);
				match(STRUCT);
				setState(1027);
				match(T__12);
				setState(1028);
				structTypeElement();
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(1029);
					match(T__0);
					setState(1030);
					structTypeElement();
					}
					}
					setState(1035);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1036);
				match(T__13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructTypeElementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public StructTypeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structTypeElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterStructTypeElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitStructTypeElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitStructTypeElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeElementContext structTypeElement() throws RecognitionException {
		StructTypeElementContext _localctx = new StructTypeElementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_structTypeElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040);
			identifier();
			setState(1041);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateUnitContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(BigQuerySqlParser.YEAR, 0); }
		public TerminalNode QUARTER() { return getToken(BigQuerySqlParser.QUARTER, 0); }
		public TerminalNode MONTH() { return getToken(BigQuerySqlParser.MONTH, 0); }
		public TerminalNode WEEK() { return getToken(BigQuerySqlParser.WEEK, 0); }
		public TerminalNode DAY() { return getToken(BigQuerySqlParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(BigQuerySqlParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(BigQuerySqlParser.MINUTE, 0); }
		public TerminalNode SECOND() { return getToken(BigQuerySqlParser.SECOND, 0); }
		public TerminalNode MILLISECOND() { return getToken(BigQuerySqlParser.MILLISECOND, 0); }
		public TerminalNode MICROSECOND() { return getToken(BigQuerySqlParser.MICROSECOND, 0); }
		public TerminalNode NANOSECOND() { return getToken(BigQuerySqlParser.NANOSECOND, 0); }
		public DateUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterDateUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitDateUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitDateUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateUnitContext dateUnit() throws RecognitionException {
		DateUnitContext _localctx = new DateUnitContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_dateUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			_la = _input.LA(1);
			if ( !(((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 2047L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(BigQuerySqlParser.STRING_LITERAL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(BigQuerySqlParser.INTEGER_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(BigQuerySqlParser.FLOAT_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(BigQuerySqlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BigQuerySqlParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(BigQuerySqlParser.NULL, 0); }
		public TerminalNode DATE() { return getToken(BigQuerySqlParser.DATE, 0); }
		public TerminalNode TIME() { return getToken(BigQuerySqlParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(BigQuerySqlParser.TIMESTAMP, 0); }
		public TerminalNode DATETIME() { return getToken(BigQuerySqlParser.DATETIME, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_literal);
		try {
			setState(1059);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1045);
				match(STRING_LITERAL);
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1046);
				match(INTEGER_LITERAL);
				}
				break;
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1047);
				match(FLOAT_LITERAL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1048);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1049);
				match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(1050);
				match(NULL);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 7);
				{
				setState(1051);
				match(DATE);
				setState(1052);
				match(STRING_LITERAL);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 8);
				{
				setState(1053);
				match(TIME);
				setState(1054);
				match(STRING_LITERAL);
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 9);
				{
				setState(1055);
				match(TIMESTAMP);
				setState(1056);
				match(STRING_LITERAL);
				}
				break;
			case DATETIME:
				enterOuterAlt(_localctx, 10);
				{
				setState(1057);
				match(DATETIME);
				setState(1058);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BigQuerySqlParser.IDENTIFIER, 0); }
		public TerminalNode BACKTICK_IDENTIFIER() { return getToken(BigQuerySqlParser.BACKTICK_IDENTIFIER, 0); }
		public TerminalNode QUOTED_IDENTIFIER() { return getToken(BigQuerySqlParser.QUOTED_IDENTIFIER, 0); }
		public NonReservedKeywordContext nonReservedKeyword() {
			return getRuleContext(NonReservedKeywordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_identifier);
		try {
			setState(1065);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1061);
				match(IDENTIFIER);
				}
				break;
			case BACKTICK_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1062);
				match(BACKTICK_IDENTIFIER);
				}
				break;
			case QUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1063);
				match(QUOTED_IDENTIFIER);
				}
				break;
			case ALL:
			case AND:
			case ANY:
			case ARRAY:
			case AS:
			case ASC:
			case BETWEEN:
			case BY:
			case CASE:
			case CAST:
			case COLLATE:
			case CROSS:
			case CURRENT:
			case DESC:
			case DISTINCT:
			case ELSE:
			case END:
			case EXISTS:
			case EXTRACT:
			case FIRST:
			case FOLLOWING:
			case FROM:
			case FULL:
			case GROUP:
			case GROUPING:
			case HAVING:
			case IN:
			case INNER:
			case INTERSECT:
			case IS:
			case JOIN:
			case LAST:
			case LEFT:
			case LIKE:
			case LIMIT:
			case NOT:
			case NULLS:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case OVER:
			case PARTITION:
			case PRECEDING:
			case QUALIFY:
			case RANGE:
			case RIGHT:
			case ROLLUP:
			case ROW:
			case ROWS:
			case SELECT:
			case YEAR:
			case MONTH:
			case TRUE:
			case FALSE:
			case NULL:
			case WITH:
			case UNION:
			case USING:
			case WHERE:
			case SETS:
			case WINDOW:
			case UNBOUNDED:
			case WHEN:
			case STRUCT:
			case SOME:
				enterOuterAlt(_localctx, 4);
				{
				setState(1064);
				nonReservedKeyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonReservedKeywordContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(BigQuerySqlParser.ALL, 0); }
		public TerminalNode AND() { return getToken(BigQuerySqlParser.AND, 0); }
		public TerminalNode ANY() { return getToken(BigQuerySqlParser.ANY, 0); }
		public TerminalNode ARRAY() { return getToken(BigQuerySqlParser.ARRAY, 0); }
		public TerminalNode AS() { return getToken(BigQuerySqlParser.AS, 0); }
		public TerminalNode ASC() { return getToken(BigQuerySqlParser.ASC, 0); }
		public TerminalNode BETWEEN() { return getToken(BigQuerySqlParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(BigQuerySqlParser.BY, 0); }
		public TerminalNode CASE() { return getToken(BigQuerySqlParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(BigQuerySqlParser.CAST, 0); }
		public TerminalNode COLLATE() { return getToken(BigQuerySqlParser.COLLATE, 0); }
		public TerminalNode CROSS() { return getToken(BigQuerySqlParser.CROSS, 0); }
		public TerminalNode CURRENT() { return getToken(BigQuerySqlParser.CURRENT, 0); }
		public TerminalNode DESC() { return getToken(BigQuerySqlParser.DESC, 0); }
		public TerminalNode DISTINCT() { return getToken(BigQuerySqlParser.DISTINCT, 0); }
		public TerminalNode ELSE() { return getToken(BigQuerySqlParser.ELSE, 0); }
		public TerminalNode END() { return getToken(BigQuerySqlParser.END, 0); }
		public TerminalNode EXISTS() { return getToken(BigQuerySqlParser.EXISTS, 0); }
		public TerminalNode EXTRACT() { return getToken(BigQuerySqlParser.EXTRACT, 0); }
		public TerminalNode FALSE() { return getToken(BigQuerySqlParser.FALSE, 0); }
		public TerminalNode FIRST() { return getToken(BigQuerySqlParser.FIRST, 0); }
		public TerminalNode FOLLOWING() { return getToken(BigQuerySqlParser.FOLLOWING, 0); }
		public TerminalNode FROM() { return getToken(BigQuerySqlParser.FROM, 0); }
		public TerminalNode FULL() { return getToken(BigQuerySqlParser.FULL, 0); }
		public TerminalNode GROUP() { return getToken(BigQuerySqlParser.GROUP, 0); }
		public TerminalNode GROUPING() { return getToken(BigQuerySqlParser.GROUPING, 0); }
		public TerminalNode HAVING() { return getToken(BigQuerySqlParser.HAVING, 0); }
		public TerminalNode IN() { return getToken(BigQuerySqlParser.IN, 0); }
		public TerminalNode INNER() { return getToken(BigQuerySqlParser.INNER, 0); }
		public TerminalNode INTERSECT() { return getToken(BigQuerySqlParser.INTERSECT, 0); }
		public TerminalNode IS() { return getToken(BigQuerySqlParser.IS, 0); }
		public TerminalNode JOIN() { return getToken(BigQuerySqlParser.JOIN, 0); }
		public TerminalNode LAST() { return getToken(BigQuerySqlParser.LAST, 0); }
		public TerminalNode LEFT() { return getToken(BigQuerySqlParser.LEFT, 0); }
		public TerminalNode LIKE() { return getToken(BigQuerySqlParser.LIKE, 0); }
		public TerminalNode LIMIT() { return getToken(BigQuerySqlParser.LIMIT, 0); }
		public TerminalNode MONTH() { return getToken(BigQuerySqlParser.MONTH, 0); }
		public TerminalNode NOT() { return getToken(BigQuerySqlParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(BigQuerySqlParser.NULL, 0); }
		public TerminalNode NULLS() { return getToken(BigQuerySqlParser.NULLS, 0); }
		public TerminalNode ON() { return getToken(BigQuerySqlParser.ON, 0); }
		public TerminalNode OR() { return getToken(BigQuerySqlParser.OR, 0); }
		public TerminalNode ORDER() { return getToken(BigQuerySqlParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(BigQuerySqlParser.OUTER, 0); }
		public TerminalNode OVER() { return getToken(BigQuerySqlParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(BigQuerySqlParser.PARTITION, 0); }
		public TerminalNode PRECEDING() { return getToken(BigQuerySqlParser.PRECEDING, 0); }
		public TerminalNode QUALIFY() { return getToken(BigQuerySqlParser.QUALIFY, 0); }
		public TerminalNode RANGE() { return getToken(BigQuerySqlParser.RANGE, 0); }
		public TerminalNode RIGHT() { return getToken(BigQuerySqlParser.RIGHT, 0); }
		public TerminalNode ROLLUP() { return getToken(BigQuerySqlParser.ROLLUP, 0); }
		public TerminalNode ROW() { return getToken(BigQuerySqlParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(BigQuerySqlParser.ROWS, 0); }
		public TerminalNode SELECT() { return getToken(BigQuerySqlParser.SELECT, 0); }
		public TerminalNode SETS() { return getToken(BigQuerySqlParser.SETS, 0); }
		public TerminalNode SOME() { return getToken(BigQuerySqlParser.SOME, 0); }
		public TerminalNode STRUCT() { return getToken(BigQuerySqlParser.STRUCT, 0); }
		public TerminalNode TRUE() { return getToken(BigQuerySqlParser.TRUE, 0); }
		public TerminalNode UNBOUNDED() { return getToken(BigQuerySqlParser.UNBOUNDED, 0); }
		public TerminalNode UNION() { return getToken(BigQuerySqlParser.UNION, 0); }
		public TerminalNode USING() { return getToken(BigQuerySqlParser.USING, 0); }
		public TerminalNode WHEN() { return getToken(BigQuerySqlParser.WHEN, 0); }
		public TerminalNode WHERE() { return getToken(BigQuerySqlParser.WHERE, 0); }
		public TerminalNode WINDOW() { return getToken(BigQuerySqlParser.WINDOW, 0); }
		public TerminalNode WITH() { return getToken(BigQuerySqlParser.WITH, 0); }
		public TerminalNode YEAR() { return getToken(BigQuerySqlParser.YEAR, 0); }
		public NonReservedKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReservedKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).enterNonReservedKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BigQuerySqlListener ) ((BigQuerySqlListener)listener).exitNonReservedKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BigQuerySqlVisitor ) return ((BigQuerySqlVisitor<? extends T>)visitor).visitNonReservedKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedKeywordContext nonReservedKeyword() throws RecognitionException {
		NonReservedKeywordContext _localctx = new NonReservedKeywordContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_nonReservedKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
			_la = _input.LA(1);
			if ( !(((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & 7459928000100872127L) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 773489292263391L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return queryExpression_sempred((QueryExpressionContext)_localctx, predIndex);
		case 15:
			return joinedTable_sempred((JoinedTableContext)_localctx, predIndex);
		case 38:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryExpression_sempred(QueryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean joinedTable_sempred(JoinedTableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 5);
		case 13:
			return precpred(_ctx, 4);
		case 14:
			return precpred(_ctx, 1);
		case 15:
			return precpred(_ctx, 21);
		case 16:
			return precpred(_ctx, 18);
		case 17:
			return precpred(_ctx, 12);
		case 18:
			return precpred(_ctx, 11);
		case 19:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0094\u042e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u0001\u0000\u0003\u0000t\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000x\b\u0000\u0001\u0000\u0003\u0000{\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0081\b\u0001\n"+
		"\u0001\f\u0001\u0084\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0092\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0098\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009e\b\u0003\u0001\u0003\u0005"+
		"\u0003\u00a1\b\u0003\n\u0003\f\u0003\u00a4\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00ad\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u00b1\b\u0006\u0001"+
		"\u0006\u0003\u0006\u00b4\b\u0006\u0001\u0006\u0003\u0006\u00b7\b\u0006"+
		"\u0001\u0006\u0003\u0006\u00ba\b\u0006\u0001\u0006\u0003\u0006\u00bd\b"+
		"\u0006\u0001\u0006\u0003\u0006\u00c0\b\u0006\u0001\u0006\u0003\u0006\u00c3"+
		"\b\u0006\u0001\u0006\u0003\u0006\u00c6\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00ca\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u00cf\b\u0007\n\u0007\f\u0007\u00d2\t\u0007\u0001\b\u0001\b\u0003\b\u00d6"+
		"\b\b\u0001\b\u0003\b\u00d9\b\b\u0001\b\u0001\b\u0003\b\u00dd\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00e7"+
		"\b\n\n\n\f\n\u00ea\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f"+
		"\u00f0\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00f6\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00fc\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0102\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0109\b\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u010e\b\f\u0001\f\u0003\f\u0111\b\f\u0003"+
		"\f\u0113\b\f\u0001\f\u0001\f\u0003\f\u0117\b\f\u0003\f\u0119\b\f\u0001"+
		"\r\u0003\r\u011c\b\r\u0001\r\u0001\r\u0003\r\u0120\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0126\b\u000e\n\u000e\f\u000e"+
		"\u0129\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0132\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0137\b\u000f\u0005\u000f\u0139\b\u000f\n\u000f"+
		"\f\u000f\u013c\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u0142\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0146\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u014a\b\u0010\u0003\u0010\u014c"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0155\b\u0011\n\u0011\f\u0011\u0158\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u015c\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0164\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0169\b\u0013\n\u0013"+
		"\f\u0013\u016c\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0174\b\u0014\n\u0014\f\u0014\u0177"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u0180\b\u0014\n\u0014\f\u0014\u0183\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u018d\b\u0014\n\u0014\f\u0014\u0190"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0194\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u019a\b\u0015\n\u0015"+
		"\f\u0015\u019d\t\u0015\u0003\u0015\u019f\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01ad\b\u0018"+
		"\n\u0018\f\u0018\u01b0\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01b8\b\u001a\u0001\u001a\u0003"+
		"\u001a\u01bb\b\u001a\u0001\u001a\u0003\u001a\u01be\b\u001a\u0001\u001a"+
		"\u0003\u001a\u01c1\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c"+
		"\u01cc\b\u001c\n\u001c\f\u001c\u01cf\t\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01d6\b\u001d\n\u001d\f\u001d"+
		"\u01d9\t\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u01dd\b\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u01e1\b\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!"+
		"\u01ee\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01fc\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u020a\b#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u0231"+
		"\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u0262\b&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u026d"+
		"\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u0274\b&\n&\f&\u0277\t&"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u027d\b\'\n\'\f\'\u0280\t\'\u0003"+
		"\'\u0282\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u028e\b\'\u0001(\u0001(\u0003(\u0292\b(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0004)\u029b\b)\u000b)\f)"+
		"\u029c\u0001)\u0001)\u0003)\u02a1\b)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0004*\u02ab\b*\u000b*\f*\u02ac\u0001*\u0001*\u0003"+
		"*\u02b1\b*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u02c3\b+\u0001"+
		",\u0001,\u0001,\u0001,\u0005,\u02c9\b,\n,\f,\u02cc\t,\u0003,\u02ce\b,"+
		"\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0005"+
		",\u02d9\b,\n,\f,\u02dc\t,\u0003,\u02de\b,\u0001,\u0001,\u0001,\u0001,"+
		"\u0001,\u0001,\u0001,\u0001,\u0003,\u02e8\b,\u0003,\u02ea\b,\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0005-\u02f1\b-\n-\f-\u02f4\t-\u0001-\u0001-\u0003"+
		"-\u02f8\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0005"+
		"-\u0302\b-\n-\f-\u0305\t-\u0001-\u0001-\u0003-\u0309\b-\u0001.\u0001."+
		"\u0001.\u0003.\u030e\b.\u0001/\u0001/\u0001/\u0003/\u0313\b/\u0001/\u0001"+
		"/\u0003/\u0317\b/\u0001/\u0001/\u0001/\u0001/\u0003/\u031d\b/\u0001/\u0001"+
		"/\u0001/\u0005/\u0322\b/\n/\f/\u0325\t/\u0003/\u0327\b/\u0001/\u0001/"+
		"\u0001/\u0003/\u032c\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0003/\u03a7\b/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0005/\u03af\b/\n/\f/\u03b2\t/\u0003/\u03b4\b/\u0001/"+
		"\u0001/\u0003/\u03b8\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0003/\u03c3\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0003/\u03ce\b/\u0001/\u0001/\u0003/\u03d2\b/\u0001"+
		"0\u00010\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00031\u03e1\b1\u00012\u00012\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u03ef\b3\u00013\u0001"+
		"3\u00013\u00013\u00033\u03f5\b3\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00053\u0408\b3\n3\f3\u040b\t3\u00013\u00013\u00033\u040f\b3"+
		"\u00014\u00014\u00014\u00015\u00015\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0003"+
		"6\u0424\b6\u00017\u00017\u00017\u00017\u00037\u042a\b7\u00018\u00018\u0001"+
		"8\u0000\u0003\u0006\u001eL9\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnp\u0000\t\u0002\u0000\u0015\u001533\u0002\u0000\u001a\u001a"+
		"22\u0002\u000099LL\u0002\u0000^^bb\u0003\u0000\u0015\u0015\u0017\u0017"+
		"\u0086\u0086\u0004\u0000\u001b\u001b!!PQ\u0085\u0085\u0001\u0000\r\u0013"+
		"\u0001\u0000lv\u0013\u0000\u0015\u001a\u001c \"\"$$257<?DFGLORSUY[bdd"+
		"llnnw{}\u0082\u0084\u0084\u0086\u0086\u04bd\u0000s\u0001\u0000\u0000\u0000"+
		"\u0002|\u0001\u0000\u0000\u0000\u0004\u0085\u0001\u0000\u0000\u0000\u0006"+
		"\u008b\u0001\u0000\u0000\u0000\b\u00a5\u0001\u0000\u0000\u0000\n\u00ac"+
		"\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000\u0000\u0000\u000e\u00c7\u0001"+
		"\u0000\u0000\u0000\u0010\u00dc\u0001\u0000\u0000\u0000\u0012\u00de\u0001"+
		"\u0000\u0000\u0000\u0014\u00e2\u0001\u0000\u0000\u0000\u0016\u00eb\u0001"+
		"\u0000\u0000\u0000\u0018\u0118\u0001\u0000\u0000\u0000\u001a\u011b\u0001"+
		"\u0000\u0000\u0000\u001c\u0121\u0001\u0000\u0000\u0000\u001e\u012c\u0001"+
		"\u0000\u0000\u0000 \u014b\u0001\u0000\u0000\u0000\"\u015b\u0001\u0000"+
		"\u0000\u0000$\u015d\u0001\u0000\u0000\u0000&\u0160\u0001\u0000\u0000\u0000"+
		"(\u0193\u0001\u0000\u0000\u0000*\u0195\u0001\u0000\u0000\u0000,\u01a2"+
		"\u0001\u0000\u0000\u0000.\u01a5\u0001\u0000\u0000\u00000\u01a8\u0001\u0000"+
		"\u0000\u00002\u01b1\u0001\u0000\u0000\u00004\u01b5\u0001\u0000\u0000\u0000"+
		"6\u01c4\u0001\u0000\u0000\u00008\u01c6\u0001\u0000\u0000\u0000:\u01d0"+
		"\u0001\u0000\u0000\u0000<\u01da\u0001\u0000\u0000\u0000>\u01e2\u0001\u0000"+
		"\u0000\u0000@\u01e5\u0001\u0000\u0000\u0000B\u01ed\u0001\u0000\u0000\u0000"+
		"D\u01fb\u0001\u0000\u0000\u0000F\u0209\u0001\u0000\u0000\u0000H\u020b"+
		"\u0001\u0000\u0000\u0000J\u020e\u0001\u0000\u0000\u0000L\u0230\u0001\u0000"+
		"\u0000\u0000N\u028d\u0001\u0000\u0000\u0000P\u0291\u0001\u0000\u0000\u0000"+
		"R\u0293\u0001\u0000\u0000\u0000T\u02a4\u0001\u0000\u0000\u0000V\u02c2"+
		"\u0001\u0000\u0000\u0000X\u02e9\u0001\u0000\u0000\u0000Z\u0308\u0001\u0000"+
		"\u0000\u0000\\\u030a\u0001\u0000\u0000\u0000^\u03d1\u0001\u0000\u0000"+
		"\u0000`\u03d3\u0001\u0000\u0000\u0000b\u03e0\u0001\u0000\u0000\u0000d"+
		"\u03e2\u0001\u0000\u0000\u0000f\u040e\u0001\u0000\u0000\u0000h\u0410\u0001"+
		"\u0000\u0000\u0000j\u0413\u0001\u0000\u0000\u0000l\u0423\u0001\u0000\u0000"+
		"\u0000n\u0429\u0001\u0000\u0000\u0000p\u042b\u0001\u0000\u0000\u0000r"+
		"t\u0003\u0002\u0001\u0000sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000uw\u0003\u0006\u0003\u0000vx\u0003:\u001d"+
		"\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000"+
		"\u0000\u0000y{\u0003H$\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\u0001\u0001\u0000\u0000\u0000|}\u0005z\u0000\u0000}\u0082\u0003"+
		"\u0004\u0002\u0000~\u007f\u0005\u0001\u0000\u0000\u007f\u0081\u0003\u0004"+
		"\u0002\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0003\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0003n7\u0000\u0086\u0087\u0005\u0019\u0000\u0000\u0087"+
		"\u0088\u0005\u008a\u0000\u0000\u0088\u0089\u0003\u0006\u0003\u0000\u0089"+
		"\u008a\u0005\u008b\u0000\u0000\u008a\u0005\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0006\u0003\uffff\uffff\u0000\u008c\u008d\u0003\b\u0004\u0000\u008d"+
		"\u00a2\u0001\u0000\u0000\u0000\u008e\u008f\n\u0003\u0000\u0000\u008f\u0091"+
		"\u0005{\u0000\u0000\u0090\u0092\u0007\u0000\u0000\u0000\u0091\u0090\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u00a1\u0003\b\u0004\u0000\u0094\u0095\n\u0002"+
		"\u0000\u0000\u0095\u0097\u00056\u0000\u0000\u0096\u0098\u0007\u0000\u0000"+
		"\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u00a1\u0003\b\u0004\u0000"+
		"\u009a\u009b\n\u0001\u0000\u0000\u009b\u009d\u0005D\u0000\u0000\u009c"+
		"\u009e\u0007\u0000\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0003\b\u0004\u0000\u00a0\u008e\u0001\u0000\u0000\u0000\u00a0\u0094"+
		"\u0001\u0000\u0000\u0000\u00a0\u009a\u0001\u0000\u0000\u0000\u00a1\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u0007\u0001\u0000\u0000\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\n\u0005\u0000\u00a6\t\u0001"+
		"\u0000\u0000\u0000\u00a7\u00ad\u0003\f\u0006\u0000\u00a8\u00a9\u0005\u008a"+
		"\u0000\u0000\u00a9\u00aa\u0003\u0006\u0003\u0000\u00aa\u00ab\u0005\u008b"+
		"\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00a7\u0001\u0000"+
		"\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000\u0000\u00ad\u000b\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b0\u0003\u000e\u0007\u0000\u00af\u00b1\u0003\u0014"+
		"\n\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b4\u0003$\u0012\u0000"+
		"\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003&\u0013\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b8\u00ba\u0003,\u0016\u0000\u00b9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bd\u0003.\u0017\u0000\u00bc\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001"+
		"\u0000\u0000\u0000\u00be\u00c0\u00030\u0018\u0000\u00bf\u00be\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c3\u0003:\u001d\u0000\u00c2\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c6\u0003H$\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\r\u0001\u0000\u0000\u0000\u00c7\u00c9"+
		"\u0005d\u0000\u0000\u00c8\u00ca\u0003J%\u0000\u00c9\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cb\u00d0\u0003\u0010\b\u0000\u00cc\u00cd\u0005\u0001\u0000"+
		"\u0000\u00cd\u00cf\u0003\u0010\b\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u000f\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d8\u0003L&\u0000\u00d4\u00d6"+
		"\u0005\u0019\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9"+
		"\u0003n7\u0000\u00d8\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000"+
		"\u0000\u0000\u00d9\u00dd\u0001\u0000\u0000\u0000\u00da\u00dd\u0005\u0002"+
		"\u0000\u0000\u00db\u00dd\u0003\u0012\t\u0000\u00dc\u00d3\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u0011\u0001\u0000\u0000\u0000\u00de\u00df\u0003d2\u0000\u00df"+
		"\u00e0\u0005\u0003\u0000\u0000\u00e0\u00e1\u0005\u0002\u0000\u0000\u00e1"+
		"\u0013\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005;\u0000\u0000\u00e3\u00e8"+
		"\u0003\u0016\u000b\u0000\u00e4\u00e5\u0005\u0001\u0000\u0000\u00e5\u00e7"+
		"\u0003\u0016\u000b\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00ea"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e9\u0015\u0001\u0000\u0000\u0000\u00ea\u00e8"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003\u001e\u000f\u0000\u00ec\u0017"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ef\u0003d2\u0000\u00ee\u00f0\u0003\u001a"+
		"\r\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f0\u0119\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003d2\u0000\u00f2"+
		"\u00f3\u0005\u0003\u0000\u0000\u00f3\u00f5\u0003d2\u0000\u00f4\u00f6\u0003"+
		"\u001a\r\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f6\u0119\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u008a"+
		"\u0000\u0000\u00f8\u00f9\u0003\u0006\u0003\u0000\u00f9\u00fb\u0005\u008b"+
		"\u0000\u0000\u00fa\u00fc\u0003\u001a\r\u0000\u00fb\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0119\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0005\u008a\u0000\u0000\u00fe\u00ff\u0003\u0016\u000b"+
		"\u0000\u00ff\u0101\u0005\u008b\u0000\u0000\u0100\u0102\u0003\u001a\r\u0000"+
		"\u0101\u0100\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0119\u0001\u0000\u0000\u0000\u0103\u0104\u0005|\u0000\u0000\u0104"+
		"\u0105\u0005\u008a\u0000\u0000\u0105\u0106\u0003L&\u0000\u0106\u0108\u0005"+
		"\u008b\u0000\u0000\u0107\u0109\u0003\u001a\r\u0000\u0108\u0107\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u0112\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0005z\u0000\u0000\u010b\u0110\u0005T\u0000\u0000"+
		"\u010c\u010e\u0005\u0019\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000"+
		"\u010f\u0111\u0003n7\u0000\u0110\u010d\u0001\u0000\u0000\u0000\u0110\u0111"+
		"\u0001\u0000\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u010a"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0119"+
		"\u0001\u0000\u0000\u0000\u0114\u0116\u0003^/\u0000\u0115\u0117\u0003\u001a"+
		"\r\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000"+
		"\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u00ed\u0001\u0000\u0000"+
		"\u0000\u0118\u00f1\u0001\u0000\u0000\u0000\u0118\u00f7\u0001\u0000\u0000"+
		"\u0000\u0118\u00fd\u0001\u0000\u0000\u0000\u0118\u0103\u0001\u0000\u0000"+
		"\u0000\u0118\u0114\u0001\u0000\u0000\u0000\u0119\u0019\u0001\u0000\u0000"+
		"\u0000\u011a\u011c\u0005\u0019\u0000\u0000\u011b\u011a\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000"+
		"\u0000\u011d\u011f\u0003n7\u0000\u011e\u0120\u0003\u001c\u000e\u0000\u011f"+
		"\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u001b\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u008a\u0000\u0000\u0122"+
		"\u0127\u0003n7\u0000\u0123\u0124\u0005\u0001\u0000\u0000\u0124\u0126\u0003"+
		"n7\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000"+
		"\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000"+
		"\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0005\u008b\u0000\u0000\u012b\u001d\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\u0006\u000f\uffff\uffff\u0000\u012d\u012e\u0003\u0018"+
		"\f\u0000\u012e\u013a\u0001\u0000\u0000\u0000\u012f\u0131\n\u0001\u0000"+
		"\u0000\u0130\u0132\u0003 \u0010\u0000\u0131\u0130\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0005G\u0000\u0000\u0134\u0136\u0003\u0016\u000b\u0000\u0135"+
		"\u0137\u0003\"\u0011\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u012f"+
		"\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u001f"+
		"\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u014c"+
		"\u0005C\u0000\u0000\u013e\u014c\u0005\"\u0000\u0000\u013f\u0141\u0005"+
		"<\u0000\u0000\u0140\u0142\u0005X\u0000\u0000\u0141\u0140\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u014c\u0001\u0000\u0000"+
		"\u0000\u0143\u0145\u0005M\u0000\u0000\u0144\u0146\u0005X\u0000\u0000\u0145"+
		"\u0144\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146"+
		"\u014c\u0001\u0000\u0000\u0000\u0147\u0149\u0005_\u0000\u0000\u0148\u014a"+
		"\u0005X\u0000\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u013d\u0001"+
		"\u0000\u0000\u0000\u014b\u013e\u0001\u0000\u0000\u0000\u014b\u013f\u0001"+
		"\u0000\u0000\u0000\u014b\u0143\u0001\u0000\u0000\u0000\u014b\u0147\u0001"+
		"\u0000\u0000\u0000\u014c!\u0001\u0000\u0000\u0000\u014d\u014e\u0005U\u0000"+
		"\u0000\u014e\u015c\u0003L&\u0000\u014f\u0150\u0005}\u0000\u0000\u0150"+
		"\u0151\u0005\u008a\u0000\u0000\u0151\u0156\u0003n7\u0000\u0152\u0153\u0005"+
		"\u0001\u0000\u0000\u0153\u0155\u0003n7\u0000\u0154\u0152\u0001\u0000\u0000"+
		"\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0001\u0000\u0000"+
		"\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u015a\u0005\u008b\u0000"+
		"\u0000\u015a\u015c\u0001\u0000\u0000\u0000\u015b\u014d\u0001\u0000\u0000"+
		"\u0000\u015b\u014f\u0001\u0000\u0000\u0000\u015c#\u0001\u0000\u0000\u0000"+
		"\u015d\u015e\u0005~\u0000\u0000\u015e\u015f\u0003L&\u0000\u015f%\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0005?\u0000\u0000\u0161\u0163\u0005\u001d"+
		"\u0000\u0000\u0162\u0164\u0003J%\u0000\u0163\u0162\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000"+
		"\u0165\u016a\u0003(\u0014\u0000\u0166\u0167\u0005\u0001\u0000\u0000\u0167"+
		"\u0169\u0003(\u0014\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016c"+
		"\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016a\u016b"+
		"\u0001\u0000\u0000\u0000\u016b\'\u0001\u0000\u0000\u0000\u016c\u016a\u0001"+
		"\u0000\u0000\u0000\u016d\u0194\u0003L&\u0000\u016e\u016f\u0005`\u0000"+
		"\u0000\u016f\u0170\u0005\u008a\u0000\u0000\u0170\u0175\u0003L&\u0000\u0171"+
		"\u0172\u0005\u0001\u0000\u0000\u0172\u0174\u0003L&\u0000\u0173\u0171\u0001"+
		"\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000\u0000\u0175\u0173\u0001"+
		"\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0001"+
		"\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0178\u0179\u0005"+
		"\u008b\u0000\u0000\u0179\u0194\u0001\u0000\u0000\u0000\u017a\u017b\u0005"+
		"#\u0000\u0000\u017b\u017c\u0005\u008a\u0000\u0000\u017c\u0181\u0003L&"+
		"\u0000\u017d\u017e\u0005\u0001\u0000\u0000\u017e\u0180\u0003L&\u0000\u017f"+
		"\u017d\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181"+
		"\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182"+
		"\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0005\u008b\u0000\u0000\u0185\u0194\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0005@\u0000\u0000\u0187\u0188\u0005\u007f\u0000\u0000\u0188\u0189"+
		"\u0005\u008a\u0000\u0000\u0189\u018e\u0003*\u0015\u0000\u018a\u018b\u0005"+
		"\u0001\u0000\u0000\u018b\u018d\u0003*\u0015\u0000\u018c\u018a\u0001\u0000"+
		"\u0000\u0000\u018d\u0190\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000"+
		"\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u0191\u0001\u0000"+
		"\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0191\u0192\u0005\u008b"+
		"\u0000\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u016d\u0001\u0000"+
		"\u0000\u0000\u0193\u016e\u0001\u0000\u0000\u0000\u0193\u017a\u0001\u0000"+
		"\u0000\u0000\u0193\u0186\u0001\u0000\u0000\u0000\u0194)\u0001\u0000\u0000"+
		"\u0000\u0195\u019e\u0005\u008a\u0000\u0000\u0196\u019b\u0003L&\u0000\u0197"+
		"\u0198\u0005\u0001\u0000\u0000\u0198\u019a\u0003L&\u0000\u0199\u0197\u0001"+
		"\u0000\u0000\u0000\u019a\u019d\u0001\u0000\u0000\u0000\u019b\u0199\u0001"+
		"\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019f\u0001"+
		"\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019e\u0196\u0001"+
		"\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u0005\u008b\u0000\u0000\u01a1+\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u0005A\u0000\u0000\u01a3\u01a4\u0003L&\u0000"+
		"\u01a4-\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005]\u0000\u0000\u01a6\u01a7"+
		"\u0003L&\u0000\u01a7/\u0001\u0000\u0000\u0000\u01a8\u01a9\u0005\u0080"+
		"\u0000\u0000\u01a9\u01ae\u00032\u0019\u0000\u01aa\u01ab\u0005\u0001\u0000"+
		"\u0000\u01ab\u01ad\u00032\u0019\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000"+
		"\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ae\u01af\u0001\u0000\u0000\u0000\u01af1\u0001\u0000\u0000\u0000\u01b0"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b2\u0003n7\u0000\u01b2\u01b3\u0005"+
		"\u0019\u0000\u0000\u01b3\u01b4\u00034\u001a\u0000\u01b43\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b7\u0005\u008a\u0000\u0000\u01b6\u01b8\u00036\u001b\u0000"+
		"\u01b7\u01b6\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b8\u01ba\u0001\u0000\u0000\u0000\u01b9\u01bb\u00038\u001c\u0000\u01ba"+
		"\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb"+
		"\u01bd\u0001\u0000\u0000\u0000\u01bc\u01be\u0003:\u001d\u0000\u01bd\u01bc"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01c0"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c1\u0003>\u001f\u0000\u01c0\u01bf\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c3\u0005\u008b\u0000\u0000\u01c35\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c5\u0003n7\u0000\u01c57\u0001\u0000\u0000\u0000"+
		"\u01c6\u01c7\u0005[\u0000\u0000\u01c7\u01c8\u0005\u001d\u0000\u0000\u01c8"+
		"\u01cd\u0003L&\u0000\u01c9\u01ca\u0005\u0001\u0000\u0000\u01ca\u01cc\u0003"+
		"L&\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000"+
		"\u0000\u01cd\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000"+
		"\u0000\u01ce9\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000"+
		"\u01d0\u01d1\u0005W\u0000\u0000\u01d1\u01d2\u0005\u001d\u0000\u0000\u01d2"+
		"\u01d7\u0003<\u001e\u0000\u01d3\u01d4\u0005\u0001\u0000\u0000\u01d4\u01d6"+
		"\u0003<\u001e\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d6\u01d9\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001"+
		"\u0000\u0000\u0000\u01d8;\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000"+
		"\u0000\u0000\u01da\u01dc\u0003L&\u0000\u01db\u01dd\u0007\u0001\u0000\u0000"+
		"\u01dc\u01db\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000"+
		"\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de\u01df\u0005S\u0000\u0000\u01df"+
		"\u01e1\u0007\u0002\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e1=\u0001\u0000\u0000\u0000\u01e2\u01e3"+
		"\u0003@ \u0000\u01e3\u01e4\u0003B!\u0000\u01e4?\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e6\u0007\u0003\u0000\u0000\u01e6A\u0001\u0000\u0000\u0000\u01e7"+
		"\u01ee\u0003D\"\u0000\u01e8\u01e9\u0005\u001c\u0000\u0000\u01e9\u01ea"+
		"\u0003D\"\u0000\u01ea\u01eb\u0005\u0016\u0000\u0000\u01eb\u01ec\u0003"+
		"F#\u0000\u01ec\u01ee\u0001\u0000\u0000\u0000\u01ed\u01e7\u0001\u0000\u0000"+
		"\u0000\u01ed\u01e8\u0001\u0000\u0000\u0000\u01eeC\u0001\u0000\u0000\u0000"+
		"\u01ef\u01f0\u0005\u0081\u0000\u0000\u01f0\u01fc\u0005\\\u0000\u0000\u01f1"+
		"\u01f2\u0003L&\u0000\u01f2\u01f3\u0005\\\u0000\u0000\u01f3\u01fc\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0005$\u0000\u0000\u01f5\u01fc\u0005a\u0000"+
		"\u0000\u01f6\u01f7\u0003L&\u0000\u01f7\u01f8\u0005:\u0000\u0000\u01f8"+
		"\u01fc\u0001\u0000\u0000\u0000\u01f9\u01fa\u0005\u0081\u0000\u0000\u01fa"+
		"\u01fc\u0005:\u0000\u0000\u01fb\u01ef\u0001\u0000\u0000\u0000\u01fb\u01f1"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f4\u0001\u0000\u0000\u0000\u01fb\u01f6"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fcE\u0001"+
		"\u0000\u0000\u0000\u01fd\u01fe\u0005\u0081\u0000\u0000\u01fe\u020a\u0005"+
		"\\\u0000\u0000\u01ff\u0200\u0003L&\u0000\u0200\u0201\u0005\\\u0000\u0000"+
		"\u0201\u020a\u0001\u0000\u0000\u0000\u0202\u0203\u0005$\u0000\u0000\u0203"+
		"\u020a\u0005a\u0000\u0000\u0204\u0205\u0003L&\u0000\u0205\u0206\u0005"+
		":\u0000\u0000\u0206\u020a\u0001\u0000\u0000\u0000\u0207\u0208\u0005\u0081"+
		"\u0000\u0000\u0208\u020a\u0005:\u0000\u0000\u0209\u01fd\u0001\u0000\u0000"+
		"\u0000\u0209\u01ff\u0001\u0000\u0000\u0000\u0209\u0202\u0001\u0000\u0000"+
		"\u0000\u0209\u0204\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000"+
		"\u0000\u020aG\u0001\u0000\u0000\u0000\u020b\u020c\u0005O\u0000\u0000\u020c"+
		"\u020d\u0003L&\u0000\u020dI\u0001\u0000\u0000\u0000\u020e\u020f\u0007"+
		"\u0000\u0000\u0000\u020fK\u0001\u0000\u0000\u0000\u0210\u0211\u0006&\uffff"+
		"\uffff\u0000\u0211\u0231\u0003l6\u0000\u0212\u0231\u0003b1\u0000\u0213"+
		"\u0231\u0003V+\u0000\u0214\u0231\u0003^/\u0000\u0215\u0231\u0003P(\u0000"+
		"\u0216\u0231\u0003X,\u0000\u0217\u0231\u0003Z-\u0000\u0218\u0219\u0005"+
		"7\u0000\u0000\u0219\u021a\u0005\u008a\u0000\u0000\u021a\u021b\u0003\u0006"+
		"\u0003\u0000\u021b\u021c\u0005\u008b\u0000\u0000\u021c\u0231\u0001\u0000"+
		"\u0000\u0000\u021d\u021e\u0007\u0004\u0000\u0000\u021e\u021f\u0005\u008a"+
		"\u0000\u0000\u021f\u0220\u0003\u0006\u0003\u0000\u0220\u0221\u0005\u008b"+
		"\u0000\u0000\u0221\u0231\u0001\u0000\u0000\u0000\u0222\u0223\u0005\u008a"+
		"\u0000\u0000\u0223\u0224\u0003\u0006\u0003\u0000\u0224\u0225\u0005\u008b"+
		"\u0000\u0000\u0225\u0231\u0001\u0000\u0000\u0000\u0226\u0227\u0005\u008a"+
		"\u0000\u0000\u0227\u0228\u0003L&\u0000\u0228\u0229\u0005\u008b\u0000\u0000"+
		"\u0229\u0231\u0001\u0000\u0000\u0000\u022a\u022b\u0005R\u0000\u0000\u022b"+
		"\u0231\u0003L&\u0011\u022c\u022d\u0005\u0006\u0000\u0000\u022d\u0231\u0003"+
		"L&\u0003\u022e\u022f\u0005\u0005\u0000\u0000\u022f\u0231\u0003L&\u0002"+
		"\u0230\u0210\u0001\u0000\u0000\u0000\u0230\u0212\u0001\u0000\u0000\u0000"+
		"\u0230\u0213\u0001\u0000\u0000\u0000\u0230\u0214\u0001\u0000\u0000\u0000"+
		"\u0230\u0215\u0001\u0000\u0000\u0000\u0230\u0216\u0001\u0000\u0000\u0000"+
		"\u0230\u0217\u0001\u0000\u0000\u0000\u0230\u0218\u0001\u0000\u0000\u0000"+
		"\u0230\u021d\u0001\u0000\u0000\u0000\u0230\u0222\u0001\u0000\u0000\u0000"+
		"\u0230\u0226\u0001\u0000\u0000\u0000\u0230\u022a\u0001\u0000\u0000\u0000"+
		"\u0230\u022c\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000"+
		"\u0231\u0275\u0001\u0000\u0000\u0000\u0232\u0233\n\u0010\u0000\u0000\u0233"+
		"\u0234\u0003`0\u0000\u0234\u0235\u0003L&\u0011\u0235\u0274\u0001\u0000"+
		"\u0000\u0000\u0236\u0237\n\u000f\u0000\u0000\u0237\u0238\u0005\u0016\u0000"+
		"\u0000\u0238\u0274\u0003L&\u0010\u0239\u023a\n\u000e\u0000\u0000\u023a"+
		"\u023b\u0005V\u0000\u0000\u023b\u0274\u0003L&\u000f\u023c\u023d\n\r\u0000"+
		"\u0000\u023d\u023e\u0005N\u0000\u0000\u023e\u0274\u0003L&\u000e\u023f"+
		"\u0240\n\t\u0000\u0000\u0240\u0241\u0005\u0004\u0000\u0000\u0241\u0274"+
		"\u0003L&\n\u0242\u0243\n\b\u0000\u0000\u0243\u0244\u0005\u0005\u0000\u0000"+
		"\u0244\u0274\u0003L&\t\u0245\u0246\n\u0007\u0000\u0000\u0246\u0247\u0005"+
		"\u0006\u0000\u0000\u0247\u0274\u0003L&\b\u0248\u0249\n\u0006\u0000\u0000"+
		"\u0249\u024a\u0005\u0002\u0000\u0000\u024a\u0274\u0003L&\u0007\u024b\u024c"+
		"\n\u0005\u0000\u0000\u024c\u024d\u0005\u0007\u0000\u0000\u024d\u0274\u0003"+
		"L&\u0006\u024e\u024f\n\u0004\u0000\u0000\u024f\u0250\u0005\b\u0000\u0000"+
		"\u0250\u0274\u0003L&\u0005\u0251\u0252\n\u0001\u0000\u0000\u0252\u0253"+
		"\u0005\t\u0000\u0000\u0253\u0254\u0003L&\u0000\u0254\u0255\u0005\n\u0000"+
		"\u0000\u0255\u0256\u0003L&\u0002\u0256\u0274\u0001\u0000\u0000\u0000\u0257"+
		"\u0258\n\u0015\u0000\u0000\u0258\u0259\u0003`0\u0000\u0259\u025a\u0007"+
		"\u0004\u0000\u0000\u025a\u025b\u0005\u008a\u0000\u0000\u025b\u025c\u0003"+
		"\u0006\u0003\u0000\u025c\u025d\u0005\u008b\u0000\u0000\u025d\u0274\u0001"+
		"\u0000\u0000\u0000\u025e\u025f\n\u0012\u0000\u0000\u025f\u0261\u0005F"+
		"\u0000\u0000\u0260\u0262\u0005R\u0000\u0000\u0261\u0260\u0001\u0000\u0000"+
		"\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000"+
		"\u0000\u0263\u0274\u0005y\u0000\u0000\u0264\u0265\n\f\u0000\u0000\u0265"+
		"\u0266\u0005\u001c\u0000\u0000\u0266\u0267\u0003L&\u0000\u0267\u0268\u0005"+
		"\u0016\u0000\u0000\u0268\u0269\u0003L&\u0000\u0269\u0274\u0001\u0000\u0000"+
		"\u0000\u026a\u026c\n\u000b\u0000\u0000\u026b\u026d\u0005R\u0000\u0000"+
		"\u026c\u026b\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000\u0000\u0000"+
		"\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f\u0005B\u0000\u0000\u026f"+
		"\u0274\u0003N\'\u0000\u0270\u0271\n\n\u0000\u0000\u0271\u0272\u0005 \u0000"+
		"\u0000\u0272\u0274\u0003n7\u0000\u0273\u0232\u0001\u0000\u0000\u0000\u0273"+
		"\u0236\u0001\u0000\u0000\u0000\u0273\u0239\u0001\u0000\u0000\u0000\u0273"+
		"\u023c\u0001\u0000\u0000\u0000\u0273\u023f\u0001\u0000\u0000\u0000\u0273"+
		"\u0242\u0001\u0000\u0000\u0000\u0273\u0245\u0001\u0000\u0000\u0000\u0273"+
		"\u0248\u0001\u0000\u0000\u0000\u0273\u024b\u0001\u0000\u0000\u0000\u0273"+
		"\u024e\u0001\u0000\u0000\u0000\u0273\u0251\u0001\u0000\u0000\u0000\u0273"+
		"\u0257\u0001\u0000\u0000\u0000\u0273\u025e\u0001\u0000\u0000\u0000\u0273"+
		"\u0264\u0001\u0000\u0000\u0000\u0273\u026a\u0001\u0000\u0000\u0000\u0273"+
		"\u0270\u0001\u0000\u0000\u0000\u0274\u0277\u0001\u0000\u0000\u0000\u0275"+
		"\u0273\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000\u0000\u0000\u0276"+
		"M\u0001\u0000\u0000\u0000\u0277\u0275\u0001\u0000\u0000\u0000\u0278\u0281"+
		"\u0005\u008a\u0000\u0000\u0279\u027e\u0003L&\u0000\u027a\u027b\u0005\u0001"+
		"\u0000\u0000\u027b\u027d\u0003L&\u0000\u027c\u027a\u0001\u0000\u0000\u0000"+
		"\u027d\u0280\u0001\u0000\u0000\u0000\u027e\u027c\u0001\u0000\u0000\u0000"+
		"\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0282\u0001\u0000\u0000\u0000"+
		"\u0280\u027e\u0001\u0000\u0000\u0000\u0281\u0279\u0001\u0000\u0000\u0000"+
		"\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000"+
		"\u0283\u028e\u0005\u008b\u0000\u0000\u0284\u0285\u0005\u008a\u0000\u0000"+
		"\u0285\u0286\u0003\u0006\u0003\u0000\u0286\u0287\u0005\u008b\u0000\u0000"+
		"\u0287\u028e\u0001\u0000\u0000\u0000\u0288\u0289\u0005|\u0000\u0000\u0289"+
		"\u028a\u0005\u008a\u0000\u0000\u028a\u028b\u0003L&\u0000\u028b\u028c\u0005"+
		"\u008b\u0000\u0000\u028c\u028e\u0001\u0000\u0000\u0000\u028d\u0278\u0001"+
		"\u0000\u0000\u0000\u028d\u0284\u0001\u0000\u0000\u0000\u028d\u0288\u0001"+
		"\u0000\u0000\u0000\u028eO\u0001\u0000\u0000\u0000\u028f\u0292\u0003R)"+
		"\u0000\u0290\u0292\u0003T*\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0291"+
		"\u0290\u0001\u0000\u0000\u0000\u0292Q\u0001\u0000\u0000\u0000\u0293\u0294"+
		"\u0005\u001e\u0000\u0000\u0294\u029a\u0003L&\u0000\u0295\u0296\u0005\u0082"+
		"\u0000\u0000\u0296\u0297\u0003L&\u0000\u0297\u0298\u0005\u0083\u0000\u0000"+
		"\u0298\u0299\u0003L&\u0000\u0299\u029b\u0001\u0000\u0000\u0000\u029a\u0295"+
		"\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000\u0000\u029c\u029a"+
		"\u0001\u0000\u0000\u0000\u029c\u029d\u0001\u0000\u0000\u0000\u029d\u02a0"+
		"\u0001\u0000\u0000\u0000\u029e\u029f\u00054\u0000\u0000\u029f\u02a1\u0003"+
		"L&\u0000\u02a0\u029e\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000"+
		"\u0000\u02a1\u02a2\u0001\u0000\u0000\u0000\u02a2\u02a3\u00055\u0000\u0000"+
		"\u02a3S\u0001\u0000\u0000\u0000\u02a4\u02aa\u0005\u001e\u0000\u0000\u02a5"+
		"\u02a6\u0005\u0082\u0000\u0000\u02a6\u02a7\u0003L&\u0000\u02a7\u02a8\u0005"+
		"\u0083\u0000\u0000\u02a8\u02a9\u0003L&\u0000\u02a9\u02ab\u0001\u0000\u0000"+
		"\u0000\u02aa\u02a5\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000\u0000"+
		"\u0000\u02ac\u02aa\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000"+
		"\u0000\u02ad\u02b0\u0001\u0000\u0000\u0000\u02ae\u02af\u00054\u0000\u0000"+
		"\u02af\u02b1\u0003L&\u0000\u02b0\u02ae\u0001\u0000\u0000\u0000\u02b0\u02b1"+
		"\u0001\u0000\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2\u02b3"+
		"\u00055\u0000\u0000\u02b3U\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005\u001f"+
		"\u0000\u0000\u02b5\u02b6\u0005\u008a\u0000\u0000\u02b6\u02b7\u0003L&\u0000"+
		"\u02b7\u02b8\u0005\u0019\u0000\u0000\u02b8\u02b9\u0003f3\u0000\u02b9\u02ba"+
		"\u0005\u008b\u0000\u0000\u02ba\u02c3\u0001\u0000\u0000\u0000\u02bb\u02bc"+
		"\u0005c\u0000\u0000\u02bc\u02bd\u0005\u008a\u0000\u0000\u02bd\u02be\u0003"+
		"L&\u0000\u02be\u02bf\u0005\u0019\u0000\u0000\u02bf\u02c0\u0003f3\u0000"+
		"\u02c0\u02c1\u0005\u008b\u0000\u0000\u02c1\u02c3\u0001\u0000\u0000\u0000"+
		"\u02c2\u02b4\u0001\u0000\u0000\u0000\u02c2\u02bb\u0001\u0000\u0000\u0000"+
		"\u02c3W\u0001\u0000\u0000\u0000\u02c4\u02cd\u0005\u000b\u0000\u0000\u02c5"+
		"\u02ca\u0003L&\u0000\u02c6\u02c7\u0005\u0001\u0000\u0000\u02c7\u02c9\u0003"+
		"L&\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000\u02c9\u02cc\u0001\u0000\u0000"+
		"\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000"+
		"\u0000\u02cb\u02ce\u0001\u0000\u0000\u0000\u02cc\u02ca\u0001\u0000\u0000"+
		"\u0000\u02cd\u02c5\u0001\u0000\u0000\u0000\u02cd\u02ce\u0001\u0000\u0000"+
		"\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf\u02ea\u0005\f\u0000\u0000"+
		"\u02d0\u02d1\u0005\u0018\u0000\u0000\u02d1\u02d2\u0005\r\u0000\u0000\u02d2"+
		"\u02d3\u0003f3\u0000\u02d3\u02d4\u0005\u000e\u0000\u0000\u02d4\u02dd\u0005"+
		"\u000b\u0000\u0000\u02d5\u02da\u0003L&\u0000\u02d6\u02d7\u0005\u0001\u0000"+
		"\u0000\u02d7\u02d9\u0003L&\u0000\u02d8\u02d6\u0001\u0000\u0000\u0000\u02d9"+
		"\u02dc\u0001\u0000\u0000\u0000\u02da\u02d8\u0001\u0000\u0000\u0000\u02da"+
		"\u02db\u0001\u0000\u0000\u0000\u02db\u02de\u0001\u0000\u0000\u0000\u02dc"+
		"\u02da\u0001\u0000\u0000\u0000\u02dd\u02d5\u0001\u0000\u0000\u0000\u02dd"+
		"\u02de\u0001\u0000\u0000\u0000\u02de\u02df\u0001\u0000\u0000\u0000\u02df"+
		"\u02e0\u0005\f\u0000\u0000\u02e0\u02ea\u0001\u0000\u0000\u0000\u02e1\u02e2"+
		"\u0005\u0018\u0000\u0000\u02e2\u02e3\u0005d\u0000\u0000\u02e3\u02e4\u0003"+
		"\u0010\b\u0000\u02e4\u02e5\u0005;\u0000\u0000\u02e5\u02e7\u0003\u0016"+
		"\u000b\u0000\u02e6\u02e8\u0003$\u0012\u0000\u02e7\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000\u02e8\u02ea\u0001\u0000\u0000"+
		"\u0000\u02e9\u02c4\u0001\u0000\u0000\u0000\u02e9\u02d0\u0001\u0000\u0000"+
		"\u0000\u02e9\u02e1\u0001\u0000\u0000\u0000\u02eaY\u0001\u0000\u0000\u0000"+
		"\u02eb\u02f7\u0005\u0084\u0000\u0000\u02ec\u02ed\u0005\u008a\u0000\u0000"+
		"\u02ed\u02f2\u0003\\.\u0000\u02ee\u02ef\u0005\u0001\u0000\u0000\u02ef"+
		"\u02f1\u0003\\.\u0000\u02f0\u02ee\u0001\u0000\u0000\u0000\u02f1\u02f4"+
		"\u0001\u0000\u0000\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000\u02f2\u02f3"+
		"\u0001\u0000\u0000\u0000\u02f3\u02f5\u0001\u0000\u0000\u0000\u02f4\u02f2"+
		"\u0001\u0000\u0000\u0000\u02f5\u02f6\u0005\u008b\u0000\u0000\u02f6\u02f8"+
		"\u0001\u0000\u0000\u0000\u02f7\u02ec\u0001\u0000\u0000\u0000\u02f7\u02f8"+
		"\u0001\u0000\u0000\u0000\u02f8\u0309\u0001\u0000\u0000\u0000\u02f9\u02fa"+
		"\u0005\u0084\u0000\u0000\u02fa\u02fb\u0005\r\u0000\u0000\u02fb\u02fc\u0003"+
		"n7\u0000\u02fc\u0303\u0003f3\u0000\u02fd\u02fe\u0005\u0001\u0000\u0000"+
		"\u02fe\u02ff\u0003n7\u0000\u02ff\u0300\u0003f3\u0000\u0300\u0302\u0001"+
		"\u0000\u0000\u0000\u0301\u02fd\u0001\u0000\u0000\u0000\u0302\u0305\u0001"+
		"\u0000\u0000\u0000\u0303\u0301\u0001\u0000\u0000\u0000\u0303\u0304\u0001"+
		"\u0000\u0000\u0000\u0304\u0306\u0001\u0000\u0000\u0000\u0305\u0303\u0001"+
		"\u0000\u0000\u0000\u0306\u0307\u0005\u000e\u0000\u0000\u0307\u0309\u0001"+
		"\u0000\u0000\u0000\u0308\u02eb\u0001\u0000\u0000\u0000\u0308\u02f9\u0001"+
		"\u0000\u0000\u0000\u0309[\u0001\u0000\u0000\u0000\u030a\u030d\u0003L&"+
		"\u0000\u030b\u030c\u0005\u0019\u0000\u0000\u030c\u030e\u0003n7\u0000\u030d"+
		"\u030b\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e"+
		"]\u0001\u0000\u0000\u0000\u030f\u0310\u0007\u0005\u0000\u0000\u0310\u0312"+
		"\u0005\u008a\u0000\u0000\u0311\u0313\u0007\u0000\u0000\u0000\u0312\u0311"+
		"\u0001\u0000\u0000\u0000\u0312\u0313\u0001\u0000\u0000\u0000\u0313\u0316"+
		"\u0001\u0000\u0000\u0000\u0314\u0317\u0003L&\u0000\u0315\u0317\u0005\u0002"+
		"\u0000\u0000\u0316\u0314\u0001\u0000\u0000\u0000\u0316\u0315\u0001\u0000"+
		"\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u03d2\u0005\u008b"+
		"\u0000\u0000\u0319\u031a\u0003n7\u0000\u031a\u031c\u0005\u008a\u0000\u0000"+
		"\u031b\u031d\u0007\u0000\u0000\u0000\u031c\u031b\u0001\u0000\u0000\u0000"+
		"\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u0326\u0001\u0000\u0000\u0000"+
		"\u031e\u0323\u0003L&\u0000\u031f\u0320\u0005\u0001\u0000\u0000\u0320\u0322"+
		"\u0003L&\u0000\u0321\u031f\u0001\u0000\u0000\u0000\u0322\u0325\u0001\u0000"+
		"\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000\u0323\u0324\u0001\u0000"+
		"\u0000\u0000\u0324\u0327\u0001\u0000\u0000\u0000\u0325\u0323\u0001\u0000"+
		"\u0000\u0000\u0326\u031e\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000"+
		"\u0000\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328\u032b\u0005\u008b"+
		"\u0000\u0000\u0329\u032a\u0005Y\u0000\u0000\u032a\u032c\u00034\u001a\u0000"+
		"\u032b\u0329\u0001\u0000\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000"+
		"\u032c\u03d2\u0001\u0000\u0000\u0000\u032d\u032e\u0003n7\u0000\u032e\u032f"+
		"\u0005\u008a\u0000\u0000\u032f\u0330\u0005\u0002\u0000\u0000\u0330\u0331"+
		"\u0005\u008b\u0000\u0000\u0331\u03d2\u0001\u0000\u0000\u0000\u0332\u0333"+
		"\u00058\u0000\u0000\u0333\u0334\u0005\u008a\u0000\u0000\u0334\u0335\u0003"+
		"n7\u0000\u0335\u0336\u0005;\u0000\u0000\u0336\u0337\u0003L&\u0000\u0337"+
		"\u0338\u0005\u008b\u0000\u0000\u0338\u03d2\u0001\u0000\u0000\u0000\u0339"+
		"\u033a\u0005&\u0000\u0000\u033a\u033b\u0005\u008a\u0000\u0000\u033b\u033c"+
		"\u0003L&\u0000\u033c\u033d\u0005\u0001\u0000\u0000\u033d\u033e\u0005E"+
		"\u0000\u0000\u033e\u033f\u0003L&\u0000\u033f\u0340\u0003j5\u0000\u0340"+
		"\u0341\u0005\u008b\u0000\u0000\u0341\u03d2\u0001\u0000\u0000\u0000\u0342"+
		"\u0343\u0005(\u0000\u0000\u0343\u0344\u0005\u008a\u0000\u0000\u0344\u0345"+
		"\u0003L&\u0000\u0345\u0346\u0005\u0001\u0000\u0000\u0346\u0347\u0005E"+
		"\u0000\u0000\u0347\u0348\u0003L&\u0000\u0348\u0349\u0003j5\u0000\u0349"+
		"\u034a\u0005\u008b\u0000\u0000\u034a\u03d2\u0001\u0000\u0000\u0000\u034b"+
		"\u034c\u0005\'\u0000\u0000\u034c\u034d\u0005\u008a\u0000\u0000\u034d\u034e"+
		"\u0003L&\u0000\u034e\u034f\u0005\u0001\u0000\u0000\u034f\u0350\u0003L"+
		"&\u0000\u0350\u0351\u0005\u0001\u0000\u0000\u0351\u0352\u0003j5\u0000"+
		"\u0352\u0353\u0005\u008b\u0000\u0000\u0353\u03d2\u0001\u0000\u0000\u0000"+
		"\u0354\u0355\u0005+\u0000\u0000\u0355\u0356\u0005\u008a\u0000\u0000\u0356"+
		"\u0357\u0003L&\u0000\u0357\u0358\u0005\u0001\u0000\u0000\u0358\u0359\u0005"+
		"E\u0000\u0000\u0359\u035a\u0003L&\u0000\u035a\u035b\u0003j5\u0000\u035b"+
		"\u035c\u0005\u008b\u0000\u0000\u035c\u03d2\u0001\u0000\u0000\u0000\u035d"+
		"\u035e\u0005,\u0000\u0000\u035e\u035f\u0005\u008a\u0000\u0000\u035f\u0360"+
		"\u0003L&\u0000\u0360\u0361\u0005\u0001\u0000\u0000\u0361\u0362\u0005E"+
		"\u0000\u0000\u0362\u0363\u0003L&\u0000\u0363\u0364\u0003j5\u0000\u0364"+
		"\u0365\u0005\u008b\u0000\u0000\u0365\u03d2\u0001\u0000\u0000\u0000\u0366"+
		"\u0367\u0005-\u0000\u0000\u0367\u0368\u0005\u008a\u0000\u0000\u0368\u0369"+
		"\u0003L&\u0000\u0369\u036a\u0005\u0001\u0000\u0000\u036a\u036b\u0003L"+
		"&\u0000\u036b\u036c\u0005\u0001\u0000\u0000\u036c\u036d\u0003j5\u0000"+
		"\u036d\u036e\u0005\u008b\u0000\u0000\u036e\u03d2\u0001\u0000\u0000\u0000"+
		"\u036f\u0370\u0005)\u0000\u0000\u0370\u0371\u0005\u008a\u0000\u0000\u0371"+
		"\u0372\u0003L&\u0000\u0372\u0373\u0005\u0001\u0000\u0000\u0373\u0374\u0003"+
		"j5\u0000\u0374\u0375\u0005\u008b\u0000\u0000\u0375\u03d2\u0001\u0000\u0000"+
		"\u0000\u0376\u0377\u0005.\u0000\u0000\u0377\u0378\u0005\u008a\u0000\u0000"+
		"\u0378\u0379\u0003L&\u0000\u0379\u037a\u0005\u0001\u0000\u0000\u037a\u037b"+
		"\u0003j5\u0000\u037b\u037c\u0005\u008b\u0000\u0000\u037c\u03d2\u0001\u0000"+
		"\u0000\u0000\u037d\u037e\u0005H\u0000\u0000\u037e\u037f\u0005\u008a\u0000"+
		"\u0000\u037f\u0380\u0003L&\u0000\u0380\u0381\u0005\u0001\u0000\u0000\u0381"+
		"\u0382\u0003L&\u0000\u0382\u0383\u0005\u008b\u0000\u0000\u0383\u03d2\u0001"+
		"\u0000\u0000\u0000\u0384\u0385\u0005I\u0000\u0000\u0385\u0386\u0005\u008a"+
		"\u0000\u0000\u0386\u0387\u0003L&\u0000\u0387\u0388\u0005\u0001\u0000\u0000"+
		"\u0388\u0389\u0003L&\u0000\u0389\u038a\u0005\u008b\u0000\u0000\u038a\u03d2"+
		"\u0001\u0000\u0000\u0000\u038b\u038c\u0005J\u0000\u0000\u038c\u038d\u0005"+
		"\u008a\u0000\u0000\u038d\u038e\u0003L&\u0000\u038e\u038f\u0005\u0001\u0000"+
		"\u0000\u038f\u0390\u0003L&\u0000\u0390\u0391\u0005\u008b\u0000\u0000\u0391"+
		"\u03d2\u0001\u0000\u0000\u0000\u0392\u0393\u0005K\u0000\u0000\u0393\u0394"+
		"\u0005\u008a\u0000\u0000\u0394\u0395\u0003L&\u0000\u0395\u0396\u0005\u0001"+
		"\u0000\u0000\u0396\u0397\u0003L&\u0000\u0397\u0398\u0005\u008b\u0000\u0000"+
		"\u0398\u03d2\u0001\u0000\u0000\u0000\u0399\u039a\u0005/\u0000\u0000\u039a"+
		"\u039b\u0005\u008a\u0000\u0000\u039b\u039c\u0003L&\u0000\u039c\u039d\u0005"+
		"\u008b\u0000\u0000\u039d\u03d2\u0001\u0000\u0000\u0000\u039e\u039f\u0005"+
		"Z\u0000\u0000\u039f\u03a0\u0005\u008a\u0000\u0000\u03a0\u03a1\u0003L&"+
		"\u0000\u03a1\u03a2\u0005\u008b\u0000\u0000\u03a2\u03d2\u0001\u0000\u0000"+
		"\u0000\u03a3\u03a4\u0005\u0014\u0000\u0000\u03a4\u03a6\u0005\u008a\u0000"+
		"\u0000\u03a5\u03a7\u0007\u0000\u0000\u0000\u03a6\u03a5\u0001\u0000\u0000"+
		"\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000"+
		"\u0000\u03a8\u03b3\u0003L&\u0000\u03a9\u03aa\u0005W\u0000\u0000\u03aa"+
		"\u03ab\u0005\u001d\u0000\u0000\u03ab\u03b0\u0003<\u001e\u0000\u03ac\u03ad"+
		"\u0005\u0001\u0000\u0000\u03ad\u03af\u0003<\u001e\u0000\u03ae\u03ac\u0001"+
		"\u0000\u0000\u0000\u03af\u03b2\u0001\u0000\u0000\u0000\u03b0\u03ae\u0001"+
		"\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1\u03b4\u0001"+
		"\u0000\u0000\u0000\u03b2\u03b0\u0001\u0000\u0000\u0000\u03b3\u03a9\u0001"+
		"\u0000\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000\u0000\u03b4\u03b7\u0001"+
		"\u0000\u0000\u0000\u03b5\u03b6\u0005O\u0000\u0000\u03b6\u03b8\u0003L&"+
		"\u0000\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000"+
		"\u0000\u03b8\u03b9\u0001\u0000\u0000\u0000\u03b9\u03ba\u0005\u008b\u0000"+
		"\u0000\u03ba\u03d2\u0001\u0000\u0000\u0000\u03bb\u03bc\u0005=\u0000\u0000"+
		"\u03bc\u03bd\u0005\u008a\u0000\u0000\u03bd\u03be\u0003L&\u0000\u03be\u03bf"+
		"\u0005\u0001\u0000\u0000\u03bf\u03c2\u0003L&\u0000\u03c0\u03c1\u0005\u0001"+
		"\u0000\u0000\u03c1\u03c3\u0003L&\u0000\u03c2\u03c0\u0001\u0000\u0000\u0000"+
		"\u03c2\u03c3\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000"+
		"\u03c4\u03c5\u0005\u008b\u0000\u0000\u03c5\u03d2\u0001\u0000\u0000\u0000"+
		"\u03c6\u03c7\u0005>\u0000\u0000\u03c7\u03c8\u0005\u008a\u0000\u0000\u03c8"+
		"\u03c9\u0003L&\u0000\u03c9\u03ca\u0005\u0001\u0000\u0000\u03ca\u03cd\u0003"+
		"L&\u0000\u03cb\u03cc\u0005\u0001\u0000\u0000\u03cc\u03ce\u0003L&\u0000"+
		"\u03cd\u03cb\u0001\u0000\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000\u0000"+
		"\u03ce\u03cf\u0001\u0000\u0000\u0000\u03cf\u03d0\u0005\u008b\u0000\u0000"+
		"\u03d0\u03d2\u0001\u0000\u0000\u0000\u03d1\u030f\u0001\u0000\u0000\u0000"+
		"\u03d1\u0319\u0001\u0000\u0000\u0000\u03d1\u032d\u0001\u0000\u0000\u0000"+
		"\u03d1\u0332\u0001\u0000\u0000\u0000\u03d1\u0339\u0001\u0000\u0000\u0000"+
		"\u03d1\u0342\u0001\u0000\u0000\u0000\u03d1\u034b\u0001\u0000\u0000\u0000"+
		"\u03d1\u0354\u0001\u0000\u0000\u0000\u03d1\u035d\u0001\u0000\u0000\u0000"+
		"\u03d1\u0366\u0001\u0000\u0000\u0000\u03d1\u036f\u0001\u0000\u0000\u0000"+
		"\u03d1\u0376\u0001\u0000\u0000\u0000\u03d1\u037d\u0001\u0000\u0000\u0000"+
		"\u03d1\u0384\u0001\u0000\u0000\u0000\u03d1\u038b\u0001\u0000\u0000\u0000"+
		"\u03d1\u0392\u0001\u0000\u0000\u0000\u03d1\u0399\u0001\u0000\u0000\u0000"+
		"\u03d1\u039e\u0001\u0000\u0000\u0000\u03d1\u03a3\u0001\u0000\u0000\u0000"+
		"\u03d1\u03bb\u0001\u0000\u0000\u0000\u03d1\u03c6\u0001\u0000\u0000\u0000"+
		"\u03d2_\u0001\u0000\u0000\u0000\u03d3\u03d4\u0007\u0006\u0000\u0000\u03d4"+
		"a\u0001\u0000\u0000\u0000\u03d5\u03e1\u0003n7\u0000\u03d6\u03d7\u0003"+
		"d2\u0000\u03d7\u03d8\u0005\u0003\u0000\u0000\u03d8\u03d9\u0003n7\u0000"+
		"\u03d9\u03e1\u0001\u0000\u0000\u0000\u03da\u03db\u0003d2\u0000\u03db\u03dc"+
		"\u0005\u0003\u0000\u0000\u03dc\u03dd\u0003d2\u0000\u03dd\u03de\u0005\u0003"+
		"\u0000\u0000\u03de\u03df\u0003n7\u0000\u03df\u03e1\u0001\u0000\u0000\u0000"+
		"\u03e0\u03d5\u0001\u0000\u0000\u0000\u03e0\u03d6\u0001\u0000\u0000\u0000"+
		"\u03e0\u03da\u0001\u0000\u0000\u0000\u03e1c\u0001\u0000\u0000\u0000\u03e2"+
		"\u03e3\u0003n7\u0000\u03e3e\u0001\u0000\u0000\u0000\u03e4\u040f\u0005"+
		"\u0087\u0000\u0000\u03e5\u040f\u0005\u0088\u0000\u0000\u03e6\u040f\u0005"+
		"i\u0000\u0000\u03e7\u040f\u0005j\u0000\u0000\u03e8\u040f\u0005g\u0000"+
		"\u0000\u03e9\u040f\u0005h\u0000\u0000\u03ea\u03ee\u0005e\u0000\u0000\u03eb"+
		"\u03ec\u0005\u008a\u0000\u0000\u03ec\u03ed\u0005\u0090\u0000\u0000\u03ed"+
		"\u03ef\u0005\u008b\u0000\u0000\u03ee\u03eb\u0001\u0000\u0000\u0000\u03ee"+
		"\u03ef\u0001\u0000\u0000\u0000\u03ef\u040f\u0001\u0000\u0000\u0000\u03f0"+
		"\u03f4\u0005f\u0000\u0000\u03f1\u03f2\u0005\u008a\u0000\u0000\u03f2\u03f3"+
		"\u0005\u0090\u0000\u0000\u03f3\u03f5\u0005\u008b\u0000\u0000\u03f4\u03f1"+
		"\u0001\u0000\u0000\u0000\u03f4\u03f5\u0001\u0000\u0000\u0000\u03f5\u040f"+
		"\u0001\u0000\u0000\u0000\u03f6\u040f\u0005%\u0000\u0000\u03f7\u040f\u0005"+
		"*\u0000\u0000\u03f8\u040f\u00050\u0000\u0000\u03f9\u040f\u00051\u0000"+
		"\u0000\u03fa\u040f\u0005E\u0000\u0000\u03fb\u040f\u0005k\u0000\u0000\u03fc"+
		"\u040f\u0005\u0089\u0000\u0000\u03fd\u03fe\u0005\u0018\u0000\u0000\u03fe"+
		"\u03ff\u0005\r\u0000\u0000\u03ff\u0400\u0003f3\u0000\u0400\u0401\u0005"+
		"\u000e\u0000\u0000\u0401\u040f\u0001\u0000\u0000\u0000\u0402\u0403\u0005"+
		"\u0084\u0000\u0000\u0403\u0404\u0005\r\u0000\u0000\u0404\u0409\u0003h"+
		"4\u0000\u0405\u0406\u0005\u0001\u0000\u0000\u0406\u0408\u0003h4\u0000"+
		"\u0407\u0405\u0001\u0000\u0000\u0000\u0408\u040b\u0001\u0000\u0000\u0000"+
		"\u0409\u0407\u0001\u0000\u0000\u0000\u0409\u040a\u0001\u0000\u0000\u0000"+
		"\u040a\u040c\u0001\u0000\u0000\u0000\u040b\u0409\u0001\u0000\u0000\u0000"+
		"\u040c\u040d\u0005\u000e\u0000\u0000\u040d\u040f\u0001\u0000\u0000\u0000"+
		"\u040e\u03e4\u0001\u0000\u0000\u0000\u040e\u03e5\u0001\u0000\u0000\u0000"+
		"\u040e\u03e6\u0001\u0000\u0000\u0000\u040e\u03e7\u0001\u0000\u0000\u0000"+
		"\u040e\u03e8\u0001\u0000\u0000\u0000\u040e\u03e9\u0001\u0000\u0000\u0000"+
		"\u040e\u03ea\u0001\u0000\u0000\u0000\u040e\u03f0\u0001\u0000\u0000\u0000"+
		"\u040e\u03f6\u0001\u0000\u0000\u0000\u040e\u03f7\u0001\u0000\u0000\u0000"+
		"\u040e\u03f8\u0001\u0000\u0000\u0000\u040e\u03f9\u0001\u0000\u0000\u0000"+
		"\u040e\u03fa\u0001\u0000\u0000\u0000\u040e\u03fb\u0001\u0000\u0000\u0000"+
		"\u040e\u03fc\u0001\u0000\u0000\u0000\u040e\u03fd\u0001\u0000\u0000\u0000"+
		"\u040e\u0402\u0001\u0000\u0000\u0000\u040fg\u0001\u0000\u0000\u0000\u0410"+
		"\u0411\u0003n7\u0000\u0411\u0412\u0003f3\u0000\u0412i\u0001\u0000\u0000"+
		"\u0000\u0413\u0414\u0007\u0007\u0000\u0000\u0414k\u0001\u0000\u0000\u0000"+
		"\u0415\u0424\u0005\u008f\u0000\u0000\u0416\u0424\u0005\u0090\u0000\u0000"+
		"\u0417\u0424\u0005\u0091\u0000\u0000\u0418\u0424\u0005w\u0000\u0000\u0419"+
		"\u0424\u0005x\u0000\u0000\u041a\u0424\u0005y\u0000\u0000\u041b\u041c\u0005"+
		"%\u0000\u0000\u041c\u0424\u0005\u008f\u0000\u0000\u041d\u041e\u00050\u0000"+
		"\u0000\u041e\u0424\u0005\u008f\u0000\u0000\u041f\u0420\u00051\u0000\u0000"+
		"\u0420\u0424\u0005\u008f\u0000\u0000\u0421\u0422\u0005*\u0000\u0000\u0422"+
		"\u0424\u0005\u008f\u0000\u0000\u0423\u0415\u0001\u0000\u0000\u0000\u0423"+
		"\u0416\u0001\u0000\u0000\u0000\u0423\u0417\u0001\u0000\u0000\u0000\u0423"+
		"\u0418\u0001\u0000\u0000\u0000\u0423\u0419\u0001\u0000\u0000\u0000\u0423"+
		"\u041a\u0001\u0000\u0000\u0000\u0423\u041b\u0001\u0000\u0000\u0000\u0423"+
		"\u041d\u0001\u0000\u0000\u0000\u0423\u041f\u0001\u0000\u0000\u0000\u0423"+
		"\u0421\u0001\u0000\u0000\u0000\u0424m\u0001\u0000\u0000\u0000\u0425\u042a"+
		"\u0005\u008c\u0000\u0000\u0426\u042a\u0005\u008d\u0000\u0000\u0427\u042a"+
		"\u0005\u008e\u0000\u0000\u0428\u042a\u0003p8\u0000\u0429\u0425\u0001\u0000"+
		"\u0000\u0000\u0429\u0426\u0001\u0000\u0000\u0000\u0429\u0427\u0001\u0000"+
		"\u0000\u0000\u0429\u0428\u0001\u0000\u0000\u0000\u042ao\u0001\u0000\u0000"+
		"\u0000\u042b\u042c\u0007\b\u0000\u0000\u042cq\u0001\u0000\u0000\u0000"+
		"oswz\u0082\u0091\u0097\u009d\u00a0\u00a2\u00ac\u00b0\u00b3\u00b6\u00b9"+
		"\u00bc\u00bf\u00c2\u00c5\u00c9\u00d0\u00d5\u00d8\u00dc\u00e8\u00ef\u00f5"+
		"\u00fb\u0101\u0108\u010d\u0110\u0112\u0116\u0118\u011b\u011f\u0127\u0131"+
		"\u0136\u013a\u0141\u0145\u0149\u014b\u0156\u015b\u0163\u016a\u0175\u0181"+
		"\u018e\u0193\u019b\u019e\u01ae\u01b7\u01ba\u01bd\u01c0\u01cd\u01d7\u01dc"+
		"\u01e0\u01ed\u01fb\u0209\u0230\u0261\u026c\u0273\u0275\u027e\u0281\u028d"+
		"\u0291\u029c\u02a0\u02ac\u02b0\u02c2\u02ca\u02cd\u02da\u02dd\u02e7\u02e9"+
		"\u02f2\u02f7\u0303\u0308\u030d\u0312\u0316\u031c\u0323\u0326\u032b\u03a6"+
		"\u03b0\u03b3\u03b7\u03c2\u03cd\u03d1\u03e0\u03ee\u03f4\u0409\u040e\u0423"+
		"\u0429";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}