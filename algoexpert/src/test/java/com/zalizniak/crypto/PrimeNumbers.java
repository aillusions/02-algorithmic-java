package com.zalizniak.crypto;

import org.junit.Assert;
import org.junit.Test;

public class PrimeNumbers {


    @Test
    public void testPrim() {
        Assert.assertTrue(isPrime(2));
        Assert.assertTrue(isPrime(3));
        Assert.assertTrue(isPrime(7));
        Assert.assertTrue(isPrime(11));
        Assert.assertTrue(isPrime(19));
        Assert.assertTrue(isPrime(29));

        Assert.assertFalse(isPrime(4));
        Assert.assertFalse(isPrime(6));
        Assert.assertFalse(isPrime(14));
        Assert.assertFalse(isPrime(15));
        Assert.assertFalse(isPrime(16));
    }

    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    public boolean isPrime(int in) {
        for (int i = 2; i < in; i++) {
            if (in % i == 0) {
                return false;
            }
        }

        return true;
    }
}
