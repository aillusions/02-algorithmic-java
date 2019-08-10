package com.zalizniak.medium.maximum_subset_from_non_adjacent_elements;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MaxNonAdjacentElementsSubsetTest {

    private MaxNonAdjacentElementsSubset solver;

    public MaxNonAdjacentElementsSubsetTest(MaxNonAdjacentElementsSubset solver) {
        this.solver = solver;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new MostEfficient()},
                {new DynamicProgramming()}
        });
    }

    @Test
    public void shouldFindSum() {
        Integer[] input = {3, 2, 7, 10};
        int expected = 13;
        Assert.assertEquals(expected, solver.getMaxSum(input));
    }

    @Test
    public void shouldFindSum0() {
        Integer[] input = {3, 2, 5, 10, 7};
        int expected = 15;
        Assert.assertEquals(expected, solver.getMaxSum(input));
    }

    @Test
    public void shouldFindSum1() {
        Integer[] input = {5, 5, 10, 100, 10, 5};
        int expected = 110;
        Assert.assertEquals(expected, solver.getMaxSum(input));
    }

    @Test
    public void shouldFindSum2() {
        Integer[] input = {1, 2, 3};
        int expected = 4;
        Assert.assertEquals(expected, solver.getMaxSum(input));
    }

    @Test
    public void shouldFindSum3() {
        Integer[] input = {1, 20, 3};
        int expected = 20;
        Assert.assertEquals(expected, solver.getMaxSum(input));
    }
}
