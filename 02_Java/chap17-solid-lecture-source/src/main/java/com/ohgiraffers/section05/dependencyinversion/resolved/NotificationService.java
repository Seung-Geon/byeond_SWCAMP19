package com.ohgiraffers.section05.dependencyinversion.resolved;

public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String message) {
        messageSender.sendMessage(message);
    }
}
