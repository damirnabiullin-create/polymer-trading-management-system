package com.ptms;

import java.util.function.Supplier;

public class ObjectFactory {
    public static <T> T createAndLog(Supplier<T> supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Аргумент не должен быть null");
        }
        T created = supplier.get();
        System.out.println("Объект создан");
        return created;
    }
}
