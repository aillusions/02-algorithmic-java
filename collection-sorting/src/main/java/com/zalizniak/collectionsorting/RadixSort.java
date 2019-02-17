package com.zalizniak.collectionsorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity of Solution: * Best Case O(k*n); Average Case O(k*n); Worst Case O(k*n)
 * where k is the length of the longest number
 * and n is the * size of the input array.
 */
public class RadixSort {

    public static void radixSort(int[] input) {
        final int RADIX = 10;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            // move to next digit
            placement *= RADIX;
        }
    }
}
