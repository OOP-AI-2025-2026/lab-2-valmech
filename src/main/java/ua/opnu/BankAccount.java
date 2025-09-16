package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = Math.max(0, balance);
    }

    public BankAccount() {
        this.name = "Unknown";
        this.balance = 0.0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            return; // ігноруємо
        }
        balance += amount;
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }
        if (this.withdraw(amount)) {
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
}