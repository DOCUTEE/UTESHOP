package ktweb.uteshop.DAO.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ktweb.uteshop.DAO.interfaces.IMarketingCampaignDAO;
import ktweb.uteshop.configs.JPAConfig;
import ktweb.uteshop.entity.MarketingCampaign;

import java.util.List;

public class IMarketingCampaignDAOImpl implements IMarketingCampaignDAO {
        @Override
        public List<MarketingCampaign> findAll() {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT mc FROM MarketingCampaign mc";
                        List<MarketingCampaign> result = em.createQuery(jsql, MarketingCampaign.class).getResultList();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public MarketingCampaign findById(int id) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        String jsql = "SELECT mc FROM MarketingCampaign mc where mc.id = :id";
                        MarketingCampaign result = em.createQuery(jsql, MarketingCampaign.class).getSingleResult();
                        trans.commit();
                        return result;
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void insert(MarketingCampaign marketingCampaign) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(marketingCampaign);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }

        @Override
        public void update(MarketingCampaign marketingCampaign) {
                EntityManager em = JPAConfig.getEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.merge(marketingCampaign);
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
                        MarketingCampaign marketingCampaign = em.find(MarketingCampaign.class, id);
                        em.remove(marketingCampaign);
                        trans.commit();
                }
                catch (Exception ex) {
                        trans.rollback();
                        throw ex;
                }
        }
}
