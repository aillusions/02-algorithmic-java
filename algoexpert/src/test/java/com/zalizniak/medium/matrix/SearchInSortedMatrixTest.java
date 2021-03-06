package com.zalizniak.medium.matrix;


import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

public class SearchInSortedMatrixTest {

    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    int[][] largeMatrix = new int[1_000][100_000];


    @Test
    public void shouldSearchBruteForce() {


        MatrixPrinter.print(matrix);

        MatcherAssert.assertThat(SearchInSortedMatrix.searchBruteForce(matrix, 6), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{1, 2}));
        MatcherAssert.assertThat(SearchInSortedMatrix.searchBruteForce(matrix, 1), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{0, 0}));
        MatcherAssert.assertThat(SearchInSortedMatrix.searchBruteForce(matrix, 9), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{2, 2}));
    }

    @Test
    public void shouldSearchBinary() {

        MatrixPrinter.print(matrix);

        MatcherAssert.assertThat(SearchInSortedMatrix.searchBinary(matrix, 6), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{1, 2}));
        MatcherAssert.assertThat(SearchInSortedMatrix.searchBinary(matrix, 1), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{0, 0}));
        MatcherAssert.assertThat(SearchInSortedMatrix.searchBinary(matrix, 9), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{2, 2}));
    }

    @Test
    public void shouldSearchBruteForcePerf() {
        SearchInSortedMatrix.searchBruteForce(largeMatrix, 999);
    }

    @Test
    public void shouldSearchBinaryPerf() {
        SearchInSortedMatrix.searchBinary(largeMatrix, 999);
    }
}
