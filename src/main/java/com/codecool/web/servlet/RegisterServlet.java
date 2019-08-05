package com.codecool.web.servlet;

import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends AbstractServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userDao);
            String email = req.getParameter("email");
            String foreName = req.getParameter("foreName");
            String sencondName = req.getParameter("secondName");
            String password = req.getParameter("password");
            String rePassword = req.getParameter("rePassword");
            if(password.equals(rePassword)) {
                try {
                    User user = userService.addUser(email, foreName, sencondName, password, false);
                    user.setPassword(null);
                    user.setAdmin(null);
                    req.getSession().setAttribute("user",user);
                    sendMessage(resp,HttpServletResponse.SC_OK,user);
                }catch (SQLException |ServiceException e ){
                    sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                }
            }else{
                sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Register Failed");
            }
        }catch (SQLException e ){
            sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
