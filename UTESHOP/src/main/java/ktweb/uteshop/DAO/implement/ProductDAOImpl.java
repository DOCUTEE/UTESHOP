package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.IProductDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Product;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public void insert(Product product) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }
    public void update(Product product) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(int productId) {
        //set isDelete = true
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, productId);
        product.setDelete(true);
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }
    public Product findById(int productId) {
        EntityManager em = JPAConfig.getEntityManager();
        Product product = em.find(Product.class, productId);
        em.close();
        return product;
    }
    public Product findByName(String productName) {
        EntityManager em = JPAConfig.getEntityManager();
        Product product = em.find(Product.class, productName);
        em.close();
        return product;
    }
    public List<Product> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.isDelete != true", Product.class).getResultList();
        em.close();
        return products;
    }
    public List<Product> findByKeyword(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :keyword and p.isDelete != true ", Product.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
        em.close();
        return products;
    }

    @Override
    public List<Product> findByKeywordAndPage(String keyword, int page, int pageSize, int vendorId) {
        EntityManager em = JPAConfig.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :keyword AND p.vendor.vendorId = :vendorId and p.isDelete != true", Product.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setParameter("vendorId", vendorId)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        em.close();
        return products;
    }

    @Override
    public List<Product> findByVendorId(int vendorId) {
        return List.of();
    }


    @Override
    public List<Product> findByVendorIdAndPage(int vendorId, int page, int pageSize) {
        EntityManager em = JPAConfig.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.vendor.vendorId = :vendorId and p.isDelete != true ", Product.class)
                .setParameter("vendorId", vendorId)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        em.close();
        return products;
    }


    @Override
    public List<Product> findByKeywordAndPage(String keyword, Integer page, Integer productByPage) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            String jsql = "SELECT p FROM Product p WHERE p.name LIKE :keyword and p.isDelete != true";
            List<Product> productList = em.createQuery(jsql, Product.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .setFirstResult((page - 1) * productByPage)
                    .setMaxResults(productByPage)
                    .getResultList();
            trans.commit();
            return productList;
        }
        catch (Exception ex) {
            trans.rollback();
            throw ex;
        }
    }

    public static void main(String[] args) {

    }
}
