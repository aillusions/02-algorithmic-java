package com.zalizniak.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array of positive integers,
 * what's the most efficient algorithm to find non-consecutive elements from this array which,
 * when added together, produce the maximum sum?
 */
public class MaximumSubsetFromNonAdjacentElementsTest {

    @Test
    public void shouldFindSum() {
        int[] input = {1, 2, 9, 4, 5, 0, 4, 11, 6};
        int expected = 26;
        Assert.assertEquals(expected, MaximumSubsetFromNonAdjacentElements.getSumMostEfficientWay(input));
    }

    @Test
    public void shouldFindSum1() {
        int[] input = {5, 5, 10, 100, 10, 5};
        int expected = 110;
        Assert.assertEquals(expected, MaximumSubsetFromNonAdjacentElements.getSumMostEfficientWay(input));
    }

    @Test
    public void shouldFindSum2() {
        int[] input = {1, 2, 3};
        int expected = 4;
        Assert.assertEquals(expected, MaximumSubsetFromNonAdjacentElements.getSumMostEfficientWay(input));
    }

    @Test
    public void shouldFindSum3() {
        int[] input = {1, 20, 3};
        int expected = 20;
        Assert.assertEquals(expected, MaximumSubsetFromNonAdjacentElements.getSumMostEfficientWay(input));
    }
}
