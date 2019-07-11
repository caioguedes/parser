package com.guedes.parser.processor;

import com.guedes.parser.entity.Sale;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.output.SalesResumeOutput;
import java.util.Comparator;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SalesResumeProcessor {

  public SalesResumeOutput process(SalesReportOutput salesReport) {
    SalesResumeOutput output = new SalesResumeOutput();

    Optional<Sale> bestSale =
        salesReport.getSales().stream().max(Comparator.comparing(Sale::getTotal));
    Optional<Sale> worstSale =
        salesReport.getSales().stream().min(Comparator.comparing(Sale::getTotal));

    if (bestSale.isPresent()) {
      output.setBestSale(bestSale.get().getId());
    }

    if (worstSale.isPresent()) {
      output.setWorstSalesman(worstSale.get().getSellerName());
    }

    output.setCustomersTotal(salesReport.getCustomers().size());
    output.setSellersTotal(salesReport.getSellers().size());

    return output;
  }
}
