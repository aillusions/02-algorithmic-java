package com.zalizniak.medium.maximum_subset_from_non_adjacent_elements;

public class DynamicProgramming implements MaxNonAdjacentElementsSubset {

    int maxLen = 10;
    int dp[] = new int[maxLen];
    boolean v[] = new boolean[maxLen];

    @Override
    public int getMaxSum(Integer[] in) {
        maxLen = 10;
        dp = new int[maxLen];
        v = new boolean[maxLen];
        return maxSum(in, 0, in.length);
    }

    int maxSum(Integer[] arr, int i, int n) {
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
        dp[i] = Math.max(maxSum(arr, i + 1, n), arr[i] + maxSum(arr, i + 2, n));

        // Returning the value
        return dp[i];
    }
}
