package com.intercorp.XMLReaderService.application.query.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.intercorp.XMLReaderService.infrastructure.model.PersonDetails;
import com.intercorp.XMLReaderService.infrastructure.model.Root;
import com.intercorp.XMLReaderService.infrastructure.producer.KafkaJsonProducer;
import com.intercorp.XMLReaderService.infrastructure.utils.VerifiedXML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Objects;
import java.util.stream.Stream;

@Component
@Slf4j
public class XMLScheduler {

    private final KafkaJsonProducer kafkaJsonProducer;
    private int processedFiles = 0;

    public XMLScheduler(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @Scheduled(fixedRate = 180000)
    public void processXMLFiles() {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:XML-Example/*.xml");
            Stream.of(resources)
                    .filter(resource -> resource.getFilename() != null && resource.getFilename().matches("myXMLFile\\d+\\.xml"))
                    .skip(processedFiles)
                    .limit(10)
                    .forEach(this::processResource);
            processedFiles += 10;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processResource(Resource resource) {
        try (InputStream inputStream = resource.getInputStream()) {
            Root root = new XmlMapper().readValue(inputStream, Root.class);
            log.info("Sending message to Kafka topic: {}", root);
            kafkaJsonProducer.sendMessage(root);
        } catch (Exception e) {
            log.error("Error processing XML resource: {}", e.getMessage());
        }
    }
}