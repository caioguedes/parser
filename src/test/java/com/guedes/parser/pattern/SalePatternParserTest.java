package com.guedes.parser.pattern;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.SaleItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalePatternParserTest {
  @Test
  public void shouldReturnFalseGivenInvalidTextFormats() {
    SalePatternParser format = new SalePatternParser();

    assertFalse(format.check(""));
    assertFalse(format.check("ççç"));
    assertFalse(format.check("003ççç"));
    assertFalse(format.check("ç003çç"));
  }

  @Test
  public void shouldReturnFalseGivenValidTextFormats() {
    SalePatternParser format = new SalePatternParser();

    assertTrue(format.check("003ç1ç[1-1-1]çSeller"));
    assertTrue(format.check("003ç123ç[1-1-1,1-1-2.1]çSeller With Space"));
    assertTrue(format.check("003ç999ç[1-200-1,1-10-2.11]çSeller Wiçth Space"));
  }

  @Test
  public void shouldReturnValidEntityWithGivenText() {
    SalePatternParser format = new SalePatternParser();

    Sale sale = format.parse("003ç123ç[1-1-1,1-1-21]çSeller With Space");

    assertEquals(sale.getId(), 123L);
    assertEquals(sale.getSellerName(), "Seller With Space");
    assertThat(sale.getItems(), containsInAnyOrder(new SaleItem(1, 1, 1.0), new SaleItem(1, 1, 21.0)));
  }
}
