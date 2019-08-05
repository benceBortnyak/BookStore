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
    public User addUser(String user_email ,String user_first_name,String user_second_name,String user_password ,Boolean is_admin ) throws SQLException,ServiceException{
        try{
            return userDao.addUser(user_email ,user_first_name,user_second_name,user_password ,is_admin);
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public UserDetails addUserDetalis(UserDetails userDetails, int user_id) throws ServiceException,IllegalArgumentException{
        try{
            return userDao.addUserDetalis(userDetails,user_id);
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
