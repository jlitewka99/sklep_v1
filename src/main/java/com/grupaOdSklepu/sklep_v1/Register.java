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

        int statusCode = User.userRegisterValidate(email, login, password, password2, city, postCode);

        if (statusCode == 0) {
            response.sendRedirect(request.getContextPath() + "/index?status=register_success");
        } else {
            response.sendRedirect(request.getContextPath() + "/index?status=register_error" + statusCode);
        }
    }
}
