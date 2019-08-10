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

    static int maxLen = 10;
    static int dp[] = new int[maxLen];
    static boolean v[] = new boolean[maxLen];

    static int maxSum(Integer[] arr, int i, int n) {
        // Base case
        if (i >= n) {
            return 0;
        }

        // To check if a state has
        // been solved
        if (v[i]) {
            return dp[i];
        }

        v[i] = true;

        // Required recurrence relation
        dp[i] = Math.max(maxSum(arr, i + 1, n),
                arr[i] + maxSum(arr, i + 2, n));

        // Returning the value
        return dp[i];
    }

    public static int getSumDynamicProgramming(Integer[] in) {
        maxLen = 10;
        dp = new int[maxLen];
        v = new boolean[maxLen];
        return maxSum(in, 0, in.length);
    }
}
