package ktweb.uteshop.DAO.implement;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.ICustomerDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Customer;

import java.util.List;

public class CustomerDAOImpl implements ICustomerDAO {
        @Override
        public List<Customer> findAllByPage(int page, int limit) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT c FROM Customer c";
                        List<Customer> result = em.createQuery(jsql, Customer.class).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public Customer findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        Customer customer = em.find(Customer.class, id);
                        trans.commit();
                        return customer;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public boolean insert(Customer customer) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(customer);
                        trans.commit();
                        return true;
                }
                catch (Exception ex) {
                        trans.rollback();
                        ex.printStackTrace();
                        return false;
                }
        }

        @Override
        public void update(Customer customer) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(customer);
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
                        Customer customer = em.find(Customer.class, id);
                        em.remove(customer);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public List<Customer> findByKeywordAndPage(String keyword, int page, int limit) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction transaction = em.getTransaction();
                try {
                        transaction.begin();
                        String jsql = "SELECT c FROM Customer c WHERE c.name LIKE :keyword and c.isDelete != true";
                        List<Customer> result = em.createQuery(jsql, Customer.class).setParameter("keyword", "%" + keyword + "%").setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();
                        transaction.commit();
                        return result;
                }
                catch (Exception ex) {
                        transaction.rollback();
                        throw ex;
                }
        }

        @Override
        public Customer findByEmail(String email) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT c FROM Customer c WHERE c.email = :email";
                        Customer customer = em.createQuery(jsql, Customer.class).setParameter("email", email).getSingleResult();
                        trans.commit();
                        return customer;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

}
