package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.guedes.parser.pattern.CustomerPatternParser;
import com.guedes.parser.pattern.PatternParserFactory;
import com.guedes.parser.pattern.SalePatternParser;
import com.guedes.parser.pattern.SellerPatternParser;
import com.guedes.parser.processor.SalesReportFileProcessor;
import com.guedes.parser.processor.SalesResumeProcessor;
import com.guedes.parser.service.SalesReportService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalesReportServiceTest {
  @Test
  public void shouldReturnAResumeFileFromASalesReportFile() throws Exception {
    Path inputFile = this.createFixtureFile();

    SalesReportFileProcessor salesReportFileProcessor =
        new SalesReportFileProcessor(new PatternParserFactory());

    SalesReportService service =
        new SalesReportService(salesReportFileProcessor, new SalesResumeProcessor());

    Path outputFile = service.generate(inputFile, Paths.get("src/test/resources/data/out/"));

    String expected =
        new StringBuilder()
            .append("Customers: 2\n")
            .append("Sellers: 2\n")
            .append("Best Sale Id: 10\n")
            .append("Worst Salesman Name: Paulo\n")
            .toString();

    assertEquals(expected, new String(Files.readAllBytes(outputFile)));
  }

  private Path createFixtureFile() throws IOException {
    String content =
        new StringBuilder()
            .append("001ç1234567891234çPedroç50000\n")
            .append("001ç3245678865434çPauloç40000.99\n")
            .append("002ç2345675434544345çJose da SilvaçRural\n")
            .append("002ç2345675433444345çEduardo PereiraçRural\n")
            .append("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n")
            .append("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo")
            .toString();

    Path file =
        Files.write(Paths.get("src/test/resources/data/in/sales_01.dat"), content.getBytes());

    return file;
  }
}
