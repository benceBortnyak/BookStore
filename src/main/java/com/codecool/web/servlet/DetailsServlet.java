package com.codecool.web.servlet;

import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.model.User;
import com.codecool.web.model.UserDetails;
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

@WebServlet("/details")
public class DetailsServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = getConnection(req.getServletContext())){
            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userDao);
            try {
                UserDetails userDetails = userService.getUserDetalisById(Integer.valueOf(req.getParameter("userId")));
                sendMessage(resp,HttpServletResponse.SC_OK,userDetails);
            } catch (ServiceException e) {
                sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
            } catch (IllegalArgumentException e){
                sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST,"user info not found");
            }
        }catch (SQLException e ){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            UserDao userDao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userDao);
            String city = req.getParameter("city");
            String street = req.getParameter("street");
            Integer zip = Integer.valueOf(req.getParameter("zip"));
            Integer streetNo = Integer.valueOf(req.getParameter("streetNo"));
            UserDetails userDetails = new UserDetails(0,city,street,zip,streetNo,0);
            User user = (User) req.getSession().getAttribute("user");
            try {
                UserDetails userDetailsResp = userService.addUserDetalis(userDetails, user.getId());
                sendMessage(resp,HttpServletResponse.SC_OK,userDetailsResp);
            }catch (ServiceException e ){
                sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
            }
        }catch (SQLException e){
            sendMessage(resp,HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
