package com.Servlets;

import com.Sklep.jsp.Auction;
import com.Sklep.jsp.User;
import com.databaseRelated.AuctionDbUtil;
import com.databaseRelated.UserDbUtil;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private UserDbUtil userDbUtil;
    private AuctionDbUtil auctionDbUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDbUtil = new UserDbUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            auctionDbUtil = new AuctionDbUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");

        try {
            getAuctionClass(request, response, productId);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void getAuctionClass(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
        Auction auction = auctionDbUtil.getAuctionById(id);
        // get Auction class from database by ID
        auction.setUser(userDbUtil.getUserById(auction.getUserId()));


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
