package com.zalizniak.medium.matrix;

import java.util.Arrays;

public class SearchInSortedMatrix {

    /**
     * Time Complexity:- O(rows * cols)
     * Space Complexity:- O(1)
     */
    public static Integer[] searchBruteForce(int[][] matrix, int search) {

        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix[0].length; w++) {
                if (matrix[h][w] == search) {
                    Integer[] rv = new Integer[]{h, w};
                    //System.out.println("Found: " + search + " at " + Arrays.toString(rv));
                    return rv;
                }
            }
        }

        return null;
    }

    public static Integer[] searchBinary(int[][] matrix, int search) {

        for (int h = 0; h < matrix.length; h++) {
            int[] row = matrix[h];
            int binarySearchResult = binarySearch(row, search);
            if (binarySearchResult >= 0) {
                return new Integer[]{h, binarySearchResult};
            }
        }

        return null;
    }

    static int binarySearch(int[] row, int elem) {

        int maxIdx = row.length - 1;

        int startIdx = 0;
        int endIdx = maxIdx;

        int safelyIterator = 0;

        while (startIdx <= endIdx) {

            int middleIdx = (endIdx + startIdx) / 2;

            // System.out.println("Checking: " + startIdx + " to " + endIdx + " with mid idx: " + middleIdx);

            if (safelyIterator > maxIdx) {
                throw new RuntimeException("Too many iterations: " + safelyIterator);
            }

            safelyIterator++;

            int middleValue = row[middleIdx];

            if (elem == middleValue) {
                return middleIdx;
            } else if (elem < middleValue) {
                endIdx = middleIdx - 1;
            } else {
                startIdx = middleIdx + 1;
            }
        }

        return -1;
    }
}
