package com.ptms;

public class WarehouseBatch {
    private final int id;
    private final String polymerType;
    private final int quantity;

    public WarehouseBatch(int id, String polymerType, int quantity) {
        if (id <= 0 || quantity <= 0) {
            throw new IllegalArgumentException("Id партии и количество должны быть больше 0");
        }
        if (polymerType == null || polymerType.isBlank()) {
            throw new IllegalArgumentException("Тип полимера не может быть пустым или null");
        }
        this.id = id;
        this.polymerType = polymerType;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getPolymerType() {
        return polymerType;
    }

    public int getQuantity() {
        return quantity;
    }
}
