package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CartDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICartDAO;
import ktweb.uteshop.entity.Cart;
import ktweb.uteshop.service.interfaces.ICartService;

public class CartServiceImpl implements ICartService {
        ICartDAO cartDAO = new CartDAOImpl();
        @Override
        public Cart findByUserId(int id) {
                return cartDAO.findByUserId(id);
        }

        @Override
        public void insert(Cart cart) {
                cartDAO.insert(cart);
        }
}
