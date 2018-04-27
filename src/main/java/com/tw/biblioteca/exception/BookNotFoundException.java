package com.tw.biblioteca.exception;

public class BookNotFoundException extends Exception{

    private String message;
    public BookNotFoundException(String message) {
        this.message = message;
    }
}
