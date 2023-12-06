package com.example.casemodule3.Model;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Entity.User;

import java.util.List;

public interface BookDAO {
    List<Book> getAll() throws Exception;
    void delete(int id) throws Exception;
    void save(Book book) throws Exception;
    void update(Book book) throws Exception;
    void getById(int id);
    // show danh sách tìm kiếm theo key
    List<Book> search(String key);

}
