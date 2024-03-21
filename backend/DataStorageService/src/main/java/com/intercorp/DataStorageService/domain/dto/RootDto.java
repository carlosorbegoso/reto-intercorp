package com.intercorp.DataStorageService.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record RootDto(
        String id,
         PersonDto person,
         Integer random,
         Float random_float,
         Boolean bool,
         String date,
         String regEx,
         @JsonProperty("enum")
         String enumValue,
         String elt,
         Map<String, PersonDetailsDto> personDetails
) {


}