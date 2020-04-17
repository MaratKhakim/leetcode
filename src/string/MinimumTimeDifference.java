package string;

import java.util.Arrays;
import java.util.List;

/**
 * Date 17.04.2020.
 *
 * 539. Minimum Time Difference
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 *
 * https://leetcode.com/problems/minimum-time-difference/
 */

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] arr = new int[len];

        for (int i = 0; i < timePoints.size(); i++) {
            String st = timePoints.get(i);
            String[] times = st.split(":");
            int hour = Integer.valueOf(times[0]);

            arr[i] = 60 * hour + Integer.valueOf(times[1]);
        }

        Arrays.sort(arr);

        int res = arr[len-1];

        for (int i = 1; i < len; i++)
            res = Math.min(res, arr[i]-arr[i-1]);

        return Math.min(res, 24*60+arr[0] - arr[len-1]);
    }
}
