package com.example.casemodule3.Model;

import com.example.casemodule3.Entity.Customer;
import jdk.nashorn.internal.runtime.regexp.joni.ast.CClassNode;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll() throws SQLException;
    void addCustomer(Customer customer) throws SQLException;
    Customer findCustomerById(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;

    int totalCustomer();

    boolean deleteCustomer(int id) throws SQLException;
}
