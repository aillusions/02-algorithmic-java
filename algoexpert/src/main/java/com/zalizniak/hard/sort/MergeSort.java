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

        merge(in, left, right, midIdx, length - midIdx);
    }

    public static void merge(Integer[] in, Integer[] l, Integer[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                in[k++] = l[i++];
            } else {
                in[k++] = r[j++];
            }
        }
        while (i < left) {
            in[k++] = l[i++];
        }
        while (j < right) {
            in[k++] = r[j++];
        }
    }

}
