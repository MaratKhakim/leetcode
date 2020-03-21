package twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 21.03.2020.
 *
 *  986. Interval List Intersections
 *
 *  Given two lists of closed intervals,
 *  each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * https://leetcode.com/problems/interval-list-intersections/
 */

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int lenA = a.length;
        int lenB = b.length;

        if (lenA == 0 || lenB == 0)
            return new int[0][0];

        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;

        while(i < lenA && j < lenB) {
            int st = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            if (st <= end) {
                list.add(new int[]{st, end});
            }

            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[0][2]);
    }
}
