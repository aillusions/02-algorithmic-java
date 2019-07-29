package com.zalizniak;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    /**
     * 1 2 3
     * 1 - x x
     * 2
     * 3
     */
    public static int[][] findTwoSums(int[] inputArray, int sum) {

        int[][] rv;

        List<int[]> rvList = new ArrayList<int[]>();

        //for (int i = 0; i < inputArray.length; i++) {
        //    for (int j = 0; j < inputArray.length; j++) {
//
        //    }
        //}

        rv = new int[rvList.size()][2];
        for (int i = 0; i < rvList.size(); i++) {
            rv[i] = rvList.get(i);
        }
        return rv;
    }
}
