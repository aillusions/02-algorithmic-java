package com.zalizniak.medium.kadanes;

public class MyKadenesAlgo implements KadenesAlgo {

    @Override
    public int maxSum(Integer[] in) {
        return maxSubArraySum(in);
    }

    static int maxSubArraySum(Integer[] in) {

        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < in.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + in[i], 0);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
