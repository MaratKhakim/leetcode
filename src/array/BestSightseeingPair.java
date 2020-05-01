package array;

/**
 * Date 01.05.2020.
 *
 * 1014. Best Sightseeing Pair
 *
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot,
 * and two sightseeing spots i and j have distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 * https://leetcode.com/problems/best-sightseeing-pair/
 */

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxSumOfValueAndIndex = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, maxSumOfValueAndIndex + A[i] - i);
            maxSumOfValueAndIndex = Math.max(maxSumOfValueAndIndex, A[i] + i);
        }

        return max;
    }
}
