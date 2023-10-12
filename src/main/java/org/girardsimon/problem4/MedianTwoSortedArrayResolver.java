package org.girardsimon.problem4;

public final class MedianTwoSortedArrayResolver {
    private MedianTwoSortedArrayResolver() {
    }
    /*
        numsLeft and numsRight are both sorted arrays
        numsLeft.length == m
        numsRight.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -10^6 <= numsLeft[i], numsRight[i] <= 10^6
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
