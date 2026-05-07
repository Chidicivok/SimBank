//Author:chidicivok
package com.simbank.models;


// import date 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
    
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    
    // format date time
    @Override
    public String toString() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        return type + " |  R" + amount + " | " + dateTime.format(formatter);
    }
    
    
    
}
