package com.ptms.practice;

import java.util.ArrayList;
import java.util.List;

public class Catalog<T> {
    private final List<T> catalog = new ArrayList<>();

    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не должно быть null");
        }
        return this.catalog.add(value);
    }

    public int size() {
        return this.catalog.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(catalog);
    }
}
