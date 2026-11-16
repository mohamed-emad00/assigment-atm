package com.example;

import java.math.BigDecimal;

public class Account implements AccountInterface{
    private String name;
    private String PIN;
    private BigDecimal balance;
    private String balanceCurrency;
    
    public Account(String name, String PIN, BigDecimal balance, String balanceCurrency) {
        this.name = name;
        this.PIN = PIN;
        this.balance = balance;
        this.balanceCurrency = balanceCurrency;
    }

    public Account() {
    
    }
    public String getName(){
        return this.name;
    }

    public BigDecimal getBalance(){
        return this.balance;
    } 
    public String getCurrency(){
        return this.balanceCurrency;
    }
    public Boolean checkPIN(final String PINToCheck){
        return PINToCheck.
    }
    

    @Override
    public synchronized Boolean deposit(final BigDecimal amount,final String currency) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public synchronized Boolean withdraw(final BigDecimal amount,final String currency) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void showStatus(){
    }
   

}
