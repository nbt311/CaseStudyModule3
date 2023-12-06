package com.example.casemodule3.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected String jdbcUrl;
    protected String jdbcUsername;
    protected String jdbcPassword;
    public static Database instance;
    private Database(){
        this.jdbcUrl = "jdbc:mysql://localhost:3306/case3?useSSL=false";
        this.jdbcUsername = "root";
        this.jdbcPassword = "123456";
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
    public Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage() + "error");
        }
        return null;
    }
}
