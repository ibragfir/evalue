package com.example.tracker.domain;

import com.example.tracker.util.InvalidCurrencyException;
import org.junit.Assert;
import org.junit.Test;

public class BalanceTest {

    @Test
    public void balanceCreation() {
        Balance balance = new Balance("USD");
        Assert.assertEquals(balance.getCurrency(), "USD");
        Assert.assertEquals(balance.getBalance(), 0);

        balance = new Balance("CZK", 100);
        Assert.assertEquals(balance.getCurrency(), "CZK");
        Assert.assertEquals(balance.getBalance(), 100);
    }

    @Test(expected = InvalidCurrencyException.class)
    public void invalidBalanceCreation() {
        new Balance("aa");
    }

    @Test
    public void addAmountTest() {
        Balance balance = new Balance("USD", 0L);
        balance.addAmount(100);
        Assert.assertEquals(100, balance.getBalance());
    }
}
