package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Model.BookDAO;
import com.example.casemodule3.Model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BookController {
    protected BookDAO bookDAO;
    public BookController(){
        bookDAO = new BookModel();
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
        data = bookDAO.get5NewestBooks(5);
        int total = bookDAO.totalBook();
        request.setAttribute("newBook", data);
        request.setAttribute("total", total);
        RequestDispatcher view = request.getRequestDispatcher("admin/adminHome.jsp");
        view.forward(request, response);
    }

    public void showHomeLibrarian(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> data;
        data = bookDAO.get5NewestBooks(5);
        int total = bookDAO.totalBook();
        request.setAttribute("newBook", data);
        request.setAttribute("total", total);
        RequestDispatcher view = request.getRequestDispatcher("librarian/librarianHome.jsp");
        view.forward(request, response);
    }
}
