package de.ebcsoft.customerapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressesDto {

    @JsonProperty("Straße")
    private String street;
    @JsonProperty("Hausnummer")
    private String houseNumber;
    @JsonProperty("PLZ")
    private String plz;
    @JsonProperty("Wohnort")
    private String city;
}
