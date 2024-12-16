package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.OrderItemDAOImpl;
import ktweb.uteshop.entity.OrderItem;
import ktweb.uteshop.service.interfaces.IOrderItemService;
import java.util.List;

public class OrderItemServiceImpl implements IOrderItemService {
    @Override
    public void insert(OrderItem orderItem) {
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        orderItemDAO.insert(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        orderItemDAO.update(orderItem);
    }

    @Override
    public void delete(int orderItemId) {
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        orderItemDAO.delete(orderItemId);
    }

    @Override
    public OrderItem findById(int orderItemId) {
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        return orderItemDAO.findById(orderItemId);
    }
    @Override
    public List<OrderItem> findOrderItemsOfVendor(int vendorId, int page, int size) {
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        return orderItemDAO.findOrderItemsOfVendor(vendorId, page, size);
    }
}
