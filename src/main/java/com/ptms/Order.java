package com.ptms;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

import static java.util.Arrays.stream;

public class Order {
    private final int id;
    private final Client client;
    private final int quantity;

    public Order(int id, Client client, int quantity) {
        if (client == null) {
            throw new IllegalArgumentException("Клиент не может быть null");
        }
        if (id <= 0 || quantity <= 0) {
            throw new IllegalArgumentException("Id и количество должны быть больше 0");
        }

        this.id = id;
        this.client = client;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public Client getClient() {
        return this.client;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public static long clientOrderVolume(List<Order> allOrders, int idOfClient) {
        if (allOrders == null) {
            throw new IllegalArgumentException("Список не должен быть null");
        }

        return allOrders.stream()
                .filter(o -> o.getClient().getId() == idOfClient)
                .mapToLong(Order::getQuantity)
                .sum();
    }
}
