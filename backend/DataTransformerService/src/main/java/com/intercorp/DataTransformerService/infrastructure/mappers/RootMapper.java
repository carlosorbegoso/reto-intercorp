package com.intercorp.DataTransformerService.infrastructure.mappers;

import com.intercorp.DataTransformerService.domain.dto.RootDto;
import com.intercorp.DataTransformerService.infrastructure.dataacces.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class RootMapper {

    public static RootDto toRoot(Root root) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = LocalDateTime.now().format(formatter);

        Map<String, Integer> ages = root.personDetails().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().age()
                ));

        Integer age = ages.get(root.personDetails().keySet().iterator().next());


        return new RootDto(
                root.id(),
               PersonMapper.toPerson(root.person(),age),
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
