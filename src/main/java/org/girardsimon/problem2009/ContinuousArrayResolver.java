package org.girardsimon.problem2009;

import java.util.Arrays;

public final class ContinuousArrayResolver {
    private ContinuousArrayResolver() {
    }
    /*
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^9
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
        int rangeCoveredByArrayLenghtStartingFromCurrentIndex = 0;
        for(int i = 0; i < uniqueNums.length; i++) {
            rangeCoveredByArrayLenghtStartingFromCurrentIndex =
                    getRangeCoveredByArrayLength(rangeCoveredByArrayLenghtStartingFromCurrentIndex,
                            uniqueNums,
                            i, numsLength);
            int currentRangeCoveredByArray = rangeCoveredByArrayLenghtStartingFromCurrentIndex - i;
            minimumOperation = Math.min(minimumOperation, numsLength - currentRangeCoveredByArray);
            //No need to iterate anymore, minimumOperation can't be lower than 0.
            if(minimumOperation == 0 && rangeCoveredByArrayLenghtStartingFromCurrentIndex + i > nums.length) {
                break;
            }
        }
        return minimumOperation;
    }

    private static int getRangeCoveredByArrayLength(int rangeCoveredByArrayLenghtStartingFromCurrentIndex,
                                                    int[] nums, int i, int numsLength) {
        while (rangeCoveredByArrayLenghtStartingFromCurrentIndex <
                nums.length &&
                nums[rangeCoveredByArrayLenghtStartingFromCurrentIndex] < nums[i] + numsLength) {
            rangeCoveredByArrayLenghtStartingFromCurrentIndex++;
        }
        return rangeCoveredByArrayLenghtStartingFromCurrentIndex;
    }
}
