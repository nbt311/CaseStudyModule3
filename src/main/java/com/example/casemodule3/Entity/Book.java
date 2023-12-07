package com.example.casemodule3.Entity;

public class Book {
    private int id;
    private String name;
    private String avatar;
    private String describes;
    private String status;
    private String category;
    private String author;

    public Book(int id, String name, String avatar, String describes, String status, String category, String author) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.describes = describes;
        this.status = status;
        this.category = category;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
