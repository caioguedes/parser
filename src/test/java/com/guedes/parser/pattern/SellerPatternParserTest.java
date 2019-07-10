package com.guedes.parser.pattern;

import static org.junit.Assert.*;

import com.guedes.parser.entity.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SellerPatternParserTest {
  @Test
  public void shouldReturnFalseGivenInvalidTextFormats() {
    SellerPatternParser format = new SellerPatternParser();

    assertFalse(format.check(""));
    assertFalse(format.check("ççç"));
    assertFalse(format.check("001ççç00.01"));
    assertFalse(format.check("ç001çç0,1"));
  }

  @Test
  public void shouldReturnFalseGivenValidTextFormats() {
    SellerPatternParser format = new SellerPatternParser();

    assertTrue(format.check("001ç0010020030çSellerç159"));
    assertTrue(format.check("001ç0010020030çSeller With Spaceç00.10"));
    assertTrue(format.check("001ç0010020030çSeller Wiçth Spaceç12355"));
  }

  @Test
  public void shouldReturnValidEntityWithGivenText() {
    SellerPatternParser format = new SellerPatternParser();

    Seller seller = format.parse("001ç0010020030çSeller Wiçth Spaceç1235.5");

    assertEquals("0010020030", seller.getDocument());
    assertEquals("Seller Wiçth Space", seller.getName());
    assertEquals(1235.5d, seller.getSalary(), 0.001);
  }
}
