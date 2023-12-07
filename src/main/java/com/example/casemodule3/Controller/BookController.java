package com.example.casemodule3.Controller;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Model.BookDAO;
import com.example.casemodule3.Model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookController {
    protected BookDAO bookDAO;
    public BookController(){
        bookDAO = new BookModel();
    }

    public void showListBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Book> data;
    data = bookDAO.getAll();
//    for (Book book : data){
//        System.out.println(book);
//    }
    request.setAttribute("books", data);
    RequestDispatcher view = request.getRequestDispatcher("librarian/librarianHome.jsp");
    view.forward(request, response);
    }
}
