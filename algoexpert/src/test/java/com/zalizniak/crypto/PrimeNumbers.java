package com.zalizniak.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
     * <p>
     * Found 48155 prime numbers per 1000000 integers: 1000000000 - 1001000000
     * Found 48262 prime numbers per 1000000 integers: 1001000000 - 1002000000
     * Found 48198 prime numbers per 1000000 integers: 1002000000 - 1003000000
     * Found 48263 prime numbers per 1000000 integers: 1003000000 - 1004000000
     */
    @Test
    public void loopPrimes() {

        final int terminator = 1_000_000;

        int counter = 0;
        for (long i = 10_000_000_000L; i < Long.MAX_VALUE; i++) {
            if (isPrime(i)) {
                counter++;
            }

            if (i % terminator == 0) {
                System.out.println("Found " + counter + " prime numbers per " + terminator + " integers: " + (i - terminator) + " - " + i);
                counter = 0;
            }
        }
    }

    @Test
    public void testPrimeFactors() {
        System.out.println(primeFactors(44));
        System.out.println(primeFactors(3));
        System.out.println(primeFactors(32));
    }

    // 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95
    @Test
    public void testSemiprime() {
        System.out.println(26 + " -> " + primeFactors(26));
        System.out.println(57 + " -> " + primeFactors(57));
        System.out.println(86 + " -> " + primeFactors(86));
        System.out.println(95 + " -> " + primeFactors(95));
        System.out.println(116393 + " -> " + primeFactors(116393));
        System.out.println(3789829 + " -> " + primeFactors(3789829));
        System.out.println(7388399 + " -> " + primeFactors(7388399));
        System.out.println(392524199 + " -> " + primeFactors(392524199));
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

    public static List<Integer> primeFactors(long number) {
        long n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}
