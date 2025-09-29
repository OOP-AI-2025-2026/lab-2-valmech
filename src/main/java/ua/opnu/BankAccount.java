package ua.opnu;

public class BankAccount {
    public String name;
    public double balance;
    public double transactionFee;

    public BankAccount() {
        this.name = "";
        this.balance = 0;
        this.transactionFee = 0;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = Math.max(0, balance);
        this.transactionFee = 0;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) this.transactionFee = fee;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        double total = amount + this.transactionFee;
        if (total > this.balance) return false;
        this.balance -= total;
        return true;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) return false;
        double total = amount + this.transactionFee;
        if (total > this.balance) return false;
        this.balance -= total;
        receiver.deposit(amount);
        return true;
    }
}
