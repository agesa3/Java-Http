package org.agesadev.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryData {
    private String countryId;
    private String countryName;
    private String countryCode;
    private String date;
}
