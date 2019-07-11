package com.guedes.parser;

import com.guedes.parser.service.DirectoryWatcherService;
import com.guedes.parser.service.SalesReportService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserApplication implements CommandLineRunner {

  public static Logger logger = LoggerFactory.getLogger(ParserApplication.class);
  private SalesReportService salesReportService;

  @Autowired
  public ParserApplication(SalesReportService salesReportService) {
    this.salesReportService = salesReportService;
  }

  public static void main(String[] args) {
    SpringApplication.run(ParserApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Starting Parser Application");
    logger.info("Watching '/data/in' directory....");

    Path inputDirectory = Paths.get("data/in/");
    Path outputDirectory = Paths.get("data/out/");

    DirectoryWatcherService watcher = new DirectoryWatcherService(logger);
    watcher.start(
        inputDirectory,
        file -> {
          try {
            Path output = this.salesReportService.generate(file, outputDirectory);
            String filename = file.getFileName().toString();
            Files.delete(file);
            logger.info("Output generated at [{}].", file.getFileName().toAbsolutePath());
            logger.info("File [{}] deleted!", filename);
            return output;
          } catch (Exception exception) {
            logger.error(exception.getMessage());
            return null;
          }
        });
  }
}
