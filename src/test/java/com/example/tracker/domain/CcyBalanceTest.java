package com.example.tracker.domain;

import com.example.tracker.util.InvalidCurrencyException;
import org.junit.Assert;
import org.junit.Test;

public class CcyBalanceTest {

    @Test
    public void balanceCreation() {
        CcyBalance balance = new CcyBalance("USD");
        Assert.assertEquals(balance.getCurrency(), "USD");
        Assert.assertEquals(balance.getBalance(), 0);

        balance = new CcyBalance("CZK", 100);
        Assert.assertEquals(balance.getCurrency(), "CZK");
        Assert.assertEquals(balance.getBalance(), 100);
    }

    @Test(expected = InvalidCurrencyException.class)
    public void invalidBalanceCreation() {
        new CcyBalance("aa");
    }

    @Test
    public void addAmountTest() {
        CcyBalance balance = new CcyBalance("USD", 0L);
        balance.addAmount(100);
        Assert.assertEquals(100, balance.getBalance());
    }
}
