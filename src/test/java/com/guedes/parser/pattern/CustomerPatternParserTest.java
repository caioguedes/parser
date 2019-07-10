package com.guedes.parser.pattern;

import com.guedes.parser.entity.Customer;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomerPatternParserTest {
  @Test
  public void shouldReturnFalseGivenInvalidTextFormats() {
    CustomerPatternParser format = new CustomerPatternParser();

    assertFalse(format.check(""));
    assertFalse(format.check("ççç"));
    assertFalse(format.check("002ççç"));
    assertFalse(format.check("ç002çç"));
  }

  @Test
  public void shouldReturnFalseGivenValidTextFormats() {
    CustomerPatternParser format = new CustomerPatternParser();

    assertTrue(format.check("002ç00100200300405çCustomerçBank"));
    assertTrue(format.check("002ç00100200300405çCustomer With SpaceçBusiness Area"));
    assertTrue(format.check("002ç00100200300405çCustomer Wiçth SpaceçBusiness Area"));
  }

  @Test
  public void shouldReturnValidEntityWithGivenText() {
    CustomerPatternParser format = new CustomerPatternParser();

    Customer customer = format.parse("002ç00100200300405çCustomer Wiçth SpaceçBusiness Area");

    assertEquals(customer.getDocument(), "00100200300405");
    assertEquals(customer.getName(), "Customer Wiçth Space");
    assertEquals(customer.getBusinessArea(), "Business Area");
  }
}
