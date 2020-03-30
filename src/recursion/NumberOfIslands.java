package recursion;

/**
 * Date 30.03.2020.
 *
 *  200. Number of Islands
 *
 *  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
 *
 *  https://leetcode.com/problems/number-of-islands/
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}
