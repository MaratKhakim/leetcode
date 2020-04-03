package multiarray;

/**
 * Date 03.04.2020.
 *
 * 1020. Number of Enclaves
 *
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 *
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 *
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * https://leetcode.com/problems/number-of-enclaves/
 */

public class NumberOfEnclaves {
    public int numEnclaves(int[][] a) {
        int res = 0;
        int row = a.length;
        int col = a[0].length;

        for (int i = 0; i < row; i++)
            dfs(a, i, 0);

        for (int i = 0; i < row; i++)
            dfs(a, i, col-1);

        for (int i = 1; i < col-1; i++)
            dfs(a, 0, i);

        for (int i = 1; i < col-1; i++)
            dfs(a, row-1, i);

        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if (a[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] a, int row, int col) {
        if (row < 0 || row >= a.length || col < 0 || col >= a[row].length || a[row][col] == 0) {
            return;
        }

        a[row][col] = 0;

        dfs(a, row-1, col);
        dfs(a, row+1, col);
        dfs(a, row, col-1);
        dfs(a, row, col+1);
    }
}
