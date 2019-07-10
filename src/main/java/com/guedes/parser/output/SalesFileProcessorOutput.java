package com.guedes.parser.output;

import com.guedes.parser.entity.Customer;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.Seller;
import java.util.ArrayList;
import java.util.List;

public class SalesFileProcessorOutput {
  private List<Customer> customers = new ArrayList<>();
  private List<Seller> sellers = new ArrayList<>();
  private List<Sale> sales = new ArrayList<>();

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  public List<Seller> getSellers() {
    return sellers;
  }

  public void setSellers(List<Seller> sellers) {
    this.sellers = sellers;
  }

  public List<Sale> getSales() {
    return sales;
  }

  public void setSales(List<Sale> sales) {
    this.sales = sales;
  }
}
