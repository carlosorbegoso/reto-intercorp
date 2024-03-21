package com.intercorp.DataStorageService.infrastructure.mapper;

import com.intercorp.DataStorageService.domain.dto.PersonDto;
import com.intercorp.DataStorageService.infrastructure.dataaccess.PersonEntity;

public class PersonMapper {
    public static PersonEntity toPersonEntity(PersonDto person,Integer age) {
        return
                new PersonEntity(
                        null,
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
