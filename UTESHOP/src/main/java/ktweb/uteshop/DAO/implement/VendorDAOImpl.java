package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import ktweb.uteshop.DAO.interfaces.IVendorDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Vendor;
import java.util.List;


public class VendorDAOImpl implements IVendorDAO {

    @Override
    public void insert(Vendor vendor) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Vendor vendor) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(vendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int vendorId) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.find(Vendor.class, vendorId);
        if (vendor != null) {
            entityManager.remove(vendor);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Vendor findById(int vendorId) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        Vendor vendor = entityManager.find(Vendor.class, vendorId);
        entityManager.close();
        return vendor;
    }

    @Override
    public Vendor findByName(String vendorName) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        Vendor vendor = entityManager.find(Vendor.class, vendorName);
        entityManager.close();
        return vendor;
    }

    @Override
    public List<Vendor> findAll() {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Vendor> vendors = entityManager.createQuery("SELECT v FROM Vendor v", Vendor.class).getResultList();
        entityManager.close();
        return vendors;
    }

    @Override
    public List<Vendor> findByKeyword(String keyword) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Vendor> vendors = entityManager.createQuery("SELECT v FROM Vendor v WHERE v.name LIKE :keyword", Vendor.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
        entityManager.close();
        return vendors;
    }

    @Override
    public List<Vendor> findByPage(int page, int pageSize) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Vendor> vendors = entityManager.createQuery("SELECT v FROM Vendor v", Vendor.class)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        entityManager.close();
        return vendors;
    }

    @Override
    public List<Vendor> findByKeywordAndPage(String keyword, int page, int pageSize) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Vendor> vendors = entityManager.createQuery("SELECT v FROM Vendor v WHERE v.name LIKE :keyword", Vendor.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        entityManager.close();
        return vendors;
    }

    @Override
    public Vendor findByEmail(String email) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        Vendor vendor = entityManager.createQuery("SELECT v FROM Vendor v WHERE v.email = :email", Vendor.class)
                .setParameter("email", email)
                .getSingleResult();
        entityManager.close();
        return vendor;
    }
    public static void main(String[] args) {

    }
}
