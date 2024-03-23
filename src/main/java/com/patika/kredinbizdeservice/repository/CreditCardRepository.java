package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.ICampaignService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CreditCardRepository {

    @Autowired
    private ICampaignService campaignService;
    private final List<CreditCard> creditCardList = new ArrayList<>();

    public void save(CreditCard creditCard) {
        creditCardList.add(creditCard);
    }

    public List<CreditCard> getAll() {
        return creditCardList;
    }


    @PostConstruct
    private void createRandomCreditCards() {
        List<Campaign> campaignList = campaignService.getAllCampaigns();
        CreditCard creditCard1 = new CreditCard(BigDecimal.valueOf(159L), List.of(campaignList.getFirst()));
        CreditCard creditCard2 = new CreditCard(BigDecimal.valueOf(99L), List.of(campaignList.get(0), campaignList.get(2)));
        CreditCard creditCard3 = new CreditCard(BigDecimal.valueOf(0L), List.of(campaignList.get(0), campaignList.get(1), campaignList.get(2)));

        creditCardList.add(creditCard1);
        creditCardList.add(creditCard2);
        creditCardList.add(creditCard3);
    }
}
