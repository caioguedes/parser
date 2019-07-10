package com.guedes.parser.output;

public class SalesResumeOutput {
  private int customersTotal;
  private int sellersTotal;
  private String bestSale;
  private String worstSalesman;

  public int getCustomersTotal() {
    return customersTotal;
  }

  public void setCustomersTotal(int customersTotal) {
    this.customersTotal = customersTotal;
  }

  public int getSellersTotal() {
    return sellersTotal;
  }

  public void setSellersTotal(int sellersTotal) {
    this.sellersTotal = sellersTotal;
  }

  public String getBestSale() {
    return bestSale;
  }

  public void setBestSale(String bestSale) {
    this.bestSale = bestSale;
  }

  public String getWorstSalesman() {
    return worstSalesman;
  }

  public void setWorstSalesman(String worstSalesman) {
    this.worstSalesman = worstSalesman;
  }
}
