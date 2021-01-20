package com.controller;

import com.model.Cookies;
import com.model.User;
import com.DAO.UserDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDAO = new UserDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get parameters from POST
        String login = request.getParameter("loginLogin");
        String password = request.getParameter("passwordLogin");

        // validate user data
        int status = User.userLoginValidate(login, password);

        User user = null;

        // check if record exist
        try {
            user = login(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (status == 0) {
            if (user != null) { // successful login
                Cookies.setSessionCookie(request, response, user);
                response.sendRedirect(request.getContextPath() + "/index?status=loggedin");
            } else { // if record do not exist in database
                response.sendRedirect(request.getContextPath() + "/index?status=login_error0");
            }
        } else { // form validation error
            response.sendRedirect(request.getContextPath() + "/index?status=login_error" + status);
        }
    }

    private User login(String login, String password) throws Exception{
        return userDAO.login(login, password);
    }
}
