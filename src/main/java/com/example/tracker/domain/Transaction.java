package com.example.tracker.domain;

import com.example.tracker.util.CurrencyValidator;

/**
 * This class is intended to be immutable.
 */
public final class Transaction {
    private static final String CCY_AMOUNT_SEPARATOR = " ";

    public final String currency;
    public final int amount;

    public Transaction(String currency, int amount) {
//        this.currency = Currency.getInstance(currency).getCurrencyCode();
        this.currency = CurrencyValidator.validate(currency);
        this.amount = amount;
    }

    public static Transaction parse(String input) {
        String[] parts = input.split(CCY_AMOUNT_SEPARATOR);
        return new Transaction(parts[0], Integer.parseInt(parts[1]));
    }
}
