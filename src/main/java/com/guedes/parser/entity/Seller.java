package com.guedes.parser.entity;

import java.util.Objects;

public class Seller {
  private final String document;
  private final String name;
  private final double salary;

  public Seller(String document, String name, double salary) {
    this.document = document;
    this.name = name;
    this.salary = salary;
  }

  public String getDocument() {
    return document;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seller seller = (Seller) o;
    return Double.compare(seller.salary, salary) == 0 &&
        Objects.equals(document, seller.document) &&
        Objects.equals(name, seller.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(document, name, salary);
  }
}
