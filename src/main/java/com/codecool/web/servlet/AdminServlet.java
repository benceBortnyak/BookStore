package com.codecool.web.servlet;

import com.codecool.web.dao.BookDao;
import com.codecool.web.dao.database.DatabaseBookDao;
import com.codecool.web.model.Book;
import com.codecool.web.service.BookService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/admin")
public class AdminServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            BookDao bookDao = new DatabaseBookDao(connection);
            BookService bookService = new SimpleBookService(bookDao);
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            int pages = Integer.valueOf(req.getParameter("pages"));

            bookService.addBook(new Book(0,title,author,pages,0));
            sendMessage(resp, HttpServletResponse.SC_OK,"book added");
        }catch (ServiceException | SQLException e){
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST,"error");
            e.printStackTrace();
        }
    }
}
