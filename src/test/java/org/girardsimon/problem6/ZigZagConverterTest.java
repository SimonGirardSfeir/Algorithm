package org.girardsimon.problem6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZigZagConverterTest {
    private static Stream<Arguments> data() {
        return Stream.of(

                /*
                    "PAYPALISHIRING" - 3
                    ->
                    P   A   H   N
                    A P L S I I G
                    Y   I   R
                    Then read row by row.
                 */
                Arguments.of("PAYPALISHIRING", 3,
                        "PAHNAPLSIIGYIR"),
                /*
                    "PAYPALISHIRING" - 4
                    ->
                    P     I    N
                    A   L S  I G
                    Y A   H R
                    P     I
                 */
                Arguments.of("PAYPALISHIRING", 4,
                        "PINALSIGYAHRPI"),
                Arguments.of("A", 1,
                        "A"),
                Arguments.of("AB", 1,
                        "AB"),
                Arguments.of("ABC", 1,
                        "ABC"),
                Arguments.of("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                        2,
                        "Aaidoeswr,haenme,rtesqecouishtabrateaeaietedrcinwtgnrlloacsoajsmnsoucutoadodiiesplnrmiaodprs,ubroohreunefnttacneedhsmwynihrieto,iheeaalwnefrdutettpntainnwrdvdr.")
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void convert_should_return_length_of_longest_substring_without_repeating_characters(String input, int numberOfRows,
                                                                                        String expectedOutput) {
        // Act
        String actual = ZigZagConverter.convert(input, numberOfRows);

        // Assert
        assertThat(actual).isEqualTo(expectedOutput);
    }
}