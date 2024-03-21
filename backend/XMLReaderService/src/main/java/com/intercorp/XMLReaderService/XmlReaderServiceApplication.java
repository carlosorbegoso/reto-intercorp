package com.intercorp.XMLReaderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XmlReaderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlReaderServiceApplication.class, args);
	}

}
