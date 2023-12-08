package com.example.casemodule3.Servlet;

import com.example.casemodule3.Controller.BookController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    protected BookController bookController;

    @Override
    public void init() throws ServletException {
        bookController = new BookController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "update":
                    bookController.showFromUpdate(req, resp);
                    break;
                case "add":
                    bookController.showAddBook(req, resp);
                    break;
                case "delete":
                    bookController.deleteBook(req, resp);
                    break;
                case "search":
                    bookController.showListBook(req, resp);
                    break;
                default:
                    bookController.showListBook(req,resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action) {
            case "addBook":
                bookController.addListBook(req, resp);
                break;
            case "updateBook":
                bookController.updateBook(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
