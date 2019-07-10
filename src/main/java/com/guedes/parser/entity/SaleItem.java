package com.guedes.parser.entity;

import java.util.Objects;

public class SaleItem {
  private final long id;
  private final long quantity;
  private final double price;

  public SaleItem(long id, long quantity, double price) {
    this.id = id;
    this.quantity = quantity;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public long getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleItem saleItem = (SaleItem) o;
    return id == saleItem.id &&
        quantity == saleItem.quantity &&
        Double.compare(saleItem.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, price);
  }
}
