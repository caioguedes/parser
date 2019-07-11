package processor;

import static org.junit.Assert.assertThat;

import com.guedes.parser.entity.Customer;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.SaleItem;
import com.guedes.parser.entity.Seller;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.pattern.PatternParserFactory;
import com.guedes.parser.processor.SalesReportFileProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(JUnit4.class)
public class SalesReportFileProcessorTest {

  @Test
  public void shouldReturnSalesReportOutputWithGivenInput() throws Exception {
    SalesReportFileProcessor processor = new SalesReportFileProcessor(new PatternParserFactory());

    Path fixture = createFixtureFile();
    SalesReportOutput output = processor.process(fixture);

    List<SaleItem> saleItems10 = Arrays.asList(
        new SaleItem(1, 10, 100),
        new SaleItem(2, 30, 2.50),
        new SaleItem(3, 40, 3.10)
    );

    List<SaleItem> saleItems08 = Arrays.asList(
        new SaleItem(1, 34, 10),
        new SaleItem(2, 33, 1.50),
        new SaleItem(3, 40, 0.10)
    );

    assertThat(output.getEntities(), containsInAnyOrder(
        new Customer("2345675434544345", "Jose da Silva", "Rural"),
        new Customer("2345675433444345", "Eduardo Pereira", "Rural"),
        new Seller("1234567891234", "Pedro", 50000d),
        new Seller("3245678865434", "Paulo", 40000.99),
        new Sale("10", saleItems10, "Pedro"),
        new Sale("08", saleItems08, "Paulo")
    ));
  }

  private Path createFixtureFile() throws IOException {
    String content = new StringBuilder()
        .append("001ç1234567891234çPedroç50000\n")
        .append("001ç3245678865434çPauloç40000.99\n")
        .append("002ç2345675434544345çJose da SilvaçRural\n")
        .append("002ç2345675433444345çEduardo PereiraçRural\n")
        .append("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n")
        .append("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo")
        .toString();

    Path file = Files.write(Paths.get("src/test/resources/data/in/sales_01.dat"), content.getBytes());

    return file;
  }
}
