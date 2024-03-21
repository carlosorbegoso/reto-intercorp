package com.intercorp.DataTransformerService.infrastructure.dataacces;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Root(
        String id,
        Person person,
        Integer random,
        Float random_float,
        Boolean bool,
        String date,
        String regEx,
        @JsonProperty("enum")
        String enumValue,
        String elt,
        Map<String, PersonDetails> personDetails
) {


}