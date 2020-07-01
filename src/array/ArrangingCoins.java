package array;

/**
 * Date 01.07.2020.
 *
 * 441. Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * https://leetcode.com/problems/arranging-coins/
 */

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int k = 0;

        while(n > k) {
            k++;
            n -= k;
        }

        return k;
    }
}
