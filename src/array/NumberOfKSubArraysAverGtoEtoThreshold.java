package array;

/**
 * Date 26.03.2020.
 *
 *  1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 *  Given an array of integers arr and two integers k and threshold.
 *
 * Return the number of sub-arrays of size k and average greater than or equal to threshold
 *
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */

public class NumberOfKSubArraysAverGtoEtoThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;

        int st = 0, end = 0;

        while(end < k)
            sum += arr[end++];

        if (sum/k >= threshold)
            res++;

        while(end < arr.length) {
            sum += arr[end++] - arr[st++];

            if (sum/k >= threshold)
                res++;
        }

        return res;
    }
}
