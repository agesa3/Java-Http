
package org.agesadev.model.dto;


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
