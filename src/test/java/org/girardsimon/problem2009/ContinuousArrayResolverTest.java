package org.girardsimon.problem2009;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContinuousArrayResolverTest {

    /*
    You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

    nums is considered continuous if both of the following conditions are fulfilled:

     1. All elements in nums are unique.
    2. The difference between the maximum element and the minimum element in nums equals nums.length - 1.
    For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

    Return the minimum number of operations to make nums continuous.

    Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 109
    */

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{4,2,5,3},0),
                Arguments.of(new int[]{1,2,3,5,6},1),
                Arguments.of(new int[]{1,10,100,1000},3),
                Arguments.of(new int[]{41,33,29,33,35,26,47,24,18,28},5),
                Arguments.of(new int[]{18,13,11,25,10,21,13,11,16,16,17,12,20,14},4),
                Arguments.of(new int[]{10,49,16,22,28,34,35,7},5)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void minOperations_should_return_minimum_of_operations_to_make_array_continuous(int[] nums, int expectedNumberOfOperations) {
        // Act
        int actual = ContinuousArrayResolver.minOperations(nums);

        // Assert
        assertThat(actual).isEqualTo(expectedNumberOfOperations);
    }

}