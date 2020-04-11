package multiarray;

/**
 * Date 11.04.2020.
 *
 * 289. Game of Life
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
 * four rules (taken from the above Wikipedia article):
 *
 *  1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *  2. Any live cell with two or three live neighbors lives on to the next generation.
 *  3. Any live cell with more than three live neighbors dies, as if by over-population..
 *  4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * https://leetcode.com/problems/game-of-life/
 */

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++)
            copy[i] = board[i].clone();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = copy[i][j];
                int val = getNeighboursState(copy, i, j, false);

                if (curr == 1) {
                    if (val < 2 || val > 3)
                        board[i][j] = 0;
                } else {
                    if (val == 3)
                        board[i][j] = 1;
                }
            }
        }
    }

    private int getNeighboursState(int[][] board, int i, int j, boolean flag) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return 0;

        if (flag)
            return board[i][j];

        int val = getNeighboursState(board, i-1, j-1, true);
        val += getNeighboursState(board, i+1, j+1, true);
        val += getNeighboursState(board, i-1, j+1, true);
        val += getNeighboursState(board, i+1, j-1, true);
        val += getNeighboursState(board, i, j-1, true);
        val += getNeighboursState(board, i, j+1, true);
        val += getNeighboursState(board, i-1, j, true);
        val += getNeighboursState(board, i+1, j, true);

        return val;
    }
}
