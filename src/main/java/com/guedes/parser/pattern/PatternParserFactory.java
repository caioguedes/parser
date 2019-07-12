package com.guedes.parser.pattern;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PatternParserFactory {
  private static final List<PatternParser> parsers = Arrays.asList(
      new CustomerPatternParser(),
      new SellerPatternParser(),
      new SalePatternParser()
  );

  public PatternParser create(String text) {
    return parsers.stream().filter(parse -> parse.check(text)).findFirst().orElseThrow(() ->
        new RuntimeException("No parser was found."));
  }
}
