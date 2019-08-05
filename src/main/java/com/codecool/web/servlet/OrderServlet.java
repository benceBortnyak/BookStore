package com.codecool.web.servlet;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.dao.database.DatabaseOrderDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.User;
import com.codecool.web.service.OrderService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends AbstractServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            OrderDao orderDao = new DatabaseOrderDao(connection);
            OrderService orderService = new SimpleOrderService(orderDao);
            connection.setAutoCommit(false);
            List<Book> books = (List<Book>) req.getAttribute("books");
            User user = (User) req.getSession().getAttribute("user");
            Integer orderId = orderService.createOrder(books,user.getId());
            System.out.println(books);
            System.out.println(user);
            orderService.addOrderBook(books,orderId);
            connection.commit();
            sendMessage(resp,HttpServletResponse.SC_OK,"order added");
        }catch (SQLException e){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }catch (ServiceException e ){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
