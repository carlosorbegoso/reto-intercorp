package com.intercorp.DataViewerService.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

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
        String creationDate
) {


}