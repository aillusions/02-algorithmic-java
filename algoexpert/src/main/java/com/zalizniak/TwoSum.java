package com.zalizniak;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    /**
     * 1 - x x -- 0,0 0,1 0,2
     * 2 - - x -- 1,0 1,1 1,2
     * 3 - - -
     * _ 1 2 3
     */
    public static int[][] findTwoSums(int[] inputArray, int sum) {

        List<int[]> rvList = new ArrayList<int[]>();

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (j > i && inputArray[i] + inputArray[j] == sum) {
                    rvList.add(new int[]{i, j});
                }
            }
        }

        int[][] rv = new int[rvList.size()][];
        for (int i = 0; i < rvList.size(); i++) {
            int[] idxs = rvList.get(i);
            rv[i] = new int[]{inputArray[idxs[0]], inputArray[idxs[1]]};
        }

        return rv;
    }
}
