package com.intercorp.XMLReaderService.infrastructure.producer;

import com.intercorp.XMLReaderService.infrastructure.model.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {
    private final KafkaTemplate<String, Root> kafkaTemplate;

    public void sendMessage(Root root){
        Message<Root> message = MessageBuilder
                .withPayload(root)
                        .setHeader(KafkaHeaders.TOPIC, "topic1-reto")
                                .build();
        kafkaTemplate.send(message);
    }

}
