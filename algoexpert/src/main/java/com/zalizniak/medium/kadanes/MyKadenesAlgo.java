package com.zalizniak.medium.kadanes;

public class MyKadenesAlgo implements KadenesAlgo {

    @Override
    public int maxSum(Integer[] in) {
        return maxSubArraySum(in);
    }

    static int maxSubArraySum(Integer[] in) {

        if (in == null || in.length == 0) {
            return 0;
        }

        int maxEndingHere = in[0];
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 1; i < in.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + in[i], in[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
