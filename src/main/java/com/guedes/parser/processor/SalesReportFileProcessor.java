package com.guedes.parser.processor;

import com.guedes.parser.entity.Entity;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.pattern.PatternParserFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesReportFileProcessor {

  private PatternParserFactory parserFactory;

  @Autowired
  public SalesReportFileProcessor(PatternParserFactory parserFactory) {
    this.parserFactory = parserFactory;
  }

  public SalesReportOutput process(Path input) throws IOException {
    List<Entity> entities =
        Files.lines(input)
            .parallel()
            .map(line -> this.parserFactory.create(line).parse(line))
            .collect(Collectors.toList());

    return new SalesReportOutput(entities);
  }
}
