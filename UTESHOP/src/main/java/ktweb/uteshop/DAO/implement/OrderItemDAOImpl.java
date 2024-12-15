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
    public void insert(OrderItem orderItem) {

    }
    public static void main(String[] args) {
        EntityManager em = JPAConfig.getEntityManager();

    }
}
