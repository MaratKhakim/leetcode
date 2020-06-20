package multiarray;

/**
 * Date 20.06.2020.
 *
 * 867. Transpose Matrix
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over
 * it's main diagonal, switching the row and column indices of the matrix.
 *
 * https://leetcode.com/problems/transpose-matrix/
 */

public class TransposeMatrix {
    public int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] transpose = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = mat[i][j];
            }
        }

        return transpose;
    }
}
