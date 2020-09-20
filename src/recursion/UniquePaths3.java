package recursion;

/**
 * Date 20.09.2020.
 *
 * 980. Unique Paths III
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 *  - 1 represents the starting square.  There is exactly one starting square.
 *  - 2 represents the ending square.  There is exactly one ending square.
 *  - 0 represents empty squares we can walk over.
 *  - -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * https://leetcode.com/problems/unique-paths-iii/
 */

public class UniquePaths3 {
    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0, empty = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }

        return dfs(grid, sx, sy, 0, empty);
    }

    private int dfs(int[][] grid, int i, int j, int count, int empty) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1)
            return 0;

        if (grid[i][j] == 2) {
            if (count == empty)
                return 1;
            return 0;
        }

        count = grid[i][j] == 0 ? count+1 : count;
        int temp = grid[i][j];
        grid[i][j] = -1;

        int res = dfs(grid, i+1, j, count, empty);
        res += dfs(grid, i-1, j, count, empty);
        res += dfs(grid, i, j+1, count, empty);
        res += dfs(grid, i, j-1, count, empty);

        grid[i][j] = temp;

        return res;
    }
}
