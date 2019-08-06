package com.codecool.web.servlet;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.dao.database.DatabaseOrderDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.User;
import com.codecool.web.service.OrderService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            OrderDao orderDao = new DatabaseOrderDao(connection);
            OrderService orderService = new SimpleOrderService(orderDao);
            ObjectMapper mapper = new ObjectMapper();
            String booksReq = req.getParameter("books");
            System.out.println(booksReq);
            List<Book> books = mapper.readValue(booksReq, new TypeReference<List<Book>>() {});
            System.out.println(books);
            User user = (User) req.getSession().getAttribute("user");
            Integer orderId = orderService.createOrder(books,user.getId());
            System.out.println(books);
            orderService.addOrderBook(books,orderId);
            sendMessage(resp,HttpServletResponse.SC_OK,"order added");
        }catch (SQLException e){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
            e.printStackTrace();
        }catch (ServiceException e ){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
            e.printStackTrace();
        }
    }
}
