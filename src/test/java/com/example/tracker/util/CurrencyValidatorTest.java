package com.example.tracker.util;

import org.junit.Assert;
import org.junit.Test;

public class CurrencyValidatorTest {

    @Test(expected = InvalidCurrencyException.class)
    public void nullCurrency() {
        CurrencyValidator.validate(null);
    }

    @Test(expected = InvalidCurrencyException.class)
    public void lowerCasedCurrency() {
        CurrencyValidator.validate("aaa");
    }

    @Test(expected = InvalidCurrencyException.class)
    public void numericCurrency() {
        CurrencyValidator.validate("AA1");
    }

    @Test(expected = InvalidCurrencyException.class)
    public void invalidCurrency() {
        CurrencyValidator.validate("A");
    }

    @Test
    public void validCurrency() {
        String ccy = "TJS";
        Assert.assertEquals(ccy, CurrencyValidator.validate(ccy));
    }
}
