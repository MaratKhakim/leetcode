package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Date 19.06.2021.
 *
 * 1086. High Five
 *
 * Given a list of the scores of different students, items,
 * where items[i] = [IDi, scorei] represents one score from a student with IDi,
 * calculate each student's top five average.
 *
 * Return the answer as an array of pairs result, where result[j] = [IDj,
 * topFiveAveragej] represents the student with IDj and their top five average.
 * Sort result by IDj in increasing order.
 *
 * A student's top five average is calculated by taking the sum of their top five scores
 * and dividing it by 5 using integer division.
 *
 * https://leetcode.com/problems/high-five/
 */

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = getMap(items);
        int[][] res = new int[map.size()][2];
        int idx = 0;

        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            while(!pq.isEmpty())
                sum += pq.poll();

            res[idx++] = new int[]{id, sum/5};
        }

        Arrays.sort(res, (a, b) -> a[0] - b[0]);

        return res;
    }

    private  Map<Integer, PriorityQueue<Integer>> getMap(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            PriorityQueue<Integer> pq = map.getOrDefault(item[0], new PriorityQueue<>());
            pq.add(item[1]);

            if (pq.size() > 5)
                pq.poll();

            map.put(item[0], pq);
        }

        return map;
    }
}
