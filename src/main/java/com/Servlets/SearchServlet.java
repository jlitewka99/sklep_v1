package com.Servlets;

import com.model.Category;
import com.model.Auction;
import com.DAO.AuctionDAO;
import com.DAO.CategoryDAO;

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

    private AuctionDAO auctionDAO;

    private CategoryDAO categoryDAO;


    @Override
    public void init() throws ServletException {
        super.init();
        try {
            auctionDAO = new AuctionDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            categoryDAO = new CategoryDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        category = request.getParameter("category");
        searchtext = request.getParameter("searchtext"); // get parameters from URL

        searchtext = Auction.filter(searchtext);

        request.setAttribute("searchtext", searchtext);

        if (category != null && searchtext != null) {
            try {
                getAuctionsBySearchTextAndCategory(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getCategoriesBySearchText(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (category == null && searchtext != null) {
            try {
                getAuctionsBySearchText(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getCategoriesBySearchText(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (category == null) { // category == null && searchtext == null

        } else { // category != null && searchtext == null
            try {
                getAuctionsByCategory(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getAllCategories(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
        // send to JSP page

    }

    private void getAllCategories(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Category> categories = categoryDAO.getAllCategories();

        request.setAttribute("CATEGORIES", categories);
        // add Categories to the request
    }

    private void getAuctionsBySearchText(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Auction> auctions = auctionDAO.getAuctionsBySearchText(searchtext);

        request.setAttribute("AUCTIONS", auctions);
        // add Auctions to the request
    }

    private void getAuctionsBySearchTextAndCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Auction> auctions = auctionDAO.getAuctionsBySearchTextAndCategory(searchtext, category);

        request.setAttribute("AUCTIONS", auctions);
        // add Auctions to the request
    }

    private void getCategoriesBySearchText(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Category> categories = categoryDAO.getCategoriesBySearchText(searchtext);

        request.setAttribute("CATEGORIES", categories);
        // add Categories to the request
    }


    private void getAuctionsByCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Auction> auctions = auctionDAO.getAuctionsByCategory(category);

        request.setAttribute("AUCTIONS", auctions);
        // add Auctions to the request
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
