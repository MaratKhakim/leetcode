package multiarray;

/**
 * Date 17.06.2020.
 *
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * https://leetcode.com/problems/surrounded-regions/
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int m, int n) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] == 'X' || board[m][n] == '*')
            return;

        board[m][n] = '*';
        dfs(board, m+1, n);
        dfs(board, m-1, n);
        dfs(board, m, n+1);
        dfs(board, m, n-1);
    }
}
