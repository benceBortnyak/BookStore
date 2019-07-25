package com.codecool.web.dao;

import com.codecool.web.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    void createOrder(List<Book> books, int order_user_id)throws SQLException;
    void addOrderBook(List<Book> bookList,int orderId) throws SQLException;
    void changeStatus(boolean status,int id ) throws SQLException;
}
