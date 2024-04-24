// Generated from C:/MiASI_project_mp/src/grammar/first.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class firstLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, FILE=8, STRING=9, 
		STRINIT=10, IF_kw=11, DIV=12, MUL=13, SUB=14, ADD=15, NEWLINE=16, WS=17, 
		INT=18, ID=19, COMMENT=20, LINE_COMMENT=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "FILE", "STRING", 
			"STRINIT", "IF_kw", "DIV", "MUL", "SUB", "ADD", "NEWLINE", "WS", "INT", 
			"ID", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'else'", "'>'", "'{'", "'}'", "'='", "'save_file'", 
			null, "'string'", "'if'", "'/'", "'*'", "'-'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "FILE", "STRING", "STRINIT", 
			"IF_kw", "DIV", "MUL", "SUB", "ADD", "NEWLINE", "WS", "INT", "ID", "COMMENT", 
			"LINE_COMMENT"
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


	public firstLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "first.g4"; }

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
		"\u0004\u0000\u0015\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bI\b\b\n\b"+
		"\f\bL\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000fc\b"+
		"\u000f\u000b\u000f\f\u000fd\u0001\u000f\u0001\u000f\u0001\u0010\u0004"+
		"\u0010j\b\u0010\u000b\u0010\f\u0010k\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0004\u0011q\b\u0011\u000b\u0011\f\u0011r\u0001\u0012\u0001\u0012\u0005"+
		"\u0012w\b\u0012\n\u0012\f\u0012z\t\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u0080\b\u0013\n\u0013\f\u0013\u0083\t\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u008e\b\u0014\n\u0014"+
		"\f\u0014\u0091\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0081\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015\u0001\u0000\u0007\u0003\u0000\n\n\r\r\"\"\u0002\u0000\n"+
		"\n\r\r\u0002\u0000\t\t  \u0001\u000009\u0003\u0000AZ__az\u0004\u00000"+
		"9AZ__az\u0001\u0000\n\n\u009c\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003-"+
		"\u0001\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000\u00074\u0001\u0000"+
		"\u0000\u0000\t6\u0001\u0000\u0000\u0000\u000b8\u0001\u0000\u0000\u0000"+
		"\r:\u0001\u0000\u0000\u0000\u000f<\u0001\u0000\u0000\u0000\u0011F\u0001"+
		"\u0000\u0000\u0000\u0013O\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000"+
		"\u0000\u0017Y\u0001\u0000\u0000\u0000\u0019[\u0001\u0000\u0000\u0000\u001b"+
		"]\u0001\u0000\u0000\u0000\u001d_\u0001\u0000\u0000\u0000\u001fb\u0001"+
		"\u0000\u0000\u0000!i\u0001\u0000\u0000\u0000#p\u0001\u0000\u0000\u0000"+
		"%t\u0001\u0000\u0000\u0000\'{\u0001\u0000\u0000\u0000)\u0089\u0001\u0000"+
		"\u0000\u0000+,\u0005(\u0000\u0000,\u0002\u0001\u0000\u0000\u0000-.\u0005"+
		")\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005e\u0000\u000001\u0005"+
		"l\u0000\u000012\u0005s\u0000\u000023\u0005e\u0000\u00003\u0006\u0001\u0000"+
		"\u0000\u000045\u0005>\u0000\u00005\b\u0001\u0000\u0000\u000067\u0005{"+
		"\u0000\u00007\n\u0001\u0000\u0000\u000089\u0005}\u0000\u00009\f\u0001"+
		"\u0000\u0000\u0000:;\u0005=\u0000\u0000;\u000e\u0001\u0000\u0000\u0000"+
		"<=\u0005s\u0000\u0000=>\u0005a\u0000\u0000>?\u0005v\u0000\u0000?@\u0005"+
		"e\u0000\u0000@A\u0005_\u0000\u0000AB\u0005f\u0000\u0000BC\u0005i\u0000"+
		"\u0000CD\u0005l\u0000\u0000DE\u0005e\u0000\u0000E\u0010\u0001\u0000\u0000"+
		"\u0000FJ\u0005\"\u0000\u0000GI\b\u0000\u0000\u0000HG\u0001\u0000\u0000"+
		"\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KM\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005"+
		"\"\u0000\u0000N\u0012\u0001\u0000\u0000\u0000OP\u0005s\u0000\u0000PQ\u0005"+
		"t\u0000\u0000QR\u0005r\u0000\u0000RS\u0005i\u0000\u0000ST\u0005n\u0000"+
		"\u0000TU\u0005g\u0000\u0000U\u0014\u0001\u0000\u0000\u0000VW\u0005i\u0000"+
		"\u0000WX\u0005f\u0000\u0000X\u0016\u0001\u0000\u0000\u0000YZ\u0005/\u0000"+
		"\u0000Z\u0018\u0001\u0000\u0000\u0000[\\\u0005*\u0000\u0000\\\u001a\u0001"+
		"\u0000\u0000\u0000]^\u0005-\u0000\u0000^\u001c\u0001\u0000\u0000\u0000"+
		"_`\u0005+\u0000\u0000`\u001e\u0001\u0000\u0000\u0000ac\u0007\u0001\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0006"+
		"\u000f\u0000\u0000g \u0001\u0000\u0000\u0000hj\u0007\u0002\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0006\u0010"+
		"\u0000\u0000n\"\u0001\u0000\u0000\u0000oq\u0007\u0003\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000s$\u0001\u0000\u0000\u0000tx\u0007\u0004\u0000"+
		"\u0000uw\u0007\u0005\u0000\u0000vu\u0001\u0000\u0000\u0000wz\u0001\u0000"+
		"\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y&\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0005/\u0000\u0000|}\u0005"+
		"*\u0000\u0000}\u0081\u0001\u0000\u0000\u0000~\u0080\t\u0000\u0000\u0000"+
		"\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0005*\u0000\u0000\u0085\u0086\u0005/\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0006\u0013\u0000\u0000\u0088(\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005/\u0000\u0000\u008a\u008b\u0005/\u0000\u0000"+
		"\u008b\u008f\u0001\u0000\u0000\u0000\u008c\u008e\b\u0006\u0000\u0000\u008d"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005\n\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0006\u0014\u0000\u0000\u0095*\u0001\u0000\u0000\u0000\b\u0000Jdkrx\u0081"+
		"\u008f\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}