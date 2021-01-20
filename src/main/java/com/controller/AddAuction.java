package com.controller;

import com.DAO.AuctionDAO;
import com.model.Auction;
import com.model.Cookies;
import com.model.User;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "AddAuction", value = "/addauction")
public class AddAuction extends HttpServlet {

    private Date endDate;

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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(Cookies.getSessionId(request, response));


        if(userId > 0) { // check if logged in

            // get POST parameters
            String title = request.getParameter("auctionTitle");
            String description = request.getParameter("auctionDescription");
            double price = Double.parseDouble(request.getParameter("auctionPrice"));
            String category = request.getParameter("auctionCategory");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // conversion HTML date to sql date format
            try {
                endDate = Auction.dateConvert(sdf.parse(request.getParameter("auctionStartDate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int numberOfPhotos = Integer.parseInt(request.getParameter("auctionNumberOfPhotos"));


            // validation of auction data
            User user = new User(userId);
            int status = Auction.auctionValidate(title, description, numberOfPhotos, category, endDate, price);
            if(status == 0) {
                Auction auction = new Auction(title, description, price, category, endDate, numberOfPhotos, user);

                // insert into database
                try {
                    addAuction(auction);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.sendRedirect(request.getContextPath() + "/index?status=auction_success");

            }else { // validation error
                response.sendRedirect(request.getContextPath() + "/index?status=auction_error" + status);
            }
        }
    }

    private void addAuction(Auction auction) throws Exception{
        auctionDAO.addAuction(auction);
    }
}
