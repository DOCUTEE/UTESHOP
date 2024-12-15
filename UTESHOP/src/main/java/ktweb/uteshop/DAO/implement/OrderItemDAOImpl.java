package ktweb.uteshop.DAO.implement;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IOrderItemDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Customer;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;
import ktweb.uteshop.entity.Product;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.sql.Date;
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
    public void update(OrderItem orderItem) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.merge(orderItem);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(int orderItemId) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        OrderItem orderItem = em.find(OrderItem.class, orderItemId);
        if (orderItem != null) {
            em.remove(orderItem);
        }
        em.getTransaction().commit();
        em.close();
    }
    public OrderItem findById(int orderItemId) {
        EntityManager em = JPAConfig.getEntityManager();
        OrderItem orderItem = em.find(OrderItem.class, orderItemId);
        em.close();
        return orderItem;
    }


    public static void main(String[] args) {

    }
}
