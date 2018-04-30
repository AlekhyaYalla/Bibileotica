package com.tw.biblioteca.model;

public class Item {
    private String id;
    private String title;
    private String release_year;
    private Integer count;
    private String type;
    private String details;

    public Item(String id, String title, String release_year, Integer count, String type, String details) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.count = count;
        this.type = type;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_year() {
        return release_year;
    }

    public Integer getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
