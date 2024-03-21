package com.intercorp.DataTransformerService.infrastructure.mappers;

import com.intercorp.DataTransformerService.domain.dto.PersonDto;
import com.intercorp.DataTransformerService.infrastructure.dataacces.Person;

public class PersonMapper {
    public static PersonDto toPerson(Person person,Integer age) {
        return new PersonDto(
                person.firstname(),
                person.lastname(),
                age,
                person.city(),
                person.country(),
                person.firstname2(),
                person.lastname2(),
                person.email()
        );
    }
}
