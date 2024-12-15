package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.ICartItemDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.CartItem;

import java.util.List;

public class CartItemDAOImpl implements ICartItemDAO {
    @Override
    public List<CartItem> findAllByCartId(int cartId) {
            EntityManager em = JPAConfig.getEntityManager();
            EntityTransaction trans = em.getTransaction();
            try {
                    trans.begin();
                    String sql = "SELECT item FROM CartItem item WHERE item.cart.id = :id";
                    List<CartItem> result = em.createQuery(sql, CartItem.class).setParameter("id", cartId).getResultList();
                    trans.commit();
                    return result;
            } catch (Exception ex) {
                    trans.rollback();
                    throw ex;
            }
    }

        @Override
        public void insert(CartItem cartItem) {
            EntityManager em = JPAConfig.getEntityManager();
            EntityTransaction trans = em.getTransaction();
            try {
                    trans.begin();
                    em.persist(cartItem);
                    trans.commit();
            }
            catch (Exception ex) {
                trans.rollback();
                throw ex;
            }
        }

        @Override
        public void update(CartItem cartItem) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(cartItem);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void deleteById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        CartItem cartItem = em.find(CartItem.class, id);
                        em.remove(cartItem);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public CartItem findByProductId(int productId) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String sql = "SELECT item FROM CartItem item WHERE item.product.id = :id";
                        CartItem result = em.createQuery(sql, CartItem.class).setParameter("id", productId).getSingleResult();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }
}
