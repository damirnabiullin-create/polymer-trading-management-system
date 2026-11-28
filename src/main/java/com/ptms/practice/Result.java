package com.ptms.practice;

public class Result<T> {
    private T value;

    public Result(T item) {
        this.value = item;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }
}
