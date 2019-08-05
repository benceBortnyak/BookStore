package com.codecool.web.dao.database;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.model.Book;

import java.sql.*;
import java.util.List;

public class DatabaseOrderDao extends AbstractDao implements OrderDao {

    public DatabaseOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public Integer createOrder(List<Book> books, int orderUserId) throws SQLException,IllegalArgumentException {
        String sql = "INSERT INTO orders (completed,order_user_id) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setBoolean(1, false);
            statement.setInt(2, orderUserId);
            executeInsert(statement);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt("order_id");
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void addOrderBook(List<Book> bookList, int orderId) throws SQLException {
        connection.setAutoCommit(false);
        String sql = "INSERT INTO book_orders (book_id_order,order_id_book) values (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < bookList.size(); i++) {
                statement.setInt(1, bookList.get(i).getBookId());
                statement.setInt(2, orderId);
                executeInsert(statement);
            }
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
        }

    }

    @Override
    public void changeStatus(boolean status, int id) throws SQLException {
        String sql = "UPDATE orders SET completed = ? where order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

}
