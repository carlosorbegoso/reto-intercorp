package com.intercorp.DataStorageService.infrastructure.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.DataStorageService.application.query.service.RooCommandService;
import com.intercorp.DataStorageService.domain.dto.RootDto;
import com.intercorp.DataStorageService.infrastructure.mapper.RootMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class KafkaConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RooCommandService rooCommandService;

    public KafkaConsumer(RooCommandService rooCommandService) {
        this.rooCommandService = rooCommandService;
    }

    @KafkaListener(topics = "topic1-reto")
    public void consumeJsonMessage(ConsumerRecord<String, String> record) {
        try {
            String message = record.value();
            RootDto root = objectMapper.readValue(message, RootDto.class);
            System.out.printf("Consumed message -> %s%n", root);
            rooCommandService.saveRootEntity(RootMapper.toRootEntity(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}