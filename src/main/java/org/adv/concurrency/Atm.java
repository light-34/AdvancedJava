package org.adv.concurrency;

public class Atm {
    public synchronized void withdraw(BankAccount account, int amount) {
        int balance = account.getBalance();
        if (balance - amount < 0) {
            System.out.println("Tansaction denied");
        } else {
            account.debit(amount);
            System.out.println(amount + " withdrawn");
        }
        System.out.println("Current balance " + account.getBalance());
    }
}
