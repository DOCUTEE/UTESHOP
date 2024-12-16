package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.CartItem;

import java.util.List;

public interface ICartItemDAO {
        public List<CartItem> findAllByCartId(int cartId);
        public void insert(CartItem cartItem);
        public void update(CartItem cartItem);
        public void deleteById(int id);

        CartItem findByProductIdAndCartId(int productId, int cartId);
}
