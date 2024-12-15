package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.ProductDAOImpl;
import ktweb.uteshop.entity.Product;
import ktweb.uteshop.service.interfaces.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    @Override
    public void insert(Product product) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.insert(product);
    }

    @Override
    public void update(Product product) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.update(product);
    }

    @Override
    public void delete(int productId) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.delete(productId);
    }

    @Override
    public Product findById(int productId) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findById(productId);
    }

    @Override
    public Product findByName(String productName) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findByName(productName);
    }

    @Override
    public List<Product> findAll() {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findByKeyword(keyword);
    }
}