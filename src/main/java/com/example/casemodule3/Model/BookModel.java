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
