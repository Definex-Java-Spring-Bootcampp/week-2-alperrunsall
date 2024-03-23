package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;

import java.util.List;

public interface ICampaignService {
    Campaign save(Campaign campaign);

    //Campaign getByName(String name);
    List<Campaign> getAllCampaigns();

    void delete(Campaign campaign);
}
