package com.zalizniak.medium;

/**
 * Given an array of positive numbers,
 * find the maximum sum of a subsequence
 * with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * <p>
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */
public class MaximumSubsetFromNonAdjacentElements {

    public static int getSumMostEfficientWay(Integer[] in) {

        int incl = 0;
        int excl = 0;

        for (int i = 0; i < in.length; i++) {
            int prevIncl = incl;
            incl = excl + in[i];
            excl = Math.max(prevIncl, excl);
        }

        return Math.max(incl, excl);
    }
}
