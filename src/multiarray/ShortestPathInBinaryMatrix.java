package multiarray;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 14.06.2020.
 *
 * 1091. Shortest Path in Binary Matrix
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *  - Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 *  - C_1 is at location (0, 0) (ie. has value grid[0][0])
 *  - C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 *  - If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.
 * If such a path does not exist, return -1.
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;

        if (grid[0][0] == 1 || grid[len-1][len-1] == 1)
            return -1;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int res = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == len-1 && curr[1] == len-1)
                    return res;

                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if (row < 0 || row >= len || col < 0 || col >= len || grid[row][col] == 1)
                        continue;

                    queue.add(new int[]{row, col});
                    grid[row][col] = 1;
                }
            }
            res++;
        }

        return -1;
    }
}
