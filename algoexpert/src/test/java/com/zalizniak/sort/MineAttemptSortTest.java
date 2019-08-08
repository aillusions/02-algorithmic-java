package com.zalizniak.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Test;

public class MineAttemptSortTest {

    @Test
    public void shouldSort() {
        MatcherAssert.assertThat(MineAttemptSort.referenceImpl(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(MineAttemptSort.bubbleSort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(1, 2, 3));
        MatcherAssert.assertThat(MineAttemptSort.bubbleSort(new Integer[]{1, 0, 2, -1, 3}), IsArrayContainingInOrder.arrayContaining(-1, 0, 1, 2, 3));
    }
}
