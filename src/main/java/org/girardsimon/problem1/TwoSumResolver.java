package org.girardsimon.problem1;

import java.util.HashMap;
import java.util.Map;

public final class TwoSumResolver {
    private TwoSumResolver() {
    }
    /**
     * Finds the two numbers in the given array whose sum is equal to the target number.
     * <p>
     * Constraints:<br>
     * • 2 ≤ nums.length ≤ 10⁴<br>
     * • -10⁹ ≤ nums[i] ≤ 10⁹<br>
     * • -10⁹ ≤ target ≤ 10⁹<br>
     *
     * @param nums   the input array of numbers.
     * @param target the target number.
     * @return an array of size 2 containing the indices of the numbers whose sum is equal to the target number
     * @throws IllegalArgumentException if no two numbers in the array add up to the target number
     */
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
