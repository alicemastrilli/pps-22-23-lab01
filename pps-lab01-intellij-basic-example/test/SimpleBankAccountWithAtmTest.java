import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lab01.example.model.SimpleBankAccountWithAtm.ATM_FEE;
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
    void testAccountHolderIsRight(){
        assertEquals(this.accountHolder, this.bankAccount.getHolder());
    }
    @Test
    void testInitialBalance(){
        assertEquals(0, this.bankAccount.getBalance());
    }
    @Test
    void testDeposit(){
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(100 - ATM_FEE, this.bankAccount.getBalance());
        this.bankAccount.deposit(this.accountHolder.getId(), 50);
        assertEquals(150 - 2*ATM_FEE, this.bankAccount.getBalance());
    }
    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 50);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - 2*ATM_FEE, bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), 30 - 3*ATM_FEE);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), 100 - ATM_FEE);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

}