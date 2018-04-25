package com.tw.biblioteca.model;


public class Book {
    private String id;
    private String title;
    private String author;
    private String publish_year;
    private String isbn;

    public Book(String id, String title, String author, String publish_year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish_year = publish_year;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublish_year() {
        return publish_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublish_year(String publish_year) {
        this.publish_year = publish_year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
