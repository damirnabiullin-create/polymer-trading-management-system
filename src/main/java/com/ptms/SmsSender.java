package com.ptms;

public class SmsSender implements NotificationSender {
    public SmsSender() {
    }

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
