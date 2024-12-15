package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
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
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, productId);
        if (product != null) {
            em.remove(product);
        }
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
        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        em.close();
        return products;
    }
    public List<Product> findByKeyword(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.productName LIKE :keyword", Product.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
        em.close();
        return products;
    }
    public static void main(String[] args) {

    }
}
