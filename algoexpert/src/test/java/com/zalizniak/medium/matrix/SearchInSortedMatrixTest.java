package com.zalizniak.medium.matrix;


import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

public class SearchInSortedMatrixTest {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatcherAssert.assertThat(SearchInSortedMatrix.search(matrix, 6), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{1, 2}));
        MatcherAssert.assertThat(SearchInSortedMatrix.search(matrix, 1), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{0, 0}));
        MatcherAssert.assertThat(SearchInSortedMatrix.search(matrix, 9), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{2, 2}));
    }
}
