package com.example.casemodule3.Model;

import com.example.casemodule3.Database.Database;
import com.example.casemodule3.Entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel implements UserDAO {

    protected Connection conn;

    public UserModel() {
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
    public boolean checkUser(String username, String password) throws SQLException {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // Nếu có kết quả, đăng nhập thành công
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi kết nối cơ sở dữ liệu
        }
        return false; // Đăng nhập không thành công
    }
    @Override
    public User getUserName(String username, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String avatar = resultSet.getString(5);
                String nameUser = resultSet.getString(6);

                user = new User(id, name, email, phone, avatar, nameUser);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String getRole(String username) throws SQLException {
        try {
            String query = "SELECT role FROM users WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("role"); // Trả về vai trò của người dùng
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi kết nối cơ sở dữ liệu
        }
        return null; // Trả về null nếu không tìm thấy vai trò
    }
}
