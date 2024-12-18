package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.ProductDAOImpl;
import ktweb.uteshop.DAO.interfaces.IProductDAO;
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
    @Override
    public List<Product> findByKeywordAndPage(String keyword, int page, int pageSize, int vendorId) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findByKeywordAndPage(keyword, page, pageSize, vendorId);
    }

    @Override
    public List<Product> findByVendorId(int vendorId) {
        return List.of();
    }

    @Override
    public List<Product> findByVendorIdAndPage(int vendorId, int page, int pageSize) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        return productDAO.findByVendorIdAndPage(vendorId, page, pageSize);
    }
    @Override
    public void update(int productId, String name, String descript,int quantity,double price,double weight) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = productDAO.findById(productId);
        product.setName(name);
        product.setDescript(descript);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setWeight(weight);
        productDAO.update(product);
    }

    @Override
    public List<Product> findByKeywordAndPage(String keyword, Integer page, Integer productByPage) {
        IProductDAO productDAO = new ProductDAOImpl();
        return productDAO.findByKeywordAndPage(keyword, page, productByPage);
    }
}
