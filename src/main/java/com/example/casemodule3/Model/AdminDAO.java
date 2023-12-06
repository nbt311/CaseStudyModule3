package com.example.casemodule3.Model;

import com.example.casemodule3.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO {
    List<User> getAll() throws SQLException;
    void addUser(User user) throws SQLException;
}