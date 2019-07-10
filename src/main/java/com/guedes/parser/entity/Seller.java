package com.guedes.parser.entity;

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
}
