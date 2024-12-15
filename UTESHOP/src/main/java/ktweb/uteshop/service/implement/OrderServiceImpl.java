package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.OrderDAOImpl;
import ktweb.uteshop.DAO.interfaces.IOrderDAO;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.util.List;

public class OrderServiceImpl implements IOrderService {
        IOrderDAO orderDAO = new OrderDAOImpl();
        @Override
        public List<Order> findAllByPage(int page, int limit) {
                return orderDAO.findAllByPage(page, limit);
        }

        @Override
        public Order findById(int id) {
                return orderDAO.findById(id);
        }

        @Override
        public void insert(Order order) {
                orderDAO.insert(order);

        }

        @Override
        public void update(Order order) {
                orderDAO.update(order);

        }

        @Override
        public void deleteById(int id) {
                orderDAO.deleteById(id);

        }
}
