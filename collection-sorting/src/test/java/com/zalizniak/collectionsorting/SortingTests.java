package com.zalizniak.collectionsorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTests {

    @Test
    public void bubleSort() {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }

    @Test
    public void bubbleSortStream() {
        Integer arr[] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSortStream(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }

    @Test
    public void mergeSort() {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        arr = MergeSort.mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }

    @Test
    public void quickSort() {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        Quicksort.quickSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Assert.assertEquals("[11, 12, 22, 25, 34, 64, 90]", Arrays.toString(arr));
    }
}
