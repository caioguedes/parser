package com.guedes.parser.pattern;

import com.guedes.parser.entity.Seller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class SellerPatternParser implements PatternParser<Seller> {
  public static final String LINE_PATTERN = "001ç(\\d+)ç([a-zA-z].+)ç(\\d+.\\d+)";

  public boolean check(String text) {
    return Pattern.matches(LINE_PATTERN, text);
  }

  public Seller parse(String text) {
    Matcher matcher = Pattern.compile(LINE_PATTERN).matcher(text);

    if (!matcher.matches()) {
      return null;
    }

    return new Seller(
        matcher.group(1),
        matcher.group(2),
        Double.parseDouble(matcher.group(3))
    );
  }
}
