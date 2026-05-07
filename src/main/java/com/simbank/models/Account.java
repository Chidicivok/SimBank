//AUthor : Chidicivok

package com.simbank.models;


// import array list 
import java.util.ArrayList;

public class Account {
    
    // class level balanace
    private double balance;
    
    private ArrayList<Transaction> transactions;

    
    // constructor
    public Account(double balance) {
        
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        
        
        // initialize the array 
        this.transactions = new ArrayList<>();
    }
    
    
    
    // deposit method 
    public boolean deposit (double amount) {
        
        if (amount <= 0) {
            return false;
        }
        
        balance += amount;
        
        transactions.add(new Transaction("DEPOSIT", amount));
        
        return true;
    }
    
    
    
    // withdrawal
    public boolean withdraw( double amount) {
        if (amount <=0 || balance < amount) {
            return false;
        }
        
        balance -= amount;
        
        transactions.add(new Transaction("WITHDRAWAL", amount));
        return true;
    }
    
    
    // view balance

    public double getBalance() {
        return balance;
    }
    
    // transaction history 
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
}
