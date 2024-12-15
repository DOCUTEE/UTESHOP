package ktweb.uteshop.DAO.implement;

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
        public void insert(Customer customer) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(customer);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
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
}
