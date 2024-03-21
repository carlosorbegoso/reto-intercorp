package com.intercorp.DataStorageService.application.query.service;

import com.intercorp.DataStorageService.infrastructure.command.repository.RootCommandRepository;
import com.intercorp.DataStorageService.infrastructure.dataaccess.RootEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service

public class RooCommandService {
    private final RootCommandRepository rootCommandRepository;

    public RooCommandService(RootCommandRepository rootCommandRepository) {
        this.rootCommandRepository = rootCommandRepository;
    }

    public void saveRootEntity(RootEntity rootEntity) {
        rootCommandRepository.save(rootEntity);
    }
}
