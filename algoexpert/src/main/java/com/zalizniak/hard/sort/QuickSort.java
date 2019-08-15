package com.zalizniak.hard.sort;

/**
 * O(n log n)
 * <p>
 * Quicksort works in place.
 * And its worst-case running time is as bad as selection sort's and insertion sort's: Θ(n2).
 * But its average-case running time is as good as merge sort's: Θ(nlgn).
 */
public class QuickSort {


    /**
     * 5 4 3 2 1
     */
    public static Integer[] insertionSort(Integer[] in) {

        for (int i = 1; i < in.length; i++) {
            int cardValue = in[i];
            int j = i - 1;
            while (j >= 0 && in[j] > cardValue) {
                in[j + 1] = in[j];
                j--;
            }
            in[j + 1] = cardValue;
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
