package com.example.casemodule3.Model;

import com.example.casemodule3.Database.Database;
import com.example.casemodule3.Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel implements CustomerDAO {
    protected Connection conn;
    public CustomerModel(){
        Database database = Database.getInstance();
        this.conn = database.connect();
    }
    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String className = rs.getString(3);
                String address = rs.getString(4);
                String dateOfBirth = rs.getString(5);
                Customer customer = new Customer(id, name, className, address, dateOfBirth);
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
            try {
                String sql = "INSERT INTO customer (name," +
                        " className, " +
                        "address, " +
                        "dateOfBirth) VALUES (?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getClassName());
                statement.setString(3, customer.getAddress());
                statement.setString(4, customer.getDateOfBirth());
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage() + "Error");
            }
    }

    @Override
    public Customer findCustomerById(int id) throws SQLException {
        Customer customer = null;
        try {
            String sql ="SELECT id,name,classname,address, dateOfbirth FROM customer WHERE id =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String classname = rs.getString("classname");
                String address = rs.getString("address");
                String dateOfbirth = rs.getString("dateOfbirth");
                customer = new Customer(id, name, classname,address,dateOfbirth);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try {
            String sql = "UPDATE customer set name = ?,className= ?, address =?, dateOfBirth =? where id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getClassName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getDateOfBirth());
            statement.setInt(5, customer.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public int totalCustomer() {
        int total = 0;
        try {
            String sql = "SELECT count(id) from customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }
}
