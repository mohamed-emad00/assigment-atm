package com.example;

import java.math.BigDecimal;
import java.util.Scanner;
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

     static void main(String[] args) {
        Account account = new Account("Mohamed Emad","mohamed","1234",new BigDecimal("3432.5"),"EGP");
        Account.accounts.put(account.getUsername(),account);
        Scanner  input = new Scanner(System.in);
        byte noAttempt = 0;
        do{
            System.out.println("Enter your account PIN: ");
            noAttempt++;
        }while(!account.checkPIN(input.nextLine()) && noAttempt < 3);

        if(noAttempt >= 3){
            System.out.println("Your account has been locked");
            return;
        }

        byte option = 0;
        do{
            System.out.println("Initial balance: "+ account.getBalance() + " " + account.getCurrency());
            printMenu();
            System.out.println("Enter the option: ");
            option = input.nextByte();
            switch(option){
                case 1:
                    System.out.println("your current balance is: " + account.getBalance() + " "+account.getCurrency());
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    account.deposit(input.nextBigDecimal(),"EGP");
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw: ");
                    account.withdraw(input.nextBigDecimal());
                    break;
                case 4:
                    System.out.println("the account status is: "+account.getAccountStatus());
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM");
                    System.out.println("no withdraw: " + account.getNoWithdraw() + " times" + " And no deposit: "+account.getNoDeposit() + " times");
                    break;
                default:    
                System.out.println("Invalid option\nEnter number from 1 to 5");
            }
        }while(option != 5);
        

    }
}