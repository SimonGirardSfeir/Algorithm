package org.girardsimon.problem7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverserTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(123,
                        321),
                Arguments.of(-123,
                        -321),
                Arguments.of(120,
                        21),
                Arguments.of(1534236469,
                        0)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void reverse_should_return_the_same_number_with_digit_reversed(int num, int reversed) {
        // Act
        int actual = Reverser.reverse(num);

        // Assert
        assertThat(actual).isEqualTo(reversed);
    }
}