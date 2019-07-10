package com.guedes.parser.processor;

import com.guedes.parser.entity.Customer;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.Seller;
import com.guedes.parser.output.SalesFileProcessorOutput;
import com.guedes.parser.pattern.PatternParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesFileProcessor {
  private PatternParser<Customer> customerParser;
  private PatternParser<Seller> sellerParser;
  private PatternParser<Sale> saleParser;

  @Autowired
  public SalesFileProcessor(PatternParser<Customer> customerParser, PatternParser<Seller> sellerParser, PatternParser<Sale> saleParser) {
    this.customerParser = customerParser;
    this.sellerParser = sellerParser;
    this.saleParser = saleParser;
  }

  public SalesFileProcessorOutput process(Path input) throws IOException {
    SalesFileProcessorOutput output = new SalesFileProcessorOutput();

    Files.lines(input).forEach(line -> {
      if (this.saleParser.check(line)) {
        output.getSales().add(this.saleParser.parse(line));
      }

      if (this.customerParser.check(line)) {
        output.getCustomers().add(this.customerParser.parse(line));
      }

      if (this.sellerParser.check(line)) {
        output.getSellers().add(this.sellerParser.parse(line));
      }
    });

    return output;
  }
}
