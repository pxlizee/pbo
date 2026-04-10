package sesi_5;
import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {
    private double saldo;
    private String accountNumber;
    private String accountName;

    public BankAccount(double firstSaldo, String accountNumber, String accountName) {
        saldo = firstSaldo;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.saldo += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.saldo >= amount) {
            this.saldo -= amount;
        } else {
            System.out.println("Withdrawal failed: insufficient funds.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getInstance(new Locale("id", "ID"));
        return "Account number: " + this.accountNumber +
                "\nAccount name: " + this.accountName +
                "\nSaldo: " + format.format(this.saldo);
    }
}
