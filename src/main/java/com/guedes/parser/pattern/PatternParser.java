package com.guedes.parser.pattern;

import com.guedes.parser.entity.Entity;

public interface PatternParser<T extends Entity> {
  boolean check(String text);
  T parse(String text);
}
