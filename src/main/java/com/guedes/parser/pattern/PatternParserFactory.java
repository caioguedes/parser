package com.guedes.parser.pattern;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PatternParserFactory {
  public PatternParser create(String text) {
    if (Pattern.matches(CustomerPatternParser.LINE_PATTERN, text)) {
      return new CustomerPatternParser();
    }

    if (Pattern.matches(SellerPatternParser.LINE_PATTERN, text)) {
      return new SellerPatternParser();
    }

    if (Pattern.matches(SalePatternParser.LINE_PATTERN, text)) {
      return new SalePatternParser();
    }

    throw new RuntimeException("No parser was found.");
  }
}
