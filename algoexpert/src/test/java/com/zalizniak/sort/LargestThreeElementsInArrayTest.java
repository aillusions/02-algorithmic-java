package com.zalizniak.sort;

import org.junit.Assert;
import org.junit.Test;

public class LargestThreeElementsInArrayTest {

    @Test
    public void shouldFindTreeLargest() {
        Assert.assertArrayEquals(new int[]{3, 2, 1}, LargestThreeElementsInArray.findBiggestThreeNumbers(new int[]{3, 2, 1}));

        Assert.assertArrayEquals(new int[]{3, 2, 1}, LargestThreeElementsInArray.findBiggestThreeNumbers(new int[]{1, 2, 3}));

        Assert.assertArrayEquals(new int[]{6, 5, 4}, LargestThreeElementsInArray.findBiggestThreeNumbers(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
