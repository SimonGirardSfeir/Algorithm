package org.girardsimon.problem1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumResolverTest {

    private static Stream<Arguments> data() {

        return Stream.of(
                Arguments.of(new int[]{2,7,11,15}, 9,
                        new int[]{0,1}),
                Arguments.of(new int[]{3,2,4}, 6,
                        new int[]{1,2}),
                Arguments.of(new int[]{3,3}, 6,
                        new int[]{0,1})
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void twoSum_should_return_indices_of_the_two_numbers_such_that_they_add_up_to_target(int[] nums, int target,
                                                                                         int[] expectedIndices) {
        //When
        int[] actual = TwoSumResolver.twoSum(nums, target);

        //Then
        assertThat(actual).isEqualTo(expectedIndices);
    }

}