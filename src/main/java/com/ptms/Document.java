package com.ptms;

public abstract class Document {
    private final String number;

    public Document(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Номер не должен быть пустым");
        }
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void save() {
        System.out.println("Документ сохранен");
    }

}
