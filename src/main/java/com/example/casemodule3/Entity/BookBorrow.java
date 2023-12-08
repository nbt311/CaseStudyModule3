package com.example.casemodule3.Entity;

public class BookBorrow {
    private int id;
    private String customerName;
    private String bookName;

    public BookBorrow(int id, String customerName, String bookName) {
        this.id = id;
        this.customerName = customerName;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
