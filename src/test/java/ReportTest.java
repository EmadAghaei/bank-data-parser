import com.carta.integrations.gtt.GringottsBank;
import com.carta.integrations.gtt.exception.IntegrationDataFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportTest {

    private String resourcesPath = "./src/test/resources/";

    @Test
    public void parseNastyFile() throws IntegrationDataFormatException {
        GringottsBank gringottsBank = new GringottsBank();

        Assertions.assertThrows(IntegrationDataFormatException.class,() -> {
            gringottsBank.prepareReport(resourcesPath + "nasty_data.txt");
        });

    }
    @Test
    public void parseFileWithOnBatch2Transactions() throws IntegrationDataFormatException {
        GringottsBank gringottsBank = new GringottsBank();
        gringottsBank.prepareReport(resourcesPath + "gtt_bank_data1.txt");
        Assertions.assertTrue(gringottsBank.getTransactionBatchList().size()==1);
        Assertions.assertTrue(gringottsBank.getTransactionBatchList().get(0).getTransactionList().size()==2);
    }
    @Test
    public void parseFileWith2Batch() throws IntegrationDataFormatException {
        GringottsBank gringottsBank = new GringottsBank();
        gringottsBank.prepareReport(resourcesPath + "gtt_bank_data2.txt");
        Assertions.assertTrue(gringottsBank.getTransactionBatchList().size()==2);
        Assertions.assertTrue(gringottsBank.getTransactionBatchList().get(0).getTransactionList().size()==1);
        Assertions.assertTrue(gringottsBank.getTransactionBatchList().get(1).getTransactionList().size()==2);
    }
}
