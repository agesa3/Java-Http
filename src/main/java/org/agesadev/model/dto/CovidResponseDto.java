
package org.agesadev.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Generated("net.hexar.json2pojo")
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
