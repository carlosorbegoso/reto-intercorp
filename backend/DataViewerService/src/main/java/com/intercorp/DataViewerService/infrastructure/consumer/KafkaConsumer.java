package com.intercorp.DataViewerService.infrastructure.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.DataViewerService.application.query.service.RootQueryService;

import com.intercorp.DataViewerService.domain.dto.RootDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final RootQueryService rootCommandService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public KafkaConsumer(RootQueryService rootCommandService) {
        this.rootCommandService = rootCommandService;
    }

    @KafkaListener(topics = "topic2-reto")
    public void consumeJsonMessage(ConsumerRecord<String, String> record) {
        try {
            String message = record.value();
            RootDto root = objectMapper.readValue(message, RootDto.class);
            rootCommandService.listRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}