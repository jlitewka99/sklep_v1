package com.Servlets;

import com.DAO.AuctionDAO;
import com.DAO.CategoryDAO;
import com.DAO.UserDAO;
import com.model.Auction;
import com.model.Cookies;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BoughtServlet", value = "/bought")
public class BoughtServlet extends HttpServlet {

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
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int sessionId = Integer.parseInt(Cookies.getSessionId(request, response));

        // check if logged in
        if(sessionId > 0){
            try {
                getBoughtList(request, response, sessionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/index?status=not_leggedin");
        }
        request.setAttribute("COOK", sessionId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/bought.jsp");
        dispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getBoughtList(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {

        List<Auction> auctions = auctionDAO.getBoughtList(id);

        request.setAttribute("AUCTIONS", auctions);
        // add Auctions to the request
    }

}
