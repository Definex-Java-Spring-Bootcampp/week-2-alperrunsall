package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.CreditCard;

import java.util.List;

public interface ICreditCardService {

    CreditCard save(CreditCard creditCard);

    //Campaign getByName(String name);
    List<CreditCard> getAllCards();

    void delete(CreditCard creditCard);

}
