package com.tw.biblioteca.exception;

public class NoCheckOutAvailable extends Exception{

    private String message;

    public NoCheckOutAvailable(String message) {

        this.message = message;
    }
}
