package com.ptms.practice;

public class SalesManager extends Employee {
    public SalesManager(String name) {
        super(name);
    }

    public void sellProduct() {
        System.out.println("Менеджер продаёт полимерное сырьё");
    }
}
