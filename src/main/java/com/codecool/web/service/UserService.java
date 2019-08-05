package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface UserService {

    User getUserByEmail(String email) throws SQLException, ServiceException;
    User addUser(String user_email ,String user_first_name,String user_second_name,String user_password ,Boolean is_admin ) throws SQLException,ServiceException;
    UserDetails addUserDetalis(UserDetails userDetails, int user_id) throws SQLException,ServiceException;
    UserDetails getUserDetalisById(int id) throws ServiceException,IllegalArgumentException;
}
