package com.controller;

import com.DAO.AuctionDAO;
import com.DAO.UserDAO;
import com.model.Cookies;
import com.model.User;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Rate", value = "/rate")
public class Rate extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private AuctionDAO auctionDAO;

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            auctionDAO = new AuctionDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }try {
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

        int cookieId = Integer.parseInt(Cookies.getSessionId(request, response));
        if (cookieId > 0) {
            int id = Integer.parseInt(request.getParameter("productId"));
            int rating = Integer.parseInt(request.getParameter("rateRadio"));
            int sellerId = 0;
            User user = null;
            PrintWriter out = response.getWriter();

            try {
                rateAuction(id, rating);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                sellerId = getSellerIdByAuctionId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                user = userDAO.getUserById(sellerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Double avgRating = user.getAvgRating();
            int numberOfRatings = user.getNumberOfRatings();

            avgRating = ((avgRating * numberOfRatings + rating) / (numberOfRatings + 1));


            try {
                rateUser(sellerId, avgRating);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        response.sendRedirect(request.getContextPath() + "/bought");

    }

    private void rateUser(int id, Double avgRating) throws Exception{
        userDAO.rateUser(id, avgRating);
    }

    private int getSellerIdByAuctionId(int id) throws Exception{
        return auctionDAO.getSellerIdByAuctionId(id);
    }
    private void rateAuction(int id, int rating) throws Exception {
        auctionDAO.rateAuction(id, rating);
    }
}
