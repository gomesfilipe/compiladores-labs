// Generated from /home/filipe/git/compiladores-labs/lab1/Java/exercicios/aquecimento/Q03.g by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Q03 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, HEX=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "WS", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "HEX"
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


	public Q03(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Q03.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2:
			HEX_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void HEX_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println(getText()); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\4.\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\3\3\6\3\r\n\3\r\3\16\3\16\3\3\3\3\3\4\3\4\3\4\5"+
		"\4\26\n\4\3\4\5\4\31\n\4\3\4\5\4\34\n\4\3\4\5\4\37\n\4\3\4\5\4\"\n\4\3"+
		"\4\5\4%\n\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\2\2\5\3\2\5\3\7\4\3\2\5"+
		"\5\2\62;CHch\4\2\13\f\"\"\4\2ZZzz\2\65\2\5\3\2\2\2\2\7\3\2\2\2\3\t\3\2"+
		"\2\2\5\f\3\2\2\2\7\22\3\2\2\2\t\n\t\2\2\2\n\4\3\2\2\2\13\r\t\3\2\2\f\13"+
		"\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\20\3\2\2\2\20\21\b"+
		"\3\2\2\21\6\3\2\2\2\22\23\7\62\2\2\23\25\t\4\2\2\24\26\5\3\2\2\25\24\3"+
		"\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\31\5\3\2\2\30\27\3\2\2\2\30\31\3"+
		"\2\2\2\31\33\3\2\2\2\32\34\5\3\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34\36\3"+
		"\2\2\2\35\37\5\3\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \"\5\3\2"+
		"\2! \3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#%\5\3\2\2$#\3\2\2\2$%\3\2\2\2%\'\3"+
		"\2\2\2&(\5\3\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)+\5\3\2\2*)\3\2\2\2*"+
		"+\3\2\2\2+,\3\2\2\2,-\b\4\3\2-\b\3\2\2\2\f\2\16\25\30\33\36!$\'*\4\b\2"+
		"\2\3\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}