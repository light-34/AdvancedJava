package org.adv.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {
    public static void main(String[] args) {
        Atm atm = new Atm();
        BankAccount account = new BankAccount();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> atm.withdraw(account, 1000));
        executorService.submit(() -> atm.withdraw(account, 1000));
        executorService.shutdown();
    }
}
