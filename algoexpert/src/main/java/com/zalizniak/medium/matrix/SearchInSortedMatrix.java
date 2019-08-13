package com.zalizniak.medium.matrix;

import java.util.Arrays;

public class SearchInSortedMatrix {

    public static Integer[] search(int[][] matrix, int search) {

        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix[0].length; w++) {
                if (matrix[h][w] == search) {
                    Integer[] rv = new Integer[]{h, w};
                    System.out.println("Found: " + search + " at " + Arrays.toString(rv));
                    return rv;
                }
            }
        }

        return null;
    }
}
