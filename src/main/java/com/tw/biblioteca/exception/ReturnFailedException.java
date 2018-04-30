package com.tw.biblioteca.exception;

public class ReturnFailedException extends Exception {
    private String message;
    public ReturnFailedException(String message) {
        this.message  = message;
    }
}
