package com.zalizniak.collectionsorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTests {

    @Test
    public void boobleSort() {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }

    @Test
    public void boobleSortStream() {
        BubbleSort ob = new BubbleSort();
        Integer arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSortStream(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }
}
