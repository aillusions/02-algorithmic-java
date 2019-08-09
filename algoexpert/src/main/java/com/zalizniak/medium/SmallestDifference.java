package com.zalizniak.medium;

public class SmallestDifference {

    public static int getSmallestDiff(int[] in) {

        int rv = Integer.MAX_VALUE;

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (i == j) {
                    continue;
                }
                int diff = Math.abs(in[i] - in[j]);
                if (rv > diff) {
                    rv = diff;
                }
            }
        }
        return rv;
    }
}
