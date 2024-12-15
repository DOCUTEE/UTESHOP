package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Category;

public interface ICategoryDAO {
        public void insert(Category category);
        public void update(Category category);
        public void deleteById(int id);
}
