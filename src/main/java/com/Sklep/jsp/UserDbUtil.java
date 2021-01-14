package com.Sklep.jsp;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDbUtil {
    private DataSource dataSource;

    public UserDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User getUserById(String id) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;


        try{
            myConn = dataSource.getConnection();

            String sql = "SELECT login FROM user WHERE id='" + id + "'";

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            while(myRs.next()){
                String login = myRs.getString("login");
                String status;
                Double rating;
                return new User(id, login);
            }

        }
        finally {
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
        }
    }

}
