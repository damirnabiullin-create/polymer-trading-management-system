package com.ptms;

public class ClientSalesSummary {
    private final Client client;
    private final int orderCount;
    private final long totalQuantity;

    public ClientSalesSummary(Client client, int orderCount, long totalQuantity) {
        if (client == null) {
            throw new IllegalArgumentException("Клиент не может быть null");
        }
        if (orderCount < 0 || totalQuantity < 0) {
            throw new IllegalArgumentException("Количество заказов и сырья не может быть отрицательным");
        }
        if (orderCount == 0 && totalQuantity != 0) {
            throw new IllegalArgumentException("Количество заказов равно 0, количество сырья не может быть отличным от 0");
        }
        if (orderCount > 0 && totalQuantity == 0) {
            throw new IllegalArgumentException("Количество заказов больше 0, количество сырья не может быть равным 0");
        }

        this.client = client;
        this.orderCount = orderCount;
        this.totalQuantity = totalQuantity;
    }

    public Client getClient() {
        return client;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }
}
