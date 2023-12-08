package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Entity.User;
import com.example.casemodule3.Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BookController {
    protected BookDAO bookDAO;
    protected AdminDAO adminDAO;
    protected CustomerDAO customerDAO;
    protected UserDAO userDAO;
    public BookController(){
        bookDAO = new BookModel();
        adminDAO = new AdminModel();
        customerDAO = new CustomerModel();
        userDAO = new UserModel();
    }

    public void showListBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Book> data;
    data = bookDAO.getAll();
    request.setAttribute("books", data);
    RequestDispatcher view = request.getRequestDispatcher("book/bookList.jsp");
    view.forward(request, response);
    }

    public void showHomeAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> data;
        List<User> users;
        data = bookDAO.get5NewestBooks(5);
        int total = bookDAO.totalBook();
        int totalCustomer = customerDAO.totalCustomer();
        int totalUser = userDAO.totalUser();
        users = adminDAO.getAll();
        request.setAttribute("newBook", data);
        request.setAttribute("total", total);
        request.setAttribute("user", users);
        request.setAttribute("totalCustomer", totalCustomer);
        request.setAttribute("totalUser", totalUser);
        RequestDispatcher view = request.getRequestDispatcher("admin/adminHome.jsp");
        view.forward(request, response);
    }

    public void showHomeLibrarian(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> data;
        data = bookDAO.get5NewestBooks(5);
        int total = bookDAO.totalBook();
        int totalCustomer = customerDAO.totalCustomer();
        int totalUser = userDAO.totalUser();
        request.setAttribute("newBook", data);
        request.setAttribute("total", total);
        request.setAttribute("totalCustomer", totalCustomer);
        request.setAttribute("totalUser", totalUser);
        RequestDispatcher view = request.getRequestDispatcher("librarian/librarianHome.jsp");
        view.forward(request, response);
    }
}
