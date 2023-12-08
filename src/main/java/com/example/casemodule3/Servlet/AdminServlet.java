package com.example.casemodule3.Servlet;

import com.example.casemodule3.Controller.BookController;
import com.example.casemodule3.Controller.UserController;
import com.example.casemodule3.Entity.User;
import com.example.casemodule3.Model.AdminDAO;
import com.example.casemodule3.Model.AdminModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    AdminDAO adminDAO = new AdminModel();

    protected BookController bookController;
    protected UserController userController;
    @Override
    public void init() throws ServletException {
        bookController = new BookController();
        userController = new UserController();
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
                    userController.showFormAddLibrarian(req, resp);
                    break;
                case "view":
                    userController.showUserDetails(req, resp);
                    break;
                case "update":
                    userController.showFormUpdateUser(req, resp);
                    break;
                case "delete":
                    userController.deleteLibrarian(req, resp);
                    break;
                case "list":
                    userController.showListUser(req, resp);
                    break;
                default:
                    bookController.showHomeAdmin(req,resp);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
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
                    userController.addLibrarian(req, resp);
                    break;
                case "update":
                    userController.updateUser(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
