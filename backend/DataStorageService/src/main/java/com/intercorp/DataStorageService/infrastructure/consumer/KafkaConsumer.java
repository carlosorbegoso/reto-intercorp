package com.intercorp.DataStorageService.infrastructure.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.DataStorageService.application.query.service.RooCommandService;
import com.intercorp.DataStorageService.domain.dto.RootDto;
import com.intercorp.DataStorageService.infrastructure.mapper.RootMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
            log.info("Consumed message -> {}", root);
            rooCommandService.saveRootEntity(RootMapper.toRootEntity(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}