package dp;

/**
 * Date 28.04.2021.
 *
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * https://leetcode.com/problems/unique-paths-ii/
 */

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid[0][0] == 1)
            return 0;

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j];
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        return grid[m-1][n-1];
    }
}
