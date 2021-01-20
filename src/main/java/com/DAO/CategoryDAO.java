package com.DAO;

import com.AdditionalComponents.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private DataSource dataSource;

    public CategoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Category> getCategoriesBySearchText(String searchInput) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();

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

    public List<Category> getAllCategories() throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT category, count(*) AS count FROM auction GROUP BY category";

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
