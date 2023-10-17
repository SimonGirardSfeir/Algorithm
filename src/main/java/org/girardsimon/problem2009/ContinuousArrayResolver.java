package org.girardsimon.problem2009;

import java.util.Arrays;

public final class ContinuousArrayResolver {
    private ContinuousArrayResolver() {
    }
    /**<p>
     * Finds the minimum number of operations required to make the array in input
     * <strong style="text-decoration:underline;">continuous</strong>.
     * What is a <strong style="text-decoration:underline;">continuous</strong> array?</p>
     * <p>
     * nums is <strong style="text-decoration:underline;">continuous</strong> if:<br>
     * • All elements in nums are unique<br>
     * • The difference between the <strong>maximum</strong> element and the
     * <strong>minimum</strong> element in nums equals nums.length - 1.<br>
     * </p>
     * <p>
     * Constraints:<br>
     * • 1 ≤ nums.length ≤ 10⁵<br>
     * • 1 ≤ nums[i] ≤ 10⁹<br>
     *
     *
     * @param nums The input array of integers.
     * @return The minimum number of operations required to make the input continuous.
     */
    public static int minOperations(int[] nums) {
        int numsLength = nums.length;
        int minimumOperation = numsLength;
        /*
            The array in input can contain duplicated items, and it is not sorted.
         */
        int[] uniqueNums = Arrays.stream(nums)
                .distinct()
                .sorted()
                .toArray();
        int rangeCoveredByArrayLengthStartingFromCurrentIndex = 0;
        for(int i = 0; i < uniqueNums.length; i++) {
            rangeCoveredByArrayLengthStartingFromCurrentIndex =
                    getRangeCoveredByArrayLength(rangeCoveredByArrayLengthStartingFromCurrentIndex,
                            uniqueNums,
                            i, numsLength);
            int currentRangeCoveredByArray = rangeCoveredByArrayLengthStartingFromCurrentIndex - i;
            minimumOperation = Math.min(minimumOperation, numsLength - currentRangeCoveredByArray);
            //No need to iterate anymore, minimumOperation can't be lower than 0.
            if(minimumOperation == 0 && rangeCoveredByArrayLengthStartingFromCurrentIndex + i > nums.length) {
                break;
            }
        }
        return minimumOperation;
    }

    private static int getRangeCoveredByArrayLength(int rangeCoveredByArrayLengthStartingFromCurrentIndex,
                                                    int[] nums, int i, int numsLength) {
        while (rangeCoveredByArrayLengthStartingFromCurrentIndex <
                nums.length &&
                nums[rangeCoveredByArrayLengthStartingFromCurrentIndex] < nums[i] + numsLength) {
            rangeCoveredByArrayLengthStartingFromCurrentIndex++;
        }
        return rangeCoveredByArrayLengthStartingFromCurrentIndex;
    }
}
