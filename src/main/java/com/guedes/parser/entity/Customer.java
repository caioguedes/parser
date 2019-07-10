package com.guedes.parser.entity;

public class Customer {
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
}
