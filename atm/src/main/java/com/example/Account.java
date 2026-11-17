package com.example;

import java.math.BigDecimal;

import java.util.concurrent.ConcurrentHashMap;

public class Account implements AccountInterface{
    public final static ConcurrentHashMap<String , Account> accounts = new ConcurrentHashMap<>();

    private String name;
    private String username;
    private String PIN;
    private BigDecimal balance;
    private String balanceCurrency;
    private String accountStatus;
    private int numOfDeposit;
    private int numOfWithdraw;

    public Account(String name, String username, String PIN, BigDecimal balance, String balanceCurrency) {
        this.name = name;
        this.username = username;
        this.PIN = PIN;
        this.balance = balance;
        this.balanceCurrency = balanceCurrency;
        this.accountStatus = "Low Balance";
        this.numOfDeposit = 0;
        this.numOfWithdraw =0;

    }

    public Account() {
    
    }
    public String getName(){
        return this.name;
    }
    public String getUsername(){
        return this.username;
    }
    public String getAccountStatus(){
        return this.accountStatus;
    }
    public BigDecimal getBalance(){
        return this.balance;
    } 
    public String getCurrency(){
        return this.balanceCurrency;
    }
    public Boolean checkPIN(final String PINToCheck){
        return PINToCheck.equals(this.PIN);
    }
    
    public int getNoDeposit(){
        return this.numOfDeposit;
    }
    public int getNoWithdraw(){
        return this.numOfWithdraw;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPIN(String PIN){
        this.PIN = PIN;
    }
    

    @Override
    public synchronized Boolean deposit(final BigDecimal amount,final String currency) {
        if( currency == null || !currency.equals(this.balanceCurrency)){
            throw new IllegalArgumentException("The Currency must be: "+this.balanceCurrency);
        }
        if( amount == null|| amount.compareTo(new BigDecimal("0.0")) <= 0){
            throw new IllegalArgumentException("the amount must be greater than zero");
        }
        this.balance = this.balance.add(amount);
        updateStatus();
        this.numOfDeposit++;
        return true;
    
    }

    @Override
    public synchronized Boolean withdraw(final BigDecimal amount) {
        if( amount == null || amount.compareTo(this.balance) > 0 ){
            throw new IllegalArgumentException("amount to withdraw must be <= less than or equal: "+this.balance + " "+ this.balanceCurrency);
        }
        this.balance = this.balance.subtract(amount);
        updateStatus();
        this.numOfWithdraw++;
        return true;
    }

    public void updateStatus(){
        if(this.balance.compareTo(new BigDecimal("5000")) >= 0){
            this.accountStatus = "VIP Customer";
        }else if(this.balance.compareTo(new BigDecimal("1000")) >= 0){
            this.accountStatus = "Regular Customer";
        }else{
            this.accountStatus = "Low Balance";
        }
    }
    @Override
    public void showStatus(){
        System.out.println(this.accountStatus);
    }
   

}
