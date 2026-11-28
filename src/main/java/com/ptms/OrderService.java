package com.ptms;

import java.util.Comparator;
import java.util.List;

public class OrderService {
    public static List<Order> ordersReport(List<Order> orders, int minQuantity) {
        if (orders == null) {
            throw new IllegalArgumentException("Список заказов не должен быть null");
        }
        if (minQuantity < 0) {
            throw new IllegalArgumentException("Минимальное количество не должно быть меньше 0");
        }

        Comparator<Order> byId = Comparator.comparing(Order::getId);
        Comparator<Order> byQuantityDescByIdAsc = Comparator.comparing(Order::getQuantity).reversed().thenComparing(byId);

        return orders.stream()
                .filter(o -> o.getQuantity() >= minQuantity)
                .sorted(byQuantityDescByIdAsc)
                .toList();
    }
}
