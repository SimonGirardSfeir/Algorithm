package org.girardsimon.problem8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringToIntegerTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("0032", 32),
                Arguments.of("4193 with words", 4193),
                Arguments.of("words and 987", 0),
                Arguments.of("-91283472332", Integer.MIN_VALUE),
                Arguments.of("+-12", 0),
                Arguments.of("", 0),
                Arguments.of(" ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void myAtoi_should_convert_input_to_an_integer(String input, int expected) {
        // Act
        int actual = StringToInteger.myAtoi(input);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }
}