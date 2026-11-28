package com.ptms.practice;

public abstract class Payment {
    private final double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }

    public abstract void processPayment();

    public void printAmount() {
        System.out.println(amount);
    }
}
