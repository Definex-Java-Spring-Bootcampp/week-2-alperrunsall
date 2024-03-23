package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService implements IBankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank save(Bank bank) {
        bankRepository.save(bank);
        return null;
    }

    @Override
    public Bank getByName(String name) {
        Optional<Bank> foundBank = bankRepository.findByName(name);

        Bank bank = null;

        if (foundBank.isPresent()) {
            bank = foundBank.get();
        }

        return bank;
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.getAll();
    }


    @Override
    public List<CreditCard> getCreditCards(Bank bank) {
        return bankRepository.getBankCreditCards(bank);
    }

    @Override
    public List<Campaign> getCampaignByCreditCard() {
        return null;
    }

    @Override
    public void delete(Bank bank) {

    }
}
