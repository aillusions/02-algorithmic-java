package com.zalizniak.hard.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Test;


public class QuickSortTest {

    @Test
    public void testInsertion() {
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }
}
