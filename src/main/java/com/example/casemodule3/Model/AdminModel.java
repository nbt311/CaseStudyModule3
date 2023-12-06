package com.example.casemodule3.Model;

import com.example.casemodule3.Database.Database;
import com.example.casemodule3.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminModel implements AdminDAO{
    protected Connection conn;
    public AdminModel(){
        Database database = Database.getInstance();
        this.conn = database.connect();
    }
    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String avatar = rs.getString(5);
                String username = rs.getString(6);
                String password = rs.getString(7);
                String role = rs.getString(8);
                User user = new User(id, name, email, phone, avatar, username, password, role);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void addUser(User user) throws SQLException {
        try{
            String sql = "INSERT INTO users (name, " +
                    "email, " +
                    "phone, " +
                    "username, " +
                    "password,role) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getUsername());
            statement.setString(5,user.getPassword());
            statement.setString(6, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
    }
}