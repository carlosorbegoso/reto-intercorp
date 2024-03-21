package com.intercorp.DataViewerService.infrastructure.mappers;

import com.intercorp.DataViewerService.domain.dto.RootDto;
import com.intercorp.DataViewerService.infrastructure.dataaccess.RootEntity;

public class RootDtoMapper {
    public static RootDto toRootDto(RootEntity rootDtoFormBD) {
        return new RootDto(
                rootDtoFormBD.getRootId(),
                PersonDtoMapper.toPersonDto(rootDtoFormBD.getPerson()),
                rootDtoFormBD.getRandom(),
                rootDtoFormBD.getRandom_float(),
                rootDtoFormBD.getBool(),
                rootDtoFormBD.getDate().toString(),
                rootDtoFormBD.getRegEx(),
                rootDtoFormBD.getEnumValue(),
                rootDtoFormBD.getElt(),
                rootDtoFormBD.getRootId()
        );
    }
}
