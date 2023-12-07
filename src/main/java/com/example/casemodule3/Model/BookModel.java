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
            String sql = "SELECT * FROM books";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String avatar = rs.getString(3);
                String describes = rs.getString(4);
                String status = rs.getString(5);
                String category = rs.getString(6);
                String author = rs.getString(7);
                Book book = new Book(id, name, avatar, describes, status, category, author);
                books.add(book);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            String sql = "DELETE FROM  books WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        }catch (SQLException e) {
            System.out.println("Delete book fail" + e.getMessage());
        }
    }

    @Override
    public void save(Book book) throws Exception {
        try {
            String sql = "INSERT INTO books(name, avatar, describes, status, category, author) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAvatar());
            statement.setString(3, book.getDescribes());
            statement.setString(4, book.getStatus());
            statement.setString(5, book.getCategory());
            statement.setString(6, book.getAuthor());

            statement.execute();

        }catch (SQLException e){
            System.out.println("Add boos fail" + e.getMessage());
        }
    }

    @Override
    public void update(Book book) throws Exception {
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE books SET name = ?, avatar = ?, describes = ?, status = ?, category = ?, author = ? WHERE id= ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAvatar());
            statement.setString(3, book.getDescribes());
            statement.setString(4, book.getStatus());
            statement.setString(5, book.getCategory());
            statement.setString(6, book.getAuthor());
            statement.setInt(7, book.getId());
            statement.execute();
            conn.commit();
        }catch (SQLException e){
            conn.rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Book getById(int id) {
        Book book = null;
        try {
            String sql = "SELECT * FROM books WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                // lấy và gán thông tin từ csdl
                String name = rs.getString(2);
                String avatar = rs.getString(3);
                String describes = rs.getString(4);
                String status = rs.getString(5);
                String category = rs.getString(6);
                String author = rs.getString(7);
                book = new Book(name,avatar, describes, status, category,author);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> search(String key) {
        return null;
    }
}
