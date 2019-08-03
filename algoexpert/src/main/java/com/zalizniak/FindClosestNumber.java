package com.zalizniak;

import java.util.Arrays;

public class FindClosestNumber {

    public static int getClosest(int given, int[] array) {

        int minDiff = Integer.MAX_VALUE;
        int rv = 0;

        for (int i = 0; i < array.length; i++) {
            int thisValue = array[i];
            int diff = Math.abs(given - thisValue);
            if (minDiff > diff) {
                minDiff = diff;
                rv = thisValue;
            }
        }

        return rv;
    }

    public static int getClosestSort(int given, int[] array) {
        Integer[] integerArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integerArray[i] = array[i];
        }

        Arrays.sort(integerArray, (a, b) -> Math.abs(given - a) - Math.abs(given - b));

        return integerArray[0];
    }
}
