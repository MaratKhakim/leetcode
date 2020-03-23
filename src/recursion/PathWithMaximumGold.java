package recursion;

/**
 * Date 23.03.2020.
 *
 *  1219. Path with Maximum Gold
 *
 *  In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 *  Return the maximum amount of gold you can collect under the conditions:
 *
 *  - Every time you are located in a cell you will collect all the gold in that cell.
 *  - From your position you can walk one step to the left, right, up or down.
 *  - You can't visit the same cell more than once.
 *  - Never visit a cell with 0 gold.
 *  - You can start and stop collecting gold from any position in the grid that has some gold.
 *
 * https://leetcode.com/problems/path-with-maximum-gold/
 */

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, dfs(grid, i, j, 0));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int row, int col, int total) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return total;

        int temp = grid[row][col];
        grid[row][col] = 0;

        int sum1 = dfs(grid, row+1, col, temp + total);
        int sum2 = dfs(grid, row-1, col, temp + total);
        int sum3 = dfs(grid, row, col+1, temp + total);
        int sum4 = dfs(grid, row, col-1, temp + total);

        grid[row][col] = temp;

        return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
    }
}
