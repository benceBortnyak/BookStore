package com.codecool.web.dao.database;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseOrderDao extends AbstractDao implements OrderDao {

    public DatabaseOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public void createOrder(List<Book> books, int order_user_id)throws SQLException {
        String sql = "INSERT INTO orders (order_price, completed,order_user_id) VALUES (?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,fetchOrderPrice(books));
            statement.setBoolean(2,false);
            statement.setInt(3,order_user_id);
            executeInsert(statement);
        }
    }
    @Override
    public void addOrderBook(List<Book> bookList,int orderId) throws SQLException{
        String sql = "INSERT INTO book_orders (book_id_order,order_id_book) values (?,?)";
        for (int i = 0; i <bookList.size() ; i++) {
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,bookList.get(i).getBook_id());
            statement.setInt(2,orderId);
            executeInsert(statement);
            }
        }
    }
    @Override
    public void changeStatus(boolean status,int id ) throws SQLException{
        String sql = "UPDATE orders SET completed = ? where order_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setBoolean(1,status);
            statement.setInt(2,id);
            statement.executeUpdate();
        }
    }

    private int fetchOrderPrice(List<Book> bookList){
        int price = 0;
        for (Book book : bookList) {
            price = price + book.getBook_price();
        }
        return price;
    }
}
