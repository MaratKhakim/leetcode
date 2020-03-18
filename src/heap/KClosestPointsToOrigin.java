package heap;

import java.util.PriorityQueue;

/**
 * Date 18.03.2020.
 *
 *  973. K Closest Points to Origin
 *
 *  We have a list of points on the plane.
 *  Find the K closest points to the origin (0, 0).
 *
 *  https://leetcode.com/problems/k-closest-points-to-origin/
 */

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]));

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;

        while(!pq.isEmpty()) {
            res[idx++] = pq.poll();
        }

        return res;
    }
}
