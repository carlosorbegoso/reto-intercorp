package com.intercorp.DataStorageService.infrastructure.mapper;

import com.intercorp.DataStorageService.domain.dto.RootDto;
import com.intercorp.DataStorageService.infrastructure.dataaccess.RootEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class RootMapper {
    public static RootEntity toRootEntity(RootDto root) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(root.date(), formatter);

        Map<String, Integer> ages = root.personDetails().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().age()
                ));

        Integer age = ages.get(root.personDetails().keySet().iterator().next());

        return new RootEntity(
                null,
                PersonMapper.toPersonEntity(root.person(),
                       age),
                root.random(),
                root.random_float(),
                root.bool(),
                date,
                root.regEx(),
                root.enumValue(),
                root.elt(),
                root.id()

        );
    }
}
