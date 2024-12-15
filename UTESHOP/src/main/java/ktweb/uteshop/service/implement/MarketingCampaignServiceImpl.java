package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.MarketingCampaignDAOImpl;
import ktweb.uteshop.DAO.interfaces.IMarketingCampaignDAO;
import ktweb.uteshop.entity.MarketingCampaign;
import ktweb.uteshop.service.interfaces.IMarketingCampaignService;

import java.util.List;

public class MarketingCampaignServiceImpl implements IMarketingCampaignService {
        IMarketingCampaignDAO marketingCampaignDAO = new MarketingCampaignDAOImpl();
        @Override
        public List<MarketingCampaign> findAll() {
                return marketingCampaignDAO.findAll();
        }

        @Override
        public MarketingCampaign findById(int id) {
               return marketingCampaignDAO.findById(id);
        }

        @Override
        public void insert(MarketingCampaign marketingCampaign) {
                marketingCampaignDAO.insert(marketingCampaign);
        }

        @Override
        public void update(MarketingCampaign marketingCampaign) {
                marketingCampaignDAO.update(marketingCampaign);
        }

        @Override
        public void deleteById(int id) {
                marketingCampaignDAO.deleteById(id);
        }
}
