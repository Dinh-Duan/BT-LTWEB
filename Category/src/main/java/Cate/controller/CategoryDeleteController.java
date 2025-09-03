package Cate.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Cate.service.CategoryService;
import Cate.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        cateService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
