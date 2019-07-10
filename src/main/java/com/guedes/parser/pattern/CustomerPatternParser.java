package com.guedes.parser.pattern;

import com.guedes.parser.entity.Customer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class CustomerPatternParser implements PatternParser<Customer> {
  private static final String LINE_PATTERN = "002ç(\\d+)ç([a-zA-z].+)ç([a-zA-z].+)";

  public boolean check(String text) {
    return Pattern.matches(LINE_PATTERN, text);
  }

  public Customer parse(String text) {
    Matcher matcher = Pattern.compile(LINE_PATTERN).matcher(text);

    if (!matcher.matches()) {
      return null;
    }

    return new Customer(
        matcher.group(1),
        matcher.group(2),
        matcher.group(3)
    );
  }
}
