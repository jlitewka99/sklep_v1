package com.Servlets;

import com.model.Auction;
import com.DAO.AuctionDAO;
import com.DAO.UserDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "AuctionServlet", value = "/auction")
public class AuctionServlet extends HttpServlet {

    private String auctionId;

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
        auctionId = request.getParameter("id");

        try {
            getAuctionClass(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void getAuctionClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Auction auction = auctionDAO.getAuctionById(auctionId);
        // get Auction class from database by ID

        auction.setUser(userDAO.getUserById(auction.getUserId()));
        // create class of seller of that item


        request.setAttribute("AUCTION", auction);
        // add Auction to the request

        RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
        dispatcher.forward(request, response);
        // send to JSP page
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
