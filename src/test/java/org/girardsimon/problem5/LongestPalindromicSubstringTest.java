package org.girardsimon.problem5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("babad",
                        "bab"),
                Arguments.of("cbbd",
                        "bb"),
                Arguments.of("a",
                        "a"),
                Arguments.of("ccc",
                        "ccc"),
                Arguments.of("aaaa",
                        "aaaa")
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void longestPalindrome_should_return_longest_palindrome_in_input(String input, String expectedLongestPalindrome) {
        // Act
        String actual = LongestPalindromicSubstring.longestPalindrome(input);

        // Assert
        assertThat(actual).isEqualTo(expectedLongestPalindrome);
    }

}