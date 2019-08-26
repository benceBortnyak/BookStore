package com.codecool.web.service.simple;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.model.Book;
import com.codecool.web.service.OrderService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleOrderService implements OrderService {

    private final OrderDao orderDao;

    public SimpleOrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Integer createOrder(List<Book> books, int orderUserId)throws IllegalArgumentException,ServiceException{
        try{
            return orderDao.createOrder(books,orderUserId);
        }catch (SQLException e ){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public void addOrderBook(List<Book> bookList,int orderId) throws SQLException,ServiceException{
        try{
            orderDao.addOrderBook(bookList,orderId);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public void changeStatus(boolean status,int id ) throws SQLException,ServiceException{
        try{
            orderDao.changeStatus(status,id);
        }catch (IllegalArgumentException e ){
            throw new ServiceException(e.getMessage());
        }
    }
}
