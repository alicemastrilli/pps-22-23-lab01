import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccountWithAtm;

    @BeforeEach
    void setUp() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccountWithAtm = new SimpleBankAccountWithAtm(this.accountHolder);
    }

    @Test
    public void testAccountHolderIsRight(){
        assertEquals(this.accountHolder, this.bankAccountWithAtm.getHolder());
    }

}