package com.Servlets;

import com.Sklep.jsp.User;
import com.databaseRelated.UserDbUtil;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private UserDbUtil userDbUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDbUtil = new UserDbUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        try {
            getUserClass(request, response, productId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getUserClass(HttpServletRequest request, HttpServletResponse response, String userId) throws Exception {
        User user = userDbUtil.getUserById(userId);
        // get User class from database by ID

        request.setAttribute("USER", user);
        // add User to the request

        RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
        dispatcher.forward(request, response);
        // send ro JSP page
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
