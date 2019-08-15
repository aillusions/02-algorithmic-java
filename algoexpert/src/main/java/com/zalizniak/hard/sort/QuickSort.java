package com.zalizniak.hard.sort;

/**
 * O(n log n)
 * <p>
 * Quicksort works in place.
 * And its worst-case running time is as bad as selection sort's and insertion sort's: Θ(n2).
 * But its average-case running time is as good as merge sort's: Θ(nlgn).
 */
public class QuickSort {


    public static Integer[] insertionSort(Integer[] in) {

        for (int i = 1; i < in.length; i++) {
            for (int j = 0; j < i; j++) {
                if (in[i] < in[j]) {
                    swap(in, i, j);
                    break;
                }
            }
        }
        return in;
    }


    public static Integer[] quickSort(Integer[] in) {
        return in;
    }

    private static void swap(Integer[] in, int i, int j) {
        int tmp = in[j];
        in[j] = in[i];
        in[i] = tmp;
    }

}
