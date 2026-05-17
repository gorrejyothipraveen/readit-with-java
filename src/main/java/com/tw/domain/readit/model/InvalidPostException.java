package com.tw.domain.readit.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPostException extends RuntimeException {
    public InvalidPostException(String message) {
        super(message);
    }
}