package com.grupaOdSklepu.sklep_v1;

import com.Sklep.jsp.Status;
import com.Sklep.jsp.User;
import com.databaseRelated.UserDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private UserDAO userDAO;
    private boolean doesLoginExist = true;

    private String userID;
    private String login;
    private String password;
    private String password2;
    private String email;
    private String city;
    private String postCode;
    private String street;
    private Double avgRating;
    private int numberOfRatings;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("loginRegister");
        password = request.getParameter("passwordRegister");
        password2 = request.getParameter("password2Register");
        email = request.getParameter("emailRegister");
        city = request.getParameter("cityRegister");
        street = request.getParameter("streetRegister");
        postCode = request.getParameter("postCodeRegister");

        PrintWriter out = response.getWriter();

        int statusCode = User.userRegisterValidate(email, login, password, password2, city, postCode, street);


        try { // check if login exist in database
            doesLoginExist = doesLoginExist(login);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (statusCode == 0) {
            if (doesLoginExist) { // return error if login exist in database
                response.sendRedirect(request.getContextPath() + "/index?status=register_error0");
            }else{ // if validation do not returns error, and if login do not exist in database
                User user = new User(login, password, email, city, street, postCode);
                try {
                    addUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.sendRedirect(request.getContextPath() + "/index?status=register_success");
            }
        } else { // if validation returns error
            response.sendRedirect(request.getContextPath() + "/index?status=register_error" + statusCode);
        }
    }

    private boolean doesLoginExist(String login) throws Exception{
        return userDAO.doesLoginExist(login);
    }

    private void addUser(User user) throws Exception{
        userDAO.addUser(user);
    }
}
