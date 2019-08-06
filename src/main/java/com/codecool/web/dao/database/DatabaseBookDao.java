package com.codecool.web.dao.database;

import com.codecool.web.dao.BookDao;
import com.codecool.web.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBookDao extends AbstractDao implements BookDao {

    public DatabaseBookDao(Connection connection) {
        super(connection);
    }
    @Override
    public List<Book> findAllBook() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    bookList.add(fetchBook(resultSet));
                }
            }
        }
        return bookList;
    }
    @Override
    public void changeStock(int id,int stock) throws SQLException {
        String sql = "UPDATE books SET stock=? where book_id=?";
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }finally{
            connection.setAutoCommit(autoCommit);
        }
    }
    @Override
    public Book addBook(Book book) throws SQLException{
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT into books (book_title,book_author,book_page,stock) VALUES (?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,book.getBookTitle());
            statement.setString(2,book.getBookAuthor());
            statement.setInt(3,book.getBookPage());
            statement.setInt(4,1000);
            executeInsert(statement);
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return fetchBook(resultSet);
            }
        }catch (SQLException e) {
            connection.rollback();
            throw e;
        }finally {
            connection.setAutoCommit(autoCommit);
        }
        throw new SQLException("Insert failed");
    }


    private Book fetchBook(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("book_id");
        String title = resultSet.getString("book_title");
        String author = resultSet.getString("book_author");
        int page = resultSet.getInt("book_page");
        int stock = resultSet.getInt("stock");
        return new Book(id,title,author,page,stock);
    }

}
