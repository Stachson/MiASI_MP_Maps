package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseConnection {

   private String url = "jdbc:postgresql://mydbinstance.czue2casejbn.us-east-1.rds.amazonaws.com:5432/ZaawansowaneBazyDanych";
   private String user = "postgres";
   private String password = "pwritehaslo";


    public void connectToDatabase() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Połączenie z bazą danych PostgreSQL zostało pomyślnie ustanowione.");
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas próby połączenia z bazą danych:");
            e.printStackTrace();
        }
    }

    public List<String> executeQuery(String query){
        String name = "";
        List<String> nameList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    // Przetwarzanie wyników zapytania
                    int id = resultSet.getInt("id");
                    name = resultSet.getString("nazwa");
                    nameList.add(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (String n:nameList) {
            System.out.println(n);
        }
        return nameList;
    }

    public void add_map(byte[] fileBytes, String fileName, List<String> lines) {

        int generatedId = -1;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mapa_pfm (nazwa, plik_pfm) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, fileName); // Ustawienie nazwy pliku
                preparedStatement.setBytes(2, fileBytes); // Ustawienie zawartości pliku w formacie binarnym
                //preparedStatement.setString();

                System.out.println("start");
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                        System.out.println("Generated ID: " + generatedId);
                    } else {
                        throw new SQLException("Creating map failed, no ID obtained.");
                    }
                }



                System.out.println("Plik zapisany");

                process_Lines(lines, generatedId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private void process_Lines(List<String> lines, int mapId){
        List<String> current = new ArrayList<>();
        boolean inPOI = false;
        boolean inPOLYLINE = false;
        boolean inPOLYGON = false;

        for (String line : lines) {
            if (line.startsWith("[POI]")) {
                inPOI = true;
                current.clear(); // Clear currentPOI list
            } else if (line.startsWith("[END]") && inPOI) {
                inPOI = false;
                current.add(line); // Add [END] line to currentPOI list
                processPOI(current, mapId);
            } else if (inPOI) {
                current.add(line);
            } else if( line.startsWith("[POLYLINE]")){
                inPOLYLINE = true;
                current.clear();
            } else if (line.startsWith("[END]") && inPOLYLINE) {
                inPOLYLINE = false;
                current.add(line);
                processPOLYLINE(current, mapId);
            } else if (inPOLYLINE){
                current.add(line);
            } else if( line.startsWith("[POLYGON]")){
                inPOLYGON = true;
                current.clear();
            } else if (line.startsWith("[END]") && inPOLYGON) {
                inPOLYGON = false;
                current.add(line);
                processPOLYGON(current, mapId);
            } else if (inPOLYGON){
                current.add(line);
            }

        }
    }

    private void processPOI(List<String> poiData, int mapId){

        String label = null;
        String type = null;
        int endLevel = -1;
        String streetDesc = null;
        String houseNumber = null;
        double latitude = -1;
        double longitude = -1;
        int cityIdx = -1;
        String plik = null;
        String typ = null;

        // Przetwarzanie danych linia po linii
        for (String line : poiData) {
            if (line.startsWith("Label=")) {
                label = line.substring("Label=".length());
            } else if (line.startsWith("Type=")) {
                type = line.substring("Type=".length());
            } else if (line.startsWith("EndLevel=")) {
                endLevel = Integer.parseInt(line.substring("EndLevel=".length()));
            } else if (line.startsWith("StreetDesc=")) {
                streetDesc = line.substring("StreetDesc=".length());
            } else if (line.startsWith("HouseNumber=")) {
                houseNumber = line.substring("HouseNumber=".length());
            } else if (line.startsWith("Data0=")) {
                String coordinatesStr = line.substring("Data0=".length(), line.length() - 1).replaceAll("[()]", ""); // Usunięcie nawiasów okrągłych
                String[] coordinates = coordinatesStr.split(",");
                latitude = Double.parseDouble(coordinates[0]);
                longitude = Double.parseDouble(coordinates[1]);
            } else if (line.startsWith("CityIdx=")) {
                cityIdx = Integer.parseInt(line.substring("CityIdx=".length()));
            } else if (line.startsWith("Plik=")) {
                plik = line.substring("Plik=".length());
            } else if (line.startsWith("Typ=")) {
                typ = line.substring("Typ=".length());

            }
        }

            savePOIToDB(mapId, type, label, endLevel, streetDesc, houseNumber, latitude, longitude, cityIdx, plik, typ);
    }

    private void processPOLYLINE(List<String> polylineData, int mapId){

        String label = null;
        String type = null;
        int endLevel = -1;
        double latitude = -1;
        double longitude = -1;
        int cityIdx = -1;
        String city = null;
        String plik = null;
        String[] numbers = new String[16];
        List<String> points = new ArrayList<>();
        // Przetwarzanie danych linia po linii
        for (String line : polylineData) {
            if (line.startsWith("Label=")) {
                label = line.substring("Label=".length());
            } else if (line.startsWith("Type=")) {
                type = line.substring("Type=".length());
            } else if (line.startsWith("EndLevel=")) {
                endLevel = Integer.parseInt(line.substring("EndLevel=".length()));
            } else if (line.startsWith("Data0=")) {
                String coordinatesStr = line.substring("Data0=".length());
                String[] coordinates = coordinatesStr.split("\\),\\(");
                for (String coordinate : coordinates) {
                    String[] parts = coordinate.replaceAll("[()]", "").split(",");
                    String point = parts[1].trim() + " " + parts[0].trim(); // Współrzędne w formacie "longitude latitude"
                    points.add(point);
                }
            } else if (line.startsWith("CityIdx=")) {
                cityIdx = Integer.parseInt(line.substring("CityIdx=".length()));
            } else if (line.startsWith("Plik=")) {
                plik = line.substring("Plik=".length());
            } else if (line.startsWith("Miasto=")) {
                city = line.substring("Miasto=".length());
            } else if (line.startsWith("Numbers1=")){
                numbers[0] = line.substring("Numbers1=".length());
            }  else if (line.startsWith("Numbers2=")){
                numbers[1] = line.substring("Numbers2=".length());
            }  else if (line.startsWith("Numbers3=")){
                numbers[2] = line.substring("Numbers3=".length());
            }  else if (line.startsWith("Numbers4=")){
                numbers[3] = line.substring("Numbers4=".length());
            }  else if (line.startsWith("Numbers5=")){
                numbers[4] = line.substring("Numbers5=".length());
            }  else if (line.startsWith("Numbers6=")){
                numbers[5] = line.substring("Numbers6=".length());
            }  else if (line.startsWith("Numbers7=")){
                numbers[6] = line.substring("Numbers7=".length());
            }  else if (line.startsWith("Numbers8=")){
                numbers[7] = line.substring("Numbers8=".length());
            }  else if (line.startsWith("Numbers9=")){
                numbers[8] = line.substring("Numbers9=".length());
            }  else if (line.startsWith("Numbers10=")){
                numbers[9] = line.substring("Numbers10=".length());
            }  else if (line.startsWith("Numbers11=")){
                numbers[10] = line.substring("Numbers11=".length());
            }  else if (line.startsWith("Numbers12=")){
                numbers[11] = line.substring("Numbers12=".length());
            }  else if (line.startsWith("Numbers13=")){
                numbers[12] = line.substring("Numbers13=".length());
            }  else if (line.startsWith("Numbers14=")){
                numbers[13] = line.substring("Numbers14=".length());
            }  else if (line.startsWith("Numbers15=")){
                numbers[14] = line.substring("Numbers15=".length());
            }  else if (line.startsWith("Numbers16=")){
                numbers[15] = line.substring("Numbers16=".length());
            }
        }

        savePOLYLINEToDB(mapId, type, label, endLevel, points, numbers, cityIdx, city, plik);
    }

    private void processPOLYGON(List<String> polygonData, int mapId){


        String type = null;
        int endLevel = -1;
        List<String> points = new ArrayList<>();
        String plik = null;
        String label = null;

        // Przetwarzanie danych linia po linii
        for (String line : polygonData) {
            if (line.startsWith("Label=")) {
                label = line.substring("Label=".length());
            } else if (line.startsWith("Type=")) {
                type = line.substring("Type=".length());
            } else if (line.startsWith("EndLevel=")) {
                endLevel = Integer.parseInt(line.substring("EndLevel=".length()));
            } else if (line.startsWith("Data0=")) {
                String coordinatesStr = line.substring("Data0=".length());
                String[] coordinates = coordinatesStr.split("\\),\\(");
                for (String coordinate : coordinates) {
                    String[] parts = coordinate.replaceAll("[()]", "").split(",");
                    String point = parts[1].trim() + " " + parts[0].trim(); // Współrzędne w formacie "longitude latitude"
                    points.add(point);
                }
            }  else if (line.startsWith("Plik=")) {
                plik = line.substring("Plik=".length());
            }
        }
        savePOLYGONToDB(mapId, type, label, endLevel, points, plik);
    }





    private void savePOIToDB(int mapId, String type, String label, int endLevel, String streetDesc, String houseNumber, double latitude, double longitude, int cityIdx, String plik, String typ){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO public1.POI (map_id, type, label, end_level, street_desc, house_number, location, city_idx, plik, typ) VALUES (?, ?, ?, ?, ?, ?, ST_GeographyFromText('POINT(" + longitude + " " + latitude + ")'), ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, mapId);
                preparedStatement.setString(2, type);
                preparedStatement.setString(3, label);
                preparedStatement.setInt(4, endLevel);
                preparedStatement.setString(5, streetDesc);
                preparedStatement.setString(6, houseNumber);
                preparedStatement.setInt(7, cityIdx);
                preparedStatement.setString(8, plik);
                preparedStatement.setString(9, typ);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void savePOLYLINEToDB(int mapId, String type, String label, int endLevel, List<String> points, String[] numbers, int cityIdx, String city, String plik) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO public1.polyline (map_id, type, label, end_level, data0, ");
            for (int i = 1; i <= 16; i++) {
                queryBuilder.append("numbers").append(i).append(", ");
            }
            queryBuilder.append("city_idx, miasto, plik) ");
            queryBuilder.append("VALUES (?, ?, ?, ?, ST_GeomFromText('LINESTRING(");
            queryBuilder.append(String.join(",", points));
            queryBuilder.append(")'), ");
            for (int i = 0; i < 16; i++) {
                queryBuilder.append("?, ");
            }
            queryBuilder.append("?, ?, ?)");

            String query = queryBuilder.toString();

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, mapId);
                preparedStatement.setString(2, type);
                preparedStatement.setString(3, label);
                preparedStatement.setInt(4, endLevel);
                for (int i = 0; i < 16; i++) {
                    preparedStatement.setString(5 + i, numbers[i]);
                }
                preparedStatement.setInt(21, cityIdx);
                preparedStatement.setString(22, city);
                preparedStatement.setString(23, plik);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void savePOLYGONToDB(int mapId, String type, String label, int endLevel, List<String> points,  String plik) {
        String query = "INSERT INTO public1.polygon (map_id, type, end_level, plik, label, data0) VALUES (?, ?, ?, ?, ?, ST_GeomFromText(?))";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, mapId);
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, endLevel);
            preparedStatement.setString(4, plik);
            preparedStatement.setString(5, label);

            String lineString = "LINESTRING(" + String.join(",", points) + ")";
            preparedStatement.setString(6, lineString);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}



