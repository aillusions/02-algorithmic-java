package com.zalizniak.hard.sort;

import java.util.Arrays;

/**
 * time complexity is O(n log n)
 * space complexity is O(n)
 */
public class MergeSort {

    public static Integer[] sort(Integer[] in) {
        mergeSort(in);
        return in;
    }

    public static void mergeSort(Integer[] in) {
        if (in.length < 2) {
            return;
        }

        int midIdx = in.length / 2;

        Integer[] left = Arrays.copyOfRange(in, 0, midIdx);
        Integer[] right = Arrays.copyOfRange(in, midIdx, in.length);

        mergeSort(left);
        mergeSort(right);

        merge(in, left, right);
    }

    /**
     *
     * @param in - unordered super-array
     * @param left - sorted sub-array
     * @param right- sorted sub-array
     */
    public static void merge(Integer[] in, Integer[] left, Integer[] right) {

        int leftIdx = 0;
        int rightIdx = 0;

        int inIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                in[inIdx++] = left[leftIdx++];
            } else {
                in[inIdx++] = right[rightIdx++];
            }
        }

        while (leftIdx < left.length) {
            in[inIdx++] = left[leftIdx++];
        }

        while (rightIdx < right.length) {
            in[inIdx++] = right[rightIdx++];
        }
    }

}
