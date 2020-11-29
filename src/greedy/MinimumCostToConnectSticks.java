package greedy;

import java.util.PriorityQueue;

/**
 * Date 29.11.2020.
 *
 * 1167. Minimum Cost to Connect Sticks
 *
 * You have some number of sticks with positive integer lengths.
 * These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
 *
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y.
 * You must connect all the sticks until there is only one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int stick : sticks)
            heap.add(stick);

        int res = 0;

        while(heap.size() != 1) {
            int first = heap.poll();
            int sec = heap.poll();

            int sum = first+sec;
            res += sum;
            heap.add(sum);
        }

        return res;
    }
}
