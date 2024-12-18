package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ktweb.uteshop.DAO.interfaces.IAdministratorDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.Administrator;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AdministratorDAOImpl implements IAdministratorDAO {
        @PersistenceContext


        @Override
        @SuppressWarnings("unchecked")
        public List<Administrator> findAll() {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String sql = "SELECT admin FROM Administrator admin";
                        List<Administrator> result = em.createQuery(sql, Administrator.class).getResultList();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public Administrator findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        Administrator administrator = em.find(Administrator.class, id);
                        trans.commit();
                        return administrator;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        @Transactional
        public void insert(Administrator administrator) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(administrator);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        @Transactional
        public void update(Administrator administrator) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(administrator);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        @Transactional
        public void deleteById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        Administrator administrator = em.find(Administrator.class, id);
                        if (administrator != null) {
                                administrator.setIsDelete(true);
                                em.merge(administrator);
                        }
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public Administrator getAdministrator(String email) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String sql = "SELECT admin FROM Administrator admin WHERE admin.email = :email";
                        Administrator administrator = em.createQuery(sql, Administrator.class).setParameter("email", email).getSingleResult();
                        trans.commit();
                        return administrator;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }
        @Override
        public Administrator findByEmail(String email) {
                //findAdminByEmail
                EntityManager em = JPAConfig.getEntityManager();
                em.getTransaction().begin();
                Administrator admin = em.createQuery("SELECT a FROM Administrator a WHERE a.email = :email", Administrator.class)
                        .setParameter("email", email)
                        .getSingleResult();
                em.getTransaction().commit();
                em.close();
                return admin;
        }
}
