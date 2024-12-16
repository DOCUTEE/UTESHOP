package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.ICartDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Cart;

import java.util.List;
import java.util.concurrent.Callable;

public class CartDAOImpl implements ICartDAO {
        @Override
        public Cart findByUserId(int userId) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT cart FROM Cart cart WHERE cart.customer.id = :id";
                        Cart cart = em.createQuery(jsql, Cart.class).setParameter("id", userId).getSingleResult();
                        trans.commit();
                        return cart;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void insert(Cart cart) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(cart);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public Cart findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT cart FROM Cart cart WHERE cart.cartId = :id";
                        Cart cart = em.createQuery(jsql, Cart.class).setParameter("id", id).getSingleResult();
                        trans.commit();
                        return cart;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void clearCart(Cart cart) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "DELETE FROM CartItem ci WHERE ci.cart = :cart";
                        em.createQuery(jsql).setParameter("cart", cart).executeUpdate();
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }

        }

        @Override
        public void update(Cart cart) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(cart);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }

        }


}

