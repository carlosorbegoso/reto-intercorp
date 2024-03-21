package com.intercorp.XMLReaderService.infrastructure.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableKafka
public class KafkaProducer {
    // The KafkaTemplate is used to send messages to a Kafka topic.
    private final KafkaTemplate<String,String> kafkaTemplate;
    /**
     * Sends a message to the "topic-reto" Kafka topic.
     *
     * @param message The message to be sent.
     */
    public void sendMessage(String message){
        log.info(String.format("Sending message to topic: %s", message));
        kafkaTemplate.send("topic-reto", message);
    }
}
