package com.example.tracker.util;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String msg) {
        super(msg);
    }
}
