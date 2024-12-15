package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CategoryDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICategoryDAO;
import ktweb.uteshop.entity.Category;
import ktweb.uteshop.service.interfaces.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
        ICategoryDAO categoryDAO = new CategoryDAOImpl();
        @Override
        public void insert(Category category) {
                categoryDAO.insert(category);
        }

        @Override
        public void update(Category category) {
                categoryDAO.update(category);
        }

        @Override
        public void deleteById(int id) {
                categoryDAO.deleteById(id);
        }
}