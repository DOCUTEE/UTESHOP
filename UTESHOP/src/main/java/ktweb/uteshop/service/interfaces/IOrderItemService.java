package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.OrderItem;
import java.util.List;

public interface IOrderItemService {
    void insert(OrderItem orderItem);
    void update(OrderItem orderItem);
    void delete(int orderItemId);
    OrderItem findById(int orderItemId);
    List<OrderItem> findOrderItemsOfVendor(int vendorId, int page, int size);
}
