
package org.agesadev.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Generated("net.hexar.json2pojo")
public class Country {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("NewConfirmed")
    private Long newConfirmed;
    @JsonProperty("NewDeaths")
    private Long newDeaths;
    @JsonProperty("NewRecovered")
    private Long newRecovered;
    @JsonProperty("Premium")
    private Premium premium;
    @JsonProperty("Slug")
    private String slug;
    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;
    @JsonProperty("TotalDeaths")
    private Long totalDeaths;
    @JsonProperty("TotalRecovered")
    private Long totalRecovered;


}
