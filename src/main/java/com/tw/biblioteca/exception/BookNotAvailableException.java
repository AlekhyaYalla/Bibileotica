package com.tw.biblioteca.exception;

public class BookNotAvailableException extends Exception{

    private String message;
    public BookNotAvailableException(String message) {
        this.message = message;
    }
}
