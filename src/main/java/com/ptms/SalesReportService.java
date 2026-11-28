package com.ptms;

import java.util.*;

public class SalesReportService {
    public static List<ClientSalesSummary> clientsRatingByTotalQuantity(List<Client> clients, List<Order> orders, long minVolume) {
        if (clients == null || orders == null) {
            throw new IllegalArgumentException("Списки клиентов и заказов не должны быть null");
        }
        if (minVolume < 0) {
            throw new IllegalArgumentException("Минимальный объём не должен быть отрицательным");
        }

        Comparator<ClientSalesSummary> byVolumeDescIdAsc = Comparator
                .comparingLong(ClientSalesSummary::getTotalQuantity)
                .reversed()
                .thenComparingInt(s -> s.getClient().getId());

        List<ClientSalesSummary> clientSalesSummaryList = salesReportForClients(orders, clients);
        return clientSalesSummaryList.stream()
                .filter(s -> s.getTotalQuantity() >= minVolume)
                .sorted(byVolumeDescIdAsc)
                .toList();
    }

    public static List<ClientSalesSummary> salesReportForClients(List<Order> orders, List<Client> clients) {
        if (orders == null || clients == null) {
            throw new IllegalArgumentException("Списки заказов и клиентов не должны быть null");
        }

        List<ClientSalesSummary> summaryList = new ArrayList<>();
        Map<Integer, SalesAccumulator> accumulatorMap = new HashMap<>();

        for (Order o : orders) {
            int id = o.getClient().getId();
            SalesAccumulator temp = accumulatorMap.get(id);
            if (temp == null) {
                temp = new SalesAccumulator();
                temp.addQuantity(o.getQuantity());
                accumulatorMap.put(id, temp);
            } else {
                temp.addQuantity(o.getQuantity());
            }
        }

        for (Client c : clients) {
            SalesAccumulator temp = accumulatorMap.getOrDefault(c.getId(), new SalesAccumulator());
            summaryList.add(new ClientSalesSummary(c, temp.getCount(), temp.getQuantity()));
        }

        return summaryList;
    }

    public static Map<Integer, Long> totalQuantityByClientId(List<Order> orders) {
        if (orders == null) {
            throw new IllegalArgumentException("Список заказов не должен быть null");
        }

        Map<Integer, Long> result = new HashMap<>();
        for (Order o : orders) {
            int id = o.getClient().getId();
            result.put(id, (result.getOrDefault(id, 0L) + o.getQuantity()));
        }
        return result;
    }

    public static Map<Integer, Integer> countOrdersByClientId(List<Order> orders) {
        if (orders == null) {
            throw new IllegalArgumentException("Список заказов не должен быть null");
        }

        Map<Integer, Integer> result = new HashMap<>();
        for (Order o : orders) {
            int id = o.getClient().getId();
            if (result.get(id) == null) {
                result.put(id, 1);
            } else {
                result.put(id, (result.get(id) + 1));
            }
        }
        return result;
    }

    public static ClientSalesSummary salesReport(List<Order> orders, Client client) {
        if (orders == null || client == null) {
            throw new IllegalArgumentException("Список и клиент не должны быть null");
        }

        int count = 0;
        long totalQuantity = 0;

        for (Order o : orders) {
            if (o.getClient().getId() == client.getId()) {
                count++;
                totalQuantity += o.getQuantity();
            }
        }

        return new ClientSalesSummary(client, count, totalQuantity);
    }
}
