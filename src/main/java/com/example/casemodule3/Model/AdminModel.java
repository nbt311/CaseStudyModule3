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

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            String sql ="SELECT id,name,email,phone FROM users WHERE id =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                user = new User(id, name, email, phone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try {
            String sql = "UPDATE users set name = ?,email= ?, phone =? where id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
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
