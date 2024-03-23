package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.service.ICreditCardService;
import com.patika.kredinbizdeservice.service.ILoanService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class BankRepository {
    private final List<Bank> bankList = new ArrayList<>();
    @Autowired
    private ICreditCardService creditCardService;
    @Autowired
    private ILoanService loanService;

    @PostConstruct
    private void createRandomBanks() {
        List<CreditCard> creditCards = creditCardService.getAllCards();
        List<Loan> loans = loanService.getAllLoans();

        Bank bank1 = new Bank("banka1", List.of(loans.get(0), loans.get(3), loans.get(7), loans.get(8)), List.of(creditCards.get(0)));
        Bank bank2 = new Bank("banka2", List.of(loans.get(1), loans.get(2)), List.of(creditCards.get(1)));
        Bank bank3 = new Bank("banka3", List.of(loans.get(4), loans.get(5), loans.get(1), loans.get(6)), List.of(creditCards.get(2)));

        bankList.add(bank1);
        bankList.add(bank2);
        bankList.add(bank3);
    }

    public void save(Bank bank) {
        bankList.add(bank);
    }

    public List<Bank> getAll() {
        return bankList;
    }

    public List<CreditCard> getBankCreditCards(Bank bank) {
        return bank.getCreditCards();
    }

    public Optional<Bank> findByName(String name) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(name))
                .findFirst();
    }

    private Optional<Bank> getRandom() {
        return bankList.stream()
                .skip(new Random().nextInt(bankList.size()))
                .findFirst();
    }

    public void delete(Bank bank) {
        bankList.remove(bank);
    }
}
