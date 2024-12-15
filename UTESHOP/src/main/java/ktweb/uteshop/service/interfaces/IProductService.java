package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Product;

import java.util.List;

public interface IProductService {
    void insert(Product product);
    void update(Product product);
    void delete(int productId);
    Product findById(int productId);
    Product findByName(String productName);
    List<Product> findAll();
    List<Product> findByKeyword(String keyword);
    List<Product> findByKeywordAndPage(String keyword, int page, int pageSize, int vendorId);
}
