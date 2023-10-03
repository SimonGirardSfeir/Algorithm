package org.girardsimon.problem1;

import java.util.HashMap;
import java.util.Map;

public final class TwoSumResolver {
    private TwoSumResolver() {
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if(map.containsKey(comp) && i != map.get(comp))
                return new int[]{map.get(comp), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
