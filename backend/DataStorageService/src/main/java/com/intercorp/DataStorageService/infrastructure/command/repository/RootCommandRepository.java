package com.intercorp.DataStorageService.infrastructure.command.repository;

import com.intercorp.DataStorageService.infrastructure.dataaccess.RootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RootCommandRepository extends JpaRepository<RootEntity,Long> {
}
