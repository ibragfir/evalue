package com.example.tracker.util;

import java.util.stream.IntStream;

public class CurrencyValidator {

    public static String validate(String currency) {
        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException("Not a valid currency: " + currency);
        }

        IntStream.range(0, 3).forEach(i -> {
            char c = currency.charAt(i);
            if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                throw new IllegalArgumentException("Currency must be 3 upper-cased letters: " + currency);
            }
        });

        return currency;
    }

}
