package multiarray;

/**
 * Date 05.07.2021.
 *
 * 566. Reshape the Matrix
 *
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * https://leetcode.com/problems/reshape-the-matrix/
 */

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m*n != r*c)
            return mat;

        int[][] res = new int[r][c];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col == c) {
                    col = 0;
                    row++;
                }

                res[row][col++] = mat[i][j];
            }
        }

        return res;
    }
}
