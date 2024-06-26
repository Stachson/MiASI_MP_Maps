// Generated from C:/MiASI_project_mp/src/grammar/GetUMPLex.g4 by ANTLR 4.13.1
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
public class GetUMPLex extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SECTstart=1, COMMENT=2, WS=3, EQ=4, NL=5, IntComment=6, SECTend=7, LabI=8, 
		TypeI=9, EndLevelI=10, DataI=11, MiastoI=12, CityIdxI=13, PlikI=14, HouseNumberI=15, 
		StreetDescI=16, TypI=17, ID=18, NUM=19, V=20;
	public static final int
		SECTION=1, VALUE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "SECTION", "VALUE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SECTstart", "COMMENT", "WS", "EQ", "NL", "IntComment", "SECTend", "LabI", 
			"TypeI", "EndLevelI", "DataI", "MiastoI", "CityIdxI", "PlikI", "HouseNumberI", 
			"StreetDescI", "TypI", "ID", "NUM", "V"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'='", null, null, null, null, "'Type'", "'EndLevel'", 
			null, "'Miasto'", "'CityIdx'", "'Plik'", "'HouseNumber'", "'StreetDesc'", 
			"'Typ'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SECTstart", "COMMENT", "WS", "EQ", "NL", "IntComment", "SECTend", 
			"LabI", "TypeI", "EndLevelI", "DataI", "MiastoI", "CityIdxI", "PlikI", 
			"HouseNumberI", "StreetDescI", "TypI", "ID", "NUM", "V"
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


	public GetUMPLex(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GetUMPLex.g4"; }

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
		"\u0004\u0000\u0014\u00d8\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"+
		"\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"+
		"\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"+
		"\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"+
		"\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002"+
		"\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0005\u0000.\b\u0000\n\u0000"+
		"\f\u00001\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u00019\b\u0001\n\u0001\f\u0001<\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002C\b"+
		"\u0002\u000b\u0002\f\u0002D\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004N\b\u0004\u000b"+
		"\u0004\f\u0004O\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005"+
		"\u0005V\b\u0005\n\u0005\f\u0005Y\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006i\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006m\b\u0006\n\u0006\f"+
		"\u0006p\t\u0006\u0003\u0006r\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0094\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0004\u0011\u00c6\b\u0011\u000b\u0011\f\u0011\u00c7"+
		"\u0001\u0012\u0004\u0012\u00cb\b\u0012\u000b\u0012\f\u0012\u00cc\u0001"+
		"\u0013\u0005\u0013\u00d0\b\u0013\n\u0013\f\u0013\u00d3\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0004/:Wn\u0000\u0014\u0003\u0001"+
		"\u0005\u0002\u0007\u0003\t\u0004\u000b\u0005\r\u0006\u000f\u0007\u0011"+
		"\b\u0013\t\u0015\n\u0017\u000b\u0019\f\u001b\r\u001d\u000e\u001f\u000f"+
		"!\u0010#\u0011%\u0012\'\u0013)\u0014\u0003\u0000\u0001\u0002\u0005\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0001\u000023\u0004\u0000::AZ__a"+
		"z\u0001\u000009\u00e2\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0001\t\u0001"+
		"\u0000\u0000\u0000\u0001\u000b\u0001\u0000\u0000\u0000\u0001\r\u0001\u0000"+
		"\u0000\u0000\u0001\u000f\u0001\u0000\u0000\u0000\u0001\u0011\u0001\u0000"+
		"\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000"+
		"\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000"+
		"\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000"+
		"\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000"+
		"\u0000\u0001#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0001"+
		"\'\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0003+\u0001"+
		"\u0000\u0000\u0000\u00056\u0001\u0000\u0000\u0000\u0007B\u0001\u0000\u0000"+
		"\u0000\tH\u0001\u0000\u0000\u0000\u000bM\u0001\u0000\u0000\u0000\rS\u0001"+
		"\u0000\u0000\u0000\u000f^\u0001\u0000\u0000\u0000\u0011w\u0001\u0000\u0000"+
		"\u0000\u0013\u007f\u0001\u0000\u0000\u0000\u0015\u0084\u0001\u0000\u0000"+
		"\u0000\u0017\u008d\u0001\u0000\u0000\u0000\u0019\u0095\u0001\u0000\u0000"+
		"\u0000\u001b\u009c\u0001\u0000\u0000\u0000\u001d\u00a4\u0001\u0000\u0000"+
		"\u0000\u001f\u00a9\u0001\u0000\u0000\u0000!\u00b5\u0001\u0000\u0000\u0000"+
		"#\u00c0\u0001\u0000\u0000\u0000%\u00c5\u0001\u0000\u0000\u0000\'\u00ca"+
		"\u0001\u0000\u0000\u0000)\u00d1\u0001\u0000\u0000\u0000+/\u0005[\u0000"+
		"\u0000,.\t\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000002\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0005]\u0000\u000034\u0001\u0000"+
		"\u0000\u000045\u0006\u0000\u0000\u00005\u0004\u0001\u0000\u0000\u0000"+
		"6:\u0005;\u0000\u000079\t\u0000\u0000\u000087\u0001\u0000\u0000\u0000"+
		"9<\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\n\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0001\u0001\u0000@\u0006\u0001"+
		"\u0000\u0000\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0006\u0002\u0001\u0000G\b\u0001\u0000"+
		"\u0000\u0000HI\u0005=\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0006\u0003"+
		"\u0002\u0000K\n\u0001\u0000\u0000\u0000LN\u0007\u0001\u0000\u0000ML\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0006\u0004\u0001"+
		"\u0000R\f\u0001\u0000\u0000\u0000SW\u0005\"\u0000\u0000TV\t\u0000\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000Z[\u0005\n\u0000\u0000[\\\u0001\u0000\u0000\u0000\\"+
		"]\u0006\u0005\u0001\u0000]\u000e\u0001\u0000\u0000\u0000^h\u0005[\u0000"+
		"\u0000_`\u0005E\u0000\u0000`a\u0005N\u0000\u0000ai\u0005D\u0000\u0000"+
		"bc\u0005E\u0000\u0000cd\u0005n\u0000\u0000di\u0005d\u0000\u0000ef\u0005"+
		"e\u0000\u0000fg\u0005n\u0000\u0000gi\u0005d\u0000\u0000h_\u0001\u0000"+
		"\u0000\u0000hb\u0001\u0000\u0000\u0000he\u0001\u0000\u0000\u0000iq\u0001"+
		"\u0000\u0000\u0000jn\u0005-\u0000\u0000km\t\u0000\u0000\u0000lk\u0001"+
		"\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000qj\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000st\u0005]\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0006\u0006"+
		"\u0003\u0000v\u0010\u0001\u0000\u0000\u0000wx\u0005L\u0000\u0000xy\u0005"+
		"a\u0000\u0000yz\u0005b\u0000\u0000z{\u0005e\u0000\u0000{|\u0005l\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0007\u0002\u0000\u0000~\u0012\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005T\u0000\u0000\u0080\u0081\u0005y\u0000"+
		"\u0000\u0081\u0082\u0005p\u0000\u0000\u0082\u0083\u0005e\u0000\u0000\u0083"+
		"\u0014\u0001\u0000\u0000\u0000\u0084\u0085\u0005E\u0000\u0000\u0085\u0086"+
		"\u0005n\u0000\u0000\u0086\u0087\u0005d\u0000\u0000\u0087\u0088\u0005L"+
		"\u0000\u0000\u0088\u0089\u0005e\u0000\u0000\u0089\u008a\u0005v\u0000\u0000"+
		"\u008a\u008b\u0005e\u0000\u0000\u008b\u008c\u0005l\u0000\u0000\u008c\u0016"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005D\u0000\u0000\u008e\u008f\u0005"+
		"a\u0000\u0000\u008f\u0090\u0005t\u0000\u0000\u0090\u0091\u0005a\u0000"+
		"\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0094\u0003\'\u0012\u0000"+
		"\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0018\u0001\u0000\u0000\u0000\u0095\u0096\u0005M\u0000\u0000\u0096"+
		"\u0097\u0005i\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098\u0099\u0005"+
		"s\u0000\u0000\u0099\u009a\u0005t\u0000\u0000\u009a\u009b\u0005o\u0000"+
		"\u0000\u009b\u001a\u0001\u0000\u0000\u0000\u009c\u009d\u0005C\u0000\u0000"+
		"\u009d\u009e\u0005i\u0000\u0000\u009e\u009f\u0005t\u0000\u0000\u009f\u00a0"+
		"\u0005y\u0000\u0000\u00a0\u00a1\u0005I\u0000\u0000\u00a1\u00a2\u0005d"+
		"\u0000\u0000\u00a2\u00a3\u0005x\u0000\u0000\u00a3\u001c\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005P\u0000\u0000\u00a5\u00a6\u0005l\u0000\u0000\u00a6"+
		"\u00a7\u0005i\u0000\u0000\u00a7\u00a8\u0005k\u0000\u0000\u00a8\u001e\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0005H\u0000\u0000\u00aa\u00ab\u0005o\u0000"+
		"\u0000\u00ab\u00ac\u0005u\u0000\u0000\u00ac\u00ad\u0005s\u0000\u0000\u00ad"+
		"\u00ae\u0005e\u0000\u0000\u00ae\u00af\u0005N\u0000\u0000\u00af\u00b0\u0005"+
		"u\u0000\u0000\u00b0\u00b1\u0005m\u0000\u0000\u00b1\u00b2\u0005b\u0000"+
		"\u0000\u00b2\u00b3\u0005e\u0000\u0000\u00b3\u00b4\u0005r\u0000\u0000\u00b4"+
		" \u0001\u0000\u0000\u0000\u00b5\u00b6\u0005S\u0000\u0000\u00b6\u00b7\u0005"+
		"t\u0000\u0000\u00b7\u00b8\u0005r\u0000\u0000\u00b8\u00b9\u0005e\u0000"+
		"\u0000\u00b9\u00ba\u0005e\u0000\u0000\u00ba\u00bb\u0005t\u0000\u0000\u00bb"+
		"\u00bc\u0005D\u0000\u0000\u00bc\u00bd\u0005e\u0000\u0000\u00bd\u00be\u0005"+
		"s\u0000\u0000\u00be\u00bf\u0005c\u0000\u0000\u00bf\"\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0005T\u0000\u0000\u00c1\u00c2\u0005y\u0000\u0000\u00c2"+
		"\u00c3\u0005p\u0000\u0000\u00c3$\u0001\u0000\u0000\u0000\u00c4\u00c6\u0007"+
		"\u0003\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8&\u0001\u0000\u0000\u0000\u00c9\u00cb\u0007\u0004"+
		"\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd(\u0001\u0000\u0000\u0000\u00ce\u00d0\b\u0001\u0000"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0005\n\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u0006\u0013\u0003\u0000\u00d7*\u0001\u0000\u0000\u0000\u000f"+
		"\u0000\u0001\u0002/:DOWhnq\u0093\u00c7\u00cc\u00d1\u0004\u0005\u0001\u0000"+
		"\u0006\u0000\u0000\u0005\u0002\u0000\u0004\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}