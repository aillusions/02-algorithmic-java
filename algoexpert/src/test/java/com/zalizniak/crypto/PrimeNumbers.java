package com.zalizniak.crypto;

import org.junit.Assert;
import org.junit.Test;

public class PrimeNumbers {

    @Test
    public void testPrime() {
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

    /**
     * Found 78498 prime numbers per 1000000 integers: 0 -  1000000
     * Found 70435 prime numbers per 1000000 integers: 1000000 -  2000000
     * Found 67883 prime numbers per 1000000 integers: 2000000 -  3000000
     * Found 66330 prime numbers per 1000000 integers: 3000000 -  4000000
     * Found 65367 prime numbers per 1000000 integers: 4000000 -  5000000
     * Found 64336 prime numbers per 1000000 integers: 5000000 -  6000000
     * Found 63799 prime numbers per 1000000 integers: 6000000 -  7000000
     * Found 63129 prime numbers per 1000000 integers: 7000000 -  8000000
     * Found 62712 prime numbers per 1000000 integers: 8000000 -  9000000
     * Found 62090 prime numbers per 1000000 integers: 9000000 -  10000000
     * Found 61938 prime numbers per 1000000 integers: 10000000 -  11000000
     * Found 61543 prime numbers per 1000000 integers: 11000000 -  12000000
     * Found 61192 prime numbers per 1000000 integers: 12000000 -  13000000
     * Found 60825 prime numbers per 1000000 integers: 13000000 -  14000000
     * Found 60627 prime numbers per 1000000 integers: 14000000 -  15000000
     * Found 60426 prime numbers per 1000000 integers: 15000000 -  16000000
     * Found 60184 prime numbers per 1000000 integers: 16000000 -  17000000
     */
    @Test
    public void loopPrimes() {

        final int terminator = 1_000_000;

        int counter = 0;
        for (long i = 2; i < Long.MAX_VALUE; i++) {
            if (isPrime(i)) {
                counter++;
            }

            if (i % terminator == 0) {
                System.out.println("Found " + counter + " prime numbers per " + terminator + " integers: " + (i - terminator) + " - " + i);
                counter = 0;
            }
        }
    }

    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    public boolean isPrime(long n) {

        if (n == 2) return true;
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
