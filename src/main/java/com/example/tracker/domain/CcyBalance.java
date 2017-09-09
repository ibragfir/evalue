package com.example.tracker.domain;

import com.example.tracker.util.CurrencyValidator;

public class CcyBalance {
    private String currency;
    private long balance;

    public CcyBalance(String currency) {
        this(currency, 0L);
    }

    public CcyBalance(String currency, long startingBalance) {
        this.currency = CurrencyValidator.validate(currency);
        this.balance = startingBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public CcyBalance addAmount(long amount) {
        balance += amount;
        return this;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof CcyBalance && currency.equals(((CcyBalance) other).currency);
    }

    @Override
    public int hashCode() {
        return currency.hashCode();
    }
}
