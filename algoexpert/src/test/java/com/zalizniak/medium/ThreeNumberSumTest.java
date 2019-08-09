package com.zalizniak.medium;

import medium.ThreeNumberSum;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

public class ThreeNumberSumTest {

    @Test
    public void testThreeNumberSum() {
        MatcherAssert.assertThat(ThreeNumberSum.findThreeNumberSum(new Integer[]{1, 2, 3, 4}, 6), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(1, 2, 3));
    }
}
