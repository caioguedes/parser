package com.guedes.parser.pattern;

import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.SaleItem;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class SalePatternParser implements PatternParser<Sale> {
  private static final String LINE_ITEM_PATTERN = "((\\d)-(\\d)-([0-9]*\\.?[0-9]))";
  private static final String LINE_PATTERN = "003ç(\\d+)ç(.+)ç([a-zA-Z].+)";

  public boolean check(String text) {
    return Pattern.matches(LINE_PATTERN, text);
  }

  public Sale parse(String text) {
    Matcher matcher = Pattern.compile(LINE_PATTERN).matcher(text);

    if (!matcher.matches()) {
      return null;
    }

    Matcher matcherItems = Pattern.compile(LINE_ITEM_PATTERN).matcher(matcher.group(2));
    List<SaleItem> items = new ArrayList<>();

    while (matcherItems.find()) {
      items.add(new SaleItem(
          Long.parseLong(matcherItems.group(2)),
          Long.parseLong(matcherItems.group(3)),
          Double.parseDouble(matcherItems.group(4))
      ));
      matcherItems.end();
    }

    return new Sale(Long.parseLong(matcher.group(1)), items, matcher.group(3));
  }
}
