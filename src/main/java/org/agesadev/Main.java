package org.agesadev;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.agesadev.model.dto.Country;
import org.agesadev.model.entity.CountryData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {

    private static final String BASE_URL = "https://api.covid19api.com/summary";

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
        }
    }
}