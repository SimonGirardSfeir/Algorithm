package org.girardsimon.problem5;

public final class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {
    }
    /*
        1 <= s.length <= 1000
        s consist of only digits and English letters.
     */
    public static String longestPalindrome(String input) {
        int[] longestPalindrome = new int[] {0,0};
        int[] currentPalindrome = new int[] {0,0};

        for(int i = 0; i < input.length()-1; i++) {
            if(i > 0 && i < input.length()-1 && input.charAt(i-1) == input.charAt(i+1)) {
                currentPalindrome = expandPalindromeFromCenter(input, i, i);
            }
            longestPalindrome = getLongestPalindrome(currentPalindrome, longestPalindrome);

            if(input.charAt(i) == input.charAt(i+1)) {
                currentPalindrome = expandPalindromeFromCenter(input, i, i+1);
            }
            longestPalindrome = getLongestPalindrome(currentPalindrome, longestPalindrome);
        }
        return input.substring(longestPalindrome[0], longestPalindrome[1] + 1);
    }
    private static int[] getLongestPalindrome(int[] currentPalindrome, int[] longestPalindrome) {
        int currentPalindromeLength = currentPalindrome[1] - currentPalindrome[0] + 1;
        int longestPalindromeLength = longestPalindrome[1] - longestPalindrome[0] + 1;
        if(currentPalindromeLength > longestPalindromeLength) {
            longestPalindrome = currentPalindrome;
        }
        return longestPalindrome;
    }
    private static int[] expandPalindromeFromCenter(String input, int left, int right) {
        while(left > 0 && right < input.length() -1 && input.charAt(left-1) == input.charAt(right+1)) {
            left--;
            right++;
        }
        return new int[]{left, right};
    }
}
