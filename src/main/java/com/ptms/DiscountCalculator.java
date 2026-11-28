package com.ptms;

@FunctionalInterface
public interface DiscountCalculator {
    double calculate(double price, double discount);
}
