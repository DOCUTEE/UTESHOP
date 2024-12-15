package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.ProductImage;

import java.util.List;

public interface IProductImageService {
    void insert(ProductImage productImage);
    void delete(int productImageId);
    List<ProductImage> findImages(int productId);
}
