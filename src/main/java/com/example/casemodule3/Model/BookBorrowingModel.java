package com.example.casemodule3.Model;

import com.example.casemodule3.Database.Database;
import com.example.casemodule3.Entity.BookBorrow;
import com.example.casemodule3.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBorrowingModel implements BookBorrowingDAO {
    protected Connection conn;

    public BookBorrowingModel() {
        Database database = Database.getInstance();
        this.conn = database.connect();
    }

    @Override
    public List<BookBorrow> getAllBookBorrow() {
        List<BookBorrow> bookBorrow = new ArrayList<BookBorrow>();
        try {
            String sql = "select orders.id, customer.name, books.name from orders join customer  on orders.customer_id=customer.id join books  on orders.books_id=books.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String customerName = rs.getString(2);
                String bookName = rs.getString(3);
                BookBorrow borrow = new BookBorrow(id, customerName, bookName);
                bookBorrow.add(borrow);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookBorrow;
    }
}