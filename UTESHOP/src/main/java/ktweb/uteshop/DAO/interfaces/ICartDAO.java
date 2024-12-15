package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.Cart;

public interface ICartDAO {
        Cart findByUserId(int id);
        void insert(Cart cart);

}
