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
    List<Product> findByVendorIdAndPage(int vendorId, int page, int pageSize);
    void update(int productId, String name, String descript,int quantity,double price,double weight);
}
