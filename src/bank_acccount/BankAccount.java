package bank_acccount;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class BankAccount {
    private String accountName;
    private String accountNumber;
    private double accountBalance;
    NumberFormat cadFmt = NumberFormat.getCurrencyInstance(Locale.CANADA);

    public BankAccount(String accountName, String accountNumber) throws Exception {
        this.accountName = validateName(accountName);
        this.accountNumber = validateAccountNumber(accountNumber);
        this.accountBalance = validateBalance(100_000);
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountBalance() {

        return cadFmt.format(accountBalance);
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void getAccountInfo() {
        System.out.println("Account name: " + getAccountName());
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Balance: " + getAccountBalance());
        System.out.println();
    }

    public void deposit(double amount) throws NegativeAmountException,
            ZeroAmountException {
        if (amount == -1) {
            throw new NegativeAmountException("Amount must be a positive number!");
        } else if (amount == 0) {
            throw new ZeroAmountException("Amount can't be zero!");
        }
        setAccountBalance(accountBalance + amount);
        System.out.printf("$%.2f was deposited into your account%n%n", amount);

    }

    public void withdraw(double amount) throws NegativeAmountException,
            ZeroAmountException, InsufficientFundsException {

        try {
            if (amount < 0) {
                throw new NegativeAmountException("Amount must be a positive number!");
            }
            if (amount == 0) {
                throw new ZeroAmountException("Amount can't be zero!");
            }
            if (amount > accountBalance) {
                throw new InsufficientFundsException("Insufficient funds!");
            }

            setAccountBalance(accountBalance - amount);
            System.out.printf("$%.2f was withdrawn from your account%n%n", amount);
        } finally {
            System.out.println("Withdrawal operation executed!");

        }

    }

    private String validateName(String name) throws EmptyFieldException {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyFieldException("Account Name must not be empty");
        }
        return name.trim();
    }

    private String validateAccountNumber(String number) throws InvalidAccountNumber {
        Pattern pattern = Pattern.compile("^\\d{9}$");
        boolean matcher = pattern.matcher(number).matches();
        if (!matcher) {
            throw new InvalidAccountNumber("Account number must be at least 9 digits ");
        }
        return number;
    }

    private double validateBalance(double balance) throws NegativeAmountException {
        if (balance < 0) {
            throw new NegativeAmountException("Balance cannot be a negative number");
        }
        return balance;
    }
}
