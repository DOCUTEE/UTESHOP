package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.MarketingCampaign;

import java.util.List;

public interface IMarketingCampaignService {
        public List<MarketingCampaign> findAll();
        public MarketingCampaign findById(int id);
        public void insert(MarketingCampaign marketingCampaign);
        public void update(MarketingCampaign marketingCampaign);
        public void deleteById(int id);
}
