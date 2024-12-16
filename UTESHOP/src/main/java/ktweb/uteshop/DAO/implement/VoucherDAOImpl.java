package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IVoucherDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Voucher;

import java.util.List;

public class VoucherDAOImpl implements IVoucherDAO {
    @Override
    public void insert(Voucher voucher) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(voucher);
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public void update(Voucher voucher) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        em.merge(voucher);
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public void delete(int voucherId) {
        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();
        Voucher voucher = em.find(Voucher.class, voucherId);
        if (voucher != null) {
            em.remove(voucher);
        }
        em.getTransaction().commit();
        em.close();
    }
    @Override
    public Voucher findById(int voucherId) {
        EntityManager em = JPAConfig.getEntityManager();
        Voucher voucher = em.find(Voucher.class, voucherId);
        em.close();
        return voucher;
    }
    @Override
    public Voucher findByCode(String code) {
        EntityManager em = JPAConfig.getEntityManager();
        Voucher voucher = null;
        try {
            voucher = em.createQuery("SELECT v FROM Voucher v WHERE v.code = :code", Voucher.class)
                    .setParameter("code", code)
                    .getSingleResult();
            em.close();
        }
        catch (Exception e) {
            voucher = null;
        }
        return voucher;
    }

    @Override
    public List<Voucher> findAll() {
        //find all vouchers expired end date > now
        EntityManager em = JPAConfig.getEntityManager();
        List<Voucher> vouchers = em.createQuery("SELECT v FROM Voucher v WHERE v.dateEnd > CURRENT_DATE", Voucher.class)
                .getResultList();
        em.close();
        return vouchers;
    }

    @Override
    public List<Voucher> findByKeyword(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        List<Voucher> vouchers = em.createQuery("SELECT v FROM Voucher v WHERE v.code LIKE :keyword", Voucher.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
        em.close();
        return vouchers;
    }

    @Override
    public List<Voucher> findByPage(int page, int pageSize){
        EntityManager em = JPAConfig.getEntityManager();
        List<Voucher> vouchers = em.createQuery("SELECT v FROM Voucher v", Voucher.class)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        em.close();
        return vouchers;
    }
    public static void main(String[] args) {
        VoucherDAOImpl voucherDAO = new VoucherDAOImpl();
        //find all vouchers by page
        List<Voucher> vouchers = voucherDAO.findByPage(1, 5);
        for (Voucher voucher : vouchers) {
            System.out.println(voucher.getCode());
        }

    }
}
