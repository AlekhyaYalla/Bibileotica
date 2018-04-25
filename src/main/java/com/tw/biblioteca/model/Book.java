package com.tw.biblioteca.model;


public class Book {
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String id, String title) {

        this.id = id;
        this.title = title;
    }
}
