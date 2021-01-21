package com.Servlets;

import com.DAO.AuctionDAO;
import com.DAO.UserDAO;
import com.model.Auction;
import com.model.Cookies;
import com.model.User;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyAuctionsServlet", value = "/myauctions")
public class MyAuctionsServlet extends HttpServlet {

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

        int sessionId = Integer.parseInt(Cookies.getSessionId(request, response));

        // check if logged in
        if (sessionId > 0) {
            try {
                getUserAuctions(request, response, sessionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getUserById(request, response, sessionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index?status=not_leggedin");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/bought.jsp");
        dispatcher.forward(request, response);


    }

    private void getUserById(HttpServletRequest request, HttpServletResponse response, int sessionId) throws Exception{
        User user = userDAO.getUserById(sessionId);

        request.setAttribute("USER", user);
    }

    private void getUserAuctions(HttpServletRequest request, HttpServletResponse response, int sessionId) throws Exception{

        List<Auction> auctions = auctionDAO.getUserAuctions(sessionId);

        request.setAttribute("AUCTIONS", auctions);
        // add Auctions to the request
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
