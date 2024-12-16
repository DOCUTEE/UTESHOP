package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CartDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICartDAO;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.service.interfaces.ICartService;

public class CartServiceImpl implements ICartService {
        ICartDAO cartDAO = new CartDAOImpl();
        @Override
        public Cart findByCustomerId(int id) {
                return cartDAO.findByUserId(id);
        }

        @Override
        public Cart findById(int id) {
                return cartDAO.findById(id);

        }

        @Override
        public void insert(Cart cart) {
                cartDAO.insert(cart);
        }

        @Override
        public void update(Cart cart) {

                cartDAO.update(cart);
        }

        @Override
        public void clearCart(Cart cart) {
                cartDAO.clearCart(cart);
        }
}
