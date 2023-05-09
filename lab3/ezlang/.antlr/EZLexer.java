// Generated from /home/fgasouza/compiladores-labs/lab3/ezlang/EZLexer.g by ANTLR 4.9.2

    package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EZLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_VALUE", "REAL_VALUE", "STR_VALUE", "ID_VALUE", "WS", "COMMENT", 
			"BEGIN", "BOOL", "ELSE", "END", "FALSE", "IF", "INT", "PROGRAM", "READ", 
			"REAL", "REPEAT", "STRING", "THEN", "TRUE", "UNTIL", "VAR", "WRITE", 
			"ASSIGN", "EQ", "LT", "MINUS", "OVER", "PLUS", "SEMI", "TIMES", "LPAR", 
			"RPAR", "INT_VAL", "REAL_VAL", "STR_VAL", "ID", "UNKNOWN"
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


	public EZLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EZLexer.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00f9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\7\2R\n\2\f\2\16\2"+
		"U\13\2\3\2\5\2X\n\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4`\n\4\f\4\16\4c\13\4\3"+
		"\4\3\4\3\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\6\6\6o\n\6\r\6\16\6p\3\6\3\6"+
		"\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\2\2(\3\2\5\2\7\2\t\2\13"+
		"\3\r\4\17\5\21\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21"+
		")\22+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35A\36C\37E G!I"+
		"\"K#M$\3\2\t\3\2\63;\3\2\62;\3\2$$\4\2C\\c|\7\2//\62;C\\aac|\5\2\13\f"+
		"\17\17\"\"\3\2\177\177\2\u00fa\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7]\3\2\2\2\tf\3\2\2\2\13n\3\2"+
		"\2\2\rt\3\2\2\2\17\177\3\2\2\2\21\u0085\3\2\2\2\23\u008a\3\2\2\2\25\u008f"+
		"\3\2\2\2\27\u0093\3\2\2\2\31\u0099\3\2\2\2\33\u009c\3\2\2\2\35\u00a0\3"+
		"\2\2\2\37\u00a8\3\2\2\2!\u00ad\3\2\2\2#\u00b2\3\2\2\2%\u00b9\3\2\2\2\'"+
		"\u00c0\3\2\2\2)\u00c5\3\2\2\2+\u00ca\3\2\2\2-\u00d0\3\2\2\2/\u00d4\3\2"+
		"\2\2\61\u00da\3\2\2\2\63\u00dd\3\2\2\2\65\u00df\3\2\2\2\67\u00e1\3\2\2"+
		"\29\u00e3\3\2\2\2;\u00e5\3\2\2\2=\u00e7\3\2\2\2?\u00e9\3\2\2\2A\u00eb"+
		"\3\2\2\2C\u00ed\3\2\2\2E\u00ef\3\2\2\2G\u00f1\3\2\2\2I\u00f3\3\2\2\2K"+
		"\u00f5\3\2\2\2M\u00f7\3\2\2\2OS\t\2\2\2PR\t\3\2\2QP\3\2\2\2RU\3\2\2\2"+
		"SQ\3\2\2\2ST\3\2\2\2TX\3\2\2\2US\3\2\2\2VX\7\62\2\2WO\3\2\2\2WV\3\2\2"+
		"\2X\4\3\2\2\2YZ\5\3\2\2Z[\7\60\2\2[\\\5\3\2\2\\\6\3\2\2\2]a\7$\2\2^`\n"+
		"\4\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7"+
		"$\2\2e\b\3\2\2\2fj\t\5\2\2gi\t\6\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3"+
		"\2\2\2k\n\3\2\2\2lj\3\2\2\2mo\t\7\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq"+
		"\3\2\2\2qr\3\2\2\2rs\b\6\2\2s\f\3\2\2\2tx\7}\2\2uw\n\b\2\2vu\3\2\2\2w"+
		"z\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\177\2\2|}\3\2\2"+
		"\2}~\b\7\2\2~\16\3\2\2\2\177\u0080\7d\2\2\u0080\u0081\7g\2\2\u0081\u0082"+
		"\7i\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\20\3\2\2\2\u0085\u0086"+
		"\7d\2\2\u0086\u0087\7q\2\2\u0087\u0088\7q\2\2\u0088\u0089\7n\2\2\u0089"+
		"\22\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7g\2\2\u008e\24\3\2\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7f\2\2\u0092\26\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095\7c\2\2\u0095"+
		"\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098\30\3\2\2\2\u0099"+
		"\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\32\3\2\2\2\u009c\u009d\7k\2\2\u009d"+
		"\u009e\7p\2\2\u009e\u009f\7v\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7r\2\2\u00a1"+
		"\u00a2\7t\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7i\2\2\u00a4\u00a5\7t\2\2"+
		"\u00a5\u00a6\7c\2\2\u00a6\u00a7\7o\2\2\u00a7\36\3\2\2\2\u00a8\u00a9\7"+
		"t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7f\2\2\u00ac "+
		"\3\2\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7c\2\2\u00b0"+
		"\u00b1\7n\2\2\u00b1\"\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\u00b5\7r\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7v\2\2"+
		"\u00b8$\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7t\2"+
		"\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7i\2\2\u00bf&\3\2"+
		"\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7j\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7p\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8"+
		"\7w\2\2\u00c8\u00c9\7g\2\2\u00c9*\3\2\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc"+
		"\7p\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7n\2\2\u00cf"+
		",\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7t\2\2\u00d3"+
		".\3\2\2\2\u00d4\u00d5\7y\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7k\2\2\u00d7"+
		"\u00d8\7v\2\2\u00d8\u00d9\7g\2\2\u00d9\60\3\2\2\2\u00da\u00db\7<\2\2\u00db"+
		"\u00dc\7?\2\2\u00dc\62\3\2\2\2\u00dd\u00de\7?\2\2\u00de\64\3\2\2\2\u00df"+
		"\u00e0\7>\2\2\u00e0\66\3\2\2\2\u00e1\u00e2\7/\2\2\u00e28\3\2\2\2\u00e3"+
		"\u00e4\7\61\2\2\u00e4:\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6<\3\2\2\2\u00e7"+
		"\u00e8\7=\2\2\u00e8>\3\2\2\2\u00e9\u00ea\7,\2\2\u00ea@\3\2\2\2\u00eb\u00ec"+
		"\7*\2\2\u00ecB\3\2\2\2\u00ed\u00ee\7+\2\2\u00eeD\3\2\2\2\u00ef\u00f0\5"+
		"\3\2\2\u00f0F\3\2\2\2\u00f1\u00f2\5\5\3\2\u00f2H\3\2\2\2\u00f3\u00f4\5"+
		"\7\4\2\u00f4J\3\2\2\2\u00f5\u00f6\5\t\5\2\u00f6L\3\2\2\2\u00f7\u00f8\13"+
		"\2\2\2\u00f8N\3\2\2\2\t\2SWajpx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}