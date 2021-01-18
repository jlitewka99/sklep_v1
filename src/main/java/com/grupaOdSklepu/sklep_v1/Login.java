package com.grupaOdSklepu.sklep_v1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie sessionCookie = new Cookie("sessionCookie", "1");

        sessionCookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(sessionCookie);
        response.sendRedirect(request.getContextPath()+"/index?status=loggedin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
