package com.ptms;

public class EmailSender implements NotificationSender {
    public EmailSender() {
    }

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
