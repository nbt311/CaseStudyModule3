package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Model.BookDAO;
import com.example.casemodule3.Model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class BookController {
    protected BookDAO bookDAO;
    public BookController(){
        bookDAO = new BookModel();
    }

    public void showListBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        List<Book> data;
        if (keyword == null) {
            data = bookDAO.getAll();
        }else {
            data = bookDAO.search(keyword);
            System.out.println("lay du lieu" + data);
        }
        request.setAttribute("Keyword", data);

        request.setAttribute("books", data);
        RequestDispatcher view = request.getRequestDispatcher("book/bookList.jsp");
        view.forward(request, response);
    }

    public void showAddBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        RequestDispatcher view = request.getRequestDispatcher("/book/addBook.jsp");
        view.forward(request, response);
    }

    public void showFromUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{

        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.getById(id);
        book.setId(id);
        request.setAttribute("book", book);
        RequestDispatcher view = request.getRequestDispatcher("/book/updateBook.jsp");
        view.forward(request, response);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.delete(id);

        response.sendRedirect("/book");
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String avatar = request.getParameter("avatar");
            String describes = request.getParameter("describes");
            String status = request.getParameter("status");
            String category = request.getParameter("category");
            String author = request.getParameter("author");
            Book book = new Book(id, name, avatar, describes, status, category, author);

            bookDAO.update(book);

            response.sendRedirect("/book");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  void addListBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{

            String name = request.getParameter("name");
            String avatar = request.getParameter("avatar");
            String describes = request.getParameter("describes");
            String status = request.getParameter("status");
            String category = request.getParameter("category");
            String author = request.getParameter("author");
            Book book = new Book(name, avatar, describes, status, category, author);
            bookDAO.save(book);
            response.sendRedirect("/book");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


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
