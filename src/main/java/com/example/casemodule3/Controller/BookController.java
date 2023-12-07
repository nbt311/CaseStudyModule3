package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Model.BookDAO;
import com.example.casemodule3.Model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
    RequestDispatcher view = request.getRequestDispatcher("librarian/librarianHome.jsp");
    view.forward(request, response);
    }

    public void showAddBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher = request.getRequestDispatcher("librarian/addBook.jsp");
        dispatcher.forward(request, response);
    }
    public void showUpdateBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.getById(id);
        book.setId(id);
        request.setAttribute("book", book);
        RequestDispatcher view = request.getRequestDispatcher("librarian/updateLibrarian.jsp");
        view.forward(request, response);
    }
    public  void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String name = request.getParameter("name");
            String avatar = request.getParameter("avatar");
            String describes = request.getParameter("describes");
            String status = request.getParameter("status");
            String category = request.getParameter("category");
            String author = request.getParameter("author");
            Book book = new Book(name, avatar, describes, status, category, author);
            bookDAO.save(book);
            response.sendRedirect("/librarian");
        }catch (SQLException e){
            System.out.println("Error saving book" + e.getMessage());
        }
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
//            System.out.println(request.getParameter("id"));
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String avatar = request.getParameter("avatar");
            String describes = request.getParameter("describes");
            String status = request.getParameter("status");
            String category = request.getParameter("category");
            String author = request.getParameter("author");
            Book book = new Book(id,name, avatar, describes, status, category, author);
            bookDAO.update(book);

//            response.sendRedirect("librarianHome.jsp");
        }
        catch (SQLException e) {
            System.out.println("Error update book" + e.getMessage());
        }
    }
    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.delete(id);
        response.sendRedirect("/librarian");
    }
}
