package multiarray;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 06.04.2020.
 *
 * 1267. Count Servers that Communicate
 *
 * You are given a map of a server center, represented as a m * n integer matrix grid,
 * where 1 means that on that cell there is a server and 0 means that it is no server.
 * Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 *
 * https://leetcode.com/problems/count-servers-that-communicate/
 */

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.put(i, row.getOrDefault(i, 0)+1);
                    col.put(j, col.getOrDefault(j, 0)+1);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int x = row.getOrDefault(i, 0);
                    int y = col.getOrDefault(j, 0);

                    res += (x > 1 || y > 1) ? 1 : 0;
                }
            }
        }

        return res;
    }
}
