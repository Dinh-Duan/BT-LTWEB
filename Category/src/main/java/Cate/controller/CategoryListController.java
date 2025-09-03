package Cate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Cate.model.Category;
import Cate.service.CategoryService;
import Cate.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Category> cateList = cateService.getAll();
        req.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/views/admin/listcategory.jsp");
        dispatcher.forward(req, resp);
    }
}
