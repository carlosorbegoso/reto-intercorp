package com.intercorp.DataTransformerService.domain.dto;

public record PersonDto(
     String firstname,
     String lastname,
     Integer age,
     String city,
     String country,
     String firstname2,
     String lastname2,
     String email)
        {
}
