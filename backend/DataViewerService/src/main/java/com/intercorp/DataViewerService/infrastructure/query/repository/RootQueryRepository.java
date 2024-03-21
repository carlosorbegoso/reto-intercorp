package com.intercorp.DataViewerService.infrastructure.query.repository;

import com.intercorp.DataViewerService.infrastructure.dataaccess.RootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RootQueryRepository extends JpaRepository<RootEntity,Long> {
    RootEntity findByRootId(String root_id);
}
