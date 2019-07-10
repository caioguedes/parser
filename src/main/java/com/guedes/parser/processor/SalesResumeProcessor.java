package com.guedes.parser.processor;

import com.guedes.parser.entity.Sale;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.output.SalesResumeOutput;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class SalesResumeProcessor {

  public SalesResumeOutput process(SalesReportOutput salesReport) {
    SalesResumeOutput output = new SalesResumeOutput();

    Sale bestSale = salesReport.getSales().stream().max(Comparator.comparing(Sale::getTotal)).get();
    Sale worstSale = salesReport.getSales().stream().min(Comparator.comparing(Sale::getTotal)).get();

    output.setBestSale(bestSale.getId());
    output.setCustomersTotal(salesReport.getCustomers().size());
    output.setSellersTotal(salesReport.getSellers().size());
    output.setWorstSalesman(worstSale.getSellerName());

    return output;
  }
}
