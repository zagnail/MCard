package ru.tradepilot.mcard.api.dto;

public class Message {
    private String message;
    private String messageKey;

    public Message() {
    }

    public Message(String message, String messageKey) {
        this.message = message;
        this.messageKey = messageKey;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
