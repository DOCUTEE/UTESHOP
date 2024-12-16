package ktweb.uteshop.DAO.interfaces;

import ktweb.uteshop.entity.MarketingCampaign;

import java.util.List;
import java.util.Map;

public interface IMarketingCampaignDAO {
        public List<MarketingCampaign> findAll();
        public MarketingCampaign findById(int id);
        public void insert(MarketingCampaign marketingCampaign);
        public void update(MarketingCampaign marketingCampaign);
        public void deleteById(int id);
}
