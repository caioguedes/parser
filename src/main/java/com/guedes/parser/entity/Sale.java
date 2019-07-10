package com.guedes.parser.entity;

import java.util.List;

public class Sale {
  private final long id;
  private final List<SaleItem> items;
  private final String sellerName;

  public Sale(long id, List<SaleItem> items, String sellerName) {
    this.id = id;
    this.items = items;
    this.sellerName = sellerName;
  }

  public long getId() {
    return id;
  }

  public List<SaleItem> getItems() {
    return items;
  }

  public String getSellerName() {
    return sellerName;
  }
}
