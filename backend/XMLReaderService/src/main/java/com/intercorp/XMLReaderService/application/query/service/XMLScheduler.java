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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
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
            Resource resource = new ClassPathResource("XML-Example");
            File folder = resource.getFile();
            if (folder.exists() && folder.isDirectory()) {
                File[] listOfFiles = folder.listFiles();
                Stream.of(Objects.requireNonNull(listOfFiles))
                        .filter(file -> file.isFile() && file.getName().matches("myXMLFile\\d+\\.xml"))
                        .skip(processedFiles)
                        .limit(10)
                        .forEach(this::processFile);
                processedFiles += 10;
            } else {
                log.error("Directory does not exist: {}", folder.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processFile(File file) {
        if (!VerifiedXML.isXMLWellFormed(file.getPath())) {
            VerifiedXML.correctXML(file.getPath());
        }
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Root root = new XmlMapper().readValue(inputStream, Root.class);
            log.info("Sending message to Kafka topic: {}", root);
            kafkaJsonProducer.sendMessage(root);
        } catch (Exception e) {
            log.error("Error processing XML file {}: {}", file.getName(), e.getMessage());
        }
    }


}