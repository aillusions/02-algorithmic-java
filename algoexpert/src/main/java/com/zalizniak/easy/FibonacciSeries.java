package com.zalizniak.easy;

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */
public class FibonacciSeries {


    /**
     * RECURSIVE
     *
     * Slow of stack-overflow prone
     * O(2^n) - time complexity - exponential
     * O(n) - space complexity
     */
    public static int getNthFibRec(int n) {

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return getNthFibRec(n - 1) + getNthFibRec(n - 2);
    }

    /**
     *  ITERATIVE
     */
    public static int getNthFibIt(int n) {

        int n_2 = 0;
        int n_1 = 0;
        int n_0 = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                n_2 = 0;
                n_1 = 0;
                n_0 = 0;
            } else if (i == 2) {
                n_2 = 0;
                n_1 = 1;
                n_0 = 1;
            } else {
                n_0 = n_2 + n_1;
                n_2 = n_1;
                n_1 = n_0;
            }
        }

        return n_0;
    }


}
