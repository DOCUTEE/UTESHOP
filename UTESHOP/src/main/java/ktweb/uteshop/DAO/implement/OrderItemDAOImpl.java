package ktweb.uteshop.DAO.implement;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IOrderItemDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;

import java.util.List;

public class OrderItemDAOImpl implements IOrderItemDAO {
    @Override
    public void insert(OrderItem orderItem){
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(orderItem);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(OrderItem orderItem) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.remove(orderItem);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<OrderItem> findAll(int orderId) {
        EntityManager em = JPAConfig.getEntityManager();
        List<OrderItem> orderItems = em.createQuery("SELECT oi FROM OrderItem oi WHERE oi.order.id = :orderId", OrderItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
        em.close();
        return orderItems;
    }

    @Override
    public int countAll(int orderId) {
        EntityManager em = JPAConfig.getEntityManager();
        List<OrderItem> orderItems = em.createQuery("SELECT oi FROM OrderItem oi WHERE oi.order.id = :orderId", OrderItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
        em.close();
        return orderItems.size();
    }
    public static void main(String[] args) {
        EntityManager em = JPAConfig.getEntityManager();
    }
}
