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
        assertEquals(99, this.bankAccount.getBalance());
        this.bankAccount.deposit(this.accountHolder.getId(), 50);
        assertEquals(148, this.bankAccount.getBalance());
    }
    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

}