package interpreter;

import Database.DatabaseConnection;
import SymbolTable.GlobalSymbols;
import grammar.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CalculateVisitor extends firstBaseVisitor<String> {
    private TokenStream tokStream = null;
    private CharStream input=null;
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private GlobalSymbols<String> globalSymbols;

    public CalculateVisitor(CharStream inp) {
        super();
        this.input = inp;
    }

    public CalculateVisitor(TokenStream tok) {
        super();
        this.tokStream = tok;
    }
    public CalculateVisitor(CharStream inp, TokenStream tok) {
        super();
        this.input = inp;
        this.tokStream = tok;
        this.globalSymbols = new GlobalSymbols<>();
    }
    private String getText(ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        if(input==null) throw new RuntimeException("Input stream undefined");
        return input.getText(new Interval(a,b));
    }
    /*
    @Override
    public Integer visitIf_stat(firstParser.If_statContext ctx) {
        Integer result = 0;
        if (visit(ctx.cond)!=0) {
            result = visit(ctx.then);
        }
        else {
            if(ctx.else_ != null)
                result = visit(ctx.else_);
        }
        return result;
    }

     */

    @Override
    public String visitPrint_stat(firstParser.Print_statContext ctx) {
        var st = ctx.expr();
        var result = visit(st);
        System.out.printf("|%s=%s|\n", st.getText(), result); //nie drukuje ukrytych ani pominiętych spacji
        //System.out.printf("|%s=%d|\n", getText(st),  result); //drukuje wszystkie spacje
        //System.out.printf("|%s=%d|\n", tokStream.getText(st),  result); //drukuje spacje z ukrytego kanału, ale nie ->skip
        return result;
    }
    /*
    @Override
    public Integer visitInt_tok(firstParser.Int_tokContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

     */

    @Override
    public String visitPars(firstParser.ParsContext ctx) {
        return visit(ctx.expr());
    }

    /*
    @Override
    public Integer visitBinOp(firstParser.BinOpContext ctx) {
        Integer result=0;
        switch (ctx.op.getType()) {
            case firstLexer.ADD:
                result = visit(ctx.l) + visit(ctx.r);
                break;
            case firstLexer.SUB:
                result = visit(ctx.l) - visit(ctx.r);
                break;
            case firstLexer.MUL:
                result = visit(ctx.l) * visit(ctx.r);
                break;
            case firstLexer.DIV:
                try {
                    result = visit(ctx.l) / visit(ctx.r);
                } catch (Exception e) {
                    System.err.println("Div by zero");
                    throw new ArithmeticException();
                }
        }
        return result;
    }

     */
    ////////////////////////////////////////////////////////////////


    @Override
    public String visitString_tok(firstParser.String_tokContext ctx) {
        return String.valueOf(ctx.STRING().getText());
    }

    @Override
    public String visitVar_id(firstParser.Var_idContext ctx) {
        return globalSymbols.getSymbol(ctx.ID().getText());
    }

    @Override
    public String visitInite(firstParser.IniteContext ctx) {
        globalSymbols.newSymbol(ctx.ID().getText());
        return null;
    }

    @Override
    public String visitAssign(firstParser.AssignContext ctx) {
        var name = ctx.ID().getText();
        var value = visit(ctx.expr());
        globalSymbols.setSymbol(name,value);
        return value;
    }

    @Override
    public String visitFile_stat(firstParser.File_statContext ctx) {

        String nazwaPliku = cleanStringToken(visit(ctx.expr(0))); //.getText(); // Pobierz nazwę pliku MP
        String sciezkaPliku =  cleanStringToken(visit(ctx.expr(1))); //.getText(); // Pobierz ścieżkę do pliku
        //String metadane = cleanStringToken(ctx.STRING().getText()); //.getText(); // Pobierz metadane

        File file = new File(sciezkaPliku);
        List<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sciezkaPliku), StandardCharsets.UTF_8))){
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        try {
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            databaseConnection.add_map(fileBytes, nazwaPliku, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private String cleanStringToken(String token) {
        // Usuń pierwszy i ostatni znak (cudzysłów)
        return token.substring(1, token.length() - 1);
    }

}
