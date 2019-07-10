package com.guedes.parser.pattern;

public interface PatternParser<T> {
  public boolean check(String text);
  public T parse(String text);
}
