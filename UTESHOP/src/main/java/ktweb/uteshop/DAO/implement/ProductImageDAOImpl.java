package ktweb.uteshop.DAO.implement;

import ktweb.uteshop.DAO.interfaces.IProductDAO;
import ktweb.uteshop.DAO.interfaces.IProductImageDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.ProductImage;
import jakarta.persistence.EntityManager;
import java.util.List;


public class ProductImageDAOImpl implements IProductImageDAO {
    @Override
    public void insert(ProductImage productImage) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(productImage);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int productImageId) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        ProductImage productImage = em.find(ProductImage.class, productImageId);
        if (productImage != null) {
            em.remove(productImage);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ProductImage> findImages(int productId) {
        EntityManager em = JPAConfig.getEntityManager();
        List<ProductImage> productImages = em.createQuery("SELECT pi FROM ProductImage pi WHERE pi.product.productId = :productId", ProductImage.class)
                .setParameter("productId", productId)
                .getResultList();
        em.close();
        return productImages;
    }
}
