// Generated from C:/MiASI_project_mp/src/grammar/GetUMPStx.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GetUMPStx extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POIstart=1, POLYLINEstart=2, POLYGONstart=3, COMMENT=4, WS=5, EQ=6, NL=7, 
		IntComment=8, SECTend=9, LabI=10, TypeI=11, EndLevelI=12, DataI=13, MiastoI=14, 
		CityIdxI=15, PlikI=16, HouseNumberI=17, StreetDescI=18, TypI=19, ID=20, 
		NUM=21, V=22, POYGONstart=23;
	public static final int
		RULE_file = 0, RULE_section = 1, RULE_kvEq = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "section", "kvEq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[POI]'", "'[POLYLINE]'", "'[POLYGON]'", null, null, "'='", null, 
			null, null, null, "'Type'", "'EndLevel'", null, "'Miasto'", "'CityIdx'", 
			"'Plik'", "'HouseNumber'", "'StreetDesc'", "'Typ'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "POIstart", "POLYLINEstart", "POLYGONstart", "COMMENT", "WS", "EQ", 
			"NL", "IntComment", "SECTend", "LabI", "TypeI", "EndLevelI", "DataI", 
			"MiastoI", "CityIdxI", "PlikI", "HouseNumberI", "StreetDescI", "TypI", 
			"ID", "NUM", "V", "POYGONstart"
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
	public String getGrammarFileName() { return "GetUMPStx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GetUMPStx(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GetUMPStx.EOF, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GetUMPStxVisitor ) return ((GetUMPStxVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8388614L) != 0)) {
				{
				{
				setState(6);
				section();
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
			match(EOF);
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
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode POIstart() { return getToken(GetUMPStx.POIstart, 0); }
		public TerminalNode SECTend() { return getToken(GetUMPStx.SECTend, 0); }
		public List<KvEqContext> kvEq() {
			return getRuleContexts(KvEqContext.class);
		}
		public KvEqContext kvEq(int i) {
			return getRuleContext(KvEqContext.class,i);
		}
		public TerminalNode POLYLINEstart() { return getToken(GetUMPStx.POLYLINEstart, 0); }
		public TerminalNode POYGONstart() { return getToken(GetUMPStx.POYGONstart, 0); }
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GetUMPStxVisitor ) return ((GetUMPStxVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_section);
		int _la;
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POIstart:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(POIstart);
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2096128L) != 0)) {
					{
					{
					setState(15);
					kvEq();
					}
					}
					setState(20);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(21);
				match(SECTend);
				}
				break;
			case POLYLINEstart:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(POLYLINEstart);
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2096128L) != 0)) {
					{
					{
					setState(23);
					kvEq();
					}
					}
					setState(28);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(29);
				match(SECTend);
				}
				break;
			case POYGONstart:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				match(POYGONstart);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2096128L) != 0)) {
					{
					{
					setState(31);
					kvEq();
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(37);
				match(SECTend);
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
	public static class KvEqContext extends ParserRuleContext {
		public Token key;
		public TerminalNode EQ() { return getToken(GetUMPStx.EQ, 0); }
		public TerminalNode V() { return getToken(GetUMPStx.V, 0); }
		public TerminalNode ID() { return getToken(GetUMPStx.ID, 0); }
		public TerminalNode LabI() { return getToken(GetUMPStx.LabI, 0); }
		public TerminalNode TypeI() { return getToken(GetUMPStx.TypeI, 0); }
		public TerminalNode EndLevelI() { return getToken(GetUMPStx.EndLevelI, 0); }
		public TerminalNode DataI() { return getToken(GetUMPStx.DataI, 0); }
		public TerminalNode MiastoI() { return getToken(GetUMPStx.MiastoI, 0); }
		public TerminalNode CityIdxI() { return getToken(GetUMPStx.CityIdxI, 0); }
		public TerminalNode PlikI() { return getToken(GetUMPStx.PlikI, 0); }
		public TerminalNode HouseNumberI() { return getToken(GetUMPStx.HouseNumberI, 0); }
		public TerminalNode StreetDescI() { return getToken(GetUMPStx.StreetDescI, 0); }
		public TerminalNode TypI() { return getToken(GetUMPStx.TypI, 0); }
		public TerminalNode NUM() { return getToken(GetUMPStx.NUM, 0); }
		public KvEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvEq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GetUMPStxVisitor ) return ((GetUMPStxVisitor<? extends T>)visitor).visitKvEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KvEqContext kvEq() throws RecognitionException {
		KvEqContext _localctx = new KvEqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_kvEq);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((KvEqContext)_localctx).key = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2096128L) != 0)) ) {
					((KvEqContext)_localctx).key = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(41);
				match(EQ);
				setState(42);
				match(V);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(ID);
				setState(44);
				match(NUM);
				setState(45);
				match(EQ);
				setState(46);
				match(V);
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

	public static final String _serializedATN =
		"\u0004\u0001\u00172\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0005\u0000\b\b\u0000\n\u0000\f\u0000\u000b"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u0011"+
		"\b\u0001\n\u0001\f\u0001\u0014\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u0019\b\u0001\n\u0001\f\u0001\u001c\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001$\t\u0001\u0001"+
		"\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001"+
		"\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0001\u0001\u0000\n\u0014"+
		"5\u0000\t\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004"+
		"/\u0001\u0000\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006"+
		"\u0001\u0000\u0000\u0000\b\u000b\u0001\u0000\u0000\u0000\t\u0007\u0001"+
		"\u0000\u0000\u0000\t\n\u0001\u0000\u0000\u0000\n\f\u0001\u0000\u0000\u0000"+
		"\u000b\t\u0001\u0000\u0000\u0000\f\r\u0005\u0000\u0000\u0001\r\u0001\u0001"+
		"\u0000\u0000\u0000\u000e\u0012\u0005\u0001\u0000\u0000\u000f\u0011\u0003"+
		"\u0004\u0002\u0000\u0010\u000f\u0001\u0000\u0000\u0000\u0011\u0014\u0001"+
		"\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001"+
		"\u0000\u0000\u0000\u0013\u0015\u0001\u0000\u0000\u0000\u0014\u0012\u0001"+
		"\u0000\u0000\u0000\u0015\'\u0005\t\u0000\u0000\u0016\u001a\u0005\u0002"+
		"\u0000\u0000\u0017\u0019\u0003\u0004\u0002\u0000\u0018\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d\'\u0005\t\u0000"+
		"\u0000\u001e\"\u0005\u0017\u0000\u0000\u001f!\u0003\u0004\u0002\u0000"+
		" \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000\u0000\u0000\" \u0001\u0000"+
		"\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0001\u0000\u0000\u0000$\"\u0001"+
		"\u0000\u0000\u0000%\'\u0005\t\u0000\u0000&\u000e\u0001\u0000\u0000\u0000"+
		"&\u0016\u0001\u0000\u0000\u0000&\u001e\u0001\u0000\u0000\u0000\'\u0003"+
		"\u0001\u0000\u0000\u0000()\u0007\u0000\u0000\u0000)*\u0005\u0006\u0000"+
		"\u0000*0\u0005\u0016\u0000\u0000+,\u0005\u0014\u0000\u0000,-\u0005\u0015"+
		"\u0000\u0000-.\u0005\u0006\u0000\u0000.0\u0005\u0016\u0000\u0000/(\u0001"+
		"\u0000\u0000\u0000/+\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000"+
		"\u0000\u0006\t\u0012\u001a\"&/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}