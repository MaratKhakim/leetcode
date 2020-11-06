package array;

/**
 * Date 06.11.2020.
 *
 * 1283. Find the Smallest Divisor Given a Threshold
 *
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division.
 * Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 *
 * It is guaranteed that there will be an answer.
 *
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */

public class FindTheSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;

        for (int num : nums)
            max = Math.max(max, num);

        int left = 1, right = max;

        while(left < right) {
            int mid = (left+right)/2;

            if (getSum(nums, mid) > threshold) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private int getSum(int[] nums, int div) {
        int sum = 0;

        for (int num : nums)
            sum += num/div + (num%div != 0 ? 1 : 0);

        return sum;
    }
}
