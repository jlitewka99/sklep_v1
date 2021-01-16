package com.Servlets;

import com.AdditionalComponents.Category;
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
    private String searchtext;

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
        searchtext = request.getParameter("searchtext");

        if (searchtext == null) {
            searchtext = "";
        }
        try {
            getCategoriesOfSearch(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (category != null) {
            try {
                getAuctionsByCategory(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
        // send to JSP page

    }

    private void getCategoriesOfSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Category> categories = auctionDbUtil.getCategoriesOfSearch(searchtext);

        request.setAttribute("CATEGORIES", categories);

    }


    private void getAuctionsByCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //List<Category> categories = auctionDbUtil.getCategoriesOfSearch("a");

        //request.setAttribute("CATEGORIES", categories);

        List<Auction> auctions = auctionDbUtil.getAuctionsByCategory(category);

        request.setAttribute("AUCTIONS", auctions);
        // add Auction to the request

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
