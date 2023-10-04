package org.girardsimon.problem3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("abcabcbb",
                        3),
                Arguments.of("bbbbb",
                        1),
                Arguments.of("pwwkew",
                        3),
                Arguments.of(" ",
                        1)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLongestSubstring_should_return_length_of_longest_substring_without_repeating_characters(String input, int expectedLength) {
        // Act
        int actual = LongestSubstring.lengthOfLongestSubstring(input);

        // Assert
        assertThat(actual).isEqualTo(expectedLength);
    }
}