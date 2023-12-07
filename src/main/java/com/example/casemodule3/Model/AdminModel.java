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
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT name, email, phone, avatar, username, password, role FROM users";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String email = rs.getString(2);
                String phone = rs.getString(3);
                String avatar = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);
                String role = rs.getString(7);
                User user = new User(name, email, phone, avatar, username, password, role);
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

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            String sql = "DELETE FROM users WHERE id = ?" ;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return rowDeleted;
    }
}
