package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Category;

public interface ICategoryService {
        public void insert(Category category);
        public void update(Category category);
        public void deleteById(int id);
}
