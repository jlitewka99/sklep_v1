package com.controller;

import com.DAO.AuctionDAO;
import com.DAO.UserDAO;
import com.model.Auction;
import com.model.Cookies;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "Buy", value = "/buy")
public class Buy extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    AuctionDAO auctionDAO;

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

        // get id parameter from GET
        int id = Integer.parseInt(request.getParameter("id"));

        int sessionId = Integer.parseInt(Cookies.getSessionId(request, response));

        Auction auction = null;

        // get auction by id
        try {
            auction = getAuctionById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // check if user is logged in
        if (sessionId > 0) {

            // if auction with id exist
            if (auction != null) {

                // chceck if it is not users auction
                if(auction.getUser().getUserID() != sessionId) {

                    // create archive log about sold item
                    try {
                        addAuctionToArchive(auction, sessionId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // remove auction
                    try {
                        removeAuctionById(auction);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    response.sendRedirect(request.getContextPath() + "/index?status=bought");


                }else {
                    response.sendRedirect(request.getContextPath() + "/index?status=error_yourauction");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/index?status=auction_notexist");
            }

        } else { // if not logged in go back to index page
            response.sendRedirect(request.getContextPath() + "/index?status=not_leggedin");
        }


    }

    private void removeAuctionById(Auction auction) throws Exception{
        auctionDAO.removeAuctionById(auction);
    }

    private void addAuctionToArchive(Auction auction, int sessionId) throws Exception{
        auctionDAO.addAuctionToArchive(auction, sessionId);
    }

    private Auction getAuctionById(int id) throws Exception {
        return auctionDAO.getAuctionById(id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
