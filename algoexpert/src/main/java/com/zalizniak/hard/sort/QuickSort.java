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
        quickSort(in, 0, in.length - 1);
        return in;
    }

    protected static void swap(Integer[] in, int i, int j) {
        int tmp = in[j];
        in[j] = in[i];
        in[i] = tmp;
    }

    /**
     * Performs pivot partitioning
     */
    protected static int partition(Integer[] in, int startIdx, int endIdx) {
        int pivotIdx = endIdx;
        int pivotValue = in[pivotIdx];

        int leftIdx = startIdx;
        int rightIdx = endIdx - 1;

        while (true) {

            while (in[leftIdx] < pivotValue) {
                leftIdx++;
            }

            while (in[rightIdx] > pivotIdx) {
                rightIdx--;
            }

            if (leftIdx >= rightIdx) {
                break;
            }

            swap(in, leftIdx, rightIdx);
            leftIdx++;
            rightIdx--;
        }

        swap(in, leftIdx, pivotIdx);
        return leftIdx;
    }

    protected static void quickSort(Integer[] in, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int pivotIdx = partition(in, startIdx, endIdx);

            quickSort(in, startIdx, pivotIdx - 1);  // Before pivotIdx
            quickSort(in, pivotIdx + 1, endIdx); // After pivotIdx
        }
    }
}
