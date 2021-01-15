package com.databaseRelated;

import com.Sklep.jsp.Auction;

import javax.sql.DataSource;
import java.sql.*;

public class AuctionDbUtil {
    private DataSource dataSource;

    public AuctionDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Auction getAuctionById(String id) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT * FROM auction WHERE id='" + id + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                String auctionID = myRs.getString("id");
                String title = myRs.getString("title");
                String description = myRs.getString("description");
                Double price = myRs.getDouble("price");
                Date startDate = myRs.getDate("startdate");
                Date endDate = myRs.getDate("enddate");
                String userId = myRs.getString("numberofphotos");
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
