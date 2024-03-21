package com.intercorp.DataTransformerService.infrastructure.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.DataTransformerService.domain.dto.RootDto;
import com.intercorp.DataTransformerService.infrastructure.dataacces.Root;
import com.intercorp.DataTransformerService.infrastructure.mappers.RootMapper;
import com.intercorp.DataTransformerService.infrastructure.producer.KafkaJsonProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    private final KafkaJsonProducer kafkaJsonProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public KafkaConsumer(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @KafkaListener(topics = "topic1-reto")
    public void consumeJsonMessage(ConsumerRecord<String, String> record) {
        try {
            String message = record.value();
            Root root = objectMapper.readValue(message, Root.class);
            log.info("Consumed message -> {}", root);
            kafkaJsonProducer.sendJsonMessage("topic2-reto", RootMapper.toRoot(root));

        } catch (Exception e) {
            log.error("Error processing message: {}",  e);
        }
    }
}
