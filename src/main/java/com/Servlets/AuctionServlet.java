package com.Servlets;

import com.model.Auction;
import com.DAO.AuctionDAO;
import com.DAO.UserDAO;
import com.model.User;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "AuctionServlet", value = "/auction")
public class AuctionServlet extends HttpServlet {

    private int auctionId;

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private UserDAO userDAO;
    private AuctionDAO auctionDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDAO = new UserDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            auctionDAO = new AuctionDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Auction auction = null;

        // get GET parameter
        auctionId = Integer.parseInt(request.getParameter("id"));

        // get auction from database
        try {
            auction = getAuctionClass(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // if auction with that id exist
        if(auction != null) {

            // add Auction to the request
            request.setAttribute("AUCTION", auction);

            // send to JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/index?status=auction_notexist");
        }

    }

    private Auction getAuctionClass(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get Auction class from database by ID
        return auctionDAO.getAuctionById(auctionId);

    }

    private User getUserById(Auction auction) throws Exception {
        return userDAO.getUserById(auction.getUser().getUserID());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
