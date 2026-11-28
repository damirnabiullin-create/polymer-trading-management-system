package com.ptms.practice;

public class Invoice extends Document implements Printable, Exportable {
    public Invoice(String number) {
        super(number);
    }

    @Override
    public void showStatus() {
        Printable.super.showStatus();
        Exportable.super.showStatus();
    }
}
