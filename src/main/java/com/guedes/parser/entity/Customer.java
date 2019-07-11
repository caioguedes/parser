package com.guedes.parser.entity;

import java.util.Objects;

public class Customer extends Entity {
  private String document;
  private String name;
  private String businessArea;

  public Customer(String document, String name, String businessArea) {
    this.document = document;
    this.name = name;
    this.businessArea = businessArea;
  }

  public String getDocument() {
    return document;
  }

  public String getName() {
    return name;
  }

  public String getBusinessArea() {
    return businessArea;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(document, customer.document) &&
        Objects.equals(name, customer.name) &&
        Objects.equals(businessArea, customer.businessArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(document, name, businessArea);
  }
}
