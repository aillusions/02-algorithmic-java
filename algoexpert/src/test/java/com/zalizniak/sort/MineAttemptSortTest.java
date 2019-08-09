package com.zalizniak.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Test;

public class MineAttemptSortTest {

    @Test
    public void shouldSortOOTB() {
        MatcherAssert.assertThat(MineAttemptSort.referenceImpl(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
    }

    @Test
    public void shouldSortBubble() {
        MatcherAssert.assertThat(MineAttemptSort.bubbleSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(MineAttemptSort.bubbleSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }

    @Test
    public void shouldSortSelection() {
        MatcherAssert.assertThat(MineAttemptSort.selectionSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(MineAttemptSort.selectionSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }

    @Test
    public void shouldSortInsertion() {
        MatcherAssert.assertThat(MineAttemptSort.insertionSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(MineAttemptSort.insertionSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }
}
