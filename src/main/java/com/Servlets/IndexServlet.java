package com.Servlets;

import com.AdditionalComponents.Category;
import com.databaseRelated.CategoryDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    @Resource(name = "jdbc/32403572_sklep")
    private DataSource dataSource;

    private CategoryDAO categoryDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            categoryDAO = new CategoryDAO(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAllCategories(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        // send to JSP page
    }

    private void getAllCategories(HttpServletRequest request, HttpServletResponse response) {

        List<Category> categories = null;
        try {
            categories = categoryDAO.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("CATEGORIES", categories);
        // add Categories to the request
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
