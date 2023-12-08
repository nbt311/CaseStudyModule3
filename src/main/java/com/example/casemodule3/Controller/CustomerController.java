package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Customer;
import com.example.casemodule3.Model.CustomerDAO;
import com.example.casemodule3.Model.CustomerModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    protected CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerModel();
    }
    public void showFromUpdateCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDAO.findCustomerById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/updateCustomer.jsp");
        req.setAttribute("customer",customer );
        dispatcher.forward(req, resp);
    }

    public void showFromAddCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian/addCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    public void showCustomerList(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Customer> listCustomer = customerDAO.getAll();
        req.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/customerList.jsp");
        dispatcher.forward(req, resp);
    }
    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String address = req.getParameter("address");
        String dateOfBirth = req.getParameter("dateOfBirth");

        Customer customer = new Customer(id, name, className , address,dateOfBirth);
        customerDAO.updateCustomer(customer);
        resp.sendRedirect("/customer");
    }

    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String address = req.getParameter("address");
        String dateOfBirth = req.getParameter("dateOfBirth");
        Customer customer = new Customer(name, className, address, dateOfBirth);
        customerDAO.addCustomer(customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian/addCustomer.jsp");
        dispatcher.forward(req, resp);
    }
}
