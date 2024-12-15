package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;
import java.util.List;
public interface IOrderItemDAO {
    void insert(OrderItem orderItem);
    void update(OrderItem orderItem);
    void delete(int orderItemId);
    OrderItem findById(int orderItemId);
}
