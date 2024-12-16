package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Product;
import java.util.List;
public interface IProductDAO {
    void insert(Product product);
    void update(Product product);
    void delete(int productId);
    Product findById(int productId);
    Product findByName(String productName);
    List<Product> findAll();
    List<Product> findByKeyword(String keyword);
    List<Product> findByKeywordAndPage(String keyword, int page, int pageSize, int vendorId);
    List<Product> findByVendorId(int vendorId);
    List<Product> findByKeywordAndPage(String keyword, Integer page, Integer productByPage);
    List<Product> findByVendorIdAndPage(int vendorId, int page, int pageSize);
}
