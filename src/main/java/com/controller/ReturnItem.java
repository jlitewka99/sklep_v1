package com.controller;

import com.DAO.AuctionDAO;
import com.DAO.UserDAO;
import com.model.Cookies;
import com.model.User;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet(name = "ReturnItem", value = "/returnitem")
public class ReturnItem extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private AuctionDAO auctionDAO;

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            auctionDAO = new AuctionDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }try {
            userDAO = new UserDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cookieId = Integer.parseInt(Cookies.getSessionId(request, response));
        if (cookieId > 0) {
            int id = Integer.parseInt(request.getParameter("productId"));
            int sellerId = 0;
            User user = null;

            try {
                changeStatus(id, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath() + "/bought");

        }

    }

    private void changeStatus(int id, int status) throws Exception{
        auctionDAO.changeStatus(id, status);
    }

    private int getSellerIdByAuctionId(int id) throws Exception{
        return auctionDAO.getSellerIdByAuctionId(id);
    }
}
