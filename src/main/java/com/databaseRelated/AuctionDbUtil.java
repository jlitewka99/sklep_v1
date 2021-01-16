package com.databaseRelated;

import com.AdditionalComponents.Category;
import com.Sklep.jsp.Auction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuctionDbUtil {
    private DataSource dataSource;

    public AuctionDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Category> getCategoriesOfSearch(String searchInput) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            //SELECT CategoryID, count(*) AS counter FROM Products GROUP BY CategoryID;

            String sql = "SELECT category, count(*) AS count FROM auction WHERE title LIKE '%" + searchInput + "%' GROUP BY category";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            List<Category> categories = new ArrayList<>();

            while (myRs.next()) {
                String category = myRs.getString("category");
                int count = myRs.getInt("count");

                Category tempCategory = new Category(category,count);
                categories.add(tempCategory);
            }
            return categories;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    public List<Auction> getAuctionsByCategory(String category) throws Exception { // method returns auctions by category
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT * FROM auction WHERE category='" + category + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            List<Auction> auctions = new ArrayList<>();

            while (myRs.next()) {
                String auctionID = myRs.getString("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");

                Auction tempAuction = new Auction(auctionID, title, description, price, category);
                auctions.add(tempAuction);
            }
            return auctions;

        } finally {
            close(myConn, myStmt, myRs);
        }

    }

    public Auction getAuctionById(String id) throws Exception { // method returns auction by ID
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT * FROM auction WHERE id='" + id + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            if (myRs.next()) {
                String auctionID = myRs.getString("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");
                Date startDate = myRs.getDate("startdate");
                Date endDate = myRs.getDate("enddate");
                String userId = myRs.getString("userid");
                int numberOfPhotos = myRs.getInt("numberofphotos");

                return new Auction(auctionID, title, description, price, startDate, endDate, numberOfPhotos, userId);
            }

        } finally {
            close(myConn, myStmt, myRs);
        }
        return null;

    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myConn != null) {
                myConn.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myRs != null) {
                myRs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
