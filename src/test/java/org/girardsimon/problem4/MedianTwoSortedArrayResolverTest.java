package org.girardsimon.problem4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MedianTwoSortedArrayResolverTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1,3},new int[]{2},2.00000),
                Arguments.of(new int[]{1,2},new int[]{3,4},2.50000)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void findMedianSortedArrays_should_return_the_median_of_two_sorted_arrays_in_input(int[] numsLeft, int[] numsRight, double expectedMedian) {
        // Act
        double actual = MedianTwoSortedArrayResolver.findMedianSortedArrays(numsLeft, numsRight);

        // Assert
        assertThat(actual).isEqualTo(expectedMedian);
    }

}