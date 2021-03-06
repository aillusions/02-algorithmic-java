package com.zalizniak.easy;

import com.zalizniak.easy.TwoSum;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * The two sum problem is a common interview question, and it is a variation of the subset sum problem. There is a popular dynamic programming solution for the subset sum problem, but for the two sum problem we can actually write an algorithm that runs in O(n) time. The challenge is to find all the pairs of two integers in an unsorted array that sum up to a given S.
 * For example, if the array is [3, 5, 2, -4, 8, 11] and the sum is 7, your program should return [[11, -4], [2, 5]] because 11 + -4 = 7 and 2 + 5 = 7.
 */
public class TwoSumTest extends TestCase {

    private final int[] emptyInput = new int[0];
    private final int[] input = new int[]{3, 5, 2, -4, 8, 11};


    public void testEmptyInput() {
        Assert.assertArrayEquals(new int[0], TwoSum.findTwoSums(emptyInput, 0));
    }

    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, TwoSum.findTwoSums(input, 7));
    }

    public void testTwoSumMap() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, TwoSum.twoSumMap(input, 7));
    }

}
