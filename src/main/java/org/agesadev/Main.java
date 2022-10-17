package org.agesadev;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.agesadev.model.dto.Country;
import org.agesadev.model.entity.CountryData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final String BASE_URL = "https://api.covid19api.com/summary";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Lister7Lister@";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(BASE_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            JsonNode countries = root.path("Countries");
            List<Country> countryList = mapper.readValue(countries.toString(), new TypeReference<>() {
            });
            countryList.forEach(country -> {
                CountryData countryData = CountryData.builder()
                        .countryId(country.getID())
                        .countryName(country.getCountry())
                        .countryCode(country.getCountryCode())
                        .date(country.getDate()).build();
                System.out.println(countryData);
            });

            try {
                Class.forName(JDBC_DRIVER);
                Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO country_covid_data (countryId, country_name, country_code, today_date) VALUES (?, ?, ?, ?)");
                countryList.forEach(country -> {
                    try {
                        preparedStatement.setString(1, country.getID());
                        preparedStatement.setString(2, country.getCountry());
                        preparedStatement.setString(3, country.getCountryCode());
                        preparedStatement.setString(4, country.getDate());
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}