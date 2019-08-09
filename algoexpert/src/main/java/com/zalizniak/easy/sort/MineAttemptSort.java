package com.zalizniak.easy.sort;

import java.util.Arrays;

public class MineAttemptSort {

    public static Integer[] referenceImpl(Integer[] in) {
        Arrays.sort(in);
        return in;
    }

    /**
     * In Bubble Sort, n-1 comparisons will be done in the 1st pass, n-2 in 2nd pass, n-3 in 3rd pass and so on.
     * So the total number of comparisons will be:
     * <p>
     * (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1
     * Sum = n(n-1)/2
     * i.e O(n2)
     */
    public static Integer[] bubbleSort(Integer[] in) {
        for (int j = 0; j < in.length - 1; j++) {
            for (int i = 0; i < (in.length - j - 1); i++) {
                if (in[i] > in[i + 1]) {
                    Integer tmp = in[i];
                    in[i] = in[i + 1];
                    in[i + 1] = tmp;
                }
            }
        }

        return in;
    }

    /**
     * Worst Case Time Complexity [ Big-O ]: O(n2)
     * Best Case Time Complexity [Big-omega]: O(n2)
     * Average Time Complexity [Big-theta]: O(n2)
     * Space Complexity: O(1)
     */
    public static Integer[] selectionSort(Integer[] in) {

        for (int i = 0; i < in.length; i++) {

            int smallestVal = in[i];
            int smallestIdx = i;

            for (int j = i + 1; j < in.length; j++) {
                if (smallestVal > in[j]) {
                    smallestVal = in[j];
                    smallestIdx = j;
                }
            }

            int tmp = in[i];
            in[i] = in[smallestIdx];
            in[smallestIdx] = tmp;
        }

        return in;
    }

    /**
     *
     */
    public static Integer[] insertionSort(Integer[] in) {

        for (int i = 1; i < in.length; i++) {
            System.out.print(i + " - " + Arrays.toString(in) + " -> ");
            int card = in[i];
            int j = i - 1;

            while (j >= 0 && card < in[j]) {
                in[j + 1] = in[j];
                j--;
            }

            in[j + 1] = card;

            System.out.println(Arrays.toString(in));
        }

        return in;
    }
}
