package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private final AccountHolder holder;
    private double balance;
    public SimpleBankAccountWithAtm(AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (this.holder.getId() == userID){
            this.balance += (amount + ATM_FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
