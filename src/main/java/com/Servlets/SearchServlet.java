package com.Servlets;

import com.Sklep.jsp.Auction;
import com.databaseRelated.AuctionDbUtil;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {

    private String category;

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private AuctionDbUtil auctionDbUtil;


    @Override
    public void init() throws ServletException {
        super.init();
        try {
            auctionDbUtil = new AuctionDbUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        category = request.getParameter("category");

        try {
            getAuctions(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAuctions(HttpServletRequest request, HttpServletResponse response) throws Exception{

        List<Auction> auctions = auctionDbUtil.getAuctionsByCategory(category);

        request.setAttribute("AUCTIONS", auctions);
        // add Auction to the request

        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
        // send to JSP page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
