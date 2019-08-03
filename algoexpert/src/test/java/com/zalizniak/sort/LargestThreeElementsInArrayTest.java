package com.zalizniak.sort;

import org.junit.Assert;
import org.junit.Test;

public class LargestThreeElementsInArrayTest {

    @Test
    public void shouldFindTreeLargest() {
        Assert.assertArrayEquals(new int[]{3, 2, 1}, LargestThreeElementsInArray.findBiggestThreeNumbers(new int[]{3, 2, 1}));
    }
}
