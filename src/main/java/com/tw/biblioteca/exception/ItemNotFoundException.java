package com.tw.biblioteca.exception;

public class ItemNotFoundException extends Exception {
    private String message;

    public ItemNotFoundException(String message) {

        this.message = message;
    }
}
