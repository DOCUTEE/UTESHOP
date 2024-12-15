package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.CartItemDAOImpl;
import ktweb.uteshop.DAO.interfaces.ICartItemDAO;
import ktweb.uteshop.entity.CartItem;
import ktweb.uteshop.service.interfaces.ICartItemService;

import java.util.List;

public class CartItemServiceImpl implements ICartItemService {
        ICartItemDAO cartItemDAO = new CartItemDAOImpl();
        @Override
        public List<CartItem> findAllByCartId(int cartId) {
                return cartItemDAO.findAllByCartId(cartId);
        }

        @Override
        public void insert(CartItem cartItem) {
                if (cartItemDAO.findByProductId(cartItem.getProduct().getProductId()) != null) {
                        CartItem cartItem1 = cartItemDAO.findByProductId(cartItem.getProduct().getProductId());
                        cartItem1.setQuantity(cartItem1.getQuantity() + cartItem.getQuantity());
                        cartItemDAO.update(cartItem1);
                        return;
                };
                cartItemDAO.insert(cartItem);
        }

        @Override
        public void update(CartItem cartItem) {
                cartItemDAO.update(cartItem);
        }

        @Override
        public void deleteById(int id) {
                cartItemDAO.deleteById(id);
        }
}
