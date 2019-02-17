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
    public void testBinary() {
        int arr[] = {2, 3, 4, 10, 40};
        int result = BinarySearch.binarySearch(arr, 10);
        Assert.assertEquals(3, result);
    }
}
