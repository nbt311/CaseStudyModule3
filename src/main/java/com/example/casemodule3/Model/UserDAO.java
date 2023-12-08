package com.example.casemodule3.Model;

import com.example.casemodule3.Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAll() throws SQLException;
    boolean checkUser(String userName, String password) throws SQLException;
    String getRole(String userName) throws SQLException;

    User getUserName(String username, String password);
}
