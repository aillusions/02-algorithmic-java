package com.zalizniak.hard.sort;

/**
 * O(n log n)
 */
public class MergeSort {

    public static Integer[] sort(Integer[] in) {
        mergeSort(in, in.length);
        return in;
    }

    public static void mergeSort(Integer[] in, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = in[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = in[i];
        }
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(in, left, right, mid, length - mid);
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
