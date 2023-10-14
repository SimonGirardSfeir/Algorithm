package org.girardsimon.problem3;

import java.util.HashSet;
import java.util.Set;

public final class LongestSubstring {
    private LongestSubstring() {
    }
    /**
     * Calculates the length of the longest substring in the given input without repeating characters.
     * <p>
     * Constraints:<br>
     * • 0 ≤ input.length ≤ 5 * 10⁴<br>
     * • input consists of English letters, digits, symbols and spaces.<br>
     *
     * @param input the input string
     * @return the length of the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String input) {
        int startCurrentLongestString = 0;
        int endCurrentLongestString = 0;
        int length = 0;
        Set<Character> currentLongestSubstring = new HashSet<>();

        while((input.length() - startCurrentLongestString >= length) && (endCurrentLongestString < input.length())) {
            if(!currentLongestSubstring.contains(input.charAt(endCurrentLongestString))) {
                currentLongestSubstring.add(input.charAt(endCurrentLongestString));
                endCurrentLongestString++;
                length = Math.max(length, currentLongestSubstring.size());
            } else {
                currentLongestSubstring.remove(input.charAt(startCurrentLongestString));
                startCurrentLongestString++;
            }
        }
        return length;
    }
}
