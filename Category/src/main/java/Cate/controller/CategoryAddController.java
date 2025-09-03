package Cate.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Cate.model.Category;
import Cate.service.CategoryService;
import Cate.service.impl.CategoryServiceImpl;
import Cate.util.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/views/admin/add-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Category category = new Category();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");

        try {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");

            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("name")) {
                    category.setCatename(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("icon")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(Constant.DIR + "/category/" + fileName);
                        item.write(file);
                        category.setIcon("category/" + fileName);
                    }
                }
            }
            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}