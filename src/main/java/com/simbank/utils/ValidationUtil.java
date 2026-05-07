//Author Chidicivok
package com.simbank.utils;


public class ValidationUtil {
    
    // validate username - 8 characters long min and must have at least 1 digit
    public static boolean isValidUsername (String username) {
        
        // must be 8 charactser slong 
        if (username.length() < 8) {
            return false;
        }
        
        
        // msut have 1 digit at least 
        for (char character : username.toCharArray()) {
            
            
            // in this iteration check if the character is a digit 
            if (Character.isDigit(character)) {
                return true;
            }
        }
        
        
        //return false since it didnt break at loop
        return false;
        
        
        
    }
    
    
    /// validate password - 8 charactersd , 1 digit min, 1 symbol min
    
    public static boolean isValidPassword (String password) {
        
        
        if (password.length() < 8) {
            return false;
        }
        
        
        // boolean for uppercase, symboil and digitsd
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSymbol= false;
        
        
        for (char character : password.toCharArray()) {
            
            // check for uppercase
            if(Character.isUpperCase(character)) {
                hasUppercase = true;
            }
            
            //check for digit
            if (Character.isDigit(character)) {
                hasDigit = true;
            }
            
            // check for symbol
            if ( !Character.isLetterOrDigit(character)) {
                hasSymbol = true;
            }
  
            
        }
        
        
        // return if all three are met
        return hasDigit && hasSymbol && hasUppercase;
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
