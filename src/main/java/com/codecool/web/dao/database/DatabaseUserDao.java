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
    public User addUser(String userEmail ,String userFirstName,String userSecondName,String userPassword ,Boolean isAdmin ) throws SQLException {
        String sql = "INSERT into users (user_email ,user_first_name, user_second_name, user_password ,is_admin ,user_credit) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, userEmail);
            statement.setString(2, userFirstName);
            statement.setString(3, userSecondName);
            statement.setString(4, userPassword);
            statement.setBoolean(5, isAdmin);
            statement.setInt(6, 6000);

            executeInsert(statement);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return fetchUser(rs);
            }
        } catch (SQLException e) {
            throw e;
        }
        throw new IllegalArgumentException();
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

    @Override
    public UserDetails getUserDetails(int userID) throws SQLException,IllegalArgumentException{
        String sql = " SELECT * FROM user_details where user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return fetchUserDetails(rs);
            }
            throw new IllegalArgumentException();
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
        return user;
    }

    private UserDetails fetchUserDetails(ResultSet resultSet) throws SQLException{
        int detailId = resultSet.getInt("detailId");
        String city = resultSet.getString("user_city");
        String street = resultSet.getString("user_street");
        int zipcode = resultSet.getInt("user_zipcode");
        int streetNum = resultSet.getInt("user_street_number");
        int userId = resultSet.getInt("user_id");
        return new UserDetails(detailId,city,street,zipcode,streetNum,userId);

    }
}
