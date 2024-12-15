package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Cart;

public interface ICartService {
        public Cart findByUserId(int id);
        void insert(Cart cart);
}
