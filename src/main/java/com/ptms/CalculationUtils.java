package com.ptms;

public class CalculationUtils {
    public static <Q extends Number, P extends Number> double calculateTotal(Q quantity, P price) {
        if (quantity == null || price == null) {
            throw new IllegalArgumentException("Цена и количество не должны быть null");
        }
        if (quantity.doubleValue() <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше 0");
        }
        if (price.doubleValue() < 0) {
            throw new IllegalArgumentException("Цена должна быть больше положительной");
        }

        return quantity.doubleValue() * price.doubleValue();
    }
}
