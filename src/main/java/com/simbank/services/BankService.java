//Author: Chidicivok
package com.simbank.services;

// imports 
import  com.simbank.models.User;
import  com.simbank.models.Transaction;
import  com.simbank.utils.ValidationUtil;
import java.util.ArrayList;

public class BankService {
    
    private ArrayList<User> users;
    private User loggedInUser;

    public BankService() {
        this.users = new ArrayList<>();
        this.loggedInUser = null;
    }
    
    
    // register a user 
    public boolean registerUser(String username, String password, double startingBalance) {
       
        if (!ValidationUtil.isValidUsername(username)) {
            return  false;
        }
        
        
        if (!ValidationUtil.isValidPassword(password)) {
            return  false;
        }
        
         if (findUserByUsername(username) != null) {
            return false;
        }

        users.add(new User(username, password, startingBalance));
        
        return true;
        
        
    }
    
    
    
    
    // find user by user ame
    private User findUserByUsername(String username) {

        for (User user : users) {

            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }
    
    
    // log in 
    public boolean login(String username, String password) {

        User user = findUserByUsername(username);

        if (user == null) {
            return false;
        }

        if (!user.verifyPassword(password)) {
            return false;
        }

        loggedInUser = user;
        
        return true;
    }
    
    
    
    // logo ut 
    public void logout() {
        loggedInUser = null;
    }
    
    
    // for deposit services 
    public boolean deposit(double amount) {

        if (loggedInUser == null) {
            return false;
        }

        return loggedInUser.getAccount().deposit(amount);
    }
    
    
    
    //for withdrawal services
    public boolean withdraw(double amount) {

        if (loggedInUser == null) {
            return false;
        }

        return loggedInUser.getAccount().withdraw(amount);
    }
    
    
    // for view balance services 
    public double getBalance() {

        if (loggedInUser == null) {
            return 0;
        }

        return loggedInUser.getAccount().getBalance();
    }
    
    
    // for transcations history services
    public ArrayList<Transaction> getTransactionHistory() {

        if (loggedInUser == null) {
            return new ArrayList<>();
        }

        return loggedInUser.getAccount().getTransactions();
    }
    
    
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
    
    
    
}
