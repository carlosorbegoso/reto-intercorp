package com.intercorp.DataViewerService.infrastructure.mappers;

import com.intercorp.DataViewerService.domain.dto.PersonDto;
import com.intercorp.DataViewerService.infrastructure.dataaccess.PersonEntity;

public class PersonDtoMapper {
    public static PersonDto toPersonDto(PersonEntity person) {
        return new PersonDto(
                person.getFirstname(),
                person.getLastname(),
                person.getAge(),
                person.getCity(),
                person.getCountry(),
                person.getFirstname2(),
                person.getLastname2(),
                person.getEmail()
        );
    }
}
