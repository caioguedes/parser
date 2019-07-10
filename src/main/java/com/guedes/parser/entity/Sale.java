package com.guedes.parser.entity;

import java.util.List;
import java.util.Objects;

public class Sale {
  private final String id;
  private final List<SaleItem> items;
  private final String sellerName;

  public Sale(String id, List<SaleItem> items, String sellerName) {
    this.id = id;
    this.items = items;
    this.sellerName = sellerName;
  }

  public String getId() {
    return id;
  }

  public List<SaleItem> getItems() {
    return items;
  }

  public String getSellerName() {
    return sellerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(id, sale.id) &&
        Objects.equals(items, sale.items) &&
        Objects.equals(sellerName, sale.sellerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, items, sellerName);
  }
}
