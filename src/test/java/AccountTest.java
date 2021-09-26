import com.carta.integrations.gtt.bo.SrcAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    /**
     * it test both src and dst accounts
     */
    @Test
    public void parseAccounts(){
        SrcAccount srcAccount = new SrcAccount("128172817HP991819309");
        Assertions.assertTrue(srcAccount.getAccountID().equals("991819309"));
        Assertions.assertTrue(srcAccount.getAccountHolder().equals("HP"));
        Assertions.assertTrue(srcAccount.getBankId().equals("128172817"));
    }
}
