package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.ProductImage;
import java.util.List;
public interface IProductImageDAO {
    void insert(ProductImage productImage);
    void delete(int productImageId);
    List<ProductImage> findImages(int productId);
}

