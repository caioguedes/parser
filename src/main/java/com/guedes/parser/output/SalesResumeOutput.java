package com.guedes.parser.output;

public class SalesResumeOutput {
  private long customersTotal;
  private long sellersTotal;
  private String bestSale;
  private String worstSalesman;

  public long getCustomersTotal() {
    return customersTotal;
  }

  public void setCustomersTotal(long customersTotal) {
    this.customersTotal = customersTotal;
  }

  public long getSellersTotal() {
    return sellersTotal;
  }

  public void setSellersTotal(long sellersTotal) {
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
