package com.tw.biblioteca.exception;

public class ItemNotAvailableException extends Exception {

    private String message;

    public ItemNotAvailableException(String message) {
        this.message = message;
    }
}

