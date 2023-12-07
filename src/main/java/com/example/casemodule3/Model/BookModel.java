package com.example.casemodule3.Model;

import com.example.casemodule3.Database.Database;
import com.example.casemodule3.Entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements BookDAO {
    protected Connection conn;
    public BookModel(){
        Database database = Database.getInstance();
        this.conn = database.connect();
    }
    @Override
    public List<Book> getAll() throws Exception {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT name, avatar, describes, status, category, author FROM books";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String avatar = rs.getString(2);
                String describes = rs.getString(3);
                String status = rs.getString(4);
                String category = rs.getString(5);
                String author = rs.getString(6);
                Book book = new Book(name, avatar, describes, status, category, author);
                books.add(book);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public List<Book> get5NewestBooks(int limit) throws Exception {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT name, category, author FROM books " +
                    "order by id DESC " +
                    "limit ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,limit);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setCategory(rs.getString("category"));
                book.setAuthor(rs.getString("author"));
                books.add(book);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public int totalBook() {
        int total = 0;
        try {
            String sql = "SELECT count(id) from books";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }


    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void save(Book book) throws Exception {

    }

    @Override
    public void update(Book book) throws Exception {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public List<Book> search(String key) {
        return null;
    }
}
