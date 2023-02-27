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
        if (this.checkUser(userID)){
            this.balance += (amount - ATM_FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(this.checkUser(userID) && this.isWithdrawAllowed(amount)) {
            this.balance -= (amount + ATM_FEE);
        }
    }
    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= (amount + ATM_FEE);
    }
    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

}
