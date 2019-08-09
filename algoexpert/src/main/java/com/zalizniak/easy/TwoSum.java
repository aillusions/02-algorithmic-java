package com.zalizniak.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    /**
     *
     */
    public static int[] findTwoSums(int[] nums, int target) {

        List<Integer> rvList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j > i && nums[i] + nums[j] == target) {
                    rvList.add(i);
                    rvList.add(j);
                }
            }
        }

        return rvList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
