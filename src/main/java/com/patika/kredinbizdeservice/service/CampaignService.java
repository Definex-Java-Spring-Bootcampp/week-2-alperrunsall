package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService implements ICampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Campaign save(Campaign campaign) {
        campaignRepository.save(campaign);
        return campaign;
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.getAll();
    }

    @Override
    public void delete(Campaign campaign) {

    }
}
