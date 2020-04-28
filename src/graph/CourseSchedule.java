package graph;

import java.util.*;

/**
 * Date 28.04.2020.
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * https://leetcode.com/problems/course-schedule/
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int[] pre : prerequisites) {
            int parent = pre[1], child = pre[0];
            inDegrees[child]++;

            if (map.get(parent) == null)
                map.put(parent, new ArrayList<>());

            map.get(parent).add(child);
        }

        int taken = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                taken++;
            }
        }

        while(!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> children = map.get(parent);

            if (children == null)
                continue;

            for (int child : children) {
                inDegrees[child]--;
                if (inDegrees[child] == 0) {
                    queue.add(child);
                    taken++;
                }
            }
        }

        return numCourses == taken;
    }
}
