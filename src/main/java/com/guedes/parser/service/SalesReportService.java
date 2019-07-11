package com.guedes.parser.service;

import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.output.SalesResumeOutput;
import com.guedes.parser.processor.SalesReportFileProcessor;
import com.guedes.parser.processor.SalesResumeProcessor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService {
  private SalesReportFileProcessor salesReportProcessor;
  private SalesResumeProcessor salesResumeProcessor;

  public SalesReportService(
      SalesReportFileProcessor salesReportProcessor, SalesResumeProcessor salesResumeProcessor) {
    this.salesReportProcessor = salesReportProcessor;
    this.salesResumeProcessor = salesResumeProcessor;
  }

  public Path generate(Path file, Path outputPath) throws IOException {
    SalesReportOutput salesReportOutput = this.salesReportProcessor.process(file);
    SalesResumeOutput salesResumeOutput = this.salesResumeProcessor.process(salesReportOutput);

    String content =
        new StringBuilder()
            .append(String.format("Customers: %s\n", salesResumeOutput.getCustomersTotal()))
            .append(String.format("Sellers: %s\n", salesResumeOutput.getSellersTotal()))
            .append(String.format("Best Sale Id: %s\n", salesResumeOutput.getBestSale()))
            .append(
                String.format("Worst Salesman Name: %s\n", salesResumeOutput.getWorstSalesman()))
            .toString();


    String outputFileName = file.getFileName().toString().replace(".dat", ".done.dat");
    Path output =
        Files.write(
            outputPath.resolve(outputFileName),
            content.getBytes());

    return output;
  }
}
