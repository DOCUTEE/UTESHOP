package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Order;

import java.util.List;

public interface IOrderDAO {
        public List<Order> findAllByPage(int page, int limit);
        public Order findById(int id);
        public void insert(Order order);
        public void update(Order order);
        public void deleteById(int id);
}
