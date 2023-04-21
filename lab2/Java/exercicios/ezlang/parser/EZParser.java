// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EZParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

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
		RULE_program = 0, RULE_varssect = 1, RULE_optvardecl = 2, RULE_vardecllist = 3, 
		RULE_vardecl = 4, RULE_typespec = 5, RULE_ifstmt = 6, RULE_stmtsect = 7, 
		RULE_stmtlist = 8, RULE_stmt = 9, RULE_repeatstmt = 10, RULE_assignstmt = 11, 
		RULE_readstmt = 12, RULE_writestmt = 13, RULE_expr = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "varssect", "optvardecl", "vardecllist", "vardecl", "typespec", 
			"ifstmt", "stmtsect", "stmtlist", "stmt", "repeatstmt", "assignstmt", 
			"readstmt", "writestmt", "expr"
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
	public String getGrammarFileName() { return "java-escape"; }

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

	@SuppressWarnings("CheckReturnValue")
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
			setState(30);
			match(PROGRAM);
			setState(31);
			match(ID);
			setState(32);
			match(SEMI);
			setState(33);
			varssect();
			setState(34);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarssectContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(EZParser.VAR, 0); }
		public OptvardeclContext optvardecl() {
			return getRuleContext(OptvardeclContext.class,0);
		}
		public VarssectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varssect; }
	}

	public final VarssectContext varssect() throws RecognitionException {
		VarssectContext _localctx = new VarssectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varssect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(VAR);
			setState(37);
			optvardecl();
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
	public static class OptvardeclContext extends ParserRuleContext {
		public VardecllistContext vardecllist() {
			return getRuleContext(VardecllistContext.class,0);
		}
		public OptvardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optvardecl; }
	}

	public final OptvardeclContext optvardecl() throws RecognitionException {
		OptvardeclContext _localctx = new OptvardeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_optvardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 21008L) != 0) {
				{
				setState(39);
				vardecllist(0);
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
	public static class VardecllistContext extends ParserRuleContext {
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public VardecllistContext vardecllist() {
			return getRuleContext(VardecllistContext.class,0);
		}
		public VardecllistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecllist; }
	}

	public final VardecllistContext vardecllist() throws RecognitionException {
		return vardecllist(0);
	}

	private VardecllistContext vardecllist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VardecllistContext _localctx = new VardecllistContext(_ctx, _parentState);
		VardecllistContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_vardecllist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			vardecl();
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VardecllistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_vardecllist);
					setState(45);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(46);
					vardecl();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		enterRule(_localctx, 8, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			typespec();
			setState(53);
			match(ID);
			setState(54);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 10, RULE_typespec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 21008L) != 0) ) {
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
	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(EZParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(EZParser.THEN, 0); }
		public List<StmtlistContext> stmtlist() {
			return getRuleContexts(StmtlistContext.class);
		}
		public StmtlistContext stmtlist(int i) {
			return getRuleContext(StmtlistContext.class,i);
		}
		public TerminalNode END() { return getToken(EZParser.END, 0); }
		public TerminalNode ELSE() { return getToken(EZParser.ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifstmt);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(IF);
				setState(59);
				expr(0);
				setState(60);
				match(THEN);
				setState(61);
				stmtlist(0);
				setState(62);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(IF);
				setState(65);
				expr(0);
				setState(66);
				match(THEN);
				setState(67);
				stmtlist(0);
				setState(68);
				match(ELSE);
				setState(69);
				stmtlist(0);
				setState(70);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtsectContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(EZParser.BEGIN, 0); }
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public TerminalNode END() { return getToken(EZParser.END, 0); }
		public StmtsectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtsect; }
	}

	public final StmtsectContext stmtsect() throws RecognitionException {
		StmtsectContext _localctx = new StmtsectContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmtsect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(BEGIN);
			setState(75);
			stmtlist(0);
			setState(76);
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
	public static class StmtlistContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public StmtlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtlist; }
	}

	public final StmtlistContext stmtlist() throws RecognitionException {
		return stmtlist(0);
	}

	private StmtlistContext stmtlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtlistContext _localctx = new StmtlistContext(_ctx, _parentState);
		StmtlistContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_stmtlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(79);
			stmt();
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmtlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stmtlist);
					setState(81);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(82);
					stmt();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class StmtContext extends ParserRuleContext {
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public RepeatstmtContext repeatstmt() {
			return getRuleContext(RepeatstmtContext.class,0);
		}
		public AssignstmtContext assignstmt() {
			return getRuleContext(AssignstmtContext.class,0);
		}
		public ReadstmtContext readstmt() {
			return getRuleContext(ReadstmtContext.class,0);
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
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				ifstmt();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				repeatstmt();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				assignstmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				readstmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatstmtContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(EZParser.REPEAT, 0); }
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(EZParser.UNTIL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RepeatstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatstmt; }
	}

	public final RepeatstmtContext repeatstmt() throws RecognitionException {
		RepeatstmtContext _localctx = new RepeatstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_repeatstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(REPEAT);
			setState(96);
			stmtlist(0);
			setState(97);
			match(UNTIL);
			setState(98);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 22, RULE_assignstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
			setState(101);
			match(ASSIGN);
			setState(102);
			expr(0);
			setState(103);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 24, RULE_readstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(READ);
			setState(106);
			match(ID);
			setState(107);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 26, RULE_writestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(WRITE);
			setState(110);
			expr(0);
			setState(111);
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

	@SuppressWarnings("CheckReturnValue")
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
		public TerminalNode OVER() { return getToken(EZParser.OVER, 0); }
		public TerminalNode TIMES() { return getToken(EZParser.TIMES, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(114);
				match(LPAR);
				setState(115);
				expr(0);
				setState(116);
				match(RPAR);
				}
				break;
			case TRUE:
				{
				setState(118);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(119);
				match(FALSE);
				}
				break;
			case INT_VAL:
				{
				setState(120);
				match(INT_VAL);
				}
				break;
			case REAL_VAL:
				{
				setState(121);
				match(REAL_VAL);
				}
				break;
			case STR_VAL:
				{
				setState(122);
				match(STR_VAL);
				}
				break;
			case ID:
				{
				setState(123);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(144);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(127);
						match(OVER);
						setState(128);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(130);
						match(TIMES);
						setState(131);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(133);
						match(PLUS);
						setState(134);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136);
						match(MINUS);
						setState(137);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(139);
						match(EQ);
						setState(140);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(142);
						match(LT);
						setState(143);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		case 3:
			return vardecllist_sempred((VardecllistContext)_localctx, predIndex);
		case 8:
			return stmtlist_sempred((StmtlistContext)_localctx, predIndex);
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean vardecllist_sempred(VardecllistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean stmtlist_sempred(StmtlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0003\u0002)\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00030\b\u0003\n\u0003\f\u0003"+
		"3\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006I\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\bT\b\b\n\b\f\bW\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t^\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e}\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0091\b\u000e\n\u000e"+
		"\f\u000e\u0094\t\u000e\u0001\u000e\u0000\u0003\u0006\u0010\u001c\u000f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u0000\u0001\u0004\u0000\u0004\u0004\t\t\f\f\u000e\u000e\u009a\u0000"+
		"\u001e\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004(\u0001"+
		"\u0000\u0000\u0000\u0006*\u0001\u0000\u0000\u0000\b4\u0001\u0000\u0000"+
		"\u0000\n8\u0001\u0000\u0000\u0000\fH\u0001\u0000\u0000\u0000\u000eJ\u0001"+
		"\u0000\u0000\u0000\u0010N\u0001\u0000\u0000\u0000\u0012]\u0001\u0000\u0000"+
		"\u0000\u0014_\u0001\u0000\u0000\u0000\u0016d\u0001\u0000\u0000\u0000\u0018"+
		"i\u0001\u0000\u0000\u0000\u001am\u0001\u0000\u0000\u0000\u001c|\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0005\n\u0000\u0000\u001f \u0005!\u0000"+
		"\u0000 !\u0005\u001a\u0000\u0000!\"\u0003\u0002\u0001\u0000\"#\u0003\u000e"+
		"\u0007\u0000#\u0001\u0001\u0000\u0000\u0000$%\u0005\u0012\u0000\u0000"+
		"%&\u0003\u0004\u0002\u0000&\u0003\u0001\u0000\u0000\u0000\')\u0003\u0006"+
		"\u0003\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\u0005"+
		"\u0001\u0000\u0000\u0000*+\u0006\u0003\uffff\uffff\u0000+,\u0003\b\u0004"+
		"\u0000,1\u0001\u0000\u0000\u0000-.\n\u0002\u0000\u0000.0\u0003\b\u0004"+
		"\u0000/-\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u00002\u0007\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000045\u0003\n\u0005\u000056\u0005!\u0000\u0000"+
		"67\u0005\u001a\u0000\u00007\t\u0001\u0000\u0000\u000089\u0007\u0000\u0000"+
		"\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\b\u0000\u0000;<\u0003\u001c"+
		"\u000e\u0000<=\u0005\u000f\u0000\u0000=>\u0003\u0010\b\u0000>?\u0005\u0006"+
		"\u0000\u0000?I\u0001\u0000\u0000\u0000@A\u0005\b\u0000\u0000AB\u0003\u001c"+
		"\u000e\u0000BC\u0005\u000f\u0000\u0000CD\u0003\u0010\b\u0000DE\u0005\u0005"+
		"\u0000\u0000EF\u0003\u0010\b\u0000FG\u0005\u0006\u0000\u0000GI\u0001\u0000"+
		"\u0000\u0000H:\u0001\u0000\u0000\u0000H@\u0001\u0000\u0000\u0000I\r\u0001"+
		"\u0000\u0000\u0000JK\u0005\u0003\u0000\u0000KL\u0003\u0010\b\u0000LM\u0005"+
		"\u0006\u0000\u0000M\u000f\u0001\u0000\u0000\u0000NO\u0006\b\uffff\uffff"+
		"\u0000OP\u0003\u0012\t\u0000PU\u0001\u0000\u0000\u0000QR\n\u0002\u0000"+
		"\u0000RT\u0003\u0012\t\u0000SQ\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\u0011\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000X^\u0003\f\u0006\u0000Y^\u0003"+
		"\u0014\n\u0000Z^\u0003\u0016\u000b\u0000[^\u0003\u0018\f\u0000\\^\u0003"+
		"\u001a\r\u0000]X\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000]Z\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000"+
		"^\u0013\u0001\u0000\u0000\u0000_`\u0005\r\u0000\u0000`a\u0003\u0010\b"+
		"\u0000ab\u0005\u0011\u0000\u0000bc\u0003\u001c\u000e\u0000c\u0015\u0001"+
		"\u0000\u0000\u0000de\u0005!\u0000\u0000ef\u0005\u0014\u0000\u0000fg\u0003"+
		"\u001c\u000e\u0000gh\u0005\u001a\u0000\u0000h\u0017\u0001\u0000\u0000"+
		"\u0000ij\u0005\u000b\u0000\u0000jk\u0005!\u0000\u0000kl\u0005\u001a\u0000"+
		"\u0000l\u0019\u0001\u0000\u0000\u0000mn\u0005\u0013\u0000\u0000no\u0003"+
		"\u001c\u000e\u0000op\u0005\u001a\u0000\u0000p\u001b\u0001\u0000\u0000"+
		"\u0000qr\u0006\u000e\uffff\uffff\u0000rs\u0005\u001c\u0000\u0000st\u0003"+
		"\u001c\u000e\u0000tu\u0005\u001d\u0000\u0000u}\u0001\u0000\u0000\u0000"+
		"v}\u0005\u0010\u0000\u0000w}\u0005\u0007\u0000\u0000x}\u0005\u001e\u0000"+
		"\u0000y}\u0005\u001f\u0000\u0000z}\u0005 \u0000\u0000{}\u0005!\u0000\u0000"+
		"|q\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|w\u0001\u0000\u0000"+
		"\u0000|x\u0001\u0000\u0000\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0092\u0001\u0000\u0000\u0000"+
		"~\u007f\n\f\u0000\u0000\u007f\u0080\u0005\u0018\u0000\u0000\u0080\u0091"+
		"\u0003\u001c\u000e\r\u0081\u0082\n\u000b\u0000\u0000\u0082\u0083\u0005"+
		"\u001b\u0000\u0000\u0083\u0091\u0003\u001c\u000e\f\u0084\u0085\n\n\u0000"+
		"\u0000\u0085\u0086\u0005\u0019\u0000\u0000\u0086\u0091\u0003\u001c\u000e"+
		"\u000b\u0087\u0088\n\t\u0000\u0000\u0088\u0089\u0005\u0017\u0000\u0000"+
		"\u0089\u0091\u0003\u001c\u000e\n\u008a\u008b\n\b\u0000\u0000\u008b\u008c"+
		"\u0005\u0015\u0000\u0000\u008c\u0091\u0003\u001c\u000e\t\u008d\u008e\n"+
		"\u0007\u0000\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f\u0091\u0003"+
		"\u001c\u000e\b\u0090~\u0001\u0000\u0000\u0000\u0090\u0081\u0001\u0000"+
		"\u0000\u0000\u0090\u0084\u0001\u0000\u0000\u0000\u0090\u0087\u0001\u0000"+
		"\u0000\u0000\u0090\u008a\u0001\u0000\u0000\u0000\u0090\u008d\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u001d\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\b(1HU]|\u0090\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}