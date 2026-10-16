package com.example.Bank.Account.Simulator.Sequential_implementation;


public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.withdraw(2_000);
        account.deposit(1_000);
        account.withdraw(3_000);

        System.out.println(
                "Final balance: " + account.getBalance()
        );
    }
}
