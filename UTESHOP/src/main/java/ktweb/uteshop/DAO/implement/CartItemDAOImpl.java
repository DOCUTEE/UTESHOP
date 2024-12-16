package ktweb.uteshop.DAO.implement;

import jakarta.persistence.Entity;
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
                        String jsql = "DELETE FROM CartItem item WHERE item.id = :id";
                        em.createQuery(jsql).setParameter("id", id).executeUpdate();
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

    @Override
    public CartItem findByProductIdAndCartId(int productId, int cartId) {
        EntityManager em = JPAConfig.getEntityManager();
        CartItem result = null;

        try {
            em.getTransaction().begin();
            String sql = "SELECT item FROM CartItem item WHERE item.product.productId = :productId AND item.cart.cartId = :cartId";
            result = em.createQuery(sql, CartItem.class)
                    .setParameter("productId", productId)
                    .setParameter("cartId", cartId)
                    .getSingleResult();
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace(); // Log the exception
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return result;
    }



}
