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
        public void insert(CartItem cartItem, Integer productId, Integer cartId) {
                try {
                        CartItem existingCartItem = cartItemDAO.findByProductIdAndCartId(productId, cartId);

                        if (existingCartItem != null) {
                                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
                                existingCartItem.setPrice(existingCartItem.getPrice() + cartItem.getPrice());
                                cartItemDAO.update(existingCartItem);
                        } else {
                                cartItemDAO.insert(cartItem);
                        }
                        System.out.println("INSERT OKAY");
                } catch (Exception e) {
                        e.printStackTrace();
                        // Handle exception as needed
                }
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
