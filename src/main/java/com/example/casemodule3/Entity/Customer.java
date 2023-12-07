package com.example.casemodule3.Entity;

public class Customer {
    private int id;
    private  String name;
    private  String className;
    private String address;
    private String dateOfBirth;

    public Customer(int id, String name, String className, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
