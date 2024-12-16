package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.ICategoryDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Category;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
        @Override
        public void insert(Category category) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(category);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void update(Category category) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(category);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void deleteById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        Category category = em.find(Category.class, id);
                        if (category != null) {
                                em.remove(category);
                        }
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }
        @Override
        public Category findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                Category category = em.find(Category.class, id);
                return category;
        }
        @Override
        public List<Category> findAll() {
                EntityManager em = JPAConfig.getEntityManager();
                List<Category> categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
                return categories;
        }
}
