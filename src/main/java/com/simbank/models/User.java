//Author: Chidicivok
package com.simbank.models;


public class User {
    
    private String username;
    private String password;
    private Account account;
    
    
    // constructor 

    public User(String username, String password, double startingBalance) {
        this.username = username;
        this.password = password;
        
        // every user must have an account  with a starting balance
        this.account = new Account(startingBalance);
    }
    
    
    // get useername

    public String getUsername() {
        return username;
    }
    
    
    // get account

    public Account getAccount() {
        return account;
    }
    
    // verify the password 
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
    
}
