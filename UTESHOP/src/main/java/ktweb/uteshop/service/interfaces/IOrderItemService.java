package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.OrderItem;

public interface IOrderItemService {
    void insert(OrderItem orderItem);
    void update(OrderItem orderItem);
    void delete(int orderItemId);
    OrderItem findById(int orderItemId);
}
