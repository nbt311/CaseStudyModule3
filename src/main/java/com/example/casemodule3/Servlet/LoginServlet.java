package com.example.casemodule3.Servlet;

import com.example.casemodule3.Model.UserDAO;
import com.example.casemodule3.Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserDAO users = new UserModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showFormLogin(req, resp);
    }

    private void showFormLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        try {
            if (users.checkUser(username,password)){
                String role = users.getRole(username);
                if (role.equals("admin")){
                    resp.sendRedirect("/admin");
                }else if (role.equals("librarian")){
                    resp.sendRedirect("/librarian");
                }
            }else {
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
