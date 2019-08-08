package com.example.collectionsearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchTests {

    int[] arr = {2, 3, 4, 10, 40};

    @Test
    public void testLinear() {
        int result = LinearSearch.search(arr, 10);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testBinaryRecursive() {
        int result = BinarySearchRecursive.binarySearch(arr, 10);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testBinaryIterative() {
        int result = BinarySearchIterative.binarySearch(arr, 10);
        Assert.assertEquals(3, result);
    }
}
