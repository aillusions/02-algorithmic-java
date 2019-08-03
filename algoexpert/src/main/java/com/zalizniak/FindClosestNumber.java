package com.zalizniak;

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
}
