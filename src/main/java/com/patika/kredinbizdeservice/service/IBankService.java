package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;

import java.util.List;

public interface IBankService {

    Bank save(Bank bank);

    Bank getByName(String name);

    List<Bank> getAllBanks();

    List<CreditCard> getCreditCards(Bank bank);

    List<Campaign> getCampaignByCreditCard();


    void delete(Bank bank);

}
