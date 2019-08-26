package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface UserService {

    User getUserByEmail(String email) throws SQLException, ServiceException;
    User addUser(String userEmail ,String userFirstName,String userSecondName,String userPassword ,Boolean isAdmin) throws SQLException,ServiceException;
    UserDetails addUserDetalis(UserDetails userDetails, int userId) throws SQLException,ServiceException;
    UserDetails getUserDetalisById(int id) throws ServiceException,IllegalArgumentException;
}
