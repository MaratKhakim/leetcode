package intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 21.04.2020.
 *
 * 436. Find Right Interval
 *
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to
 * the end point of the interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build
 * the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 *  -  You may assume the interval's end point is always bigger than its start point.
 *  -  You may assume none of these intervals have the same start point.
 *
 *  https://leetcode.com/problems/find-right-interval/
 */

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0];

        int[] res = new int[intervals.length];
        int idx = 0;

        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i], i);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals) {
            int index = map.get(interval);
            res[index] = binarySearch(intervals, interval[1], map);
        }

        return res;
    }

    private int binarySearch(int[][] intervals, int target, Map<int[], Integer> map) {
        int lo = 0, hi = intervals.length-1;

        while(lo < hi) {
            int mid = lo + (hi-lo)/2;

            if (intervals[mid][0] >= target) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        int[] interval = intervals[lo];

        return interval[0] >= target ? map.get(interval) : -1;
    }
}
