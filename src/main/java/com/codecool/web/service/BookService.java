package com.codecool.web.service;

import com.codecool.web.model.Book;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface BookService{

        List<Book> findAllBook() throws SQLException, ServiceException;
        void changeStock(int id,int stock) throws SQLException,ServiceException;
        public Book addBook(Book book) throws SQLException,ServiceException;
}
