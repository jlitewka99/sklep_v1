package com.controller;

import com.model.Cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Buy", value = "/buy")
public class Buy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // check if user is logged in
        if(Cookies.isLoggedIn(request, response)){

        }else{ // if not logged in go back to index page
            response.sendRedirect(request.getContextPath() + "/index?status=not_leggedin");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
