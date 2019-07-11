package com.guedes.parser.processor;

import com.guedes.parser.entity.Customer;
import com.guedes.parser.entity.Entity;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.Seller;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.output.SalesResumeOutput;
import java.util.Comparator;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SalesResumeProcessor {

  public SalesResumeOutput process(SalesReportOutput salesReport) {
    SalesResumeOutput output = new SalesResumeOutput();

    long customersTotal =
        salesReport.getEntities().parallelStream().filter(e -> e instanceof Customer).count();

    long sellersTotal =
        salesReport.getEntities().parallelStream().filter(e -> e instanceof Seller).count();

    Optional<Sale> bestSale =
        salesReport.getEntities().stream()
            .filter(e -> e instanceof Sale)
            .map(e -> (Sale) e)
            .max(Comparator.comparing(Sale::getTotal));

    Optional<Sale> worstSale =
        salesReport.getEntities().stream()
            .filter(e -> e instanceof Sale)
            .map(e -> (Sale) e)
            .min(Comparator.comparing(Sale::getTotal));

    if (bestSale.isPresent()) {
      output.setBestSale(bestSale.get().getId());
    }

    if (worstSale.isPresent()) {
      output.setWorstSalesman(worstSale.get().getSellerName());
    }

    output.setCustomersTotal(customersTotal);
    output.setSellersTotal(sellersTotal);

    return output;
  }
}
