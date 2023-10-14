package org.girardsimon.problem6;

public final class ZigZagConverter {
    private ZigZagConverter() {
    }
    /**
     * <p>
     * Converts a given input string into a zigzag pattern based on the number of rows.
     * The zigzag pattern starts from the top row, goes down to the bottom row,
     * then goes back up to the top row, and so on.
     * </p>
     * <p>
     * Constraints:<br>
     *  • 0 ≤ input.length ≤ 1000<br>
     *  • input consists of English letters (lower-case and upper-case), ',' and '.'.<br>
     *  • 1 ≤ numRows ≤ 1000<br>
     *
     * @param input the input string to be converted
     * @param numRows the number of rows in the zigzag pattern
     * @return the converted string in zigzag pattern
     */
    public static String convert(String input, int numRows) {
        if(numRows == 1 || numRows > input.length()) {
            return input;
        } else  {
            StringBuilder sb = new StringBuilder();
            int cycleLength = 2 * numRows -2;
            for(int i = 0; i < numRows; i++) {
                for(int j = 0; j+i < input.length(); j += cycleLength) {
                    generateLineOfZigZagPattern(input, numRows, sb, i, j, cycleLength);
                }
            }
            return sb.toString();
        }
    }
    private static void generateLineOfZigZagPattern(String input, int numberOfRows,
                                                    StringBuilder sb, int rowIndex, int columnIndex,
                                                    int cycleLength) {
        sb.append(input.charAt(rowIndex + columnIndex));
        //In a zigzag, except for top or bottom row, a line can have letter from different part of the cycle.
        if(isNotTopOrBottomRow(rowIndex, numberOfRows) && columnIndex - rowIndex + cycleLength < input.length()) {
            sb.append(input.charAt(columnIndex - rowIndex + cycleLength));
        }
    }
    private static boolean isNotTopOrBottomRow(int rowIndex, int numberOfRows) {
        return rowIndex != 0 && rowIndex != numberOfRows - 1;
    }
}
