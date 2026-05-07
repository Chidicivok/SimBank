//Author: Chidicivok
package com.simbank;

import com.simbank.models.Transaction;
import com.simbank.services.BankService;
import java.util.Scanner;

public class BankApp {

    private static Scanner scanner = new Scanner(System.in);
    private static BankService bankService = new BankService();

    // method to collect int values 
    private static int getIntInput() {

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    
    // collect double values 
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid amount: ");
            scanner.next();
        }

        return scanner.nextDouble();
    }
    
    
    
    
    // REGISTER USER METHOD 
    private static void registerUser() {
        
        System.out.println("----- REGISTER USER -----");

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter starting balance: R");
        double startingBalance = getDoubleInput();

        boolean registered = bankService.registerUser(username, password, startingBalance);

        if (registered) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed.");
            System.out.println("Username must be at least 8 characters and contain 1 digit.");
            System.out.println("Password must be at least 8 characters and contain 1 uppercase letter, 1 digit, and 1 symbol.");
        }
    }
    
    
    
    /// deposit menu method
    private static void depositMoney() {
        System.out.print("Enter deposit amount: R");
        double amount = getDoubleInput();

        if (bankService.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("failed to deposit amount R" + amount);
        }
    }
    
    // withdraw
    private static void withdrawMoney() {
        System.out.print("Enter withdrawal amount: R");
        double amount = getDoubleInput();

        if (bankService.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Check amount or View balance.");
        }
    }
    
    // view balance
    private static void viewBalance() {
        System.out.printf("Current balance: R%.2f%n", bankService.getBalance());
    }
    
    // view transactions 
    private static void viewTransactionHistory() {
        System.out.println("--- TRANSACTION HISTORY ---");

        if (bankService.getTransactionHistory().isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : bankService.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
    
    /// bank system menu
    private static void bankingMenu() {
        int choice;

        do {
            System.out.println("====================");
            System.out.println("\tBANKING MENU");
            System.out.println("======================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            
            System.out.print("Select a choice   ->:     ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    depositMoney();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    viewBalance();
                    break;

                case 4:
                    viewTransactionHistory();
                    break;

                case 5:
                    bankService.logout();
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);
    }
    
    
    
    
    
    // login method
    private static void loginUser() {
        System.out.println("\n--- LOGIN ---");

        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            System.out.print("Enter username: ");
            String username = scanner.next();

            System.out.print("Enter password: ");
            String password = scanner.next();

            success = bankService.login(username, password);

            if (!success) {
                attempts++;
                System.out.println("Invalid login. Attempts left: " + (3 - attempts));
            }
        }

        if (success) {
            System.out.println("Login successful.");
            bankingMenu();
        } else {
            System.out.println("Too many failed attempts.");
        }
    }
    
    
    
    
    
    
    // main method
    public static void main(String[] args) {

        
        int choice;

        // use do loop until a choice is enetered 
        do {
            System.out.println("==============================");
            System.out.println("\tSIMBANK SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Select a choice   ->:     ");
            choice = getIntInput();
            
            
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                    
                case 2:
                    loginUser();
                    break;
                case 3: 
                    System.out.println("Thanks for using SimBank");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");;
            }
            
        } while(choice != 3);
        
        
        
        
        
        
        
    }
}
