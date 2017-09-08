package com.example.tracker.domain;

import com.example.tracker.util.InvalidCurrencyException;
import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
    /**
     * It's assumed that the input is always correct and the implementation
     * doesn't contain any validation logic. Otherwise, here would have been more tests.
     */

    @Test
    public void parseTransaction() {
        String input = "USD 100";
        Transaction transaction = Transaction.parse(input);
        Assert.assertEquals("USD", transaction.currency);
        Assert.assertEquals(100, transaction.amount);
    }

    @Test(expected = InvalidCurrencyException.class)
    public void invalidCreation() {
        new Transaction("a", 100);
    }
}
