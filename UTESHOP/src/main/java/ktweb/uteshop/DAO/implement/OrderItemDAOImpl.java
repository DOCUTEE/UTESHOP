package ktweb.uteshop.DAO.implement;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IOrderItemDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;

import java.util.List;

public class OrderItemDAOImpl implements IOrderItemDAO {
    @Override
    public void insert(OrderItem orderItem) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(orderItem);
        em.getTransaction().commit();
        em.close();
    }
    public static void main(String[] args) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, 1);
        System.out.println(customer.getName());
        em.getTransaction().commit();
        em.close();
    }
}
