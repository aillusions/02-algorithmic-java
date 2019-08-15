package com.zalizniak.hard.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SortTest {

    @Test
    public void testPivotPartitioning() {
        Integer[] in = {5, 6, 7, 1, 2, 3};
        System.out.println(Arrays.toString(in));
        Assert.assertEquals(2, QuickSort.partition(in, 0, in.length - 1));
        System.out.println(Arrays.toString(in));
    }

    @Test
    public void testInsertion() {
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{5, 6, 7, 1, 2, 3}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 5, 6, 7));
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{5, 4, 3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 4, 5));
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(QuickSort.insertionSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }

    @Test
    public void testQuickSort() {
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{5, 6, 7, 1, 2, 3}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 5, 6, 7));
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{5, 4, 3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 4, 5));
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(QuickSort.quickSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }

    @Test
    public void testMergeSort() {
        MatcherAssert.assertThat(MergeSort.sort(new Integer[]{5, 6, 7, 1, 2, 3}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 5, 6, 7));
        // MatcherAssert.assertThat(MergeSort.sort(new Integer[]{5, 4, 3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3, 4, 5));
        // MatcherAssert.assertThat(MergeSort.sort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        // MatcherAssert.assertThat(MergeSort.sort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }
}
