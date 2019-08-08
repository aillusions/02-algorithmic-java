package com.zalizniak.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Test;

public class MineAttamptSortTest {

    @Test
    public void shouldSort() {
        MatcherAssert.assertThat(MineAttamptSort.sort(new Integer[]{3, 2, 1}), IsArrayContainingInOrder.arrayContaining(3, 2, 1));
    }
}
