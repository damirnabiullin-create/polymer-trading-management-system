package com.ptms;

import java.util.List;

public class WarehouseService {
    public static long quantityOfPolymerType(List<WarehouseBatch> batches, String polymerType) {
        if (batches == null || polymerType == null || polymerType.isBlank()) {
            throw new IllegalArgumentException("Список партий не должен быть null, и название полимера не должно быть null или пустым");
        }

        return batches.stream()
                .filter(b -> b.getPolymerType().equals(polymerType))
                .mapToLong(b -> b.getQuantity())
                .sum();
    }
}
