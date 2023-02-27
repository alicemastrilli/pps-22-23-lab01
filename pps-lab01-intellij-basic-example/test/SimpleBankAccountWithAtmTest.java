import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccount;

    @BeforeEach
    void setUp() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    public void testAccountHolderIsRight(){
        assertEquals(this.accountHolder, this.bankAccount.getHolder());
    }
    @Test
    public void testInitialBalance(){
        assertEquals(0, this.bankAccount.getBalance());
    }
    @Test
    public void testDeposit(){
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(101, this.bankAccount.getBalance());
        this.bankAccount.deposit(this.accountHolder.getId(), 50);
        assertEquals(152, this.bankAccount.getBalance());
    }

}