package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.OrderDAOImpl;
import ktweb.uteshop.DAO.implement.OrderItemDAOImpl;
import ktweb.uteshop.DAO.interfaces.IOrderDAO;
import ktweb.uteshop.DAO.interfaces.IOrderItemDAO;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.entity.CartItem;
import ktweb.uteshop.entity.Order;
import ktweb.uteshop.entity.OrderItem;
import ktweb.uteshop.service.interfaces.ICartItemService;
import ktweb.uteshop.service.interfaces.ICartService;
import ktweb.uteshop.service.interfaces.IOrderService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
        IOrderDAO orderDAO = new OrderDAOImpl();
        IOrderItemDAO orderItemDAO = new OrderItemDAOImpl();
        ICartService cartService = new CartServiceImpl();
        ICartItemService cartItemService = new CartItemServiceImpl();
        @Override
        public List<Order> findAllByPage(int page, int limit) {
                return orderDAO.findAllByPage(page, limit);
        }

        @Override
        public void checkout(Order order, Cart cart) {
                // Đặt ngày đặt hàng, khách hàng và các thông tin khác cho order
                order.setOrderDate(Date.valueOf(java.time.LocalDate.now()));
                order.setCustomer(cart.getCustomer());
                orderDAO.insert(order);

                // Duyệt qua từng cartItem để tạo OrderItem
                order.setOrderItems(new ArrayList<OrderItem>());
                for (CartItem cartItem : cart.getCartItems()) {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setOrder(order);
                        orderItem.setProduct(cartItem.getProduct());
                        orderItem.setQuantity(cartItem.getQuantity());
                        orderItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());

                        order.getOrderItems().add(orderItem);
                        orderItemDAO.insert(orderItem);
                        order.setTotalCost(order.getTotalCost() + orderItem.getPrice());
                }

                order.setStatus("Đã đặt hàng");
                order.setActualCost(order.getTotalCost() - order.getDiscount());
                cart.setCartItems(null);
                cartService.clearCart(cart);
                orderDAO.update(order);
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
