package com.guedes.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserApplication implements CommandLineRunner {

	public static Logger logger = LoggerFactory.getLogger(ParserApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Parser Application");
		SpringApplication.run(ParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Done!");
	}
}
