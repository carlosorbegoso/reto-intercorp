package com.intercorp.DataViewerService.application.query.service;


import com.intercorp.DataViewerService.domain.dto.RootDto;
import com.intercorp.DataViewerService.infrastructure.query.repository.RootQueryRepository;
import com.intercorp.DataViewerService.infrastructure.dataaccess.RootEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootQueryService {
    private final RootQueryRepository rootCommandRepository;
    List<RootDto> rootDtoList = new ArrayList<>();
    public RootQueryService(RootQueryRepository rootCommandRepository) {
        this.rootCommandRepository = rootCommandRepository;
    }

    public void listRoot(RootDto rootDto) {
        RootEntity rootDtoFormBD = rootCommandRepository.findByRootId(rootDto.id());
        if(!rootDto.equals(rootDtoFormBD)) {
            rootDtoList.add(rootDto);
        }
    }
    public List<RootDto> listRoot(){
        return rootDtoList;
    }

}
