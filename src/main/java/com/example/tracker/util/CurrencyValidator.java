package com.example.tracker.util;

import java.util.stream.IntStream;

public class CurrencyValidator {

    /**
     * The only valid currency is 3 upper-cased letters (any letter, even if the currency doesn't exist in a real world)
     *
     * @param currency to validate
     * @return the currency if it's valid
     * @throws InvalidCurrencyException if the currency is not valid
     */
    public static String validate(String currency) {
        if (currency == null || currency.length() != 3) {
            throw new InvalidCurrencyException("Not a valid currency: " + currency);
        }

        IntStream.range(0, 3).forEach(i -> {
            char c = currency.charAt(i);
            if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                throw new InvalidCurrencyException("Currency must be 3 upper-cased letters: " + currency);
            }
        });

        return currency;
    }

}
