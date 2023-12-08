package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.User;
import com.example.casemodule3.Model.AdminDAO;
import com.example.casemodule3.Model.AdminModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    protected AdminDAO adminDAO;
    public UserController(){
        this.adminDAO = new AdminModel();
    }

    public void showUserDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = adminDAO.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/userDetail.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    public void showFormUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = adminDAO.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/updateUser.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    public void showListUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<User> listUser = adminDAO.getAll();
        req.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/userList.jsp");
        dispatcher.forward(req, resp);
    }

    public void deleteLibrarian(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        adminDAO.deleteUser(id);
        resp.sendRedirect("/admin?action=list");
    }

    public void showFormAddLibrarian(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/addLibrarian.jsp");
        dispatcher.forward(req, resp);
    }

    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        User user = new User(id, name, email, phone);
        adminDAO.updateUser(user);
        resp.sendRedirect("/admin?action=list");
    }

    public void addLibrarian(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(name, email, phone, username, password, role);
        adminDAO.addUser(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/addLibrarian.jsp");
        dispatcher.forward(req, resp);
    }
}
