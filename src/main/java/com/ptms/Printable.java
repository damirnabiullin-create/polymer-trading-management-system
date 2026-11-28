package com.ptms;

public interface Printable {
    default void showStatus() {
        System.out.println("Документ готов к печати");
    }
}
