package string;

/**
 * Date 14.04.2020.
 *
 * Day 14. 30-day-leetcoding-challenge
 *
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *  https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 */

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        int k = 0;
        int len = s.length();

        for (int[] nums : shift) {
            if (nums[0] == 0)
                k += nums[1];
            else
                k -= nums[1];
        }

        if (k%len == 0)
            return s;

        StringBuilder sb = new StringBuilder();

        if (k < 0) {
            k = -k;
            k = k%len;
            sb.append(s.substring(len-k, len));
            sb.append(s.substring(0, len-k));
        } else {
            k = k%len;
            sb.append(s.substring(k, len));
            sb.append(s.substring(0, k));
        }

        return sb.toString();
    }
}
