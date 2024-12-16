package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Category;
import java.util.List;

public interface ICategoryDAO {
        public void insert(Category category);
        public void update(Category category);
        public void deleteById(int id);
        public Category findById(int id);
        public List<Category> findAll();
}
