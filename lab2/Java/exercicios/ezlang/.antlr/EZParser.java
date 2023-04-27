// Generated from /home/filipe/git/compiladores-labs/lab2/Java/exercicios/ezlang/EZParser.g by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EZParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, BEGIN=3, BOOL=4, ELSE=5, END=6, FALSE=7, IF=8, INT=9, 
		PROGRAM=10, READ=11, REAL=12, REPEAT=13, STRING=14, THEN=15, TRUE=16, 
		UNTIL=17, VAR=18, WRITE=19, ASSIGN=20, EQ=21, LT=22, MINUS=23, OVER=24, 
		PLUS=25, SEMI=26, TIMES=27, LPAR=28, RPAR=29, INT_VAL=30, REAL_VAL=31, 
		STR_VAL=32, ID=33, UNKNOWN=34;
	public static final int
		RULE_program = 0, RULE_varssect = 1, RULE_vardecl = 2, RULE_typespec = 3, 
		RULE_stmtsect = 4, RULE_stmt = 5, RULE_assignstmt = 6, RULE_ifstmt = 7, 
		RULE_readstmt = 8, RULE_repeatstmt = 9, RULE_writestmt = 10, RULE_expr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "varssect", "vardecl", "typespec", "stmtsect", "stmt", "assignstmt", 
			"ifstmt", "readstmt", "repeatstmt", "writestmt", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'begin'", "'bool'", "'else'", "'end'", "'false'", 
			"'if'", "'int'", "'program'", "'read'", "'real'", "'repeat'", "'string'", 
			"'then'", "'true'", "'until'", "'var'", "'write'", "':='", "'='", "'<'", 
			"'-'", "'/'", "'+'", "';'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "BEGIN", "BOOL", "ELSE", "END", "FALSE", "IF", 
			"INT", "PROGRAM", "READ", "REAL", "REPEAT", "STRING", "THEN", "TRUE", 
			"UNTIL", "VAR", "WRITE", "ASSIGN", "EQ", "LT", "MINUS", "OVER", "PLUS", 
			"SEMI", "TIMES", "LPAR", "RPAR", "INT_VAL", "REAL_VAL", "STR_VAL", "ID", 
			"UNKNOWN"
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
	public String getGrammarFileName() { return "EZParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EZParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(EZParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(EZParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(EZParser.SEMI, 0); }
		public VarssectContext varssect() {
			return getRuleContext(VarssectContext.class,0);
		}
		public StmtsectContext stmtsect() {
			return getRuleContext(StmtsectContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(PROGRAM);
			setState(25);
			match(ID);
			setState(26);
			match(SEMI);
			setState(27);
			varssect();
			setState(28);
			stmtsect();
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

	public static class VarssectContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(EZParser.VAR, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public VarssectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varssect; }
	}

	public final VarssectContext varssect() throws RecognitionException {
		VarssectContext _localctx = new VarssectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varssect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(VAR);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << STRING))) != 0)) {
				{
				{
				setState(31);
				vardecl();
				}
				}
				setState(36);
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

	public static class VardeclContext extends ParserRuleContext {
		public TypespecContext typespec() {
			return getRuleContext(TypespecContext.class,0);
		}
		public TerminalNode ID() { return getToken(EZParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(EZParser.SEMI, 0); }
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			typespec();
			setState(38);
			match(ID);
			setState(39);
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

	public static class TypespecContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(EZParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(EZParser.INT, 0); }
		public TerminalNode REAL() { return getToken(EZParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(EZParser.STRING, 0); }
		public TypespecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typespec; }
	}

	public final TypespecContext typespec() throws RecognitionException {
		TypespecContext _localctx = new TypespecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typespec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << STRING))) != 0)) ) {
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

	public static class StmtsectContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(EZParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(EZParser.END, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtsectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtsect; }
	}

	public final StmtsectContext stmtsect() throws RecognitionException {
		StmtsectContext _localctx = new StmtsectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmtsect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(BEGIN);
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				stmt();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << REPEAT) | (1L << WRITE) | (1L << ID))) != 0) );
			setState(49);
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

	public static class StmtContext extends ParserRuleContext {
		public AssignstmtContext assignstmt() {
			return getRuleContext(AssignstmtContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public ReadstmtContext readstmt() {
			return getRuleContext(ReadstmtContext.class,0);
		}
		public RepeatstmtContext repeatstmt() {
			return getRuleContext(RepeatstmtContext.class,0);
		}
		public WritestmtContext writestmt() {
			return getRuleContext(WritestmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmt);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				assignstmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				ifstmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				readstmt();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				repeatstmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				writestmt();
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

	public static class AssignstmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EZParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(EZParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EZParser.SEMI, 0); }
		public AssignstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignstmt; }
	}

	public final AssignstmtContext assignstmt() throws RecognitionException {
		AssignstmtContext _localctx = new AssignstmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(ID);
			setState(59);
			match(ASSIGN);
			setState(60);
			expr(0);
			setState(61);
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

	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(EZParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(EZParser.THEN, 0); }
		public TerminalNode END() { return getToken(EZParser.END, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(EZParser.ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifstmt);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(IF);
				setState(64);
				expr(0);
				setState(65);
				match(THEN);
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(66);
					stmt();
					}
					}
					setState(69); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << REPEAT) | (1L << WRITE) | (1L << ID))) != 0) );
				setState(71);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(IF);
				setState(74);
				expr(0);
				setState(75);
				match(THEN);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					stmt();
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << REPEAT) | (1L << WRITE) | (1L << ID))) != 0) );
				setState(81);
				match(ELSE);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					stmt();
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << REPEAT) | (1L << WRITE) | (1L << ID))) != 0) );
				setState(87);
				match(END);
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

	public static class ReadstmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(EZParser.READ, 0); }
		public TerminalNode ID() { return getToken(EZParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(EZParser.SEMI, 0); }
		public ReadstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readstmt; }
	}

	public final ReadstmtContext readstmt() throws RecognitionException {
		ReadstmtContext _localctx = new ReadstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_readstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(READ);
			setState(92);
			match(ID);
			setState(93);
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

	public static class RepeatstmtContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(EZParser.REPEAT, 0); }
		public TerminalNode UNTIL() { return getToken(EZParser.UNTIL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public RepeatstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatstmt; }
	}

	public final RepeatstmtContext repeatstmt() throws RecognitionException {
		RepeatstmtContext _localctx = new RepeatstmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_repeatstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(REPEAT);
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96);
				stmt();
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << REPEAT) | (1L << WRITE) | (1L << ID))) != 0) );
			setState(101);
			match(UNTIL);
			setState(102);
			expr(0);
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

	public static class WritestmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(EZParser.WRITE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EZParser.SEMI, 0); }
		public WritestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writestmt; }
	}

	public final WritestmtContext writestmt() throws RecognitionException {
		WritestmtContext _localctx = new WritestmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_writestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(WRITE);
			setState(105);
			expr(0);
			setState(106);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(EZParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(EZParser.RPAR, 0); }
		public TerminalNode TRUE() { return getToken(EZParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(EZParser.FALSE, 0); }
		public TerminalNode INT_VAL() { return getToken(EZParser.INT_VAL, 0); }
		public TerminalNode REAL_VAL() { return getToken(EZParser.REAL_VAL, 0); }
		public TerminalNode STR_VAL() { return getToken(EZParser.STR_VAL, 0); }
		public TerminalNode ID() { return getToken(EZParser.ID, 0); }
		public TerminalNode TIMES() { return getToken(EZParser.TIMES, 0); }
		public TerminalNode OVER() { return getToken(EZParser.OVER, 0); }
		public TerminalNode PLUS() { return getToken(EZParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(EZParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(EZParser.EQ, 0); }
		public TerminalNode LT() { return getToken(EZParser.LT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(109);
				match(LPAR);
				setState(110);
				expr(0);
				setState(111);
				match(RPAR);
				}
				break;
			case TRUE:
				{
				setState(113);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(114);
				match(FALSE);
				}
				break;
			case INT_VAL:
				{
				setState(115);
				match(INT_VAL);
				}
				break;
			case REAL_VAL:
				{
				setState(116);
				match(REAL_VAL);
				}
				break;
			case STR_VAL:
				{
				setState(117);
				match(STR_VAL);
				}
				break;
			case ID:
				{
				setState(118);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(130);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(122);
						_la = _input.LA(1);
						if ( !(_la==OVER || _la==TIMES) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(125);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(126);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(128);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==LT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3#\n\3\f\3\16\3"+
		"&\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\6\6\60\n\6\r\6\16\6\61\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\5\7;\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t"+
		"F\n\t\r\t\16\tG\3\t\3\t\3\t\3\t\3\t\3\t\6\tP\n\t\r\t\16\tQ\3\t\3\t\6\t"+
		"V\n\t\r\t\16\tW\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\13\3\13\6\13d\n\13"+
		"\r\13\16\13e\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\rz\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0085"+
		"\n\r\f\r\16\r\u0088\13\r\3\r\2\3\30\16\2\4\6\b\n\f\16\20\22\24\26\30\2"+
		"\6\6\2\6\6\13\13\16\16\20\20\4\2\32\32\35\35\4\2\31\31\33\33\3\2\27\30"+
		"\2\u0091\2\32\3\2\2\2\4 \3\2\2\2\6\'\3\2\2\2\b+\3\2\2\2\n-\3\2\2\2\f:"+
		"\3\2\2\2\16<\3\2\2\2\20[\3\2\2\2\22]\3\2\2\2\24a\3\2\2\2\26j\3\2\2\2\30"+
		"y\3\2\2\2\32\33\7\f\2\2\33\34\7#\2\2\34\35\7\34\2\2\35\36\5\4\3\2\36\37"+
		"\5\n\6\2\37\3\3\2\2\2 $\7\24\2\2!#\5\6\4\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\'(\5\b\5\2()\7#\2\2)*\7\34\2\2*\7"+
		"\3\2\2\2+,\t\2\2\2,\t\3\2\2\2-/\7\5\2\2.\60\5\f\7\2/.\3\2\2\2\60\61\3"+
		"\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\b\2\2\64\13\3\2"+
		"\2\2\65;\5\16\b\2\66;\5\20\t\2\67;\5\22\n\28;\5\24\13\29;\5\26\f\2:\65"+
		"\3\2\2\2:\66\3\2\2\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\r\3\2\2\2<=\7#\2"+
		"\2=>\7\26\2\2>?\5\30\r\2?@\7\34\2\2@\17\3\2\2\2AB\7\n\2\2BC\5\30\r\2C"+
		"E\7\21\2\2DF\5\f\7\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2"+
		"IJ\7\b\2\2J\\\3\2\2\2KL\7\n\2\2LM\5\30\r\2MO\7\21\2\2NP\5\f\7\2ON\3\2"+
		"\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2SU\7\7\2\2TV\5\f\7\2UT\3\2"+
		"\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\b\2\2Z\\\3\2\2\2[A\3"+
		"\2\2\2[K\3\2\2\2\\\21\3\2\2\2]^\7\r\2\2^_\7#\2\2_`\7\34\2\2`\23\3\2\2"+
		"\2ac\7\17\2\2bd\5\f\7\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2"+
		"\2\2gh\7\23\2\2hi\5\30\r\2i\25\3\2\2\2jk\7\25\2\2kl\5\30\r\2lm\7\34\2"+
		"\2m\27\3\2\2\2no\b\r\1\2op\7\36\2\2pq\5\30\r\2qr\7\37\2\2rz\3\2\2\2sz"+
		"\7\22\2\2tz\7\t\2\2uz\7 \2\2vz\7!\2\2wz\7\"\2\2xz\7#\2\2yn\3\2\2\2ys\3"+
		"\2\2\2yt\3\2\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\u0086\3\2\2"+
		"\2{|\f\f\2\2|}\t\3\2\2}\u0085\5\30\r\r~\177\f\13\2\2\177\u0080\t\4\2\2"+
		"\u0080\u0085\5\30\r\f\u0081\u0082\f\n\2\2\u0082\u0083\t\5\2\2\u0083\u0085"+
		"\5\30\r\13\u0084{\3\2\2\2\u0084~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\u0088"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\31\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\r$\61:GQW[ey\u0084\u0086";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}