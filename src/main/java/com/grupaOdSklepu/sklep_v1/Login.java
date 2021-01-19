package com.grupaOdSklepu.sklep_v1;

import com.Sklep.jsp.User;
import com.databaseRelated.UserDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    private String login;
    private String password;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = User.userLoginValidate(login, password);
        login = request.getParameter("loginRegister");
        password = request.getParameter("passwordRegister");

        User user = null;
        try {
            user = userDAO.login(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (status == 0) {
            if (user != null) {
                response.sendRedirect(request.getContextPath() + "/index?status=loggedin");
            } else {
                response.sendRedirect(request.getContextPath() + "/index?status=login_error0");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index?status=login_error" + status);
        }
    }
}
