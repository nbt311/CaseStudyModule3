package com.example.casemodule3.Entity;

public class BookBorrow {
    private int id;
    private String customerName;
    private String bookName;
    private  String borroweDay;
    private String payDay;

    public BookBorrow(int id, String customerName, String bookName) {
        this.id = id;
        this.customerName = customerName;
        this.bookName = bookName;
    }

    public BookBorrow(String customerName, String bookName, String borroweDay, String payDay) {
        this.customerName = customerName;
        this.bookName = bookName;
        this.borroweDay = borroweDay;
        this.payDay = payDay;
    }

    public String getBorroweDay() {
        return borroweDay;
    }

    public void setBorroweDay(String borroweDay) {
        this.borroweDay = borroweDay;
    }

    public String getPayDay() {
        return payDay;
    }

    public void setPayDay(String payDay) {
        this.payDay = payDay;
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
