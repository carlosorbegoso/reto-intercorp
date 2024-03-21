package com.intercorp.DataViewerService.infrastructure.query.controller;

import com.intercorp.DataViewerService.application.query.service.RootQueryService;
import com.intercorp.DataViewerService.domain.dto.RootDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("root")
@CrossOrigin("*")
public class RootQueryController {
    final RootQueryService rootQueryService;

    public RootQueryController(RootQueryService rootQueryService) {
        this.rootQueryService = rootQueryService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<RootDto>> listRoot(){
        return ResponseEntity.ok( rootQueryService.listRoot());
    }
}
