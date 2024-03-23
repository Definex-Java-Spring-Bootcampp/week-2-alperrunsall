package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.HouseLoan;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.VehicleLoan;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository {
    private final List<Loan> loanList = new ArrayList<>();

    public Loan save(Loan loan) {
        loanList.add(loan);
        return loan;
    }

    public List<Loan> getAll() {
        return loanList;
    }

    @PostConstruct
    private void createRandomLoans() {

        Loan loan1 = new VehicleLoan(new BigDecimal("50000"), 60, 0.5);
        Loan loan2 = new VehicleLoan(new BigDecimal("70000"), 48, 0.7);
        Loan loan3 = new VehicleLoan(new BigDecimal("100000"), 72, 0.8);
        Loan loan4 = new HouseLoan(new BigDecimal("250000"), 72, 0.7);
        Loan loan5 = new HouseLoan(new BigDecimal("100000"), 36, 0.4);
        Loan loan6 = new HouseLoan(new BigDecimal("200000"), 48, 0.5);
        Loan loan7 = new ConsumerLoan(new BigDecimal("20000"), 12, 0.6);
        Loan loan8 = new ConsumerLoan(new BigDecimal("10000"), 6, 0.3);
        Loan loan9 = new ConsumerLoan(new BigDecimal("5000"), 3, 0.2);

        loanList.add(loan1);
        loanList.add(loan2);
        loanList.add(loan3);
        loanList.add(loan4);
        loanList.add(loan5);
        loanList.add(loan6);
        loanList.add(loan7);
        loanList.add(loan8);
        loanList.add(loan9);
    }
}
