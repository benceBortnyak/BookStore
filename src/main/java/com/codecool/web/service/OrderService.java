package com.codecool.web.service;

import com.codecool.web.model.Book;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    Integer createOrder(List<Book> books, int order_user_id)throws SQLException, ServiceException,IllegalArgumentException;
    void addOrderBook(List<Book> bookList,int orderId) throws SQLException,ServiceException;
    void changeStatus(boolean status,int id ) throws SQLException,ServiceException;

}
