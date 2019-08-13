package com.zalizniak.medium.matrix;

public class MatrixPrinter {

    public static void print(int[][] matrix) {
        for (int h = 0; h < matrix.length; h++) {
            for (int w = 0; w < matrix[0].length; w++) {
                // System.out.print(matrix[h][w] + " ");
                System.out.printf("%4d", matrix[h][w]);
            }
            System.out.println();
        }

    }
}
