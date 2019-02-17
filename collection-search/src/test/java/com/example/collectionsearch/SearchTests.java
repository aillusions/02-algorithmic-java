package com.example.collectionsearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchTests {

    @Test
    public void testLinear() {
        int arr[] = {2, 3, 4, 10, 40};
        int result = LinearSearch.search(arr, 10);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testBinaryRecursive() {
        int arr[] = {2, 3, 4, 10, 40};
        int result = BinarySearchRecursive.binarySearch(arr, 10);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testBinaryIterative() {
        int arr[] = {2, 3, 4, 10, 40};
        int result = BinarySearchIterative.binarySearch(arr, 10);
        Assert.assertEquals(3, result);
    }
}
