package com.ptms;

public class SalesAccumulator {
    private int orderCount;
    private long totalQuantity;

    public void addQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }

        this.totalQuantity += quantity;
        orderCount++;
    }

    public int getCount() {
        return orderCount;
    }

    public long getQuantity() {
        return totalQuantity;
    }
}
