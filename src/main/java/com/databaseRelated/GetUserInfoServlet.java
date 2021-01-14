package com.databaseRelated;

import com.Sklep.jsp.UserData;
import com.Sklep.jsp.UserDbUtil;
import org.graalvm.compiler.lir.LIRInstruction;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "GetUserInfoServlet", value = "/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private UserDbUtil userDbUtil;
    @Resource(name="jdbc/32403572_sklep")
    private DataSource dataSource;
    @Override
    public void init() throws ServletException {
        super.init();

        try{
            userDbUtil = new UserDbUtil(dataSource);
        }
        catch (Exception ex){
            throw new ServletException(ex);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
