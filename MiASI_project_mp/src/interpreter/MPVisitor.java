package interpreter;

import grammar.GetUMPLex;
import grammar.GetUMPStx;
import grammar.GetUMPStxBaseVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MPVisitor extends GetUMPStxBaseVisitor<Void> {
    private Connection connection;
    private String url = "";
    private String user = "";
    private String password = "";
    private int mapId = -1;

    public MPVisitor(String jdbcURL, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(jdbcURL, username, password);
    }



    public Void visitSection(GetUMPStx.SectionContext ctx) {
        String structure = ctx.getStart().getText();
        String type = null;
        String label = null;
        String houseNumber = null;
        String streetDesc = null;
        String typ = null;
        int cityIdx = -1;
        int endLevel = -1;
        double latitude = 0.0; //było 0.0
        double longitude = 0.0; //było 0.0
        List<String> points = new ArrayList<>();

        for (GetUMPStx.KvEqContext kvEqContext : ctx.kvEq()) {
            if (kvEqContext.key != null) {
                // Przypadek 1: Nazwana grupa alternatyw
                Token keyNode = kvEqContext.key;
                TerminalNode valueNode = kvEqContext.V();

                switch (keyNode.getText()) {
                    case "Type":
                        type = valueNode.getText().trim();
                        break;
                    case "Label":
                        label = valueNode.getText().trim();
                        break;
                    case "HouseNumber":
                        houseNumber = valueNode.getText();
                        break;
                    case "StreetDesc":
                        streetDesc = valueNode.getText();
                        break;
                    case "Typ":
                        typ = valueNode.getText();
                        break;
                    case "CityIdx":
                        cityIdx = Integer.parseInt(valueNode.getText().trim());
                        break;
                    case "Data0":
                        String[] coordinates = valueNode.getText().replaceAll("[()]", "").split(",");
                        //String[] coordinates = valueNode.getText().split(",");
                        if(coordinates.length == 2) {
                            latitude = Double.parseDouble(coordinates[0]);
                            longitude = Double.parseDouble(coordinates[1]);
                        }
                        else if (coordinates.length > 2){
                            /*
                            for (String coordinate : coordinates) {
                                String[] parts = coordinate.split("\\),\\(");
                                if (parts.length == 2) {
                                    String latitude1 = parts[0].replaceAll("[()]", "").trim();
                                    String longitude1 = parts[1].replaceAll("[()]", "").trim();
                                    String point = longitude1 + " " + latitude1; // Współrzędne w formacie "longitude latitude"
                                    points.add(point);
                                } else {
                                    // Obsługa błędnego formatu danych
                                    System.out.println("Błędny format danych w sekcji Data0: " + coordinate);
                                }
                            }

                             */

                            String[] pairs = valueNode.getText().split("\\),\\(");
                            pairs[pairs.length - 1] = pairs[pairs.length - 1].replace(")", "").replace("(", "").trim();

                            for (String pair : pairs) {
                                String[] latLon = pair.split(",");
                                if (latLon.length == 2) {
                                    double latitude1 = Double.parseDouble(latLon[0].replace("(","").trim());
                                    double longitude1 = Double.parseDouble(latLon[1].trim());
                                    points.add(longitude1 + " " + latitude1);
                                } else {
                                    System.out.println("Błędny format danych: " + pair);
                                }
                            }
                            String firstPoint = points.get(0);
                            points.add(firstPoint);
                        }



                        break;
                    case "EndLevel":
                        endLevel = Integer.parseInt(valueNode.getText().trim());
                        break;
                    case "Miasto":
                        // Handle mapId retrieval from "Miasto" section
                        break;
                    default:
                        // Ignore other keys
                        break;
                }
            } else {
                // Przypadek 2: Bez grupy alternatyw
                TerminalNode idNode = kvEqContext.ID(); // było ID(0)
                TerminalNode numNode = kvEqContext.NUM();
                TerminalNode valueNode = kvEqContext.V();

                String key = idNode.getText(); // Uzyskujemy klucz z pierwszego ID
                String value = valueNode.getText();

                // Obsługa pary klucz-wartość dla przypadku 2
                switch (key) {
                    case "Type":
                        type = value.trim();
                        break;
                    case "Label":
                        label = value.trim();
                        break;
                    case "HouseNumber":
                        houseNumber = value;
                        break;
                    case "StreetDesc":
                        streetDesc = value;
                        break;
                    case "Typ":
                        typ = value;
                        break;
                    case "CityIdx":
                        cityIdx = Integer.parseInt(value);
                        break;
                    case "Data0", "Data1", "Data2", "Data3":
                        String[] coordinates = value.replaceAll("[()]", "").split(",");
                        if(coordinates.length == 2) {
                            latitude = Double.parseDouble(coordinates[0]);
                            longitude = Double.parseDouble(coordinates[1]);
                        }
                        else if (coordinates.length > 2){
                            for (String coordinate : coordinates) {
                                String[] parts = coordinate.replaceAll("[()]", "").split(",");
                                String point = parts[1].trim() + " " + parts[0].trim(); // Współrzędne w formacie "longitude latitude"
                                points.add(point);
                            }
                            String firstPoint = points.get(0);
                            points.add(firstPoint);
                        }
                        break;
                    case "EndLevel":
                        endLevel = Integer.parseInt(value);
                        break;
                    case "Miasto":
                        // Handle mapId retrieval from "Miasto" section
                        break;
                    default:
                        // Ignore other keys
                        break;
                }
            }
        }

        // Insert into database based on section type
        switch (structure) {
            case "[POLYLINE]":
                //insertPolyline(label, endLevel, cityIdx, points);
                break;
            case "[POLYGON]":
                //TODO przekazywanie numerka do data
                //insertPolygon(label, endLevel, cityIdx, points);
                break;
            case "[POI]":
                //insertPOI(type, label, endLevel, cityIdx, latitude, longitude, houseNumber, streetDesc, typ);
                break;
            default:
                // Unknown section type
                break;
        }

        return null;
    }

    private void insertPolyline(String label, int endLevel, int cityIdx, List<String> points) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO public1.polyline (label, end_level, city_idx, data0 )");
            queryBuilder.append("VALUES (?, ?, ?, public1.ST_GeomFromText('LINESTRING(");
            queryBuilder.append(String.join(",", points));
            queryBuilder.append(")') )");
            String query = queryBuilder.toString();

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, label);
                preparedStatement.setInt(2, endLevel);
                preparedStatement.setInt(3, cityIdx);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertPolygon(String label, int endLevel, int cityIdx, List<String> points) {
        String query = "INSERT INTO public1.polygon (label, end_level, city_idx, data0) VALUES (?, ?, ?, public1.ST_GeomFromText(?))";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, label);
            preparedStatement.setInt(2, endLevel);
            preparedStatement.setInt(3, cityIdx);

            String lineString = "POLYGON((" + String.join(",", points) + "))";
            preparedStatement.setString(4, lineString);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertPOI(String type, String label, int endLevel, int cityIdx, double latitude, double longitude, String houseNumber, String streetDesc, String typ) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO public1.POI (type, label, end_level, street_desc, house_number, location, city_idx, typ) VALUES (?, ?, ?, ?, ?, public1.ST_GeometryFromText('POINT(" + longitude + " " + latitude + ")'), ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, type);
                preparedStatement.setString(2, label);
                preparedStatement.setInt(3, endLevel);
                preparedStatement.setString(4, streetDesc);
                preparedStatement.setString(5, houseNumber);
                preparedStatement.setInt(6, cityIdx); // było 7 i 8
                preparedStatement.setString(7, typ);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to read and parse the input file
    public void parseFile(String filename) {
        try {
            //String content = new String(Files.readAllBytes(Paths.get(filename)));
            String content = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);


            GetUMPLex lexer = new GetUMPLex(CharStreams.fromString(content));
            GetUMPStx parser = new GetUMPStx(new CommonTokenStream(lexer));
            parser.removeErrorListeners(); // Remove the default error listeners
            parser.addErrorListener(new ThrowExceptionErrorListener()); // Add custom error listener
            parser.file().accept(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Custom error listener to throw exception on syntax error
    private static class ThrowExceptionErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            throw new ParseCancellationException("Syntax error at line " + line + ":" + charPositionInLine + " " + msg);
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
