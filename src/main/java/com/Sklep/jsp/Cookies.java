package com.Sklep.jsp;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {
    public static boolean isLoggedIn(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] theCookies = request.getCookies(); // get cookies array

        String cookieId = "0";
        if (theCookies != null) // check if any cookie exist
        {
            for (Cookie tempCookie : theCookies) {
                if ("sessionCookie".equals(tempCookie.getName())) // if user id cookie exist
                {
                    cookieId = tempCookie.getValue();
                } else // if sessionCookie do not exist create new
                {
                    Cookie sessionCookie = new Cookie("sessionCookie", "0");

                    sessionCookie.setMaxAge(60 * 60 * 24 * 365);
                    response.addCookie(sessionCookie);
                }
            }
        } else // if any cookie do not exist create new
        {
            Cookie sessionCookie = new Cookie("sessionCookie", "0");

            sessionCookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(sessionCookie);
        }
        return cookieId.equals("1");
    }

}
