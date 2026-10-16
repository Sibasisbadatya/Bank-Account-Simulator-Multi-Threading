package com.example.Bank.Account.Simulator.Version2;


public class BankAccount {

    private int balance = 10_000;

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(int amount) throws InterruptedException {
        Thread.sleep(1000);
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}

