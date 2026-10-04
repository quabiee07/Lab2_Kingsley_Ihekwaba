package bank_acccount;

import java.util.Scanner;

public class BankDriver {

    static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        BankAccount[] bankAccounts = new BankAccount[3];
        BankAccount selected;


        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.println("Enter your account name: ");
            String name = input.nextLine();

            System.out.println("Enter your 9 digit account number: ");
            String number = input.nextLine();
            System.out.println();

            bankAccounts[i] = new BankAccount(name, number);
        }

        System.out.println("Select an account");
        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.print(i + 1 + ". ");
            bankAccounts[i].getAccountInfo();
        }
        int option = Integer.parseInt(input.nextLine());
        if (option < 1 || option > bankAccounts.length) {
            throw new InvalidChoiceException("Select a valid option");
        } else {
            selected = bankAccounts[option - 1];
            selected.getAccountInfo();
        }

        System.out.println("What would you like to do?");
        System.out.println("[1]. Deposit");
        System.out.println("[2]. Withdraw");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("How much would you like to deposit? ");
                double amount = input.nextDouble();
                selected.deposit(amount);
                selected.getAccountInfo();
                break;
            case 2:
                System.out.println("How much would you like to withdraw? ");
                double money = input.nextDouble();
                selected.withdraw(money);
                selected.getAccountInfo();
                break;
            default:
                System.out.println("Invalid Choice!");
                break;

        }

    }
}
