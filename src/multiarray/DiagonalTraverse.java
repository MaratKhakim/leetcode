package multiarray;

/**
 * Date 07.04.2020.
 *
 * 498. Diagonal Traverse
 *
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 *
 * https://leetcode.com/problems/diagonal-traverse/
 */

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m*n];
        int idx = 0;

        for (int i = 0; i <= m+n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i%2 == 0) {
                    if (i-j < m && j < n)
                        res[idx++] = matrix[i-j][j];
                } else {
                    if (j < m && i-j < n)
                        res[idx++] = matrix[j][i-j];
                }
            }
        }

        return res;
    }
}
