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
    public static int[][] findTwoSums(int[] nums, int target) {

        List<int[]> rvList = new ArrayList<int[]>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j > i && nums[i] + nums[j] == target) {
                    rvList.add(new int[]{i, j});
                }
            }
        }

        int[][] rv = new int[rvList.size()][];
        for (int i = 0; i < rvList.size(); i++) {
            int[] idxs = rvList.get(i);
            rv[i] = new int[]{nums[idxs[0]], nums[idxs[1]]};
        }

        return rv;
    }
}
