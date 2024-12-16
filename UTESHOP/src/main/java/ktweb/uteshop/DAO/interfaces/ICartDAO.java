package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Cart;

public interface ICartDAO {
        public Cart findByUserId(int id);
        public void insert(Cart cart);

        public Cart findById(int id);
        public void clearCart(Cart cart);

        void update(Cart cart);
}
