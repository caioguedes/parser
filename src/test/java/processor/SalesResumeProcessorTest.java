package processor;

import static org.junit.Assert.*;

import com.guedes.parser.entity.Customer;
import com.guedes.parser.entity.Sale;
import com.guedes.parser.entity.SaleItem;
import com.guedes.parser.entity.Seller;
import com.guedes.parser.output.SalesReportOutput;
import com.guedes.parser.output.SalesResumeOutput;
import com.guedes.parser.processor.SalesResumeProcessor;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalesResumeProcessorTest {

  @Test
  public void shouldReturnSalesResumeOutputWithComputedTotals() {
    SalesReportOutput salesReport = new SalesReportOutput();
    salesReport.setCustomers(Arrays.asList(
        new Customer("2345675433444345", "Eduardo Pereira", "Rural"),
        new Customer("2345675433444346", "Maria Madalena", "Rural"),
        new Customer("2345675433444347", "Carlos Costela", "Rural")
    ));

    salesReport.setSellers(Arrays.asList(
        new Seller("1234567891234", "Pedro", 50000),
        new Seller("1234567891233", "Almeda", 45125)
    ));

    salesReport.setSales(Arrays.asList(
        new Sale("01", Arrays.asList(new SaleItem(1, 1, 10)), "Pedro"),
        new Sale("02", Arrays.asList(new SaleItem(1, 1, 10), new SaleItem(2, 10, 10)), "Almeda")
    ));

    SalesResumeProcessor processor = new SalesResumeProcessor();
    SalesResumeOutput output = processor.process(salesReport);

    assertEquals("02", output.getBestSale());
    assertEquals("Pedro", output.getWorstSalesman());
    assertEquals(3, output.getCustomersTotal());
    assertEquals(2, output.getSellersTotal());
  }
}
