package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.IOrderDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Order;

import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
        @Override
        public List<Order> findAllByPage(int page, int limit) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT o FROM Order o";
                        List<Order> result = em.createQuery(jsql, Order.class).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public Order findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT o FROM Order o where o.id = :id";
                        Order result = em.createQuery(jsql, Order.class).setParameter("id", id).getSingleResult();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void insert(Order order) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(order);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void update(Order order) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(order);
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
                        Order order = em.find(Order.class, id);
                        em.remove(order);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }
}
