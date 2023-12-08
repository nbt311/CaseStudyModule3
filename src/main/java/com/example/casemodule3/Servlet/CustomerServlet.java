package com.example.casemodule3.Servlet;

import com.example.casemodule3.Controller.CustomerController;
import com.example.casemodule3.Entity.Customer;
import com.example.casemodule3.Entity.User;
import com.example.casemodule3.Model.CustomerDAO;
import com.example.casemodule3.Model.CustomerModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerDAO customerDAO = new CustomerModel();
    protected CustomerController customerController;

    @Override
    public void init() throws ServletException {
        this.customerController = new CustomerController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    customerController.showFromAddCustomer(req, resp);
                    break;
                case "update":
                    customerController.showFromUpdateCustomer(req, resp);
                    break;
                default:
                    customerController.showCustomerList(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    customerController.addCustomer(req, resp);
                    break;
                case "update":
                    customerController.updateCustomer(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
