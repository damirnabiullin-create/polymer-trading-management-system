package com.ptms.practice;

public class OperationResult<T> {
    private final T result;

    public OperationResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
