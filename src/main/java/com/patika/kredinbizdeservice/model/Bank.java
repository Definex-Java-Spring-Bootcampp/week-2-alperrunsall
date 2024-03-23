package com.patika.kredinbizdeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards = new ArrayList<>();

    public Bank(String name, List<Loan> loanList, List<CreditCard> creditCards) {
        this.name = name;
        this.loanList = loanList;
        this.creditCards = creditCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", loanList=" + loanList +
                '}';
    }
}
