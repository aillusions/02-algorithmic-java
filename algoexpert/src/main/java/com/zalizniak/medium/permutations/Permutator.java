package com.zalizniak.medium.permutations;

/**
 * The number of possible permutations grows factorially
 * By the time you have 10 elements, there are more than 3.5 million permutations
 * With factorial algorithms - computer is unable to compute more than the first dozen or so cases in any reasonable amount of time.
 */
public class Permutator {

    public static int[][] permutate(int[] in) {
        int size = in.length;
        int permutationsNumber = factorialUsingForLoop(size);
        int[][] rv = new int[permutationsNumber][size];
        return rv;
    }

    public static int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }
}
