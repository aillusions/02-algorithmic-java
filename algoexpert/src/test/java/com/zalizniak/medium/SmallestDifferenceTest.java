package com.zalizniak.medium;

import org.junit.Assert;
import org.junit.Test;

public class SmallestDifferenceTest {

    @Test
    public void shouldFindSmallestDifference() {
        Assert.assertEquals(1, SmallestDifference.getSmallestDiff(new int[]{1, 2}));
        Assert.assertEquals(2, SmallestDifference.getSmallestDiff(new int[]{5, 10, 20, 100, 3}));
    }
}
