package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/banks")
public class BankController {
    private final IBankService bankService;

    @Autowired
    public BankController(IBankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<Bank> getAllBank() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{name}")
    public Bank getBankByName(@PathVariable String name) {
        return bankService.getByName(name);
    }

    @GetMapping("/{name}/creditCards")
    public List<CreditCard> getCreditCardsByBankName(@PathVariable String name) {
        return bankService.getByName(name).getCreditCards();
    }


}
