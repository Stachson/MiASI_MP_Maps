package interpreter;

import Database.DatabaseConnection;
import grammar.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.sql.SQLException;

public class Start {
    /*
    public static void main(String[] args) {
        CharStream inp = null;
        try {
            inp = CharStreams.fromFileName("we.first");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        CharStream inp = CharStreams.fromString("1+2*3-(4+5)","wejście");
//        CharStream inp = CharStreams.fromStream(System.in);

        firstLexer lex = new firstLexer(inp);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        firstParser par = new firstParser(tokens);

        ParseTree tree = par.prog();

        CalculateVisitor v = new CalculateVisitor(inp,tokens);
        String res = v.visit(tree);
//        System.out.printf("Wynik: %d\n", res);
    }
     */

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Stanisław Strauchold\\Desktop\\wynik1.mp"; // Twoje wejściowe pliki .mp
        try {
            // Tworzenie obiektu MPVisitor
            MPVisitor visitor = new MPVisitor("jdbc:postgresql://mydbinstance.czue2casejbn.us-east-1.rds.amazonaws.com:5432/ZaawansowaneBazyDanych", "postgres", "pwritehaslo");

            // Parsowanie pliku wejściowego i przetwarzanie go za pomocą obiektu MPVisitor
            visitor.parseFile(inputFile);

            // Możesz także wyświetlić wynikowe dane lub sprawdzić stan bazy danych

            // Zamykanie połączenia z bazą danych
            //visitor.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




