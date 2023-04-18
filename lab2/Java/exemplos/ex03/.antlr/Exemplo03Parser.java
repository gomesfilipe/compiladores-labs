// Generated from /home/filipe/git/compiladores-labs/lab2/Java/exemplos/ex03/Exemplo03.g by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Exemplo03Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SWITCH=1, CASE=2, DEFAULT=3, BREAK=4, COLON=5, SEMI=6, LBRACE=7, RBRACE=8, 
		INT_VAL=9, ID=10, WS=11;
	public static final int
		RULE_begin = 0, RULE_switch_stmt = 1, RULE_case_stmt = 2, RULE_default_stmt = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"begin", "switch_stmt", "case_stmt", "default_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'switch'", "'case'", "'default'", "'break'", "':'", "';'", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SWITCH", "CASE", "DEFAULT", "BREAK", "COLON", "SEMI", "LBRACE", 
			"RBRACE", "INT_VAL", "ID", "WS"
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
	public String getGrammarFileName() { return "Exemplo03.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Exemplo03Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class BeginContext extends ParserRuleContext {
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			switch_stmt();
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

	public static class Switch_stmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(Exemplo03Parser.SWITCH, 0); }
		public TerminalNode ID() { return getToken(Exemplo03Parser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(Exemplo03Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Exemplo03Parser.RBRACE, 0); }
		public List<Case_stmtContext> case_stmt() {
			return getRuleContexts(Case_stmtContext.class);
		}
		public Case_stmtContext case_stmt(int i) {
			return getRuleContext(Case_stmtContext.class,i);
		}
		public Default_stmtContext default_stmt() {
			return getRuleContext(Default_stmtContext.class,0);
		}
		public Switch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_stmt; }
	}

	public final Switch_stmtContext switch_stmt() throws RecognitionException {
		Switch_stmtContext _localctx = new Switch_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_switch_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(SWITCH);
			setState(11);
			match(ID);
			setState(12);
			match(LBRACE);
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(13);
				case_stmt();
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(18);
				default_stmt();
				}
			}

			setState(21);
			match(RBRACE);
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

	public static class Case_stmtContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(Exemplo03Parser.CASE, 0); }
		public TerminalNode INT_VAL() { return getToken(Exemplo03Parser.INT_VAL, 0); }
		public TerminalNode COLON() { return getToken(Exemplo03Parser.COLON, 0); }
		public TerminalNode BREAK() { return getToken(Exemplo03Parser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(Exemplo03Parser.SEMI, 0); }
		public Case_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_stmt; }
	}

	public final Case_stmtContext case_stmt() throws RecognitionException {
		Case_stmtContext _localctx = new Case_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_case_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(CASE);
			setState(24);
			match(INT_VAL);
			setState(25);
			match(COLON);
			setState(26);
			match(BREAK);
			setState(27);
			match(SEMI);
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

	public static class Default_stmtContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(Exemplo03Parser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(Exemplo03Parser.COLON, 0); }
		public Default_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_stmt; }
	}

	public final Default_stmtContext default_stmt() throws RecognitionException {
		Default_stmtContext _localctx = new Default_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_default_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(DEFAULT);
			setState(30);
			match(COLON);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\3\6\3\21\n\3\r\3\16\3\22\3\3"+
		"\5\3\26\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\2\2\6\2\4"+
		"\6\b\2\2\2 \2\n\3\2\2\2\4\f\3\2\2\2\6\31\3\2\2\2\b\37\3\2\2\2\n\13\5\4"+
		"\3\2\13\3\3\2\2\2\f\r\7\3\2\2\r\16\7\f\2\2\16\20\7\t\2\2\17\21\5\6\4\2"+
		"\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2"+
		"\24\26\5\b\5\2\25\24\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2\27\30\7\n\2\2"+
		"\30\5\3\2\2\2\31\32\7\4\2\2\32\33\7\13\2\2\33\34\7\7\2\2\34\35\7\6\2\2"+
		"\35\36\7\b\2\2\36\7\3\2\2\2\37 \7\5\2\2 !\7\7\2\2!\t\3\2\2\2\4\22\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}