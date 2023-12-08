package com.example.casemodule3.Servlet;

import com.example.casemodule3.Entity.Book;
import com.example.casemodule3.Entity.BookBorrow;
import com.example.casemodule3.Entity.Customer;
import com.example.casemodule3.Model.BookBorrowingDAO;
import com.example.casemodule3.Model.BookBorrowingModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BorrowServlet", urlPatterns = "/borrow")
public class BorrowServlet extends HttpServlet {
    BookBorrowingDAO borrowDAO = new BookBorrowingModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {

                default:
                    showListBorrow(req,resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showListBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookBorrow> listBorrow = this.borrowDAO.getAllBookBorrow();
        req.setAttribute("listBorrow", listBorrow);
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/borrowList.jsp");
        dispatcher.forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
