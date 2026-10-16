package com.example.Bank.Account.Simulator.Version2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        Thread atm1 = new Thread(()->{
            try {
                Thread.sleep(01);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                bankAccount.withdraw(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"ATM-1");

        Thread atm2 = new Thread(()->{
            try {
                Thread.sleep(01);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                bankAccount.withdraw(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"ATM-2");

        atm1.start();
        atm2.start();

        atm1.join();
        atm2.join();

        System.out.println(
                "Final balance: " + bankAccount.getBalance()
        );

    }
}
