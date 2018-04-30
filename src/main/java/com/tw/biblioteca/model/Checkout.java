package com.tw.biblioteca.model;

import java.sql.Timestamp;
import java.util.UUID;

public class Checkout {
    private String id;
    private String item_id;
    private Timestamp date_of_issue;
    private Timestamp date_of_return;

    public Checkout(Item item) {
        this.item_id = item.getId();
        this.id = UUID.randomUUID().toString();
    }

    public Checkout(String id, String item_id, Timestamp date_of_issue, Timestamp date_of_return) {
        this.id = id;
        this.item_id = item_id;
        this.date_of_issue = date_of_issue;
        this.date_of_return = date_of_return;
    }

    public String getId() {
        return id;
    }

    public String getItem_id() {
        return item_id;
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

    public void setItem_id(String book_id) {
        this.item_id = book_id;
    }

    public void setDate_of_issue(Timestamp date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public void setDate_of_return(Timestamp date_of_return) {
        this.date_of_return = date_of_return;
    }
}