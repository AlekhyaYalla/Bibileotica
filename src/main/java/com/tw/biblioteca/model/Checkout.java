package com.tw.biblioteca.model;

import java.sql.Timestamp;
import java.util.UUID;

public class Checkout {
    private String id;
    private String book_id;
    private Timestamp date_of_issue;
    private Timestamp date_of_return;

    public Checkout(Book book) {
        this.book_id = book.getId();
        this.id = UUID.randomUUID().toString();
    }

    public Checkout(String id, String book_id, Timestamp date_of_issue, Timestamp date_of_return) {
        this.id = id;
        this.book_id = book_id;
        this.date_of_issue = date_of_issue;
        this.date_of_return = date_of_return;
    }

    public String getId() {
        return id;
    }

    public String getBook_id() {
        return book_id;
    }

    public Timestamp getDate_of_issue() {
        return date_of_issue;
    }

    public Timestamp getDate_of_return() {
        return date_of_return;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setDate_of_issue(Timestamp date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public void setDate_of_return(Timestamp date_of_return) {
        this.date_of_return = date_of_return;
    }
}