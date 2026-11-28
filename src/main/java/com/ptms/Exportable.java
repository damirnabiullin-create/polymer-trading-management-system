package com.ptms;

public interface Exportable {
    default void showStatus() {
        System.out.println("Документ готов к экспорту");
    }
}
