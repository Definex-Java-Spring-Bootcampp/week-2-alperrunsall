package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Loan;

import java.util.List;

public interface ILoanService {
    Loan save(Loan loan);

    //Campaign getByName(String name);
    List<Loan> getAllLoans();

    void delete(Loan loan);
}
