package com.zalizniak.collectionsorting;

/**
 * Time complexity (n*log(n))
 * Space complexity O(n)
 */
public class MergeSort {

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j]) c[k] = a[i++];
            else c[k] = b[j++];
        }
        return c;
    }

    public static int[] mergeSort(int[] input) {
        int N = input.length;
        if (N <= 1) return input;
        int[] a = new int[N / 2];
        int[] b = new int[N - N / 2];

        for (int i = 0; i < a.length; i++) {
            a[i] = input[i];
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = input[i + N / 2];
        }

        return merge(mergeSort(a), mergeSort(b));
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1]) return false;
        return true;
    }
}
