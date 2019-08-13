package com.zalizniak.medium.matrix;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int[][] rv = new int[matrix[0].length][matrix.length];

        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix[0].length; w++) {
                rv[w][h] = matrix[h][w];
            }
        }

        return rv;
    }

}
