package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService implements ICreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
        return creditCard;
    }

    @Override
    public List<CreditCard> getAllCards() {
        return creditCardRepository.getAll();
    }

    @Override
    public void delete(CreditCard creditCard) {

    }
}
