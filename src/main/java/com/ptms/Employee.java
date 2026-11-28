package com.ptms;

public class Employee {
    private String name;

    public Employee(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
