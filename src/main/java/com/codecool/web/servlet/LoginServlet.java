package com.codecool.web.servlet;

import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleUserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userDao);
            LoginService loginService = new LoginService();
            User user = userService.getUserByEmail(req.getParameter("email"));
            if(loginService.loginCheck(user.getEmail(),req.getParameter("password"),user.getPassword())){
                user.setPassword(null);
                System.out.println(user);
                req.getSession().setAttribute("user",user);
                sendMessage(resp,HttpServletResponse.SC_OK,user);
            }
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED,"login failed");
        }catch (ServiceException e){
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }catch (SQLException e){
            handleSqlError(resp,e);
        }
    }
}
