package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IReviewDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Review;
import java.util.List;

public class ReviewDAOImpl implements IReviewDAO {


    @Override
    public List<Review> findReviewsAll(int productId) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Review> reviews = entityManager.createQuery("SELECT r FROM Review r WHERE r.product.productId = :productId", Review.class)
                .setParameter("productId", productId)
                .getResultList();
        entityManager.close();
        return reviews;
    }

    @Override
    public void insert(Review review) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(review);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Review review) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(review);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int reviewId) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        Review review = entityManager.find(Review.class, reviewId);
        if (review != null) {
            entityManager.remove(review);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Review findById(int reviewId) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        Review review = entityManager.find(Review.class, reviewId);
        entityManager.close();
        return review;
    }
}
