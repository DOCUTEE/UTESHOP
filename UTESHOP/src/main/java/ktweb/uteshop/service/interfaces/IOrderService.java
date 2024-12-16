package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.entity.Order;

import java.util.List;

public interface IOrderService {
        public List<Order> findAllByPage(int page, int limit);
        public void checkout(Order order, Cart cart);
        public Order findById(int id);
        public void insert(Order order);
        public void update(Order order);
        public void deleteById(int id);
        public List<Order> findByVendorId(int vendorId, int page, int size);
}
