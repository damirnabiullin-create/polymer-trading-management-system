package com.ptms;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<String, Integer> stock = new HashMap<>();

    public void add(String product, Integer quantity) {
        if (product == null || quantity == null) {
            throw new IllegalArgumentException("Название товара и количество не должны быть null");
        }
        if (product.isBlank()) {
            throw new IllegalArgumentException("Название не должно быть пустым");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше 0");
        }

        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            if (Integer.MAX_VALUE - currentQuantity < quantity) {
                throw new ArithmeticException("Переполнение int при сложении");
            }
            stock.put(product, (currentQuantity + quantity));
        } else {
            stock.put(product, quantity);
        }

    }
}
