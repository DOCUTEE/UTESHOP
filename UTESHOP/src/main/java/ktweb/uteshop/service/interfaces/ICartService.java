package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Cart;

public interface ICartService {
        public Cart findByCustomerId(int id);
        public Cart findById(int id);
        void insert(Cart cart);

        void update(Cart cart);
}
