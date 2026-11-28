package com.ptms.practice;

public class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Банковский перевод на сумму: " + getAmount());
    }
}
