package com.DAO;

import com.model.User;

import javax.sql.DataSource;
import java.sql.*;

public class UserDAO {
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void addUser(User user) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "INSERT INTO user "
                    + "(login, password, email, city, street, postcode, avgrating, numberofratings) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, user.getLogin());
            myStmt.setString(2, user.getPassword());
            myStmt.setString(3, user.getEmail());
            myStmt.setString(4, user.getCity());
            myStmt.setString(5, user.getStreet());
            myStmt.setString(6, user.getPostCode());
            myStmt.setDouble(7, 0.0);
            myStmt.setInt(8, 0);

            myStmt.execute();

        } finally {
            close(myConn, myStmt, null);
        }

    }

    public User login(String login, String password) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT id FROM user WHERE login='" + login + "' AND password='" + password + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            if (myRs.next()) {
                int id = myRs.getInt("id");
                return new User(id);
            }

        } finally {
            close(myConn, myStmt, myRs);
        }
        return null;
    }

    public boolean doesLoginExist(String login) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT id FROM user WHERE login='" + login + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            if (myRs.next()) {
                return true;
            }

        } finally {
            close(myConn, myStmt, myRs);
        }
        return false;
    }

    public User getUserById(int id) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "SELECT login FROM user WHERE id='" + id + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            if (myRs.next()) {
                String login = myRs.getString("login");
                String status;
                Double rating;
                return new User(id, login);
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
