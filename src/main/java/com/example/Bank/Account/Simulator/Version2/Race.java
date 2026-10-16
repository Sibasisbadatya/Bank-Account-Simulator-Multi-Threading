package com.example.Bank.Account.Simulator.Version2;

import com.example.Bank.Account.Simulator.Version2.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static void main(String[] args)
            throws InterruptedException {

        BankAccount account = new BankAccount();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread atm = new Thread(
                    () -> {
                        try {
                            account.withdraw(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    "ATM-" + i
            );

            threads.add(atm);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(
                "Expected balance: 0"
        );
        System.out.println(
                "Actual balance: " + account.getBalance()
        );
    }
}
