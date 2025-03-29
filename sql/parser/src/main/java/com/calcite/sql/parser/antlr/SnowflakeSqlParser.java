// Generated from SnowflakeSql.g4 by ANTLR 4.13.2

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
public class SnowflakeSqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, ABS=59, ACOS=60, 
		ACOSH=61, ALL=62, AND=63, ANY=64, APPROXIMATE=65, AS=66, ASC=67, ASIN=68, 
		ASINH=69, AT=70, ATAN=71, ATAN2=72, ATANH=73, AVG=74, BETWEEN=75, BOTH=76, 
		BY=77, CASE=78, CAST=79, CEIL=80, CEILING=81, COALESCE=82, COLLATE=83, 
		CONVERT_TIMEZONE=84, COS=85, COSH=86, COUNT=87, CROSS=88, CUBE=89, CURRENT=90, 
		CURRENT_DATE=91, CURRENT_TIME=92, CURRENT_TIMESTAMP=93, CURRENT_USER=94, 
		DATEADD=95, DATEDIFF=96, DESC=97, DISTINCT=98, ELSE=99, END=100, ESCAPE=101, 
		EXCEPT=102, EXCLUDE=103, EXISTS=104, EXTRACT=105, FIRST=106, FLATTEN=107, 
		FLOOR=108, FOLLOWING=109, FOR=110, FROM=111, FULL=112, GROUP=113, GROUPING=114, 
		HAVING=115, IF=116, ILIKE=117, IN=118, INNER=119, INTERSECT=120, INTERVAL=121, 
		IS=122, JOIN=123, LAST=124, LATERAL=125, LEADING=126, LEFT=127, LIKE=128, 
		LIMIT=129, LISTAGG=130, LOCALTIME=131, LOCALTIMESTAMP=132, LOG=133, MAX=134, 
		MIN=135, MOD=136, NATURAL=137, NOT=138, NULL=139, NULLS=140, OBJECT_AGG=141, 
		OFFSET=142, ON=143, OR=144, ORDER=145, OUTER=146, OVER=147, PARTITION=148, 
		PERCENT=149, POSITION=150, PRECEDING=151, QUALIFY=152, RANGE=153, RECURSIVE=154, 
		REGEXP=155, RIGHT=156, RLIKE=157, ROLLUP=158, ROW=159, ROWS=160, SELECT=161, 
		SETS=162, SIMILAR=163, SOME=164, STDDEV=165, SUBSTRING=166, SUM=167, TABLE=168, 
		THEN=169, TIME=170, TIMESTAMP=171, TO=172, TRAILING=173, TRIM=174, TRY_CAST=175, 
		UNBOUNDED=176, UNION=177, USING=178, VARIANCE=179, WHEN=180, WHERE=181, 
		WINDOW=182, WITH=183, WITHIN=184, ZONE=185, ARRAY_AGG=186, IDENTIFIER=187, 
		QUOTED_IDENTIFIER=188, INTEGER_LITERAL=189, DECIMAL_LITERAL=190, STRING_LITERAL=191, 
		BINARY_LITERAL=192, BOOLEAN_LITERAL=193, DATE_LITERAL=194, TIME_LITERAL=195, 
		TIMESTAMP_LITERAL=196, INTERVAL_LITERAL=197, VARIANT_LITERAL=198, WS=199, 
		LINE_COMMENT=200, BLOCK_COMMENT=201;
	public static final int
		RULE_selectStatement = 0, RULE_withClause = 1, RULE_commonTableExpression = 2, 
		RULE_selectCore = 3, RULE_setQuantifier = 4, RULE_selectList = 5, RULE_selectItem = 6, 
		RULE_fromClause = 7, RULE_tableExpression = 8, RULE_tablePrimary = 9, 
		RULE_tableFunctionCall = 10, RULE_functionArgument = 11, RULE_joinClause = 12, 
		RULE_joinType = 13, RULE_whereClause = 14, RULE_groupByClause = 15, RULE_groupByItem = 16, 
		RULE_groupingSetItem = 17, RULE_havingClause = 18, RULE_qualifyClause = 19, 
		RULE_windowClause = 20, RULE_namedWindow = 21, RULE_windowSpecification = 22, 
		RULE_partitionByClause = 23, RULE_orderByClause = 24, RULE_orderByItem = 25, 
		RULE_frameClause = 26, RULE_frameStart = 27, RULE_frameEnd = 28, RULE_limitClause = 29, 
		RULE_expression = 30, RULE_caseExpression = 31, RULE_simpleCaseExpression = 32, 
		RULE_searchedCaseExpression = 33, RULE_functionCall = 34, RULE_aggregateFunction = 35, 
		RULE_withinGroup = 36, RULE_regularFunction = 37, RULE_specialFunction = 38, 
		RULE_columnReference = 39, RULE_tableName = 40, RULE_schemaName = 41, 
		RULE_databaseName = 42, RULE_columnName = 43, RULE_columnAlias = 44, RULE_tableAlias = 45, 
		RULE_windowName = 46, RULE_collationName = 47, RULE_literal = 48, RULE_arrayLiteral = 49, 
		RULE_objectLiteral = 50, RULE_objectField = 51, RULE_dataType = 52, RULE_unaryOperator = 53, 
		RULE_binaryOperator = 54, RULE_identifier = 55, RULE_nonReservedKeyword = 56;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "withClause", "commonTableExpression", "selectCore", 
			"setQuantifier", "selectList", "selectItem", "fromClause", "tableExpression", 
			"tablePrimary", "tableFunctionCall", "functionArgument", "joinClause", 
			"joinType", "whereClause", "groupByClause", "groupByItem", "groupingSetItem", 
			"havingClause", "qualifyClause", "windowClause", "namedWindow", "windowSpecification", 
			"partitionByClause", "orderByClause", "orderByItem", "frameClause", "frameStart", 
			"frameEnd", "limitClause", "expression", "caseExpression", "simpleCaseExpression", 
			"searchedCaseExpression", "functionCall", "aggregateFunction", "withinGroup", 
			"regularFunction", "specialFunction", "columnReference", "tableName", 
			"schemaName", "databaseName", "columnName", "columnAlias", "tableAlias", 
			"windowName", "collationName", "literal", "arrayLiteral", "objectLiteral", 
			"objectField", "dataType", "unaryOperator", "binaryOperator", "identifier", 
			"nonReservedKeyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'*'", "'.'", "'::'", "'ARRAY'", "'['", "']'", 
			"'OBJECT'", "'{'", "'}'", "':'", "'NUMBER'", "'INT'", "'INTEGER'", "'BIGINT'", 
			"'SMALLINT'", "'FLOAT'", "'FLOAT4'", "'FLOAT8'", "'DOUBLE'", "'DOUBLE PRECISION'", 
			"'REAL'", "'DECIMAL'", "'NUMERIC'", "'VARCHAR'", "'CHAR'", "'CHARACTER'", 
			"'STRING'", "'TEXT'", "'BINARY'", "'VARBINARY'", "'BOOLEAN'", "'DATE'", 
			"'TIMESTAMP_LTZ'", "'TIMESTAMP_NTZ'", "'TIMESTAMP_TZ'", "'VARIANT'", 
			"'GEOGRAPHY'", "'GEOMETRY'", "'-'", "'+'", "'~'", "'||'", "'/'", "'%'", 
			"'&'", "'|'", "'^'", "'='", "'=='", "'!='", "'<>'", "'<'", "'<='", "'>'", 
			"'>='", "'ABS'", "'ACOS'", "'ACOSH'", "'ALL'", "'AND'", "'ANY'", "'APPROXIMATE'", 
			"'AS'", "'ASC'", "'ASIN'", "'ASINH'", "'AT'", "'ATAN'", "'ATAN2'", "'ATANH'", 
			"'AVG'", "'BETWEEN'", "'BOTH'", "'BY'", "'CASE'", "'CAST'", "'CEIL'", 
			"'CEILING'", "'COALESCE'", "'COLLATE'", "'CONVERT_TIMEZONE'", "'COS'", 
			"'COSH'", "'COUNT'", "'CROSS'", "'CUBE'", "'CURRENT'", "'CURRENT_DATE'", 
			"'CURRENT_TIME'", "'CURRENT_TIMESTAMP'", "'CURRENT_USER'", "'DATEADD'", 
			"'DATEDIFF'", "'DESC'", "'DISTINCT'", "'ELSE'", "'END'", "'ESCAPE'", 
			"'EXCEPT'", "'EXCLUDE'", "'EXISTS'", "'EXTRACT'", "'FIRST'", "'FLATTEN'", 
			"'FLOOR'", "'FOLLOWING'", "'FOR'", "'FROM'", "'FULL'", "'GROUP'", "'GROUPING'", 
			"'HAVING'", "'IF'", "'ILIKE'", "'IN'", "'INNER'", "'INTERSECT'", "'INTERVAL'", 
			"'IS'", "'JOIN'", "'LAST'", "'LATERAL'", "'LEADING'", "'LEFT'", "'LIKE'", 
			"'LIMIT'", "'LISTAGG'", "'LOCALTIME'", "'LOCALTIMESTAMP'", "'LOG'", "'MAX'", 
			"'MIN'", "'MOD'", "'NATURAL'", "'NOT'", "'NULL'", "'NULLS'", "'OBJECT_AGG'", 
			"'OFFSET'", "'ON'", "'OR'", "'ORDER'", "'OUTER'", "'OVER'", "'PARTITION'", 
			"'PERCENT'", "'POSITION'", "'PRECEDING'", "'QUALIFY'", "'RANGE'", "'RECURSIVE'", 
			"'REGEXP'", "'RIGHT'", "'RLIKE'", "'ROLLUP'", "'ROW'", "'ROWS'", "'SELECT'", 
			"'SETS'", "'SIMILAR'", "'SOME'", "'STDDEV'", "'SUBSTRING'", "'SUM'", 
			"'TABLE'", "'THEN'", "'TIME'", "'TIMESTAMP'", "'TO'", "'TRAILING'", "'TRIM'", 
			"'TRY_CAST'", "'UNBOUNDED'", "'UNION'", "'USING'", "'VARIANCE'", "'WHEN'", 
			"'WHERE'", "'WINDOW'", "'WITH'", "'WITHIN'", "'ZONE'", "'ARRAY_AGG'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ABS", 
			"ACOS", "ACOSH", "ALL", "AND", "ANY", "APPROXIMATE", "AS", "ASC", "ASIN", 
			"ASINH", "AT", "ATAN", "ATAN2", "ATANH", "AVG", "BETWEEN", "BOTH", "BY", 
			"CASE", "CAST", "CEIL", "CEILING", "COALESCE", "COLLATE", "CONVERT_TIMEZONE", 
			"COS", "COSH", "COUNT", "CROSS", "CUBE", "CURRENT", "CURRENT_DATE", "CURRENT_TIME", 
			"CURRENT_TIMESTAMP", "CURRENT_USER", "DATEADD", "DATEDIFF", "DESC", "DISTINCT", 
			"ELSE", "END", "ESCAPE", "EXCEPT", "EXCLUDE", "EXISTS", "EXTRACT", "FIRST", 
			"FLATTEN", "FLOOR", "FOLLOWING", "FOR", "FROM", "FULL", "GROUP", "GROUPING", 
			"HAVING", "IF", "ILIKE", "IN", "INNER", "INTERSECT", "INTERVAL", "IS", 
			"JOIN", "LAST", "LATERAL", "LEADING", "LEFT", "LIKE", "LIMIT", "LISTAGG", 
			"LOCALTIME", "LOCALTIMESTAMP", "LOG", "MAX", "MIN", "MOD", "NATURAL", 
			"NOT", "NULL", "NULLS", "OBJECT_AGG", "OFFSET", "ON", "OR", "ORDER", 
			"OUTER", "OVER", "PARTITION", "PERCENT", "POSITION", "PRECEDING", "QUALIFY", 
			"RANGE", "RECURSIVE", "REGEXP", "RIGHT", "RLIKE", "ROLLUP", "ROW", "ROWS", 
			"SELECT", "SETS", "SIMILAR", "SOME", "STDDEV", "SUBSTRING", "SUM", "TABLE", 
			"THEN", "TIME", "TIMESTAMP", "TO", "TRAILING", "TRIM", "TRY_CAST", "UNBOUNDED", 
			"UNION", "USING", "VARIANCE", "WHEN", "WHERE", "WINDOW", "WITH", "WITHIN", 
			"ZONE", "ARRAY_AGG", "IDENTIFIER", "QUOTED_IDENTIFIER", "INTEGER_LITERAL", 
			"DECIMAL_LITERAL", "STRING_LITERAL", "BINARY_LITERAL", "BOOLEAN_LITERAL", 
			"DATE_LITERAL", "TIME_LITERAL", "TIMESTAMP_LITERAL", "INTERVAL_LITERAL", 
			"VARIANT_LITERAL", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "SnowflakeSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SnowflakeSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public SelectCoreContext selectCore() {
			return getRuleContext(SelectCoreContext.class,0);
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSelectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSelectStatement(this);
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
			selectCore();
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(118);
				orderByClause();
				}
				break;
			}
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(121);
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
	public static class WithClauseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SnowflakeSqlParser.WITH, 0); }
		public List<CommonTableExpressionContext> commonTableExpression() {
			return getRuleContexts(CommonTableExpressionContext.class);
		}
		public CommonTableExpressionContext commonTableExpression(int i) {
			return getRuleContext(CommonTableExpressionContext.class,i);
		}
		public TerminalNode RECURSIVE() { return getToken(SnowflakeSqlParser.RECURSIVE, 0); }
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWithClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWithClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWithClause(this);
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
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RECURSIVE) {
				{
				setState(125);
				match(RECURSIVE);
				}
			}

			setState(128);
			commonTableExpression();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(129);
				match(T__0);
				setState(130);
				commonTableExpression();
				}
				}
				setState(135);
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
	public static class CommonTableExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public CommonTableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonTableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterCommonTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitCommonTableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitCommonTableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommonTableExpressionContext commonTableExpression() throws RecognitionException {
		CommonTableExpressionContext _localctx = new CommonTableExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_commonTableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			identifier();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(137);
				match(T__1);
				setState(138);
				columnName();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(139);
					match(T__0);
					setState(140);
					columnName();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(T__2);
				}
			}

			setState(150);
			match(AS);
			setState(151);
			match(T__1);
			setState(152);
			selectStatement();
			setState(153);
			match(T__2);
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
	public static class SelectCoreContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SnowflakeSqlParser.SELECT, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
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
		public SelectCoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectCore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSelectCore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSelectCore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSelectCore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectCoreContext selectCore() throws RecognitionException {
		SelectCoreContext _localctx = new SelectCoreContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectCore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(SELECT);
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(156);
				setQuantifier();
				}
				break;
			}
			setState(159);
			selectList();
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(160);
				fromClause();
				}
				break;
			}
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(163);
				whereClause();
				}
				break;
			}
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(166);
				groupByClause();
				}
				break;
			}
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(169);
				havingClause();
				}
				break;
			}
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(172);
				qualifyClause();
				}
				break;
			}
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(175);
				windowClause();
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
	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SnowflakeSqlParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SnowflakeSqlParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
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
	public static class SelectListContext extends ParserRuleContext {
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSelectList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSelectList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			selectItem();
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					match(T__0);
					setState(182);
					selectItem();
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ColumnAliasContext columnAlias() {
			return getRuleContext(ColumnAliasContext.class,0);
		}
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSelectItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSelectItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectItem);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576460752303423488L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 1873462243362856955L) != 0)) {
					{
					setState(189);
					tableName();
					setState(190);
					match(T__4);
					}
				}

				setState(194);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				expression(0);
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(196);
						match(AS);
						}
						break;
					}
					setState(199);
					columnAlias();
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
	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SnowflakeSqlParser.FROM, 0); }
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(FROM);
			setState(205);
			tableExpression();
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					match(T__0);
					setState(207);
					tableExpression();
					}
					} 
				}
				setState(212);
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
	public static class TableExpressionContext extends ParserRuleContext {
		public TablePrimaryContext tablePrimary() {
			return getRuleContext(TablePrimaryContext.class,0);
		}
		public List<JoinClauseContext> joinClause() {
			return getRuleContexts(JoinClauseContext.class);
		}
		public JoinClauseContext joinClause(int i) {
			return getRuleContext(JoinClauseContext.class,i);
		}
		public TableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterTableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitTableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitTableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableExpressionContext tableExpression() throws RecognitionException {
		TableExpressionContext _localctx = new TableExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			tablePrimary();
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					joinClause();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
	public static class TablePrimaryContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public List<ColumnAliasContext> columnAlias() {
			return getRuleContexts(ColumnAliasContext.class);
		}
		public ColumnAliasContext columnAlias(int i) {
			return getRuleContext(ColumnAliasContext.class,i);
		}
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode LATERAL() { return getToken(SnowflakeSqlParser.LATERAL, 0); }
		public TableFunctionCallContext tableFunctionCall() {
			return getRuleContext(TableFunctionCallContext.class,0);
		}
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public TablePrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterTablePrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitTablePrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitTablePrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePrimaryContext tablePrimary() throws RecognitionException {
		TablePrimaryContext _localctx = new TablePrimaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tablePrimary);
		int _la;
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				tableName();
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(222);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						setState(221);
						match(AS);
						}
						break;
					}
					setState(224);
					tableAlias();
					}
					break;
				}
				setState(238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(227);
					match(T__1);
					setState(228);
					columnAlias();
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(229);
						match(T__0);
						setState(230);
						columnAlias();
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(236);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__1);
				setState(241);
				selectStatement();
				setState(242);
				match(T__2);
				setState(247);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(244);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(243);
						match(AS);
						}
						break;
					}
					setState(246);
					tableAlias();
					}
					break;
				}
				setState(260);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(249);
					match(T__1);
					setState(250);
					columnAlias();
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(251);
						match(T__0);
						setState(252);
						columnAlias();
						}
						}
						setState(257);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(258);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LATERAL) {
					{
					setState(262);
					match(LATERAL);
					}
				}

				{
				setState(265);
				match(T__1);
				setState(266);
				selectStatement();
				setState(267);
				match(T__2);
				}
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(269);
						match(AS);
						}
						break;
					}
					setState(272);
					tableAlias();
					}
					break;
				}
				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(275);
					match(T__1);
					setState(276);
					columnAlias();
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(277);
						match(T__0);
						setState(278);
						columnAlias();
						}
						}
						setState(283);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(284);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(288);
					match(LATERAL);
					}
					break;
				}
				setState(291);
				tableFunctionCall();
				setState(296);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(293);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						setState(292);
						match(AS);
						}
						break;
					}
					setState(295);
					tableAlias();
					}
					break;
				}
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(298);
					match(T__1);
					setState(299);
					columnAlias();
					setState(304);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(300);
						match(T__0);
						setState(301);
						columnAlias();
						}
						}
						setState(306);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(307);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(311);
				match(T__1);
				setState(312);
				tableExpression();
				setState(313);
				match(T__2);
				setState(318);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(315);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(314);
						match(AS);
						}
						break;
					}
					setState(317);
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
	public static class TableFunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<FunctionArgumentContext> functionArgument() {
			return getRuleContexts(FunctionArgumentContext.class);
		}
		public FunctionArgumentContext functionArgument(int i) {
			return getRuleContext(FunctionArgumentContext.class,i);
		}
		public TableFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterTableFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitTableFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitTableFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableFunctionCallContext tableFunctionCall() throws RecognitionException {
		TableFunctionCallContext _localctx = new TableFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			identifier();
			setState(323);
			match(T__1);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
				{
				setState(324);
				functionArgument();
				}
			}

			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(327);
				match(T__0);
				setState(328);
				functionArgument();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334);
			match(T__2);
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
	public static class FunctionArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFunctionArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFunctionArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFunctionArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentContext functionArgument() throws RecognitionException {
		FunctionArgumentContext _localctx = new FunctionArgumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
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
	public static class JoinClauseContext extends ParserRuleContext {
		public TerminalNode JOIN() { return getToken(SnowflakeSqlParser.JOIN, 0); }
		public TableExpressionContext tableExpression() {
			return getRuleContext(TableExpressionContext.class,0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public TerminalNode ON() { return getToken(SnowflakeSqlParser.ON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SnowflakeSqlParser.USING, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode NATURAL() { return getToken(SnowflakeSqlParser.NATURAL, 0); }
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitJoinClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitJoinClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_joinClause);
		int _la;
		try {
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CROSS:
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 551920074753L) != 0) || _la==RIGHT) {
					{
					setState(338);
					joinType();
					}
				}

				setState(341);
				match(JOIN);
				setState(342);
				tableExpression();
				setState(357);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(343);
					match(ON);
					setState(344);
					expression(0);
					}
					break;
				case 2:
					{
					setState(345);
					match(USING);
					setState(346);
					match(T__1);
					setState(347);
					columnName();
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(348);
						match(T__0);
						setState(349);
						columnName();
						}
						}
						setState(354);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(355);
					match(T__2);
					}
					break;
				}
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				match(NATURAL);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 551920074753L) != 0) || _la==RIGHT) {
					{
					setState(360);
					joinType();
					}
				}

				setState(363);
				match(JOIN);
				setState(364);
				tableExpression();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				match(T__0);
				setState(366);
				tableExpression();
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
	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SnowflakeSqlParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SnowflakeSqlParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SnowflakeSqlParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SnowflakeSqlParser.FULL, 0); }
		public TerminalNode OUTER() { return getToken(SnowflakeSqlParser.OUTER, 0); }
		public TerminalNode CROSS() { return getToken(SnowflakeSqlParser.CROSS, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_joinType);
		int _la;
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(370);
				_la = _input.LA(1);
				if ( !(((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 17592186077185L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(371);
					match(OUTER);
					}
				}

				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
				match(CROSS);
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
		public TerminalNode WHERE() { return getToken(SnowflakeSqlParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(WHERE);
			setState(378);
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
		public TerminalNode GROUP() { return getToken(SnowflakeSqlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SnowflakeSqlParser.BY, 0); }
		public List<GroupByItemContext> groupByItem() {
			return getRuleContexts(GroupByItemContext.class);
		}
		public GroupByItemContext groupByItem(int i) {
			return getRuleContext(GroupByItemContext.class,i);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitGroupByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_groupByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(GROUP);
			setState(381);
			match(BY);
			setState(382);
			groupByItem();
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(383);
					match(T__0);
					setState(384);
					groupByItem();
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
	public static class GroupByItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ROLLUP() { return getToken(SnowflakeSqlParser.ROLLUP, 0); }
		public TerminalNode CUBE() { return getToken(SnowflakeSqlParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(SnowflakeSqlParser.GROUPING, 0); }
		public TerminalNode SETS() { return getToken(SnowflakeSqlParser.SETS, 0); }
		public List<GroupingSetItemContext> groupingSetItem() {
			return getRuleContexts(GroupingSetItemContext.class);
		}
		public GroupingSetItemContext groupingSetItem(int i) {
			return getRuleContext(GroupingSetItemContext.class,i);
		}
		public GroupByItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterGroupByItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitGroupByItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitGroupByItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByItemContext groupByItem() throws RecognitionException {
		GroupByItemContext _localctx = new GroupByItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_groupByItem);
		int _la;
		try {
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(ROLLUP);
				setState(392);
				match(T__1);
				setState(393);
				expression(0);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(394);
					match(T__0);
					setState(395);
					expression(0);
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(CUBE);
				setState(404);
				match(T__1);
				setState(405);
				expression(0);
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(406);
					match(T__0);
					setState(407);
					expression(0);
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(413);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
				match(GROUPING);
				setState(416);
				match(SETS);
				setState(417);
				match(T__1);
				setState(418);
				groupingSetItem();
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(419);
					match(T__0);
					setState(420);
					groupingSetItem();
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(426);
				match(T__2);
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
	public static class GroupingSetItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSetItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterGroupingSetItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitGroupingSetItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitGroupingSetItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingSetItemContext groupingSetItem() throws RecognitionException {
		GroupingSetItemContext _localctx = new GroupingSetItemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_groupingSetItem);
		int _la;
		try {
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(T__1);
				setState(432);
				expression(0);
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(433);
					match(T__0);
					setState(434);
					expression(0);
					}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(440);
				match(T__2);
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
	public static class HavingClauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SnowflakeSqlParser.HAVING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitHavingClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitHavingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(HAVING);
			setState(445);
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
		public TerminalNode QUALIFY() { return getToken(SnowflakeSqlParser.QUALIFY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifyClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterQualifyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitQualifyClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitQualifyClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifyClauseContext qualifyClause() throws RecognitionException {
		QualifyClauseContext _localctx = new QualifyClauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_qualifyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(QUALIFY);
			setState(448);
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
		public TerminalNode WINDOW() { return getToken(SnowflakeSqlParser.WINDOW, 0); }
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWindowClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWindowClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWindowClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_windowClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(WINDOW);
			setState(451);
			namedWindow();
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(452);
					match(T__0);
					setState(453);
					namedWindow();
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public NamedWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedWindow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterNamedWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitNamedWindow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitNamedWindow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedWindowContext namedWindow() throws RecognitionException {
		NamedWindowContext _localctx = new NamedWindowContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_namedWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			identifier();
			setState(460);
			match(AS);
			setState(461);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PartitionByClauseContext partitionByClause() {
			return getRuleContext(PartitionByClauseContext.class,0);
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWindowSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWindowSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWindowSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowSpecificationContext windowSpecification() throws RecognitionException {
		WindowSpecificationContext _localctx = new WindowSpecificationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_windowSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__1);
			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(464);
				identifier();
				}
				break;
			}
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(467);
				partitionByClause();
				}
			}

			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(470);
				orderByClause();
				}
			}

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RANGE || _la==ROWS) {
				{
				setState(473);
				frameClause();
				}
			}

			setState(476);
			match(T__2);
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
	public static class PartitionByClauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SnowflakeSqlParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SnowflakeSqlParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PartitionByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterPartitionByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitPartitionByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitPartitionByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionByClauseContext partitionByClause() throws RecognitionException {
		PartitionByClauseContext _localctx = new PartitionByClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_partitionByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(PARTITION);
			setState(479);
			match(BY);
			setState(480);
			expression(0);
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(481);
				match(T__0);
				setState(482);
				expression(0);
				}
				}
				setState(487);
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
		public TerminalNode ORDER() { return getToken(SnowflakeSqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SnowflakeSqlParser.BY, 0); }
		public List<OrderByItemContext> orderByItem() {
			return getRuleContexts(OrderByItemContext.class);
		}
		public OrderByItemContext orderByItem(int i) {
			return getRuleContext(OrderByItemContext.class,i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_orderByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(ORDER);
			setState(489);
			match(BY);
			setState(490);
			orderByItem();
			setState(495);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(491);
					match(T__0);
					setState(492);
					orderByItem();
					}
					} 
				}
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
	public static class OrderByItemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SnowflakeSqlParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(SnowflakeSqlParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SnowflakeSqlParser.DESC, 0); }
		public TerminalNode FIRST() { return getToken(SnowflakeSqlParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SnowflakeSqlParser.LAST, 0); }
		public OrderByItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterOrderByItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitOrderByItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitOrderByItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByItemContext orderByItem() throws RecognitionException {
		OrderByItemContext _localctx = new OrderByItemContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_orderByItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			expression(0);
			setState(500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(499);
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
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(502);
				match(NULLS);
				setState(503);
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
		public TerminalNode ROWS() { return getToken(SnowflakeSqlParser.ROWS, 0); }
		public TerminalNode RANGE() { return getToken(SnowflakeSqlParser.RANGE, 0); }
		public FrameStartContext frameStart() {
			return getRuleContext(FrameStartContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(SnowflakeSqlParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SnowflakeSqlParser.AND, 0); }
		public FrameEndContext frameEnd() {
			return getRuleContext(FrameEndContext.class,0);
		}
		public FrameClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFrameClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFrameClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFrameClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameClauseContext frameClause() throws RecognitionException {
		FrameClauseContext _localctx = new FrameClauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_frameClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_la = _input.LA(1);
			if ( !(_la==RANGE || _la==ROWS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(507);
				frameStart();
				}
				break;
			case 2:
				{
				setState(508);
				match(BETWEEN);
				setState(509);
				frameStart();
				setState(510);
				match(AND);
				setState(511);
				frameEnd();
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
	public static class FrameStartContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(SnowflakeSqlParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SnowflakeSqlParser.PRECEDING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(SnowflakeSqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SnowflakeSqlParser.ROW, 0); }
		public TerminalNode FOLLOWING() { return getToken(SnowflakeSqlParser.FOLLOWING, 0); }
		public FrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFrameStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFrameStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFrameStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameStartContext frameStart() throws RecognitionException {
		FrameStartContext _localctx = new FrameStartContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_frameStart);
		try {
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				match(UNBOUNDED);
				setState(516);
				match(PRECEDING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				expression(0);
				setState(518);
				match(PRECEDING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(520);
				match(CURRENT);
				setState(521);
				match(ROW);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(522);
				expression(0);
				setState(523);
				match(FOLLOWING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(525);
				match(UNBOUNDED);
				setState(526);
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
		public TerminalNode UNBOUNDED() { return getToken(SnowflakeSqlParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SnowflakeSqlParser.PRECEDING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(SnowflakeSqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SnowflakeSqlParser.ROW, 0); }
		public TerminalNode FOLLOWING() { return getToken(SnowflakeSqlParser.FOLLOWING, 0); }
		public FrameEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFrameEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFrameEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFrameEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameEndContext frameEnd() throws RecognitionException {
		FrameEndContext _localctx = new FrameEndContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_frameEnd);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(529);
				match(UNBOUNDED);
				setState(530);
				match(PRECEDING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				expression(0);
				setState(532);
				match(PRECEDING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				match(CURRENT);
				setState(535);
				match(ROW);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(536);
				expression(0);
				setState(537);
				match(FOLLOWING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(539);
				match(UNBOUNDED);
				setState(540);
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
		public TerminalNode LIMIT() { return getToken(SnowflakeSqlParser.LIMIT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OFFSET() { return getToken(SnowflakeSqlParser.OFFSET, 0); }
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitLimitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitLimitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(LIMIT);
			setState(544);
			expression(0);
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(545);
				match(OFFSET);
				setState(546);
				expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ColumnReferenceContext columnReference() {
			return getRuleContext(ColumnReferenceContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CaseExpressionContext caseExpression() {
			return getRuleContext(CaseExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SnowflakeSqlParser.EXISTS, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode CAST() { return getToken(SnowflakeSqlParser.CAST, 0); }
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode TRY_CAST() { return getToken(SnowflakeSqlParser.TRY_CAST, 0); }
		public BinaryOperatorContext binaryOperator() {
			return getRuleContext(BinaryOperatorContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(SnowflakeSqlParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SnowflakeSqlParser.AND, 0); }
		public TerminalNode NOT() { return getToken(SnowflakeSqlParser.NOT, 0); }
		public TerminalNode RLIKE() { return getToken(SnowflakeSqlParser.RLIKE, 0); }
		public TerminalNode AT() { return getToken(SnowflakeSqlParser.AT, 0); }
		public TerminalNode TIME() { return getToken(SnowflakeSqlParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SnowflakeSqlParser.ZONE, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SnowflakeSqlParser.TIMESTAMP, 0); }
		public TerminalNode IS() { return getToken(SnowflakeSqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SnowflakeSqlParser.NULL, 0); }
		public TerminalNode IN() { return getToken(SnowflakeSqlParser.IN, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SnowflakeSqlParser.LIKE, 0); }
		public TerminalNode ESCAPE() { return getToken(SnowflakeSqlParser.ESCAPE, 0); }
		public TerminalNode COLLATE() { return getToken(SnowflakeSqlParser.COLLATE, 0); }
		public CollationNameContext collationName() {
			return getRuleContext(CollationNameContext.class,0);
		}
		public TerminalNode SIMILAR() { return getToken(SnowflakeSqlParser.SIMILAR, 0); }
		public TerminalNode TO() { return getToken(SnowflakeSqlParser.TO, 0); }
		public TerminalNode ILIKE() { return getToken(SnowflakeSqlParser.ILIKE, 0); }
		public TerminalNode OVER() { return getToken(SnowflakeSqlParser.OVER, 0); }
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(550);
				literal();
				}
				break;
			case 2:
				{
				setState(551);
				columnReference();
				}
				break;
			case 3:
				{
				setState(552);
				functionCall();
				}
				break;
			case 4:
				{
				setState(553);
				caseExpression();
				}
				break;
			case 5:
				{
				setState(554);
				match(T__1);
				setState(555);
				expression(0);
				setState(556);
				match(T__2);
				}
				break;
			case 6:
				{
				setState(558);
				unaryOperator();
				setState(559);
				expression(15);
				}
				break;
			case 7:
				{
				setState(561);
				match(EXISTS);
				setState(562);
				match(T__1);
				setState(563);
				selectStatement();
				setState(564);
				match(T__2);
				}
				break;
			case 8:
				{
				setState(566);
				match(CAST);
				setState(567);
				match(T__1);
				setState(568);
				expression(0);
				setState(569);
				match(AS);
				setState(570);
				dataType();
				setState(571);
				match(T__2);
				}
				break;
			case 9:
				{
				setState(573);
				match(TRY_CAST);
				setState(574);
				match(T__1);
				setState(575);
				expression(0);
				setState(576);
				match(AS);
				setState(577);
				dataType();
				setState(578);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(675);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(673);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(582);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(583);
						binaryOperator();
						setState(584);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(586);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(588);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(587);
							match(NOT);
							}
						}

						setState(590);
						match(BETWEEN);
						setState(591);
						expression(0);
						setState(592);
						match(AND);
						setState(593);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(595);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(596);
						match(RLIKE);
						setState(597);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(598);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(599);
						match(AT);
						setState(603);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case TIME:
							{
							setState(600);
							match(TIME);
							setState(601);
							match(ZONE);
							}
							break;
						case TIMESTAMP:
							{
							setState(602);
							match(TIMESTAMP);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(605);
						expression(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(606);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
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
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(612);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(614);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(613);
							match(NOT);
							}
						}

						setState(616);
						match(IN);
						setState(631);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
						case 1:
							{
							setState(617);
							match(T__1);
							setState(626);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
								{
								setState(618);
								expression(0);
								setState(623);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==T__0) {
									{
									{
									setState(619);
									match(T__0);
									setState(620);
									expression(0);
									}
									}
									setState(625);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(628);
							match(T__2);
							}
							break;
						case 2:
							{
							setState(629);
							selectStatement();
							}
							break;
						case 3:
							{
							setState(630);
							tableName();
							}
							break;
						}
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(633);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(635);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(634);
							match(NOT);
							}
						}

						setState(637);
						match(LIKE);
						setState(638);
						expression(0);
						setState(641);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
						case 1:
							{
							setState(639);
							match(ESCAPE);
							setState(640);
							expression(0);
							}
							break;
						}
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(643);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(644);
						match(COLLATE);
						setState(645);
						collationName();
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(646);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(647);
						match(T__5);
						setState(648);
						dataType();
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(649);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(650);
						match(SIMILAR);
						setState(651);
						match(TO);
						setState(652);
						expression(0);
						setState(655);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
						case 1:
							{
							setState(653);
							match(ESCAPE);
							setState(654);
							expression(0);
							}
							break;
						}
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(657);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(659);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(658);
							match(NOT);
							}
						}

						setState(661);
						match(ILIKE);
						setState(662);
						expression(0);
						setState(665);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
						case 1:
							{
							setState(663);
							match(ESCAPE);
							setState(664);
							expression(0);
							}
							break;
						}
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(667);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(668);
						match(OVER);
						setState(671);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ABS:
						case ACOS:
						case ACOSH:
						case ALL:
						case AND:
						case ANY:
						case APPROXIMATE:
						case AS:
						case ASC:
						case ASIN:
						case ASINH:
						case AT:
						case ATAN:
						case ATAN2:
						case ATANH:
						case AVG:
						case BETWEEN:
						case BOTH:
						case BY:
						case CASE:
						case CAST:
						case CEIL:
						case CEILING:
						case COALESCE:
						case COLLATE:
						case CONVERT_TIMEZONE:
						case COS:
						case COSH:
						case COUNT:
						case CUBE:
						case CURRENT:
						case CURRENT_DATE:
						case CURRENT_TIME:
						case CURRENT_TIMESTAMP:
						case CURRENT_USER:
						case DATEADD:
						case DATEDIFF:
						case DESC:
						case DISTINCT:
						case ELSE:
						case END:
						case ESCAPE:
						case EXCEPT:
						case EXCLUDE:
						case EXISTS:
						case EXTRACT:
						case FIRST:
						case FLATTEN:
						case FLOOR:
						case FOLLOWING:
						case FOR:
						case FROM:
						case FULL:
						case GROUP:
						case GROUPING:
						case HAVING:
						case IF:
						case ILIKE:
						case IN:
						case INNER:
						case INTERSECT:
						case INTERVAL:
						case IS:
						case JOIN:
						case LAST:
						case LATERAL:
						case LEFT:
						case LIKE:
						case LIMIT:
						case LOCALTIME:
						case LOCALTIMESTAMP:
						case LOG:
						case MAX:
						case MIN:
						case MOD:
						case NATURAL:
						case NOT:
						case NULL:
						case NULLS:
						case OFFSET:
						case ON:
						case OR:
						case ORDER:
						case OUTER:
						case OVER:
						case PARTITION:
						case PERCENT:
						case PRECEDING:
						case QUALIFY:
						case RANGE:
						case REGEXP:
						case RIGHT:
						case RLIKE:
						case ROLLUP:
						case ROW:
						case ROWS:
						case SELECT:
						case SIMILAR:
						case SOME:
						case STDDEV:
						case SUBSTRING:
						case SUM:
						case TABLE:
						case THEN:
						case TIME:
						case TIMESTAMP:
						case TO:
						case TRIM:
						case TRY_CAST:
						case UNBOUNDED:
						case UNION:
						case USING:
						case VARIANCE:
						case WHEN:
						case WHERE:
						case WINDOW:
						case WITH:
						case WITHIN:
						case IDENTIFIER:
						case QUOTED_IDENTIFIER:
							{
							setState(669);
							windowName();
							}
							break;
						case T__1:
							{
							setState(670);
							windowSpecification();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(677);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_caseExpression);
		try {
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				simpleCaseExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(679);
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
		public TerminalNode CASE() { return getToken(SnowflakeSqlParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END() { return getToken(SnowflakeSqlParser.END, 0); }
		public List<TerminalNode> WHEN() { return getTokens(SnowflakeSqlParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(SnowflakeSqlParser.WHEN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(SnowflakeSqlParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(SnowflakeSqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(SnowflakeSqlParser.ELSE, 0); }
		public SimpleCaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSimpleCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSimpleCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSimpleCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCaseExpressionContext simpleCaseExpression() throws RecognitionException {
		SimpleCaseExpressionContext _localctx = new SimpleCaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_simpleCaseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(CASE);
			setState(683);
			expression(0);
			setState(689); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(684);
				match(WHEN);
				setState(685);
				expression(0);
				setState(686);
				match(THEN);
				setState(687);
				expression(0);
				}
				}
				setState(691); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(693);
				match(ELSE);
				setState(694);
				expression(0);
				}
			}

			setState(697);
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
		public TerminalNode CASE() { return getToken(SnowflakeSqlParser.CASE, 0); }
		public TerminalNode END() { return getToken(SnowflakeSqlParser.END, 0); }
		public List<TerminalNode> WHEN() { return getTokens(SnowflakeSqlParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(SnowflakeSqlParser.WHEN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(SnowflakeSqlParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(SnowflakeSqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(SnowflakeSqlParser.ELSE, 0); }
		public SearchedCaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchedCaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSearchedCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSearchedCaseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSearchedCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchedCaseExpressionContext searchedCaseExpression() throws RecognitionException {
		SearchedCaseExpressionContext _localctx = new SearchedCaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_searchedCaseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			match(CASE);
			setState(705); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(700);
				match(WHEN);
				setState(701);
				expression(0);
				setState(702);
				match(THEN);
				setState(703);
				expression(0);
				}
				}
				setState(707); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(711);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(709);
				match(ELSE);
				setState(710);
				expression(0);
				}
			}

			setState(713);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public RegularFunctionContext regularFunction() {
			return getRuleContext(RegularFunctionContext.class,0);
		}
		public SpecialFunctionContext specialFunction() {
			return getRuleContext(SpecialFunctionContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionCall);
		try {
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(715);
				aggregateFunction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(716);
				regularFunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(717);
				specialFunction();
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
	public static class AggregateFunctionContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SnowflakeSqlParser.COUNT, 0); }
		public TerminalNode SUM() { return getToken(SnowflakeSqlParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(SnowflakeSqlParser.AVG, 0); }
		public TerminalNode MIN() { return getToken(SnowflakeSqlParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(SnowflakeSqlParser.MAX, 0); }
		public TerminalNode STDDEV() { return getToken(SnowflakeSqlParser.STDDEV, 0); }
		public TerminalNode VARIANCE() { return getToken(SnowflakeSqlParser.VARIANCE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DISTINCT() { return getToken(SnowflakeSqlParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SnowflakeSqlParser.ALL, 0); }
		public TerminalNode LISTAGG() { return getToken(SnowflakeSqlParser.LISTAGG, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SnowflakeSqlParser.STRING_LITERAL, 0); }
		public WithinGroupContext withinGroup() {
			return getRuleContext(WithinGroupContext.class,0);
		}
		public TerminalNode ARRAY_AGG() { return getToken(SnowflakeSqlParser.ARRAY_AGG, 0); }
		public TerminalNode OBJECT_AGG() { return getToken(SnowflakeSqlParser.OBJECT_AGG, 0); }
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterAggregateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitAggregateFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitAggregateFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_aggregateFunction);
		int _la;
		try {
			setState(768);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(720);
				_la = _input.LA(1);
				if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 3458764513820549121L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 16389L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(721);
				match(T__1);
				setState(723);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(722);
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
				setState(727);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__6:
				case T__7:
				case T__9:
				case T__10:
				case T__41:
				case T__42:
				case T__43:
				case ABS:
				case ACOS:
				case ACOSH:
				case ALL:
				case AND:
				case ANY:
				case APPROXIMATE:
				case AS:
				case ASC:
				case ASIN:
				case ASINH:
				case AT:
				case ATAN:
				case ATAN2:
				case ATANH:
				case AVG:
				case BETWEEN:
				case BOTH:
				case BY:
				case CASE:
				case CAST:
				case CEIL:
				case CEILING:
				case COALESCE:
				case COLLATE:
				case CONVERT_TIMEZONE:
				case COS:
				case COSH:
				case COUNT:
				case CUBE:
				case CURRENT:
				case CURRENT_DATE:
				case CURRENT_TIME:
				case CURRENT_TIMESTAMP:
				case CURRENT_USER:
				case DATEADD:
				case DATEDIFF:
				case DESC:
				case DISTINCT:
				case ELSE:
				case END:
				case ESCAPE:
				case EXCEPT:
				case EXCLUDE:
				case EXISTS:
				case EXTRACT:
				case FIRST:
				case FLATTEN:
				case FLOOR:
				case FOLLOWING:
				case FOR:
				case FROM:
				case FULL:
				case GROUP:
				case GROUPING:
				case HAVING:
				case IF:
				case ILIKE:
				case IN:
				case INNER:
				case INTERSECT:
				case INTERVAL:
				case IS:
				case JOIN:
				case LAST:
				case LATERAL:
				case LEFT:
				case LIKE:
				case LIMIT:
				case LISTAGG:
				case LOCALTIME:
				case LOCALTIMESTAMP:
				case LOG:
				case MAX:
				case MIN:
				case MOD:
				case NATURAL:
				case NOT:
				case NULL:
				case NULLS:
				case OBJECT_AGG:
				case OFFSET:
				case ON:
				case OR:
				case ORDER:
				case OUTER:
				case OVER:
				case PARTITION:
				case PERCENT:
				case POSITION:
				case PRECEDING:
				case QUALIFY:
				case RANGE:
				case REGEXP:
				case RIGHT:
				case RLIKE:
				case ROLLUP:
				case ROW:
				case ROWS:
				case SELECT:
				case SIMILAR:
				case SOME:
				case STDDEV:
				case SUBSTRING:
				case SUM:
				case TABLE:
				case THEN:
				case TIME:
				case TIMESTAMP:
				case TO:
				case TRIM:
				case TRY_CAST:
				case UNBOUNDED:
				case UNION:
				case USING:
				case VARIANCE:
				case WHEN:
				case WHERE:
				case WINDOW:
				case WITH:
				case WITHIN:
				case ARRAY_AGG:
				case IDENTIFIER:
				case QUOTED_IDENTIFIER:
				case INTEGER_LITERAL:
				case DECIMAL_LITERAL:
				case STRING_LITERAL:
				case BINARY_LITERAL:
				case BOOLEAN_LITERAL:
				case DATE_LITERAL:
				case TIME_LITERAL:
				case TIMESTAMP_LITERAL:
				case INTERVAL_LITERAL:
				case VARIANT_LITERAL:
					{
					setState(725);
					expression(0);
					}
					break;
				case T__3:
					{
					setState(726);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(729);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(730);
				match(COUNT);
				setState(731);
				match(T__1);
				setState(732);
				match(DISTINCT);
				setState(733);
				expression(0);
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(734);
					match(T__0);
					setState(735);
					expression(0);
					}
					}
					setState(740);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(741);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(743);
				match(LISTAGG);
				setState(744);
				match(T__1);
				setState(745);
				expression(0);
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(746);
					match(T__0);
					setState(747);
					match(STRING_LITERAL);
					}
				}

				setState(750);
				match(T__2);
				setState(752);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(751);
					withinGroup();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(754);
				match(ARRAY_AGG);
				setState(755);
				match(T__1);
				setState(756);
				expression(0);
				setState(757);
				match(T__2);
				setState(759);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(758);
					withinGroup();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(761);
				match(OBJECT_AGG);
				setState(762);
				match(T__1);
				setState(763);
				expression(0);
				setState(764);
				match(T__0);
				setState(765);
				expression(0);
				setState(766);
				match(T__2);
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
	public static class WithinGroupContext extends ParserRuleContext {
		public TerminalNode WITHIN() { return getToken(SnowflakeSqlParser.WITHIN, 0); }
		public TerminalNode GROUP() { return getToken(SnowflakeSqlParser.GROUP, 0); }
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public WithinGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withinGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWithinGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWithinGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWithinGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithinGroupContext withinGroup() throws RecognitionException {
		WithinGroupContext _localctx = new WithinGroupContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_withinGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			match(WITHIN);
			setState(771);
			match(GROUP);
			setState(772);
			match(T__1);
			setState(773);
			orderByClause();
			setState(774);
			match(T__2);
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
	public static class RegularFunctionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<FunctionArgumentContext> functionArgument() {
			return getRuleContexts(FunctionArgumentContext.class);
		}
		public FunctionArgumentContext functionArgument(int i) {
			return getRuleContext(FunctionArgumentContext.class,i);
		}
		public RegularFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterRegularFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitRegularFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitRegularFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularFunctionContext regularFunction() throws RecognitionException {
		RegularFunctionContext _localctx = new RegularFunctionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_regularFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			identifier();
			setState(777);
			match(T__1);
			setState(779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
				{
				setState(778);
				functionArgument();
				}
			}

			setState(785);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(781);
				match(T__0);
				setState(782);
				functionArgument();
				}
				}
				setState(787);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(788);
			match(T__2);
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
	public static class SpecialFunctionContext extends ParserRuleContext {
		public TerminalNode CURRENT_DATE() { return getToken(SnowflakeSqlParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SnowflakeSqlParser.CURRENT_TIME, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SnowflakeSqlParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode CURRENT_USER() { return getToken(SnowflakeSqlParser.CURRENT_USER, 0); }
		public TerminalNode SUBSTRING() { return getToken(SnowflakeSqlParser.SUBSTRING, 0); }
		public TerminalNode FROM() { return getToken(SnowflakeSqlParser.FROM, 0); }
		public TerminalNode FOR() { return getToken(SnowflakeSqlParser.FOR, 0); }
		public TerminalNode EXTRACT() { return getToken(SnowflakeSqlParser.EXTRACT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode POSITION() { return getToken(SnowflakeSqlParser.POSITION, 0); }
		public TerminalNode IN() { return getToken(SnowflakeSqlParser.IN, 0); }
		public TerminalNode DATEADD() { return getToken(SnowflakeSqlParser.DATEADD, 0); }
		public TerminalNode DATEDIFF() { return getToken(SnowflakeSqlParser.DATEDIFF, 0); }
		public TerminalNode TRIM() { return getToken(SnowflakeSqlParser.TRIM, 0); }
		public TerminalNode LEADING() { return getToken(SnowflakeSqlParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(SnowflakeSqlParser.TRAILING, 0); }
		public TerminalNode BOTH() { return getToken(SnowflakeSqlParser.BOTH, 0); }
		public TerminalNode CONVERT_TIMEZONE() { return getToken(SnowflakeSqlParser.CONVERT_TIMEZONE, 0); }
		public SpecialFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSpecialFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSpecialFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSpecialFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialFunctionContext specialFunction() throws RecognitionException {
		SpecialFunctionContext _localctx = new SpecialFunctionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_specialFunction);
		int _la;
		try {
			setState(882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				match(CURRENT_DATE);
				setState(793);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(791);
					match(T__1);
					setState(792);
					match(T__2);
					}
					break;
				}
				}
				break;
			case CURRENT_TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(795);
				match(CURRENT_TIME);
				setState(801);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
				case 1:
					{
					setState(796);
					match(T__1);
					setState(798);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
						{
						setState(797);
						expression(0);
						}
					}

					setState(800);
					match(T__2);
					}
					break;
				}
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 3);
				{
				setState(803);
				match(CURRENT_TIMESTAMP);
				setState(809);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
				case 1:
					{
					setState(804);
					match(T__1);
					setState(806);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
						{
						setState(805);
						expression(0);
						}
					}

					setState(808);
					match(T__2);
					}
					break;
				}
				}
				break;
			case CURRENT_USER:
				enterOuterAlt(_localctx, 4);
				{
				setState(811);
				match(CURRENT_USER);
				setState(814);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
				case 1:
					{
					setState(812);
					match(T__1);
					setState(813);
					match(T__2);
					}
					break;
				}
				}
				break;
			case SUBSTRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(816);
				match(SUBSTRING);
				setState(817);
				match(T__1);
				setState(818);
				expression(0);
				setState(819);
				match(FROM);
				setState(820);
				expression(0);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOR) {
					{
					setState(821);
					match(FOR);
					setState(822);
					expression(0);
					}
				}

				setState(825);
				match(T__2);
				}
				break;
			case EXTRACT:
				enterOuterAlt(_localctx, 6);
				{
				setState(827);
				match(EXTRACT);
				setState(828);
				match(T__1);
				setState(829);
				identifier();
				setState(830);
				match(FROM);
				setState(831);
				expression(0);
				setState(832);
				match(T__2);
				}
				break;
			case POSITION:
				enterOuterAlt(_localctx, 7);
				{
				setState(834);
				match(POSITION);
				setState(835);
				match(T__1);
				setState(836);
				expression(0);
				setState(837);
				match(IN);
				setState(838);
				expression(0);
				setState(839);
				match(T__2);
				}
				break;
			case DATEADD:
				enterOuterAlt(_localctx, 8);
				{
				setState(841);
				match(DATEADD);
				setState(842);
				match(T__1);
				setState(843);
				identifier();
				setState(844);
				match(T__0);
				setState(845);
				expression(0);
				setState(846);
				match(T__0);
				setState(847);
				expression(0);
				setState(848);
				match(T__2);
				}
				break;
			case DATEDIFF:
				enterOuterAlt(_localctx, 9);
				{
				setState(850);
				match(DATEDIFF);
				setState(851);
				match(T__1);
				setState(852);
				identifier();
				setState(853);
				match(T__0);
				setState(854);
				expression(0);
				setState(855);
				match(T__0);
				setState(856);
				expression(0);
				setState(857);
				match(T__2);
				}
				break;
			case TRIM:
				enterOuterAlt(_localctx, 10);
				{
				setState(859);
				match(TRIM);
				setState(860);
				match(T__1);
				setState(862);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
				case 1:
					{
					setState(861);
					_la = _input.LA(1);
					if ( !(_la==BOTH || _la==LEADING || _la==TRAILING) ) {
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
				setState(865);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(864);
					expression(0);
					}
					break;
				}
				setState(867);
				match(FROM);
				setState(868);
				expression(0);
				setState(869);
				match(T__2);
				}
				break;
			case CONVERT_TIMEZONE:
				enterOuterAlt(_localctx, 11);
				{
				setState(871);
				match(CONVERT_TIMEZONE);
				setState(872);
				match(T__1);
				setState(873);
				expression(0);
				setState(874);
				match(T__0);
				setState(875);
				expression(0);
				setState(878);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(876);
					match(T__0);
					setState(877);
					expression(0);
					}
				}

				setState(880);
				match(T__2);
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
	public static class ColumnReferenceContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnReferenceContext columnReference() throws RecognitionException {
		ColumnReferenceContext _localctx = new ColumnReferenceContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_columnReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(884);
				tableName();
				setState(885);
				match(T__4);
				}
				break;
			}
			setState(889);
			columnName();
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
	public static class TableNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SchemaNameContext schemaName() {
			return getRuleContext(SchemaNameContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(891);
				schemaName();
				setState(892);
				match(T__4);
				}
				break;
			}
			setState(896);
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
	public static class SchemaNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterSchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitSchemaName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitSchemaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaNameContext schemaName() throws RecognitionException {
		SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_schemaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(898);
				databaseName();
				setState(899);
				match(T__4);
				}
				break;
			}
			setState(903);
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
	public static class DatabaseNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DatabaseNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_databaseName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterDatabaseName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitDatabaseName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitDatabaseName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatabaseNameContext databaseName() throws RecognitionException {
		DatabaseNameContext _localctx = new DatabaseNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_databaseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
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
	public static class ColumnNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
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
	public static class ColumnAliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SnowflakeSqlParser.STRING_LITERAL, 0); }
		public ColumnAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterColumnAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitColumnAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitColumnAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAliasContext columnAlias() throws RecognitionException {
		ColumnAliasContext _localctx = new ColumnAliasContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_columnAlias);
		try {
			setState(911);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABS:
			case ACOS:
			case ACOSH:
			case ALL:
			case AND:
			case ANY:
			case APPROXIMATE:
			case AS:
			case ASC:
			case ASIN:
			case ASINH:
			case AT:
			case ATAN:
			case ATAN2:
			case ATANH:
			case AVG:
			case BETWEEN:
			case BOTH:
			case BY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case COALESCE:
			case COLLATE:
			case CONVERT_TIMEZONE:
			case COS:
			case COSH:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DATEADD:
			case DATEDIFF:
			case DESC:
			case DISTINCT:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUDE:
			case EXISTS:
			case EXTRACT:
			case FIRST:
			case FLATTEN:
			case FLOOR:
			case FOLLOWING:
			case FOR:
			case FROM:
			case FULL:
			case GROUP:
			case GROUPING:
			case HAVING:
			case IF:
			case ILIKE:
			case IN:
			case INNER:
			case INTERSECT:
			case INTERVAL:
			case IS:
			case JOIN:
			case LAST:
			case LATERAL:
			case LEFT:
			case LIKE:
			case LIMIT:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOG:
			case MAX:
			case MIN:
			case MOD:
			case NATURAL:
			case NOT:
			case NULL:
			case NULLS:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case OVER:
			case PARTITION:
			case PERCENT:
			case PRECEDING:
			case QUALIFY:
			case RANGE:
			case REGEXP:
			case RIGHT:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case SELECT:
			case SIMILAR:
			case SOME:
			case STDDEV:
			case SUBSTRING:
			case SUM:
			case TABLE:
			case THEN:
			case TIME:
			case TIMESTAMP:
			case TO:
			case TRIM:
			case TRY_CAST:
			case UNBOUNDED:
			case UNION:
			case USING:
			case VARIANCE:
			case WHEN:
			case WHERE:
			case WINDOW:
			case WITH:
			case WITHIN:
			case IDENTIFIER:
			case QUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(909);
				identifier();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(910);
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
	public static class TableAliasContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SnowflakeSqlParser.STRING_LITERAL, 0); }
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitTableAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitTableAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_tableAlias);
		try {
			setState(915);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABS:
			case ACOS:
			case ACOSH:
			case ALL:
			case AND:
			case ANY:
			case APPROXIMATE:
			case AS:
			case ASC:
			case ASIN:
			case ASINH:
			case AT:
			case ATAN:
			case ATAN2:
			case ATANH:
			case AVG:
			case BETWEEN:
			case BOTH:
			case BY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case COALESCE:
			case COLLATE:
			case CONVERT_TIMEZONE:
			case COS:
			case COSH:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DATEADD:
			case DATEDIFF:
			case DESC:
			case DISTINCT:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUDE:
			case EXISTS:
			case EXTRACT:
			case FIRST:
			case FLATTEN:
			case FLOOR:
			case FOLLOWING:
			case FOR:
			case FROM:
			case FULL:
			case GROUP:
			case GROUPING:
			case HAVING:
			case IF:
			case ILIKE:
			case IN:
			case INNER:
			case INTERSECT:
			case INTERVAL:
			case IS:
			case JOIN:
			case LAST:
			case LATERAL:
			case LEFT:
			case LIKE:
			case LIMIT:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOG:
			case MAX:
			case MIN:
			case MOD:
			case NATURAL:
			case NOT:
			case NULL:
			case NULLS:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case OVER:
			case PARTITION:
			case PERCENT:
			case PRECEDING:
			case QUALIFY:
			case RANGE:
			case REGEXP:
			case RIGHT:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case SELECT:
			case SIMILAR:
			case SOME:
			case STDDEV:
			case SUBSTRING:
			case SUM:
			case TABLE:
			case THEN:
			case TIME:
			case TIMESTAMP:
			case TO:
			case TRIM:
			case TRY_CAST:
			case UNBOUNDED:
			case UNION:
			case USING:
			case VARIANCE:
			case WHEN:
			case WHERE:
			case WINDOW:
			case WITH:
			case WITHIN:
			case IDENTIFIER:
			case QUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(913);
				identifier();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(914);
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
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterWindowName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitWindowName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitWindowName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
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
	public static class CollationNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CollationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterCollationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitCollationName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitCollationName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollationNameContext collationName() throws RecognitionException {
		CollationNameContext _localctx = new CollationNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_collationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SnowflakeSqlParser.NULL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(SnowflakeSqlParser.INTEGER_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(SnowflakeSqlParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SnowflakeSqlParser.STRING_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(SnowflakeSqlParser.BINARY_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(SnowflakeSqlParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode DATE_LITERAL() { return getToken(SnowflakeSqlParser.DATE_LITERAL, 0); }
		public TerminalNode TIME_LITERAL() { return getToken(SnowflakeSqlParser.TIME_LITERAL, 0); }
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(SnowflakeSqlParser.TIMESTAMP_LITERAL, 0); }
		public TerminalNode INTERVAL_LITERAL() { return getToken(SnowflakeSqlParser.INTERVAL_LITERAL, 0); }
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public TerminalNode VARIANT_LITERAL() { return getToken(SnowflakeSqlParser.VARIANT_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_literal);
		try {
			setState(934);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(921);
				match(NULL);
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(922);
				match(INTEGER_LITERAL);
				}
				break;
			case DECIMAL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(923);
				match(DECIMAL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(924);
				match(STRING_LITERAL);
				}
				break;
			case BINARY_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(925);
				match(BINARY_LITERAL);
				}
				break;
			case BOOLEAN_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(926);
				match(BOOLEAN_LITERAL);
				}
				break;
			case DATE_LITERAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(927);
				match(DATE_LITERAL);
				}
				break;
			case TIME_LITERAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(928);
				match(TIME_LITERAL);
				}
				break;
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(929);
				match(TIMESTAMP_LITERAL);
				}
				break;
			case INTERVAL_LITERAL:
				enterOuterAlt(_localctx, 10);
				{
				setState(930);
				match(INTERVAL_LITERAL);
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 11);
				{
				setState(931);
				arrayLiteral();
				}
				break;
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 12);
				{
				setState(932);
				objectLiteral();
				}
				break;
			case VARIANT_LITERAL:
				enterOuterAlt(_localctx, 13);
				{
				setState(933);
				match(VARIANT_LITERAL);
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
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(SnowflakeSqlParser.WS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_arrayLiteral);
		int _la;
		try {
			setState(964);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(936);
				match(T__6);
				setState(938);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(937);
					match(WS);
					}
				}

				setState(940);
				match(T__7);
				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
					{
					setState(941);
					expression(0);
					setState(946);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(942);
						match(T__0);
						setState(943);
						expression(0);
						}
						}
						setState(948);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(951);
				match(T__8);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(952);
				match(T__7);
				setState(961);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576429965977842300L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4611686018444165121L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -144150389694922753L) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 127L) != 0)) {
					{
					setState(953);
					expression(0);
					setState(958);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(954);
						match(T__0);
						setState(955);
						expression(0);
						}
						}
						setState(960);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(963);
				match(T__8);
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
	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(SnowflakeSqlParser.WS, 0); }
		public List<ObjectFieldContext> objectField() {
			return getRuleContexts(ObjectFieldContext.class);
		}
		public ObjectFieldContext objectField(int i) {
			return getRuleContext(ObjectFieldContext.class,i);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitObjectLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitObjectLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_objectLiteral);
		int _la;
		try {
			setState(994);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(966);
				match(T__9);
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(967);
					match(WS);
					}
				}

				setState(970);
				match(T__10);
				setState(979);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(971);
					objectField();
					setState(976);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(972);
						match(T__0);
						setState(973);
						objectField();
						}
						}
						setState(978);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(981);
				match(T__11);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(982);
				match(T__10);
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(983);
					objectField();
					setState(988);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(984);
						match(T__0);
						setState(985);
						objectField();
						}
						}
						setState(990);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(993);
				match(T__11);
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
	public static class ObjectFieldContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SnowflakeSqlParser.STRING_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SnowflakeSqlParser.IDENTIFIER, 0); }
		public ObjectFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterObjectField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitObjectField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitObjectField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectFieldContext objectField() throws RecognitionException {
		ObjectFieldContext _localctx = new ObjectFieldContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_objectField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(996);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(997);
			match(T__12);
			setState(998);
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
	public static class DataTypeContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER_LITERAL() { return getTokens(SnowflakeSqlParser.INTEGER_LITERAL); }
		public TerminalNode INTEGER_LITERAL(int i) {
			return getToken(SnowflakeSqlParser.INTEGER_LITERAL, i);
		}
		public TerminalNode TIME() { return getToken(SnowflakeSqlParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SnowflakeSqlParser.TIMESTAMP, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_dataType);
		int _la;
		try {
			setState(1114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(1000);
				match(T__13);
				setState(1008);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
				case 1:
					{
					setState(1001);
					match(T__1);
					setState(1002);
					match(INTEGER_LITERAL);
					setState(1005);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(1003);
						match(T__0);
						setState(1004);
						match(INTEGER_LITERAL);
						}
					}

					setState(1007);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(1010);
				match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(1011);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(1012);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(1013);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(1014);
				match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 7);
				{
				setState(1015);
				match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 8);
				{
				setState(1016);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 9);
				{
				setState(1017);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 10);
				{
				setState(1018);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 11);
				{
				setState(1019);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 12);
				{
				setState(1020);
				match(T__24);
				setState(1028);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1021);
					match(T__1);
					setState(1022);
					match(INTEGER_LITERAL);
					setState(1025);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(1023);
						match(T__0);
						setState(1024);
						match(INTEGER_LITERAL);
						}
					}

					setState(1027);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 13);
				{
				setState(1030);
				match(T__25);
				setState(1038);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1031);
					match(T__1);
					setState(1032);
					match(INTEGER_LITERAL);
					setState(1035);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(1033);
						match(T__0);
						setState(1034);
						match(INTEGER_LITERAL);
						}
					}

					setState(1037);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 14);
				{
				setState(1040);
				match(T__26);
				setState(1044);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
				case 1:
					{
					setState(1041);
					match(T__1);
					setState(1042);
					match(INTEGER_LITERAL);
					setState(1043);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 15);
				{
				setState(1046);
				match(T__27);
				setState(1050);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
				case 1:
					{
					setState(1047);
					match(T__1);
					setState(1048);
					match(INTEGER_LITERAL);
					setState(1049);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 16);
				{
				setState(1052);
				match(T__28);
				setState(1056);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
				case 1:
					{
					setState(1053);
					match(T__1);
					setState(1054);
					match(INTEGER_LITERAL);
					setState(1055);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 17);
				{
				setState(1058);
				match(T__29);
				setState(1062);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(1059);
					match(T__1);
					setState(1060);
					match(INTEGER_LITERAL);
					setState(1061);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 18);
				{
				setState(1064);
				match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 19);
				{
				setState(1065);
				match(T__31);
				setState(1069);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
				case 1:
					{
					setState(1066);
					match(T__1);
					setState(1067);
					match(INTEGER_LITERAL);
					setState(1068);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 20);
				{
				setState(1071);
				match(T__32);
				setState(1075);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(1072);
					match(T__1);
					setState(1073);
					match(INTEGER_LITERAL);
					setState(1074);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 21);
				{
				setState(1077);
				match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 22);
				{
				setState(1078);
				match(T__34);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 23);
				{
				setState(1079);
				match(TIME);
				setState(1083);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
				case 1:
					{
					setState(1080);
					match(T__1);
					setState(1081);
					match(INTEGER_LITERAL);
					setState(1082);
					match(T__2);
					}
					break;
				}
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 24);
				{
				setState(1085);
				match(TIMESTAMP);
				setState(1089);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1086);
					match(T__1);
					setState(1087);
					match(INTEGER_LITERAL);
					setState(1088);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 25);
				{
				setState(1091);
				match(T__35);
				setState(1095);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(1092);
					match(T__1);
					setState(1093);
					match(INTEGER_LITERAL);
					setState(1094);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 26);
				{
				setState(1097);
				match(T__36);
				setState(1101);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1098);
					match(T__1);
					setState(1099);
					match(INTEGER_LITERAL);
					setState(1100);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 27);
				{
				setState(1103);
				match(T__37);
				setState(1107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1104);
					match(T__1);
					setState(1105);
					match(INTEGER_LITERAL);
					setState(1106);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 28);
				{
				setState(1109);
				match(T__38);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 29);
				{
				setState(1110);
				match(T__9);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 30);
				{
				setState(1111);
				match(T__6);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 31);
				{
				setState(1112);
				match(T__39);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 32);
				{
				setState(1113);
				match(T__40);
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
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SnowflakeSqlParser.NOT, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1116);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0) || _la==NOT) ) {
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
	public static class BinaryOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SnowflakeSqlParser.AND, 0); }
		public TerminalNode OR() { return getToken(SnowflakeSqlParser.OR, 0); }
		public BinaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterBinaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitBinaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitBinaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperatorContext binaryOperator() throws RecognitionException {
		BinaryOperatorContext _localctx = new BinaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_binaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -8646933274783907824L) != 0) || _la==OR) ) {
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SnowflakeSqlParser.IDENTIFIER, 0); }
		public TerminalNode QUOTED_IDENTIFIER() { return getToken(SnowflakeSqlParser.QUOTED_IDENTIFIER, 0); }
		public NonReservedKeywordContext nonReservedKeyword() {
			return getRuleContext(NonReservedKeywordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_identifier);
		try {
			setState(1123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1120);
				match(IDENTIFIER);
				}
				break;
			case QUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1121);
				match(QUOTED_IDENTIFIER);
				}
				break;
			case ABS:
			case ACOS:
			case ACOSH:
			case ALL:
			case AND:
			case ANY:
			case APPROXIMATE:
			case AS:
			case ASC:
			case ASIN:
			case ASINH:
			case AT:
			case ATAN:
			case ATAN2:
			case ATANH:
			case AVG:
			case BETWEEN:
			case BOTH:
			case BY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case COALESCE:
			case COLLATE:
			case CONVERT_TIMEZONE:
			case COS:
			case COSH:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DATEADD:
			case DATEDIFF:
			case DESC:
			case DISTINCT:
			case ELSE:
			case END:
			case ESCAPE:
			case EXCEPT:
			case EXCLUDE:
			case EXISTS:
			case EXTRACT:
			case FIRST:
			case FLATTEN:
			case FLOOR:
			case FOLLOWING:
			case FOR:
			case FROM:
			case FULL:
			case GROUP:
			case GROUPING:
			case HAVING:
			case IF:
			case ILIKE:
			case IN:
			case INNER:
			case INTERSECT:
			case INTERVAL:
			case IS:
			case JOIN:
			case LAST:
			case LATERAL:
			case LEFT:
			case LIKE:
			case LIMIT:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOG:
			case MAX:
			case MIN:
			case MOD:
			case NATURAL:
			case NOT:
			case NULL:
			case NULLS:
			case OFFSET:
			case ON:
			case OR:
			case ORDER:
			case OUTER:
			case OVER:
			case PARTITION:
			case PERCENT:
			case PRECEDING:
			case QUALIFY:
			case RANGE:
			case REGEXP:
			case RIGHT:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case SELECT:
			case SIMILAR:
			case SOME:
			case STDDEV:
			case SUBSTRING:
			case SUM:
			case TABLE:
			case THEN:
			case TIME:
			case TIMESTAMP:
			case TO:
			case TRIM:
			case TRY_CAST:
			case UNBOUNDED:
			case UNION:
			case USING:
			case VARIANCE:
			case WHEN:
			case WHERE:
			case WINDOW:
			case WITH:
			case WITHIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1122);
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
		public TerminalNode ABS() { return getToken(SnowflakeSqlParser.ABS, 0); }
		public TerminalNode ACOS() { return getToken(SnowflakeSqlParser.ACOS, 0); }
		public TerminalNode ACOSH() { return getToken(SnowflakeSqlParser.ACOSH, 0); }
		public TerminalNode ALL() { return getToken(SnowflakeSqlParser.ALL, 0); }
		public TerminalNode AND() { return getToken(SnowflakeSqlParser.AND, 0); }
		public TerminalNode ANY() { return getToken(SnowflakeSqlParser.ANY, 0); }
		public TerminalNode APPROXIMATE() { return getToken(SnowflakeSqlParser.APPROXIMATE, 0); }
		public TerminalNode AS() { return getToken(SnowflakeSqlParser.AS, 0); }
		public TerminalNode ASC() { return getToken(SnowflakeSqlParser.ASC, 0); }
		public TerminalNode ASIN() { return getToken(SnowflakeSqlParser.ASIN, 0); }
		public TerminalNode ASINH() { return getToken(SnowflakeSqlParser.ASINH, 0); }
		public TerminalNode AT() { return getToken(SnowflakeSqlParser.AT, 0); }
		public TerminalNode ATAN() { return getToken(SnowflakeSqlParser.ATAN, 0); }
		public TerminalNode ATAN2() { return getToken(SnowflakeSqlParser.ATAN2, 0); }
		public TerminalNode ATANH() { return getToken(SnowflakeSqlParser.ATANH, 0); }
		public TerminalNode AVG() { return getToken(SnowflakeSqlParser.AVG, 0); }
		public TerminalNode BETWEEN() { return getToken(SnowflakeSqlParser.BETWEEN, 0); }
		public TerminalNode BOTH() { return getToken(SnowflakeSqlParser.BOTH, 0); }
		public TerminalNode BY() { return getToken(SnowflakeSqlParser.BY, 0); }
		public TerminalNode CASE() { return getToken(SnowflakeSqlParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(SnowflakeSqlParser.CAST, 0); }
		public TerminalNode CEIL() { return getToken(SnowflakeSqlParser.CEIL, 0); }
		public TerminalNode CEILING() { return getToken(SnowflakeSqlParser.CEILING, 0); }
		public TerminalNode COALESCE() { return getToken(SnowflakeSqlParser.COALESCE, 0); }
		public TerminalNode COLLATE() { return getToken(SnowflakeSqlParser.COLLATE, 0); }
		public TerminalNode CONVERT_TIMEZONE() { return getToken(SnowflakeSqlParser.CONVERT_TIMEZONE, 0); }
		public TerminalNode COS() { return getToken(SnowflakeSqlParser.COS, 0); }
		public TerminalNode COSH() { return getToken(SnowflakeSqlParser.COSH, 0); }
		public TerminalNode COUNT() { return getToken(SnowflakeSqlParser.COUNT, 0); }
		public TerminalNode CUBE() { return getToken(SnowflakeSqlParser.CUBE, 0); }
		public TerminalNode CURRENT() { return getToken(SnowflakeSqlParser.CURRENT, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SnowflakeSqlParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SnowflakeSqlParser.CURRENT_TIME, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SnowflakeSqlParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode CURRENT_USER() { return getToken(SnowflakeSqlParser.CURRENT_USER, 0); }
		public TerminalNode DATEADD() { return getToken(SnowflakeSqlParser.DATEADD, 0); }
		public TerminalNode DATEDIFF() { return getToken(SnowflakeSqlParser.DATEDIFF, 0); }
		public TerminalNode DESC() { return getToken(SnowflakeSqlParser.DESC, 0); }
		public TerminalNode DISTINCT() { return getToken(SnowflakeSqlParser.DISTINCT, 0); }
		public TerminalNode ELSE() { return getToken(SnowflakeSqlParser.ELSE, 0); }
		public TerminalNode END() { return getToken(SnowflakeSqlParser.END, 0); }
		public TerminalNode ESCAPE() { return getToken(SnowflakeSqlParser.ESCAPE, 0); }
		public TerminalNode EXCEPT() { return getToken(SnowflakeSqlParser.EXCEPT, 0); }
		public TerminalNode EXCLUDE() { return getToken(SnowflakeSqlParser.EXCLUDE, 0); }
		public TerminalNode EXISTS() { return getToken(SnowflakeSqlParser.EXISTS, 0); }
		public TerminalNode EXTRACT() { return getToken(SnowflakeSqlParser.EXTRACT, 0); }
		public TerminalNode FIRST() { return getToken(SnowflakeSqlParser.FIRST, 0); }
		public TerminalNode FLATTEN() { return getToken(SnowflakeSqlParser.FLATTEN, 0); }
		public TerminalNode FLOOR() { return getToken(SnowflakeSqlParser.FLOOR, 0); }
		public TerminalNode FOLLOWING() { return getToken(SnowflakeSqlParser.FOLLOWING, 0); }
		public TerminalNode FOR() { return getToken(SnowflakeSqlParser.FOR, 0); }
		public TerminalNode FROM() { return getToken(SnowflakeSqlParser.FROM, 0); }
		public TerminalNode FULL() { return getToken(SnowflakeSqlParser.FULL, 0); }
		public TerminalNode GROUP() { return getToken(SnowflakeSqlParser.GROUP, 0); }
		public TerminalNode GROUPING() { return getToken(SnowflakeSqlParser.GROUPING, 0); }
		public TerminalNode HAVING() { return getToken(SnowflakeSqlParser.HAVING, 0); }
		public TerminalNode IF() { return getToken(SnowflakeSqlParser.IF, 0); }
		public TerminalNode ILIKE() { return getToken(SnowflakeSqlParser.ILIKE, 0); }
		public TerminalNode IN() { return getToken(SnowflakeSqlParser.IN, 0); }
		public TerminalNode INNER() { return getToken(SnowflakeSqlParser.INNER, 0); }
		public TerminalNode INTERSECT() { return getToken(SnowflakeSqlParser.INTERSECT, 0); }
		public TerminalNode INTERVAL() { return getToken(SnowflakeSqlParser.INTERVAL, 0); }
		public TerminalNode IS() { return getToken(SnowflakeSqlParser.IS, 0); }
		public TerminalNode JOIN() { return getToken(SnowflakeSqlParser.JOIN, 0); }
		public TerminalNode LAST() { return getToken(SnowflakeSqlParser.LAST, 0); }
		public TerminalNode LATERAL() { return getToken(SnowflakeSqlParser.LATERAL, 0); }
		public TerminalNode LEFT() { return getToken(SnowflakeSqlParser.LEFT, 0); }
		public TerminalNode LIKE() { return getToken(SnowflakeSqlParser.LIKE, 0); }
		public TerminalNode LIMIT() { return getToken(SnowflakeSqlParser.LIMIT, 0); }
		public TerminalNode LOCALTIME() { return getToken(SnowflakeSqlParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(SnowflakeSqlParser.LOCALTIMESTAMP, 0); }
		public TerminalNode LOG() { return getToken(SnowflakeSqlParser.LOG, 0); }
		public TerminalNode MAX() { return getToken(SnowflakeSqlParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(SnowflakeSqlParser.MIN, 0); }
		public TerminalNode MOD() { return getToken(SnowflakeSqlParser.MOD, 0); }
		public TerminalNode NATURAL() { return getToken(SnowflakeSqlParser.NATURAL, 0); }
		public TerminalNode NOT() { return getToken(SnowflakeSqlParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(SnowflakeSqlParser.NULL, 0); }
		public TerminalNode NULLS() { return getToken(SnowflakeSqlParser.NULLS, 0); }
		public TerminalNode OFFSET() { return getToken(SnowflakeSqlParser.OFFSET, 0); }
		public TerminalNode ON() { return getToken(SnowflakeSqlParser.ON, 0); }
		public TerminalNode OR() { return getToken(SnowflakeSqlParser.OR, 0); }
		public TerminalNode ORDER() { return getToken(SnowflakeSqlParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(SnowflakeSqlParser.OUTER, 0); }
		public TerminalNode OVER() { return getToken(SnowflakeSqlParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SnowflakeSqlParser.PARTITION, 0); }
		public TerminalNode PERCENT() { return getToken(SnowflakeSqlParser.PERCENT, 0); }
		public TerminalNode PRECEDING() { return getToken(SnowflakeSqlParser.PRECEDING, 0); }
		public TerminalNode QUALIFY() { return getToken(SnowflakeSqlParser.QUALIFY, 0); }
		public TerminalNode RANGE() { return getToken(SnowflakeSqlParser.RANGE, 0); }
		public TerminalNode REGEXP() { return getToken(SnowflakeSqlParser.REGEXP, 0); }
		public TerminalNode RIGHT() { return getToken(SnowflakeSqlParser.RIGHT, 0); }
		public TerminalNode RLIKE() { return getToken(SnowflakeSqlParser.RLIKE, 0); }
		public TerminalNode ROLLUP() { return getToken(SnowflakeSqlParser.ROLLUP, 0); }
		public TerminalNode ROW() { return getToken(SnowflakeSqlParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SnowflakeSqlParser.ROWS, 0); }
		public TerminalNode SELECT() { return getToken(SnowflakeSqlParser.SELECT, 0); }
		public TerminalNode SIMILAR() { return getToken(SnowflakeSqlParser.SIMILAR, 0); }
		public TerminalNode SOME() { return getToken(SnowflakeSqlParser.SOME, 0); }
		public TerminalNode STDDEV() { return getToken(SnowflakeSqlParser.STDDEV, 0); }
		public TerminalNode SUBSTRING() { return getToken(SnowflakeSqlParser.SUBSTRING, 0); }
		public TerminalNode SUM() { return getToken(SnowflakeSqlParser.SUM, 0); }
		public TerminalNode TABLE() { return getToken(SnowflakeSqlParser.TABLE, 0); }
		public TerminalNode THEN() { return getToken(SnowflakeSqlParser.THEN, 0); }
		public TerminalNode TIME() { return getToken(SnowflakeSqlParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SnowflakeSqlParser.TIMESTAMP, 0); }
		public TerminalNode TO() { return getToken(SnowflakeSqlParser.TO, 0); }
		public TerminalNode TRIM() { return getToken(SnowflakeSqlParser.TRIM, 0); }
		public TerminalNode TRY_CAST() { return getToken(SnowflakeSqlParser.TRY_CAST, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SnowflakeSqlParser.UNBOUNDED, 0); }
		public TerminalNode UNION() { return getToken(SnowflakeSqlParser.UNION, 0); }
		public TerminalNode USING() { return getToken(SnowflakeSqlParser.USING, 0); }
		public TerminalNode VARIANCE() { return getToken(SnowflakeSqlParser.VARIANCE, 0); }
		public TerminalNode WHEN() { return getToken(SnowflakeSqlParser.WHEN, 0); }
		public TerminalNode WHERE() { return getToken(SnowflakeSqlParser.WHERE, 0); }
		public TerminalNode WINDOW() { return getToken(SnowflakeSqlParser.WINDOW, 0); }
		public TerminalNode WITH() { return getToken(SnowflakeSqlParser.WITH, 0); }
		public TerminalNode WITHIN() { return getToken(SnowflakeSqlParser.WITHIN, 0); }
		public NonReservedKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReservedKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).enterNonReservedKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnowflakeSqlListener ) ((SnowflakeSqlListener)listener).exitNonReservedKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnowflakeSqlVisitor ) return ((SnowflakeSqlVisitor<? extends T>)visitor).visitNonReservedKeyword(this);
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
			setState(1125);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & -536870913L) != 0) || ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & 4610559566482767735L) != 0)) ) {
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
		case 30:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00c9\u0468\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u0001\u0001\u0001\u0003\u0001\u007f\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0084\b\u0001\n\u0001\f\u0001\u0087\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u008e\b\u0002"+
		"\n\u0002\f\u0002\u0091\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0095"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u009e\b\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00a2\b\u0003\u0001\u0003\u0003\u0003\u00a5\b\u0003\u0001\u0003"+
		"\u0003\u0003\u00a8\b\u0003\u0001\u0003\u0003\u0003\u00ab\b\u0003\u0001"+
		"\u0003\u0003\u0003\u00ae\b\u0003\u0001\u0003\u0003\u0003\u00b1\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00b8\b\u0005\n\u0005\f\u0005\u00bb\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00c1\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00c6\b\u0006\u0001\u0006\u0003\u0006\u00c9\b\u0006"+
		"\u0003\u0006\u00cb\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00d1\b\u0007\n\u0007\f\u0007\u00d4\t\u0007\u0001\b\u0001"+
		"\b\u0005\b\u00d8\b\b\n\b\f\b\u00db\t\b\u0001\t\u0001\t\u0003\t\u00df\b"+
		"\t\u0001\t\u0003\t\u00e2\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00e8"+
		"\b\t\n\t\f\t\u00eb\t\t\u0001\t\u0001\t\u0003\t\u00ef\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00f5\b\t\u0001\t\u0003\t\u00f8\b\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u00fe\b\t\n\t\f\t\u0101\t\t\u0001\t\u0001"+
		"\t\u0003\t\u0105\b\t\u0001\t\u0003\t\u0108\b\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u010f\b\t\u0001\t\u0003\t\u0112\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0118\b\t\n\t\f\t\u011b\t\t\u0001\t\u0001\t"+
		"\u0003\t\u011f\b\t\u0001\t\u0003\t\u0122\b\t\u0001\t\u0001\t\u0003\t\u0126"+
		"\b\t\u0001\t\u0003\t\u0129\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t"+
		"\u012f\b\t\n\t\f\t\u0132\t\t\u0001\t\u0001\t\u0003\t\u0136\b\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u013c\b\t\u0001\t\u0003\t\u013f\b\t\u0003"+
		"\t\u0141\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u0146\b\n\u0001\n\u0001\n"+
		"\u0005\n\u014a\b\n\n\n\f\n\u014d\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0003\f\u0154\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u015f\b\f\n\f\f\f\u0162\t\f"+
		"\u0001\f\u0001\f\u0003\f\u0166\b\f\u0001\f\u0001\f\u0003\f\u016a\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0170\b\f\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0175\b\r\u0001\r\u0003\r\u0178\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0182\b\u000f\n\u000f\f\u000f\u0185\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u018d\b\u0010\n"+
		"\u0010\f\u0010\u0190\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0199\b\u0010\n"+
		"\u0010\f\u0010\u019c\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u01a6"+
		"\b\u0010\n\u0010\f\u0010\u01a9\t\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u01ad\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u01b4\b\u0011\n\u0011\f\u0011\u01b7\t\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u01bb\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u01c7\b\u0014\n\u0014\f\u0014\u01ca\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u01d2\b\u0016\u0001\u0016\u0003\u0016\u01d5\b\u0016\u0001\u0016\u0003"+
		"\u0016\u01d8\b\u0016\u0001\u0016\u0003\u0016\u01db\b\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u01e4\b\u0017\n\u0017\f\u0017\u01e7\t\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01ee\b\u0018\n"+
		"\u0018\f\u0018\u01f1\t\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u01f5"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01f9\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0202\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u0210\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u021e\b\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0224\b\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u0245\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u024d\b\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u025c\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0262\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0267\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0005\u001e\u026e\b\u001e\n\u001e\f\u001e\u0271\t\u001e\u0003\u001e\u0273"+
		"\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0278\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u027c\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0282\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0290\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0294\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u029a\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u02a0\b\u001e\u0005\u001e\u02a2\b"+
		"\u001e\n\u001e\f\u001e\u02a5\t\u001e\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u02a9\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0004"+
		" \u02b2\b \u000b \f \u02b3\u0001 \u0001 \u0003 \u02b8\b \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0004!\u02c2\b!\u000b!\f!"+
		"\u02c3\u0001!\u0001!\u0003!\u02c8\b!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u02cf\b\"\u0001#\u0001#\u0001#\u0003#\u02d4\b#\u0001#\u0001"+
		"#\u0003#\u02d8\b#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0005"+
		"#\u02e1\b#\n#\f#\u02e4\t#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0003#\u02ed\b#\u0001#\u0001#\u0003#\u02f1\b#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u02f8\b#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0003#\u0301\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0003%\u030c\b%\u0001%\u0001%\u0005%\u0310\b%\n%\f%\u0313\t%"+
		"\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u031a\b&\u0001&\u0001&\u0001"+
		"&\u0003&\u031f\b&\u0001&\u0003&\u0322\b&\u0001&\u0001&\u0001&\u0003&\u0327"+
		"\b&\u0001&\u0003&\u032a\b&\u0001&\u0001&\u0001&\u0003&\u032f\b&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u0338\b&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u035f\b&\u0001&\u0003&\u0362"+
		"\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0003&\u036f\b&\u0001&\u0001&\u0003&\u0373\b&\u0001\'\u0001\'"+
		"\u0001\'\u0003\'\u0378\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0003"+
		"(\u037f\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0003)\u0386\b)\u0001)\u0001"+
		")\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0003,\u0390\b,\u0001-\u0001"+
		"-\u0003-\u0394\b-\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0003"+
		"0\u03a7\b0\u00011\u00011\u00031\u03ab\b1\u00011\u00011\u00011\u00011\u0005"+
		"1\u03b1\b1\n1\f1\u03b4\t1\u00031\u03b6\b1\u00011\u00011\u00011\u00011"+
		"\u00011\u00051\u03bd\b1\n1\f1\u03c0\t1\u00031\u03c2\b1\u00011\u00031\u03c5"+
		"\b1\u00012\u00012\u00032\u03c9\b2\u00012\u00012\u00012\u00012\u00052\u03cf"+
		"\b2\n2\f2\u03d2\t2\u00032\u03d4\b2\u00012\u00012\u00012\u00012\u00012"+
		"\u00052\u03db\b2\n2\f2\u03de\t2\u00032\u03e0\b2\u00012\u00032\u03e3\b"+
		"2\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u03ee\b4\u00014\u00034\u03f1\b4\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u0402\b4\u00014\u00034\u0405\b4\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u040c\b4\u00014\u00034\u040f\b4\u00014\u00014\u00014\u00014\u00034\u0415"+
		"\b4\u00014\u00014\u00014\u00014\u00034\u041b\b4\u00014\u00014\u00014\u0001"+
		"4\u00034\u0421\b4\u00014\u00014\u00014\u00014\u00034\u0427\b4\u00014\u0001"+
		"4\u00014\u00014\u00014\u00034\u042e\b4\u00014\u00014\u00014\u00014\u0003"+
		"4\u0434\b4\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u043c\b4\u0001"+
		"4\u00014\u00014\u00014\u00034\u0442\b4\u00014\u00014\u00014\u00014\u0003"+
		"4\u0448\b4\u00014\u00014\u00014\u00014\u00034\u044e\b4\u00014\u00014\u0001"+
		"4\u00014\u00034\u0454\b4\u00014\u00014\u00014\u00014\u00014\u00034\u045b"+
		"\b4\u00015\u00015\u00016\u00016\u00017\u00017\u00017\u00037\u0464\b7\u0001"+
		"8\u00018\u00018\u0000\u0001<9\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnp\u0000\u000b\u0002\u0000>>bb\u0003\u0000pp\u007f\u007f"+
		"\u009c\u009c\u0002\u0000CCaa\u0002\u0000jj||\u0002\u0000\u0099\u0099\u00a0"+
		"\u00a0\u0006\u0000JJWW\u0086\u0087\u00a5\u00a5\u00a7\u00a7\u00b3\u00b3"+
		"\u0003\u0000LL~~\u00ad\u00ad\u0002\u0000\u00bb\u00bb\u00bf\u00bf\u0002"+
		"\u0000*,\u008a\u008a\u0005\u0000\u0004\u0004*+-:??\u0090\u0090\t\u0000"+
		";WY}\u007f\u0081\u0083\u008c\u008e\u0095\u0097\u0099\u009b\u00a1\u00a3"+
		"\u00ac\u00ae\u00b8\u051c\u0000s\u0001\u0000\u0000\u0000\u0002|\u0001\u0000"+
		"\u0000\u0000\u0004\u0088\u0001\u0000\u0000\u0000\u0006\u009b\u0001\u0000"+
		"\u0000\u0000\b\u00b2\u0001\u0000\u0000\u0000\n\u00b4\u0001\u0000\u0000"+
		"\u0000\f\u00ca\u0001\u0000\u0000\u0000\u000e\u00cc\u0001\u0000\u0000\u0000"+
		"\u0010\u00d5\u0001\u0000\u0000\u0000\u0012\u0140\u0001\u0000\u0000\u0000"+
		"\u0014\u0142\u0001\u0000\u0000\u0000\u0016\u0150\u0001\u0000\u0000\u0000"+
		"\u0018\u016f\u0001\u0000\u0000\u0000\u001a\u0177\u0001\u0000\u0000\u0000"+
		"\u001c\u0179\u0001\u0000\u0000\u0000\u001e\u017c\u0001\u0000\u0000\u0000"+
		" \u01ac\u0001\u0000\u0000\u0000\"\u01ba\u0001\u0000\u0000\u0000$\u01bc"+
		"\u0001\u0000\u0000\u0000&\u01bf\u0001\u0000\u0000\u0000(\u01c2\u0001\u0000"+
		"\u0000\u0000*\u01cb\u0001\u0000\u0000\u0000,\u01cf\u0001\u0000\u0000\u0000"+
		".\u01de\u0001\u0000\u0000\u00000\u01e8\u0001\u0000\u0000\u00002\u01f2"+
		"\u0001\u0000\u0000\u00004\u01fa\u0001\u0000\u0000\u00006\u020f\u0001\u0000"+
		"\u0000\u00008\u021d\u0001\u0000\u0000\u0000:\u021f\u0001\u0000\u0000\u0000"+
		"<\u0244\u0001\u0000\u0000\u0000>\u02a8\u0001\u0000\u0000\u0000@\u02aa"+
		"\u0001\u0000\u0000\u0000B\u02bb\u0001\u0000\u0000\u0000D\u02ce\u0001\u0000"+
		"\u0000\u0000F\u0300\u0001\u0000\u0000\u0000H\u0302\u0001\u0000\u0000\u0000"+
		"J\u0308\u0001\u0000\u0000\u0000L\u0372\u0001\u0000\u0000\u0000N\u0377"+
		"\u0001\u0000\u0000\u0000P\u037e\u0001\u0000\u0000\u0000R\u0385\u0001\u0000"+
		"\u0000\u0000T\u0389\u0001\u0000\u0000\u0000V\u038b\u0001\u0000\u0000\u0000"+
		"X\u038f\u0001\u0000\u0000\u0000Z\u0393\u0001\u0000\u0000\u0000\\\u0395"+
		"\u0001\u0000\u0000\u0000^\u0397\u0001\u0000\u0000\u0000`\u03a6\u0001\u0000"+
		"\u0000\u0000b\u03c4\u0001\u0000\u0000\u0000d\u03e2\u0001\u0000\u0000\u0000"+
		"f\u03e4\u0001\u0000\u0000\u0000h\u045a\u0001\u0000\u0000\u0000j\u045c"+
		"\u0001\u0000\u0000\u0000l\u045e\u0001\u0000\u0000\u0000n\u0463\u0001\u0000"+
		"\u0000\u0000p\u0465\u0001\u0000\u0000\u0000rt\u0003\u0002\u0001\u0000"+
		"sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uw\u0003\u0006\u0003\u0000vx\u00030\u0018\u0000wv\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000y{\u0003:\u001d"+
		"\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0001\u0001"+
		"\u0000\u0000\u0000|~\u0005\u00b7\u0000\u0000}\u007f\u0005\u009a\u0000"+
		"\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0085\u0003\u0004\u0002\u0000\u0081"+
		"\u0082\u0005\u0001\u0000\u0000\u0082\u0084\u0003\u0004\u0002\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0003\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u0094\u0003n7\u0000\u0089\u008a\u0005\u0002\u0000\u0000\u008a\u008f\u0003"+
		"V+\u0000\u008b\u008c\u0005\u0001\u0000\u0000\u008c\u008e\u0003V+\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0005\u0003\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000"+
		"\u0094\u0089\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0005B\u0000\u0000\u0097"+
		"\u0098\u0005\u0002\u0000\u0000\u0098\u0099\u0003\u0000\u0000\u0000\u0099"+
		"\u009a\u0005\u0003\u0000\u0000\u009a\u0005\u0001\u0000\u0000\u0000\u009b"+
		"\u009d\u0005\u00a1\u0000\u0000\u009c\u009e\u0003\b\u0004\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0003\n\u0005\u0000\u00a0\u00a2\u0003"+
		"\u000e\u0007\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a5\u0003"+
		"\u001c\u000e\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a8\u0003"+
		"\u001e\u000f\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003"+
		"$\u0012\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00ae\u0003&\u0013"+
		"\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00b1\u0003(\u0014\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u0007\u0001\u0000\u0000\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000"+
		"\u00b3\t\u0001\u0000\u0000\u0000\u00b4\u00b9\u0003\f\u0006\u0000\u00b5"+
		"\u00b6\u0005\u0001\u0000\u0000\u00b6\u00b8\u0003\f\u0006\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u000b"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00cb"+
		"\u0005\u0004\u0000\u0000\u00bd\u00be\u0003P(\u0000\u00be\u00bf\u0005\u0005"+
		"\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00cb\u0005\u0004\u0000\u0000\u00c3\u00c8\u0003<\u001e"+
		"\u0000\u00c4\u00c6\u0005B\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c9\u0003X,\u0000\u00c8\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00bc"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c0\u0001\u0000\u0000\u0000\u00ca\u00c3"+
		"\u0001\u0000\u0000\u0000\u00cb\r\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"o\u0000\u0000\u00cd\u00d2\u0003\u0010\b\u0000\u00ce\u00cf\u0005\u0001"+
		"\u0000\u0000\u00cf\u00d1\u0003\u0010\b\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u000f\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d9\u0003\u0012\t\u0000"+
		"\u00d6\u00d8\u0003\u0018\f\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u0011\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e1\u0003P(\u0000\u00dd\u00df\u0005"+
		"B\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000"+
		"\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0003Z-\u0000"+
		"\u00e1\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00ee\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0002\u0000\u0000"+
		"\u00e4\u00e9\u0003X,\u0000\u00e5\u00e6\u0005\u0001\u0000\u0000\u00e6\u00e8"+
		"\u0003X,\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000"+
		"\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005\u0003\u0000\u0000\u00ed\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e3\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u0141\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0002"+
		"\u0000\u0000\u00f1\u00f2\u0003\u0000\u0000\u0000\u00f2\u00f7\u0005\u0003"+
		"\u0000\u0000\u00f3\u00f5\u0005B\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f8\u0003Z-\u0000\u00f7\u00f4\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u0104\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0005\u0002\u0000\u0000\u00fa\u00ff\u0003X,\u0000\u00fb\u00fc\u0005"+
		"\u0001\u0000\u0000\u00fc\u00fe\u0003X,\u0000\u00fd\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0102\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u0003\u0000"+
		"\u0000\u0103\u0105\u0001\u0000\u0000\u0000\u0104\u00f9\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0141\u0001\u0000\u0000"+
		"\u0000\u0106\u0108\u0005}\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0005\u0002\u0000\u0000\u010a\u010b\u0003\u0000\u0000\u0000"+
		"\u010b\u010c\u0005\u0003\u0000\u0000\u010c\u0111\u0001\u0000\u0000\u0000"+
		"\u010d\u010f\u0005B\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110"+
		"\u0112\u0003Z-\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u011e\u0001\u0000\u0000\u0000\u0113\u0114\u0005"+
		"\u0002\u0000\u0000\u0114\u0119\u0003X,\u0000\u0115\u0116\u0005\u0001\u0000"+
		"\u0000\u0116\u0118\u0003X,\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118"+
		"\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119"+
		"\u011a\u0001\u0000\u0000\u0000\u011a\u011c\u0001\u0000\u0000\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u0003\u0000\u0000\u011d"+
		"\u011f\u0001\u0000\u0000\u0000\u011e\u0113\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u0141\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u0005}\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0128"+
		"\u0003\u0014\n\u0000\u0124\u0126\u0005B\u0000\u0000\u0125\u0124\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0001"+
		"\u0000\u0000\u0000\u0127\u0129\u0003Z-\u0000\u0128\u0125\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u0135\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0005\u0002\u0000\u0000\u012b\u0130\u0003X,\u0000\u012c"+
		"\u012d\u0005\u0001\u0000\u0000\u012d\u012f\u0003X,\u0000\u012e\u012c\u0001"+
		"\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u012e\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0133\u0001"+
		"\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0134\u0005"+
		"\u0003\u0000\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u012a\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0141\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0005\u0002\u0000\u0000\u0138\u0139\u0003"+
		"\u0010\b\u0000\u0139\u013e\u0005\u0003\u0000\u0000\u013a\u013c\u0005B"+
		"\u0000\u0000\u013b\u013a\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013f\u0003Z-\u0000"+
		"\u013e\u013b\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000"+
		"\u013f\u0141\u0001\u0000\u0000\u0000\u0140\u00dc\u0001\u0000\u0000\u0000"+
		"\u0140\u00f0\u0001\u0000\u0000\u0000\u0140\u0107\u0001\u0000\u0000\u0000"+
		"\u0140\u0121\u0001\u0000\u0000\u0000\u0140\u0137\u0001\u0000\u0000\u0000"+
		"\u0141\u0013\u0001\u0000\u0000\u0000\u0142\u0143\u0003n7\u0000\u0143\u0145"+
		"\u0005\u0002\u0000\u0000\u0144\u0146\u0003\u0016\u000b\u0000\u0145\u0144"+
		"\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u014b"+
		"\u0001\u0000\u0000\u0000\u0147\u0148\u0005\u0001\u0000\u0000\u0148\u014a"+
		"\u0003\u0016\u000b\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014d"+
		"\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c"+
		"\u0001\u0000\u0000\u0000\u014c\u014e\u0001\u0000\u0000\u0000\u014d\u014b"+
		"\u0001\u0000\u0000\u0000\u014e\u014f\u0005\u0003\u0000\u0000\u014f\u0015"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0003<\u001e\u0000\u0151\u0017\u0001"+
		"\u0000\u0000\u0000\u0152\u0154\u0003\u001a\r\u0000\u0153\u0152\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000"+
		"\u0000\u0000\u0155\u0156\u0005{\u0000\u0000\u0156\u0165\u0003\u0010\b"+
		"\u0000\u0157\u0158\u0005\u008f\u0000\u0000\u0158\u0166\u0003<\u001e\u0000"+
		"\u0159\u015a\u0005\u00b2\u0000\u0000\u015a\u015b\u0005\u0002\u0000\u0000"+
		"\u015b\u0160\u0003V+\u0000\u015c\u015d\u0005\u0001\u0000\u0000\u015d\u015f"+
		"\u0003V+\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0005\u0003\u0000\u0000\u0164\u0166\u0001\u0000"+
		"\u0000\u0000\u0165\u0157\u0001\u0000\u0000\u0000\u0165\u0159\u0001\u0000"+
		"\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0170\u0001\u0000"+
		"\u0000\u0000\u0167\u0169\u0005\u0089\u0000\u0000\u0168\u016a\u0003\u001a"+
		"\r\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016c\u0005{\u0000\u0000"+
		"\u016c\u0170\u0003\u0010\b\u0000\u016d\u016e\u0005\u0001\u0000\u0000\u016e"+
		"\u0170\u0003\u0010\b\u0000\u016f\u0153\u0001\u0000\u0000\u0000\u016f\u0167"+
		"\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u0170\u0019"+
		"\u0001\u0000\u0000\u0000\u0171\u0178\u0005w\u0000\u0000\u0172\u0174\u0007"+
		"\u0001\u0000\u0000\u0173\u0175\u0005\u0092\u0000\u0000\u0174\u0173\u0001"+
		"\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0178\u0001"+
		"\u0000\u0000\u0000\u0176\u0178\u0005X\u0000\u0000\u0177\u0171\u0001\u0000"+
		"\u0000\u0000\u0177\u0172\u0001\u0000\u0000\u0000\u0177\u0176\u0001\u0000"+
		"\u0000\u0000\u0178\u001b\u0001\u0000\u0000\u0000\u0179\u017a\u0005\u00b5"+
		"\u0000\u0000\u017a\u017b\u0003<\u001e\u0000\u017b\u001d\u0001\u0000\u0000"+
		"\u0000\u017c\u017d\u0005q\u0000\u0000\u017d\u017e\u0005M\u0000\u0000\u017e"+
		"\u0183\u0003 \u0010\u0000\u017f\u0180\u0005\u0001\u0000\u0000\u0180\u0182"+
		"\u0003 \u0010\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0182\u0185\u0001"+
		"\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u001f\u0001\u0000\u0000\u0000\u0185\u0183\u0001"+
		"\u0000\u0000\u0000\u0186\u01ad\u0003<\u001e\u0000\u0187\u0188\u0005\u009e"+
		"\u0000\u0000\u0188\u0189\u0005\u0002\u0000\u0000\u0189\u018e\u0003<\u001e"+
		"\u0000\u018a\u018b\u0005\u0001\u0000\u0000\u018b\u018d\u0003<\u001e\u0000"+
		"\u018c\u018a\u0001\u0000\u0000\u0000\u018d\u0190\u0001\u0000\u0000\u0000"+
		"\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000"+
		"\u018f\u0191\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000"+
		"\u0191\u0192\u0005\u0003\u0000\u0000\u0192\u01ad\u0001\u0000\u0000\u0000"+
		"\u0193\u0194\u0005Y\u0000\u0000\u0194\u0195\u0005\u0002\u0000\u0000\u0195"+
		"\u019a\u0003<\u001e\u0000\u0196\u0197\u0005\u0001\u0000\u0000\u0197\u0199"+
		"\u0003<\u001e\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0199\u019c\u0001"+
		"\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u019b\u0001"+
		"\u0000\u0000\u0000\u019b\u019d\u0001\u0000\u0000\u0000\u019c\u019a\u0001"+
		"\u0000\u0000\u0000\u019d\u019e\u0005\u0003\u0000\u0000\u019e\u01ad\u0001"+
		"\u0000\u0000\u0000\u019f\u01a0\u0005r\u0000\u0000\u01a0\u01a1\u0005\u00a2"+
		"\u0000\u0000\u01a1\u01a2\u0005\u0002\u0000\u0000\u01a2\u01a7\u0003\"\u0011"+
		"\u0000\u01a3\u01a4\u0005\u0001\u0000\u0000\u01a4\u01a6\u0003\"\u0011\u0000"+
		"\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000"+
		"\u01a8\u01aa\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0005\u0003\u0000\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000"+
		"\u01ac\u0186\u0001\u0000\u0000\u0000\u01ac\u0187\u0001\u0000\u0000\u0000"+
		"\u01ac\u0193\u0001\u0000\u0000\u0000\u01ac\u019f\u0001\u0000\u0000\u0000"+
		"\u01ad!\u0001\u0000\u0000\u0000\u01ae\u01bb\u0003<\u001e\u0000\u01af\u01b0"+
		"\u0005\u0002\u0000\u0000\u01b0\u01b5\u0003<\u001e\u0000\u01b1\u01b2\u0005"+
		"\u0001\u0000\u0000\u01b2\u01b4\u0003<\u001e\u0000\u01b3\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005\u0003"+
		"\u0000\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01ae\u0001\u0000"+
		"\u0000\u0000\u01ba\u01af\u0001\u0000\u0000\u0000\u01bb#\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bd\u0005s\u0000\u0000\u01bd\u01be\u0003<\u001e\u0000\u01be"+
		"%\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u0098\u0000\u0000\u01c0\u01c1"+
		"\u0003<\u001e\u0000\u01c1\'\u0001\u0000\u0000\u0000\u01c2\u01c3\u0005"+
		"\u00b6\u0000\u0000\u01c3\u01c8\u0003*\u0015\u0000\u01c4\u01c5\u0005\u0001"+
		"\u0000\u0000\u01c5\u01c7\u0003*\u0015\u0000\u01c6\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c7\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9)\u0001\u0000\u0000\u0000"+
		"\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb\u01cc\u0003n7\u0000\u01cc\u01cd"+
		"\u0005B\u0000\u0000\u01cd\u01ce\u0003,\u0016\u0000\u01ce+\u0001\u0000"+
		"\u0000\u0000\u01cf\u01d1\u0005\u0002\u0000\u0000\u01d0\u01d2\u0003n7\u0000"+
		"\u01d1\u01d0\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d4\u0001\u0000\u0000\u0000\u01d3\u01d5\u0003.\u0017\u0000\u01d4"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d6\u01d8\u00030\u0018\u0000\u01d7\u01d6"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01da"+
		"\u0001\u0000\u0000\u0000\u01d9\u01db\u00034\u001a\u0000\u01da\u01d9\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0005\u0003\u0000\u0000\u01dd-\u0001\u0000"+
		"\u0000\u0000\u01de\u01df\u0005\u0094\u0000\u0000\u01df\u01e0\u0005M\u0000"+
		"\u0000\u01e0\u01e5\u0003<\u001e\u0000\u01e1\u01e2\u0005\u0001\u0000\u0000"+
		"\u01e2\u01e4\u0003<\u001e\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5"+
		"\u01e6\u0001\u0000\u0000\u0000\u01e6/\u0001\u0000\u0000\u0000\u01e7\u01e5"+
		"\u0001\u0000\u0000\u0000\u01e8\u01e9\u0005\u0091\u0000\u0000\u01e9\u01ea"+
		"\u0005M\u0000\u0000\u01ea\u01ef\u00032\u0019\u0000\u01eb\u01ec\u0005\u0001"+
		"\u0000\u0000\u01ec\u01ee\u00032\u0019\u0000\u01ed\u01eb\u0001\u0000\u0000"+
		"\u0000\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000"+
		"\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f01\u0001\u0000\u0000\u0000"+
		"\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f4\u0003<\u001e\u0000\u01f3"+
		"\u01f5\u0007\u0002\u0000\u0000\u01f4\u01f3\u0001\u0000\u0000\u0000\u01f4"+
		"\u01f5\u0001\u0000\u0000\u0000\u01f5\u01f8\u0001\u0000\u0000\u0000\u01f6"+
		"\u01f7\u0005\u008c\u0000\u0000\u01f7\u01f9\u0007\u0003\u0000\u0000\u01f8"+
		"\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000\u01f9"+
		"3\u0001\u0000\u0000\u0000\u01fa\u0201\u0007\u0004\u0000\u0000\u01fb\u0202"+
		"\u00036\u001b\u0000\u01fc\u01fd\u0005K\u0000\u0000\u01fd\u01fe\u00036"+
		"\u001b\u0000\u01fe\u01ff\u0005?\u0000\u0000\u01ff\u0200\u00038\u001c\u0000"+
		"\u0200\u0202\u0001\u0000\u0000\u0000\u0201\u01fb\u0001\u0000\u0000\u0000"+
		"\u0201\u01fc\u0001\u0000\u0000\u0000\u02025\u0001\u0000\u0000\u0000\u0203"+
		"\u0204\u0005\u00b0\u0000\u0000\u0204\u0210\u0005\u0097\u0000\u0000\u0205"+
		"\u0206\u0003<\u001e\u0000\u0206\u0207\u0005\u0097\u0000\u0000\u0207\u0210"+
		"\u0001\u0000\u0000\u0000\u0208\u0209\u0005Z\u0000\u0000\u0209\u0210\u0005"+
		"\u009f\u0000\u0000\u020a\u020b\u0003<\u001e\u0000\u020b\u020c\u0005m\u0000"+
		"\u0000\u020c\u0210\u0001\u0000\u0000\u0000\u020d\u020e\u0005\u00b0\u0000"+
		"\u0000\u020e\u0210\u0005m\u0000\u0000\u020f\u0203\u0001\u0000\u0000\u0000"+
		"\u020f\u0205\u0001\u0000\u0000\u0000\u020f\u0208\u0001\u0000\u0000\u0000"+
		"\u020f\u020a\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000\u0000\u0000"+
		"\u02107\u0001\u0000\u0000\u0000\u0211\u0212\u0005\u00b0\u0000\u0000\u0212"+
		"\u021e\u0005\u0097\u0000\u0000\u0213\u0214\u0003<\u001e\u0000\u0214\u0215"+
		"\u0005\u0097\u0000\u0000\u0215\u021e\u0001\u0000\u0000\u0000\u0216\u0217"+
		"\u0005Z\u0000\u0000\u0217\u021e\u0005\u009f\u0000\u0000\u0218\u0219\u0003"+
		"<\u001e\u0000\u0219\u021a\u0005m\u0000\u0000\u021a\u021e\u0001\u0000\u0000"+
		"\u0000\u021b\u021c\u0005\u00b0\u0000\u0000\u021c\u021e\u0005m\u0000\u0000"+
		"\u021d\u0211\u0001\u0000\u0000\u0000\u021d\u0213\u0001\u0000\u0000\u0000"+
		"\u021d\u0216\u0001\u0000\u0000\u0000\u021d\u0218\u0001\u0000\u0000\u0000"+
		"\u021d\u021b\u0001\u0000\u0000\u0000\u021e9\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0005\u0081\u0000\u0000\u0220\u0223\u0003<\u001e\u0000\u0221\u0222"+
		"\u0005\u008e\u0000\u0000\u0222\u0224\u0003<\u001e\u0000\u0223\u0221\u0001"+
		"\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224;\u0001\u0000"+
		"\u0000\u0000\u0225\u0226\u0006\u001e\uffff\uffff\u0000\u0226\u0245\u0003"+
		"`0\u0000\u0227\u0245\u0003N\'\u0000\u0228\u0245\u0003D\"\u0000\u0229\u0245"+
		"\u0003>\u001f\u0000\u022a\u022b\u0005\u0002\u0000\u0000\u022b\u022c\u0003"+
		"<\u001e\u0000\u022c\u022d\u0005\u0003\u0000\u0000\u022d\u0245\u0001\u0000"+
		"\u0000\u0000\u022e\u022f\u0003j5\u0000\u022f\u0230\u0003<\u001e\u000f"+
		"\u0230\u0245\u0001\u0000\u0000\u0000\u0231\u0232\u0005h\u0000\u0000\u0232"+
		"\u0233\u0005\u0002\u0000\u0000\u0233\u0234\u0003\u0000\u0000\u0000\u0234"+
		"\u0235\u0005\u0003\u0000\u0000\u0235\u0245\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u0005O\u0000\u0000\u0237\u0238\u0005\u0002\u0000\u0000\u0238\u0239"+
		"\u0003<\u001e\u0000\u0239\u023a\u0005B\u0000\u0000\u023a\u023b\u0003h"+
		"4\u0000\u023b\u023c\u0005\u0003\u0000\u0000\u023c\u0245\u0001\u0000\u0000"+
		"\u0000\u023d\u023e\u0005\u00af\u0000\u0000\u023e\u023f\u0005\u0002\u0000"+
		"\u0000\u023f\u0240\u0003<\u001e\u0000\u0240\u0241\u0005B\u0000\u0000\u0241"+
		"\u0242\u0003h4\u0000\u0242\u0243\u0005\u0003\u0000\u0000\u0243\u0245\u0001"+
		"\u0000\u0000\u0000\u0244\u0225\u0001\u0000\u0000\u0000\u0244\u0227\u0001"+
		"\u0000\u0000\u0000\u0244\u0228\u0001\u0000\u0000\u0000\u0244\u0229\u0001"+
		"\u0000\u0000\u0000\u0244\u022a\u0001\u0000\u0000\u0000\u0244\u022e\u0001"+
		"\u0000\u0000\u0000\u0244\u0231\u0001\u0000\u0000\u0000\u0244\u0236\u0001"+
		"\u0000\u0000\u0000\u0244\u023d\u0001\u0000\u0000\u0000\u0245\u02a3\u0001"+
		"\u0000\u0000\u0000\u0246\u0247\n\u0010\u0000\u0000\u0247\u0248\u0003l"+
		"6\u0000\u0248\u0249\u0003<\u001e\u0011\u0249\u02a2\u0001\u0000\u0000\u0000"+
		"\u024a\u024c\n\r\u0000\u0000\u024b\u024d\u0005\u008a\u0000\u0000\u024c"+
		"\u024b\u0001\u0000\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d"+
		"\u024e\u0001\u0000\u0000\u0000\u024e\u024f\u0005K\u0000\u0000\u024f\u0250"+
		"\u0003<\u001e\u0000\u0250\u0251\u0005?\u0000\u0000\u0251\u0252\u0003<"+
		"\u001e\u000e\u0252\u02a2\u0001\u0000\u0000\u0000\u0253\u0254\n\u0003\u0000"+
		"\u0000\u0254\u0255\u0005\u009d\u0000\u0000\u0255\u02a2\u0003<\u001e\u0004"+
		"\u0256\u0257\n\u0002\u0000\u0000\u0257\u025b\u0005F\u0000\u0000\u0258"+
		"\u0259\u0005\u00aa\u0000\u0000\u0259\u025c\u0005\u00b9\u0000\u0000\u025a"+
		"\u025c\u0005\u00ab\u0000\u0000\u025b\u0258\u0001\u0000\u0000\u0000\u025b"+
		"\u025a\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000\u0000\u025d"+
		"\u02a2\u0003<\u001e\u0003\u025e\u025f\n\u000e\u0000\u0000\u025f\u0261"+
		"\u0005z\u0000\u0000\u0260\u0262\u0005\u008a\u0000\u0000\u0261\u0260\u0001"+
		"\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262\u0263\u0001"+
		"\u0000\u0000\u0000\u0263\u02a2\u0005\u008b\u0000\u0000\u0264\u0266\n\f"+
		"\u0000\u0000\u0265\u0267\u0005\u008a\u0000\u0000\u0266\u0265\u0001\u0000"+
		"\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000"+
		"\u0000\u0000\u0268\u0277\u0005v\u0000\u0000\u0269\u0272\u0005\u0002\u0000"+
		"\u0000\u026a\u026f\u0003<\u001e\u0000\u026b\u026c\u0005\u0001\u0000\u0000"+
		"\u026c\u026e\u0003<\u001e\u0000\u026d\u026b\u0001\u0000\u0000\u0000\u026e"+
		"\u0271\u0001\u0000\u0000\u0000\u026f\u026d\u0001\u0000\u0000\u0000\u026f"+
		"\u0270\u0001\u0000\u0000\u0000\u0270\u0273\u0001\u0000\u0000\u0000\u0271"+
		"\u026f\u0001\u0000\u0000\u0000\u0272\u026a\u0001\u0000\u0000\u0000\u0272"+
		"\u0273\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274"+
		"\u0278\u0005\u0003\u0000\u0000\u0275\u0278\u0003\u0000\u0000\u0000\u0276"+
		"\u0278\u0003P(\u0000\u0277\u0269\u0001\u0000\u0000\u0000\u0277\u0275\u0001"+
		"\u0000\u0000\u0000\u0277\u0276\u0001\u0000\u0000\u0000\u0278\u02a2\u0001"+
		"\u0000\u0000\u0000\u0279\u027b\n\u000b\u0000\u0000\u027a\u027c\u0005\u008a"+
		"\u0000\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027b\u027c\u0001\u0000"+
		"\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d\u027e\u0005\u0080"+
		"\u0000\u0000\u027e\u0281\u0003<\u001e\u0000\u027f\u0280\u0005e\u0000\u0000"+
		"\u0280\u0282\u0003<\u001e\u0000\u0281\u027f\u0001\u0000\u0000\u0000\u0281"+
		"\u0282\u0001\u0000\u0000\u0000\u0282\u02a2\u0001\u0000\u0000\u0000\u0283"+
		"\u0284\n\u0007\u0000\u0000\u0284\u0285\u0005S\u0000\u0000\u0285\u02a2"+
		"\u0003^/\u0000\u0286\u0287\n\u0006\u0000\u0000\u0287\u0288\u0005\u0006"+
		"\u0000\u0000\u0288\u02a2\u0003h4\u0000\u0289\u028a\n\u0005\u0000\u0000"+
		"\u028a\u028b\u0005\u00a3\u0000\u0000\u028b\u028c\u0005\u00ac\u0000\u0000"+
		"\u028c\u028f\u0003<\u001e\u0000\u028d\u028e\u0005e\u0000\u0000\u028e\u0290"+
		"\u0003<\u001e\u0000\u028f\u028d\u0001\u0000\u0000\u0000\u028f\u0290\u0001"+
		"\u0000\u0000\u0000\u0290\u02a2\u0001\u0000\u0000\u0000\u0291\u0293\n\u0004"+
		"\u0000\u0000\u0292\u0294\u0005\u008a\u0000\u0000\u0293\u0292\u0001\u0000"+
		"\u0000\u0000\u0293\u0294\u0001\u0000\u0000\u0000\u0294\u0295\u0001\u0000"+
		"\u0000\u0000\u0295\u0296\u0005u\u0000\u0000\u0296\u0299\u0003<\u001e\u0000"+
		"\u0297\u0298\u0005e\u0000\u0000\u0298\u029a\u0003<\u001e\u0000\u0299\u0297"+
		"\u0001\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a\u02a2"+
		"\u0001\u0000\u0000\u0000\u029b\u029c\n\u0001\u0000\u0000\u029c\u029f\u0005"+
		"\u0093\u0000\u0000\u029d\u02a0\u0003\\.\u0000\u029e\u02a0\u0003,\u0016"+
		"\u0000\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u029e\u0001\u0000\u0000"+
		"\u0000\u02a0\u02a2\u0001\u0000\u0000\u0000\u02a1\u0246\u0001\u0000\u0000"+
		"\u0000\u02a1\u024a\u0001\u0000\u0000\u0000\u02a1\u0253\u0001\u0000\u0000"+
		"\u0000\u02a1\u0256\u0001\u0000\u0000\u0000\u02a1\u025e\u0001\u0000\u0000"+
		"\u0000\u02a1\u0264\u0001\u0000\u0000\u0000\u02a1\u0279\u0001\u0000\u0000"+
		"\u0000\u02a1\u0283\u0001\u0000\u0000\u0000\u02a1\u0286\u0001\u0000\u0000"+
		"\u0000\u02a1\u0289\u0001\u0000\u0000\u0000\u02a1\u0291\u0001\u0000\u0000"+
		"\u0000\u02a1\u029b\u0001\u0000\u0000\u0000\u02a2\u02a5\u0001\u0000\u0000"+
		"\u0000\u02a3\u02a1\u0001\u0000\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000"+
		"\u0000\u02a4=\u0001\u0000\u0000\u0000\u02a5\u02a3\u0001\u0000\u0000\u0000"+
		"\u02a6\u02a9\u0003@ \u0000\u02a7\u02a9\u0003B!\u0000\u02a8\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a9?\u0001\u0000"+
		"\u0000\u0000\u02aa\u02ab\u0005N\u0000\u0000\u02ab\u02b1\u0003<\u001e\u0000"+
		"\u02ac\u02ad\u0005\u00b4\u0000\u0000\u02ad\u02ae\u0003<\u001e\u0000\u02ae"+
		"\u02af\u0005\u00a9\u0000\u0000\u02af\u02b0\u0003<\u001e\u0000\u02b0\u02b2"+
		"\u0001\u0000\u0000\u0000\u02b1\u02ac\u0001\u0000\u0000\u0000\u02b2\u02b3"+
		"\u0001\u0000\u0000\u0000\u02b3\u02b1\u0001\u0000\u0000\u0000\u02b3\u02b4"+
		"\u0001\u0000\u0000\u0000\u02b4\u02b7\u0001\u0000\u0000\u0000\u02b5\u02b6"+
		"\u0005c\u0000\u0000\u02b6\u02b8\u0003<\u001e\u0000\u02b7\u02b5\u0001\u0000"+
		"\u0000\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8\u02b9\u0001\u0000"+
		"\u0000\u0000\u02b9\u02ba\u0005d\u0000\u0000\u02baA\u0001\u0000\u0000\u0000"+
		"\u02bb\u02c1\u0005N\u0000\u0000\u02bc\u02bd\u0005\u00b4\u0000\u0000\u02bd"+
		"\u02be\u0003<\u001e\u0000\u02be\u02bf\u0005\u00a9\u0000\u0000\u02bf\u02c0"+
		"\u0003<\u001e\u0000\u02c0\u02c2\u0001\u0000\u0000\u0000\u02c1\u02bc\u0001"+
		"\u0000\u0000\u0000\u02c2\u02c3\u0001\u0000\u0000\u0000\u02c3\u02c1\u0001"+
		"\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4\u02c7\u0001"+
		"\u0000\u0000\u0000\u02c5\u02c6\u0005c\u0000\u0000\u02c6\u02c8\u0003<\u001e"+
		"\u0000\u02c7\u02c5\u0001\u0000\u0000\u0000\u02c7\u02c8\u0001\u0000\u0000"+
		"\u0000\u02c8\u02c9\u0001\u0000\u0000\u0000\u02c9\u02ca\u0005d\u0000\u0000"+
		"\u02caC\u0001\u0000\u0000\u0000\u02cb\u02cf\u0003F#\u0000\u02cc\u02cf"+
		"\u0003J%\u0000\u02cd\u02cf\u0003L&\u0000\u02ce\u02cb\u0001\u0000\u0000"+
		"\u0000\u02ce\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cd\u0001\u0000\u0000"+
		"\u0000\u02cfE\u0001\u0000\u0000\u0000\u02d0\u02d1\u0007\u0005\u0000\u0000"+
		"\u02d1\u02d3\u0005\u0002\u0000\u0000\u02d2\u02d4\u0007\u0000\u0000\u0000"+
		"\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000\u0000\u0000"+
		"\u02d4\u02d7\u0001\u0000\u0000\u0000\u02d5\u02d8\u0003<\u001e\u0000\u02d6"+
		"\u02d8\u0005\u0004\u0000\u0000\u02d7\u02d5\u0001\u0000\u0000\u0000\u02d7"+
		"\u02d6\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9"+
		"\u0301\u0005\u0003\u0000\u0000\u02da\u02db\u0005W\u0000\u0000\u02db\u02dc"+
		"\u0005\u0002\u0000\u0000\u02dc\u02dd\u0005b\u0000\u0000\u02dd\u02e2\u0003"+
		"<\u001e\u0000\u02de\u02df\u0005\u0001\u0000\u0000\u02df\u02e1\u0003<\u001e"+
		"\u0000\u02e0\u02de\u0001\u0000\u0000\u0000\u02e1\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e2\u02e0\u0001\u0000\u0000\u0000\u02e2\u02e3\u0001\u0000\u0000"+
		"\u0000\u02e3\u02e5\u0001\u0000\u0000\u0000\u02e4\u02e2\u0001\u0000\u0000"+
		"\u0000\u02e5\u02e6\u0005\u0003\u0000\u0000\u02e6\u0301\u0001\u0000\u0000"+
		"\u0000\u02e7\u02e8\u0005\u0082\u0000\u0000\u02e8\u02e9\u0005\u0002\u0000"+
		"\u0000\u02e9\u02ec\u0003<\u001e\u0000\u02ea\u02eb\u0005\u0001\u0000\u0000"+
		"\u02eb\u02ed\u0005\u00bf\u0000\u0000\u02ec\u02ea\u0001\u0000\u0000\u0000"+
		"\u02ec\u02ed\u0001\u0000\u0000\u0000\u02ed\u02ee\u0001\u0000\u0000\u0000"+
		"\u02ee\u02f0\u0005\u0003\u0000\u0000\u02ef\u02f1\u0003H$\u0000\u02f0\u02ef"+
		"\u0001\u0000\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000\u02f1\u0301"+
		"\u0001\u0000\u0000\u0000\u02f2\u02f3\u0005\u00ba\u0000\u0000\u02f3\u02f4"+
		"\u0005\u0002\u0000\u0000\u02f4\u02f5\u0003<\u001e\u0000\u02f5\u02f7\u0005"+
		"\u0003\u0000\u0000\u02f6\u02f8\u0003H$\u0000\u02f7\u02f6\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8\u0301\u0001\u0000\u0000"+
		"\u0000\u02f9\u02fa\u0005\u008d\u0000\u0000\u02fa\u02fb\u0005\u0002\u0000"+
		"\u0000\u02fb\u02fc\u0003<\u001e\u0000\u02fc\u02fd\u0005\u0001\u0000\u0000"+
		"\u02fd\u02fe\u0003<\u001e\u0000\u02fe\u02ff\u0005\u0003\u0000\u0000\u02ff"+
		"\u0301\u0001\u0000\u0000\u0000\u0300\u02d0\u0001\u0000\u0000\u0000\u0300"+
		"\u02da\u0001\u0000\u0000\u0000\u0300\u02e7\u0001\u0000\u0000\u0000\u0300"+
		"\u02f2\u0001\u0000\u0000\u0000\u0300\u02f9\u0001\u0000\u0000\u0000\u0301"+
		"G\u0001\u0000\u0000\u0000\u0302\u0303\u0005\u00b8\u0000\u0000\u0303\u0304"+
		"\u0005q\u0000\u0000\u0304\u0305\u0005\u0002\u0000\u0000\u0305\u0306\u0003"+
		"0\u0018\u0000\u0306\u0307\u0005\u0003\u0000\u0000\u0307I\u0001\u0000\u0000"+
		"\u0000\u0308\u0309\u0003n7\u0000\u0309\u030b\u0005\u0002\u0000\u0000\u030a"+
		"\u030c\u0003\u0016\u000b\u0000\u030b\u030a\u0001\u0000\u0000\u0000\u030b"+
		"\u030c\u0001\u0000\u0000\u0000\u030c\u0311\u0001\u0000\u0000\u0000\u030d"+
		"\u030e\u0005\u0001\u0000\u0000\u030e\u0310\u0003\u0016\u000b\u0000\u030f"+
		"\u030d\u0001\u0000\u0000\u0000\u0310\u0313\u0001\u0000\u0000\u0000\u0311"+
		"\u030f\u0001\u0000\u0000\u0000\u0311\u0312\u0001\u0000\u0000\u0000\u0312"+
		"\u0314\u0001\u0000\u0000\u0000\u0313\u0311\u0001\u0000\u0000\u0000\u0314"+
		"\u0315\u0005\u0003\u0000\u0000\u0315K\u0001\u0000\u0000\u0000\u0316\u0319"+
		"\u0005[\u0000\u0000\u0317\u0318\u0005\u0002\u0000\u0000\u0318\u031a\u0005"+
		"\u0003\u0000\u0000\u0319\u0317\u0001\u0000\u0000\u0000\u0319\u031a\u0001"+
		"\u0000\u0000\u0000\u031a\u0373\u0001\u0000\u0000\u0000\u031b\u0321\u0005"+
		"\\\u0000\u0000\u031c\u031e\u0005\u0002\u0000\u0000\u031d\u031f\u0003<"+
		"\u001e\u0000\u031e\u031d\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000"+
		"\u0000\u0000\u031f\u0320\u0001\u0000\u0000\u0000\u0320\u0322\u0005\u0003"+
		"\u0000\u0000\u0321\u031c\u0001\u0000\u0000\u0000\u0321\u0322\u0001\u0000"+
		"\u0000\u0000\u0322\u0373\u0001\u0000\u0000\u0000\u0323\u0329\u0005]\u0000"+
		"\u0000\u0324\u0326\u0005\u0002\u0000\u0000\u0325\u0327\u0003<\u001e\u0000"+
		"\u0326\u0325\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000"+
		"\u0327\u0328\u0001\u0000\u0000\u0000\u0328\u032a\u0005\u0003\u0000\u0000"+
		"\u0329\u0324\u0001\u0000\u0000\u0000\u0329\u032a\u0001\u0000\u0000\u0000"+
		"\u032a\u0373\u0001\u0000\u0000\u0000\u032b\u032e\u0005^\u0000\u0000\u032c"+
		"\u032d\u0005\u0002\u0000\u0000\u032d\u032f\u0005\u0003\u0000\u0000\u032e"+
		"\u032c\u0001\u0000\u0000\u0000\u032e\u032f\u0001\u0000\u0000\u0000\u032f"+
		"\u0373\u0001\u0000\u0000\u0000\u0330\u0331\u0005\u00a6\u0000\u0000\u0331"+
		"\u0332\u0005\u0002\u0000\u0000\u0332\u0333\u0003<\u001e\u0000\u0333\u0334"+
		"\u0005o\u0000\u0000\u0334\u0337\u0003<\u001e\u0000\u0335\u0336\u0005n"+
		"\u0000\u0000\u0336\u0338\u0003<\u001e\u0000\u0337\u0335\u0001\u0000\u0000"+
		"\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000\u0000"+
		"\u0000\u0339\u033a\u0005\u0003\u0000\u0000\u033a\u0373\u0001\u0000\u0000"+
		"\u0000\u033b\u033c\u0005i\u0000\u0000\u033c\u033d\u0005\u0002\u0000\u0000"+
		"\u033d\u033e\u0003n7\u0000\u033e\u033f\u0005o\u0000\u0000\u033f\u0340"+
		"\u0003<\u001e\u0000\u0340\u0341\u0005\u0003\u0000\u0000\u0341\u0373\u0001"+
		"\u0000\u0000\u0000\u0342\u0343\u0005\u0096\u0000\u0000\u0343\u0344\u0005"+
		"\u0002\u0000\u0000\u0344\u0345\u0003<\u001e\u0000\u0345\u0346\u0005v\u0000"+
		"\u0000\u0346\u0347\u0003<\u001e\u0000\u0347\u0348\u0005\u0003\u0000\u0000"+
		"\u0348\u0373\u0001\u0000\u0000\u0000\u0349\u034a\u0005_\u0000\u0000\u034a"+
		"\u034b\u0005\u0002\u0000\u0000\u034b\u034c\u0003n7\u0000\u034c\u034d\u0005"+
		"\u0001\u0000\u0000\u034d\u034e\u0003<\u001e\u0000\u034e\u034f\u0005\u0001"+
		"\u0000\u0000\u034f\u0350\u0003<\u001e\u0000\u0350\u0351\u0005\u0003\u0000"+
		"\u0000\u0351\u0373\u0001\u0000\u0000\u0000\u0352\u0353\u0005`\u0000\u0000"+
		"\u0353\u0354\u0005\u0002\u0000\u0000\u0354\u0355\u0003n7\u0000\u0355\u0356"+
		"\u0005\u0001\u0000\u0000\u0356\u0357\u0003<\u001e\u0000\u0357\u0358\u0005"+
		"\u0001\u0000\u0000\u0358\u0359\u0003<\u001e\u0000\u0359\u035a\u0005\u0003"+
		"\u0000\u0000\u035a\u0373\u0001\u0000\u0000\u0000\u035b\u035c\u0005\u00ae"+
		"\u0000\u0000\u035c\u035e\u0005\u0002\u0000\u0000\u035d\u035f\u0007\u0006"+
		"\u0000\u0000\u035e\u035d\u0001\u0000\u0000\u0000\u035e\u035f\u0001\u0000"+
		"\u0000\u0000\u035f\u0361\u0001\u0000\u0000\u0000\u0360\u0362\u0003<\u001e"+
		"\u0000\u0361\u0360\u0001\u0000\u0000\u0000\u0361\u0362\u0001\u0000\u0000"+
		"\u0000\u0362\u0363\u0001\u0000\u0000\u0000\u0363\u0364\u0005o\u0000\u0000"+
		"\u0364\u0365\u0003<\u001e\u0000\u0365\u0366\u0005\u0003\u0000\u0000\u0366"+
		"\u0373\u0001\u0000\u0000\u0000\u0367\u0368\u0005T\u0000\u0000\u0368\u0369"+
		"\u0005\u0002\u0000\u0000\u0369\u036a\u0003<\u001e\u0000\u036a\u036b\u0005"+
		"\u0001\u0000\u0000\u036b\u036e\u0003<\u001e\u0000\u036c\u036d\u0005\u0001"+
		"\u0000\u0000\u036d\u036f\u0003<\u001e\u0000\u036e\u036c\u0001\u0000\u0000"+
		"\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0370\u0001\u0000\u0000"+
		"\u0000\u0370\u0371\u0005\u0003\u0000\u0000\u0371\u0373\u0001\u0000\u0000"+
		"\u0000\u0372\u0316\u0001\u0000\u0000\u0000\u0372\u031b\u0001\u0000\u0000"+
		"\u0000\u0372\u0323\u0001\u0000\u0000\u0000\u0372\u032b\u0001\u0000\u0000"+
		"\u0000\u0372\u0330\u0001\u0000\u0000\u0000\u0372\u033b\u0001\u0000\u0000"+
		"\u0000\u0372\u0342\u0001\u0000\u0000\u0000\u0372\u0349\u0001\u0000\u0000"+
		"\u0000\u0372\u0352\u0001\u0000\u0000\u0000\u0372\u035b\u0001\u0000\u0000"+
		"\u0000\u0372\u0367\u0001\u0000\u0000\u0000\u0373M\u0001\u0000\u0000\u0000"+
		"\u0374\u0375\u0003P(\u0000\u0375\u0376\u0005\u0005\u0000\u0000\u0376\u0378"+
		"\u0001\u0000\u0000\u0000\u0377\u0374\u0001\u0000\u0000\u0000\u0377\u0378"+
		"\u0001\u0000\u0000\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379\u037a"+
		"\u0003V+\u0000\u037aO\u0001\u0000\u0000\u0000\u037b\u037c\u0003R)\u0000"+
		"\u037c\u037d\u0005\u0005\u0000\u0000\u037d\u037f\u0001\u0000\u0000\u0000"+
		"\u037e\u037b\u0001\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000"+
		"\u037f\u0380\u0001\u0000\u0000\u0000\u0380\u0381\u0003n7\u0000\u0381Q"+
		"\u0001\u0000\u0000\u0000\u0382\u0383\u0003T*\u0000\u0383\u0384\u0005\u0005"+
		"\u0000\u0000\u0384\u0386\u0001\u0000\u0000\u0000\u0385\u0382\u0001\u0000"+
		"\u0000\u0000\u0385\u0386\u0001\u0000\u0000\u0000\u0386\u0387\u0001\u0000"+
		"\u0000\u0000\u0387\u0388\u0003n7\u0000\u0388S\u0001\u0000\u0000\u0000"+
		"\u0389\u038a\u0003n7\u0000\u038aU\u0001\u0000\u0000\u0000\u038b\u038c"+
		"\u0003n7\u0000\u038cW\u0001\u0000\u0000\u0000\u038d\u0390\u0003n7\u0000"+
		"\u038e\u0390\u0005\u00bf\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000"+
		"\u038f\u038e\u0001\u0000\u0000\u0000\u0390Y\u0001\u0000\u0000\u0000\u0391"+
		"\u0394\u0003n7\u0000\u0392\u0394\u0005\u00bf\u0000\u0000\u0393\u0391\u0001"+
		"\u0000\u0000\u0000\u0393\u0392\u0001\u0000\u0000\u0000\u0394[\u0001\u0000"+
		"\u0000\u0000\u0395\u0396\u0003n7\u0000\u0396]\u0001\u0000\u0000\u0000"+
		"\u0397\u0398\u0003n7\u0000\u0398_\u0001\u0000\u0000\u0000\u0399\u03a7"+
		"\u0005\u008b\u0000\u0000\u039a\u03a7\u0005\u00bd\u0000\u0000\u039b\u03a7"+
		"\u0005\u00be\u0000\u0000\u039c\u03a7\u0005\u00bf\u0000\u0000\u039d\u03a7"+
		"\u0005\u00c0\u0000\u0000\u039e\u03a7\u0005\u00c1\u0000\u0000\u039f\u03a7"+
		"\u0005\u00c2\u0000\u0000\u03a0\u03a7\u0005\u00c3\u0000\u0000\u03a1\u03a7"+
		"\u0005\u00c4\u0000\u0000\u03a2\u03a7\u0005\u00c5\u0000\u0000\u03a3\u03a7"+
		"\u0003b1\u0000\u03a4\u03a7\u0003d2\u0000\u03a5\u03a7\u0005\u00c6\u0000"+
		"\u0000\u03a6\u0399\u0001\u0000\u0000\u0000\u03a6\u039a\u0001\u0000\u0000"+
		"\u0000\u03a6\u039b\u0001\u0000\u0000\u0000\u03a6\u039c\u0001\u0000\u0000"+
		"\u0000\u03a6\u039d\u0001\u0000\u0000\u0000\u03a6\u039e\u0001\u0000\u0000"+
		"\u0000\u03a6\u039f\u0001\u0000\u0000\u0000\u03a6\u03a0\u0001\u0000\u0000"+
		"\u0000\u03a6\u03a1\u0001\u0000\u0000\u0000\u03a6\u03a2\u0001\u0000\u0000"+
		"\u0000\u03a6\u03a3\u0001\u0000\u0000\u0000\u03a6\u03a4\u0001\u0000\u0000"+
		"\u0000\u03a6\u03a5\u0001\u0000\u0000\u0000\u03a7a\u0001\u0000\u0000\u0000"+
		"\u03a8\u03aa\u0005\u0007\u0000\u0000\u03a9\u03ab\u0005\u00c7\u0000\u0000"+
		"\u03aa\u03a9\u0001\u0000\u0000\u0000\u03aa\u03ab\u0001\u0000\u0000\u0000"+
		"\u03ab\u03ac\u0001\u0000\u0000\u0000\u03ac\u03b5\u0005\b\u0000\u0000\u03ad"+
		"\u03b2\u0003<\u001e\u0000\u03ae\u03af\u0005\u0001\u0000\u0000\u03af\u03b1"+
		"\u0003<\u001e\u0000\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b1\u03b4\u0001"+
		"\u0000\u0000\u0000\u03b2\u03b0\u0001\u0000\u0000\u0000\u03b2\u03b3\u0001"+
		"\u0000\u0000\u0000\u03b3\u03b6\u0001\u0000\u0000\u0000\u03b4\u03b2\u0001"+
		"\u0000\u0000\u0000\u03b5\u03ad\u0001\u0000\u0000\u0000\u03b5\u03b6\u0001"+
		"\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000\u0000\u0000\u03b7\u03c5\u0005"+
		"\t\u0000\u0000\u03b8\u03c1\u0005\b\u0000\u0000\u03b9\u03be\u0003<\u001e"+
		"\u0000\u03ba\u03bb\u0005\u0001\u0000\u0000\u03bb\u03bd\u0003<\u001e\u0000"+
		"\u03bc\u03ba\u0001\u0000\u0000\u0000\u03bd\u03c0\u0001\u0000\u0000\u0000"+
		"\u03be\u03bc\u0001\u0000\u0000\u0000\u03be\u03bf\u0001\u0000\u0000\u0000"+
		"\u03bf\u03c2\u0001\u0000\u0000\u0000\u03c0\u03be\u0001\u0000\u0000\u0000"+
		"\u03c1\u03b9\u0001\u0000\u0000\u0000\u03c1\u03c2\u0001\u0000\u0000\u0000"+
		"\u03c2\u03c3\u0001\u0000\u0000\u0000\u03c3\u03c5\u0005\t\u0000\u0000\u03c4"+
		"\u03a8\u0001\u0000\u0000\u0000\u03c4\u03b8\u0001\u0000\u0000\u0000\u03c5"+
		"c\u0001\u0000\u0000\u0000\u03c6\u03c8\u0005\n\u0000\u0000\u03c7\u03c9"+
		"\u0005\u00c7\u0000\u0000\u03c8\u03c7\u0001\u0000\u0000\u0000\u03c8\u03c9"+
		"\u0001\u0000\u0000\u0000\u03c9\u03ca\u0001\u0000\u0000\u0000\u03ca\u03d3"+
		"\u0005\u000b\u0000\u0000\u03cb\u03d0\u0003f3\u0000\u03cc\u03cd\u0005\u0001"+
		"\u0000\u0000\u03cd\u03cf\u0003f3\u0000\u03ce\u03cc\u0001\u0000\u0000\u0000"+
		"\u03cf\u03d2\u0001\u0000\u0000\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000"+
		"\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1\u03d4\u0001\u0000\u0000\u0000"+
		"\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d3\u03cb\u0001\u0000\u0000\u0000"+
		"\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000"+
		"\u03d5\u03e3\u0005\f\u0000\u0000\u03d6\u03df\u0005\u000b\u0000\u0000\u03d7"+
		"\u03dc\u0003f3\u0000\u03d8\u03d9\u0005\u0001\u0000\u0000\u03d9\u03db\u0003"+
		"f3\u0000\u03da\u03d8\u0001\u0000\u0000\u0000\u03db\u03de\u0001\u0000\u0000"+
		"\u0000\u03dc\u03da\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001\u0000\u0000"+
		"\u0000\u03dd\u03e0\u0001\u0000\u0000\u0000\u03de\u03dc\u0001\u0000\u0000"+
		"\u0000\u03df\u03d7\u0001\u0000\u0000\u0000\u03df\u03e0\u0001\u0000\u0000"+
		"\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1\u03e3\u0005\f\u0000\u0000"+
		"\u03e2\u03c6\u0001\u0000\u0000\u0000\u03e2\u03d6\u0001\u0000\u0000\u0000"+
		"\u03e3e\u0001\u0000\u0000\u0000\u03e4\u03e5\u0007\u0007\u0000\u0000\u03e5"+
		"\u03e6\u0005\r\u0000\u0000\u03e6\u03e7\u0003<\u001e\u0000\u03e7g\u0001"+
		"\u0000\u0000\u0000\u03e8\u03f0\u0005\u000e\u0000\u0000\u03e9\u03ea\u0005"+
		"\u0002\u0000\u0000\u03ea\u03ed\u0005\u00bd\u0000\u0000\u03eb\u03ec\u0005"+
		"\u0001\u0000\u0000\u03ec\u03ee\u0005\u00bd\u0000\u0000\u03ed\u03eb\u0001"+
		"\u0000\u0000\u0000\u03ed\u03ee\u0001\u0000\u0000\u0000\u03ee\u03ef\u0001"+
		"\u0000\u0000\u0000\u03ef\u03f1\u0005\u0003\u0000\u0000\u03f0\u03e9\u0001"+
		"\u0000\u0000\u0000\u03f0\u03f1\u0001\u0000\u0000\u0000\u03f1\u045b\u0001"+
		"\u0000\u0000\u0000\u03f2\u045b\u0005\u000f\u0000\u0000\u03f3\u045b\u0005"+
		"\u0010\u0000\u0000\u03f4\u045b\u0005\u0011\u0000\u0000\u03f5\u045b\u0005"+
		"\u0012\u0000\u0000\u03f6\u045b\u0005\u0013\u0000\u0000\u03f7\u045b\u0005"+
		"\u0014\u0000\u0000\u03f8\u045b\u0005\u0015\u0000\u0000\u03f9\u045b\u0005"+
		"\u0016\u0000\u0000\u03fa\u045b\u0005\u0017\u0000\u0000\u03fb\u045b\u0005"+
		"\u0018\u0000\u0000\u03fc\u0404\u0005\u0019\u0000\u0000\u03fd\u03fe\u0005"+
		"\u0002\u0000\u0000\u03fe\u0401\u0005\u00bd\u0000\u0000\u03ff\u0400\u0005"+
		"\u0001\u0000\u0000\u0400\u0402\u0005\u00bd\u0000\u0000\u0401\u03ff\u0001"+
		"\u0000\u0000\u0000\u0401\u0402\u0001\u0000\u0000\u0000\u0402\u0403\u0001"+
		"\u0000\u0000\u0000\u0403\u0405\u0005\u0003\u0000\u0000\u0404\u03fd\u0001"+
		"\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000\u0405\u045b\u0001"+
		"\u0000\u0000\u0000\u0406\u040e\u0005\u001a\u0000\u0000\u0407\u0408\u0005"+
		"\u0002\u0000\u0000\u0408\u040b\u0005\u00bd\u0000\u0000\u0409\u040a\u0005"+
		"\u0001\u0000\u0000\u040a\u040c\u0005\u00bd\u0000\u0000\u040b\u0409\u0001"+
		"\u0000\u0000\u0000\u040b\u040c\u0001\u0000\u0000\u0000\u040c\u040d\u0001"+
		"\u0000\u0000\u0000\u040d\u040f\u0005\u0003\u0000\u0000\u040e\u0407\u0001"+
		"\u0000\u0000\u0000\u040e\u040f\u0001\u0000\u0000\u0000\u040f\u045b\u0001"+
		"\u0000\u0000\u0000\u0410\u0414\u0005\u001b\u0000\u0000\u0411\u0412\u0005"+
		"\u0002\u0000\u0000\u0412\u0413\u0005\u00bd\u0000\u0000\u0413\u0415\u0005"+
		"\u0003\u0000\u0000\u0414\u0411\u0001\u0000\u0000\u0000\u0414\u0415\u0001"+
		"\u0000\u0000\u0000\u0415\u045b\u0001\u0000\u0000\u0000\u0416\u041a\u0005"+
		"\u001c\u0000\u0000\u0417\u0418\u0005\u0002\u0000\u0000\u0418\u0419\u0005"+
		"\u00bd\u0000\u0000\u0419\u041b\u0005\u0003\u0000\u0000\u041a\u0417\u0001"+
		"\u0000\u0000\u0000\u041a\u041b\u0001\u0000\u0000\u0000\u041b\u045b\u0001"+
		"\u0000\u0000\u0000\u041c\u0420\u0005\u001d\u0000\u0000\u041d\u041e\u0005"+
		"\u0002\u0000\u0000\u041e\u041f\u0005\u00bd\u0000\u0000\u041f\u0421\u0005"+
		"\u0003\u0000\u0000\u0420\u041d\u0001\u0000\u0000\u0000\u0420\u0421\u0001"+
		"\u0000\u0000\u0000\u0421\u045b\u0001\u0000\u0000\u0000\u0422\u0426\u0005"+
		"\u001e\u0000\u0000\u0423\u0424\u0005\u0002\u0000\u0000\u0424\u0425\u0005"+
		"\u00bd\u0000\u0000\u0425\u0427\u0005\u0003\u0000\u0000\u0426\u0423\u0001"+
		"\u0000\u0000\u0000\u0426\u0427\u0001\u0000\u0000\u0000\u0427\u045b\u0001"+
		"\u0000\u0000\u0000\u0428\u045b\u0005\u001f\u0000\u0000\u0429\u042d\u0005"+
		" \u0000\u0000\u042a\u042b\u0005\u0002\u0000\u0000\u042b\u042c\u0005\u00bd"+
		"\u0000\u0000\u042c\u042e\u0005\u0003\u0000\u0000\u042d\u042a\u0001\u0000"+
		"\u0000\u0000\u042d\u042e\u0001\u0000\u0000\u0000\u042e\u045b\u0001\u0000"+
		"\u0000\u0000\u042f\u0433\u0005!\u0000\u0000\u0430\u0431\u0005\u0002\u0000"+
		"\u0000\u0431\u0432\u0005\u00bd\u0000\u0000\u0432\u0434\u0005\u0003\u0000"+
		"\u0000\u0433\u0430\u0001\u0000\u0000\u0000\u0433\u0434\u0001\u0000\u0000"+
		"\u0000\u0434\u045b\u0001\u0000\u0000\u0000\u0435\u045b\u0005\"\u0000\u0000"+
		"\u0436\u045b\u0005#\u0000\u0000\u0437\u043b\u0005\u00aa\u0000\u0000\u0438"+
		"\u0439\u0005\u0002\u0000\u0000\u0439\u043a\u0005\u00bd\u0000\u0000\u043a"+
		"\u043c\u0005\u0003\u0000\u0000\u043b\u0438\u0001\u0000\u0000\u0000\u043b"+
		"\u043c\u0001\u0000\u0000\u0000\u043c\u045b\u0001\u0000\u0000\u0000\u043d"+
		"\u0441\u0005\u00ab\u0000\u0000\u043e\u043f\u0005\u0002\u0000\u0000\u043f"+
		"\u0440\u0005\u00bd\u0000\u0000\u0440\u0442\u0005\u0003\u0000\u0000\u0441"+
		"\u043e\u0001\u0000\u0000\u0000\u0441\u0442\u0001\u0000\u0000\u0000\u0442"+
		"\u045b\u0001\u0000\u0000\u0000\u0443\u0447\u0005$\u0000\u0000\u0444\u0445"+
		"\u0005\u0002\u0000\u0000\u0445\u0446\u0005\u00bd\u0000\u0000\u0446\u0448"+
		"\u0005\u0003\u0000\u0000\u0447\u0444\u0001\u0000\u0000\u0000\u0447\u0448"+
		"\u0001\u0000\u0000\u0000\u0448\u045b\u0001\u0000\u0000\u0000\u0449\u044d"+
		"\u0005%\u0000\u0000\u044a\u044b\u0005\u0002\u0000\u0000\u044b\u044c\u0005"+
		"\u00bd\u0000\u0000\u044c\u044e\u0005\u0003\u0000\u0000\u044d\u044a\u0001"+
		"\u0000\u0000\u0000\u044d\u044e\u0001\u0000\u0000\u0000\u044e\u045b\u0001"+
		"\u0000\u0000\u0000\u044f\u0453\u0005&\u0000\u0000\u0450\u0451\u0005\u0002"+
		"\u0000\u0000\u0451\u0452\u0005\u00bd\u0000\u0000\u0452\u0454\u0005\u0003"+
		"\u0000\u0000\u0453\u0450\u0001\u0000\u0000\u0000\u0453\u0454\u0001\u0000"+
		"\u0000\u0000\u0454\u045b\u0001\u0000\u0000\u0000\u0455\u045b\u0005\'\u0000"+
		"\u0000\u0456\u045b\u0005\n\u0000\u0000\u0457\u045b\u0005\u0007\u0000\u0000"+
		"\u0458\u045b\u0005(\u0000\u0000\u0459\u045b\u0005)\u0000\u0000\u045a\u03e8"+
		"\u0001\u0000\u0000\u0000\u045a\u03f2\u0001\u0000\u0000\u0000\u045a\u03f3"+
		"\u0001\u0000\u0000\u0000\u045a\u03f4\u0001\u0000\u0000\u0000\u045a\u03f5"+
		"\u0001\u0000\u0000\u0000\u045a\u03f6\u0001\u0000\u0000\u0000\u045a\u03f7"+
		"\u0001\u0000\u0000\u0000\u045a\u03f8\u0001\u0000\u0000\u0000\u045a\u03f9"+
		"\u0001\u0000\u0000\u0000\u045a\u03fa\u0001\u0000\u0000\u0000\u045a\u03fb"+
		"\u0001\u0000\u0000\u0000\u045a\u03fc\u0001\u0000\u0000\u0000\u045a\u0406"+
		"\u0001\u0000\u0000\u0000\u045a\u0410\u0001\u0000\u0000\u0000\u045a\u0416"+
		"\u0001\u0000\u0000\u0000\u045a\u041c\u0001\u0000\u0000\u0000\u045a\u0422"+
		"\u0001\u0000\u0000\u0000\u045a\u0428\u0001\u0000\u0000\u0000\u045a\u0429"+
		"\u0001\u0000\u0000\u0000\u045a\u042f\u0001\u0000\u0000\u0000\u045a\u0435"+
		"\u0001\u0000\u0000\u0000\u045a\u0436\u0001\u0000\u0000\u0000\u045a\u0437"+
		"\u0001\u0000\u0000\u0000\u045a\u043d\u0001\u0000\u0000\u0000\u045a\u0443"+
		"\u0001\u0000\u0000\u0000\u045a\u0449\u0001\u0000\u0000\u0000\u045a\u044f"+
		"\u0001\u0000\u0000\u0000\u045a\u0455\u0001\u0000\u0000\u0000\u045a\u0456"+
		"\u0001\u0000\u0000\u0000\u045a\u0457\u0001\u0000\u0000\u0000\u045a\u0458"+
		"\u0001\u0000\u0000\u0000\u045a\u0459\u0001\u0000\u0000\u0000\u045bi\u0001"+
		"\u0000\u0000\u0000\u045c\u045d\u0007\b\u0000\u0000\u045dk\u0001\u0000"+
		"\u0000\u0000\u045e\u045f\u0007\t\u0000\u0000\u045fm\u0001\u0000\u0000"+
		"\u0000\u0460\u0464\u0005\u00bb\u0000\u0000\u0461\u0464\u0005\u00bc\u0000"+
		"\u0000\u0462\u0464\u0003p8\u0000\u0463\u0460\u0001\u0000\u0000\u0000\u0463"+
		"\u0461\u0001\u0000\u0000\u0000\u0463\u0462\u0001\u0000\u0000\u0000\u0464"+
		"o\u0001\u0000\u0000\u0000\u0465\u0466\u0007\n\u0000\u0000\u0466q\u0001"+
		"\u0000\u0000\u0000\u0096swz~\u0085\u008f\u0094\u009d\u00a1\u00a4\u00a7"+
		"\u00aa\u00ad\u00b0\u00b9\u00c0\u00c5\u00c8\u00ca\u00d2\u00d9\u00de\u00e1"+
		"\u00e9\u00ee\u00f4\u00f7\u00ff\u0104\u0107\u010e\u0111\u0119\u011e\u0121"+
		"\u0125\u0128\u0130\u0135\u013b\u013e\u0140\u0145\u014b\u0153\u0160\u0165"+
		"\u0169\u016f\u0174\u0177\u0183\u018e\u019a\u01a7\u01ac\u01b5\u01ba\u01c8"+
		"\u01d1\u01d4\u01d7\u01da\u01e5\u01ef\u01f4\u01f8\u0201\u020f\u021d\u0223"+
		"\u0244\u024c\u025b\u0261\u0266\u026f\u0272\u0277\u027b\u0281\u028f\u0293"+
		"\u0299\u029f\u02a1\u02a3\u02a8\u02b3\u02b7\u02c3\u02c7\u02ce\u02d3\u02d7"+
		"\u02e2\u02ec\u02f0\u02f7\u0300\u030b\u0311\u0319\u031e\u0321\u0326\u0329"+
		"\u032e\u0337\u035e\u0361\u036e\u0372\u0377\u037e\u0385\u038f\u0393\u03a6"+
		"\u03aa\u03b2\u03b5\u03be\u03c1\u03c4\u03c8\u03d0\u03d3\u03dc\u03df\u03e2"+
		"\u03ed\u03f0\u0401\u0404\u040b\u040e\u0414\u041a\u0420\u0426\u042d\u0433"+
		"\u043b\u0441\u0447\u044d\u0453\u045a\u0463";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}