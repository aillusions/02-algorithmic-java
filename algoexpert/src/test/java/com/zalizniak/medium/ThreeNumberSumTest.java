package com.zalizniak.medium;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

public class ThreeNumberSumTest {

    @Test
    public void testThreeNumberSum() {
        Assert.assertNull(ThreeNumberSum.findThreeNumberSum(new Integer[]{1, 2, 3, 4}, 10));
        MatcherAssert.assertThat(ThreeNumberSum.findThreeNumberSum(new Integer[]{1, 2, 3, 4}, 6), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(1, 2, 3));
        MatcherAssert.assertThat(ThreeNumberSum.findThreeNumberSum(new Integer[]{12, 3, 4, 1, 6, 9}, 24), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(12, 3, 9));
    }
}
