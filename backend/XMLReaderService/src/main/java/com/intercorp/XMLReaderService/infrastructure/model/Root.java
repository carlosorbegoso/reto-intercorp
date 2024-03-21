package com.intercorp.XMLReaderService.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private String id;
    private Person person;
    private Integer random;
    private Float random_float;
    private Boolean bool;
    private String date;
    private String regEx;
    @JsonProperty("enum")
    private String enuValue;
    private String elt;

    private Map<String, PersonDetails> personDetails = new HashMap<>();
    public Root() {
        this.id = UUID.randomUUID().toString();
    }
    @JsonAnySetter
    public void addPersonDetails(String name, PersonDetails personDetails) {
        this.personDetails.put(name, personDetails);
    }

}