package com.controller;

import com.DAO.AuctionDAO;
import com.model.Cookies;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RateServlet", value = "/rate")
public class RateServlet extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private AuctionDAO auctionDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            auctionDAO = new AuctionDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cookieId = Integer.parseInt(Cookies.getSessionId(request, response));
        if(cookieId > 0){
            int id = Integer.parseInt(request.getParameter("productId"));
            int rating = Integer.parseInt(request.getParameter("rateRadio"));

            try {
                rateAuction(id, rating);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }






        response.sendRedirect(request.getContextPath()+"/bought");
    }

    private void rateAuction(int id, int rating) throws Exception{
        auctionDAO.rateAuction(id, rating);
    }
}
