package com.zalizniak.easy.search;

public class ArraySearch {


    // Iterative binary search
    // Recursive binary search

    /**
     * Search in sorted array
     */
    public static int findBinary(int[] in, int rangeStartIdx, int rangeEndIdx, int value) {

        if (rangeStartIdx <= rangeEndIdx) {
            int centerIdx = rangeStartIdx + ((rangeEndIdx - rangeStartIdx) / 2);

            System.out.println(rangeStartIdx + " " + rangeEndIdx + " -> center: " + centerIdx);

            if (in[centerIdx] == value) {
                return centerIdx;
            } else if (in[centerIdx] < value) {
                return findBinary(in, centerIdx + 1, rangeEndIdx, value);
            } else {
                return findBinary(in, rangeStartIdx, centerIdx - 1, value);
            }

        }

        return -1;
    }
}
