package com.codecool.web.dao.database;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;

import java.sql.*;

public final class DatabaseUserDao extends AbstractDao implements UserDao {

    public DatabaseUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public User getUserByEmail(String email) throws SQLException{
        if(email.equals("")){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        String sql = "SELECT * FROM users WHERE user_email = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchUser(resultSet);
                }
            }
        }
        throw new SQLException("Something went wrong");
    }

    @Override
    public void addUser(String userEmail ,String userFirstName,String userSecondName,String userPassword ,Boolean isAdmin ) throws SQLException{
        String sql = "INSERT into users (user_email ,user_first_name, user_second_name, user_password ,is_admin ,user_credit) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,userEmail);
            statement.setString(2,userFirstName);
            statement.setString(3,userSecondName);
            statement.setString(4,userPassword);
            statement.setBoolean(5,isAdmin);
            statement.setInt(6,6000);
            executeInsert(statement);
        }catch (SQLException e){
            throw e;
        }
    }
    @Override
    public void addUserDetalis(UserDetails userDetails, int userId) throws SQLException{
        String sql =" INSERT into user_details (user_city,user_street,user_zipcode,user_street_number,user_id ) values (?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,userDetails.getUserCity());
            statement.setString(2,userDetails.getUserStreet());
            statement.setInt(3,userDetails.getUserZipcode());
            statement.setInt(4,userDetails.getUserStreetNumber());
            statement.setInt(5,userId);
            executeInsert(statement);
        }catch (SQLException e){
            throw e;
        }


    }

    private User fetchUser(ResultSet resultSet) throws SQLException{
        int id =resultSet.getInt("user_id");
        String email = resultSet.getString("user_email");
        String firstName = resultSet.getString("user_first_name");
        String sencondName = resultSet.getString("user_second_name");
        String pw = resultSet.getString("user_password");
        Boolean admin = resultSet.getBoolean("is_admin");
        int credit = resultSet.getInt("user_credit");

        User user =  new User(id,email,pw,firstName,sencondName,admin,credit);
        System.out.println(user);
        return user;

    }
}
