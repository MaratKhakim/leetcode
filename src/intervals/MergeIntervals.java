package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 04.04.2020.
 *
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * https://leetcode.com/problems/merge-intervals/
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int st = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (end >= interval[0]) {
                st = Math.min(interval[0], st);
                end = Math.max(interval[1], end);
            } else {
                list.add(new int[]{st, end});
                st = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[]{st, end});

        return list.toArray(new int[list.size()][]);
    }
}
