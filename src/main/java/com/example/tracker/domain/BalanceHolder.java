package com.example.tracker.domain;

import com.example.tracker.util.CurrencyValidator;

public class BalanceHolder {
    private String currency;
    private long balance;

    public BalanceHolder(String currency) {
        this(currency, 0L);
    }

    public BalanceHolder(String currency, long startingBalance) {
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

    public BalanceHolder addAmount(long amount) {
        balance += amount;
        return this;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof BalanceHolder && currency.equals(((BalanceHolder) other).currency);
    }

    @Override
    public int hashCode() {
        return currency.hashCode();
    }
}
