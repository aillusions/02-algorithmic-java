package com.zalizniak.hard.sort;

import java.util.Arrays;

/**
 * O(n log n)
 */
public class MergeSort {

    public static Integer[] sort(Integer[] in) {
        mergeSort(in);
        return in;
    }

    public static void mergeSort(Integer[] in) {
        int length = in.length;
        if (length < 2) {
            return;
        }

        int midIdx = length / 2;

        Integer[] left = Arrays.copyOfRange(in, 0, midIdx);
        Integer[] right = Arrays.copyOfRange(in, midIdx, length);

        mergeSort(left);
        mergeSort(right);

        merge(in, left, right);
    }

    public static void merge(Integer[] in, Integer[] left, Integer[] right) {

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                in[k++] = left[i++];
            } else {
                in[k++] = right[j++];
            }
        }

        while (i < left.length) {
            in[k++] = left[i++];
        }

        while (j < right.length) {
            in[k++] = right[j++];
        }
    }

}
