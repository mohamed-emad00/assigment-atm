package com.example;


import com.example.Account;

public class Main {

    public static void  printMenu(){
        System.out.println("============ATM============");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Show Account Status");
        System.out.println("5.Exit");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        
        Account account = new Account();   
        printMenu();


    }
}