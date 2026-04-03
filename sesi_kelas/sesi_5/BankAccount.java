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
            System.out.println("Deposit failed: amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: amount must be positive.");
        } else if (this.saldo >= amount) {
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

    // Reuse NumberFormat instance for efficiency
    private static final NumberFormat FORMAT = NumberFormat.getInstance(new Locale("id", "ID"));

    @Override
    public String toString() {
        return "Account number: " + this.accountNumber +
                "\nAccount name: " + this.accountName +
                "\nSaldo: " + FORMAT.format(this.saldo);
    }
}
