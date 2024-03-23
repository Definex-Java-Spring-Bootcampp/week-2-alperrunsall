package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/campaigns")
public class CampaignController {

    private final ICampaignService campaignService;

    @Autowired
    public CampaignController(ICampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.getAllCampaigns();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Campaign create(@RequestBody Campaign campaign) {
        return campaignService.save(campaign);
    }
}
