package com.zalizniak.sort;

import java.util.Arrays;

public class MineAttemptSort {

    public static Integer[] referenceImpl(Integer[] in) {
        Arrays.sort(in);
        return in;
    }

    /**
     * In Bubble Sort, n-1 comparisons will be done in the 1st pass, n-2 in 2nd pass, n-3 in 3rd pass and so on.
     * So the total number of comparisons will be:
     *
     * (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1
     * Sum = n(n-1)/2
     * i.e O(n2)
     */
    public static Integer[] bubbleSort(Integer[] in) {
        for (int j = 0; j < in.length - 1; j++) {
            for (int i = 0; i < (in.length - j - 1); i++) {
                if (in[i] > in[i + 1]) {
                    Integer tmp = in[i];
                    in[i] = in[i + 1];
                    in[i + 1] = tmp;
                }
            }
        }

        return in;
    }
}
