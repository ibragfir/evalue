package com.example.tracker.domain;

import com.example.tracker.util.CurrencyValidator;

public class Balance {
    private String currency;
    private long balance;

    public Balance(String currency) {
        this(currency, 0L);
    }

    public Balance(String currency, long startingBalance) {
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

    public Balance addAmount(long amount) {
        balance += amount;
        return this;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Balance && currency.equals(((Balance) other).currency);
    }

    @Override
    public int hashCode() {
        return currency.hashCode();
    }
}
