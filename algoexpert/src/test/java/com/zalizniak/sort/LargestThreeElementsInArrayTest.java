package com.zalizniak.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

public class LargestThreeElementsInArrayTest {

    @Test
    public void shouldFindTreeLargestBySort() {
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersBySort(new int[]{3, 2, 1}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersBySort(new int[]{1, 2, 3}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersBySort(new int[]{1, 2, 3, 4, 5, 6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{6, 5, 4}));

        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersBySort(new int[]{-1, -2, -3, -4, -5, -6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{-1, -2, -3}));
    }

    @Test
    public void shouldFindTreeLargestNoSort() {
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort(new int[]{3, 2, 1}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort(new int[]{1, 2, 3}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort(new int[]{1, 2, 3, 4, 5, 6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{6, 5, 4}));

        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort(new int[]{-1, -2, -3, -4, -5, -6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{-1, -2, -3}));
    }

    @Test
    public void shouldFindTreeLargestNoSort2() {
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort2(new int[]{3, 2, 1}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort2(new int[]{1, 2, 3}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{3, 2, 1}));
        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort2(new int[]{1, 2, 3, 4, 5, 6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{6, 5, 4}));

        MatcherAssert.assertThat(LargestThreeElementsInArray.findBiggestThreeNumbersNoSort2(new int[]{-1, -2, -3, -4, -5, -6}), IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(new Integer[]{-1, -2, -3}));
    }

}