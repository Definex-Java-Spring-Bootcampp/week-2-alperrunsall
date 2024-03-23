package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/credit-cards")
public class CreditCardController {
    private final ICreditCardService creditCardService;

    @Autowired
    public CreditCardController(ICreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @GetMapping
    public List<CreditCard> getAll() {
        return creditCardService.getAllCards();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard create(@RequestBody CreditCard creditCard) {
        return creditCardService.save(creditCard);
    }
}
