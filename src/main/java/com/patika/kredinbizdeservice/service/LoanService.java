package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.getAll();
    }

    @Override
    public void delete(Loan loan) {

    }
}
