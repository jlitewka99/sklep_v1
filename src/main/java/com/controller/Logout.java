package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Cookie sessionCookie = new Cookie("sessionCookie", "0");
        sessionCookie.setMaxAge(60 * 60 * 24 * 365);

        response.addCookie(sessionCookie);
        response.sendRedirect(request.getContextPath()+"/index?status=loggedout");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
