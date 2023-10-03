package org.girardsimon.problem9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeResolverTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(121,
                        true),
                Arguments.of(-121,
                        false),
                Arguments.of(10,
                        false),
                Arguments.of(1243,
                        false),
                Arguments.of(1221,
                        true),
                Arguments.of(0,
                        true)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void isPalindrome_should_return_true_if_a_number_is_a_palindrome_and_false_otherwise(int num, boolean isPalindrome) {
        //When
        boolean actual = PalindromeResolver.isPalindrome(num);

        //Then
        assertThat(actual).isEqualTo(isPalindrome);
    }

}