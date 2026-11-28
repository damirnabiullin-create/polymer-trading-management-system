package com.ptms;

public class Client {
    private final int id;
    private String name;

    public Client(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id должен быть больше 0");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым или null");
        }
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым или null");
        }
        this.name = newName;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Client && this.id == ((Client) obj).getId());
    }

    @Override
    public int hashCode() {
        return id;
    }
}
