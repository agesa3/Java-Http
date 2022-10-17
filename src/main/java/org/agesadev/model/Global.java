
package org.agesadev.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.processing.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Global {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("NewConfirmed")
    private Long newConfirmed;
    @JsonProperty("NewDeaths")
    private Long newDeaths;
    @JsonProperty("NewRecovered")
    private Long newRecovered;
    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;
    @JsonProperty("TotalDeaths")
    private Long totalDeaths;
    @JsonProperty("TotalRecovered")
    private Long totalRecovered;

}
