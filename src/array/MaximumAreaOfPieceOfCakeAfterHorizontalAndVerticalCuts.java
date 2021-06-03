package array;

import java.util.Arrays;

/**
 * Date 03.06.2021.
 *
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 *
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts
 * where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
 * verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 *
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position
 * provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */

public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int) (1e9+7);

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long x = maxInterval(h, horizontalCuts);
        long y = maxInterval(w, verticalCuts);

        return (int) (x%mod * y%mod);
    }

    // returns long to avoid Integer overflow
    private long maxInterval(int len, int[] arr) {
        int prev = 0;
        long max = 0;

        for (int num : arr) {
            max = Math.max(max, num-prev);
            prev = num;
        }

        return Math.max(max, len-prev);
    }
}
