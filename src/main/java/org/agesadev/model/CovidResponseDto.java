
package org.agesadev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CovidResponseDto {

    @JsonProperty("Countries")
    private List<Country> countries;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Global")
    private Global global;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Message")
    private String message;


}
