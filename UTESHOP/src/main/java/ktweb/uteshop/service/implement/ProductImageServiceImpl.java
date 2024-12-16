package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.ProductImageDAOImpl;
import ktweb.uteshop.entity.ProductImage;
import ktweb.uteshop.service.interfaces.IProductImageService;
import java.util.List;

public class ProductImageServiceImpl implements IProductImageService {
    @Override
    public void insert(ProductImage productImage) {
        ProductImageDAOImpl productImageDAO = new ProductImageDAOImpl();
        productImageDAO.insert(productImage);
    }

    @Override
    public void delete(int productImageId) {
        ProductImageDAOImpl productImageDAO = new ProductImageDAOImpl();
        productImageDAO.delete(productImageId);
    }
    @Override
    public List<ProductImage> findImages(int productId) {
        ProductImageDAOImpl productImageDAO = new ProductImageDAOImpl();
        return productImageDAO.findImages(productId);
    }
}
