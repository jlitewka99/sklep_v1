package com.DAO;

import com.model.Auction;
import com.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuctionDAO {
    private DataSource dataSource;

    public AuctionDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addAuction(Auction auction) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "INSERT INTO auction "
                    + "(title, description, numberofphotos, startdate, enddate, userid, price, category) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, auction.getTitle());
            myStmt.setString(2, auction.getDescription());
            myStmt.setInt(3, auction.getNumberOfPhotos());
            myStmt.setDate(4, auction.getStartDate());
            myStmt.setDate(5, auction.getEndDate());
            myStmt.setInt(6, auction.getUser().getUserID());
            myStmt.setDouble(7, auction.getPrice());
            myStmt.setString(8, auction.getCategory());
            myStmt.execute();

        } finally {
            close(myConn, myStmt, null);
        }
    }

    public List<Auction> getAuctionsBySearchTextAndCategory(String text, String category) throws Exception { // method returns auctions by SearchText
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT * FROM auction WHERE title LIKE '%" + text + "%' AND category='" + category + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            List<Auction> auctions = new ArrayList<>();

            while (myRs.next()) {
                int auctionID = myRs.getInt("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");

                Auction tempAuction = new Auction(auctionID, title, description, price);
                auctions.add(tempAuction);
            }
            return auctions;

        } finally {
            close(myConn, myStmt, myRs);
        }

    }

    public List<Auction> getAuctionsBySearchText(String text) throws Exception { // method returns auctions by SearchText
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT * FROM auction WHERE title LIKE '%" + text + "%'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            List<Auction> auctions = new ArrayList<>();

            while (myRs.next()) {
                int auctionID = myRs.getInt("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");

                Auction tempAuction = new Auction(auctionID, title, description, price);
                auctions.add(tempAuction);
            }
            return auctions;

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
                int auctionID = myRs.getInt("id");
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

            String sql = "SELECT auction.id, auction.title, auction.description, " +
                    "auction.price, auction.startdate, auction.enddate, " +
                    "auction.numberofphotos, user.id AS uid, " +
                    "user.login AS ulogin, user.avgrating AS uavgrating, " +
                    "user.numberofratings AS unumberofratings " +
                    "FROM auction INNER JOIN user ON auction.userid=user.id " +
                    "WHERE auction.id='" + id + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            if (myRs.next()) {
                int auctionID = myRs.getInt("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");
                Date startDate = myRs.getDate("startdate");
                Date endDate = myRs.getDate("enddate");
                int numberOfPhotos = myRs.getInt("numberofphotos");

                int userId = myRs.getInt("uid");
                String login = myRs.getString("ulogin");
                Double avgRating = myRs.getDouble("uavgrating");
                int numberOfRatings = myRs.getInt("unumberofratings");





                return new Auction(auctionID, title, description, price, startDate, endDate, numberOfPhotos, new User(userId, login, avgRating, numberOfRatings));
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
