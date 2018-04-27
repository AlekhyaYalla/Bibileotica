package com.tw.biblioteca.exception;

public class BookAlreadyReturned extends Exception {
    private String message;
    public BookAlreadyReturned(String message) {
        this.message  = message;
    }
}
