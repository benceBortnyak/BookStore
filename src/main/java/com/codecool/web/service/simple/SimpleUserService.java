package com.codecool.web.service.simple;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleUserService implements UserService {

    private final UserDao userDao;

    public SimpleUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByEmail(String email) throws SQLException, ServiceException {
        try{
            return userDao.getUserByEmail(email);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public User addUser(String userEmail ,String userFirstName,String userSecondName,String userPassword ,Boolean isAdmin ) throws SQLException,ServiceException{
        try{
            return userDao.addUser(userEmail ,userFirstName,userSecondName,userPassword ,isAdmin);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public UserDetails addUserDetalis(UserDetails userDetails, int userId) throws ServiceException,IllegalArgumentException{
        try{
            return userDao.addUserDetalis(userDetails,userId);
        }catch (SQLException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public UserDetails getUserDetalisById(int id) throws ServiceException,IllegalArgumentException{
        try {
            return userDao.getUserDetails(id);
        }catch (SQLException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
