package org.girardsimon.problem4;

public final class MedianTwoSortedArrayResolver {
    private MedianTwoSortedArrayResolver() {
    }
    /**
     * This method takes two sorted arrays as input and finds the median of the merged array.
     * <p>
     * Constraints:<br>
     * • Each array has a limited size of 1000<br>
     * • -10⁶ ≤ numsLeft[i], numsRight[i] ≤ 10⁶<br>
     *
     * @param numsLeft the first sorted array
     * @param numsRight the second sorted array
     * @return the median of the merged array
     */
    public static double findMedianSortedArrays(int[] numsLeft, int[] numsRight) {
        int m = numsLeft.length;
        int n = numsRight.length;
        int mergedArrayLength = m+n;
        int[] mergedArray = new int[mergedArrayLength];

        int i = 0;
        int j = 0;

        while(i+j < mergedArrayLength) {
            if(i < m && j < n) {
                if(numsLeft[i] < numsRight[j]) {
                    mergedArray[i+j] = numsLeft[i];
                    i++;
                } else {
                    mergedArray[i+j] = numsRight[j];
                    j++;
                }
            } else if(i < m) {
                mergedArray[i+j] = numsLeft[i];
                i++;
            } else {
                mergedArray[i+j] = numsRight[j];
                j++;
            }
        }

        if(mergedArrayLength % 2 == 0) {
            return (mergedArray[mergedArrayLength/2] + mergedArray[mergedArrayLength/2-1])/2.0;
        } else {
            return mergedArray[mergedArrayLength/2];
        }
    }
}
