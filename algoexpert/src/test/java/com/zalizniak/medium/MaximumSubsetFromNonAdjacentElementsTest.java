package com.zalizniak.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubsetFromNonAdjacentElementsTest {

    @Test
    public void shouldFindSum() {
        int[] input = {3, 2, 7, 10};
        int expected = 13;
        Assert.assertEquals(expected, MaximumSubsetFromNonAdjacentElements.getSumMostEfficientWay(input));
    }

    @Test
    public void shouldFindSum0() {
        int[] input = {3, 2, 5, 10, 7};
        int expected = 15;
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
