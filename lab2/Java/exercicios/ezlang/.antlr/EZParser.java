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
		RULE_program = 0, RULE_varssect = 1, RULE_optvardecl = 2, RULE_vardecllist = 3, 
		RULE_vardecl = 4, RULE_typespec = 5, RULE_stmtsect = 6, RULE_stmtlist = 7, 
		RULE_stmt = 8, RULE_ifstmt = 9, RULE_repeatstmt = 10, RULE_assignstmt = 11, 
		RULE_readstmt = 12, RULE_writestmt = 13, RULE_expr = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "varssect", "optvardecl", "vardecllist", "vardecl", "typespec", 
			"stmtsect", "stmtlist", "stmt", "ifstmt", "repeatstmt", "assignstmt", 
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << STRING))) != 0)) {
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
		enterRule(_localctx, 12, RULE_stmtsect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(BEGIN);
			setState(59);
			stmtlist(0);
			setState(60);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_stmtlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(63);
			stmt();
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmtlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stmtlist);
					setState(65);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(66);
					stmt();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				ifstmt();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				repeatstmt();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				assignstmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				readstmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
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
		enterRule(_localctx, 18, RULE_ifstmt);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(IF);
				setState(80);
				expr(0);
				setState(81);
				match(THEN);
				setState(82);
				stmtlist(0);
				setState(83);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(IF);
				setState(86);
				expr(0);
				setState(87);
				match(THEN);
				setState(88);
				stmtlist(0);
				setState(89);
				match(ELSE);
				setState(90);
				stmtlist(0);
				setState(91);
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
		case 7:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0098\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5"+
		"\65\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7"+
		"\tF\n\t\f\t\16\tI\13\t\3\n\3\n\3\n\3\n\3\n\5\nP\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13`\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\177\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\7\20\u0093\n\20\f\20\16\20\u0096\13\20\3\20\2"+
		"\5\b\20\36\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\6\2\6\6\13\13"+
		"\16\16\20\20\2\u009c\2 \3\2\2\2\4&\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n\66"+
		"\3\2\2\2\f:\3\2\2\2\16<\3\2\2\2\20@\3\2\2\2\22O\3\2\2\2\24_\3\2\2\2\26"+
		"a\3\2\2\2\30f\3\2\2\2\32k\3\2\2\2\34o\3\2\2\2\36~\3\2\2\2 !\7\f\2\2!\""+
		"\7#\2\2\"#\7\34\2\2#$\5\4\3\2$%\5\16\b\2%\3\3\2\2\2&\'\7\24\2\2\'(\5\6"+
		"\4\2(\5\3\2\2\2)+\5\b\5\2*)\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,-\b\5\1\2-.\5"+
		"\n\6\2.\63\3\2\2\2/\60\f\4\2\2\60\62\5\n\6\2\61/\3\2\2\2\62\65\3\2\2\2"+
		"\63\61\3\2\2\2\63\64\3\2\2\2\64\t\3\2\2\2\65\63\3\2\2\2\66\67\5\f\7\2"+
		"\678\7#\2\289\7\34\2\29\13\3\2\2\2:;\t\2\2\2;\r\3\2\2\2<=\7\5\2\2=>\5"+
		"\20\t\2>?\7\b\2\2?\17\3\2\2\2@A\b\t\1\2AB\5\22\n\2BG\3\2\2\2CD\f\4\2\2"+
		"DF\5\22\n\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\21\3\2\2\2IG\3\2"+
		"\2\2JP\5\24\13\2KP\5\26\f\2LP\5\30\r\2MP\5\32\16\2NP\5\34\17\2OJ\3\2\2"+
		"\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\23\3\2\2\2QR\7\n\2\2RS\5\36"+
		"\20\2ST\7\21\2\2TU\5\20\t\2UV\7\b\2\2V`\3\2\2\2WX\7\n\2\2XY\5\36\20\2"+
		"YZ\7\21\2\2Z[\5\20\t\2[\\\7\7\2\2\\]\5\20\t\2]^\7\b\2\2^`\3\2\2\2_Q\3"+
		"\2\2\2_W\3\2\2\2`\25\3\2\2\2ab\7\17\2\2bc\5\20\t\2cd\7\23\2\2de\5\36\20"+
		"\2e\27\3\2\2\2fg\7#\2\2gh\7\26\2\2hi\5\36\20\2ij\7\34\2\2j\31\3\2\2\2"+
		"kl\7\r\2\2lm\7#\2\2mn\7\34\2\2n\33\3\2\2\2op\7\25\2\2pq\5\36\20\2qr\7"+
		"\34\2\2r\35\3\2\2\2st\b\20\1\2tu\7\36\2\2uv\5\36\20\2vw\7\37\2\2w\177"+
		"\3\2\2\2x\177\7\22\2\2y\177\7\t\2\2z\177\7 \2\2{\177\7!\2\2|\177\7\"\2"+
		"\2}\177\7#\2\2~s\3\2\2\2~x\3\2\2\2~y\3\2\2\2~z\3\2\2\2~{\3\2\2\2~|\3\2"+
		"\2\2~}\3\2\2\2\177\u0094\3\2\2\2\u0080\u0081\f\16\2\2\u0081\u0082\7\32"+
		"\2\2\u0082\u0093\5\36\20\17\u0083\u0084\f\r\2\2\u0084\u0085\7\35\2\2\u0085"+
		"\u0093\5\36\20\16\u0086\u0087\f\f\2\2\u0087\u0088\7\33\2\2\u0088\u0093"+
		"\5\36\20\r\u0089\u008a\f\13\2\2\u008a\u008b\7\31\2\2\u008b\u0093\5\36"+
		"\20\f\u008c\u008d\f\n\2\2\u008d\u008e\7\27\2\2\u008e\u0093\5\36\20\13"+
		"\u008f\u0090\f\t\2\2\u0090\u0091\7\30\2\2\u0091\u0093\5\36\20\n\u0092"+
		"\u0080\3\2\2\2\u0092\u0083\3\2\2\2\u0092\u0086\3\2\2\2\u0092\u0089\3\2"+
		"\2\2\u0092\u008c\3\2\2\2\u0092\u008f\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\37\3\2\2\2\u0096\u0094\3\2\2"+
		"\2\n*\63GO_~\u0092\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}