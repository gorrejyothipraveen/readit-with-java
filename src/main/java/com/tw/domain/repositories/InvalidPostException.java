package com.tw.domain.repositories;

public class InvalidPostException extends NullPointerException {
    public InvalidPostException(String message) {
        super(message);
    }
}
