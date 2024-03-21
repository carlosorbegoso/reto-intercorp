package com.intercorp.DataTransformerService.infrastructure.mappers;

import com.intercorp.DataTransformerService.domain.dto.RootDto;
import com.intercorp.DataTransformerService.infrastructure.dataacces.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RootMapper {

    public static RootDto toRoot(Root root) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = LocalDateTime.now().format(formatter);
        System.out.printf ("age --------->"+ root.person().age() );
        return new RootDto(
                root.id(),
               PersonMapper.toPerson(root.person()),
                root.random(),
                root.random_float(),
                root.bool(),
                root.date(),
                root.regEx(),
                root.enumValue(),
                root.elt(),
                formattedDate
        );
    }
}
