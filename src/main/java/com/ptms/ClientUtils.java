package com.ptms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientUtils {
    public static Client findClientById(List<Client> clients, int id) {
        if (clients == null) {
            throw new IllegalArgumentException("Список клиентов не должен быть null");
        }
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Клиент не найден"));
    }

    public static void addClient(List<? super Client> clients, Client clientToAdd) {
        if (clients == null || clientToAdd == null) {
            throw new IllegalArgumentException("Список клиентов и добавляемый клиент не должны быть null");
        }
        clients.add(clientToAdd);
    }


}
