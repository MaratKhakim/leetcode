package intervals;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Date 29.03.2020.
 *
 *  1288. Remove Covered Intervals
 *
 *  Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *  Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 *
 * https://leetcode.com/problems/remove-covered-intervals/
 */

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int removed = 0;
        int len = intervals.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return a[0] - b[0];

                return b[1] - a[1];
            }
        });

        for (int[] interval : intervals)
            pq.add(interval);

        int[] firstInterval = pq.poll();
        int end = firstInterval[1];

        while (!pq.isEmpty()) {
            int[] interval = pq.poll();

            if (end >= interval[1]) {
                removed++;
            } else {
                end = interval[1];
            }
        }

        return len - removed;
    }
}
