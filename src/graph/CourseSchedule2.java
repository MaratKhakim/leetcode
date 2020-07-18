package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 18.07.2020.
 *
 * 210. Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * https://leetcode.com/problems/course-schedule-ii/
 */

public class CourseSchedule2 {
    public int[] findOrder(int n, int[][] pres) {
        List<Integer>[] lists = new List[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++)
            lists[i] = new ArrayList<>();

        for (int[] pre : pres) {
            lists[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int[] res = new int[n];
        int idx = 0;
        int count = 0;

        while(!queue.isEmpty()) {
            count++;
            int curr = queue.poll();
            res[idx++] = curr;
            List<Integer> adj = lists[curr];

            for (int num : adj) {
                inDegree[num]--;

                if (inDegree[num] == 0)
                    queue.add(num);
            }
        }

        if (count != n)
            return new int[0];

        return res;
    }
}
