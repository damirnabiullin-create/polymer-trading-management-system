package com.ptms.practice;

@FunctionalInterface
public interface DiscountCalculator {
    double calculate(double price, double discount);
}
