package Cate.service.impl;

import java.io.File;
import java.util.List;

import Cate.dao.CategoryDAO;
import Cate.dao.impl.CategoryDAOImpl;
import Cate.model.Category;
import Cate.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    // Khởi tạo DAO để thao tác DB
    private CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category newCategory) {
        Category oldCategory = categoryDao.get(newCategory.getCateid());

        if (oldCategory != null) {
            oldCategory.setCatename(newCategory.getCatename());

            // Nếu có cập nhật icon mới
            if (newCategory.getIcon() != null && !newCategory.getIcon().isEmpty()) {
                // Xóa ảnh cũ
                String fileName = oldCategory.getIcon();
                final String dir = "E:\\upload";   // ⚠ đổi đường dẫn phù hợp môi trường của bạn
                File file = new File(dir + "/category/" + fileName);
                if (file.exists()) {
                    file.delete();
                }
                oldCategory.setIcon(newCategory.getIcon());
            }
            categoryDao.edit(oldCategory);
        }
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String catename) {
        return categoryDao.search(catename);
    }
}
