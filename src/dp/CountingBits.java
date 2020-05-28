package dp;

/**
 * Date 28.05.2020.
 *
 * 338. Counting Bits
 *
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 * https://leetcode.com/problems/counting-bits/
 */

public class CountingBits {
    public int[] countBits(int num) {
        int[] count = new int[num+1];

        for (int i = 0; i <= num; i++) {
            if (i%2 == 0) {
                count[i] = count[i/2];
            } else {
                count[i] = count[i-1]+1;
            }
        }

        return count;
    }
}
