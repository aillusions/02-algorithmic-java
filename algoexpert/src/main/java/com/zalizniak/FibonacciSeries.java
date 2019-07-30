package com.zalizniak;

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */
public class FibonacciSeries {


    /**
     * Slow of stack-overflow prone
     * O(2^n) - time complexity
     * O(n) - space complexity
     */
    public static int getNthFib(int n) {

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public static int getNthFib2(int n) {

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
