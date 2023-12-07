package com.example.casemodule3.Servlet;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    showFromAddCustomer(req, resp);
                    break;
                case "update":
                    showFromUpdateCustomer(req, resp);
                    break;
                default:
                    showCustomerList(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFromUpdateCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDAO.findCustomerById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/updateCustomer.jsp");
        req.setAttribute("customer",customer );
        dispatcher.forward(req, resp);
    }

    private void showFromAddCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/librarian/addCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCustomerList(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Customer> listCustomer = customerDAO.getAll();
        req.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/customerList.jsp");
        dispatcher.forward(req, resp);
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
                    addCustomer(req, resp);
                    break;
                case "update":
                    updateCustomer(req, resp);
                    break;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String address = req.getParameter("address");
        String dateOfBirth = req.getParameter("dateOfBirth");

        Customer customer = new Customer(id, name, className , address,dateOfBirth);
        customerDAO.updateCustomer(customer);
        resp.sendRedirect("/customer");
    }

    private void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
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
