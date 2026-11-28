package com.ptms.practice;

public interface Printable {
    default void showStatus() {
        System.out.println("Документ готов к печати");
    }
}
