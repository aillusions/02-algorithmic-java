package com.zalizniak;

import junit.framework.TestCase;
import org.junit.Test;

public class FindClosestNumberTest {

    @Test
    public void shouldFindClosest() {
        TestCase.assertEquals(10, FindClosestNumber.getClosest(9, new int[]{2, 10, 20}));
        TestCase.assertEquals(82, FindClosestNumber.getClosest(80, new int[]{2, 42, 82, 122, 162, 202, 242, 282, 322, 362}));
        TestCase.assertEquals(400, FindClosestNumber.getClosest(400, new int[]{100, 200, 400, 800, 1600, 3200, 6400, 128000}));
        TestCase.assertEquals(128000, FindClosestNumber.getClosest(128000, new int[]{100, 200, 400, 800, 1600, 3200, 6400, 128000}));
        TestCase.assertEquals(-100, FindClosestNumber.getClosest(-99, new int[]{-100, 100}));
    }

    @Test
    public void shouldFindClosestSort() {
        TestCase.assertEquals(10, FindClosestNumber.getClosestSort(9, new int[]{2, 10, 20}));
        TestCase.assertEquals(82, FindClosestNumber.getClosestSort(80, new int[]{2, 42, 82, 122, 162, 202, 242, 282, 322, 362}));
        TestCase.assertEquals(400, FindClosestNumber.getClosestSort(400, new int[]{100, 200, 400, 800, 1600, 3200, 6400, 128000}));
        TestCase.assertEquals(128000, FindClosestNumber.getClosestSort(128000, new int[]{100, 200, 400, 800, 1600, 3200, 6400, 128000}));
        TestCase.assertEquals(-100, FindClosestNumber.getClosestSort(-99, new int[]{-100, 100}));
    }
}
