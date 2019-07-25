package com.codecool.web.dao;

import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;

import java.sql.SQLException;

public interface UserDao {

    public User getUserByEmail(String email) throws SQLException;
    public void addUser(String user_email ,String user_first_name,String user_second_name,String user_password ,Boolean is_admin ) throws SQLException;
    public void addUserDetalis(UserDetails userDetails, int user_id) throws SQLException;
}
