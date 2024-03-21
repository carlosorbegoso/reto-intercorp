package com.intercorp.DataTransformerService.infrastructure.producer;

import com.intercorp.DataTransformerService.domain.dto.RootDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {
    private final KafkaTemplate<String, String> kafkaProducer;

    public void sendJsonMessage(String topic, RootDto root) {
        Message<RootDto> message = MessageBuilder
                .withPayload(root)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaProducer.send(message);
    }
}
