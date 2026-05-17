package com.tw.domain.readit.model;

public class InvalidPostException extends NullPointerException {
    public InvalidPostException(String message) {
        super(message);
    }
}
