package de.ebcsoft.customerapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDto {

    private Long id;

    @JsonProperty("Vorname")
    private String firstName;
    @JsonProperty("Nachname")
    private String lastName;
    @JsonProperty("Wohnort")
    private String city;

}
