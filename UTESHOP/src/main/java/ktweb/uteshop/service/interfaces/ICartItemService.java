package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.CartItem;

import java.util.List;

public interface ICartItemService {
        public List<CartItem> findAllByCartId(int cartId);
        public void insert(CartItem cartItem);
        public void update(CartItem cartItem);
        public void deleteById(int id);
}
