package intervals;

import java.util.Arrays;

/**
 * Date 19.07.2021.
 *
 * 252. Meeting Rooms
 *
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 *
 * https://leetcode.com/problems/meeting-rooms/
 */

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = -1;

        for (int[] interval : intervals) {
            if (interval[0] < end)
                return false;

            end = Math.max(end, interval[1]);
        }

        return true;
    }
}
