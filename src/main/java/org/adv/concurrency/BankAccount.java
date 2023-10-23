package org.adv.concurrency;

public class BankAccount {
    private int balance = 1000;

    void debit(int amount ) {
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }
}
