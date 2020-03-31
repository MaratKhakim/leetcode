package intervals;

import java.util.Arrays;

/**
 * Date 31.03.2020.
 *
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;

        Arrays.sort(points, (a, b) -> a[1]-b[1]);

        int end = points[0][1];
        int res = 1;

        for (int[] point : points) {
            if (point[0] > end) {
                res++;
                end = point[1];
            }
        }

        return res;
    }
}
