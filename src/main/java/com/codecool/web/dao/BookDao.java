package com.codecool.web.dao;

import com.codecool.web.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    List<Book> findAllBook() throws SQLException;
    void changeStock(int id,int stock) throws SQLException;
    Book addBook(Book book) throws SQLException;
}
