package com.zalizniak.medium.matrix;

import org.junit.Test;

public class TransposeMatrixTest {

    @Test
    public void test0() {
        int[][] matrix = {
                {5},
                {8}
        };

        MatrixPrinter.print(matrix);

        matrix = TransposeMatrix.transpose(matrix);

        MatrixPrinter.print(matrix);
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MatrixPrinter.print(matrix);

        matrix = TransposeMatrix.transpose(matrix);

        MatrixPrinter.print(matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        MatrixPrinter.print(matrix);

        matrix = TransposeMatrix.transpose(matrix);

        MatrixPrinter.print(matrix);
    }
}
