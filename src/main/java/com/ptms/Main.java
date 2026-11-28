package com.ptms;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Client sht = new Client(101, "SHT");
        Client ooo = new Client(102, "OOO");
        Client slk = new Client(103, "SLK");
        Client xxx = new Client(104, "XXX");
        Client abc = new Client(105, "ABC");

        List<Client> clients = List.of(sht, ooo, slk, xxx, abc);
        List<Client> reorderedClients = List.of(xxx, slk, ooo, sht, abc);
        List<Client> emptyClients = List.of();

        List<Order> orders = List.of(
                new Order(1001, sht, 300),
                new Order(1002, ooo, 150),
                new Order(1003, sht, 500),
                new Order(1004, slk, 200),
                new Order(1005, ooo, 400),
                new Order(1006, abc, 800)
        );

        printClientRating(orders, clients, 200);
        printClientRating(orders, clients, 800);
        printClientRating(orders, clients, 801);
    }

    private static void printClientRating(List<Order> orders, List<Client> clients, int minVolume) {
        try {
            List<ClientSalesSummary> clientRating = SalesReportService.clientsRatingByTotalQuantity(clients, orders, minVolume);
            if (clientRating.isEmpty()) {
                System.out.println("Отчёт пуст");
                return;
            }
            clientRating.forEach(r -> System.out.println("Id: " +
                    r.getClient().getId() +
                    " Название: " +
                    r.getClient().getName() +
                    " Объём: " +
                    r.getTotalQuantity()));
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
