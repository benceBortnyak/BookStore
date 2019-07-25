package com.codecool.web.service.simple;

import com.codecool.web.dao.BookDao;
import com.codecool.web.model.Book;
import com.codecool.web.service.BookService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleBookService implements BookService {

    private final BookDao bookDao;

    public SimpleBookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAllBook() throws SQLException, ServiceException {
        try{
            return bookDao.findAllBook();
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void changeStock(int id,int stock) throws SQLException,ServiceException{
        try{
            bookDao.changeStock(id,stock);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public Book addBook(Book book) throws SQLException,ServiceException{
        try {
            return bookDao.addBook(book);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
